package cn.kgc.tangcco.zhangyu.major.daoimp;

import java.util.List;

import cn.kgc.tangcco.entity.Major;
import cn.kgc.tangcco.util.JDBCUtil;

public class MajorDAOImp extends JDBCUtil<Major> {
	/**
	 * 查询全部专业
	 * @return
	 */
public List<Major> querymaMajors(){
	String sql="select * from major where MAdel=1";
	List<Major> list=query(Major.class, sql);
	return list;
}
/**
 * 添加方法
 * @param major
 * @return
 */
public int add(Major major) {
	int i=-1;
	String sql="insert into major value(null,?,1,1)";
	i=modify(sql,major.getMAname());
	return i;
}
/**
 * 删除方法
 */
public int del(int maid) {
	int i=-1;
	String sql="update major set MAdel=0 where MAid=?";
	i=modify(sql,maid);
	return i;
}
}
