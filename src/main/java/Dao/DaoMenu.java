package Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.Bdct;
import model.LoaiMenu;
import model.Menu;
import model.ThongTinBanDat;
import utils.Connectjpa;

public class DaoMenu extends BaseDao<Menu>{
	
	private LoaiMenu loaimenu;
	private Connectjpa conn;
	private EntityManager manager;
	private EntityTransaction transaction;
	private List<Menu> lstmenu;
	public DaoMenu() {
		loaimenu=new LoaiMenu();
		conn= new Connectjpa();
	}
	
	@Override
	public Class<Menu> getmodeclass() {
		return Menu.class;
	}

	@Override
	public String getdatabase() {
		return Menu.class.getSimpleName();
	}
	
	//tÃ¬m kiáº¿m tÃªn mÃ³n 
	public List<Menu> findName(String name){
		try {
			this.manager=this.conn.getEntityManager();
			String hql="SELECT h FROM Menu h WHERE h.ten_Mon_An like :ten";
			TypedQuery<Menu> query=manager.createQuery(hql,Menu.class);
			query.setParameter("ten", "%" + name + "%");
			this.lstmenu=query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return lstmenu;
		
	}

	public List<Menu> findTTBD(LoaiMenu loai){
		try {
			this.manager=this.conn.getEntityManager();
			String hql="SELECT h FROM Menu h WHERE loaiMenu =:id";
			TypedQuery<Menu> query=manager.createQuery(hql,Menu.class);
			query.setParameter("id", loai);
			this.lstmenu=query.getResultList();
					
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return this.lstmenu;
	}
	public List<Menu> trangthai(int trangthai1 ,int trangthai2){
		try {
			this.manager=this.conn.getEntityManager();
			String hql="SELECT h FROM Menu h WHERE h.trang_thai =:trangthai or h.trang_thai =:tt2";
			TypedQuery<Menu> query=manager.createQuery(hql,Menu.class);
			query.setParameter("trangthai", trangthai1);
			query.setParameter("tt2", trangthai2);
			this.lstmenu=query.getResultList();
			return this.lstmenu;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	
	}
	//<hien thi menu theo trang thai class: Addmenucontroller>
	public List<Menu> trangthaistaff(int trangthai1){
		try {
			this.manager=this.conn.getEntityManager();
			String hql="SELECT h FROM Menu h WHERE h.trang_Thai =:trangthai ";
			TypedQuery<Menu> query=manager.createQuery(hql,Menu.class);
			query.setParameter("trangthai", trangthai1);
			this.lstmenu=query.getResultList();
			return this.lstmenu;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	
	}
	//x�a menu
	 public void deleteMenu(Menu t){
		 this.manager=this.conn.getEntityManager();
			this.transaction=this.manager.getTransaction();
		try {
			transaction.begin();
			manager.remove(t);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
	}
	 
	 

}
