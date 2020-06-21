package cn.kgc.tangcco.zhangyu.work.daoimp;

import java.util.List;

import cn.kgc.tangcco.entity.Work;
import cn.kgc.tangcco.util.JDBCUtil;
import cn.kgc.tangcco.util.PageBean;
import cn.kgc.tangcco.zhangyu.UtilDate;
import cn.kgc.tangcco.zhangyu.work.entity.WorkBean;

public class WorkDAOImp extends JDBCUtil<WorkBean> {

	/**
	 * 查询所有
	 */
	public List<WorkBean> query(int index){
		List<WorkBean> list=null;
		if (index>0) {
			String sql="select  wo.Wid, cla.Cname,le.Lname,te.Tname,wo.Wstart,wo.Wend,wo.Wtime  from work as wo left join classroom as cla on wo.Cid=cla.Cid left join lesson as le on le.Lid=wo.Lid left join teacher as te on te.Tid=wo.Tid  where wo.Wdel=1 and cla.Cid="+index;
			list=query(WorkBean.class, sql);
		}else {
			String sql="select  wo.Wid, cla.Cname,le.Lname,te.Tname,wo.Wstart,wo.Wend,wo.Wtime  from work as wo left join classroom as cla on wo.Cid=cla.Cid left join lesson as le on le.Lid=wo.Lid left join teacher as te on te.Tid=wo.Tid  where wo.Wdel=1";
			list=query(WorkBean.class, sql);
		}
		
		return list;
	}
	/**
	 * 分页查询所有,可根据班级查找
	 * @param pageBean
	 * @return
	 */
	public List<WorkBean> querypage(int index,PageBean pageBean){
		List<WorkBean > list=null;
		if (index >0) {
			String sql="select wo.Wid, cla.Cname,le.Lname,te.Tname,wo.Wstart,wo.Wend,wo.Wtime  from work as wo left join classroom as cla on wo.Cid=cla.Cid left join lesson as le on le.Lid=wo.Lid left join teacher as te on te.Tid=wo.Tid  "
					+" where wo.Wdel=1 and cla.Cid="+index+" limit "+pageBean.getRowindex()+" , "+pageBean.getPagesize();
			list=query(WorkBean.class,sql);
		}else {
			String sql="select  wo.Wid, cla.Cname,le.Lname,te.Tname,wo.Wstart,wo.Wend,wo.Wtime  from work as wo left join classroom as cla on wo.Cid=cla.Cid left join lesson as le on le.Lid=wo.Lid left join teacher as te on te.Tid=wo.Tid  "
				+" where wo.Wdel=1 "+" limit "+pageBean.getRowindex()+" , "+pageBean.getPagesize();
			list=query(WorkBean.class,sql);
		}
		return list;
	}
	/**
	 * 删除
	 */
	public int delete(int Wid) {
		int i=-1;
		String sql="update work set Wdel=0 where Wid=?";
		i=modify(sql, Wid);
		return i;
	}
	/**
	 * 添加
	 */
	public int addWork(Work work) {
		int i=-1;
		String sql="insert into work values(null,?,?,?,?,?,?,?,?)";
		Object[] objects= {
				work.getCid(),work.getLid(),work.getTid(),UtilDate.DatetoString1(work.getWstart()),UtilDate.DatetoString1(work.getWend()),work.getWtime(),work.getWstate(),work.getWdel()
		};
		i=modify(sql, objects);
		return i;
	}
	/**
	 * 修改
	 */
	public int updateWork(Work work) {
		int i=-1;
		String sql="update work set Cid=?,Lid=?,Tid=?,Wstart=?,Wend=?,Wtime=? where Wdel=1 and Wid=?";
		Object[] objects= {
				work.getCid(),work.getLid(),work.getTid(),UtilDate.DatetoString1(work.getWstart()),UtilDate.DatetoString1(work.getWend()),work.getWtime(),work.getWid()
		};
		i=modify(sql, objects);
		return i;
	}
	/**
	 * 查询单个对象
	 * @param wid
	 * @return
	 */
	public WorkBean bean(int wid) {
		String sql="select wo.Wid, cla.Cname,le.Lname,te.Tname,wo.Wstart,wo.Wend,wo.Wtime  from work as wo left join classroom as cla on wo.Cid=cla.Cid left join lesson as le on le.Lid=wo.Lid left join teacher as te on te.Tid=wo.Tid   where Wdel=1 and wo.Wid=?";
		WorkBean work=null;
		work=find(WorkBean.class, sql,wid);
		return work;
	}
	
}
