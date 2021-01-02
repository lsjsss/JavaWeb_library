package com.bms.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.bms.dao.ISysLendDao;
import com.bms.entity.SysLend;
import com.bms.utils.DBTools;

public class SysLendDaoImpl extends BaseDaoImpl<SysLend> implements ISysLendDao {
	private Connection conn = DBTools.getConnection();
	
	@Override
	public List<SysLend> getAll() {
		List<SysLend> list = null;
		String sql = "select * from sys_lend";
		Object[] params = new Object[] {};
		try {
			list = super.getForList(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
