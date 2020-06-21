package cn.kgc.tangcco.zhangyu.lesson.daoimp;

import java.util.List;

import cn.kgc.tangcco.entity.Lesson;
import cn.kgc.tangcco.util.JDBCUtil;

public class LessonDAOImp extends JDBCUtil<Lesson> {
 public List<Lesson> list(){
	 String sql="select * from lesson where Lstate=1 and Ldel=1";
			 List<Lesson> list= query(Lesson.class, sql);
			 return list;
 }
}
