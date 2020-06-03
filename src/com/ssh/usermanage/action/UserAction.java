package com.ssh.usermanage.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.ssh.usermanage.bean.User;
import com.ssh.usermanage.service.UserService;

/**
 * 乔同良
 * 2020年5月29日
 */
public class UserAction extends ActionSupport implements RequestAware,ModelDriven<User>,Preparable,SessionAware
{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private UserService userService;
	private InputStream inputStream;
	private User model;
	private Map<String,Object> session;
	
	public void setUserService(UserService userService){
		this.userService = userService;
	}
	
	private Map<String,Object> request;
	
	@Override
	public void setRequest(Map<String, Object> arg0)
	{
		this.request = arg0;
		
	}
	
	public String list(){
		if(session.get("login").equals("logined")){
			request.put("users", userService.getAll());
			return "list";
		}
		else{
			return "illegal";
		}
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	//ajax 提示删除是否成功
	public InputStream getInputStream() {
		return inputStream;
	}
	public String delete(){
		try {
			userService.delete(id);
			inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
		}
		return "delete";
	}

	public String edit(){
		return INPUT;
	}
	
	public String prepareEdit(){
		if(id != null){
			model = userService.get(id);
		}
		return null;
	}
	
	public String save(){
		System.out.println(model);
		userService.saveOrUpdate(model);
		return SUCCESS;
	}
	
	public void prepareSave(){
		//System.out.println("prepareSave...");
		if(id == null){
			model = new User();
		}
		else {
			model = userService.get(id);//用于回显
		}
	}
	
	//因为每一次调用useraction都会调用这个方法比较浪费，所以禁用掉
	//再写一个parameter 方法 prepareInput(),只在input方法调用时才被调用
	@Override
	public void prepare() throws Exception
	{
		//System.out.println("prepare...");
	}

	//将model压入栈顶
	@Override
	public User getModel()
	{
		//System.out.println("getModel...");
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
