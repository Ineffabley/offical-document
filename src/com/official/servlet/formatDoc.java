package com.official.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.official.bean.Doc;
import com.official.util.DBUtil;

/**
 * Servlet implementation class formatDoc
 */
@WebServlet("/formatDoc")
public class formatDoc extends HttpServlet {
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
		int status=Integer.parseInt(request.getParameter("status"));
		if(status==-1)
		{
			status=0;
			Doc doc=new Doc();
			doc.setId(id);
			doc.setStatus(status);
			if(DBUtil.formatDoc(doc))
				response.getWriter().write("yes");
			else
				response.getWriter().write("no");
		}
		else
			response.getWriter().write("no");
		
	}

}
