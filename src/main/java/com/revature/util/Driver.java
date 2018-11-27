package com.revature.util;

import com.revature.daos.BkmkDao;
import com.revature.daos.BkmkDaoImpl;
import com.revature.daos.UserDao;
import com.revature.daos.UserDaoImpl;
import com.revature.models.Address;
import com.revature.models.Bookmark;
import com.revature.models.User;

public class Driver {

	public static void main(String[] args) {
		//Session sess = HibernateUtil.getSession();
		//sess.close();
		
		UserDao ud = UserDaoImpl.getDao();
		BkmkDao bd = BkmkDaoImpl.getDao();
		
		Address anAdr = new Address("A Metropolis", "A State", "987 An Ave", 88888);
		User aUser = new User("aUser", "aPW", "Adrien", "Agreste", 
				"chatnoir@amail.fr", anAdr, 0);
		System.out.println(ud.addUser(aUser)); 
		
		System.out.println(ud.getUser("aUser", "aPW"));
		
		Bookmark someBkmk = new Bookmark(aUser, "/french-candidate");
		System.out.println(bd.addBkmk(someBkmk));
		System.out.println(bd.getAllBkmks(aUser));
	}

}
