package cn.kgc.tangcco.zhangyu.classroom.classroomdaoimp;

import java.util.List;

import cn.kgc.tangcco.entity.Classroom;
import cn.kgc.tangcco.util.JDBCUtil;

public class ClassRoomDAOImp extends JDBCUtil<Classroom> {
	/**
	 * 查询所有
	 * @return
	 */
public List<Classroom> list(){
	String sql="select * from classroom where Cdel=1 and Cstate=1";
	List<Classroom> list=query(Classroom.class, sql);
	return list;
}
}
