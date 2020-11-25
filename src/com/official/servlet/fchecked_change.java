package com.official.servlet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.official.bean.Doc;
import com.official.util.DBUtil;

/**
 * Servlet implementation class fchecked_change
 */
@WebServlet("/fchecked_change")
public class fchecked_change extends HttpServlet {
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
		int result=Integer.parseInt(request.getParameter("result"));
		String tip=request.getParameter("tip");
		Date date = new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
		String time=dateFormat.format(date).toString();
		String path="G:\\Users\\Administrator\\eclipse-workspace\\official-document\\WebContent\\tip2\\"+id+"_"+time+"_tip.txt";
		File file = new File(path);
        FileOutputStream fileOutputStream;
        
		int status;
		if(result==0)
			status=7;
		else
			status=6;
		Doc doc=new Doc();
		doc.setId(id);
		doc.setResult(result);
		doc.setStatus(status);
		doc.setReceiver("办公室");
		doc.setFtipplace(path);
		if(DBUtil.fchecked_change(doc))
		{
			try {
				fileOutputStream = new FileOutputStream(file);
				 try {
					fileOutputStream.write((tip).getBytes());
					fileOutputStream.close();
					response.getWriter().write("yes");
					
				} catch (IOException e) {
					// TODO �Զ����ɵ� catch ��
					response.getWriter().write("no");
					e.printStackTrace();
				}
				
			} catch (FileNotFoundException e) {
				// TODO �Զ����ɵ� catch ��
				response.getWriter().write("no");
				e.printStackTrace();
			}
		}
		else
			response.getWriter().write("no");
		
	}

}
