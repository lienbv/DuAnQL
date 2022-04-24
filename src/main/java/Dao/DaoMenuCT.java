package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Bdct;
import model.Mnct;
import model.TtBan;
import utils.Connectjpa;

public class DaoMenuCT extends BaseDao<Mnct>{
	private Connectjpa conn;
	private EntityManager manager;
	private EntityTransaction transaction;
	private List<Mnct> lstmnct;
	private Mnct mnct;
	public DaoMenuCT() {
		conn= new Connectjpa();
		this.mnct=new Mnct();
	}
	@Override
	public Class<Mnct> getmodeclass() {
		// TODO Auto-generated method stub
		return Mnct.class;
	}

	@Override
	public String getdatabase() {
		// TODO Auto-generated method stub
		return Mnct.class.getSimpleName();
	}
   
	//tim bdct thong qua menuct <class : menuCTController>

	public List<Mnct> findTTban(Bdct bdct){
		try {
				this.manager=this.conn.getEntityManager();
					String hql="SELECT h FROM Mnct h WHERE bdct =:id_ban";
					TypedQuery<Mnct> query=manager.createQuery(hql,Mnct.class);
					query.setParameter("id_ban", bdct);
					this.lstmnct=query.getResultList();
					
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return lstmnct;
	}
	
	//tim bdct gan nhat cua menuct< class: AddMenuCT>
	public Mnct findmnctbybdct(Bdct b) {
		try {
			this.manager=this.conn.getEntityManager();
			String hql="SELECT m FROM Mnct m where bdct=:bd_ct ORDER BY idMnct DESC";
			TypedQuery<Mnct> query=this.manager.createQuery(hql,Mnct.class);
			query.setParameter("bd_ct", b);
			this.mnct=query.getResultList().get(0);
			return this.mnct;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	//update số lượng món ăn trong menct;
	public void updatemnct(int idmnct,int sl) {
		this.manager=this.conn.getEntityManager();
		try {
			this.manager.getTransaction().begin();
			manager.flush(); manager.clear();
			String hql="UPDATE Mnct SET so_luong=:sl WHERE idMnct=:id";
			Query query=this.manager.createQuery(hql);
			query.setParameter("sl", sl);
			query.setParameter("id", idmnct);
			query.executeUpdate();
			this.manager.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
			this.manager.getTransaction().rollback();
		}
		
	}
}
