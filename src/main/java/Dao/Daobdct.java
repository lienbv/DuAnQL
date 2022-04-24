package Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Bdct;
import model.ThongTinBanDat;
import utils.Connectjpa;

public class Daobdct extends BaseDao<Bdct>{

	private EntityManager manager;
	private EntityTransaction transaction;
	private Connectjpa conn;
	private List<Bdct> lstbdct;
	public Daobdct() {
		this.conn=new Connectjpa();
		this.lstbdct=new ArrayList<Bdct>();
	}
	
	@Override
	public Class<Bdct> getmodeclass() {
		return Bdct.class;
	}

	@Override
	public String getdatabase() {
		return Bdct.class.getSimpleName();
	}

	//tạo nhiều bàn đặt chi tiết(class liên quan: Confirmbooking)
	public void insertbdct(List<Bdct> lst) {
		try {
			this.manager=this.conn.getEntityManager();
			this.transaction=this.manager.getTransaction();
			transaction.begin();
			for(int i=0;i<lst.size();i++) {
				Bdct b=lst.get(i);
				this.manager.persist(b);
			}
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
	}
	
	public List<Bdct> findbdctbyttbd(ThongTinBanDat t){
		try {
			String hql="SELECT b FROM Bdct b WHERE thongTinBanDat=:ttbd";
			this.manager=this.conn.getEntityManager();
			TypedQuery<Bdct> query=this.manager.createQuery(hql,Bdct.class);
			query.setParameter("ttbd", t);
			return this.lstbdct=query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void deletelichdat(ThongTinBanDat ttbd) {
		this.manager = this.conn.getEntityManager();
		this.transaction = this.manager.getTransaction();
		try {
			this.manager.getTransaction().begin();
			manager.flush();
			manager.clear();
			String hql = "DELETE Bdct t WHERE thongTinBanDat=:index";

			Query query = this.manager.createQuery(hql);
			query.setParameter("index", ttbd);
			query.executeUpdate();
			this.transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.transaction.rollback();
		}
	}
}
