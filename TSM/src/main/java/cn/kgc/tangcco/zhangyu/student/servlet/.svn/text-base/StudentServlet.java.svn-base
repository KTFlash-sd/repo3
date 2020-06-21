package cn.kgc.tangcco.zhangyu.student.servlet;

import cn.kgc.tangcco.common.ObjectFactory;
import cn.kgc.tangcco.entity.Major;
import cn.kgc.tangcco.entity.Student;
import cn.kgc.tangcco.util.Constant;
import cn.kgc.tangcco.util.MyServlet;
import cn.kgc.tangcco.util.PageBean;
import cn.kgc.tangcco.zhangyu.UtilDate;
import cn.kgc.tangcco.zhangyu.major.majorservice.MajorServiceImp;
import cn.kgc.tangcco.zhangyu.student.service.StudentService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/student")
public class StudentServlet extends MyServlet {
	private static final long serialVersionUID = 1L;
	StudentService service = ObjectFactory.getInstance(Constant.SSERVICE);
MajorServiceImp se=new MajorServiceImp();
	/**
	 * Default constructor.
	 */
	public StudentServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 添加学生对象
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int Sid = -1;
		String Sname = request.getParameter("Sname");
		Date Sbirth = UtilDate.StringtoDate(request.getParameter("Sbirth"));
		String Ssex = request.getParameter("Ssex");
		String Sem = request.getParameter("Sem");
		String Sps = request.getParameter("Sps");
		String Snative = request.getParameter("Snative");
		String Smajorid = request.getParameter("Smajorid");
		int index=Integer.parseInt(Smajorid);
		String Saddress = request.getParameter("Saddress");
		String Stel = request.getParameter("Stel");
		String Sedu = request.getParameter("Sedu");
		String Sur = request.getParameter("Sur");
		String Surtel = request.getParameter("Surtel");
		String Aid = request.getParameter("Aid");
		String Mname=request.getParameter("Mname");
		Student student = new Student(Sid, Sname, Sbirth, Ssex, Sem, Sps, Snative,index, Saddress, Stel, Sedu, Sur,
				Surtel, "1", 0, 1, Mname);
		int addmessage = service.addstudent(student);
		response.getWriter().print(addmessage);

	}

	/**
	 * 分页查迅方法，只显示Sdel=1（未删除），并且Sstate=1（1=审核通过）的学员
	 * 
	 * @throws IOException
	 */
	public void querypage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String thispage = request.getParameter("thispage");
		PageBean pageBean = new PageBean();
		List<Student> list =new ArrayList<Student>();
		 list = service.querypage(pageBean, thispage);
		String text = JSON.toJSONString(list); // 把list--->jsonarray格式的字符串
		request.setAttribute("pagePean1", pageBean);
		String pagetext = JSON.toJSONString(pageBean);// 把对象转为json格式的字符串
		String value = "{\"pagebean\":" + pagetext + ",\"rows\":" + text + "}";
		response.getWriter().print(value);

	}

	/**
	 * 分页查迅方法，只显示Sdel=1（未删除），并且Sstate！=1（审核未通过）的学员
	 * 
	 * @throws IOException
	 */
	public void querypage1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String thispage = request.getParameter("thispage");
		PageBean pageBean = new PageBean();
		List<Student> list =null;
		 list = service.querypage1(pageBean, thispage);
		request.setAttribute("pagePean1", pageBean);
		String text = JSON.toJSONString(list); // 把list--->jsonarray格式的字符串
		String pagetext = JSON.toJSONString(pageBean);// 把对象转为json格式的字符串
		String value = "{\"pagebean\":" + pagetext + ",\"rows\":" + text + "}";
		response.getWriter().print(value);
	}
public void major(HttpServletRequest request, HttpServletResponse response) throws IOException {
	List<Major> list=se.queryMajors();
	String text = JSON.toJSONString(list);
	response.getWriter().print(text);
}
	

	/**
	 * 修改信息
	 * 
	 * @throws IOException
	 */
	public void update1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int Sid = Integer.parseInt(request.getParameter("Sid"));
		Student s = service.student(Sid);
		request.setAttribute("student", s);
		forward("student/studentupdate.jsp", request, response);
	}

	public void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int Sid = Integer.parseInt(request.getParameter("Sid"));
		String Sname = request.getParameter("Sname");
		Date Sbirth = UtilDate.StringtoDate(request.getParameter("Sbirth"));
		String Ssex = request.getParameter("Ssex");
		String Sem = request.getParameter("Sem");
		System.out.println(Sem);
		String Sps = request.getParameter("Sps");
		String Snative = request.getParameter("Snative");
		String Smajorid = request.getParameter("Smajorid");
		int index=Integer.parseInt(Smajorid);
		String Saddress = request.getParameter("Saddress");
		String Stel = request.getParameter("Stel");
		String Sedu = request.getParameter("Sedu");
		String Sur = request.getParameter("Sur");
		String Surtel = request.getParameter("Surtel");
		String Mname=request.getParameter("Mname");
//		String Aid=request.getParameter("Aid");
		Student student = new Student(Sid, Sname, Sbirth, Ssex, Sem, Sps, Snative,index, Saddress, Stel, Sedu, Sur,
				Surtel, "1", 0, 1, Mname);
		int update = service.update(Sid, student);
		response.getWriter().print(update);
	}

	/**
	 * 删除学生，假删除
	 * 
	 * @throws IOException
	 */
	public void del(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String sid = request.getParameter("Sid");
		String[] Sid = sid.split(",");
		int del = service.del(Sid);
		response.getWriter().print(del);

	}

	/**
	 * 审核编辑
	 * 
	 * @throws IOException
	 */
	public void approve(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String Sid = request.getParameter("Sid");
		String[] sid=Sid.split(",");
		int approve = service.approve(sid);
		response.getWriter().print(approve);
	}

	/**
	 * 查询单个对象
	 * 
	 * @throws IOException
	 */
	public void student(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int Sid = Integer.parseInt(request.getParameter("Sid"));
		Student student = service.student(Sid);
		if (student != null) {
			request.setAttribute("student", student);
			forward("student/select.jsp", request, response);
		}
	}
	public void student1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int Sid = Integer.parseInt(request.getParameter("Sid"));
		Student student = service.student(Sid);
		if (student != null) {
			request.setAttribute("student", student);
			forward("student/select1.jsp", request, response);
		}
	}
	/**
	 * 模糊查询
	 * 
	 * @throws IOException
	 */
	public void like(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String likes = request.getParameter("like");
		if (likes.equals("")||likes==null) {
			querypage(request,response);
		}else {
		PageBean pagebean = new PageBean();
		String thispage = request.getParameter("thispage");
		List<Student> list = service.like(pagebean, thispage, likes);
		String text = JSON.toJSONString(list); // 把list--->jsonarray格式的字符串
		request.setAttribute("pagePean", pagebean);
		String pagetext = JSON.toJSONString(pagebean);// 把对象转为json格式的字符串
		String value = "{\"pagebean\":" + pagetext + ",\"rows\":" + text + "}";
		response.getWriter().print(value);
		}
	}
	public void like1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String likes = request.getParameter("like");
		if (likes.equals("")||likes==null) {
			querypage1(request,response);
		}else {
		PageBean pagebean = new PageBean();
		String thispage = request.getParameter("thispage");
		List<Student> list = service.like1(pagebean, thispage, likes);
		String text = JSON.toJSONString(list); // 把list--->jsonarray格式的字符串
		request.setAttribute("pagePean", pagebean);
		String pagetext = JSON.toJSONString(pagebean);// 把对象转为json格式的字符串
		String value = "{\"pagebean\":" + pagetext + ",\"rows\":" + text + "}";
		response.getWriter().print(value);
	}
	}
}
