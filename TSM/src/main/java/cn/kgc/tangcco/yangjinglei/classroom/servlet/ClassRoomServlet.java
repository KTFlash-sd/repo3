package cn.kgc.tangcco.yangjinglei.classroom.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.alibaba.fastjson.JSON;


import cn.kgc.tangcco.entity.Classroom;

import cn.kgc.tangcco.util.MyServlet;
import cn.kgc.tangcco.util.PageBean;
import cn.kgc.tangcco.yangjinglei.classroom.service.ClassRoomService;
import cn.kgc.tangcco.yangjinglei.classroom.service.imp.ClassRoomServiceimp;


	@WebServlet("/classroom")
	public class ClassRoomServlet extends MyServlet {
		private static final long serialVersionUID = 1L;
		//ClassRoomService service=ObjectFactory.getInstance(Constant.SSERVICE);

		ClassRoomService service = new ClassRoomServiceimp();
		 /**
	     * Default constructor. 
	     */
	    public ClassRoomServlet() {
	    }
	    /**
		 * 添加教室对象
		 * @param request
		 * @param response
		 */
	    
	    public void addclassroom(HttpServletRequest request, HttpServletResponse response) {
	    	try {
				request.setCharacterEncoding("UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	response.setCharacterEncoding("UTF-8");
			int Cid=-1;
			String Cname=request.getParameter("Cname");
			String Cplace=request.getParameter("Cplace");
			String Cstate=request.getParameter("Cstate");
			String Cdel=request.getParameter("Cdel");
		Classroom classroom = new Classroom(Cid,Cname,Cplace,Cstate,1);
		String addmessage=service.addstudent(classroom);
		System.out.println(classroom);
		System.out.println(addmessage);
		request.setAttribute("addmessage", addmessage);
		forward("/classroom/testroom.jsp", request, response);
	    }
	
	    /**
		 * 分页查迅方法，只显示Cdel=1（未删除），并且Cstate ！= 1（审核未通过）的教室
		 * @throws IOException 
		 */
	    
		public void querypage1(HttpServletRequest request, HttpServletResponse response) throws IOException {
			String thispage=request.getParameter("thispage");
			PageBean pageBean=new PageBean();
			List<Classroom> list=service.querypage1(pageBean, thispage);
			for (Classroom classroom : list) {
				System.out.println(classroom);
			}
			String text=JSON.toJSONString(list); //把list--->jsonarray格式的字符串
		    String pagetext=JSON.toJSONString(pageBean);//把对象转为json格式的字符串
	        String value="{\"pagebean\":"+pagetext+",\"rows\":"+text+"}";
	        System.out.println(value);
	        response.getWriter().print(value);
		}
		/**
		 * 分页查询，查询所有
		 */
		public void querypage2(HttpServletRequest request, HttpServletResponse response) throws IOException {
			String thispage=request.getParameter("thispage");
			PageBean pageBean=new PageBean();
			List<Classroom> list=service.querypage2(pageBean, thispage);
			String text=JSON.toJSONString(list); //把list--->jsonarray格式的字符串
			   response.getWriter().print(text);
			   String pagetext=JSON.toJSONString(pageBean);//把对象转为json格式的字符串
		        String value="{\"pagebean\":"+pagetext+",\"rows\":"+text+"}";
		        System.out.println(value);
		        response.getWriter().print(value);
		}
	
		
		public void update(HttpServletRequest request, HttpServletResponse response) {
			int Cid=Integer.parseInt(request.getParameter("Cid"));
			String Cname=request.getParameter("Cname");
			String Cplace=request.getParameter("Cplace");
			String Cstate=request.getParameter("Cstate");
			String Cdel=request.getParameter("Cdel");	
			Classroom classroom = new Classroom(Cid,Cname,Cplace,Cstate,1);
			String update=service.update(Cid, classroom);
			request.setAttribute("update", update);
		}
		
		/**
		 * 删除教室，假删除
		 */
		public void del(HttpServletRequest request, HttpServletResponse response) {
			String [] Cid=request.getParameterValues("Cid");
			String del=service.del(Cid);
			request.setAttribute("del", del);
		}
		/**
		 * 删除教室，假删除
		 */
		public void delete(HttpServletRequest request, HttpServletResponse response) {
			String [] Cid=request.getParameterValues("Cid");
			String delete=service.delete(Cid);
			request.setAttribute("delete", delete);
		}
		
		/**
		 * 审核编辑
		 */
		public void approve(HttpServletRequest request, HttpServletResponse response) {
			String [] Cid=request.getParameterValues("Cid");
			int approve=service.approve(Cid);
			request.setAttribute("approve", approve);
		}
		
		/**
		 * 查询单个对象
		 */
		public void Classroom(HttpServletRequest request, HttpServletResponse response) {
			int Cid=Integer.parseInt(request.getParameter("Cid"));
			Classroom classroom=service.classroom(Cid);
			if (classroom!=null) {
				request.setAttribute("classroom", classroom);
			}
		}
		
		/**
		 * 模糊查询
		 * @throws IOException 
		 */
		public void like(HttpServletRequest request, HttpServletResponse response) throws IOException {
			String likes=request.getParameter("like");
			PageBean pagebean=new PageBean();
			String thispage=request.getParameter("thispage");
			List<Classroom> list=service.like(pagebean, thispage, likes);
			String text=JSON.toJSONString(list); //把list--->jsonarray格式的字符串
			   response.getWriter().print(text);
		String pagetext=JSON.toJSONString(pagebean);//把对象转为json格式的字符串
	    String value="{\"pagebean\":"+pagetext+",\"rows\":"+text+"}";
	    System.out.println(value);
	    response.getWriter().print(value);
		}
		
		}
	

