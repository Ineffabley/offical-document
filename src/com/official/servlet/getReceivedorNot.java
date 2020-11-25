package com.official.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.official.bean.Doc;
import com.official.bean.Users;
import com.official.util.DBUtil;

/**
 * Servlet implementation class getReceivedorNot
 */
@WebServlet("/getReceivedorNot")
public class getReceivedorNot extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=request.getParameter("user");
		String type=request.getParameter("type");
		Users user=new Users();
		user.setUsername(username);
		System.out.println(user.getUsername());
		ArrayList<Doc> list=DBUtil.getReceivedByUser(type, user);
		request.setAttribute("list", list);
		request.getRequestDispatcher("receive.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
