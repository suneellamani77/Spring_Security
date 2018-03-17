package com.sj.ldap.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sj.ldap.entity.Users;

@Repository
public class SecurityDaoImpl implements SecurityDao{
	
	@Autowired
	private SessionFactory sf;

	@Override
	public Integer findUserId(String name, String pass) {
		return (Integer) sf.getCurrentSession().createQuery("select userId from Users where userEmail='"+name+"' and password='"+pass+"'").uniqueResult();
	}

	@Override
	public Users getUserbyId(Integer userId) {
		return (Users) sf.getCurrentSession().createQuery("from Users where userId='"+userId+"'").uniqueResult();
	}
}
