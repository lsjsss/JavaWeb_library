package service;

import java.util.List;

import com.sj.bms.entity.SysRole;

public interface ISysRoleService {

	List<SysRole> getAll();

	int add(String roleName, String description);

	SysRole getSysRoleByRoleName(String roleName);

	int delete(String id);

	SysRole get(String id);

	int edit(String id, String roleName, String description);
	

}
