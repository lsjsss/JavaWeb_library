package impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.sj.bms.dao.ISysRoleDao;
import com.sj.bms.entity.SysRole;
import com.sj.bms.utils.DBTools;

public class SysRoleDaoImpl extends BaseDaoImpl<SysRole> implements ISysRoleDao {
	
	private Connection conn = DBTools.getConnection();

	@Override
	public List<SysRole> getAll() {
		List<SysRole> list = null;
		String sql = "select * from sys_role";
		Object[] params = new Object[] {};
		try {
			list = super.getForList(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public SysRole get(int id) {
		SysRole role = null;
		String sql = "select * from sys_role where id = ?";
		Object[] params = new Object[] {id};
		try {
			role = super.get(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return role;
	}

	@Override
	public int delete(int id) {
		int ret = -1;
		String sql = "delete from sys_role where id = ?";
		Object[] params = new Object[] {id};
		try {
			ret = super.update(conn, sql, params);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return ret;
	}

	@Override
	public int add(SysRole sysRole) {
		int ret = -1;
		String sql = "insert into sys_role(roleName, remark)values(?,?)";
		Object[] params = new Object[] {sysRole.getRoleName(),sysRole.getRemark()};
		try {
			ret = super.insert(conn, sql, params);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return ret;
	}

	@Override
	public int edit(SysRole sysRole) {
		int ret = -1;
		String sql = "update sys_role set roleName=?,remark=? where id=?";
		Object[] params = new Object[] {sysRole.getRoleName(),sysRole.getRemark(),sysRole.getId()};
		try {
			ret = super.update(conn, sql, params);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return ret;
	}

	@Override
	public SysRole getSysRoleByRoleName(String roleName) {
		SysRole role = null;
		String sql = "select * from sys_role where roleName=?";
		Object[] params = new Object[] {roleName};
		try {
			role = super.get(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return role;
	}
}
