package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import Services.EncryptUtil;
import model.KhachHang;
import model.Staff;
import utils.Connectjpa;

public class Dao_Staff extends BaseDao<Staff> {
	private Connectjpa conn;
	private EntityManager manager;
	private EntityTransaction transaction;
	private Staff st;
	private List<Staff> listStaff;

	public Dao_Staff() {
		this.conn = new Connectjpa();
		this.st = new Staff();

	}

	@Override
	public Class<Staff> getmodeclass() {
		return Staff.class;
	}

	@Override
	public String getdatabase() {
		return Staff.class.getSimpleName();
	}

	public Staff login(String username, String password) {
		try {
			this.manager = this.conn.getEntityManager();
			String sql = "SELECT s FROM Staff s WHERE username = :userName AND password =:ps ";
//			String sql = "SELECT s FROM Staff s WHERE username = :userName ";
			TypedQuery<Staff> query = manager.createQuery(sql, Staff.class);
			query.setParameter("userName", username);
			query.setParameter("ps", password);
			this.st = query.getResultList().get(0);
//			for (Staff st : this.listStaff) {
//				if (EncryptUtil.checkPass(password, st.getPassword())) {
//					return st;
//				}
//			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}
		return st;
	}

	public void changepassstaff(int id, String xacnhan_pass) {
		this.manager = this.conn.getEntityManager();
		this.transaction = this.manager.getTransaction();
		try {
			this.transaction.begin();
			String hql = "Update Staff s SET password=:xacnhan_pass WHERE idnv=:id";
			Query query = this.manager.createQuery(hql);
			query.setParameter("xacnhan_pass", xacnhan_pass);
			query.setParameter("id", id);
			query.executeUpdate();
			this.transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateprofilestaff(Staff staff) {
		this.manager = this.conn.getEntityManager();
		this.transaction = this.manager.getTransaction();
		try {
			this.transaction.begin();
			String hql = "Update Staff s SET img=:img , hoTen=:name , sdt=:phone , email=:email WHERE idnv=:id_nv";
			Query query = this.manager.createQuery(hql);
			query.setParameter("img", staff.getImg());
			query.setParameter("name", staff.getHoTen());
			query.setParameter("phone", staff.getSdt());
			query.setParameter("email", staff.getEmail());
			query.setParameter("id_nv", staff.getIdnv());
			query.executeUpdate();
			this.transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
