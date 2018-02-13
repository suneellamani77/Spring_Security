package com.sj.ldap.Provider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;

@Controller
public class AuthProvider implements AuthenticationProvider{

	@Override
	public Authentication authenticate(Authentication auth1) throws AuthenticationException {
		String name=auth1.getName();
		String pass=auth1.getCredentials().toString();
		
		List<GrantedAuthority> grant=new ArrayList<GrantedAuthority>();
		if(name.equals("admin")&& pass.equals("1")){
			grant.add(new SimpleGrantedAuthority("ROLE_USER"));
			Authentication auth=new UsernamePasswordAuthenticationToken(name,pass,grant);
			return auth;
		}
		else{
			
			return null;
		}
	}

	@Override
	public boolean supports(Class<?> custAuth) {
		return custAuth.equals(UsernamePasswordAuthenticationToken.class);
	}

}
