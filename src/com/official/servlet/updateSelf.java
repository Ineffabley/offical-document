package com.official.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.official.bean.Users;
import com.official.util.DBUtil;

import sun.management.counter.Variability;

/**
 * Servlet implementation class updateSelf
 */
@WebServlet("/updateSelf")
public class updateSelf extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		Users user=new Users();
		user.setUsername(username);
		user.setPassword(password);
		if(DBUtil.updatePwd(user))
			response.getWriter().write("yes");
		else
			response.getWriter().write("no");
	}

}
