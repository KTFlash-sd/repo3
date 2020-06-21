package cn.kgc.tangcco.guomingchao.grade.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.kgc.tangcco.entity.Grade;
import cn.kgc.tangcco.guomingchao.grade.service.imp.GradeServiceImp;
import cn.kgc.tangcco.util.Utils;

/**
 * Servlet implementation class AddGradeServlet
 */
public class AddGradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GradeServiceImp gradeservice = new GradeServiceImp();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddGradeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String Lid = request.getParameter("Lid");
		String Sid = request.getParameter("Sid");
		String Gscore = request.getParameter("Gscore");
		String Gtime = request.getParameter("Gtime");
		String Gstate = request.getParameter("Gstate");
		String Gdel = request.getParameter("Gdel");
		Date gtime = Utils.StringtoDate(Gtime.trim());
		Grade grade = new Grade(-1, Integer.parseInt(Lid), Integer.parseInt(Sid), Integer.parseInt(Gscore), gtime,
				Integer.parseInt(Gstate), Integer.parseInt(Gdel));
		String message = gradeservice.addgrade(grade);
		request.setAttribute("message", message);
		request.getRequestDispatcher("/grade/showmessage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
