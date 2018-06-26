package com.dao;

import java.util.List;
import com.domain.User;

public interface UserDAO {
	
	public void saveUser(User user) ;
	public List<User> listUser() ;
}
