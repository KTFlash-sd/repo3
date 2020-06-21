package cn.kgc.tangcco.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//日期操作类
public class Utils {
	
   private static SimpleDateFormat fm=new SimpleDateFormat("yyyy-MM-dd");
  /**
   * 字符串转为日期
   * @param value  字符串---格式必须是yyyy-MM-dd HH:mm:ss
   * @return 日期，如果转换失败，返回值为null
   */
   public static Date StringtoDate(String value) {
	   Date date=null;
	   try {
		date= fm.parse(value);
	} catch (ParseException e) {
		e.printStackTrace();
	}
	   return date;
   }
   /**
    * 把日期转为字符串的方法
    * @param date
    * @return
    */
   public static String DatetoString(Date date) {
	   String value=null;
	   value=fm.format(date);
	   return value;
   }
   
 //将util的date转换成sql的date"yyyy-MM-dd"
 	public static java.sql.Date utilToSql(Date date){
 		return new java.sql.Date(date.getTime());
 	}

}
