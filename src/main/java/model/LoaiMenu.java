package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the loai_menu database table.
 * 
 */
@Entity
@Table(name="loai_menu")
@NamedQuery(name="LoaiMenu.findAll", query="SELECT l FROM LoaiMenu l")
public class LoaiMenu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idloai;

	private String img;

	private int loai;

	@Column(name="ten_loai")
	private String tenLoai;

	//bi-directional many-to-one association to Menu
	@OneToMany(mappedBy="loaiMenu")
	private List<Menu> menus;

	public LoaiMenu() {
	}

	public int getIdloai() {
		return this.idloai;
	}

	public void setIdloai(int idloai) {
		this.idloai = idloai;
	}

	public String getImg() {
		return this.img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getLoai() {
		return this.loai;
	}

	public void setLoai(int loai) {
		this.loai = loai;
	}

	public String getTenLoai() {
		return this.tenLoai;
	}

	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}

	public List<Menu> getMenus() {
		return this.menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public Menu addMenus(Menu menus) {
		getMenus().add(menus);
		menus.setLoaiMenu(this);

		return menus;
	}

	public Menu removeMenus(Menu menus) {
		getMenus().remove(menus);
		menus.setLoaiMenu(null);

		return menus;
	}

}