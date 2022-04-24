package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the menu database table.
 * 
 */
@Entity
@NamedQuery(name="Menu.findAll", query="SELECT m FROM Menu m")
public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idmn;

	private float gia;

	private String img;

	private String ten_Mon_An;

	private int trang_Thai;

	//bi-directional many-to-one association to GioHang
	@OneToMany(mappedBy="menu")
	private List<GioHang> gioHangs;

	//bi-directional many-to-one association to LoaiMenu
	@ManyToOne
	@JoinColumn(name="IDLoai")
	private LoaiMenu loaiMenu;

	//bi-directional many-to-one association to Mnct
	@OneToMany(mappedBy="menu")
	private List<Mnct> mncts;

	public Menu() {
	}

	public Menu(float gia, String img, String ten_Mon_An, int trang_Thai, LoaiMenu loaiMenu) {
		this.gia = gia;
		this.img = img;
		this.ten_Mon_An = ten_Mon_An;
		this.trang_Thai = trang_Thai;
		this.loaiMenu = loaiMenu;
	}

	public int getIdmn() {
		return this.idmn;
	}

	public void setIdmn(int idmn) {
		this.idmn = idmn;
	}

	public float getGia() {
		return this.gia;
	}

	public void setGia(float gia) {
		this.gia = gia;
	}

	public String getImg() {
		return this.img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getTen_Mon_An() {
		return this.ten_Mon_An;
	}

	public void setTen_Mon_An(String ten_Mon_An) {
		this.ten_Mon_An = ten_Mon_An;
	}

	public int getTrang_Thai() {
		return this.trang_Thai;
	}

	public void setTrang_Thai(int trang_Thai) {
		this.trang_Thai = trang_Thai;
	}

	public List<GioHang> getGioHangs() {
		return this.gioHangs;
	}

	public void setGioHangs(List<GioHang> gioHangs) {
		this.gioHangs = gioHangs;
	}

	public GioHang addGioHang(GioHang gioHang) {
		getGioHangs().add(gioHang);
		gioHang.setMenu(this);

		return gioHang;
	}

	public GioHang removeGioHang(GioHang gioHang) {
		getGioHangs().remove(gioHang);
		gioHang.setMenu(null);

		return gioHang;
	}

	public LoaiMenu getLoaiMenu() {
		return this.loaiMenu;
	}

	public void setLoaiMenu(LoaiMenu loaiMenu) {
		this.loaiMenu = loaiMenu;
	}

	public List<Mnct> getMncts() {
		return this.mncts;
	}

	public void setMncts(List<Mnct> mncts) {
		this.mncts = mncts;
	}

	public Mnct addMnct(Mnct mnct) {
		getMncts().add(mnct);
		mnct.setMenu(this);

		return mnct;
	}

	public Mnct removeMnct(Mnct mnct) {
		getMncts().remove(mnct);
		mnct.setMenu(null);

		return mnct;
	}

}