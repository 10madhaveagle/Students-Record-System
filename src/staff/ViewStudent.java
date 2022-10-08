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


/**
 *
 * @author 2459
 */
public class ViewStudent
{
     public void getViewData()
    {
        try
        {
          Class.forName("com.mysql.jdbc.Driver").newInstance(); // Driver
          Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/college_db", "root", "root"); //connection
            Statement st1= conn.createStatement();// Statement
             Statement st2= conn.createStatement();// Statement
             
            String query="Select * from studentdetails";
            
            ResultSet rs1=st1.executeQuery(query);
             ResultSet rs2=st2.executeQuery(query);
             
             int row=0;
             while(rs1.next())
             {
                 row++;
             }
             int i=0;
             String data[][]=new String[row][2];
             while(rs2.next())
             {
                 String studid=rs2.getString(1);
                 data[i][0]=studid;
                 String studname=rs2.getString(2);
                 data[i][1]=studname;
                
                 i++;
                 
                 
             }
             ViewStudentFrame.data1=data;
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
}
