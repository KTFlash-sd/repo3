package cn.kgc.tangcco.wuxin.login.dao.imp;

import java.util.List;

import cn.kgc.tangcco.entity.Account;
import cn.kgc.tangcco.entity.Menu;
import cn.kgc.tangcco.util.JDBCUtil;
import cn.kgc.tangcco.util.PageBean;

public class MenuDaoImp extends JDBCUtil<Menu>{
	/**
	 * 用户操作的分页方法,没有条件
	 */
	public List<Menu> queryPage(PageBean pagebean){
		List<Menu> mlist=null;
		String sql="select * from menu limit "+pagebean.getRowindex()+","+pagebean.getPagesize();
		mlist=query(Menu.class, sql);
		return mlist;
	}
}
