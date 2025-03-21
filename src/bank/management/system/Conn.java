package bank.management.system;
import java.sql.*;

public class Conn{
    
    Connection c;   // Creating connection
    Statement s;    // creating statement
    
    Conn(){
        /*
        sql is external entity . so it give error during run time not compile time, 
        So for handling run time error we exceptin handlin i.e (try&cathc)
        */
        try{
            // Register Drive
            //Class.forName(com.mysql.cj.jdbc.Driver);   // we dont need to eplicitly register driver becoz mysql-connector library do it automatically
            
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","himanshu27");
            s = c.createStatement();
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
   
}
