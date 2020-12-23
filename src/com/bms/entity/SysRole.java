package com.bms.entity;

import java.io.Serializable;

public class SysRole implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//角色编号
	private int id;
	//角色名称
	private String roleName;
	//角色描述信息
	private String remark;
	
	public SysRole() {
		super();
	}	

	public SysRole(String roleName, String remark) {
		super();
		this.roleName = roleName;
		this.remark = remark;
	}
	
	public SysRole(int id, String roleName, String remark) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.remark = remark;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "SysRole [id=" + id + ", roleName=" + roleName + ", remark=" + remark + "]";
	}

}
