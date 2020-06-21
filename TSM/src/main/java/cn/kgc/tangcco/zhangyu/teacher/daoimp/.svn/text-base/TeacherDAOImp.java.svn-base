package cn.kgc.tangcco.zhangyu.teacher.daoimp;

import java.util.List;

import cn.kgc.tangcco.entity.Teacher;
import cn.kgc.tangcco.util.JDBCUtil;

public class TeacherDAOImp extends JDBCUtil<Teacher> {
public List<Teacher> list(){
	String sql="select * from teacher where Tstate=1 and Tdel=1";
	List<Teacher> list=query(Teacher.class, sql);
	return list;
}
}
