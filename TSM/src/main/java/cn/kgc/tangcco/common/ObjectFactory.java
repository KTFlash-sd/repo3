package cn.kgc.tangcco.common;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 获取对象的工厂类
 * @author dell
 *
 */
public class ObjectFactory {
	 
	 private static Map<String ,Object> m=new ConcurrentHashMap<String,Object>();
	//如果m集合中有对象，直接从m中获取，如果m中没有对象，从PropertyUtil的map中获取对象
     public static <T>T getInstance(String key){
    	 T obj=null;
    	 if(m.containsKey(key)) {
    	     obj=(T) m.get(key);
    	 }
    	 else {
    		 obj=(T) PropertyUtil.getMap().get(key);
    		 m.put(key, obj);
    	 }
    	 return obj;
     }
}
