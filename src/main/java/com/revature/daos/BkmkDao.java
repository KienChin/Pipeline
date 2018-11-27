package com.revature.daos;

import java.util.List;

import com.revature.models.Bookmark;
import com.revature.models.User;

public interface BkmkDao {

	public Bookmark getBkmk(int id);
	public List<Bookmark> getAllBkmks(User user);
	public int addBkmk(Bookmark bkmk);
	//public boolean deleteBkmk(int id);
	
}
