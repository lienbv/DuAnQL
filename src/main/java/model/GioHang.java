package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the gio_hang database table.
 * 
 */
@Entity
@Table(name="gio_hang")
@NamedQuery(name="GioHang.findAll", query="SELECT g FROM GioHang g")
public class GioHang implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idgh;

	private int so_luong;

	//bi-directional many-to-one association to Menu
	@ManyToOne
	@JoinColumn(name="IDMN")
	private Menu menu;

	//bi-directional many-to-one association to ThongTinBanDat
	@ManyToOne
	@JoinColumn(name="ID_BD")
	private ThongTinBanDat thongTinBanDat;

	public GioHang() {
	}

	public int getIdgh() {
		return this.idgh;
	}

	public void setIdgh(int idgh) {
		this.idgh = idgh;
	}

	public int getSo_luong() {
		return this.so_luong;
	}

	public void setSo_luong(int so_luong) {
		this.so_luong = so_luong;
	}

	public Menu getMenu() {
		return this.menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public ThongTinBanDat getThongTinBanDat() {
		return this.thongTinBanDat;
	}

	public void setThongTinBanDat(ThongTinBanDat thongTinBanDat) {
		this.thongTinBanDat = thongTinBanDat;
	}

	public GioHang(int idgh, int so_luong, Menu menu, ThongTinBanDat thongTinBanDat) {
		super();
		this.idgh = idgh;
		this.so_luong = so_luong;
		this.menu = menu;
		this.thongTinBanDat = thongTinBanDat;
	}

	
	
}