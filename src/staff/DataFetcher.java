/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staff;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author 2459
 */
public class DataFetcher 
{
    public ArrayList getData(String username)
    {
        ArrayList a1=new ArrayList();
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance(); // Driver
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/college_db", "root", "root"); //connection
            Statement st= conn.createStatement();// Statement
            
            String query="select * from staffregisterinfo where user_name='"+username+"'";
            System.out.println("Query is"+query);
            ResultSet rs=st.executeQuery(query);
            //employee_id, name, mobile_number, email_id, user_name, password
            if(rs.next())
            {
                String empid=rs.getString(1);
                String empname=rs.getString(2);
                String mobile=rs.getString(3);
                String emailid=rs.getString(4);
                username=rs.getString(5);
                String password=rs.getString(6);
                
                a1.add(empid);
                a1.add(empname);
                a1.add(mobile);
                a1.add(emailid);
                a1.add(username);
                a1.add(password);
                
               // a1.add(rs.getString(1));
               conn.close();
               st.close();
            }
        
        
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        return a1;
    }
}
