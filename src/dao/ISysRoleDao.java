package dao;

import java.util.List;

import com.sj.bms.entity.SysRole;

public interface ISysRoleDao {	
	
	/**
	 * 获取所有角色
	 * @return
	 */
	List<SysRole> getAll();	
	
	/**
	 * 根据id获取角色
	 * @param id
	 * @return
	 */
	SysRole get(int id);
	
	/**
	 * 根据id删除角色
	 * @param id
	 * @return
	 */
	int delete(int id);
	
	/**
	 * 新增角色，返回新增角色的id
	 * @param sysRole
	 */
	int add(SysRole sysRole);
	
	/**
	 * 更新角色
	 * @param sysRole
	 */
	int edit(SysRole sysRole);

	/**
	 * 按角色名称查询
	 * @param roleName
	 * @return 角色对象
	 */
	SysRole getSysRoleByRoleName(String roleName);
	
}
