package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.LoaiMenu;
import utils.Connectjpa;

public class Daoloaimenu extends BaseDao<LoaiMenu> {
private LoaiMenu loaimenu;
private Connectjpa conn;
private EntityManager manager;
private EntityTransaction transaction;
	public Daoloaimenu() {
		loaimenu=new LoaiMenu();
		conn= new Connectjpa();
	}
	
	@Override
	public Class<LoaiMenu> getmodeclass() {
		return LoaiMenu.class;
	}

	@Override
	public String getdatabase() {
		return LoaiMenu.class.getSimpleName();
	}

	

}
