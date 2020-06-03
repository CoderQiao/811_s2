package com.ssh.usermanage.service;

import java.util.List;

import com.ssh.usermanage.bean.User;
import com.ssh.usermanage.dao.UserDAO;

/**
 * 乔同良
 * 2020年5月29日
 */
public class UserService
{
	private UserDAO userDAO;
	
	public void setUserDao(UserDAO userDAO){
		this.userDAO = userDAO;
	}
	
	public List<User> getAll(){
		return userDAO.getAll();
	}
	public void delete(Integer id){
		userDAO.delete(id);
	}
	
	public void saveOrUpdate(User user){
		userDAO.saveOrUpdate(user);
	}
	
	public User get(Integer id){
		return userDAO.get(id);
	}

}
