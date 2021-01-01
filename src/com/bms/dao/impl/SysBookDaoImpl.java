package com.bms.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.bms.dao.ISysBookDao;
import com.bms.entity.SysBook;
import com.bms.utils.DBTools;
import com.bms.utils.DateUtils;

public class SysBookDaoImpl extends BaseDaoImpl<SysBook> implements ISysBookDao {

	private Connection conn = DBTools.getConnection();
	private Date lendDateTime = new Date(System.currentTimeMillis());

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
		Object[] params = new Object[] { id };
		try {
			book = super.get(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
	}

	@Override
	public int lend(int id) {
		int ret = -1;
		String sql = "update sys_book set lendedNumber=lendedNumber+1 where id=?";
		Object[] params = new Object[] { id };
		try {
			ret = super.update(conn, sql, params);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return ret;
	}

	@Override
	public int edit(SysBook sysBook) {
		int ret = -1;
		String sql = "update sys_book set bookName=?, author=? ,publisher=?,bookNumbers=? where id=?";
		Object[] params = new Object[] { sysBook.getBookName(), sysBook.getAuthor(), sysBook.getPublisher(),
				sysBook.getBookNumbers(), sysBook.getId() };
		try {
			ret = super.update(conn, sql, params);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return ret;
	}

	@Override
	public SysBook getSysRoleByRoleName(String bookName) {
		SysBook book = null;
		String sql = "select * from sys_book where bookName=?";
		Object[] params = new Object[] { bookName };
		try {
			book = super.get(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
	}

	@Override
	public int add(SysBook sysBook) {
		int ret = -1;
		String sql = "insert into sys_book(bookName,author,publisher,bookNumbers,lendedNumber)values(?,?,?,?,?)";
		Object[] params = new Object[] { sysBook.getBookName(), sysBook.getAuthor(), sysBook.getPublisher(),
				sysBook.getBookNumbers(), 0 };
		try {
			ret = super.insert(conn, sql, params);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return ret;
	}

	@Override
	public int delete(int id) {
		int ret = -1;
		String sql = "delete from sys_book where id = ?";
		Object[] params = new Object[] { id };
		try {
			ret = super.update(conn, sql, params);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return ret;
	}

	@Override
	public int addLend(int userId, int roleId, int bookId) {
		int ret = -1;
		Date estimateReturnDate = null;
		if (roleId == 1 || roleId == 2) {
			estimateReturnDate = DateUtils.dateAddDays(lendDateTime, 180);
		} else if (roleId == 3) {
			estimateReturnDate = DateUtils.dateAddDays(lendDateTime, 90);
		}
		String sql = "insert into sys_lend(userId,bookId,lendDate,estimateReturnDate,actualDeturnDate,status)values(?,?,?,?,?,?)";
		Object[] params = new Object[] { userId, bookId, lendDateTime, estimateReturnDate, null , 00 };
		try {
			ret = super.insert(conn, sql, params);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return ret;
	}

	@Override
	public int returnBook(int id) {
		int ret = -1;
		String sql = "update sys_book set lendedNumber=lendedNumber-1 where id=?";
		Object[] params = new Object[] {id};
		try {
			ret = super.update(conn, sql, params);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return ret;
	}

	@Override
	public int returnLend(int lendId, int userId, int bookId) {
		int ret = -1;
		String sql = "update sys_lend set actualDeturnDate=?, status=? where id=?";
		Object[] params = new Object[] {lendDateTime, 11, lendId};
		try {
			ret = super.insert(conn, sql, params);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return ret;
	}
}
