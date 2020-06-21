package cn.kgc.tangcco.wuxin.login.service.imp;

import java.util.ArrayList;
import java.util.List;

import cn.kgc.tangcco.entity.Account;
import cn.kgc.tangcco.entity.Menu;
import cn.kgc.tangcco.entity.Role;
import cn.kgc.tangcco.util.PageBean;
import cn.kgc.tangcco.wuxin.login.dao.imp.MenuDaoImp;
import cn.kgc.tangcco.wuxin.login.dao.imp.RoleDaoImp;

public class RoleServiceImp {
	RoleDaoImp roledao=new RoleDaoImp();
	MenuDaoImp menudao=new MenuDaoImp();
	//查询所有角色
		public List<Role> queryRole(){
			String sql="select * from role where Rdel='1'";
			List<Role> list=roledao.query(Role.class, sql);
			return list;
		}
		
		//分页查询角色
		public List<Role> pageRoles(PageBean pagebean, String thispage){
			List<Role> list=new ArrayList<Role>();
			List<Role> lists=queryRole();
			pagebean.setTotalsize(lists.size());
			pagebean.setThispage(thispage);
			int index=pagebean.getRowindex();
			int count=index+pagebean.getPagesize();
			count=count>lists.size()?lists.size():count;
			for (int i = index; i < count; i++) {
				list.add(lists.get(i));
			}
			return list;
		}
		
		
		//添加请求
		public String addRole(Role role) {
			String message=" ";
			Role a=find(role.getRid());
			if (a!=null) {
				message="添加失败，角色已存在";
			}else {
					String sql="insert into role values(role.Rid,?,1,1)";
					int n=roledao.modify(sql, role.getRname());
					message=n>0?"添加成功":"添加失败";
				}
			return message;
		}
		/**
		 * 找到一个角色对象
		 * @param aid
		 * @return
		 */
		public Role find(int rid) {
			String sql="select * from role where Rid=?";
			Role role=(Role) roledao.find(Role.class, sql, rid);
			
			return role;
		}
		/**
		 * 假删除业务
		 * @param aid
		 * @return
		 */
		public String fakeDelRole(int rid) {
			String message="";
			String sql="update role set Rdel='0' where Rid=?";
			int n=roledao.modify(sql,rid);
			message=n>0?"删除成功":"删除失败"; 
			return message;
			
		}
		/**
		 * 
		 * @param aid
		 * @return 真删除业务
		 */
		public String delRole(int rid) {
			String message="";
			String sql="delete from role where Rid=?";
			int n=roledao.modify(sql, rid);
			message=n>0?"删除成功":"删除失败";
			return message;
		}
		/**
		 * 
		 * @param account
		 * @return 修改角色业务
		 */
		public String updateRole(Role role) {
			String message="";
			String sql="update role set Rname=? where Rid=?";
			int n=roledao.modify(sql, role.getRname(),role.getRid());
			message=n>0?"修改成功":"修改失败";
			return message;
			
		}
	/**
	 * 角色菜单关联业务
		 */
		public List<Menu> rolemenu(int Rid){
		String sql="SELECT * FROM menu WHERE Mstate!=0 AND Mid IN(SELECT Mid FROM role_menu WHERE Rid="+Rid+")";
			List<Menu> menus=menudao.query(Menu.class, sql);
			return menus;
		}
		
		//修改角色关联的菜单
	     public int update_menu(String rid,String[] mids) {
	    	 String sql="delete from role_menu where Rid=?";
	    	 int i=roledao.modify(sql,rid);
	    	 StringBuffer str=new StringBuffer("insert into role_menu values");
	    	 for (String string : mids) {
	    		 str.append("(role_menu.RMid,"+rid+","+string+"),");
			 }
	    	 String text=str.toString();
	    	 System.out.println(text.substring(0,text.length()-1));
	    	 i=roledao.modify(text.substring(0,text.length()-1));
	    	 return i;
	     }
}
