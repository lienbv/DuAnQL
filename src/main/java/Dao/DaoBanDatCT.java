package Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import model.Bdct;
import model.ThongTinBanDat;
import model.TtBan;
import utils.Connectjpa;

public class DaoBanDatCT extends BaseDao<Bdct> {
	private Connectjpa conn;
	private EntityManager manager;
	private EntityTransaction transaction;
	private List<Bdct> lst;
	private Bdct bdct;

	public DaoBanDatCT() {
		this.conn = new Connectjpa();
		this.lst = new ArrayList<Bdct>();
		this.bdct = new Bdct();
	}

	// tìm thông tin bàn đặt qua bdct trong servlet QuảnliMenuController
	public List<Bdct> findTTBD(ThongTinBanDat ttbd) {
		try {
			this.manager = this.conn.getEntityManager();
			String hql = "SELECT h FROM Bdct h WHERE thongTinBanDat =:sl";
			TypedQuery<Bdct> query = manager.createQuery(hql, Bdct.class);
			query.setParameter("sl", ttbd);
			this.lst = query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return this.lst;
	}

	// đếm các bàn đặt qua trong servlet QuảnliMenuController
	public int count(ThongTinBanDat t) {
		try {
			this.manager = this.conn.getEntityManager();
			String qery = "select count(u.thongTinBanDat.idBd) from Bdct u Where thongTinBanDat=:t";
			Query sql = manager.createQuery(qery);
			sql.setParameter("t", t);
			return ((Long) sql.getSingleResult()).intValue();
		} catch (Exception e) {
			return 0;
		}
		
	}


	// tìm mã bàn đặt qua bdct trong servlet QuảnliMenuController
	public List<Bdct> findTTban(TtBan ttb) {
		try {
			this.manager = this.conn.getEntityManager();
			String hql = "SELECT h FROM Bdct h WHERE ttBan =:id_ban";
			TypedQuery<Bdct> query = manager.createQuery(hql, Bdct.class);
			query.setParameter("id_ban", ttb);
			this.lst = query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return lst;
	}

	@Override
	public Class<Bdct> getmodeclass() {

		return Bdct.class;
	}

	@Override
	public String getdatabase() {

		return Bdct.class.getSimpleName();
	}

	public Bdct findBdct(TtBan ttb) {
		try {
			this.manager = this.conn.getEntityManager();
			String hql = "SELECT h FROM Bdct h WHERE ttBan =:id_ban ORDER BY idBdct";
			TypedQuery<Bdct> query = manager.createQuery(hql, Bdct.class);
			query.setParameter("id_ban",ttb );
			this.bdct = query.getResultList().get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return this.bdct;
	}
	

}
