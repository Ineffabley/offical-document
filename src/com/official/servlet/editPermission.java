package com.official.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.official.bean.Permission;
import com.official.bean.Users;
import com.official.util.DBUtil;

import sun.management.counter.Variability;

/**
 * Servlet implementation class editPermission
 */
@WebServlet("/editPermission")
public class editPermission extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		Users user=new Users();
		user.setId(id);
		Users newuser=DBUtil.getUserById(user);
		Permission permission=new Permission();
		permission.setId(newuser.getPermissionId());
		ArrayList<Permission> list=DBUtil.getPermission(permission);
		request.setAttribute("list", list);
		request.getRequestDispatcher("editPermission.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		int permission=Integer.parseInt(request.getParameter("permission"));
		Permission permission2=new Permission();
		permission2.setId(id);
		permission2.setPermission(permission);
		String method=request.getParameter("method");
		if(method.equals("delete"))
		{
			if(DBUtil.deletePermission(permission2))
				response.getWriter().write("yes");
			else
				response.getWriter().write("no");
		}
		else {
			int newpermission=Integer.parseInt(request.getParameter("newpermission"));
			Permission permission3=new Permission();
			permission3.setId(id);
			permission3.setPermission(newpermission);
			if(DBUtil.updatePermission(permission2, permission3))
				response.getWriter().write("yes");
			else
				response.getWriter().write("no");
		}
	}

}
