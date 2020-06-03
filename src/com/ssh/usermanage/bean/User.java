package com.ssh.usermanage.bean;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
public class User extends AbstractUser implements java.io.Serializable
{

	// Constructors

	/** default constructor */
	public User()
	{
	}

	/** full constructor */
	public User(Integer userId, String password, String realName, String email, String admin)
	{
		super(userId, password, realName, email, admin);
	}

}
