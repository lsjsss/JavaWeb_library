package service.impl;

import java.util.List;

import com.sj.bms.dao.ISysBookDao;
import com.sj.bms.dao.ISysUserDao;
import com.sj.bms.dao.impl.SysBookDaoImpl;
import com.sj.bms.dao.impl.SysUserDaoImpl;
import com.sj.bms.entity.SysBook;
import com.sj.bms.service.ISysBookService;

public class SysBookServiceImpl implements ISysBookService {
	private ISysBookDao bookDao = new SysBookDaoImpl();
	private ISysUserDao userDao = new SysUserDaoImpl();

	@Override
	public List<SysBook> getAll() {
		List<SysBook> list = this.bookDao.getAll();
		return list;
	}

}
