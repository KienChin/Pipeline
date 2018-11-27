package com.revature.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.models.User;
import com.revature.util.HibernateUtil;

public class UserDaoImpl implements UserDao {
	
	private static UserDao ud;

	public UserDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public static UserDao getDao() {
		if (ud == null) {
			ud = new UserDaoImpl();
		}
		return ud;
	}

	@Override
	public User getUser(String username, String password) {
		Session hiSess = HibernateUtil.getSession();
		// HQL uses bean name, NOT table name
		String hql = "FROM User WHERE username = :userVal AND pswd = :pwVal";
		Query<User> selectUser = hiSess.createQuery(hql, User.class);
		selectUser.setParameter("userVal", username);
		selectUser.setParameter("pwVal", password);
		User user = (User) selectUser.getSingleResult(); // exception needs handling
		hiSess.close();
		return user;
	}	

	@Override
	public int addUser(User user) {
		Session hiSess = HibernateUtil.getSession();
		Transaction tx = hiSess.beginTransaction();
		// must add address first if not already in db to avoid transient exception
		AdrDao ad = AdrDaoImpl.getDao();
		if (ad.getAddress(user.getAddress().getAdr_id()) == null) { // if adr not in db
			hiSess.save(user.getAddress()); // add adr to db using save or addAdr
		}
		int userPK = (int) hiSess.save(user);
		// what if user is already in db?
		tx.commit();
		hiSess.close();
 		return userPK;
	}

	@Override
	public List<User> getAllUsers() {
		Session hiSess = HibernateUtil.getSession();
		Query<User> selectAll = hiSess.createQuery("FROM User", User.class);
		List<User> users = selectAll.list();
		hiSess.close();
		return users;
	}

}
