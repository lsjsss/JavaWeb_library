package dao;

import java.util.List;

import com.sj.bms.entity.SysUser;

public interface ISysUserDao {

	SysUser login(String loginName, String password);

	boolean isExits(String loginName);

	int insert(String loginName, String realName, String password, String roleId);

	List<SysUser> getAll();

}