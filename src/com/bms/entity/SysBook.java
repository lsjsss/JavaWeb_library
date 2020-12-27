package com.bms.entity;

import java.io.Serializable;

public class SysBook implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//图书编号
	private int id;
	//书名
	private String bookName;
	//作者
	private String author;
	//出版社
	private String publisher;
	//图书数量
	private int bookNumbers;
	//已经借出数量
	private int lendedNumber;
	
	public SysBook() {
		super();
	}

	public SysBook(String bookName, String author, String publisher, int bookNumbers, int lendedNumber) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.publisher = publisher;
		this.bookNumbers = bookNumbers;
		this.lendedNumber = lendedNumber;
	}

	public SysBook(int id, String bookName, String author, String publisher, int bookNumbers, int lendedNumber) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.author = author;
		this.publisher = publisher;
		this.bookNumbers = bookNumbers;
		this.lendedNumber = lendedNumber;
	}
	
	public SysBook(String bookName, String author, String publisher, int bookNumbers) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.publisher = publisher;
		this.bookNumbers = bookNumbers;
	}
	
	

	public SysBook(int id, String bookName, String author, String publisher, int bookNumbers) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.author = author;
		this.publisher = publisher;
		this.bookNumbers = bookNumbers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getBookNumbers() {
		return bookNumbers;
	}

	public void setBookNumbers(int bookNumbers) {
		this.bookNumbers = bookNumbers;
	}

	public int getLendedNumber() {
		return lendedNumber;
	}

	public void setLendedNumber(int lendedNumber) {
		this.lendedNumber = lendedNumber;
	}

	@Override
	public String toString() {
		return "SysBook [id=" + id + ", bookName=" + bookName + ", author=" + author + ", publisher=" + publisher
				+ ", bookNumbers=" + bookNumbers + ", lendedNumber=" + lendedNumber + "]";
	}	

	
}
