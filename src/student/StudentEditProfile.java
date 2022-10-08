/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import staff.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author 2459
 */
public class StudentEditProfile 
{
     // stud_id, stud_name, department, semester, mobile_number, email_id, password
    public boolean getUpdateData(String studid,String studname,String department,String semester,String mobile,String email,String password)
    {
        boolean flag=false;
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance(); // Driver
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/college_db", "root", "root"); //connection
            Statement st= conn.createStatement();// Statement
            
            String query="update studentregisterinfo set stud_name='"+studname+"',department='"+department+"',semester='"+semester+"',mobile='"+mobile+"',email='"+email+"', password='"+password+"' where studid='"+studid+"'";
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
