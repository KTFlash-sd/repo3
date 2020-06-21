package cn.kgc.tangcco.util;

//分页类
public class PageBean {
    private int pagesize=8;//每页的记录数
    private int totalsize=0;//总记录数    程序员需要赋值
    private int totalpage=0;//总页数
    private int thispage=1;//当前页        程序员需要赋值
    private int rowindex=0;//当前页的第一条记录时总记录中的下标
    
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	
	public int getTotalsize() {
		return totalsize;
	}
	public void setTotalsize(int totalsize) {
		this.totalsize = totalsize;
	}
	public int getTotalpage() {
		totalpage= (getTotalsize()+getPagesize()-1)/getPagesize();
		return totalpage;
	}
	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}
	public int getThispage() {
		return thispage;
	}
	public void setThispage(String thispage) {
		this.thispage= thispage==null||thispage.equals("")?1:Integer.parseInt(thispage);
		if(this.thispage<=1)
			 this.thispage=1;
		else if(this.thispage>getTotalpage())
			this.thispage=getTotalpage();
	}
	public int getRowindex() {
		rowindex= (getThispage()-1)*getPagesize();
		return rowindex;
	}
	public void setRowindex(int rowindex) {
		this.rowindex = rowindex;
	}
    
    
    
}
