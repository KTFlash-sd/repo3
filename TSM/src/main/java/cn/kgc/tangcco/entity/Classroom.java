package cn.kgc.tangcco.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

/**
 * 教室实体类
 * @author 张宇
 *2019/12/17
 */
public class Classroom {
private int Cid;//教室编号
private String Cname;//教室名称
private String Cplace;//教室地点
private String Cstate;//教室状态
private int Cdel;//是否删除


}
