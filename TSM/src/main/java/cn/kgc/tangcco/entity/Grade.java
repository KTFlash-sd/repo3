package cn.kgc.tangcco.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
/**
 * 成绩实体类
 * 
 * @author 张宇 2018/12/17
 */
public class Grade {
	private int Gid;// 成绩编号id
	private int Lid;// 课程编号
	private int Sid;// 学生编号
	private int Gscore;// 分数
	private Date Gtime;// 成绩时间
	private int Gstate;// 成绩状态
	private int Gdel;// 是否删除

	private String Sname;
	private String Lname;

	public Grade(int gid, int lid, int sid, int gscore, Date gtime, int gstate, int gdel) {
		super();
		Gid = gid;
		Lid = lid;
		Sid = sid;
		Gscore = gscore;
		Gtime = gtime;
		Gstate = gstate;
		Gdel = gdel;
	}

}
