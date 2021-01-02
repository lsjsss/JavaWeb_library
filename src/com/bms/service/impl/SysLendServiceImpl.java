package com.bms.service.impl;

import java.util.List;

import com.bms.dao.ISysLendDao;
import com.bms.dao.impl.SysLendDaoImpl;
import com.bms.entity.SysLend;
import com.bms.service.ISysLendService;

public class SysLendServiceImpl implements ISysLendService {
	private ISysLendDao lendDao = new SysLendDaoImpl();

	@Override
	public List<SysLend> getAll() {
		List<SysLend> list = this.lendDao.getAll();
		return list;
	}

}
