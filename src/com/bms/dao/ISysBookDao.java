package com.bms.dao;

import java.util.List;

import com.bms.entity.SysBook;
import com.bms.entity.SysRole;

public interface ISysBookDao {

	List<SysBook> getAll();

	SysBook get(int id);

	int edit(SysBook book);

	SysBook getSysRoleByRoleName(String bookName);

	int add(SysBook sysBook);

	int delete(int id);

	int lend(int id);

	int addLend(int userId, int bookId);


}
