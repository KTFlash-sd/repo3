package cn.kgc.tangcco.zhangyu.work.service.serviceimp;

import java.util.List;

import cn.kgc.tangcco.entity.Work;
import cn.kgc.tangcco.util.PageBean;
import cn.kgc.tangcco.zhangyu.work.daoimp.WorkDAOImp;
import cn.kgc.tangcco.zhangyu.work.entity.WorkBean;
import cn.kgc.tangcco.zhangyu.work.service.WorkService;

public class WorkServiceImp implements WorkService {
WorkDAOImp dao;
/**
 * 分页查迅
 */
@Override
public List<WorkBean> querypage(int index,PageBean pageBean,String thispage) {
	List<WorkBean> list=null;
	pageBean.setTotalsize(dao.query(index).size());//设置总数据量
	pageBean.setThispage(thispage);
	list=dao.querypage(index, pageBean);
	return list;
}
/**
 * 删除
 */
@Override
public int delete(int Wid) {
	int i=-1;
	i=dao.delete(Wid);
	return i;
}
/**
 * 添加
 */
@Override
public int addWork(Work work) {
	int i=-1;
	if (work!=null) {
		return i=dao.addWork(work);
	}else {
		return i;
	}
}
/**
 * 修改
 */
@Override
public int updateWork(Work work) {
	int i=-1;
	i=dao.updateWork(work);
	return i;
}
/**
 * 查询单个对象
 */
public WorkBean work(int wid) {
	WorkBean work=dao.bean(wid);
	return work;
}
}
