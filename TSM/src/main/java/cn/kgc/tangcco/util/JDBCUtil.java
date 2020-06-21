package cn.kgc.tangcco.util;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
/**
 * 数据库的操作公共类
 * @author dell
 *
 * @param <T>
 */
public class JDBCUtil<T> {
   private QueryRunner qr=new QueryRunner(DataSouceUtil.getDs());
   
   /**
    * 更新,不成功为-1
    */
   public int modify(String sql,Object...objects) {
	  try {
		return  qr.update(sql, objects);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	  return -1;
   }
   
   /**
    * 查询
    */
   public List<T> query(Class clazz,String sql,Object...objects){
	   List<T> resultlist=null;
	   try {
		 resultlist=qr.query(sql, new BeanListHandler<T>(clazz), objects);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   return resultlist;
   }
   
   
   public <T>T select(Class clazz,String sql,Object...objects){
	   T obj=null;
	   try {
		 obj=qr.query(sql, new BeanHandler<T>(clazz), objects);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   return obj;
   }
 //返回一个对象
 	public <T>T find(Class<T>clazz,String sql,Object...objects){
 		T obj=null;
 		try {
 			obj=qr.query(sql, new BeanHandler<T>(clazz), objects);
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		return obj;
 	}
 	//查询所有用户
 		
 		public  List<T> Allquery(Class<T>clazz, String sql,Object...objects){
 			List<T> list=null;
 			try {
 				list=qr.query(sql, new BeanListHandler<T>(clazz), objects);
 			} catch (SQLException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}
 			return list;
 		}
 	}

