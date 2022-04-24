package Dao;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Bdct;
import model.KhachHang;
import model.ThongTinBanDat;
import utils.Connectjpa;

public class DaoTTBD extends BaseDao<ThongTinBanDat> {
	private ThongTinBanDat ttbd;
	private List<ThongTinBanDat> lstttbd;
	private Connectjpa conn;
	private EntityManager manager;
	private EntityTransaction transaction;

	public DaoTTBD() {
		this.ttbd = new ThongTinBanDat();
		this.lstttbd = new ArrayList<ThongTinBanDat>();
		this.conn = new Connectjpa();
	}

	@Override
	public Class<ThongTinBanDat> getmodeclass() {
		return ThongTinBanDat.class;
	}

	@Override
	public String getdatabase() {
		return ThongTinBanDat.class.getSimpleName();
	}

	public List<ThongTinBanDat> findTTBDbyIDkh(KhachHang kh) {
		String hql = "Select t From ThongTinBanDat t Where khachHang=:id_kh ORDER BY idBd desc";
		this.manager = this.conn.getEntityManager();
		TypedQuery<ThongTinBanDat> query = this.manager.createQuery(hql, ThongTinBanDat.class);
		query.setParameter("id_kh", kh);
		this.lstttbd = query.getResultList();
		return this.lstttbd;
	}

	public ThongTinBanDat findttbdbystatus(KhachHang kh) {
		try {
			String hql = "Select t From ThongTinBanDat t Where trang_Thai=:status or trang_Thai=:tt and khachHang.idkh=:id_kh";
			this.manager = this.conn.getEntityManager();
			TypedQuery<ThongTinBanDat> query = this.manager.createQuery(hql, ThongTinBanDat.class);
			query.setParameter("id_kh", kh.getIdkh());
			query.setParameter("status", "Waitting line");
			query.setParameter("tt", "Confirmed");
			this.ttbd = query.getSingleResult();
			return this.ttbd;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public void Updatelichdat(Date ngay, Time giodat, String note, int so_luong, int id) {
		this.manager = this.conn.getEntityManager();
		this.transaction = this.manager.getTransaction();
		try {

			this.manager.getTransaction().begin();
			manager.flush();
			manager.clear();
			String hql = "Update ThongTinBanDat t SET ngayDatBan=:ngay, gioDatBan=:gio, so_Luong_Nguoi=:soluong, ghi_Chu=:note WHERE idBd=:index";

			Query query = this.manager.createQuery(hql);
			query.setParameter("ngay", ngay);
			query.setParameter("gio", giodat);
			query.setParameter("note", note);
			query.setParameter("soluong", so_luong);
			query.setParameter("index", id);
			query.executeUpdate();
			this.transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.transaction.rollback();
		}
	}

	public List<ThongTinBanDat> thongKe(int nam) {
		this.manager = this.conn.getEntityManager();
		String hql = "SELECT t FROM ThongTinBanDat t WHERE YEAR(t.ngayDatBan) =:nam";
		Query query = this.manager.createQuery(hql);
		query.setParameter("nam", nam);
		return this.lstttbd = query.getResultList();
	}

	// hiển thị thông tin bàn đặt với trạng thái là waitting line (class liên
	// quan:Notification)
	public List<ThongTinBanDat> showttbdbywl() {
		try {
			String hql = "Select t From ThongTinBanDat t Where t.trang_Thai=:status";
			this.manager = this.conn.getEntityManager();
			TypedQuery<ThongTinBanDat> query = this.manager.createQuery(hql, ThongTinBanDat.class);
			query.setParameter("status", "Waitting line");
			this.lstttbd = query.getResultList();
			return this.lstttbd;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// hiển thị thông tin bàn đặt với trạng thái là Confirmed (class liên
	// quan:Notification)
	public List<ThongTinBanDat> showttbdbycf() {
		try {
			String hql = "Select t From ThongTinBanDat t Where t.trang_Thai=:status or t.trang_Thai=:tt";
			this.manager = this.conn.getEntityManager();
			TypedQuery<ThongTinBanDat> query = this.manager.createQuery(hql, ThongTinBanDat.class);
			query.setParameter("status", "Confirmed");
			query.setParameter("tt", "Active");
			this.lstttbd = query.getResultList();
			return this.lstttbd;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// hiển thị thông tin bàn đặt với trạng thái là Cancelled (class liên
	// quan:Notification)
	public List<ThongTinBanDat> showttbdbycancel() {
		try {
			String hql = "Select t From ThongTinBanDat t Where t.trang_Thai=:status";
			this.manager = this.conn.getEntityManager();
			TypedQuery<ThongTinBanDat> query = this.manager.createQuery(hql, ThongTinBanDat.class);
			query.setParameter("status", "Cancelled");
			this.lstttbd = query.getResultList();
			return this.lstttbd;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void deletebd(int id) {
		this.manager = this.conn.getEntityManager();
		this.transaction = this.manager.getTransaction();
		try {
			this.manager.getTransaction().begin();
			manager.flush();
			manager.clear();
			String hql = "Update ThongTinBanDat t WHERE idBd=:id";
			Query query = this.manager.createQuery(hql);
			query.setParameter("id", id);
			query.executeUpdate();
			this.transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.transaction.rollback();
		}
	}

	// tìm kiếm bản ghi mới nhất theo khách hàng(class liên quan: Notification)
	public ThongTinBanDat findttbdbyuserdesc(KhachHang k) {
		try {
			String hql = "Select t From ThongTinBanDat t WHERE t.khachHang=:khach_hang ORDER BY idBd DESC";
			this.manager = this.conn.getEntityManager();
			TypedQuery<ThongTinBanDat> query = this.manager.createQuery(hql, ThongTinBanDat.class);
			query.setParameter("khach_hang", k);
			this.ttbd = query.getResultList().get(0);
			return this.ttbd;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// tim theo ngay <class: SearchngayQLTTinStaff>
	public List<ThongTinBanDat> finDate(Date date) {
		try {
			String hql = "Select t from ThongTinBanDat t where t.ngayDatBan =:ngay and t.trang_Thai=:tt or t.trang_Thai=:status";
			this.manager = this.conn.getEntityManager();
			TypedQuery<ThongTinBanDat> query = this.manager.createQuery(hql, ThongTinBanDat.class);
			query.setParameter("ngay", date);
			query.setParameter("tt", "Active");
			query.setParameter("status", "Confirmed");
			this.lstttbd = query.getResultList();
			return this.lstttbd;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//hiển thị thông tin bàn đã xác nhận và đang hoạt động
	public List<ThongTinBanDat> showttbdbyqlttb(){
		try {
			String hql="Select t From ThongTinBanDat t Where t.trang_Thai=:status or t.trang_Thai=:tt";
			this.manager=this.conn.getEntityManager();
			TypedQuery<ThongTinBanDat> query=this.manager.createQuery(hql, ThongTinBanDat.class);
			query.setParameter("status", "Confirmed");
			query.setParameter("tt", "Active");
			this.lstttbd=query.getResultList();
			return this.lstttbd;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//tự hủy bàn khi qua ngày đặt bàn
	public void checkdate(){
		this.manager = this.conn.getEntityManager();
		this.transaction = this.manager.getTransaction();
		try {

			this.manager.getTransaction().begin();
			manager.flush();
			manager.clear();
			String hql = "Update ThongTinBanDat t SET trang_Thai=:status WHERE datediff(day,ngayDatBan,CONVERT(VARCHAR(10),GETDATE(),101)) <= 0 "
					+ "AND datediff(minute,gioDatBan,CONVERT(VARCHAR(10),GETDATE(),108))<0 AND datediff(hour,gioDatBan,CONVERT(VARCHAR(10),GETDATE(),108))<0 AND trang_Thai=:tt or trang_Thai=:t_t";
			Query query = this.manager.createQuery(hql);
			query.setParameter("status", "Cancelled");
			query.setParameter("t_t", "Confirmed");
			query.setParameter("tt", "Waitting line");
			query.executeUpdate();
			this.transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.transaction.rollback();
		}
	}
	
	public int count() {
		try {
			this.manager = this.conn.getEntityManager();
			String qery = "select count(u) from ThongTinBanDat u Where trang_Thai=:t";
			Query sql = manager.createQuery(qery);
			sql.setParameter("t", "Waitting line");
			return ((Long) sql.getSingleResult()).intValue();
		} catch (Exception e) {
			return 0;
		}
		
	}
	
	public int counttthd() {
		try {
			this.manager = this.conn.getEntityManager();
			String qery = "select count(u) from ThongTinBanDat u Where u.trang_Thai=:t or u.trang_Thai=:tthd";
			Query sql = manager.createQuery(qery);
			sql.setParameter("t", "Confirmed");
			sql.setParameter("tthd", "Active");
			return ((Long) sql.getSingleResult()).intValue();
		} catch (Exception e) {
			return 0;
		}
		
	}
	
	public List<ThongTinBanDat> findttbdbystatus() {
		List<ThongTinBanDat> list = new ArrayList<ThongTinBanDat>();
		try {
			String hql = "Select t From ThongTinBanDat t Where trang_Thai=:status or trang_Thai=:tt";
			this.manager = this.conn.getEntityManager();
			TypedQuery<ThongTinBanDat> query = this.manager.createQuery(hql, ThongTinBanDat.class);
			query.setParameter("status", "Waitting line");
			query.setParameter("tt", "Confirmed");
			list = query.getResultList();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
}
