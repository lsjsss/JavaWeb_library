package com.bms.servlet;

import java.awt.print.Book;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bms.entity.SysBook;
import com.bms.entity.SysUser;
import com.bms.service.ISysBookService;
import com.bms.service.ISysUserService;
import com.bms.service.impl.SysBookServiceImpl;
import com.bms.service.impl.SysUserServiceImpl;

@WebServlet("/lend.do")
public class LendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ISysUserService userService = new SysUserServiceImpl();
	private ISysBookService bookService = new SysBookServiceImpl();

	public LendServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 处理乱码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		HttpSession session = request.getSession();

		String type = request.getParameter("type");
		String id = request.getParameter("id");
		String userId = request.getParameter("userId");
		String bookId = request.getParameter("bookId");
		String lendId = request.getParameter("lendId");

		if (type.equals("lend")) {
//				if(!id.equals("")&&id!=null) {
//					SysUser user = userService.get(id);
//					if(user==null) {
//						request.setAttribute("msg","用户不存在");
//					}else {
			this.bookService.lend(id);
			this.bookService.addLend(userId, bookId);
			//跳转
			request.getRequestDispatcher("/pages/book/mylend.jsp").forward(request, response);

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
