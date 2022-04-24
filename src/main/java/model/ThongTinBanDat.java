package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the thong_tin_ban_dat database table.
 * 
 */
@Entity
@Table(name="thong_tin_ban_dat")
@NamedQuery(name="ThongTinBanDat.findAll", query="SELECT t FROM ThongTinBanDat t")
public class ThongTinBanDat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_BD")
	private int idBd;

	private String ghi_Chu;

	@Column(name="gio_dat_ban")
	private Time gioDatBan;

	@Temporal(TemporalType.DATE)
	@Column(name="ngay_dat_ban")
	private Date ngayDatBan;

	private int so_Luong_Nguoi;

	private String trang_Thai;

	//bi-directional many-to-one association to Bdct
	@OneToMany(mappedBy="thongTinBanDat")
	private List<Bdct> bdcts;

	//bi-directional many-to-one association to GioHang
	@OneToMany(mappedBy="thongTinBanDat")
	private List<GioHang> gioHangs;

	//bi-directional many-to-one association to HoaDon
	@OneToMany(mappedBy="thongTinBanDat")
	private List<HoaDon> hoaDons;

	//bi-directional many-to-one association to KhachHang
	@ManyToOne
	@JoinColumn(name="IDKH")
	private KhachHang khachHang;

	public ThongTinBanDat() {
	}

	public ThongTinBanDat(int idBd, String ghi_Chu, Time gioDatBan, Date ngayDatBan) {
		this.idBd = idBd;
		this.ghi_Chu = ghi_Chu;
		this.gioDatBan = gioDatBan;
		this.ngayDatBan = ngayDatBan;
	}

	public int getIdBd() {
		return this.idBd;
	}

	public void setIdBd(int idBd) {
		this.idBd = idBd;
	}

	public String getGhi_Chu() {
		return this.ghi_Chu;
	}

	public void setGhi_Chu(String ghi_Chu) {
		this.ghi_Chu = ghi_Chu;
	}

	public Time getGioDatBan() {
		return this.gioDatBan;
	}

	public void setGioDatBan(Time gioDatBan) {
		this.gioDatBan = gioDatBan;
	}

	public Date getNgayDatBan() {
		return this.ngayDatBan;
	}

	public void setNgayDatBan(Date ngayDatBan) {
		this.ngayDatBan = ngayDatBan;
	}

	public int getSo_Luong_Nguoi() {
		return this.so_Luong_Nguoi;
	}

	public void setSo_Luong_Nguoi(int so_Luong_Nguoi) {
		this.so_Luong_Nguoi = so_Luong_Nguoi;
	}

	public String getTrang_Thai() {
		return this.trang_Thai;
	}

	public void setTrang_Thai(String trang_Thai) {
		this.trang_Thai = trang_Thai;
	}

	public List<Bdct> getBdcts() {
		return this.bdcts;
	}

	public void setBdcts(List<Bdct> bdcts) {
		this.bdcts = bdcts;
	}

	public Bdct addBdct(Bdct bdct) {
		getBdcts().add(bdct);
		bdct.setThongTinBanDat(this);

		return bdct;
	}

	public Bdct removeBdct(Bdct bdct) {
		getBdcts().remove(bdct);
		bdct.setThongTinBanDat(null);

		return bdct;
	}

	public List<GioHang> getGioHangs() {
		return this.gioHangs;
	}

	public void setGioHangs(List<GioHang> gioHangs) {
		this.gioHangs = gioHangs;
	}

	public GioHang addGioHang(GioHang gioHang) {
		getGioHangs().add(gioHang);
		gioHang.setThongTinBanDat(this);

		return gioHang;
	}

	public GioHang removeGioHang(GioHang gioHang) {
		getGioHangs().remove(gioHang);
		gioHang.setThongTinBanDat(null);

		return gioHang;
	}

	public List<HoaDon> getHoaDons() {
		return this.hoaDons;
	}

	public void setHoaDons(List<HoaDon> hoaDons) {
		this.hoaDons = hoaDons;
	}

	public HoaDon addHoaDon(HoaDon hoaDon) {
		getHoaDons().add(hoaDon);
		hoaDon.setThongTinBanDat(this);

		return hoaDon;
	}

	public HoaDon removeHoaDon(HoaDon hoaDon) {
		getHoaDons().remove(hoaDon);
		hoaDon.setThongTinBanDat(null);

		return hoaDon;
	}

	public KhachHang getKhachHang() {
		return this.khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

}