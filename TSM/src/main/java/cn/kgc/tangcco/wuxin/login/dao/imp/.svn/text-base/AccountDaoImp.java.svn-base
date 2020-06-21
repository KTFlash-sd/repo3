package cn.kgc.tangcco.wuxin.login.dao.imp;

import java.util.List;

import cn.kgc.tangcco.entity.Account;
import cn.kgc.tangcco.util.JDBCUtil;
import cn.kgc.tangcco.util.PageBean;

public class AccountDaoImp extends JDBCUtil<Account>{
	/**
	 * 用户操作的分页方法,没有条件
	 */
	public List<Account> queryPage(PageBean pagebean){
		List<Account> alist=null;
		String sql="select * from account limit "+pagebean.getRowindex()+","+pagebean.getPagesize();
		alist=query(Account.class, sql);
		return alist;
	}
	
	
}
