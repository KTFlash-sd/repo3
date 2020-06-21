package cn.kgc.tangcco.yangjinglei.classroom.service.imp;

import java.util.ArrayList;
import java.util.List;

import cn.kgc.tangcco.entity.Classroom;
import cn.kgc.tangcco.entity.Student;
import cn.kgc.tangcco.util.PageBean;
import cn.kgc.tangcco.yangjinglei.classroom.dao.imp.ClassRoomDAOImp;
import cn.kgc.tangcco.yangjinglei.classroom.service.ClassRoomService;




public class ClassRoomServiceimp  implements ClassRoomService{
	ClassRoomDAOImp dao= new ClassRoomDAOImp();

	/**
	 *  * 分页查迅方法，只显示Sdel=1（未删除），并且Sstate=1（1=审核通过）的学员
		 * 
	 */
	@Override
	public List<Classroom> querypage(PageBean pageBean,String thispage){
		List<Classroom> list=null;
		pageBean.setTotalsize(dao.select1().size());//设置所有通过审核的集合
		pageBean.setThispage(thispage);
		list=dao.queryPage(pageBean);
		return list;
	}
	/**
	 *   分页查迅方法，只显示Sdel=1（未删除），并且Sstate！=1（审核未通过）的学员
	 */
	@Override
	public List<Classroom> querypage1(PageBean pageBean,String thispage){
		List<Classroom> list=null;
		pageBean.setTotalsize(dao.select2().size());//设置所有未通过审核的集合
		pageBean.setThispage(thispage);
		list=dao.queryPage1(pageBean);
		return list;
	}
	/**
	 * 分页查询，查询所有
	 */
	@Override
	public List<Classroom> querypage2(PageBean pageBean,String thispage){
		List<Classroom> list=null;
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
	public String update(int Sid, Classroom classroom) {
		String message=dao.modifyStudent(Sid, classroom)>0?"修改成功":"修改失败";
		return message;
	}
	/**
	 * 添加学生
	 */
	@Override
	public String addstudent(Classroom classroom) {
		String message=null;
		return message=dao.addclassroom(classroom)>0?"添加成功":"添加失败";
	}
	/**
	 * 删除，假删除
	 */
	@Override
	public String del(String [] sid) {
		String message=null;
		return message=dao.del(sid)>0?"删除成功":"删除失败";
	}

	/**
	 * 删除，真删除
	 */
	@Override
	public String delete(String [] sid) {
		String message=null;
		
		return message=dao.delete(sid)>0?"删除成功":"删除失败";
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
	public Classroom classroom(int Cid) {
		Classroom classroom=null;
		classroom=dao.student(Cid);
		return classroom;
	}
	/**
	 * 模糊查询
	 * @param Sname
	 * @param Sid
	 * @param Smajorid
	 * @return
	 */
	@Override
	public List<Classroom> like(PageBean pageBean,String thispage,String likes){
		if (likes.equals("")||likes==null) {
			likes="******";
		}
		
		List<Classroom> list1=new ArrayList<Classroom>();
		List<Classroom> list=dao.like(likes);
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
