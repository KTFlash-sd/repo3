package cn.kgc.tangcco.yangjinglei.classroom.service;

import java.util.List;

import cn.kgc.tangcco.entity.Classroom;
import cn.kgc.tangcco.util.PageBean;

public interface ClassRoomService {
	/**
	 *  * 分页查迅方法，只显示cdel=1（未删除），并且cstate=1（1=审核通过）的学员
		 * 
	 */
	List<Classroom> querypage(PageBean pageBean, String thispage);

	/**
	 *  *  * 分页查迅方法，只显示cdel=1（未删除），并且cstate！=1（审核未通过）的学员
	 */
	List<Classroom> querypage1(PageBean pageBean, String thispage);

	/**
	 * 分页查询，查询所有
	 */
	List<Classroom> querypage2(PageBean pageBean, String thispage);

	/**
	 * 修改信息
	 * @param Sid
	 * @param student
	 * @return message
	 */
	String update(int Sid, Classroom classroom);

	/**
	 * 添加教室
	 */
	String addstudent(Classroom classroom);

	/**
	 * 删除，假删除
	 */
	String del(String []cid);

	/**
	 * 删除，真删除
	 */
	String delete(String [] cid);

	/**
	 * 审核编辑
	 */
	int approve(String [] cid);

	/**
	 * 查询单个对象
	 * @param Sid
	 * @return
	 */
	Classroom classroom(int cid);

	/**
	 * 模糊查询
	 * @param Sname
	 * @param Sid
	 * @param Smajorid
	 * @return
	 */
	List<Classroom> like(PageBean pageBean,String thispage,String likes);

}