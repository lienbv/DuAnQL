package Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import model.BaiViet;
import model.Staff;
import utils.Connectjpa;

public class baiVietDao extends BaseDao<BaiViet> {
	private BaiViet bv;
	private Connectjpa conn;
	private EntityManager manager;
	private EntityTransaction transaction;
	private List<BaiViet> lst;

	public baiVietDao() {
		this.bv = new BaiViet();
		this.conn = new Connectjpa();
		lst = new ArrayList<BaiViet>();
	}

	public List<BaiViet> findIDNV(Staff manv) {
		try {
			this.manager = this.conn.getEntityManager();
			String hql = "SELECT h FROM BaiViet h WHERE staff =:id_nv";
			TypedQuery<BaiViet> query = manager.createQuery(hql, BaiViet.class);
			query.setParameter("id_nv", manv);
			this.lst = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return lst;
	}

	public List<BaiViet> findName(String name) {
		try {
			this.manager = this.conn.getEntityManager();
			String hql = "SELECT h FROM BaiViet h WHERE h.ten_tieu_de like :tieude";
			TypedQuery<BaiViet> query = manager.createQuery(hql, BaiViet.class);
			query.setParameter("tieude", "%" + name + "%");
			this.lst = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return lst;

	}
	public List<BaiViet> findNameNV(String name,Staff idnv) {
		try {
			this.manager = this.conn.getEntityManager();
			String hql = "SELECT h FROM BaiViet h WHERE h.ten_tieu_de like :tieude and h.staff= :idnvstaff";
			TypedQuery<BaiViet> query = manager.createQuery(hql, BaiViet.class);
			query.setParameter("tieude", "%" + name + "%");
			query.setParameter("idnvstaff", idnv );
			this.lst = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return lst;

	}

	public BaiViet findid(Integer id) {

		this.manager = this.conn.getEntityManager();
		String hql = "SELECT h FROM BaiViet h WHERE h.IDbv = :id";
		TypedQuery<BaiViet> query = manager.createQuery(hql, BaiViet.class);
		query.setParameter("id", id);

		return query.getSingleResult();

	}

	@Override
	public String getdatabase() {
		// TODO Auto-generated method stub
		return BaiViet.class.getSimpleName();
	}

	@Override
	public Class<BaiViet> getmodeclass() {
		return BaiViet.class;
	}

}
