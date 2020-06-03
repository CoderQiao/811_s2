package com.ssh.usermanage.dao;

import java.util.List;

import com.ssh.usermanage.bean.User;

public class UserDAO extends BaseDao
{
	public List<User> getAll(){
		String hql = "FROM User";
		return getSession().createQuery(hql).list();
	}
	
	public void delete(Integer id){
		String hql = "DELETE FROM User u WHERE u.userId = ?";
		getSession().createQuery(hql).setInteger(0, id).executeUpdate();
	}
	
	public void saveOrUpdate(User user){
		getSession().saveOrUpdate(user);
	}
	
	public User get(Integer id){
		return (User) getSession().get(User.class, id);
	}
}