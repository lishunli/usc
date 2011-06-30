package com.taifook.mtss.mss.acl.model;

public class AclEntry {

	private Long id;

	private String function;

	private String permission;

	public AclEntry() {
	}

	public AclEntry(Long id, String permission, String function) {
		this.id = id;
		this.function = function;
		this.permission = permission;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

}
