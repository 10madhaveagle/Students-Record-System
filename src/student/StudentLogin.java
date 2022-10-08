/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author 2459
 */
public class StudentLogin 
{
     public boolean doLogin(String studid,String password)
    {
        boolean flag=false;
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance(); // Driver
        Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/college_db", "root", "root"); //connection
        Statement st= conn.createStatement();// Statement
        
        String query="select * from studentregisterinfo where studid='"+studid+"' and password='"+password+"' ";
        
        ResultSet rs=st.executeQuery(query);
        if(rs.next())
            flag=true;
        conn.close();
        st.close();
        
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        return flag;
    }
}
