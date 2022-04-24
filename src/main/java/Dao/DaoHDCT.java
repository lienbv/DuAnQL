package Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Bdct;
import model.Hdct;
import model.HoaDon;
import model.Mnct;
import utils.Connectjpa;

public class DaoHDCT extends BaseDao<Hdct>{

	private Connectjpa conn;
	private EntityManager manager;
	private List<Hdct> lsthdct;
	public DaoHDCT() {
		this.conn=new Connectjpa();
		this.lsthdct=new ArrayList<Hdct>();
	}
	@Override
	public Class<Hdct> getmodeclass() {
		return Hdct.class;
	}

	@Override
	public String getdatabase() {
		return Hdct.class.getSimpleName();
	}
	//tìm hóa đơn qua hdct trong servlet AddMenuController
	public List<Hdct> findhdctbyidhd(HoaDon h){
		this.manager=this.conn.getEntityManager();
		String hql="SELECT h FROM Hdct h WHERE hoaDon=:hoa_don";
		try {
			TypedQuery<Hdct> query=this.manager.createQuery(hql,Hdct.class);
			query.setParameter("hoa_don", h);
			this.lsthdct=query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return this.lsthdct;
	}
  
//tìm menuct qua hdct trong servlet menuctController
	public List<Hdct> findMenuct(Mnct mn){
		try {
				this.manager=this.conn.getEntityManager();
					String hql="SELECT h FROM Hdct h WHERE mnct =:id";
					TypedQuery<Hdct> query=manager.createQuery(hql,Hdct.class);
					query.setParameter("id", mn);
					this.lsthdct=query.getResultList();
					
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return lsthdct;
	}
}
