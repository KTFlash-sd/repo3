package cn.kgc.tangcco.common;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import cn.kgc.tangcco.util.Constant;
/**
 * 对xml文件进行解析，根据xml文件创建的类的实列保存在map中
 * 并且给对象的属性赋值
 * @author dell
 *
 */
public class PropertyUtil {
	private static List<Bean> beanlist=new ArrayList<Bean>();//存储xml文件中所有内容
	private static Map<String,Object> map=new ConcurrentHashMap<String, Object>();
	 //解析xml文件
	static {
		 try {
			  SAXReader sax=new SAXReader();
			  InputStream in=PropertyUtil.class.getResourceAsStream(Constant.xmlPath);
			  Document doc=sax.read(in);
			  Element root=doc.getRootElement();
			  List<Element> beans=root.elements();//获取bean标签
			  for (Element bean : beans) {
				String key=bean.attributeValue("id");
				String value=bean.attributeValue("class");
				
				  List<Element> ps=bean.elements();//获取property标签
				  List<ProperTy> ptlist=new ArrayList<ProperTy>();
				  for (Element element : ps) {
					 String pname= element.attributeValue("name");
					 String pvalue= element.attributeValue("ref");
				     ProperTy proty=new ProperTy(pname,pvalue);
				     ptlist.add(proty);
				  }
				  Bean bn=new Bean(key,value,ptlist);
				  beanlist.add(bn);
			  }
			  }catch(Exception e) {
				  e.printStackTrace();
			  }
		 getObjects();
		 getPropertyList();
	}

	/**
	 * 获取所有的bean标签，根据id给id对应的类实列对象并存放在map中
	 */
     public static void getObjects() {
    	 try {
    	 for (Bean bean : beanlist) {
			String id=bean.getId();
			String url=bean.getClasss();
			Class clazz =Class.forName(url);
			Object obj=clazz.newInstance();
			map.put(id, obj);
		  }
    	 }catch(Exception e) {
    		 e.printStackTrace();
    	 }
     }
     
     /**
      * 获取bean标签中下面的Property标签，根据属性名为属性赋值
      */
     public static void getPropertyList() {
    	 try {
    	 for (Bean bean : beanlist) {
			String id=bean.getId();
			List<ProperTy> plist=bean.getPtlist();
			if(plist!=null&&plist.size()>0) {
				Object object=map.get(id);
				Class clazz=object.getClass();
				for (ProperTy properTy : plist) {
					String name=properTy.getPname();//字段名称 
					String value=properTy.getPvalue();//字段匹配的值
					Object obj=map.get(value); //根据key获取对象
					Field fd=clazz.getDeclaredField(name); // 
					fd.setAccessible(true);
					fd.set(object, obj); 
				}
			}
		}
    	 }catch(Exception e) {
    		 e.printStackTrace();
    	 }
     }
     
     //返回所有的map对象
     public static Map<String,Object> getMap(){
    	 return map;
     }
     
}
