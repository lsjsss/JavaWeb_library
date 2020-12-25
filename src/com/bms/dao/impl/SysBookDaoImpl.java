package com.bms.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.bms.dao.ISysBookDao;
import com.bms.entity.SysBook;
import com.bms.entity.SysRole;
import com.bms.utils.DBTools;

public class SysBookDaoImpl extends BaseDaoImpl<SysBook> implements ISysBookDao {

	private Connection conn = DBTools.getConnection();

	@Override
	public List<SysBook> getAll() {
		List<SysBook> list = null;
		String sql = "select * from sys_book";
		Object[] params = new Object[] {};
		try {
			list = super.getForList(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public SysBook get(int id) {
		SysBook book = null;
		String sql = "select * from sys_book where id = ?";
		Object[] params = new Object[] {id};
		try {
			book = super.get(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
	}

	@Override
	public int edit(SysBook sysBook) {
		int ret = -1;
		String sql = "update sys_book set bookName=?, author=? ,publisher=?,bookNumbers=? where id=?";
		Object[] params = new Object[] {sysBook.getBookName(), sysBook.getAuthor(), sysBook.getPublisher(), sysBook.getBookNumbers(), sysBook.getId()};
		try {
			ret = super.update(conn, sql, params);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return ret;
	}

}
