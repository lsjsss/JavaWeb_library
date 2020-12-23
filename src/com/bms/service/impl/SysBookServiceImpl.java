package com.bms.service.impl;

import java.util.List;

import com.bms.dao.ISysBookDao;
import com.bms.dao.ISysUserDao;
import com.bms.dao.impl.SysBookDaoImpl;
import com.bms.dao.impl.SysUserDaoImpl;
import com.bms.entity.SysBook;
import com.bms.service.ISysBookService;

public class SysBookServiceImpl implements ISysBookService {
	private ISysBookDao bookDao = new SysBookDaoImpl();
	private ISysUserDao userDao = new SysUserDaoImpl();

	@Override
	public List<SysBook> getAll() {
		List<SysBook> list = this.bookDao.getAll();
		return list;
	}

}
