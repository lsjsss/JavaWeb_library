package com.bms.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bms.constant.Constant;
import com.bms.entity.SysBook;
import com.bms.entity.SysUser;
import com.bms.service.ISysBookService;
import com.bms.service.ISysUserService;
import com.bms.service.impl.SysBookServiceImpl;
import com.bms.service.impl.SysUserServiceImpl;

@WebServlet("/user.do")
public class SysUserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private ISysUserService userService = new SysUserServiceImpl();
	private ISysBookService bookService = new SysBookServiceImpl();

	public SysUserServlet() {
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
		String loginName = request.getParameter("loginName");
		String realName = request.getParameter("realName");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		String roleId = request.getParameter("roleId");

		if (type.equals("login")) {
			login(request, response, session, loginName, password);
		} else if (type.equals("logout")) {
			logout(request, response, session);
		} else if (type.equals("getAll")) {
			getAll(request, response);
		} else if (type.equals("reg")) {
			reg(request, response, session, loginName, realName, password, confirmPassword, roleId);
		} else if (type.equals("add")) {
			add(request, response, loginName, realName, password, roleId);
		} else if (type.equals("edit")) {
			edit(request, response, id, loginName, realName);
		} else if (type.equals("get")) {
			get(request, response, id);
		} else if (type.equals("delete")) {
			delete(request, response, id);
		}
	}

	private void delete(HttpServletRequest request, HttpServletResponse response, String id)
			throws ServletException, IOException {
		int ret = this.userService.delete(id);
		boolean isSuccess = false;
		if (ret == 1) {
			request.setAttribute("msg", "删除成功！");
			System.out.println(Constant.TIME.format(new Date()) + "管理员删除用户 -- 用户id:" + id);
			isSuccess = true;
		} else {
			request.setAttribute("msg", "删除失败！");
		}
		// 跳转
		if (isSuccess) {
			request.getRequestDispatcher("/pages/user/usersuccessresult.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/pages/user/userloseresult.jsp").forward(request, response);
		}
	}

	private void get(HttpServletRequest request, HttpServletResponse response, String id)
			throws ServletException, IOException {
		SysUser user = this.userService.get(id);
		if(id.equals("1") || id.equals("2") || id.equals("3")) {
			// 跳转到用户列表
			getAll(request, response);
		} else {
			request.setAttribute("user", user);
			// 跳转
			request.getRequestDispatcher("/pages/user/edituser.jsp").forward(request, response);
		}
	}

	private void edit(HttpServletRequest request, HttpServletResponse response, String id, String loginName,
			String realName) throws ServletException, IOException {
		// 用于判断是否为整型数据
		if (loginName.equals("") || realName.equals("")) {
			if (loginName.equals("")) {
				request.setAttribute("reg1", "账号不能为空！");
				request.setAttribute("isSuccess1", 1);
			}
			if (realName.equals("")) {
				request.setAttribute("reg2", "姓名不能为空！");
				request.setAttribute("isSuccess2", 2);
			}
			get(request, response, id);
		} else {
			this.userService.edit(id, loginName, realName);
			request.setAttribute("reg", "编辑成功！");
			request.setAttribute("isSuccess", 0);
			System.out.println(
					Constant.TIME.format(new Date()) + "管理员修改用户信息 -- 用户名: " + loginName + "; 真实姓名:" + realName);

			// 跳转到用户列表
			getAll(request, response);
		}
	}

	private void logout(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws IOException, ServletException {
		System.out.println(Constant.TIME.format(new Date()) + "用户登出　--" + session.getAttribute("loginUser"));
		session.removeAttribute("loginUser");
		session.invalidate();

		List<SysBook> bookList = this.bookService.getAll();
		request.setAttribute("bookList", bookList);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	private void login(HttpServletRequest request, HttpServletResponse response, HttpSession session, String loginName,
			String password) throws ServletException, IOException {
		// 登录处理
		SysUser loginUser = this.userService.login(loginName, password);
		if (loginUser != null) {
			session.setAttribute("loginUser", loginUser);
			System.out.println(Constant.TIME.format(new Date()) + "用户登录 -- 用户名:" + loginUser.getLoginName());

			List<SysBook> bookList = this.bookService.getAll();
			request.setAttribute("bookList", bookList);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} else {
			response.sendRedirect("login.jsp");
		}
	}

	private void add(HttpServletRequest request, HttpServletResponse response, String loginName, String realName,
			String password, String roleId) throws ServletException, IOException {
		boolean flag = this.userService.isExits(loginName);
		boolean isSuccess = false;
		if (!flag) {
			if (loginName.equals("")) {
				request.setAttribute("reg", "添加用户失败，用户名不能为空！");
			} else {
				if (realName.equals("")) {
					request.setAttribute("reg", "添加用户失败，真实姓名不能为空！");
				} else {
					if (roleId.equals("")) {
						request.setAttribute("reg", "添加用户失败，请选择用户属性！");
					} else {
						request.setAttribute("reg", "添加用户成功！");
						isSuccess = true;
						System.out.println(Constant.TIME.format(new Date()) + "管理员添加用户 -- 用户名:" + loginName + "; 姓名:"
								+ realName + "; 用户类型" + roleId);
						this.userService.add(loginName, realName, Constant.DEFAULT_PASSWORD, roleId);
					}
				}
			}
		} else {
			request.setAttribute("reg", "注册失败,存在同名用户！");
		}

		// 跳转
		if (isSuccess) {
			request.getRequestDispatcher("/pages/user/usersuccessresult.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/pages/user/userloseresult.jsp").forward(request, response);
		}

	}

	private void reg(HttpServletRequest request, HttpServletResponse response, HttpSession session, String loginName,
			String realName, String password, String confirmPassword, String roleId)
			throws ServletException, IOException {
		boolean flag = this.userService.isExits(loginName);

		// 新版登录
		if (flag || loginName.equals("") || realName.equals("") || roleId.equals("") || password.equals("")
				|| password.length() < 8 || confirmPassword.equals("") || (password.equals(confirmPassword) == false)) {
			if (loginName.equals("")) {
				request.setAttribute("reg1", "用户名不能为空！");
				request.setAttribute("isSuccess1", 1);
			}
			if (flag) {
				request.setAttribute("reg1", "存在同名用户，请更换用户名！");
				request.setAttribute("isSuccess1", 1);
			}
			if (realName.equals("")) {
				request.setAttribute("reg2", "真实姓名不能为空！");
				request.setAttribute("isSuccess2", 2);
			}
			if (roleId.equals("")) {
				request.setAttribute("reg3", "请选择用户属性！");
				request.setAttribute("isSuccess3", 3);
			}
			if (password.equals("")) {
				request.setAttribute("reg4", "请输入密码！");
				request.setAttribute("isSuccess4", 4);
			} else if (password.length() < 8) {
				request.setAttribute("reg4", "密码长度应大于或等于8位！");
				request.setAttribute("isSuccess4", 4);
			}
			if (confirmPassword.equals("")) {
				request.setAttribute("reg5", "请确认密码！");
				request.setAttribute("isSuccess5", 5);
			} else if (password.equals(confirmPassword) == false) {
				if (password.equals("")) {
					request.setAttribute("reg5", "请先输入密码！");
					request.setAttribute("isSuccess5", 5);
				} else {
					request.setAttribute("reg5", "两次输入的密码不一致！");
					request.setAttribute("isSuccess5", 5);
				}
			}
		} else {
			request.setAttribute("reg", "注册成功！");
			request.setAttribute("isSuccess", 0);
			this.userService.add(loginName, realName, password, roleId);

			// 自动登录
			SysUser loginUser = this.userService.login(loginName, password);
			session.setAttribute("loginUser", loginUser);
			System.out.println(Constant.TIME.format(new Date()) + "新注册用户 -- 用户名:" + loginUser.getLoginName() + "; 姓名:"
					+ loginUser.getRealName() + "; 用户类型:" + loginUser.getRoleId());

			// 跳转到图书列表
			List<SysBook> bookList = this.bookService.getAll();
			request.setAttribute("bookList", bookList);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}

		///////////////////////////////////////////////////////////////////////
//旧版登录
//		if (!flag) {
//			 if (loginName.equals("")) {
//				request.setAttribute("reg", "注册失败，用户名不能为空！");
//				request.setAttribute("isSuccess", 1);
//			} else {
//				if (realName.equals("")) {
//					request.setAttribute("reg", "注册失败，真实姓名不能为空！");
//					request.setAttribute("isSuccess", 2);
//				} else {
//					if (roleId.equals("")) {
//						request.setAttribute("reg", "注册失败，请选择用户属性！");
//						request.setAttribute("isSuccess", 3);
//					} else {
//						if (password.equals("")) {
//							request.setAttribute("reg", "注册失败，请输入密码！");
//							request.setAttribute("isSuccess", 4);
//						} else {
//							if (confirmPassword.equals("")) {
//								request.setAttribute("reg", "注册失败，请确认密码！");
//								request.setAttribute("isSuccess", 5);
//							} else {
//								if (password.equals(confirmPassword)) {
//									request.setAttribute("reg", "注册成功！");
//									request.setAttribute("isSuccess", 0);
////									isSuccess = true;
//									this.userService.add(loginName, realName, password, roleId);
//									
//									//自动登录
//									SysUser loginUser = this.userService.login(loginName, password);
//									System.out.println(loginUser.getLoginName());
//									session.setAttribute("loginUser", loginUser);
//									
//									//跳转到图书列表
//									List<SysBook> bookList = this.bookService.getAll();
//									request.setAttribute("bookList", bookList);
//									request.getRequestDispatcher("/index.jsp").forward(request, response);
//								} else {
//									request.setAttribute("reg", "注册失败，两次输入的密码不一致！");
//									request.getRequestDispatcher("/reg.jsp").forward(request, response);
//								}
//							}
//						}
//					}
//				}
//			}
//		} 
//		else {
//			request.setAttribute("reg", "注册失败,存在同名用户！");
////			request.getRequestDispatcher("/reg.jsp").forward(request, response);
//		}
//		request.getRequestDispatcher("/reg.jsp").forward(request, response);
	}

	private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取所有用户
		List<SysUser> userList = this.userService.getAll();
		request.setAttribute("userList", userList);
		request.getRequestDispatcher("/pages/user/users.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
