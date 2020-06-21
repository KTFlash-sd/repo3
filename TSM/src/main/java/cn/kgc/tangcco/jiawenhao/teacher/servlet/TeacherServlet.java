package cn.kgc.tangcco.jiawenhao.teacher.servlet;


import java.util.Date;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import cn.kgc.tangcco.entity.Teacher;
import cn.kgc.tangcco.jiawenhao.teacher.service.TeacherServiceImp;
import cn.kgc.tangcco.util.MyServlet;
import cn.kgc.tangcco.util.PageBean;
import cn.kgc.tangcco.util.Utils;

/**
 * Servlet implementation class TeacherServlet
 */
/**
 * 
 * @author 贾文豪
 *
 */
@WebServlet("/teacher")
public class TeacherServlet extends MyServlet {
	private static final long serialVersionUID = 1L;
      TeacherServiceImp teacherservice=new TeacherServiceImp();
      //添加教师信息
   public void addTeacher(HttpServletRequest request, HttpServletResponse response)throws Exception {
	   request.setCharacterEncoding("UTF-8");
	   response.setCharacterEncoding("UTF-8");
	   String Tname=request.getParameter("Tname");
	   String Tsex=request.getParameter("Tsex");
	   String Tem=request.getParameter("Tem");
	   String Tbirth1=request.getParameter("Tbirth");
	   String Tps=request.getParameter("Tps");
	   String Tnative=request.getParameter("Tnative");
	   String Ttel=request.getParameter("Ttel");
	   String Tmajor=request.getParameter("Tmajor");
	   String Tyear1=request.getParameter("Tyear");
	   String Tiob=request.getParameter("Tiob");
	   String Aid=request.getParameter("Aid");
//	   String Tdel1=request.getParameter("Tdel");
//	   String Tstate1=request.getParameter("Tstate");
//	   int Tstate=Integer.parseInt(Tstate1);
	   int Tyear=Integer.parseInt(Tyear1);
	   Date Tbirth=Utils.StringtoDate(Tbirth1);
	   Teacher teacher=new Teacher(1, Tname, Tsex, Tem, Tbirth, Tps, Tnative, Ttel, Tmajor, Tyear, Tiob, "1", 0, 1);
	   System.out.println(teacher+"-------");
	   int n=teacherservice.addTeacher(teacher);
	   response.getWriter().print(n+"");
   }
   //条件教师信息
   public void tjTeacher(HttpServletRequest request, HttpServletResponse response)throws Exception{
	   request.setCharacterEncoding("UTF-8");
	   response.setCharacterEncoding("UTF-8");
	   PageBean pagebean=new PageBean();
	   String thispage=request.getParameter("thispage");
	   String Tdel1=request.getParameter("Tdel");
	   String Tstate1=request.getParameter("Tstate");
	   int Tdel=Integer.parseInt(Tdel1);
	   int Tstate=Integer.parseInt(Tstate1);
	   List<Teacher> list=teacherservice.query(pagebean,Tdel, Tstate,thispage);
	   String text=JSON.toJSONString(list);//把list转换为json格式
	   JSONArray jsonarray=JSONArray.parseArray(text);//把字符串转化为JSON对象
	   String pagetext=JSON.toJSONString(pagebean);
	   String value="{\"pagebean\":"+pagetext+",\"rows\":"+text+"}";
	   response.getWriter().print(value);
	   
   }
   //查询所有教师信息
   public void queryTeacher(HttpServletRequest request, HttpServletResponse response)throws Exception{
	   request.setCharacterEncoding("UTF-8");
	   response.setCharacterEncoding("UTF-8");
	   PageBean pagebean=new PageBean();
	   String thispage=request.getParameter("thispage");
	   List<Teacher> list=teacherservice.query();
	   
	   String text=JSON.toJSONString(list);//把list转换为json格式
	   JSONArray jsonarrray=JSONArray.parseArray(text);//把字符串转为一个JSONArray对象
	   
	   String pagetext=JSON.toJSONString(pagebean);
	   String value="{\"pagebean\":"+pagetext+",\"rows\":"+text+"}";
	   response.getWriter().print(value);
	   System.out.println(value);
	   
   }
   //分页查询所有教师信息
   public void queryPageTeacher(HttpServletRequest request, HttpServletResponse response)throws Exception{
	   request.setCharacterEncoding("UTF-8");
	   response.setCharacterEncoding("UTF-8");
	   PageBean pagebean=new PageBean();
	   String thispage=request.getParameter("thispage");
	   List<Teacher> list=teacherservice.querypage(pagebean, thispage);
	   String text=JSON.toJSONString(list);//把list转换为json格式
	   JSONArray jsonarrray=JSONArray.parseArray(text);//把字符串转为一个JSONArray对象
	   String pagetext=JSON.toJSONString(pagebean);
	   String value="{\"pagebean\":"+pagetext+",\"rows\":"+text+"}";
	   response.getWriter().print(value);
	   System.out.println(value);
	   
   }
   //根据名字查询教师信息
   public void nameTeacher(HttpServletRequest request, HttpServletResponse response)throws Exception{
	   request.setCharacterEncoding("UTF-8");
	   response.setCharacterEncoding("UTF-8");
	   PageBean pagebean=new PageBean();
	   String thispage=request.getParameter("thispage");
	   String Tname=request.getParameter("Tname");
	   List<Teacher> list=teacherservice.findTeacher(Tname, pagebean, thispage);
	   String text=JSON.toJSONString(list);//把list转换为json格式
	   JSONArray jsonarrray=JSONArray.parseArray(text);//把字符串转为一个JSONArray对象
	   String pagetext=JSON.toJSONString(pagebean);
	   String value="{\"pagebean\":"+pagetext+",\"rows\":"+text+"}";
	   response.getWriter().print(value);
	   
   }
   //根据姓名 假删除 
   public void delectTeacher(HttpServletRequest request, HttpServletResponse response)throws Exception{
	   request.setCharacterEncoding("UTF-8");
	   response.setCharacterEncoding("UTF-8");
	   String Tid1=request.getParameter("Tid");
	   int Tid=Integer.parseInt(Tid1);
	   int i=teacherservice.delete(Tid);
	   response.getWriter().print(i+"");
   }
   
   //修改信息
   public void changeTeacher(HttpServletRequest request, HttpServletResponse response)throws Exception{
	   request.setCharacterEncoding("UTF-8");
	   response.setCharacterEncoding("UTF-8");
	   String Tid1=request.getParameter("Tid");
	   String Tname=request.getParameter("Tname");
	   String Tsex=request.getParameter("Tsex");
	   String Tem=request.getParameter("Tem");
	   String Tbirth1=request.getParameter("Tbirth");
	   String Tps=request.getParameter("Tps");
	   String Tnative=request.getParameter("Tnative");
	   String Ttel=request.getParameter("Ttel");
	   String Tmajor=request.getParameter("Tmajor");
	   String Tyear1=request.getParameter("Tyear");
	   String Tiob=request.getParameter("Tiob");
	   int Tyear=Integer.parseInt(Tyear1);
	   Date Tbirth=Utils.StringtoDate(Tbirth1);
	   int Tid=Integer.parseInt(Tid1);
	   Teacher teacher=new Teacher(Tid,Tname,Tsex,Tem,Tbirth,Tps,Tnative,Ttel,Tmajor,Tyear,Tiob,"1",1,1);
	   System.out.println("123"+teacher);
	   int n=teacherservice.changeTeacher(teacher);
	   System.out.println(n);
	   response.getWriter().print(n+"");
   }
   //模糊查询
   public void mohuquery(HttpServletRequest request, HttpServletResponse response)throws Exception{
	   request.setCharacterEncoding("UTF-8");
	   response.setCharacterEncoding("UTF-8");
	   PageBean pagebean=new PageBean();
	   String thispage=request.getParameter("thispage");
	   String Tname=request.getParameter("Tname");
	   List<Teacher> list=teacherservice.findTeacher(Tname,pagebean,thispage);
	   String text=JSON.toJSONString(list);//把list转换为json格式
	   JSONArray jsonarray=JSONArray.parseArray(text);//把字符串转化为JSON对象
	   String pagetext=JSON.toJSONString(pagebean);
	   String value="{\"pagebean\":"+pagetext+",\"rows\":"+text+"}";
	   response.getWriter().print(value);
   }
   //根据ID 返回对象数据
   public void idquery(HttpServletRequest request, HttpServletResponse response)throws Exception{
	   request.setCharacterEncoding("UTF-8");
	   response.setCharacterEncoding("UTF-8");
	   String Tid1=request.getParameter("Tid");
	   int Tid=Integer.parseInt(Tid1);
	   Teacher teacher=teacherservice.idTeacher(Tid);
	   request.setAttribute("teacher", teacher);
	   forward("/teacher/modifyTeacher.jsp", request, response);
   }
}
