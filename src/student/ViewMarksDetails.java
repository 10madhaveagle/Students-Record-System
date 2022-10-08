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
public class ViewMarksDetails
{
     public void getViewData(String studid)
    {
        try
        {
          Class.forName("com.mysql.jdbc.Driver").newInstance(); // Driver
          Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/college_db", "root", "root"); //connection
          Statement st1= conn.createStatement();// Statement
             Statement st2= conn.createStatement();// Statement
            String query="select * from marksdetails where stud_id='"+studid+"'";
            System.out.println(query);
            ResultSet rs1=st1.executeQuery(query);
             ResultSet rs2=st2.executeQuery(query);
             
             int row=0;
             while(rs1.next())
             {
                 row++;
             }
             int i=0;
             String data[][]=new String[row][14];
             while(rs2.next())
             {
                  studid=rs2.getString(1);
                 data[i][0]=studid;
                 String studname=rs2.getString(2);
                 data[i][1]=studname;
                 String semester=rs2.getString(3);
                 data[i][2]=semester;
                  String subject=rs2.getString(4);
                 data[i][3]=subject;
                  String examdate=rs2.getString(5);
                 data[i][4]=examdate;
                  String marks=rs2.getString(6);
                 data[i][5]=marks;
                  String examtype=rs2.getString(7);
                 data[i][6]=examtype;
//       
                 
                 i++;
                 
                 
             }
             ViewMarksDetailsFrame.data2=data;
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
}
