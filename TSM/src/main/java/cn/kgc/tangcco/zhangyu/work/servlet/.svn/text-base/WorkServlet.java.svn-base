package cn.kgc.tangcco.zhangyu.work.servlet;

import cn.kgc.tangcco.common.ObjectFactory;
import cn.kgc.tangcco.entity.Classroom;
import cn.kgc.tangcco.entity.Lesson;
import cn.kgc.tangcco.entity.Teacher;
import cn.kgc.tangcco.entity.Work;
import cn.kgc.tangcco.util.Constant;
import cn.kgc.tangcco.util.MyServlet;
import cn.kgc.tangcco.util.PageBean;
import cn.kgc.tangcco.zhangyu.UtilDate;
import cn.kgc.tangcco.zhangyu.classroom.classroomserviceimp.ClassRoomServiceImp;
import cn.kgc.tangcco.zhangyu.lesson.serviceimp.LessonServiceImp;
import cn.kgc.tangcco.zhangyu.teacher.serviceimp.TeacherServiceImp;
import cn.kgc.tangcco.zhangyu.work.entity.WorkBean;
import cn.kgc.tangcco.zhangyu.work.service.WorkService;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

/**
 * Servlet implementation class WorkServlet
 */
@WebServlet("/work")
public class WorkServlet extends MyServlet {
	private static final long serialVersionUID = 1L;
private WorkService service=ObjectFactory.getInstance(Constant.WSERVICE);
ClassRoomServiceImp classroom=new ClassRoomServiceImp();
TeacherServiceImp tservice=new TeacherServiceImp();
LessonServiceImp lservice=new LessonServiceImp();
    /**
     * Default constructor. 
     */
    public WorkServlet() {
        // TODO Auto-generated constructor stub
    }
    /**
     * 所有班级
     * @param request
     * @param response
     * @throws IOException
     */
public void claroom(HttpServletRequest request, HttpServletResponse response) throws IOException {
	List<Classroom> list=classroom.list();
	String text=JSON.toJSONString(list); //把list--->jsonarray格式的字符串
     response.getWriter().print(text);
}
/**
 * 分页查询
 * @throws IOException 
 */
	public void querypage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int Cid=Integer.parseInt(request.getParameter("Cid"));
		PageBean pageBean =new PageBean();
		String thispage=request.getParameter("thispage");
		List<WorkBean> list=service.querypage(Cid, pageBean, thispage);
		String text=JSON.toJSONString(list); //把list--->jsonarray格式的字符串
		   String pagetext=JSON.toJSONString(pageBean);//把对象转为json格式的字符串
	        String value="{\"pagebean\":"+pagetext+",\"rows\":"+text+"}";
	        response.getWriter().print(value);
	}
	/**
	 * 添加
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	public void add(HttpServletRequest request, HttpServletResponse response) {
		List<Teacher> tlist=tservice.list();
		List<Lesson> llist=lservice.list();
		List<Classroom> clist=classroom.list();
		request.setAttribute("tlist", tlist);
		request.setAttribute("llist", llist);
		request.setAttribute("clist", clist);
		forward("work/addwork.jsp", request, response);
	}
	public void addWork(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int Cid=Integer.parseInt(request.getParameter("Cid"));
		int Lid=Integer.parseInt(request.getParameter("Lid"));
		int Tid=Integer.parseInt(request.getParameter("Tid"));
		String start=request.getParameter("Wstart");
		String end=request.getParameter("Wend");
		int Wtime=Integer.parseInt(request.getParameter("Wtime"));
		Work work=new Work(0, Cid, Lid, Tid, UtilDate.StringtoDate1(start.trim()), UtilDate.StringtoDate1(end.trim()), Wtime, 1, 1);
		int i=-1;
		i=service.addWork(work);
		 response.getWriter().print(i);
	}
	/**
	 * 修改
	 * @throws IOException 
	 */
	public void update1(HttpServletRequest request, HttpServletResponse response) {
		int wid=Integer.parseInt(request.getParameter("Wid"));
		WorkBean work=service.work(wid);
		List<Teacher> tlist=tservice.list();
		List<Lesson> llist=lservice.list();
		List<Classroom> cList=classroom.list();
		if (work!=null) {
			int l=-1;
			int t=-1;
			int c=-1;
			for (Lesson lesson : llist) {
				if (lesson.getLname().equals(work.getLname())) {
					l=lesson.getLid();
					break;
				}
			}
			for (Classroom classroom : cList) {
				if (classroom.getCname().equals(work.getCname())) {
					c=classroom.getCid();
					break;
				}
			}
			for (Teacher teacher : tlist) {
				if (teacher.getTname().equals(work.getTname())) {
					t=teacher.getTid();
					break;
				}
			}
			request.setAttribute("classroom",c);
			request.setAttribute("teacher", t);
			request.setAttribute("lesson", l);
			request.setAttribute("tlist", tlist);
			request.setAttribute("llist", llist);
			request.setAttribute("work", work);
			forward("work/update.jsp", request, response);
		}
	}
	public void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int Wid=Integer.parseInt(request.getParameter("Wid"));
		int Cid=Integer.parseInt(request.getParameter("Cid"));
		int Lid=Integer.parseInt(request.getParameter("Lid"));
		int Tid=Integer.parseInt(request.getParameter("Tid"));
		String start=request.getParameter("Wstart");
		System.out.println(start);
		String end=request.getParameter("Wend");
		System.out.println(end);
		System.out.println(UtilDate.StringtoDate1(start));
		int Wtime=Integer.parseInt(request.getParameter("Wtime"));
		Work work=new Work(Wid, Cid, Lid, Tid, UtilDate.StringtoDate1(start.trim()), UtilDate.StringtoDate1(end.trim()), Wtime, 1, 1);
		int i=-1;
		i=service.updateWork(work);
		 response.getWriter().print(i);
	}
	/**
	 * 删除
	 * @throws IOException 
	 */
	public void delete (HttpServletRequest request, HttpServletResponse response) throws IOException {
	String wid=request.getParameter("Wid");
	String [] Wid=wid.split(",");
	
		int i=-1;
		for (String string : Wid) {
			int s=Integer.parseInt(string );
			i=service.delete(s);
		}
	
		response.getWriter().print(i);
	}
}
