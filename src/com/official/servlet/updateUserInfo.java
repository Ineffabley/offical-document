package com.official.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.User;

import com.official.bean.Users;
import com.official.util.DBUtil;

/**
 * Servlet implementation class updateUserInfo
 */
@WebServlet("/updateUserInfo")
public class updateUserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String job=request.getParameter("job");
		Users user=new Users();
		user.setId(id);
		user.setUsername(username);
		user.setPassword(password);
		user.setJob(job);
		if(DBUtil.update_user(user))
			response.getWriter().write("yes");
		else
			response.getWriter().write("no");
	}

}
