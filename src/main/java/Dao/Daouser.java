package Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import Services.EncryptUtil;
import model.KhachHang;
import model.Staff;
import utils.Connectjpa;

public class Daouser extends BaseDao<KhachHang> {
	private KhachHang user;
	private Connectjpa conn;
	private EntityManager manager;
	private EntityTransaction transaction;
	private List<KhachHang> lst;

	public Daouser() {
		this.user = new KhachHang();
		this.conn = new Connectjpa();
		this.lst = new ArrayList<KhachHang>();
	}

	@Override
	public Class<KhachHang> getmodeclass() {
		return KhachHang.class;
	}

	public List<KhachHang> findbyidkh(int id) {
		String hql = "SELECT k FROM KhachHang k WHERE idkh=:ky_hoc";
		this.manager = this.conn.getEntityManager();
		TypedQuery<KhachHang> query = this.manager.createQuery(hql, KhachHang.class);
		query.setParameter("ky_hoc", id);
		this.lst = query.getResultList();
		return this.lst;
	}

	public void changepassworduser(int id, String newpass) {
		this.manager = this.conn.getEntityManager();
		this.transaction = manager.getTransaction();
		try {
			this.manager.getTransaction().begin();
			manager.flush();
			manager.clear();
			String hql = "UPDATE KhachHang k SET password=:new_pass WHERE idkh=:id_kh";
			Query query = this.manager.createQuery(hql);
			String hashed = EncryptUtil.hashPassword(newpass);
			query.setParameter("new_pass", hashed);
			query.setParameter("id_kh", id);
			query.executeUpdate();
			this.transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateprofileuser(KhachHang k) {
		this.manager = this.conn.getEntityManager();
		this.transaction = manager.getTransaction();
		try {
			this.manager.getTransaction().begin();
			manager.flush();
			manager.clear();
			String hql = "UPDATE KhachHang k SET hoTen=:ho_ten , gmail=:mail , sdt=:so_dt WHERE idkh=:id_kh";
			Query query = this.manager.createQuery(hql);
			query.setParameter("ho_ten", k.getHoTen());
			query.setParameter("mail", k.getGmail());
			query.setParameter("so_dt", k.getSdt());
			query.setParameter("id_kh", k.getIdkh());
			query.executeUpdate();
			this.transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public KhachHang login(String username, String password) {
		try {
			this.manager = this.conn.getEntityManager();
			String sql = "SELECT k FROM KhachHang k WHERE username = :userName";
			TypedQuery<KhachHang> query = manager.createQuery(sql, KhachHang.class);
			query.setParameter("userName", username);
			this.lst = query.getResultList();
			for (KhachHang user : this.lst) {

				if (EncryptUtil.checkPass(password, user.getPassword())) {
					return user;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return null;
	}

	public KhachHang login_Google(String username, String password) {
		try {
			this.manager = this.conn.getEntityManager();
			String sql = "SELECT k FROM KhachHang k WHERE username = :userName AND password=:ps";
			TypedQuery<KhachHang> query = manager.createQuery(sql, KhachHang.class);
			query.setParameter("userName", username);
			query.setParameter("ps", password);
			this.user = query.getResultList().get(0);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return this.user;
	}

//quên mật khẩu
	public List<KhachHang> findEmail(String username, String gmail) {
		KhachHang kh = new KhachHang();
		try {
			manager = conn.getEntityManager();
			String sql = "select u from KhachHang u where u.username=:user_name and u.gmail=:mail";
			TypedQuery<KhachHang> query = manager.createQuery(sql, KhachHang.class);
			query.setParameter("user_name", username);
			query.setParameter("mail", gmail);
			lst = query.getResultList();
			for (KhachHang list : lst) {
				if (username.equals(list.getUsername()) && gmail.equals(list.getGmail())) {
					return lst;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public KhachHang checkAcc(String username) {
		this.manager = this.conn.getEntityManager();
		KhachHang khach = new KhachHang();
		try {
			String hql = "SELECT k FROM KhachHang k WHERE username = :user_name";
			TypedQuery<KhachHang> query = this.manager.createQuery(hql, KhachHang.class);
			query.setParameter("user_name", username);
			khach = query.getSingleResult();
		} catch (NoResultException e) {
			e.printStackTrace();
			return null;
		}
		return khach;
	}

	public KhachHang checkSdt(String sdt) {
		this.manager = this.conn.getEntityManager();
		KhachHang khach = new KhachHang();
		try {
			String hql = "SELECT A FROM KhachHang A WHERE sdt = :sdt";
			TypedQuery<KhachHang> query = this.manager.createQuery(hql, KhachHang.class);
			query.setParameter("sdt", sdt);
			khach = query.getSingleResult();
		} catch (NoResultException e) {
			e.printStackTrace();
			return null;
		}
		return khach;
	}

	public void updatettdb(int id, String name, String sdt) {
		this.manager = this.conn.getEntityManager();
		this.transaction = this.manager.getTransaction();
		try {
			this.manager.getTransaction().begin();
			manager.flush();
			manager.clear();
			String hql = "Update KhachHang k SET ho_ten=:ten, sdt=:sodt WHERE idkh=:id";
			Query query = this.manager.createQuery(hql);
			query.setParameter("ten", name);
			query.setParameter("sodt", sdt);
			query.setParameter("id", id);
			query.executeUpdate();
			this.transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.transaction.rollback();
		}
	}

	public KhachHang updateKH(KhachHang kh) {
		this.manager = this.conn.getEntityManager();
		this.transaction = this.manager.getTransaction();
		try {
			this.transaction.begin();
			String hql = "Update KhachHang k SET username=:username, password=:password, gmail=:gmail WHERE sdt=:sdt";
			Query query = this.manager.createQuery(hql);
			query.setParameter("username", kh.getUsername());
			query.setParameter("password", kh.getPassword());
			query.setParameter("gmail", kh.getGmail());
			query.setParameter("sdt", kh.getSdt());
			query.executeUpdate();
			this.transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.transaction.rollback();
		}
		return kh;
	}

	// kiểm tra số tài khoản đã tồn tại không (class liên
	// quan:Notification)
	public KhachHang showuserbyphone(String phone) {
		this.manager = this.conn.getEntityManager();
		KhachHang khach = new KhachHang();
		try {
			String hql = "SELECT A FROM KhachHang A WHERE sdt = :phone_number";
			TypedQuery<KhachHang> query = this.manager.createQuery(hql, KhachHang.class);
			query.setParameter("phone_number", phone);
			khach = query.getSingleResult();
		} catch (NoResultException e) {
			e.printStackTrace();
			return null;
		}
		return khach;
	}

	public List<KhachHang> findMemberByAjax(String name) {
		this.manager = this.conn.getEntityManager();
		String hql = "SELECT k FROM KhachHang k WHERE hoTen LIKE :key";
		TypedQuery<KhachHang> query = this.manager.createQuery(hql, KhachHang.class);
		query.setParameter("key", "%" + name + "%");
		List<KhachHang> list = query.getResultList();
		return list;
	}

	// kiểm tra trong db có khách hàng nào có sdt như input ko
	public KhachHang finduserbyphone(String phone) {
		try {
			this.manager = this.conn.getEntityManager();
			String hql = "SELECT k FROM KhachHang k WHERE sdt=:phone_number";
			TypedQuery<KhachHang> query = this.manager.createQuery(hql, KhachHang.class);
			query.setParameter("phone_number", phone);
			return this.user = query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	// kiểm tra ngoài tài khoản nhập vào còn có tài khoản nào khác
	// đang sử dụng sdt đấy ko.
	public List<KhachHang> finduserbysdt(KhachHang k, String phone) {
		try {
			this.manager = this.conn.getEntityManager();
			String hql = "SELECT k FROM KhachHang k WHERE k.sdt=:number_phone and k.idkh !=:user";
			TypedQuery<KhachHang> query = this.manager.createQuery(hql, KhachHang.class);
			query.setParameter("number_phone", phone);
			query.setParameter("user", k.getIdkh());
			return this.lst = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String getdatabase() {
		return KhachHang.class.getSimpleName();
	}

	public void changepass(int id, String pw) {
		this.manager = this.conn.getEntityManager();

	}

}
