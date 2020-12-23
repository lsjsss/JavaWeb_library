package com.bms.service.impl;

import java.util.List;

import com.bms.dao.ISysRoleDao;
import com.bms.dao.impl.SysRoleDaoImpl;
import com.bms.entity.SysRole;
import com.bms.service.ISysRoleService;


public class SysRoleServiceImpl implements ISysRoleService {
	
	private ISysRoleDao roleDao = new SysRoleDaoImpl();

	@Override
	public List<SysRole> getAll() {
		return this.roleDao.getAll();
	}

	@Override
	public int add(String roleName, String description) {
		SysRole sysRole = new SysRole(roleName, description);
		return this.roleDao.add(sysRole);
	}

	@Override
	public SysRole getSysRoleByRoleName(String roleName) {
		return this.roleDao.getSysRoleByRoleName(roleName);
	}

	@Override
	public int delete(String id) {
		return this.roleDao.delete(Integer.valueOf(id));
	}

	@Override
	public SysRole get(String id) {
		return this.roleDao.get(Integer.valueOf(id));
	}

	@Override
	public int edit(String id, String roleName, String description) {
		SysRole role = new SysRole(Integer.valueOf(id), roleName, description);
		return this.roleDao.edit(role);
	}


}
