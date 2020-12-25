package com.bms.servlet;

import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bms.entity.SysBook;
import com.bms.entity.SysRole;
import com.bms.entity.SysUser;
import com.bms.service.ISysBookService;
import com.bms.service.impl.SysBookServiceImpl;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/book.do")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ISysBookService bookService = new SysBookServiceImpl();

	public BookServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 处理乱码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		HttpSession session = request.getSession();

		// 获取参数
		String type = request.getParameter("type");
		String id = request.getParameter("id");
		String bookName = request.getParameter("bookName");
		String author = request.getParameter("author");
		String publisher = request.getParameter("publisher");
		
		if(type.equals("getAll")) {
			getAll(request, response);
		} else if(type.equals("bookManage")) {
			getAll(request, response);
		} else if(type.equals("get")) {
			get(request, response, id);
		} else if(type.equals("edit")) {
			edit(request, response, id, bookName, author, publisher, request.getParameter("bookNumbers"));
		}
	}

	private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<SysBook> bookList = this.bookService.getAll();
		request.setAttribute("bookList", bookList);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	private void edit(HttpServletRequest request, HttpServletResponse response, String id, String bookName,
			String author, String publisher, String bookNumbers) throws ServletException, IOException {
		//用于判断是否为整型数据
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
		if (bookName.equals("") || author.equals("")||
				publisher.equals("") || (bookNumbers+"").equals("")
				|| (!pattern.matcher(bookNumbers+"").matches())
				) {
			if (bookName.equals("")) {
				request.setAttribute("reg1", "书名不能为空！");
				request.setAttribute("isSuccess1", 1);
			}
			if (author.equals("")) {
				request.setAttribute("reg2", "作者不能为空！");
				request.setAttribute("isSuccess2", 2);
			}
			if (publisher.equals("")) {
				request.setAttribute("reg3", "出版社不能为空！");
				request.setAttribute("isSuccess3", 3);
			}
			if (bookNumbers.equals("")) {
				request.setAttribute("reg4", "图书数量不能为空！");
				request.setAttribute("isSuccess4", 4);
			} else if(!pattern.matcher(bookNumbers).matches()) {
				request.setAttribute("reg4", "请输入合法数据！");
				request.setAttribute("isSuccess4", 4);
			}
			get(request, response, id);
		} else {
			int ibookNumbers = Integer.valueOf(request.getParameter("bookNumbers"));
			int ret = this.bookService.edit(id, bookName, author, publisher, ibookNumbers);
			request.setAttribute("reg", "编辑成功！");
			request.setAttribute("isSuccess", 0);
			
			
			// 跳转到图书列表
			List<SysBook> bookList = this.bookService.getAll();
			request.setAttribute("bookList", bookList);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		
//		request.getRequestDispatcher("/pages/book/editbook.jsp").forward(request, response);
//		get(request, response, id);
		
		
		
		
		
		//跳转
//		request.getRequestDispatcher("/pages/book/bookresult.jsp").forward(request, response);
	}

	private void get(HttpServletRequest request, HttpServletResponse response, String id) throws ServletException, IOException {
		SysBook book = this.bookService.get(id);
		request.setAttribute("book", book);
		//跳转
		request.getRequestDispatcher("/pages/book/editbook.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
