package com.bms.dao;

import java.util.List;

import com.bms.entity.SysUser;

public interface ISysUserDao {

	SysUser login(String loginName, String password);

	boolean isExits(String loginName);

	int insert(String loginName, String realName, String password, String roleId);

	List<SysUser> getAll();

	SysUser get(int id);

	int edit(SysUser user);

	int delete(int id);

}
