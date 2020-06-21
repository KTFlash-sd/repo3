package cn.kgc.tangcco.zhangyu.student.service;

import java.util.List;

import cn.kgc.tangcco.entity.Student;
import cn.kgc.tangcco.util.PageBean;

public interface StudentService {

	/**
	 *  * 分页查迅方法，只显示Sdel=1（未删除），并且Sstate=1（1=审核通过）的学员
		 * 
	 */
	List<Student> querypage(PageBean pageBean, String thispage);

	/**
	 *  *  * 分页查迅方法，只显示Sdel=1（未删除），并且Sstate！=1（审核未通过）的学员
	 */
	List<Student> querypage1(PageBean pageBean, String thispage);

	/**
	 * 分页查询，查询所有
	 */
	List<Student> querypage2(PageBean pageBean, String thispage);

	/**
	 * 修改信息
	 * @param Sid
	 * @param student
	 * @return message
	 */
	int update(int Sid, Student student);

	/**
	 * 添加学生
	 */
	int addstudent(Student student);

	/**
	 * 删除，假删除
	 */
	int del(String []sid);

	

	/**
	 * 审核编辑
	 */
	int approve(String [] Sid);

	/**
	 * 查询单个对象
	 * @param Sid
	 * @return
	 */
	Student student(int Sid);

	/**
	 * 模糊查询
	 * @param Sname
	 * @param Sid
	 * @param Smajorid
	 * @return
	 */
	List<Student> like(PageBean pageBean,String thispage,String likes);
	List<Student> like1(PageBean pageBean,String thispage,String likes);
}