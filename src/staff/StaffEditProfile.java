/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staff;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author 2459
 */
public class StaffEditProfile 
{
      //employee_id, name, mobile_number, email_id, user_name, password
    public boolean getUpdateData(String empid,String name,String mobile,String email,String username,String password)
    {
        boolean flag=false;
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance(); // Driver
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/college_db", "root", "root"); //connection
            Statement st= conn.createStatement();// Statement
            
            String query="update staffregisterinfo set employee_id='"+empid+"',name='"+name+"',mobile_number='"+mobile+"',email_id='"+email+"', password='"+password+"' where user_name='"+username+"'";
            int x=st.executeUpdate(query);
            
            if(x>0)
                flag=true;
            else
                flag=false;
            
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
