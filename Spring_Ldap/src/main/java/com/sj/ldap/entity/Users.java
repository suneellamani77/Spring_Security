package com.sj.ldap.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="bms_users")
public class Users {
	
	@Id
	@GenericGenerator(name = "incr", strategy = "increment")
	@GeneratedValue(generator = "incr")
	@Column(name="USER_ID")
	private Integer userId;
	
	@Column(name="USERNAME")
	private String userEmail;
	
	public Users() {
		super();
	}

	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="ACTIVE")
	private int active=0;
	
	@OneToMany(fetch = FetchType.EAGER ,mappedBy = "userRoles")
	@Fetch(value=FetchMode.SUBSELECT)
	private List<PermissionDTO> userPermissions;
	
	
/*	@OneToOne(cascade = CascadeType.ALL,fetch =FetchType.EAGER,mappedBy = "loginInfo")
	@JsonIgnore
	private RegistrationDto regInfo;*/
	

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public List<PermissionDTO> getUserPermissions() {
		return userPermissions;
	}

	public void setUserPermissions(List<PermissionDTO> userPermissions) {
		this.userPermissions = userPermissions;
	}

	/*public RegistrationDto getRegInfo() {
		return regInfo;
	}

	public void setRegInfo(RegistrationDto regInfo) {
		this.regInfo = regInfo;
	}*/

	
	
	
	
	

}