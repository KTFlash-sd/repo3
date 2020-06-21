package cn.kgc.tangcco.yangjinglei.classroom.dao.imp;

import java.util.List;

import cn.kgc.tangcco.entity.Classroom;
import cn.kgc.tangcco.util.JDBCUtil;
import cn.kgc.tangcco.util.PageBean;
import cn.kgc.tangcco.yangjinglei.classroom.UtilDate;

public class ClassRoomDAOImp extends JDBCUtil<Classroom> {

	/**
	 * 分页查迅方法，只显示Sdel=1（未删除），并且Sstate=1（1=审核通过）的学员
	 * 
	 */
		public List<Classroom> queryPage(PageBean pageBean){
			List<Classroom> list=null;
			String sql="select  *  from  classroom "+" where cdel=1  limit "+pageBean.getRowindex()+" , "+pageBean.getPagesize();
			System.out.println(sql);
			list=query(Classroom.class, sql);
			
			return list;
		}
		/**
		 * 
		 * 分页查询方法，只显示Sdel=1（未删除），并且Sstate!=1（审核未通过）的学员
		 * 限教师与超级管理员查看
		 */
		public List<Classroom> queryPage1(PageBean pageBean){
			List<Classroom> list=null;
			String sql="select  *  from  classroom "+" where cdel=1  limit "+pageBean.getRowindex()+" , "+pageBean.getPagesize();
			list=query(Classroom.class, sql);
			return list;
		}
		/**
		 * 分页查询所有学生
		 */
		public List<Classroom> query(PageBean pageBean){
			List<Classroom> list=null;
			String sql="select  *  from  classroom limit "+pageBean.getRowindex()+" , "+pageBean.getPagesize();
			list=query(Classroom.class, sql);
			
			return list;
		}
		/**
		 * 查询所有
		 */
		public List<Classroom> select(){
			List<Classroom>list=null;
			String sql="select * from classroom";
			list=query(Classroom.class, sql);
			return list;
		}
		/**
		 * 查询所有可显示，通过审批的
		 */
		public List<Classroom> select1(){
			List<Classroom>list=null;
			String sql="select * from classroom where cdel=1 ";
			list=query(Classroom.class, sql);
			return list;
		}
		/**
		 * 查询所有可显示，未通过审批的
		 */
		public List<Classroom> select2(){
			List<Classroom>list=null;
			String sql="select * from classroom where cdel=1 and cstate=0";
			list=query(Classroom.class, sql);
			return list;
		}
		/**
		 * 根据学生编号修改学生id的方法
		 */
		public int modifyStudent(int Sid,Classroom room) {
			int i=-1;
			String sql="update classroom set Cname=?,Cplace=? where Cid=?";
			Object[] objects= {//网数值中存放修改单的数据
					UtilDate.StringtoDate(room.getCname())};
			i=modify(sql, objects);
			return i;
		}
		/**
		 * 添加学生
		 */
		public int addclassroom(Classroom room) {
			int i=-1;
			String sql="insert into classroom values(classroom.cid,?,?,?,1)";
			Object[] objects= {//网数值中存放添加的数据
					room.getCname(),room.getCplace(),room.getCstate()};	//添加教室默认未删除，待审核
			i=modify(sql, objects);
			return i;
		}
		/**
		 * 删除方法（假删除）
		 */
		public int del(String [] sid) {
			int i=-1;
			String sql="update classroom set Cdel=0 where Cid=?";
			for (String string : sid) {
				int Sid=Integer.parseInt(string );
				i=modify(sql, Sid);
			}
			
			return i;
		}
		/**
		 * 真删除
		 */
		public int delete(String [] sid) {
			int i=-1;
			String sql="delete from classroom where Cid=?";
			for (String string : sid) {
				int Sid=Integer.parseInt(string );
				i=modify(sql, Sid);
			}
			
			return i;
		}
		/**
		 * 审核编辑
		 */
		public int approve(String [] Sid) {
			int i=-1;
			String sql="update classroom set Cstate=1 where Cid=?";
			for (String string :Sid) {
				int sid=Integer.parseInt(string );
				i=modify(sql, Sid);
			}
			return i;
		}
		/**
		 * 查询单个对像
		 */
		public Classroom student(int Sid) {
			Classroom student=null;
			String sql="select * from classroom where Cid=?";
			student=select(Classroom.class, sql, Sid);
			return student;
		}
		/**
		 * 模糊查询
		 */
		public List<Classroom> like(String likes){
			int i=-1;
			if (likes.matches("[0-9]+")) {
				i=Integer.parseInt(likes);
			}
			List< Classroom> students=null;
			String sql="select * from classroom where Cdel=1 and Cname like '%"+ likes+"%' or Cid like '%"+ i+"%' ";
			students=query(Classroom.class, sql);
			return students;
		}
}
	

