package entity;

import java.io.Serializable;

public class SysUser implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//用户编号
	private int id;
	//登录名
	private String loginName;
	//用户姓名
	private String realName;
	//用户密码
	private String password;
	//用户角色编号
	private int roleId;
	//最大借阅数量(教师：10本，学生：5本)
	private int maxLendNumber;
	//用户角色编号(教师：180天，学生：90天)
	private int maxLendDays;
	
	//设置角色属性
	private String value;
	
	public SysUser() {
		super();
	}


	public SysUser(String loginName, String realName, String password, int roleId, int maxLendNumber, int maxLendDays) {
		super();
		this.loginName = loginName;
		this.realName = realName;
		this.password = password;
		this.roleId = roleId;
		this.maxLendNumber = maxLendNumber;
		this.maxLendDays = maxLendDays;
	}


	public SysUser(int id, String loginName, String realName, String password, int roleId, int maxLendNumber,
			int maxLendDays) {
		super();
		this.id = id;
		this.loginName = loginName;
		this.realName = realName;
		this.password = password;
		this.roleId = roleId;
		this.maxLendNumber = maxLendNumber;
		this.maxLendDays = maxLendDays;
	}

	
	public SysUser(int id, String loginName, String realName, String password, int roleId, int maxLendNumber,
			int maxLendDays, String value) {
		super();
		this.id = id;
		this.loginName = loginName;
		this.realName = realName;
		this.password = password;
		this.roleId = roleId;
		this.maxLendNumber = maxLendNumber;
		this.maxLendDays = maxLendDays;
		this.value = value;
	}


	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getLoginName() {
		return loginName;
	}


	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}


	public String getRealName() {
		return realName;
	}


	public void setRealName(String realName) {
		this.realName = realName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getRoleId() {
		return roleId;
	}


	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}


	public int getMaxLendNumber() {
		return maxLendNumber;
	}


	public void setMaxLendNumber(int maxLendNumber) {
		this.maxLendNumber = maxLendNumber;
	}


	public int getMaxLendDays() {
		return maxLendDays;
	}


	public void setMaxLendDays(int maxLendDays) {
		this.maxLendDays = maxLendDays;
	}


	@Override
	public String toString() {
		return "SysUser [id=" + id + ", loginName=" + loginName + ", realName=" + realName + ", password=" + password
				+ ", roleId=" + roleId + ", maxLendNumber=" + maxLendNumber + ", maxLendDays=" + maxLendDays + "]";
	}



	
	
}
