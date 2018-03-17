package com.sj.ldap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sj.ldap.dao.SecurityDao;
import com.sj.ldap.entity.Users;

@Component
public class SecuritySerImpl implements SecuritySer{
	
	@Autowired
	private SecurityDao dao;
	
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED , readOnly=false)
	public Integer findUserId(String name, String pass) {
		return dao.findUserId(name,pass);
	}


	@Override
	@Transactional(propagation=Propagation.REQUIRED , readOnly=false)
	public Users getUserbyId(Integer userId) {
		return dao.getUserbyId(userId);
	}

}
