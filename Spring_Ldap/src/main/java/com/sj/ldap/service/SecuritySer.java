package com.sj.ldap.service;

import com.sj.ldap.entity.Users;

public interface SecuritySer {

	Integer findUserId(String name, String pass);

	Users getUserbyId(Integer userId);

}
