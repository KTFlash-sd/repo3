package cn.kgc.tangcco.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

/**
 * 课程实体类
 * @author 张宇
 *2019/12/17
 */
public class Lesson {
private int Lid;//课程编号
private String Lname;//课程名称
private int Lstate;//课程状态
private int Ldel;//是否删除
}
