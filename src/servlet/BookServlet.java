package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sj.bms.entity.SysBook;
import com.sj.bms.service.ISysBookService;
import com.sj.bms.service.impl.SysBookServiceImpl;

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
//		int bookNumbers = Integer.valueOf(request.getParameter("bookNumbers"));
//		int lendedNumber = Integer.valueOf(request.getParameter("lendedNumber"));
//		int reaminNumber = bookNumbers - lendedNumber;
		
		if(type.equals("getAll")) {
			List<SysBook> bookList = this.bookService.getAll();
			request.setAttribute("bookList", bookList);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} else if(type.equals("bookManage")) {
			List<SysBook> bookList = this.bookService.getAll();
			request.setAttribute("bookList", bookList);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
