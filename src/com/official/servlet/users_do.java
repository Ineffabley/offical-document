package com.official.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.official.bean.Users;
import com.official.util.DBUtil;
import com.sun.swing.internal.plaf.metal.resources.metal;

/**
 * Servlet implementation class users_do
 */
@WebServlet("/users_do")
public class users_do extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String method=request.getParameter("method");
		int id=Integer.parseInt(request.getParameter("id"));
		Users user=new Users();
		user.setId(id);
		if(method.equals("delete"))
		{
			if(DBUtil.delete_user(user))
				response.getWriter().write("yes");
			else
				response.getWriter().write("no");
		}
		else if(method.equals("pause"))
		{
			int status=Integer.parseInt(request.getParameter("status"));
			if(status==0)
				status=1;
			else {
				status=0;
			}
			user.setStatus(status);
			if(DBUtil.update_userstatus(user))
				response.getWriter().write(status);
			else
				response.getWriter().write("no");
		}
		else {
			response.sendRedirect("editUserInfo?id="+id);
		}
	}

}
