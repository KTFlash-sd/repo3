package cn.kgc.tangcco.zhangyu.work.service;

import java.util.List;

import cn.kgc.tangcco.entity.Work;
import cn.kgc.tangcco.util.PageBean;
import cn.kgc.tangcco.zhangyu.work.entity.WorkBean;

public interface WorkService {

	/**
	 * 分页查迅
	 */
	List<WorkBean> querypage(int index, PageBean pageBean, String thispage);

	/**
	 * 删除
	 */
	int delete(int Wid);

	/**
	 * 添加
	 */
	int addWork(Work work);

	/**
	 * 修改
	 */
	int updateWork(Work work);
	 WorkBean work(int wid) ;
}