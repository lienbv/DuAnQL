package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import utils.Connectjpa;

abstract public class BaseDao<T> {
abstract public Class<T> getmodeclass();
abstract public String getdatabase();
private EntityManager manager;
private EntityTransaction transaction;
private Connectjpa conn;
public BaseDao() {
	this.conn=new Connectjpa();
}

public T insert(T t) {
	try {
		manager=this.conn.getEntityManager();
		transaction=manager.getTransaction();
		transaction.begin();
		manager.persist(t);
		transaction.commit();
	} catch (Exception e) {
		e.printStackTrace();
		transaction.rollback();
	}
	return t;
}

public T update(T t) {
	try {
		manager=this.conn.getEntityManager();
		transaction=manager.getTransaction();
		transaction.begin();
		manager.merge(t);
		transaction.commit();
	} catch (Exception e) {
		e.printStackTrace();
		transaction.rollback();
	}
	return t;
}

public T findbyid(int id) {
	manager=this.conn.getEntityManager();
	T t=manager.find(getmodeclass(), id);
	return t;
}


public void delete(int id) {
	T t=findbyid(id);
	this.manager=this.conn.getEntityManager();
	this.transaction=this.manager.getTransaction();
	try {
		this.transaction.begin();
		this.manager.remove(t);
		this.transaction.commit();
	} catch (Exception e) {
		e.printStackTrace();
		this.transaction.rollback();
	}
}

public List<T> getall(){
	this.manager=this.conn.getEntityManager();
	String hql="from "+getdatabase();
	TypedQuery<T> query=this.manager.createQuery(hql,getmodeclass());
	List<T> lst=query.getResultList();
	return lst;
}
	
}
