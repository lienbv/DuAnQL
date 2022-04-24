package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the mnct database table.
 * 
 */
@Entity
@NamedQuery(name="Mnct.findAll", query="SELECT m FROM Mnct m")
public class Mnct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_MNCT")
	private int idMnct;

	private int so_luong;

	//bi-directional many-to-one association to Hdct
	@OneToMany(mappedBy="mnct")
	private List<Hdct> hdcts;

	//bi-directional many-to-one association to MenuHuy
	@OneToMany(mappedBy="mnct")
	private List<MenuHuy> menuHuys;

	//bi-directional many-to-one association to Menu
	@ManyToOne
	@JoinColumn(name="ID_MN")
	private Menu menu;

	//bi-directional many-to-one association to Bdct
	@ManyToOne
	@JoinColumn(name="ID_BDCT")
	private Bdct bdct;

	public Mnct() {
	}

	public int getIdMnct() {
		return this.idMnct;
	}

	public void setIdMnct(int idMnct) {
		this.idMnct = idMnct;
	}

	public int getSo_luong() {
		return this.so_luong;
	}

	public void setSo_luong(int so_luong) {
		this.so_luong = so_luong;
	}

	public List<Hdct> getHdcts() {
		return this.hdcts;
	}

	public void setHdcts(List<Hdct> hdcts) {
		this.hdcts = hdcts;
	}

	public Hdct addHdct(Hdct hdct) {
		getHdcts().add(hdct);
		hdct.setMnct(this);

		return hdct;
	}

	public Hdct removeHdct(Hdct hdct) {
		getHdcts().remove(hdct);
		hdct.setMnct(null);

		return hdct;
	}

	public List<MenuHuy> getMenuHuys() {
		return this.menuHuys;
	}

	public void setMenuHuys(List<MenuHuy> menuHuys) {
		this.menuHuys = menuHuys;
	}

	public MenuHuy addMenuHuy(MenuHuy menuHuy) {
		getMenuHuys().add(menuHuy);
		menuHuy.setMnct(this);

		return menuHuy;
	}

	public MenuHuy removeMenuHuy(MenuHuy menuHuy) {
		getMenuHuys().remove(menuHuy);
		menuHuy.setMnct(null);

		return menuHuy;
	}

	public Menu getMenu() {
		return this.menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Bdct getBdct() {
		return this.bdct;
	}

	public void setBdct(Bdct bdct) {
		this.bdct = bdct;
	}

	public Mnct(int so_luong,  Bdct bdct,Menu menu) {
		this.so_luong = so_luong;
		this.menu = menu;
		this.bdct = bdct;
	}


}