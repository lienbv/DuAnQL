package Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.KhachHang;
import model.Staff;
import utils.Connectjpa;

public class NhanVienDao extends BaseDao<Staff>{

	private EntityManager em;
	private Connectjpa conn;
	public NhanVienDao() {
		this.conn=new Connectjpa();
	}
	@Override
	public Class<Staff> getmodeclass() {
		// TODO Auto-generated method stub
		return Staff.class;
	}

	@Override
	public String getdatabase() {
		// TODO Auto-generated method stub
		return Staff.class.getSimpleName();
	}
	
	public List<Staff> findStaffByAjax(String name){
		this.em = this.conn.getEntityManager();
		String hql = "SELECT s FROM Staff s WHERE hoTen LIKE :key";
		TypedQuery<Staff> query=this.em.createQuery(hql,Staff.class);
		query.setParameter("key", "%" + name + "%");
		List<Staff> list = query.getResultList();
		return list;
	}
	

}
