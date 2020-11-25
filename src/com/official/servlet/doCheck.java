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
 * Servlet implementation class doCheck
 */
@WebServlet("/doCheck")
public class doCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		Doc d=new Doc();
		d.setId(Integer.parseInt(id));
		Doc doc=DBUtil.getDocById(d);
		request.setAttribute("doc", doc);
		System.out.println(doc.getId());
		request.getRequestDispatcher("writecheck.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
