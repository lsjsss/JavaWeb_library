package com.bms.service;

import java.util.List;

import com.bms.entity.SysUser;

public interface ISysUserService {

	SysUser login(String loginName, String password);

	boolean isExits(String loginName);

	int add(String loginName, String realName, String password, String roleId);

	List<SysUser> getAll();

	SysUser get(String id);

	int edit(String id, String loginName, String realName);

	int delete(String id);


}
