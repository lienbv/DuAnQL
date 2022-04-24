package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tt_ban database table.
 * 
 */
@Entity
@Table(name="tt_ban")
@NamedQuery(name="TtBan.findAll", query="SELECT t FROM TtBan t")
public class TtBan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int IDBan;

	@Column(name="loai_ban")
	private int loaiBan;

	//bi-directional many-to-one association to Bdct
	@OneToMany(mappedBy="ttBan")
	private List<Bdct> bdcts;

	public TtBan() {
	}

	public TtBan(int loaiBan) {
		this.loaiBan = loaiBan;
	}

	public int getIDBan() {
		return this.IDBan;
	}

	public void setIDBan(int IDBan) {
		this.IDBan = IDBan;
	}

	public int getLoaiBan() {
		return this.loaiBan;
	}

	public void setLoaiBan(int loaiBan) {
		this.loaiBan = loaiBan;
	}

	public List<Bdct> getBdcts() {
		return this.bdcts;
	}

	public void setBdcts(List<Bdct> bdcts) {
		this.bdcts = bdcts;
	}

	public Bdct addBdct(Bdct bdct) {
		getBdcts().add(bdct);
		bdct.setTtBan(this);

		return bdct;
	}

	public Bdct removeBdct(Bdct bdct) {
		getBdcts().remove(bdct);
		bdct.setTtBan(null);

		return bdct;
	}

}