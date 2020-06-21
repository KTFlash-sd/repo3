package cn.kgc.tangcco.guomingchao.grade.dao.imp;

import java.util.List;

import cn.kgc.tangcco.entity.Grade;
import cn.kgc.tangcco.entity.Lesson;
import cn.kgc.tangcco.entity.Student;
import cn.kgc.tangcco.util.JDBCUtil;
import cn.kgc.tangcco.util.PageBean;

public class GradeDAOImp extends JDBCUtil<Grade> {

	/**
	 * 成绩分页查询所有
	 * 
	 * @param pagebean
	 * @param objects
	 * @return
	 */
	public List<Grade> queryPage(PageBean pagebean, Object... objects) {
		List<Grade> alist = null;
		// String sql = "select * from grade limit " + pagebean.getRowindex() + "," +
		// pagebean.getPagesize();

		String sql = "select g.*, s.Sname,l.Lname from grade g left join student s on g.Sid=s.Sid left join lesson l on g.Lid=l.Lid limit "
				+ pagebean.getRowindex() + "," + pagebean.getPagesize();
		alist = query(Grade.class, sql);
		return alist;
	}

	/**
	 * 成绩分页查询，Gstate=1 and Gdel=1，只显示所有已启用成绩
	 * 
	 * @param pagebean
	 * @param objects
	 * @return
	 */
	public List<Grade> queryPage1(PageBean pagebean, Object... objects) {
		List<Grade> alist = null;
		String sql = "select g.*, s.Sname,l.Lname from grade g left join student s on g.Sid=s.Sid left join lesson l on g.Lid=l.Lid where Gstate=1 and Gdel=1 limit "
				+ pagebean.getRowindex() + "," + pagebean.getPagesize();
		alist = query(Grade.class, sql);
		return alist;
	}

	/**
	 * 成绩分页查询，Gstate=0 and Gdel=1，只显示所有未已启用成绩
	 * 
	 * @param pagebean
	 * @param objects
	 * @return
	 */
	public List<Grade> queryPage2(PageBean pagebean, Object... objects) {
		List<Grade> alist = null;
		String sql = "select g.*, s.Sname,l.Lname from grade g left join student s on g.Sid=s.Sid left join lesson l on g.Lid=l.Lid where Gstate=0 and Gdel=1 limit "
				+ pagebean.getRowindex() + "," + pagebean.getPagesize();
		alist = query(Grade.class, sql);
		return alist;
	}

	/**
	 * 按照学生id查询该学生所有课程成绩
	 * 
	 * @param Sid
	 * @return
	 */
	public List<Grade> gid(int Sid) {
		List<Grade> alist = null;
		String sql = "select g.*, s.Sname,l.Lname from grade g left join student s on g.Sid=s.Sid left join lesson l on g.Lid=l.Lid where s.Sid ="
				+ Sid;
		alist = query(Grade.class, sql);
		return alist;
	}

	/**
	 * 按照课程id查询所有学生该课程成绩
	 * 
	 * @param Lid
	 * @return
	 */
	public List<Grade> gid2(int Lid) {
		List<Grade> alist = null;
		String sql = "select g.*, s.Sname,l.Lname from grade g left join student s on g.Sid=s.Sid left join lesson l on g.Lid=l.Lid where l.Lid="
				+ Lid;
		alist = query(Grade.class, sql);
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
		String sql = "select g.*, s.Sname,l.Lname from grade g left join student s on g.Sid=s.Sid left join lesson l on g.Lid=l.Lid where l.Lid ="
				+ Lid + " and s.Sid=" + Sid;
		grade = select(Grade.class, sql);
		return grade;
	}

}
