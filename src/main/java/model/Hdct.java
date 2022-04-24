package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the hdct database table.
 * 
 */
@Entity
@NamedQuery(name="Hdct.findAll", query="SELECT h FROM Hdct h")
public class Hdct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_HDCT")
	private int idHdct;

	private int so_luong;

	private double thanh_Tien;

	//bi-directional many-to-one association to HoaDon
	@ManyToOne
	@JoinColumn(name="ID_HD")
	private HoaDon hoaDon;

	//bi-directional many-to-one association to Mnct
	@ManyToOne
	@JoinColumn(name="ID_MNCT")
	private Mnct mnct;

	public Hdct() {
	}

	public int getIdHdct() {
		return this.idHdct;
	}

	public void setIdHdct(int idHdct) {
		this.idHdct = idHdct;
	}

	public int getSo_luong() {
		return this.so_luong;
	}

	public void setSo_luong(int so_luong) {
		this.so_luong = so_luong;
	}

	public double getThanh_Tien() {
		return this.thanh_Tien;
	}

	public void setThanh_Tien(double thanh_Tien) {
		this.thanh_Tien = thanh_Tien;
	}

	public HoaDon getHoaDon() {
		return this.hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}

	public Mnct getMnct() {
		return this.mnct;
	}

	public void setMnct(Mnct mnct) {
		this.mnct = mnct;
	}

	public Hdct(int idHdct, int so_luong, double thanh_Tien) {
		this.idHdct = idHdct;
		this.so_luong = so_luong;
		this.thanh_Tien = thanh_Tien;
	}

	public Hdct(int idHdct, int so_luong, HoaDon hoaDon, Mnct mnct) {
		this.idHdct = idHdct;
		this.so_luong = so_luong;
		this.hoaDon = hoaDon;
		this.mnct = mnct;
	}

}