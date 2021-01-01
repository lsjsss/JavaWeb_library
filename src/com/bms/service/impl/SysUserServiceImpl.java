package com.bms.service.impl;

import java.util.List;

import com.bms.constant.Constant;
import com.bms.dao.ISysRoleDao;
import com.bms.dao.ISysUserDao;
import com.bms.dao.impl.SysRoleDaoImpl;
import com.bms.dao.impl.SysUserDaoImpl;
import com.bms.entity.SysUser;
import com.bms.service.ISysUserService;

public class SysUserServiceImpl implements ISysUserService {

	private ISysUserDao userDao = new SysUserDaoImpl();
	private ISysRoleDao roleDao = new SysRoleDaoImpl();

	@Override
	public SysUser login(String loginName, String password) {
		return userDao.login(loginName, password);
	}

	@Override
	public boolean isExits(String loginName) {
		return this.userDao.isExits(loginName);
	}

	@Override
	public int add(String loginName, String realName, String password, String roleId) {
		return this.userDao.insert(loginName, realName, password, roleId);
	}

	@Override
	public List<SysUser> getAll() {
		List<SysUser> list = this.userDao.getAll();
		
		for(SysUser user : list) {
			this.roleDao.get(user.getRoleId());
			if(user.getRoleId()==1) {
				user.setValue(Constant.USER_ADMIN);
			} else if(user.getRoleId()==2) {
				user.setValue(Constant.USER_TEACHER);
			} else if(user.getRoleId()==3) {
				user.setValue(Constant.USER_STUDENT);
			}
		}
		return list;
	}

	@Override
	public SysUser get(String id) {
		return this.userDao.get(Integer.valueOf(id));
	}

	@Override
	public int edit(String id, String loginName, String realName) {
		SysUser user = new SysUser(Integer.valueOf(id), loginName, realName);
		return this.userDao.edit(user);
	}

	@Override
	public int delete(String id) {
		return this.userDao.delete(Integer.valueOf(id));
	}

}
