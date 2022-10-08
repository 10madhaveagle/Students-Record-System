/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collegedatabasemanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author 2459
 */
public class Registration 
{
    public boolean isInserted(String empid,String name,String mobile,String email,String username,String password)
{
    boolean flag=false;
    try
    {
        Class.forName("com.mysql.jdbc.Driver").newInstance(); // Driver
        Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/college_db", "root", "root"); //connection
        Statement st= conn.createStatement();// Statement
        String query="insert into staffregisterinfo values ('"+empid+"','"+name+"','"+mobile+"','"+email+"','"+username+"','"+password+"')";
        System.out.println("Query is "+query);
        int x=st.executeUpdate(query);
        if(x>0)
            flag=true;
    
        st.close();
        conn.close();
    }
    catch(Exception ex)
    {
        System.out.println("Exception While Inserting Data "+ex);
    }
    return flag;
}
}


