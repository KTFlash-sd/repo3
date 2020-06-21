package cn.kgc.tangcco.wuxin.login.servlet;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.kgc.tangcco.entity.Menu;
import cn.kgc.tangcco.entity.Role;
import cn.kgc.tangcco.util.MyServlet;
import cn.kgc.tangcco.util.PageBean;
import cn.kgc.tangcco.wuxin.login.service.imp.AccountServiceImp;
import cn.kgc.tangcco.wuxin.login.service.imp.MenuServiceImp;
import cn.kgc.tangcco.wuxin.login.service.imp.RoleServiceImp;
@WebServlet("/role.do")
public class RoleServlet extends MyServlet {
	private static final long serialVersionUID = 8774020463768688447L;
	private AccountServiceImp accountservice=new AccountServiceImp();
	private RoleServiceImp roleservice=new RoleServiceImp();
	private MenuServiceImp menuservice=new MenuServiceImp();
	
	//查询所有角色
	protected void query(HttpServletRequest request,HttpServletResponse response) {
		
		String thispage=request.getParameter("thispage");
		PageBean pagebean=new PageBean();
		List<Role> roles=roleservice.pageRoles(pagebean, thispage);
		request.setAttribute("rlist", roles);
		request.setAttribute("pagebean", pagebean);
		forward("/role/rolelist.jsp", request, response);
	}
	
	// 查询某个角色及它的菜单
		protected void rolemenu(HttpServletRequest request, HttpServletResponse response) {
			String rid = request.getParameter("rid");
			Role role = roleservice.find(Integer.parseInt(rid));//查看指定id的角色，
			List<Menu> menus = menuservice.selectbyrid(rid);//查看角色对应的菜单
			List<Menu> menulist=menuservice.queryMenu();//查看所有菜单
			request.setAttribute("role", role);
			request.setAttribute("rmenu", menus);
			request.setAttribute("menulist", menulist);
			forward("/role/rolemenu.jsp", request, response);
		}
		
	//添加角色
	protected void add(HttpServletRequest request,HttpServletResponse response) {
		String rname=request.getParameter("Rname");
		Role role=new Role();
		role.setRname(rname);
		String message=roleservice.addRole(role);
		if (role!=null&&!(role.getRname().equals(rname))) {
			request.setAttribute("message", message);
			forward("role/s.jsp", request, response);
		}else {
			request.setAttribute("messages", message);
			forward("role/f.jsp", request, response);
		}
		
	}
	
	//查询一个角色
     protected void select(HttpServletRequest request,HttpServletResponse response) {
				String rid=request.getParameter("rid");
				Role role=roleservice.find(Integer.parseInt(rid));

				request.setAttribute("role", role);
				
				//查询角色对应的菜单
				
				
			  forward("/role/rolemenu.jsp", request, response);
	 }
		
   //修改角色
     protected void update(HttpServletRequest request,HttpServletResponse response) {
    	 	String rid=request.getParameter("Rid");
 			String rname=request.getParameter("Rname");
 			String rstate=request.getParameter("Rstate");
 			String rdel=request.getParameter("Rdel");
 			List<Menu> menus=roleservice.rolemenu(Integer.parseInt(rid));
 			Role role=new Role(Integer.parseInt(rid), rname, Integer.parseInt(rstate), Integer.parseInt(rdel), menus);
 			roleservice.updateRole(role);
 			query(request,response);
	 }
    //删除角色
     protected void delete(HttpServletRequest request,HttpServletResponse response) {
    	 	String rid=request.getParameter("rid");
			roleservice.fakeDelRole(Integer.parseInt(rid));
			query(request,response);
     }
     
   //修改角色对应的菜单
 	protected void updateRM(HttpServletRequest request, HttpServletResponse response) {
 		int rid=-1;
 		String rid1 = request.getParameter("rid");
 		String rname = request.getParameter("rname");
 		String[] mids=request.getParameterValues("mid");
 		Role role=new Role(rid,rname);
 	    if(mids!=null&&mids.length>0) {
 	    	roleservice.updateRole(role);
 	    	roleservice.update_menu(rid1, mids);
 	    }
 	    query(request,response);
     }
}
