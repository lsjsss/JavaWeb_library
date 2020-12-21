package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sj.bms.constant.Constant;
import com.sj.bms.entity.SysUser;
import com.sj.bms.service.ISysRoleService;
import com.sj.bms.service.ISysUserService;
import com.sj.bms.service.impl.SysRoleServiceImpl;
import com.sj.bms.service.impl.SysUserServiceImpl;

@WebServlet("/user.do")
public class SysUserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private ISysUserService userService = new SysUserServiceImpl();
	private ISysRoleService roleService = new SysRoleServiceImpl();

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
		String loginName = request.getParameter("loginName");
		String realName = request.getParameter("realName");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		String roleId = request.getParameter("roleId");

		if(type.equals("login")) {
			login(request, response, session, loginName, password);
		} else if(type.equals("logout")) {
			logout(response, session);
		} else if (type.equals("getAll")) {
			getAll(request, response);
		} else if (type.equals("reg")) {
			reg(request, response, loginName, realName, password, confirmPassword, roleId);
		} else if (type.equals("add")) {
			add(request, response, loginName, realName, password, roleId);
		}
	}

	private void logout(HttpServletResponse response, HttpSession session) throws IOException {
		session.removeAttribute("loginUser");
		session.invalidate();
		response.sendRedirect("index.jsp");
	}

	private void login(HttpServletRequest request, HttpServletResponse response, HttpSession session, String loginName,
			String password) throws ServletException, IOException {
		//登录处理
				SysUser loginUser = this.userService.login(loginName, password);
				if(loginUser != null) {
					System.out.println(loginUser.getLoginName());
					session.setAttribute("loginUser", loginUser);
					
//					List<Message> messageList = this.messageService.getAll();
//					request.setAttribute("messageList", messageList);
					System.out.println("welcome");
					request.getRequestDispatcher("/index.jsp").forward(request, response);	
				}else {
					response.sendRedirect("login.jsp");
				}
		
	}

	private void add(HttpServletRequest request, HttpServletResponse response, String loginName, String realName,
			String password, String roleId) throws ServletException, IOException {
		boolean flag = this.userService.isExits(loginName);
		boolean isSuccess = false;
		if (!flag) {
			if (loginName.equals("")) {
				request.setAttribute("msg", "添加用户失败，用户名不能为空！");
			} else {
				if (realName.equals("")) {
					request.setAttribute("msg", "添加用户失败，真实姓名不能为空！");
				} else {
					if (roleId.equals("")) {
						request.setAttribute("msg", "添加用户失败，请选择用户属性！");
					} else {
						request.setAttribute("msg", "添加用户成功！");
						isSuccess = true;
						this.userService.add(loginName, realName, Constant.DEFAULT_PASSWORD, roleId);
					}
				}
			}
		} else {
			request.setAttribute("msg", "注册失败,存在同名用户！");
		}

		// 跳转
		if (isSuccess) {
			request.getRequestDispatcher("/pages/user/usersuccessresult.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/pages/user/userloseresult.jsp").forward(request, response);
		}

	}

	private void reg(HttpServletRequest request, HttpServletResponse response, String loginName, String realName,
			String password, String confirmPassword, String roleId) throws ServletException, IOException {
		boolean flag = this.userService.isExits(loginName);
		boolean isSuccess = false;
		if (!flag) {
			if (loginName.equals("")) {
				request.setAttribute("msg", "注册失败，用户名不能为空！");
			} else {
				if (realName.equals("")) {
					request.setAttribute("msg", "注册失败，真实姓名不能为空！");
				} else {
					if (roleId.equals("")) {
						request.setAttribute("msg", "注册失败，请选择用户属性！");
					} else {
						if (password.equals("")) {
							request.setAttribute("msg", "注册失败，请输入密码！");
						} else {
							if (confirmPassword.equals("")) {
								request.setAttribute("msg", "注册失败，请确认密码！");
							} else {
								if (password.equals(confirmPassword)) {
									request.setAttribute("msg", "注册成功！");
									isSuccess = true;
									this.userService.add(loginName, realName, password, roleId);
								} else {
									request.setAttribute("msg", "注册失败，两次输入的密码不一致！");
								}
							}
						}
					}
				}
			}
		} else {
			request.setAttribute("msg", "注册失败,存在同名用户！");
		}
		// 跳转
		if (isSuccess) {
			request.getRequestDispatcher("/regsuccessresult.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/regloseresult.jsp").forward(request, response);
		}
	}

	private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取所有角色
		List<SysUser> userList = this.userService.getAll();
		request.setAttribute("userList", userList);
		request.getRequestDispatcher("/pages/user/users.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
