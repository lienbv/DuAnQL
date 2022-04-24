package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the khach_hang database table.
 * 
 */
@Entity
@Table(name="khach_hang")
@NamedQuery(name="KhachHang.findAll", query="SELECT k FROM KhachHang k")
public class KhachHang implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idkh;

	private String gmail;

	@Column(name="HO_TEN")
	private String hoTen;

	private String password;

	private String sdt;

	private String username;

	//bi-directional many-to-one association to HoaDon
	@OneToMany(mappedBy="khachHang")
	private List<HoaDon> hoaDons;

	//bi-directional many-to-one association to ThongTinBanDat
	@OneToMany(mappedBy="khachHang")
	private List<ThongTinBanDat> thongTinBanDats;

	public KhachHang() {
	}


	public KhachHang(int idkh, String gmail, String hoTen, String password, String sdt, String username) {
		super();
		this.idkh = idkh;
		this.gmail = gmail;
		this.hoTen = hoTen;
		this.password = password;
		this.sdt = sdt;
		this.username = username;
	}

	public int getIdkh() {
		return this.idkh;
	}

	public void setIdkh(int idkh) {
		this.idkh = idkh;
	}

	public String getGmail() {
		return this.gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	public String getHoTen() {
		return this.hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSdt() {
		return this.sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<HoaDon> getHoaDons() {
		return this.hoaDons;
	}

	public void setHoaDons(List<HoaDon> hoaDons) {
		this.hoaDons = hoaDons;
	}

	public HoaDon addHoaDon(HoaDon hoaDon) {
		getHoaDons().add(hoaDon);
		hoaDon.setKhachHang(this);

		return hoaDon;
	}

	public HoaDon removeHoaDon(HoaDon hoaDon) {
		getHoaDons().remove(hoaDon);
		hoaDon.setKhachHang(null);

		return hoaDon;
	}

	public List<ThongTinBanDat> getThongTinBanDats() {
		return this.thongTinBanDats;
	}

	public void setThongTinBanDats(List<ThongTinBanDat> thongTinBanDats) {
		this.thongTinBanDats = thongTinBanDats;
	}

	public ThongTinBanDat addThongTinBanDat(ThongTinBanDat thongTinBanDat) {
		getThongTinBanDats().add(thongTinBanDat);
		thongTinBanDat.setKhachHang(this);

		return thongTinBanDat;
	}

	public ThongTinBanDat removeThongTinBanDat(ThongTinBanDat thongTinBanDat) {
		getThongTinBanDats().remove(thongTinBanDat);
		thongTinBanDat.setKhachHang(null);

		return thongTinBanDat;
	}

}