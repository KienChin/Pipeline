package com.revature.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.revature.models.Address;
import com.revature.models.Bookmark;
import com.revature.util.HibernateUtil;

public class AdrDaoImpl implements AdrDao {
	
	public static AdrDao ad;

	public AdrDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public static AdrDao getDao() {
		if (ad == null) {
			ad = new AdrDaoImpl();
		}
		return ad;
	}

	@Override
	public Address getAddress(int id) {
		Session hiSess = HibernateUtil.getSession();
		// HQL uses bean name, NOT table name
		String hql = "FROM Address WHERE adr_id = :idVal";
		Query<Bookmark> selectBkmk = hiSess.createQuery(hql, Bookmark.class);
		selectBkmk.setParameter("idVal", id);
		Bookmark bkmk = (Bookmark) selectBkmk.getSingleResult(); // exception needs handling
		hiSess.close();
		return null;
	}

	@Override
	public int addAdr(Address adr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Address> getAllAdr() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteAdr(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
