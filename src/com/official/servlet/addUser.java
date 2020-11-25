package com.official.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.User;

import com.official.bean.Users;
import com.official.util.DBUtil;
import com.official.util.MD5Util;

/**
 * Servlet implementation class getAllUser
 */
@WebServlet("/addUser")
public class addUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*ArrayList<Users> list=DBUtil.getAllUser();
		request.setAttribute("list", list);*/
		Users user=new Users();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		 String encryptedPwd = null;
		 try {
		 encryptedPwd = MD5Util.getEncryptedPwd(password);
		 user.setPassword(encryptedPwd);

		 } catch (NoSuchAlgorithmException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 } catch (UnsupportedEncodingException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 }
		String permissionId=request.getParameter("permissionId");
		String job=request.getParameter("job");
		System.out.println("job");
		user.setJob(job);
		user.setUsername(username);
		user.setPermissionId(Integer.parseInt(permissionId));
		user.setStatus(1);
		//DBUtil.addUser(username,password,permissionId,);
		DBUtil.addUser(user);
		request.getRequestDispatcher("Usermanage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
