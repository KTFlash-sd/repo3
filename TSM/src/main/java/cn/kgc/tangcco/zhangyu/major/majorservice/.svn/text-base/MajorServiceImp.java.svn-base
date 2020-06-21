package cn.kgc.tangcco.zhangyu.major.majorservice;

import java.util.List;

import cn.kgc.tangcco.entity.Major;
import cn.kgc.tangcco.wuxin.test1;
import cn.kgc.tangcco.zhangyu.major.daoimp.MajorDAOImp;

public class MajorServiceImp {
MajorDAOImp dao=new MajorDAOImp();
/**
 * 查询方法
 */
public List<Major> queryMajors(){
	List<Major> list=dao.querymaMajors();
	return list;
}
/**
 * 删除方法
 */
public int del(int maid) {
	int i=dao.del(maid);
	return i;
}
/**
 * 添加方法
 */
public int add(Major major) {
	int i=-1;
	i=dao.add(major);
	return i;
}
}
