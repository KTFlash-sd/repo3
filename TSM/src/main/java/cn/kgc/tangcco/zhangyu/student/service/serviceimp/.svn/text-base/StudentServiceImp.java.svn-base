package cn.kgc.tangcco.zhangyu.student.service.serviceimp;

import java.util.ArrayList;
import java.util.List;

import cn.kgc.tangcco.entity.Student;
import cn.kgc.tangcco.util.PageBean;
import cn.kgc.tangcco.zhangyu.student.daoimp.StudentDAOImp;
import cn.kgc.tangcco.zhangyu.student.service.StudentService;

public class StudentServiceImp implements StudentService {
StudentDAOImp dao;

/**
 *  * 分页查迅方法，只显示Sdel=1（未删除），并且Sstate=1（1=审核通过）的学员
	 * 
 */
@Override
public List<Student>querypage(PageBean pageBean,String thispage){
	List<Student> list=null;
	pageBean.setTotalsize(dao.select1().size());//设置所有通过审核的集合
	pageBean.setThispage(thispage);
	list=dao.queryPage(pageBean);
	
	return list;
}

/**
 *   分页查迅方法，只显示Sdel=1（未删除），并且Sstate！=1（审核未通过）的学员
 */
@Override
public List<Student>querypage1(PageBean pageBean,String thispage){
	List<Student> list=null;
	pageBean.setTotalsize(dao.select2().size());//设置所有未通过审核的集合
	pageBean.setThispage(thispage);
	list=dao.queryPage1(pageBean);
	return list;
}
/**
 * 分页查询，查询所有
 */
@Override
public List<Student> querypage2(PageBean pageBean,String thispage){
	List<Student> list=null;
	pageBean.setTotalsize(dao.select().size());//设置所有未通过审核的集合
	pageBean.setThispage(thispage);
	list=dao.query(pageBean);
	return list;
}
/**
 * 修改信息
 * @param Sid
 * @param student
 * @return message
 */
@Override
public int update(int Sid,Student student) {
	int message=dao.modifyStudent(Sid, student);
	return message;
}
/**
 * 添加学生
 */
@Override
public int addstudent(Student student) {
	int message=dao.addStudent(student);
	return message;
}
/**
 * 删除，假删除
 */
@Override
public int del(String [] sid) {
	int message=dao.del(sid);
	return message;
}


/**
 * 审核编辑
 */
@Override
public int  approve(String [] Sid) {
	 int i=-1;
		 i=dao.approve(Sid);
		 return i;
}
/**
 * 查询单个对象
 * @param Sid
 * @return
 */
@Override
public Student student(int Sid) {
	Student student=null;
	student=dao.student(Sid);
	return student;
}
/**
 * 模糊查询
 * @param Sname
 * @param Sid
 * @param Smajorid
 * @return
 */
@Override
public List<Student> like(PageBean pageBean,String thispage,String likes){
	
	List<Student> list1=new ArrayList<Student>();
	List<Student> list=dao.like(likes);
	pageBean.setTotalsize(list.size());
	pageBean.setThispage(thispage);
	int index=pageBean.getRowindex();//获取当前页第一条记录的下标  假设当前是第5页   index=16
	int count=index+pageBean.getPagesize(); //获取循环4条的条件
	count= count>list.size()?list.size():count;
	for(int i=index;i<count;i++) {
		list1.add(list.get(i));
	}
	return list1;
}
public List<Student> like1(PageBean pageBean,String thispage,String likes){
	if (likes.equals("")||likes==null) {
		likes="******";
	}
	List<Student> list1=new ArrayList<Student>();
	List<Student> list=dao.like1(likes);
	pageBean.setTotalsize(list.size());
	pageBean.setThispage(thispage);
	int index=pageBean.getRowindex();//获取当前页第一条记录的下标  假设当前是第5页   index=16
	int count=index+pageBean.getPagesize(); //获取循环4条的条件
	count= count>list.size()?list.size():count;
	for(int i=index;i<count;i++) {
		list1.add(list.get(i));
	}
	return list1;
}
}
