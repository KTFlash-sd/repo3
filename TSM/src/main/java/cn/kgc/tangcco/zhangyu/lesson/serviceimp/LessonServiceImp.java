package cn.kgc.tangcco.zhangyu.lesson.serviceimp;

import java.util.List;

import cn.kgc.tangcco.entity.Lesson;
import cn.kgc.tangcco.zhangyu.lesson.daoimp.LessonDAOImp;

public class LessonServiceImp {
LessonDAOImp dao=new LessonDAOImp();
/**
 * 查询所有
 */
public List<Lesson> list(){
	List<Lesson> list=dao.list();
	return list;
}
}
