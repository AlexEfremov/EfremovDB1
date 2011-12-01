package db.efremov;

import java.sql.*;

class EmployeeList {
  public static void main(String argv[]) {
   Connection conn=null;
   Statement stmt=null;
   ResultSet rs=null;
   
   try {
    // Load the JDBC driver  
	// This can be skipped for Derby, but derbyclient.jar has to be in the CLASSPATH   
    // Class.forName("org.apache.derby.jdbc.ClientDriver");
 
    conn = DriverManager.getConnection( "jdbc:derby://localhost:1527/Lesson22;create=false"); 
    // Build an SQL String 
    String sqlQuery = "SELECT * from Employee"; 	
    // Create a Statement object
    stmt = conn.createStatement(); 
    // Execute SQL and get obtain the ResultSet object
    rs = stmt.executeQuery(sqlQuery);  
    // Process the result set - print Employees
    while (rs.next()){ 
    	 int empNo = rs.getInt("EMPNO");
       	 String eName = rs.getString("ENAME");
         String job = rs.getString("JOB_TITLE");
	     System.out.println(""+ empNo + ", " + eName + ", " + job ); 
    }

   } catch( SQLException se ) {
      System.out.println ("SQLError: " + se.getMessage ()
           + " code: " + se.getErrorCode ());

   } catch( Exception e ) {
      System.out.println(e.getMessage()); 
      e.printStackTrace(); 
   } finally{
       // clean up the system resources
       try{
	   rs.close();     
	   stmt.close(); 
	   conn.close();  
       } catch(Exception e){
           e.printStackTrace();
       } 
   }
}
}
