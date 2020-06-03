package com.ssh.usermanage.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssh.usermanage.bean.User;
import com.ssh.usermanage.dao.LoginDAO;

/**
 * 乔同良
 * 2020年6月1日
 */
public class LoginAction extends ActionSupport implements ModelDriven<User>,SessionAware
{
	private InputStream inputStream;
	private User model;
	private LoginDAO loginDao;
	private Map<String,Object> session;
	
	public InputStream getInputStream()
	{
		return inputStream;
	}

	public void setInputStream(InputStream inputStream)
	{
		this.inputStream = inputStream;
	}

	public LoginDAO getLoginDao()
	{
		return loginDao;
	}

	public void setLoginDao(LoginDAO loginDao)   //犯过错误 1.未在applicationContext中配置LoginDAO和LoginAction
	{											 //未给loginDao设置getter和setter方法，导致空指针异常
		this.loginDao = loginDao;
	}

	public String login(){
		String name = model.getRealName();
		String password = model.getPassword();
		if(loginDao.isUser(name, password)){
			session.put("login", "logined");
			return SUCCESS;
		}
		else{
			return "failed";
		}
		
	}
	
	public String register(){
		//System.out.print(model.toString());
		loginDao.save(model);
		return SUCCESS;
	}
	
	public String validateName() throws UnsupportedEncodingException{
		if(loginDao.isExistedByName(model.getRealName())){
			inputStream = new ByteArrayInputStream("1".getBytes("UTF-8")); 
		}else{
			inputStream = new ByteArrayInputStream("0".getBytes("UTF-8")); 
		}
		return SUCCESS;
	}
	
	@Override
	public User getModel()
	{
		if(model == null){
			model = new User();
		}
		return model;
	}

	/* (non-Javadoc)
	 * @see org.apache.struts2.interceptor.SessionAware#setSession(java.util.Map)
	 */
	@Override
	public void setSession(Map<String, Object> arg0)
	{
		session = arg0;
		
	}

}
