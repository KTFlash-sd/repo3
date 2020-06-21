package cn.kgc.tangcco.entity;

import java.io.Serializable;
import java.util.Date;

import cn.kgc.tangcco.util.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
//@Data
@ToString

/**
 * 教师实体类
 * @author 张宇
 *2019/12/17
 */
public class Teacher implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = -9125224905031145543L;
private int Tid;//教师编号
private String Tname;//姓名
private String Tsex;//性别
private String Tem;//邮箱
private Date Tbirth;//出生日期
@Setter
private String tbirths;
private String Tps;//政治面貌
private String Tnative;//籍贯
private String Ttel;//联系方式
private String Tmajor;//专业
private int Tyear;//教龄
private String Tiob;//职称
private String Aid;//用户id
private int Tdel;//判断是否显示
private int Tstate;//状态



public String getTbirString() {
	tbirths=Utils.DatetoString(getTbirth());
	return tbirths;
}

public int getTid() {
	return Tid;
}

public void setTid(int tid) {
	Tid = tid;
}

public String getTname() {
	return Tname;
}

public void setTname(String tname) {
	Tname = tname;
}

public String getTsex() {
	return Tsex;
}

public void setTsex(String tsex) {
	Tsex = tsex;
}

public String getTem() {
	return Tem;
}

public void setTem(String tem) {
	Tem = tem;
}

public Date getTbirth() {
	return Tbirth;
}

public void setTbirth(Date tbirth) {
	Tbirth = tbirth;
}

public String getTps() {
	return Tps;
}

public void setTps(String tps) {
	Tps = tps;
}

public String getTnative() {
	return Tnative;
}

public void setTnative(String tnative) {
	Tnative = tnative;
}

public String getTtel() {
	return Ttel;
}

public void setTtel(String ttel) {
	Ttel = ttel;
}

public String getTmajor() {
	return Tmajor;
}

public void setTmajor(String tmajor) {
	Tmajor = tmajor;
}

public int getTyear() {
	return Tyear;
}

public void setTyear(int tyear) {
	Tyear = tyear;
}

public String getTiob() {
	return Tiob;
}

public void setTiob(String tiob) {
	Tiob = tiob;
}

public String getAid() {
	return Aid;
}

public void setAid(String aid) {
	Aid = aid;
}

public int getTdel() {
	return Tdel;
}

public void setTdel(int tdel) {
	Tdel = tdel;
}

public int getTstate() {
	return Tstate;
}

public void setTstate(int tstate) {
	Tstate = tstate;
}

public String getTbirths() {
	return tbirths;
}

public Teacher(int tid, String tname, String tsex, String tem, Date tbirth, String tps, String tnative, String ttel,
		String tmajor, int tyear, String tiob, String aid, int tdel, int tstate) {
	super();
	Tid = tid;
	Tname = tname;
	Tsex = tsex;
	Tem = tem;
	Tbirth = tbirth;
	Tps = tps;
	Tnative = tnative;
	Ttel = ttel;
	Tmajor = tmajor;
	Tyear = tyear;
	Tiob = tiob;
	Aid = aid;
	Tdel = tdel;
	Tstate = tstate;
}

public Teacher(int tid, String tname, String tsex, String tem, Date tbirth, String tbirths, String tps, String tnative,
		String ttel, String tmajor, int tyear, String tiob, String aid, int tdel, int tstate) {
	super();
	Tid = tid;
	Tname = tname;
	Tsex = tsex;
	Tem = tem;
	Tbirth = tbirth;
	this.tbirths = tbirths;
	Tps = tps;
	Tnative = tnative;
	Ttel = ttel;
	Tmajor = tmajor;
	Tyear = tyear;
	Tiob = tiob;
	Aid = aid;
	Tdel = tdel;
	Tstate = tstate;
}



}
