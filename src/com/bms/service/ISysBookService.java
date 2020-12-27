package com.bms.service;

import java.util.List;

import com.bms.entity.SysBook;
import com.bms.entity.SysRole;

public interface ISysBookService {

	List<SysBook> getAll();

	SysBook get(String id);

	int edit(String id, String bookName, String author, String publisher, int bookNumbers);

	SysBook getSysRoleByRoleName(String bookName);

	int add(String bookName, String author, String publisher, String bookNumbers);

	int delete(String id);

	int lend(String id);

	int addLend(String userId, String bookId);


}
