package com.revature.service;

import com.revature.daos.UserDaoImpl;

public class VoteServImpl implements VoteService {

	public VoteServImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean login(String username, String password) {
		if (UserDaoImpl.getDao().getUser(username, password) != null) {
			return true;
		}
		return false;
	}

}
