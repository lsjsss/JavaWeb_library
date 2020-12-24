package com.bms.dao;

import java.util.List;

import com.bms.entity.SysBook;

public interface ISysBookDao {

	List<SysBook> getAll();

	SysBook get(int id);

	int edit(SysBook book);

}
