package com.sj.ldap.Provider;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;

import com.sj.ldap.entity.PermissionDTO;
import com.sj.ldap.entity.Users;
import com.sj.ldap.service.SecuritySer;

@Controller
public class AuthProvider implements AuthenticationProvider{
	
	@Autowired 
	private SecuritySer ser;
	private static final Logger log = Logger.getLogger(AuthProvider.class);
	HttpSession Session=null;

	@Override
	public Authentication authenticate(Authentication auth1) throws AuthenticationException {
		String name=auth1.getName();
		System.out.println("-------suneel-------------"+name);
		String pass=auth1.getCredentials().toString();
        Integer userId =  0;
        
        try {
        	userId = ser.findUserId(name, pass);
        	log.info("Authentication  " + name);
		
        	
		
		
		List<GrantedAuthority> grant=new ArrayList<GrantedAuthority>();
		if(userId>0){
			
			Users user = ser.getUserbyId(userId);
        	for (PermissionDTO perm : user.getUserPermissions()) {
        		System.out.println("permsions are ----"+perm.getUrl());
        		String url = perm.getUrl();
        		if(perm.getView()==true){
        			String authority="ROLE_"+url+"_view_Y";
        			grant.add(new SimpleGrantedAuthority(authority));
        			
        			/*if(perm.getCreate()==true){
        				 authority="ROLE_"+url+"_create_Y";
        				 grant.add(new SimpleGrantedAuthority(authority));
        			}
        			
        			if(perm.getEditAny()==true){
        				authority="ROLE_"+url+"_editAny_Y";
        				grant.add(new SimpleGrantedAuthority(authority));
        			}*/
        			
        		}
        		
        		
        	}
			
			//grant.add(new SimpleGrantedAuthority("ROLE_USER"));
			Authentication auth=new UsernamePasswordAuthenticationToken(name,pass,grant);
			return auth;
		}
		else{
			
			return null;
		}
        } 
		catch (Exception e) {
			log.error("Authentication Fail  " + name);
			throw new BadCredentialsException("User or password incorrect");
		}
		
	}

	@Override
	public boolean supports(Class<?> custAuth) {
		return custAuth.equals(UsernamePasswordAuthenticationToken.class);
	}

}
