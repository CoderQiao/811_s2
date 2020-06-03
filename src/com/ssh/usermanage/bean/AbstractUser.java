package com.ssh.usermanage.bean;

/**
 * AbstractUser entity provides the base persistence definition of the User
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractUser implements java.io.Serializable
{

	// Fields
	
	private Integer userId;
	private String password;
	private String realName;
	@Override
	public String toString()
	{
		return "AbstractUser [userId=" + userId + ", password=" + password + ", realName=" + realName + ", email="
				+ email + ", admin=" + admin + "]";
	}

	private String email;
	private String admin;

	// Constructors

	/** default constructor */
	public AbstractUser()
	{
	}

	/** full constructor */
	public AbstractUser(Integer userId, String password, String realName, String email, String admin)
	{
		this.userId = userId;
		this.password = password;
		this.realName = realName;
		this.email = email;
		this.admin = admin;
	}

	// Property accessors

	public Integer getUserId()
	{
		return this.userId;
	}

	public void setUserId(Integer userId)
	{
		this.userId = userId;
	}

	public String getPassword()
	{
		return this.password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getRealName()
	{
		return this.realName;
	}

	public void setRealName(String realName)
	{
		this.realName = realName;
	}

	public String getEmail()
	{
		return this.email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getAdmin()
	{
		return this.admin;
	}

	public void setAdmin(String admin)
	{
		this.admin = admin;
	}

}