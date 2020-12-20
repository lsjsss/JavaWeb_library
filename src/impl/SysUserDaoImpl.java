package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.sj.bms.dao.ISysUserDao;
import com.sj.bms.entity.SysUser;
import com.sj.bms.utils.DBTools;

public class SysUserDaoImpl extends BaseDaoImpl<SysUser> implements ISysUserDao {

	private Connection conn = DBTools.getConnection();
	
	@Override
	public SysUser login(String loginName, String password) {
		SysUser user = null;
		String sql = "select * from sys_user where loginName=? and password=?";
		Object[] params = new Object[] {loginName, password};
		try {
			user = super.get(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public boolean isExits(String loginName) {
		SysUser user = null;
		String sql = "select * from sys_user where loginName=?";
		Object[] params = new Object[] {loginName};
		try {
			user = super.get(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user==null?false:true;
	}

	@Override
	public int insert(String loginName, String realName, String password, String roleId) {
		int id = -1;
		id = Integer.valueOf(roleId);
		String sql = "insert into sys_user(loginName,realName,password,roleId,maxLendNumber,maxLendDays)values(?,?,?,?,?,?)";
		Object[] params = new Object[] {loginName,realName,password,id,id==2?10:5,id==2?180:90};
		try {			
			PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			//提供数据
            if (params != null && params.length > 0) {
                for (int i = 0; i < params.length; i++) {
                    st.setObject(i + 1, params[i]);
                }
            }
			st.executeUpdate();
			ResultSet rs = st.getGeneratedKeys();
            while(rs.next()){
                id = rs.getInt(1);
            } 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public List<SysUser> getAll() {
		List<SysUser> list = null;
		String sql = "select * from sys_user";
		Object[] params = new Object[] {};
		try {
			list = super.getForList(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
