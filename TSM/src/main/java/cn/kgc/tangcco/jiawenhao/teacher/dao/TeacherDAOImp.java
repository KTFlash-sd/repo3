package cn.kgc.tangcco.jiawenhao.teacher.dao;

import java.util.List;

import cn.kgc.tangcco.entity.Teacher;
import cn.kgc.tangcco.util.JDBCUtil;
import cn.kgc.tangcco.util.PageBean;
/**
 * 
 * @author 贾文豪
 *
 */
public class TeacherDAOImp extends JDBCUtil<Teacher>{
	//查询分页方法 状态为通过状态
	public List<Teacher> queryPage(PageBean pagebean){
		List<Teacher> list=null;
		String sql="select * from teacher where Tstate=1 limit "+pagebean.getRowindex()+","+pagebean.getPagesize();
		list=query(Teacher.class, sql);
		return list;
	}
	
	//查询分页方法 状态为需要审核状态
		public List<Teacher> notQueryPage(PageBean pagebean){
			List<Teacher> list=null;
			String sql="select * from teacher limit  where Sstate=0 "+pagebean.getRowindex()+","+pagebean.getPagesize();
			list=query(Teacher.class, sql);
			return list;
		}
}
