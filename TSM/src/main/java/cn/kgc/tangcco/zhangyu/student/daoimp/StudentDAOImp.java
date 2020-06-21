package cn.kgc.tangcco.zhangyu.student.daoimp;

import java.util.List;

import cn.kgc.tangcco.entity.Student;
import cn.kgc.tangcco.util.JDBCUtil;
import cn.kgc.tangcco.util.PageBean;
import cn.kgc.tangcco.zhangyu.UtilDate;

public class StudentDAOImp extends JDBCUtil<Student> {
	/**
	 * 分页查迅方法，只显示Sdel=1（未删除），并且Sstate=1（1=审核通过）的学员
	 * 
	 */
	public List<Student> queryPage(PageBean pageBean) {
		List<Student> list = null;
		String sql = "select  stu.*,major.MAname  from  student as stu, major   where Sdel=1 and Sstate=1 and  major.MAid=stu.Smajorid   limit " + pageBean.getRowindex() + " , "
				+ pageBean.getPagesize();
		list = query(Student.class, sql);

		return list;
	}

	/**
	 * 
	 * 分页查询方法，只显示Sdel=1（未删除），并且Sstate!=1（审核未通过）的学员 限教师与超级管理员查看
	 */
	public List<Student> queryPage1(PageBean pageBean) {
		List<Student> list = null;
		String sql = "select  stu.*,major.MAname  from  student as stu ,major where Sdel=1 and Sstate=0 and major.MAid=stu.Smajorid  limit " + pageBean.getRowindex() + " , "
				+ pageBean.getPagesize();
		list = query(Student.class, sql);

		return list;
	}

	/**
	 * 分页查询所有学生
	 */
	public List<Student> query(PageBean pageBean) {
		List<Student> list = null;
		String sql = "select  *  from  student limit " + pageBean.getRowindex() + " , " + pageBean.getPagesize();
		list = query(Student.class, sql);

		return list;
	}

	/**
	 * 查询所有
	 */
	public List<Student> select() {
		List<Student> list = null;
		String sql = "select stu.*,major.MAname  from student as stu ,major where major.MAid=stu.Smajorid";
		list = query(Student.class, sql);
		return list;
	}

	/**
	 * 查询所有可显示，通过审批的
	 */
	public List<Student> select1() {
		List<Student> list = null;
		String sql = "select * from student where Sdel=1 and Sstate=1";
		list = query(Student.class, sql);
		return list;
	}

	/**
	 * 查询所有可显示，未通过审批的
	 */
	public List<Student> select2() {
		List<Student> list = null;
		String sql = "select * from student where Sdel=1 and Sstate=0";
		list = query(Student.class, sql);
		return list;
	}

	/**
	 * 根据学生编号修改学生的方法
	 */
	public int modifyStudent(int Sid, Student student) {
		int i = -1;
		String sql = "update student set Sbirth=?,Sem=?,Sps=?,Saddress=?,Stel=?,Sur=?,Surtel=? ,Sstate=0 where Sid=" + Sid;
		Object[] objects = { // 网数值中存放修改单的数据
				UtilDate.DatetoString(student.getSbirth()), student.getSem(), student.getSps(), student.getSaddress(),
				student.getStel(), student.getSur(), student.getSurtel() };
		i = modify(sql, objects);
		return i;
	}

	/**
	 * 添加学生
	 */
	public int addStudent(Student student) {
		int i = -1;
		String sql = "insert into student values(null,?,?, ?,?,?, ?,?,?, ?,?,?, ?,?,?,?)";
		Object[] objects = { // 网数值中存放添加的数据
				student.getSname(), UtilDate.DatetoString(student.getSbirth()), student.getSsex(), student.getSem(),
				student.getSps(), student.getSnative(), student.getSmajorid(), student.getSaddress(), student.getStel(),
				student.getSedu(), student.getSur(), student.getSurtel(), student.getAid(),student.getSstate(), student.getSdel()
				 }; // 添加学生默认未删除，待审核
		i = modify(sql, objects);
		return i;
	}

	/**
	 * 删除方法（假删除）
	 */
	public int del(String[] sid) {

		int i = -1;
		String sql = "update student set Sdel=0 where Sid=?";
		for (String string : sid) {

			i = modify(sql, string);
		}

		return i;
	}

	

	/**
	 * 审核编辑
	 */
	public int approve(String[] Sid) {
		int i = -1;
		String sql = "update student set Sstate=1 where Sid=?";
		for (String string : Sid) {
			int sid = Integer.parseInt(string);
			i = modify(sql, sid);
		}
		return i;
	}

	/**
	 * 查询单个对像
	 */
	public Student student(int Sid) {
		Student student = null;
		String sql = "select * from student where Sid=?";
		student = select(Student.class, sql, Sid);
		return student;
	}

	/**
	 * 模糊查询,以分页
	 */
	public List<Student> like(String likes) {
		int i = -1;
		List<Student> students = null;
		if (likes.matches("[0-9]+")) {
			i = Integer.parseInt(likes);
		}
		
		String sql = "select student.*,major.MAname  from student left join major on  student.Smajorid=major.MAid where student.Sdel=1 and student.Sstate=1 and (student.Sname like '%" + likes + "%' or student.Sid like '%" + i
				+ "%' or major.MAname like '%" + likes + "%')";
		students = query(Student.class, sql);
		return students;
	}
	public List<Student> like1(String likes) {
		int i = -1;
		if (likes.matches("[0-9]+")) {
			i = Integer.parseInt(likes);
		}
		List<Student> students = null;
		String sql =  "select student.*,major.MAname  from student left join major on student.Smajorid=major.MAid  where  student.Sdel=1 and student.Sstate=0 and (student.Sname like '%" + likes + "%' or student.Sid like '%" + i
				+ "%' or major.MAname like '%" + likes + "%')";
		students = query(Student.class, sql);
		return students;
	}
}
