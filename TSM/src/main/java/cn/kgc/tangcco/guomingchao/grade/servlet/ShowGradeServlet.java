package cn.kgc.tangcco.guomingchao.grade.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.kgc.tangcco.entity.Grade;
import cn.kgc.tangcco.guomingchao.grade.service.imp.GradeServiceImp;
import cn.kgc.tangcco.util.PageBean;

/**
 * Servlet implementation class ShowGradeServlet
 */

public class ShowGradeServlet extends HttpServlet {

	private static final long serialVersionUID = -1206927790637063487L;
	private GradeServiceImp gradeservice = new GradeServiceImp();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowGradeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		PageBean pagebean = new PageBean();
		String thispage = request.getParameter("thispage");
		List<Grade> grades = gradeservice.querypage(pagebean, thispage);
		request.setAttribute("grade", grades);
		request.setAttribute("pagebean", pagebean);
		request.getRequestDispatcher("/grade/showgrade.jsp").forward(request, response);
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
