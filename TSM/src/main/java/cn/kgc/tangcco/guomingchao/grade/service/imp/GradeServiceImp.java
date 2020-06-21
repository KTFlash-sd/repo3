package cn.kgc.tangcco.guomingchao.grade.service.imp;

import java.util.Date;
import java.util.List;

import cn.kgc.tangcco.entity.Grade;
import cn.kgc.tangcco.entity.Lesson;
import cn.kgc.tangcco.entity.Student;
import cn.kgc.tangcco.guomingchao.grade.dao.imp.GradeDAOImp;
import cn.kgc.tangcco.util.PageBean;

public class GradeServiceImp {
	GradeDAOImp gradedao = new GradeDAOImp();

	/**
	 * 查询所有
	 * 
	 * @return
	 */
	public List<Grade> query() {
		List<Grade> gradelist = null;
		String sql = "select * from grade";
		gradelist = gradedao.query(Grade.class, sql);
		return gradelist;
	}

	/**
	 * 分页查询
	 * 
	 * @param pagebean
	 * @param thispage
	 * @return
	 */
	public List<Grade> querypage(PageBean pagebean, String thispage) {
		List<Grade> alist = null;
		pagebean.setTotalsize(query().size());
		pagebean.setThispage(thispage);
		alist = gradedao.queryPage(pagebean);
		return alist;
	}

	/**
	 * 查询所有Gstate=1 and Gdel=1
	 * 
	 * @return
	 */
	public List<Grade> query1() {
		List<Grade> gradelist = null;
		String sql = "select * from grade where Gstate=1 and Gdel=1";
		gradelist = gradedao.query(Grade.class, sql);
		return gradelist;
	}

	/**
	 * 分页查询，Gstate=1 and Gdel=1，只显示所有已启用成绩
	 * 
	 * @param pagebean
	 * @param thispage
	 * @return
	 */
	public List<Grade> querypage1(PageBean pagebean, String thispage) {
		List<Grade> alist = null;
		pagebean.setTotalsize(query1().size());
		pagebean.setThispage(thispage);
		alist = gradedao.queryPage1(pagebean);
		return alist;
	}

	/**
	 * 查询所有Gstate=0 and Gdel=1
	 * 
	 * @return
	 */
	public List<Grade> query2() {
		List<Grade> gradelist = null;
		String sql = "select * from grade where Gstate=0 and Gdel=1";
		gradelist = gradedao.query(Grade.class, sql);
		return gradelist;
	}

	/**
	 * 分页查询，Gstate=0 and Gdel=1，只显示所有未已启用成绩
	 * 
	 * @param pagebean
	 * @param thispage
	 * @return
	 */
	public List<Grade> querypage2(PageBean pagebean, String thispage) {
		List<Grade> alist = null;
		pagebean.setTotalsize(query2().size());
		pagebean.setThispage(thispage);
		alist = gradedao.queryPage2(pagebean);
		return alist;
	}

	/**
	 * 按照学生id查询该学生所有课程成绩
	 * 
	 * @param Sid
	 * @return
	 */
	public List<Grade> Sid(int Sid) {
		List<Grade> alist = null;
		alist = gradedao.gid(Sid);
		return alist;
	}

	/**
	 * 按照课程id查询所有学生该课程成绩
	 * 
	 * @param Lid
	 * @return
	 */
	public List<Grade> Lid(int Lid) {
		List<Grade> alist = null;
		alist = gradedao.gid2(Lid);
		return alist;
	}

	/**
	 * 按照课程id学生id查询该学生课程成绩
	 * 
	 * @param Lid
	 * @param Sid
	 * @return
	 */
	public Grade find(int Lid, int Sid) {
		Grade grade = null;
		grade = gradedao.find(Lid, Sid);
		return grade;
	}

	/**
	 * 添加（录入）成绩
	 * 
	 * @param grade
	 * @return
	 */
	public String addgrade(Grade grade) {
		String message = null;
		String sql = "insert into grade value(grade.Gid,?,?,?,?,?,?)";
		int n = gradedao.modify(sql, grade.getLid(), grade.getSid(), grade.getGscore(), grade.getGtime(),
				grade.getGstate(), grade.getGdel());
		message = n > 0 ? "添加成功" : "添加失败";
		return message;
	}

	/**
	 * 修改成绩
	 * 
	 * @param Gscore
	 * @param Sid
	 * @param Lid
	 * @return
	 */
	public String update(Grade grade) {
		String message = null;
		String sql = "update grade set Gscore=?,Gtime=?,Gstate=0 where Lid=? and Sid=?";
		int n = gradedao.modify(sql, grade.getGscore(), grade.getGtime(), grade.getLid(), grade.getSid());
		message = n > 0 ? "修改成功" : "修改失败";
		return message;
	}

	/**
	 * 
	 * @param Gid
	 * @return
	 */
	public Grade select(String Gid) {
		String sql = "select * from grade where Gid=?";
		Grade grade = gradedao.select(Grade.class, sql, Gid);
		return grade;
	}

	/**
	 * 删除成绩,状态1(已审核)状态------>0(隐藏)状态
	 * 
	 * @param Sid
	 * @param Lid
	 * @return
	 */
	public String updategrade(int Gid) {
		String message = null;
		String sql = "update grade set Gstate=0 and Gdel=1 where Gid=? and Gstate=1";
		int n = gradedao.modify(sql, Gid);
		message = n > 0 ? "删除成功" : "删除失败";
		return message;
	}

}
