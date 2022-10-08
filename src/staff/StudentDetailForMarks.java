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
public class StudentDetailForMarks
{
     public ArrayList getData(String studid)
    {
        ArrayList a1=new ArrayList();
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance(); // Driver
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/college_db", "root", "root"); //connection
            Statement st= conn.createStatement();// Statement
            
            String query="select * from studentregisterinfo where studid='"+studid+"'";
            System.out.println("Query is"+query);
            ResultSet rs=st.executeQuery(query);
           //stud_id, stud_name, department, semester, mobile_number, email_id, password
            if(rs.next())
            {
               // studid=rs.getString(1);
                String studname=rs.getString(2);
              //  String department=rs.getString(3);
                String semester=rs.getString(4);
               
                
              //  a1.add(studid);
                a1.add(studname);
              
                a1.add(semester);
               
                
               // a1.add(rs.getString(1));
               
            }
        
               conn.close();
               st.close();
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        return a1;
    }
}
