package cn.kgc.tangcco.zhangyu.work.entity;

import java.util.Date;

import cn.kgc.tangcco.zhangyu.UtilDate;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@ToString
@NoArgsConstructor
public class WorkBean {
private int Wid;
private String Cname;
private String Lname;
private String Tname;
private String start;
private String end;
private Date Wstart;
private Date Wend;
private int Wtime;
private int Wdel;
public int getWid() {
	return Wid;
}
public void setWid(int wid) {
	Wid = wid;
}
public String getCname() {
	return Cname;
}
public void setCname(String cname) {
	Cname = cname;
}
public String getLname() {
	return Lname;
}
public void setLname(String lname) {
	Lname = lname;
}
public String getTname() {
	return Tname;
}
public void setTname(String tname) {
	Tname = tname;
}
public String getStart() {
	return UtilDate.DatetoString1(getWstart());
}
public void setStart(String start) {
	this.start = start;
}
public String getEnd() {
	return UtilDate.DatetoString1(getWend());
}
public void setEnd(String end) {
	this.end = end;
}
public Date getWstart() {
	return Wstart;
}
public void setWstart(Date wstart) {
	Wstart = wstart;
}
public Date getWend() {
	return Wend;
}
public void setWend(Date wend) {
	Wend = wend;
}
public int getWtime() {
	return Wtime;
}
public void setWtime(int wtime) {
	Wtime = wtime;
}
public int getWdel() {
	return Wdel;
}
public void setWdel(int wdel) {
	Wdel = wdel;
}





}
