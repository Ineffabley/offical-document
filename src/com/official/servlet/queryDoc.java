package com.official.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.official.bean.Doc;
import com.official.util.DBUtil;

/**
 * Servlet implementation class queryDoc
 */
@WebServlet("/queryDoc")
public class queryDoc extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String type=request.getParameter("type");
		if(type.equals("all"))
		{
			ArrayList<Doc> list=DBUtil.getDoces("all");
			request.setAttribute("list", list);
			request.getRequestDispatcher("querydoc.jsp").forward(request, response);
		}
		else
		{
			String value=request.getParameter("value");
			System.out.println(value);
			ArrayList<Doc> list=DBUtil.getDocesByCase(type,value);
			request.setAttribute("list", list);
			request.getRequestDispatcher("querydoc.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
