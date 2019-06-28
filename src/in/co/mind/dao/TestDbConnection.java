package in.co.mind.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class TestDbConnection {

	public TestDbConnection() {
		
//		String dbURL = "jdbc:postgresql://localhost:5432/ProductDB";
//        Properties parameters = new Properties();
//        parameters.put("user", "root");
//        parameters.put("password", "secret");
//        Connection conn = DriverManager.getConnection(dbURL, parameters);		
		
        try{  
        	Class.forName("org.postgresql.Driver");  
        	Connection con=DriverManager.getConnection(  
        	"jdbc:postgresql://localhost:5432/aap","postgres","shivay");  
        	//here sonoo is database name, root is username and password  
        	Statement stmt=con.createStatement();  
        	ResultSet rs=stmt.executeQuery("select * from employee");  
        	while(rs.next())  
        	System.out.println(rs.getString(1)+"  "+rs.getString(2));  
        	con.close();  
        	}catch(Exception e){ System.out.println(e);}    
        
        
		
	}
	
public static void saveToDB() {
	
	    Connection c = null;
      //  Statement stmt = null;
	   //stmt = c.createStatement();
       
	
       try{  
       	Class.forName("org.postgresql.Driver");  
       	Connection con=DriverManager.getConnection(  
       	"jdbc:postgresql://localhost:5432/aap","postgres","shivay");  
       	//here sonoo is database name, root is username and password  
       	Statement stmt=con.createStatement();  
       	stmt = c.createStatement();
        String sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
           + "VALUES (1, 'Paul', 32, 'California', 20000.00 );";
        stmt.executeUpdate(sql);	
       	
       	con.close();  
       	}catch(Exception e){ System.out.println(e);}    
	
}	


public static void saveUserToDB(String name,String email) {
	
    //Connection c = null;
  //  Statement stmt = null;
   //stmt = c.createStatement();
   

   try{  
   	Class.forName("org.postgresql.Driver");  
   	Connection con=DriverManager.getConnection(  
   	"jdbc:postgresql://localhost:5432/aap","postgres","shivay");  
   	//here sonoo is database name, root is username and password  
   	Statement stmt=con.createStatement();  
   	stmt = con.createStatement();
   	StringBuilder sb = new StringBuilder();
   	sb.append("INSERT INTO test (name,age,email) ");
   	sb.append("VALUES ( ");
   	sb.append("'"+name+"',");
   	sb.append("10,");
   	sb.append("'"+email+"')");
   	System.out.println(sb.toString());
           
    stmt.executeUpdate(sb.toString());	
   	
   	con.close();  
   	}catch(Exception e){ System.out.println(e);}    

}	

	
	
}
