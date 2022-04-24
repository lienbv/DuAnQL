package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.Bdct;
import model.TtBan;
import utils.Connectjpa;

public class Daottban extends BaseDao<TtBan> {

	private Connectjpa conn;
	private TtBan ttban;
	private List<TtBan> lstttb;
	private EntityManager manager;
	private EntityTransaction transaction;
	public Daottban() {
		this.conn=new Connectjpa();
		}
	@Override
	public Class<TtBan> getmodeclass() {
		return TtBan.class;
	}

	@Override
	public String getdatabase() {
		return TtBan.class.getSimpleName();
	}

	// hiển thị bàn đang trống
	public List<TtBan> showemptytable() {
		try {
			this.manager = this.conn.getEntityManager();
			String hql = "SELECT t FROM TtBan t WHERE t.IDBan NOT IN "
					+ "(SELECT b.ttBan FROM Bdct b where thongTinBanDat IN"
					+ "(SELECT d.idBd FROM ThongTinBanDat d WHERE d.trang_Thai=:status or d.trang_Thai=:tt))";
			TypedQuery<TtBan> query = this.manager.createQuery(hql, TtBan.class);
			query.setParameter("status", "Confirmed");
			query.setParameter("tt", "active");
			this.lstttb = query.getResultList();
			return this.lstttb;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	public List<TtBan> findloai( int ban){
		try {
			this.manager= this.conn.getEntityManager();
			String hql= "Select b from TtBan b where b.loaiBan= :loai";
			TypedQuery<TtBan> query = this.manager.createQuery(hql, TtBan.class);
			query.setParameter("loai", ban);
			this.lstttb= query.getResultList();
			return this.lstttb;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}

	//hiển thị bàn đã xác nhận
	public List<TtBan> showtableconfirm() {
		try {
			this.manager = this.conn.getEntityManager();
			String hql = "SELECT t FROM TtBan t WHERE t.IDBan IN "
					+ "(SELECT b.ttBan FROM Bdct b where thongTinBanDat IN"
					+ "(SELECT d.idBd FROM ThongTinBanDat d WHERE d.trang_Thai=:status))";
			TypedQuery<TtBan> query = this.manager.createQuery(hql, TtBan.class);
			query.setParameter("status", "Confirmed");
			return this.lstttb = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
		// hiển thị bàn trạng thái đang hoạt động
		public List<TtBan> showtableactive() {
			try {
				this.manager = this.conn.getEntityManager();
				String hql = "SELECT t FROM TtBan t WHERE t.IDBan IN "
						+ "(SELECT b.ttBan FROM Bdct b where thongTinBanDat IN"
						+ "(SELECT d.idBd FROM ThongTinBanDat d WHERE d.trang_Thai=:tt))";
				TypedQuery<TtBan> query = this.manager.createQuery(hql, TtBan.class);
				query.setParameter("tt", "Active");
				this.lstttb = query.getResultList();
				return this.lstttb;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
	}
		
		public List<TtBan> findName(int name){
			try {
				this.manager=this.conn.getEntityManager();
				String hql="SELECT h FROM TtBan h WHERE h.IDBan = :id";
				TypedQuery<TtBan> query=manager.createQuery(hql,TtBan.class);
				query.setParameter("id", name );
				this.lstttb=query.getResultList();
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			return lstttb;
			
		}
}
