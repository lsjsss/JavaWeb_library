package com.bms.service;

import java.util.List;

import com.bms.entity.SysBook;

public interface ISysBookService {

	List<SysBook> getAll();

	SysBook get(String id);

	int edit(String id, String bookName, String author, String publisher, int bookNumbers);

}
