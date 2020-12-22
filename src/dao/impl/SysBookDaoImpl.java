package dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.sj.bms.dao.ISysBookDao;
import com.sj.bms.entity.SysBook;
import com.sj.bms.utils.DBTools;

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

}
