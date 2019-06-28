package in.co.mind.web;


import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.json.JSONObject;
import com.google.gson.Gson;

import in.co.mind.dao.TestDbConnection;
import in.co.mind.model.PersonData;	

public class AngularJsServlet extends HttpServlet {
        private static final long serialVersionUID = 1L;
        private TestDbConnection dbcon = null;

        public AngularJsServlet() {
                super();
        }
        static String json = "...";
        protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
                PersonData personData = new PersonData();
                //request.getParameter("name");
                
            String user=   request.getParameter("user");
            String email=  request.getParameter("email");
		/*
		 * personData.setFirstName(); personData.setLastName("Jamil");
		 */
            try {
				TestDbConnection.saveUserToDB(user, email);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
                String json = new Gson().toJson(personData);
                response.setContentType("application/json");
                response.getWriter().write(json);
        }
//        protected void doPost(HttpServletRequest request,
//                HttpServletResponse response) throws ServletException, IOException {
//                    PersonData personData = new PersonData();
//                    personData.setFirstName("Mohaideen");
//                    personData.setLastName("Jamil");
//
//                    String json = new Gson().toJson(personData);
//                    response.setContentType("application/json");
//                    response.getWriter().write(json);
//            } 
        
        
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
        	
            StringBuilder sb = new StringBuilder();
            BufferedReader br = request.getReader();
            String str = null;
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
//            JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
//
//            String name = jsonObject.getAsJsonObject("str").get("UserName").getAsString();
//            System.out.println(name);

            //JSONObject obj = new JSONObject();
            //obj.put(sb);
//            for(Object key : obj.keySet()) {
//            	
//            	
//            }
            String name = request.getParameter("user");
            String email = request.getParameter("email");

            String username = (String)request.getAttribute("UserName");
            String tempEmail =(String) request.getAttribute("Email");
            
            System.out.println(name);
            System.out.println(email);
            System.out.println("Request Parameters:");
            Enumeration<String> enumt = request.getParameterNames();
            while (enumt.hasMoreElements()) {
              String names = (String) enumt.nextElement();
              String values[] = request.getParameterValues(names);
              if (values != null) {
                for (int i = 0; i < values.length; i++) {
                  System.out.println(name + " (" + i + "): " + values[i]);
                }
              }
            }
          
            
//            
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("hello from java. you entered : " + sb);
//            dbcon  = new TestDbConnection();
//            dbcon.saveToDB(str);
            
     
        }
        
//        String dbURL  = "jdbc:postgresql:ProductDB?user=root&password=secret";
//        Connection con = DriverManager.getConnection(dbURL);
        
        
        
        
        
        
}	
