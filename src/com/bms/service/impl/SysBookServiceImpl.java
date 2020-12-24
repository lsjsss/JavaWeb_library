package com.bms.service.impl;

import java.util.List;

import com.bms.dao.ISysBookDao;
import com.bms.dao.ISysUserDao;
import com.bms.dao.impl.SysBookDaoImpl;
import com.bms.dao.impl.SysUserDaoImpl;
import com.bms.entity.SysBook;
import com.bms.entity.SysRole;
import com.bms.service.ISysBookService;

public class SysBookServiceImpl implements ISysBookService {
	private ISysBookDao bookDao = new SysBookDaoImpl();

	@Override
	public List<SysBook> getAll() {
		List<SysBook> list = this.bookDao.getAll();
		return list;
	}

	@Override
	public SysBook get(String id) {
		return this.bookDao.get(Integer.valueOf(id));
	}

	@Override
	public int edit(String id, String bookName, String author, String publisher, int bookNumbers) {
		SysBook book = new SysBook(Integer.valueOf(id), bookName, author, publisher, bookNumbers);
		return this.bookDao.edit(book);
	}

}
