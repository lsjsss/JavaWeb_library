package entity;

import java.io.Serializable;
import java.util.Date;

public class SysLend implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//借阅编号
	private int id;
	//用户编号
	private int userId;
	//图书编号
	private int bookId;
	//借阅日期
	private Date lendDate;
	//预计归还日期
	private Date estimateReturnDate;
	//实际归还日期
	private Date actualDeturnDate;
	//借阅标志位:00-借阅中 11-已归还
	private String status;
	
	public SysLend() {
		super();
	}

	public SysLend(int userId, int bookId, Date lendDate, Date estimateReturnDate, Date actualDeturnDate, String status) {
		super();
		this.userId = userId;
		this.bookId = bookId;
		this.lendDate = lendDate;
		this.estimateReturnDate = estimateReturnDate;
		this.actualDeturnDate = actualDeturnDate;
		this.status = status;
	}

	public SysLend(int id, int userId, int bookId, Date lendDate, Date estimateReturnDate, Date actualDeturnDate, String status) {
		super();
		this.id = id;
		this.userId = userId;
		this.bookId = bookId;
		this.lendDate = lendDate;
		this.estimateReturnDate = estimateReturnDate;
		this.actualDeturnDate = actualDeturnDate;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public Date getLendDate() {
		return lendDate;
	}

	public void setLendDate(Date lendDate) {
		this.lendDate = lendDate;
	}

	public Date getEstimateReturnDate() {
		return estimateReturnDate;
	}

	public void setEstimateReturnDate(Date estimateReturnDate) {
		this.estimateReturnDate = estimateReturnDate;
	}

	public Date getActualDeturnDate() {
		return actualDeturnDate;
	}

	public void setActualDeturnDate(Date actualDeturnDate) {
		this.actualDeturnDate = actualDeturnDate;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "SysLend [id=" + id + ", userId=" + userId + ", bookId=" + bookId + ", lendDate=" + lendDate + ", status=" +status
				+ ", estimateReturnDate=" + estimateReturnDate + ", actualDeturnDate=" + actualDeturnDate + "]";
	}	

	

}
