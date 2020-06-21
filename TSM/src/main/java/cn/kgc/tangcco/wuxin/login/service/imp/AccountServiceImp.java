package cn.kgc.tangcco.wuxin.login.service.imp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;

import cn.kgc.tangcco.entity.Account;
import cn.kgc.tangcco.entity.Menu;
import cn.kgc.tangcco.entity.Role;
import cn.kgc.tangcco.util.PageBean;
import cn.kgc.tangcco.wuxin.login.dao.imp.AccountDaoImp;
import cn.kgc.tangcco.wuxin.login.dao.imp.MenuDaoImp;
import cn.kgc.tangcco.wuxin.login.dao.imp.RoleDaoImp;

public class AccountServiceImp {
		AccountDaoImp accountdao=new AccountDaoImp();
		RoleDaoImp roledao=new RoleDaoImp();
		MenuDaoImp menudao=new MenuDaoImp();
    
    /**
     * 登录业务
     */
    public Account islogin(String username,String password) {
   	 String sql="select * from account where username=? and password=? and Astate=1";//sql语句查询用户表传入用户名和密码，状态为1可用
   	 Account account=accountdao.select(Account.class, sql, username,password);//从数据库查询出用户对象
   	 if(account!=null)//当用户对象不为空时
   	 {
   		String sql1="select * from role where Rid=?"; //查询该对象的角色
   		Role role=roledao.select(Role.class, sql1, account.getRid());//从数据库查询到角色对象
   		String sql2="select * from menu where Mid in (select Mid from role_menu where Rid=?)";//查询菜单在角色id拥有的菜单范围内
   	    List<Menu> menulist=menudao.query(Menu.class, sql2, account.getRid());//查询角色拥有的菜单列表
   	 
   	    role.setRolemenu(menulist);//赋值菜单列表到角色
   	    account.setRole(role);//赋值角色到用户
   	    return account;//返回用户
   	 }
   	 else {
   		 return null;
   	 }
    }
    
    //查询所有用户
	public List<Account> queryAccount(){
		String sql="select * from account where Adel='1'";
		List<Account> list=accountdao.query(Account.class, sql);
		return list;
	}
	
	 //分页查询
    public List<Account> querypage(PageBean pagebean,String thispage){
   	 List<Account> accountlist=new ArrayList<Account>();
   	 pagebean.setTotalsize(queryAccount().size());
   	 pagebean.setThispage(thispage);
   	 String sql="select * from account where Adel='1' limit ?,?";
   	 accountlist=accountdao.query(Account.class, sql, pagebean.getRowindex(),pagebean.getPagesize());
   	//给用户分配角色
   	 for (Account account : accountlist) {
   		 accountorole(account);
		}
   	 	return accountlist;
    }
	
	
    //给用户付角色
    public void accountorole(Account account) {
   	    String sql1="select * from role where Rid=?";
			Role role=roledao.select(Role.class, sql1, account.getRid());
			account.setRole(role);
    }
   
	//添加请求
	public String addAccount(Account account) {
		String message=" ";
		Account a=find(account.getAid());
		if (a!=null) {
			message="添加失败，用户已存在";
		}else {
				String sql="insert into account values(account.Aid,?,?,?,?,?)";
				int n=accountdao.modify(sql, account.getUsername(),account.getPassword(),account.getAstate(),account.getRid(),account.getAdel());
				message=n>0?"添加成功":"添加失败";
			}
		return message;
	}
	/**
	 * 找到一个用户对象
	 * @param aid
	 * @return
	 */
	public Account find(int aid) {
		String sql="select * from account where Aid=?";
		Account account=(Account) accountdao.find(Account.class, sql, aid);
		if(account!=null)
		accountorole(account);//给用户付角色
		return account;
	}
	/**
	 * 假删除业务
	 * @param aid
	 * @return
	 */
	public String fakeDelAccount(int aid) {
		String message="";
		String sql="update account set Adel='0' where Aid=?";
		int n=accountdao.modify(sql, aid);
		message=n>0?"删除成功":"删除失败"; 
		System.out.println(message);
		return message;
		
	}
	/**
	 * 
	 * @param aid
	 * @return 真删除业务
	 */
	public String delAccount(int aid) {
		String message="";
		String sql="delete from account where Aid=?";
		int n=accountdao.modify(sql, aid);
		message=n>0?"删除成功":"删除失败";
		return message;
	}
	/**
	 * 
	 * @param account
	 * @return 修改用户业务
	 */
	public String updateAccount(Account account) {
		String message="";
		String sql="update account set username=?,password=?,Rid=?,Astate=?,Adel=? where Aid=?";
		int n=accountdao.modify(sql, account.getUsername(),account.getPassword(),account.getRid(),account.getAstate(),account.getAdel(),account.getAid());
		message=n>0?"修改成功":"修改失败";
		return message;
	}
    
	
}
