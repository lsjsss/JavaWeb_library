package impl;

import java.util.List;

import com.sj.bms.constant.Constant;
import com.sj.bms.dao.ISysRoleDao;
import com.sj.bms.dao.ISysUserDao;
import com.sj.bms.dao.impl.SysRoleDaoImpl;
import com.sj.bms.dao.impl.SysUserDaoImpl;
import com.sj.bms.entity.SysRole;
import com.sj.bms.entity.SysUser;
import com.sj.bms.service.ISysUserService;

public class SysUserServiceImpl implements ISysUserService {

	private ISysUserDao userDao = new SysUserDaoImpl();
	private ISysRoleDao roleDao = new SysRoleDaoImpl();

	@Override
	public SysUser login(String loginName, String password) {
		return userDao.login(loginName, password);
	}

	@Override
	public boolean isExits(String loginName) {
		return this.userDao.isExits(loginName);
	}

	@Override
	public int add(String loginName, String realName, String password, String roleId) {
		return this.userDao.insert(loginName, realName, password, roleId);
	}

	@Override
	public List<SysUser> getAll() {
		List<SysUser> list = this.userDao.getAll();
		
		for(SysUser user : list) {
			SysRole role = this.roleDao.get(user.getRoleId());
			if(user.getRoleId()==1) {
				user.setValue(Constant.USER_ADMIN);
			} else if(user.getRoleId()==2) {
				user.setValue(Constant.USER_TEACHER);
			} else if(user.getRoleId()==3) {
				user.setValue(Constant.USER_STUDENT);
			}
		}
		return list;
	}

}
