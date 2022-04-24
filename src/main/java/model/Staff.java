package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the staff database table.
 * 
 */
@Entity
@NamedQuery(name="Staff.findAll", query="SELECT s FROM Staff s")
public class Staff implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idnv;

	private String cccd;

	@Column(name="CHUC_VU")
	private String chucVu;

	private String email;

	@Column(name="HO_TEN")
	private String hoTen;

	private String img;

	private String password;

	private String sdt;

	private String username;

	//bi-directional many-to-one association to BaiViet
	@OneToMany(mappedBy="staff")
	private List<BaiViet> baiViets;

	//bi-directional many-to-one association to HoaDon
	@OneToMany(mappedBy="staff")
	private List<HoaDon> hoaDons;

	public Staff() {
	}

	public int getIdnv() {
		return this.idnv;
	}

	public void setIdnv(int idnv) {
		this.idnv = idnv;
	}

	public String getCccd() {
		return this.cccd;
	}

	public void setCccd(String cccd) {
		this.cccd = cccd;
	}

	public String getChucVu() {
		return this.chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHoTen() {
		return this.hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getImg() {
		return this.img;
	}

	public void setImg(String img) {
		this.img = img;
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

	public List<BaiViet> getBaiViets() {
		return this.baiViets;
	}

	public void setBaiViets(List<BaiViet> baiViets) {
		this.baiViets = baiViets;
	}

	public BaiViet addBaiViet(BaiViet baiViet) {
		getBaiViets().add(baiViet);
		baiViet.setStaff(this);

		return baiViet;
	}

	public BaiViet removeBaiViet(BaiViet baiViet) {
		getBaiViets().remove(baiViet);
		baiViet.setStaff(null);

		return baiViet;
	}

	public List<HoaDon> getHoaDons() {
		return this.hoaDons;
	}

	public void setHoaDons(List<HoaDon> hoaDons) {
		this.hoaDons = hoaDons;
	}

	public HoaDon addHoaDon(HoaDon hoaDon) {
		getHoaDons().add(hoaDon);
		hoaDon.setStaff(this);

		return hoaDon;
	}

	public HoaDon removeHoaDon(HoaDon hoaDon) {
		getHoaDons().remove(hoaDon);
		hoaDon.setStaff(null);

		return hoaDon;
	}

}