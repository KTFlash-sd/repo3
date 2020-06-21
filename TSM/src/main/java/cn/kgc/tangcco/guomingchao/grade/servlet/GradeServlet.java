package cn.kgc.tangcco.guomingchao.grade.servlet;

import java.util.Date;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.kgc.tangcco.entity.Grade;
import cn.kgc.tangcco.guomingchao.grade.service.imp.GradeServiceImp;
import cn.kgc.tangcco.util.MyServlet;
import cn.kgc.tangcco.util.PageBean;
import cn.kgc.tangcco.util.Utils;

@WebServlet("/gradeservlet")
public class GradeServlet extends MyServlet {

	private static final long serialVersionUID = 4044632927278413389L;
	private GradeServiceImp gradeservice = new GradeServiceImp();

	/**
	 * 分页查询，查询所有成绩
	 * 
	 * @param request
	 * @param response
	 */
	protected void querypage(HttpServletRequest request, HttpServletResponse response) {
		PageBean pagebean = new PageBean();
		String thispage = request.getParameter("thispage");
		List<Grade> grades = gradeservice.querypage(pagebean, thispage);
		for (Grade grade : grades) {
			System.out.println(grade);
		}
		request.setAttribute("grade", grades);
		request.setAttribute("pagebean", pagebean);
		System.out.println("1");
		forward("/grade/gradelist.jsp", request, response);
	}

	/**
	 * 分页查询，查询所有（已启用）成绩Gstate=1 and Gdel=1
	 * 
	 * @param request
	 * @param response
	 */
	protected void querypage1(HttpServletRequest request, HttpServletResponse response) {
		PageBean pagebean = new PageBean();
		String thispage = request.getParameter("thispage");
		List<Grade> grades = gradeservice.querypage1(pagebean, thispage);
		request.setAttribute("grade", grades);
		request.setAttribute("pagebean", pagebean);
		System.out.println("2");
		forward("/grade/gradelist.jsp", request, response);
	}

	/**
	 * 分页查询，查询所有（未启用）成绩Gstate=0 and Gdel=1
	 * 
	 * @param request
	 * @param response
	 */
	protected void querypage2(HttpServletRequest request, HttpServletResponse response) {
		PageBean pagebean = new PageBean();
		String thispage = request.getParameter("thispage");
		List<Grade> grades = gradeservice.querypage2(pagebean, thispage);
		request.setAttribute("grade", grades);
		request.setAttribute("pagebean", pagebean);
		System.out.println("3");
		forward("/grade/gradelist.jsp", request, response);
	}

	/**
	 * 添加成绩
	 * 
	 * @param request
	 * @param response
	 */
	protected void add(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("4");
		String Lid = request.getParameter("Lid");
		String Sid = request.getParameter("Sid");
		String Gscore = request.getParameter("Gscore");
		String Gtime = request.getParameter("Gtime");
		Date gtime = Utils.StringtoDate(Gtime.trim());
		Grade grade = new Grade(-1, Integer.parseInt(Lid), Integer.parseInt(Sid), Integer.parseInt(Gscore), gtime, 0,
				1);
		String message = gradeservice.addgrade(grade);
		request.setAttribute("message", message);
		forward("/grade/showmessage.jsp", request, response);
	}

	/**
	 * 修改成绩
	 * 
	 * @param request
	 * @param response
	 */
	protected void update(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("5");
		String Lid = request.getParameter("Lid");
		System.out.println(Lid);
		int l = Integer.parseInt(Lid);
		String Sid = request.getParameter("Sid");
		int l1 = Integer.parseInt(Sid);
		String Gscore = request.getParameter("Gscore");
		int l2 = Integer.parseInt(Gscore);
		String Gtime = request.getParameter("Gtime");
		Date gtime = Utils.StringtoDate(Gtime.trim());
		Grade grade = new Grade(-1, l, l1, l2, gtime, 0, 1);
		String message = gradeservice.update(grade);
		System.out.println(message);
		request.setAttribute("message", message);
		forward("/grade/showmessage.jsp", request, response);
	}

	// 查询一个用户户
	protected void select(HttpServletRequest request, HttpServletResponse response) {
		String Gid = request.getParameter("Gid");
		Grade grade = gradeservice.select(Gid);
		request.setAttribute("grade", grade);
		forward("/grade/updategrade.jsp", request, response);
	}

	/**
	 * 删除成绩
	 * 
	 * @param request
	 * @param response
	 */
	protected void delete(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("6");
		String Gid = request.getParameter("Gid");
//		String Lid = request.getParameter("Lid");
		String message = gradeservice.updategrade(Integer.parseInt(Gid));
		System.out.println(message);
		request.setAttribute("message", message);
		forward("/grade/showmessage.jsp", request, response);
	}
}
