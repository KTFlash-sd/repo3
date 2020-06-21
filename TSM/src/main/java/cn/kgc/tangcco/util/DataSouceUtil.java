package cn.kgc.tangcco.util;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSouceUtil {
    private static ComboPooledDataSource ds=new ComboPooledDataSource("test");
    private ThreadLocal<Connection> t=new ThreadLocal<Connection>();
    private Connection con;
    public static ComboPooledDataSource getDs() {
    	return ds;
    }
    
    public Connection getConnection() {
    	con=t.get();
    	if(con==null)
    	{
    	  try {
			con= ds.getConnection();
		  } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  }
    	}
    	return con;
    }
}
