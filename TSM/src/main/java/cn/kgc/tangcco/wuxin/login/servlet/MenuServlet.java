package cn.kgc.tangcco.wuxin.login.servlet;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.kgc.tangcco.entity.Account;
import cn.kgc.tangcco.entity.Menu;
import cn.kgc.tangcco.util.MyServlet;
import cn.kgc.tangcco.util.PageBean;
import cn.kgc.tangcco.wuxin.login.service.imp.AccountServiceImp;
import cn.kgc.tangcco.wuxin.login.service.imp.MenuServiceImp;
import cn.kgc.tangcco.wuxin.login.service.imp.RoleServiceImp;

@WebServlet("/menu.do")
public class MenuServlet extends MyServlet{
	
	private static final long serialVersionUID = 8774020463768688445L;
	private AccountServiceImp accountservice=new AccountServiceImp();
	private RoleServiceImp roleservice=new RoleServiceImp();
	private MenuServiceImp menuservice=new MenuServiceImp();
	
	//查询所有菜单
			protected void query(HttpServletRequest request,HttpServletResponse response) {
				
				String thispage=request.getParameter("thispage");
				PageBean pagebean=new PageBean();
				List<Menu> menus=menuservice.pageMenu(pagebean, thispage);
				request.setAttribute("menus", menus);
				List<Menu> menulist= menuservice.queryMenu();
				request.setAttribute("mlist", menulist);
				request.setAttribute("pagebean", pagebean);
				forward("/menu/menulist.jsp", request, response);
			}
			
			//添加菜单
			protected void add(HttpServletRequest request,HttpServletResponse response) {	
				try {
					int mid=-1;
					String mname=request.getParameter("mname");
					System.out.println(mname);
					String mrul=request.getParameter("murl");
					String fmid=request.getParameter("fmid");
					String mrank=request.getParameter("mrank");
					String mstate=request.getParameter("mstate");
					String mdel=request.getParameter("mdel");
					Menu menu=new Menu(mid, mname, mrul, Integer.parseInt(fmid), Integer.parseInt(mrank), 1, 1);
					menu.setMdel(1);
					menu.setMfid(Integer.parseInt(fmid));
					menu.setMid(mid);
					menu.setMurl(mrul);
					menu.setMname(mname);
					menu.setMrank(Integer.parseInt(mrank));
					menu.setMstate(1);
					String message=menuservice.addMenu(menu);
					request.setAttribute("message", message);
					forward("/menu/succuss.jsp", request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
			
			//根据一个id查询一个菜单
		     protected void select(HttpServletRequest request,HttpServletResponse response) {
						String mid=request.getParameter("mid");
						System.out.println(mid);
						Menu menu=menuservice.find(Integer.parseInt(mid));
						List<Menu> menulist=menuservice.queryMenu();
						request.setAttribute("menulist", menulist);
						request.setAttribute("menu", menu);
					  forward("/menu/updatemenu.jsp", request, response);
			 }
				
		   //修改菜单
		     protected void update(HttpServletRequest request,HttpServletResponse response) {
		    	 	String mid=request.getParameter("mid");
					String mname=request.getParameter("mname");
					String mrul=request.getParameter("murl");
					String mfid=request.getParameter("mfid");
					String mrank=request.getParameter("mrank");
					String mstate=request.getParameter("mstate");
					String mdel=request.getParameter("mdel");
					Menu menu=new Menu(Integer.parseInt(mid), mname, mrul, Integer.parseInt(mfid), Integer.parseInt(mrank), 1, 1);
					menu.setMfid(Integer.parseInt(mfid));
					menu.setMid(Integer.parseInt(mid));
					menu.setMname(mname);
					menu.setMurl(mrul);
					menu.setMrank(Integer.parseInt(mrank));
					String message=menuservice.updateMenu(menu);
					request.setAttribute("message", message);
					forward("/menu/menuhint.jsp", request, response);
					//query(request,response);
			 }
		    //删除菜单
		     protected void delete(HttpServletRequest request,HttpServletResponse response) {
		    	 String mid=request.getParameter("mid");
					menuservice.fakeDelMenu(Integer.parseInt(mid));
					query(request,response);
		     }
	
}
