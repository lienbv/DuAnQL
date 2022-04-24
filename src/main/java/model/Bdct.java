package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


/**
 * The persistent class for the bdct database table.
 * 
 */
@Entity
@NamedQuery(name="Bdct.findAll", query="SELECT b FROM Bdct b")
public class Bdct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_BDCT")
	private int idBdct;

	//bi-directional many-to-one association to TtBan
	@ManyToOne
	@JoinColumn(name="IDBan")
	private TtBan ttBan;

	//bi-directional many-to-one association to ThongTinBanDat
	@ManyToOne
	@JoinColumn(name="ID_BD")
	private ThongTinBanDat thongTinBanDat;

	//bi-directional many-to-one association to Mnct
	@OneToMany(mappedBy="bdct")
	private List<Mnct> mncts;

	public Bdct() {
	}

	public Bdct(int idBdct, TtBan ttBan, ThongTinBanDat thongTinBanDat) {
		this.idBdct = idBdct;
		this.ttBan = ttBan;
		this.thongTinBanDat = thongTinBanDat;
	}

	public int getIdBdct() {
		return this.idBdct;
	}

	public void setIdBdct(int idBdct) {
		this.idBdct = idBdct;
	}

	public TtBan getTtBan() {
		return this.ttBan;
	}

	public void setTtBan(TtBan ttBan) {
		this.ttBan = ttBan;
	}

	public ThongTinBanDat getThongTinBanDat() {
		return this.thongTinBanDat;
	}

	public void setThongTinBanDat(ThongTinBanDat thongTinBanDat) {
		this.thongTinBanDat = thongTinBanDat;
	}

	public List<Mnct> getMncts() {
		return this.mncts;
	}

	public void setMncts(List<Mnct> mncts) {
		this.mncts = mncts;
	}

	public Mnct addMnct(Mnct mnct) {
		getMncts().add(mnct);
		mnct.setBdct(this);

		return mnct;
	}

	public Mnct removeMnct(Mnct mnct) {
		getMncts().remove(mnct);
		mnct.setBdct(null);

		return mnct;
	}

}