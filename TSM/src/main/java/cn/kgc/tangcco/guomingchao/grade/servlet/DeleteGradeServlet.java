package cn.kgc.tangcco.guomingchao.grade.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.kgc.tangcco.guomingchao.grade.service.imp.GradeServiceImp;

/**
 * Servlet implementation class DeleteGradeServlet
 */
public class DeleteGradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GradeServiceImp gradeservice = new GradeServiceImp();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteGradeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		String Sid = request.getParameter("Sid");
//		String Lid = request.getParameter("Lid");
		String Gid = request.getParameter("Gid");
//		String message = gradeservice.updategrade(Integer.parseInt(Sid), Integer.parseInt(Lid));
		String message = gradeservice.updategrade(Integer.parseInt(Gid));
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
