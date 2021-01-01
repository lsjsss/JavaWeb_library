package com.bms.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bms.constant.Constant;
import com.bms.entity.SysBook;
import com.bms.entity.SysLend;
import com.bms.entity.SysUser;
import com.bms.service.ISysBookService;
import com.bms.service.ISysLendService;
import com.bms.service.ISysUserService;
import com.bms.service.impl.SysBookServiceImpl;
import com.bms.service.impl.SysLendServiceImpl;
import com.bms.service.impl.SysUserServiceImpl;

@WebServlet("/lend.do")
public class LendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ISysUserService userService = new SysUserServiceImpl();
	private ISysBookService bookService = new SysBookServiceImpl();
	private ISysLendService lendService = new SysLendServiceImpl();

	public LendServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 处理乱码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String type = request.getParameter("type");
		String bookId = request.getParameter("bookId");
		String userId = request.getParameter("userId");
		String roleId = request.getParameter("roleId");
		String lendId = request.getParameter("lendId");
		String adminUserId = request.getParameter("adminUserId");

		if (type.equals("lend")) {
			lend(request, response, userId, roleId, bookId);
		} else if (type.equals("mylend")) {
			getAll(request, response, userId);
		} else if (type.equals("getAll")) {
			getAll(request, response, userId);
		} else if (type.equals("returnBook")) {
			returnBook(request, response, lendId, userId, bookId);
		} else if (type.equals("ForcedreturnBook")) {
			ForcedreturnBook(request, response, lendId, userId, bookId, roleId, adminUserId);
		} else if (type.equals("alllend")) {
			alllend(request, response, roleId, userId);
		}
	}

	private void alllend(HttpServletRequest request, HttpServletResponse response, String roleId, String userId)
			throws ServletException, IOException {
		List<SysLend> lendList = this.lendService.getAll();
		List<SysBook> bookList = this.bookService.getAll();
		List<SysUser> userList = this.userService.getAll();
		request.setAttribute("lendList", lendList);
		request.setAttribute("bookList", bookList);
		request.setAttribute("userList", userList);
		request.setAttribute("roleId", roleId);
		request.setAttribute("userId", userId);
		request.getRequestDispatcher("/pages/book/alllend.jsp").forward(request, response);
	}

	private void lend(HttpServletRequest request, HttpServletResponse response, String userId, String roleId,
			String bookId) throws ServletException, IOException {
		this.bookService.lend(bookId);
		this.bookService.addLend(userId, roleId, bookId);
		System.out.println(Constant.TIME.format(new Date()) + "用户借阅图书 -- 用户id:" + userId + "; 用户类型:" + roleId + "; 图书id:" + bookId);
		// 跳转
		getAll(request, response, userId);
	}

	private void ForcedreturnBook(HttpServletRequest request, HttpServletResponse response, String lendId,
			String userId, String bookId, String roleId, String adminUserId) throws ServletException, IOException {
		this.bookService.returnBook(bookId);
		this.bookService.returnLend(lendId, userId, bookId);
		System.out.println(Constant.TIME.format(new Date()) + "管理员修改用户借阅状态 -- 管理员用户id:" + adminUserId + "; 借阅id:" + lendId + "; 用户id:"
				+ userId + "; 图书id:" + bookId);
		// 跳转
		alllend(request, response, roleId, adminUserId);
	}

	private void returnBook(HttpServletRequest request, HttpServletResponse response, String lendId, String userId,
			String bookId) throws ServletException, IOException {
		this.bookService.returnBook(bookId);
		this.bookService.returnLend(lendId, userId, bookId);
		System.out.println(Constant.TIME.format(new Date()) + "用户归还图书 -- 借阅id:" + lendId + "; 用户id:" + userId + "; 图书id:" + bookId);
		// 跳转
		getAll(request, response, userId);
	}

	private void getAll(HttpServletRequest request, HttpServletResponse response, String userId)
			throws ServletException, IOException {
		List<SysLend> lendList = this.lendService.getAll();
		List<SysBook> bookList = this.bookService.getAll();
		List<SysUser> userList = this.userService.getAll();
		request.setAttribute("lendList", lendList);
		request.setAttribute("bookList", bookList);
		request.setAttribute("userList", userList);
		request.setAttribute("userId", userId);
		request.getRequestDispatcher("/pages/book/mylend.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
