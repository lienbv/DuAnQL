package Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.GioHang;
import model.ThongTinBanDat;
import utils.Connectjpa;

public class DaoCart extends BaseDao<GioHang>{

	private Connectjpa conn;
	private EntityManager manager;
	private List<GioHang> lstgh;
	private EntityTransaction transaction;
	public DaoCart() {
		this.conn=new Connectjpa();
		this.lstgh=new ArrayList<GioHang>();
	}
	@Override
	public Class<GioHang> getmodeclass() {
		return GioHang.class;
	}

	@Override
	public String getdatabase() {
		return GioHang.class.getSimpleName();
	}

	public void deletecartbyttbd(ThongTinBanDat T) {
		this.manager=this.conn.getEntityManager();
		this.transaction=this.manager.getTransaction();
		try {
			this.manager.getTransaction().begin();
			manager.flush(); manager.clear();
			String hql="Delete GioHang k WHERE thongTinBanDat=:tt_Bd";
			Query query=this.manager.createQuery(hql);
			query.setParameter("tt_Bd", T);
			query.executeUpdate();
			this.transaction.commit();
		}catch (Exception e) {
			e.printStackTrace();
			this.transaction.rollback();
		}
	}
	
	//hiển thị giỏ hàng (các class liên quan: Confirmbooking,Order)
	public List<GioHang> FindCartbyIDDB(ThongTinBanDat t){
		String hql="SELECT g FROM GioHang g WHERE thongTinBanDat=:tt_bd";
		this.manager=this.conn.getEntityManager();
		try {
			TypedQuery<GioHang> query=this.manager.createQuery(hql,GioHang.class);
			query.setParameter("tt_bd", t);
			this.lstgh=query.getResultList();
			return this.lstgh;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
