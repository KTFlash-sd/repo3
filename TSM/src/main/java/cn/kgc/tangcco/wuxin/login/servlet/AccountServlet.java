package cn.kgc.tangcco.wuxin.login.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONArray;

import cn.kgc.tangcco.entity.Account;
import cn.kgc.tangcco.entity.Role;
import cn.kgc.tangcco.util.MyServlet;
import cn.kgc.tangcco.util.PageBean;
import cn.kgc.tangcco.wuxin.login.service.imp.AccountServiceImp;
import cn.kgc.tangcco.wuxin.login.service.imp.RoleServiceImp;

@WebServlet("/account.do")
public class AccountServlet extends MyServlet{
    /**
	 * 
	 */
	private static final long serialVersionUID = 8774020463768688475L;
	private AccountServiceImp accountservice=new AccountServiceImp();
	private RoleServiceImp roleservice=new RoleServiceImp();
	 
	//登录方法
	protected void login(HttpServletRequest request,HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setCharacterEncoding("UTF-8");
		String username=request.getParameter("username");
		String psd=request.getParameter("psd");
		Account account=accountservice.islogin(username, psd);
		if(account==null ) {
			request.setAttribute("message", "登录失败");
			forward("/showmessage.jsp", request, response);
		}
		else {
			request.getSession().setAttribute("account", account);
			forward("/index1.jsp", request, response);
		}
}

	   //查询所有用户
		protected void query(HttpServletRequest request,HttpServletResponse response) {
			
			String thispage=request.getParameter("thispage");
			PageBean pagebean=new PageBean();
			List<Account> accounts=accountservice.querypage(pagebean, thispage);
			
			request.setAttribute("alist", accounts);
			request.setAttribute("pagebean", pagebean);
			forward("/account/accountlist.jsp", request, response);
		}
		
		//查询所有角色
		protected void queryrole(HttpServletRequest request,HttpServletResponse response) {
			
			List<Role> rolelist=roleservice.queryRole();
			//把集合转为jsonarray
			String text=JSONArray.toJSONString(rolelist);
			try {
				response.getWriter().print(text);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//添加用户
		protected void add(HttpServletRequest request,HttpServletResponse response) {
			int aid=-1;
			String username=request.getParameter("username");
			String password=request.getParameter("psd");
			String rid=request.getParameter("Rid");
			String astate=request.getParameter("astate");
			String adel=request.getParameter("adel");
			Account account=new Account(aid,username,password,Integer.parseInt(rid),1,1);
			String message=accountservice.addAccount(account);
			if (account!=null && !(username.equals(account.getUsername()))) {
				request.setAttribute("message", message);
				forward("/account/accounthint.jsp", request, response);
			}else {
				request.setAttribute("messages", message);
				forward("/account/fail.jsp", request, response);
			}
		}
		
		//查询一个用户
	     protected void select(HttpServletRequest request,HttpServletResponse response) {
					String aid=request.getParameter("aid");
					Account account=accountservice.find(Integer.parseInt(aid));
					request.setAttribute("account", account);
					forward("/account/updateaccount.jsp", request, response);
		 }
			
	   //修改用户
	     protected void update(HttpServletRequest request,HttpServletResponse response) {
	    	 	String aid=request.getParameter("aid");
	    	 	System.out.println(aid);
	    	 	String username=request.getParameter("username");
	    	 	String password=request.getParameter("psd");
	    	 	String rid=request.getParameter("rid");
	    	 	String astate=request.getParameter("astate");
				String adel=request.getParameter("adel");
				Account account=new Account(Integer.parseInt(aid),username,password,Integer.parseInt(rid),Integer.parseInt(astate),1);
				account.setAid(Integer.parseInt(aid));
				account.setAstate(Integer.parseInt(astate));
				account.setPassword(password);
				account.setRid(Integer.parseInt(rid));
				String message=accountservice.updateAccount(account);
				request.setAttribute("message", message);
				forward("/account/accounthint.jsp", request, response);
				
				
		 }
	    //删除用户
	     protected void delete(HttpServletRequest request,HttpServletResponse response) {
				String aid=request.getParameter("aid");
				accountservice.fakeDelAccount(Integer.parseInt(aid));
				query(request,response);
	     }
	     
	     //注册方法
	     protected void reg(HttpServletRequest request,HttpServletResponse response) {
	    	 int aid=-1;
	    	 String username=request.getParameter("username");
	 			String psd=request.getParameter("password");
	 			String psd1=request.getParameter("confirm_password");
	 			String rid=request.getParameter("check");
	 			String astate=request.getParameter("astate");
	 			String adel=request.getParameter("adel");
	 			Account account=new Account(-1,username, psd,Integer.parseInt(rid),Integer.parseInt(astate),Integer.parseInt(adel));
	 			String accounts=accountservice.addAccount(account);
	 			if (username!=null&&username.equals(account.getUsername())) {
	 				try {
						response.getWriter().print("0");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	 				System.out.println(11565);
	 			}else {
	 				try {
						response.getWriter().print("1");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	 				System.out.println(11);
	 			}
	 			if(account!=null) {
	 				request.setAttribute("account", accounts);
	 				forward("/hint.jsp", request, response);
	 			}else {
	 				request.setAttribute("message", "注册失败");
	 				forward("/showmessage.jsp", request, response);
	 			}
	     }
	
}
