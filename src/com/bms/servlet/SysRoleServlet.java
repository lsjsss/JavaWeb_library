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
import com.bms.entity.SysRole;
import com.bms.service.ISysRoleService;
import com.bms.service.impl.SysRoleServiceImpl;

@WebServlet("/role.do")
public class SysRoleServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private ISysRoleService roleService = new SysRoleServiceImpl();

	public SysRoleServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 处理乱码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// 获取参数
		String type = request.getParameter("type");
		String id = request.getParameter("id");
		String roleName = request.getParameter("roleName");
		String remark = request.getParameter("remark");

		if (type.equals("getAll")) {
			getAll(request, response);
		} else if (type.equals("add")) {
			add(request, response, roleName, remark);
		} else if (type.equals("delete")) {
			delete(request, response, id);
		} else if (type.equals("get")) {
			get(request, response, id);
		} else {
			edit(request, response, id, roleName, remark);
		}

	}

	private void edit(HttpServletRequest request, HttpServletResponse response, String id, String roleName,
			String description) throws ServletException, IOException {
		int ret = this.roleService.edit(id, roleName, description);
		if (ret == 1) {
			request.setAttribute("msg", "编辑角色成功！");
			System.out.println(Constant.TIME.format(new Date()) + "管理员修改角色 -- 角色id:" + id + "; 角色名称:" + roleName);
		} else {
			request.setAttribute("msg", "编辑橘角色失败！");
		}
		// 跳转
		request.getRequestDispatcher("/pages/role/roleresult.jsp").forward(request, response);
	}

	private void get(HttpServletRequest request, HttpServletResponse response, String id)
			throws ServletException, IOException {
		SysRole role = this.roleService.get(id);
		request.setAttribute("role", role);
		// 跳转
		request.getRequestDispatcher("/pages/role/editrole.jsp").forward(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response, String id)
			throws ServletException, IOException {
		int ret = 0;
		if (id.equals("1")) {
			request.setAttribute("msg", "删除失败！");
		} else {
			ret = this.roleService.delete(id);
		}
		if (ret == 1) {
			request.setAttribute("msg", "删除成功！");
			System.out.println(Constant.TIME.format(new Date()) + "管理员删除角色 -- 角色id:" + id);
		} else {
			request.setAttribute("msg", "删除失败！");
		}
		// 跳转
		request.getRequestDispatcher("/pages/role/roleresult.jsp").forward(request, response);
	}

	private void add(HttpServletRequest request, HttpServletResponse response, String roleName, String description)
			throws ServletException, IOException {
		// 添加角色
		SysRole role = this.roleService.getSysRoleByRoleName(roleName);
		if (role == null) {
			int newId = this.roleService.add(roleName, description);
			if (newId > 0) {
				request.setAttribute("msg", "添加成功！");
				System.out.println(Constant.TIME.format(new Date()) + "管理员添加角色 -- 角色名称" + roleName);
			} else {
				request.setAttribute("msg", "添加失败！");
			}
		} else {
			request.setAttribute("msg", "添加失败，角色已经存在！");
		}
		// 跳转
		request.getRequestDispatcher("/pages/role/roleresult.jsp").forward(request, response);
	}

	private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取所有角色
		List<SysRole> roleList = this.roleService.getAll();
		// 将数据放到请求域中
		request.setAttribute("roleList", roleList);
		// 跳转
		request.getRequestDispatcher("/pages/role/roles.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
