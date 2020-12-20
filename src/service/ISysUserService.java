package service;

import java.util.List;

import com.sj.bms.entity.SysUser;

public interface ISysUserService {

	SysUser login(String loginName, String password);

	boolean isExits(String loginName);

	int add(String loginName, String realName, String password, String roleId);

	List<SysUser> getAll();


}
