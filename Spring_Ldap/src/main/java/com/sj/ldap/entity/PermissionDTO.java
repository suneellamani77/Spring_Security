package com.sj.ldap.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "bms_permissions")
public class PermissionDTO {
	
	
	@Id
	@GenericGenerator(name = "incr", strategy = "increment")
	@GeneratedValue(generator = "incr")
	@Column(name = "PERM_ID")
	private Integer permId;
	
	@Column(name = "URL")
	private String url;
	
	@Column(name = "PERM_VIEW")
	private Boolean view=false;
	
	@Column(name = "PERM_CREATE")
	private Boolean create=false;
	
	@Column(name = "PERM_EDIT_OWN")
	private Boolean editOwn=false;
	
	@Column(name = "PERM_EDIT_ANY")
	private Boolean editAny=false;
	
	@Column(name = "PERM_DELETE_OWN")
	private Boolean deleteOwn=false;
	
	@Column(name = "PERM_DELETE_ANY")
	private Boolean deleteAny=false;
	
	
	
	@ManyToOne(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_ID")
	private Users userRoles;

	public Integer getPermId() {
		return permId;
	}

	public void setPermId(Integer permId) {
		this.permId = permId;
	}

	

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Boolean getView() {
		return view;
	}

	public void setView(Boolean view) {
		this.view = view;
	}

	public Boolean getCreate() {
		return create;
	}

	public void setCreate(Boolean create) {
		this.create = create;
	}

	public Boolean getEditOwn() {
		return editOwn;
	}

	public void setEditOwn(Boolean editOwn) {
		this.editOwn = editOwn;
	}

	public Boolean getEditAny() {
		return editAny;
	}

	public void setEditAny(Boolean editAny) {
		this.editAny = editAny;
	}

	public Boolean getDeleteOwn() {
		return deleteOwn;
	}

	public void setDeleteOwn(Boolean deleteOwn) {
		this.deleteOwn = deleteOwn;
	}

	public Boolean getDeleteAny() {
		return deleteAny;
	}

	public void setDeleteAny(Boolean deleteAny) {
		this.deleteAny = deleteAny;
	}

	public Users getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Users userRoles) {
		this.userRoles = userRoles;
	}

	


}
