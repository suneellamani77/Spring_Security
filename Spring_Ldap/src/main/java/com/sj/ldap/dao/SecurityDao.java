package com.sj.ldap.dao;

import com.sj.ldap.entity.Users;

public interface SecurityDao {

	Integer findUserId(String name, String pass);

	Users getUserbyId(Integer userId);

}
