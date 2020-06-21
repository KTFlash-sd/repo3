package cn.kgc.tangcco.util;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//Servlet第4代
public class MyServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8026071676051293836L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			String method = request.getParameter("method");
			
			if (method != null) {
				Class clazz = this.getClass();
				Method m = clazz.getDeclaredMethod(method, HttpServletRequest.class, HttpServletResponse.class);
				m.setAccessible(true);
				m.invoke(this, request, response);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	//转发的公共方法
	protected void forward(String path,HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getRequestDispatcher(path).forward(request,response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
