package com.ssh.usermanage.dao;

import org.hibernate.Query;

import com.ssh.usermanage.bean.User;

/**
 * 乔同良
 * 2020年6月2日
 */
public class LoginDAO extends BaseDao
{
	public void save(User user){
		getSession().save(user);
	}
	public boolean isExistedByName(String name){
		//System.out.print(this.getUserByName(name).toString());
		if(this.getUserByName(name) != null){
			return false;
		}else{
			return true;
		}
		
	}
	
	public User getUserByName(String name){
		String hql = "FROM User u WHERE u.realName = ?";
		Query query = getSession().createQuery(hql).setString(0, name);
		User user = (User) query.uniqueResult();
		return user;
	}
	
	public boolean isUser(String name,String password){
		String pass = getUserByName(name).getPassword();
		if(pass.equals(password)){
			return true;
		}
		return false;
	}

}
