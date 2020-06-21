package cn.kgc.tangcco.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data

/**
 * 学生实体类
 * @author 张宇
 *2019/12/17
 */
public class Student {
private int Sid;//学生编号
private String Sname;//学生姓名
private Date Sbirth;//出生日期*
private String Ssex;//性别
private String Sem;//邮箱*
private String Sps;//政治面貌*
private String Snative;//籍贯*
private int Smajorid;
private String Saddress;//家庭住址*
private String Stel;////联系电话*
private String Sedu;//学制
private String Sur;//紧急联系人*
private String Surtel;//紧急联系人电话*
private String Aid;//用户id
private int Sstate;//状态
private int Sdel;//判断是否显示
private String MAname;//专业
}
