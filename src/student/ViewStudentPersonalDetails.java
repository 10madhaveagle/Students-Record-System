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
public class ViewStudentPersonalDetails 
{
    public void getViewData(String studid)
    {
        try
        {
          Class.forName("com.mysql.jdbc.Driver").newInstance(); // Driver
          Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/college_db", "root", "root"); //connection
          Statement st1= conn.createStatement();// Statement
             Statement st2= conn.createStatement();// Statement
            String query="Select * from studentdetails where stud_id='"+studid+"'";
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
                 String dept=rs2.getString(3);
                 data[i][2]=dept;
                  String sem=rs2.getString(4);
                 data[i][3]=sem;
                  String sub=rs2.getString(5);
                 data[i][4]=sub;
//                  String dob=rs2.getString(6);
//                 data[i][5]=dob;
//                  String gender=rs2.getString(7);
//                 data[i][6]=gender;
//                 String mobile=rs2.getString(8);
//                 data[i][7]=mobile;
//                  String email=rs2.getString(9);
//                 data[i][8]=email;
                  String pname=rs2.getString(10);
                 data[i][5]=pname;
//                  String relation=rs2.getString(11);
//                 data[i][10]=relation;
                  String padd=rs2.getString(12);
                 data[i][6]=padd;
                  String cadd=rs2.getString(13);
                 data[i][7]=cadd;
                  String pmobile=rs2.getString(14);
                 data[i][8]=pmobile;
                 
                 i++;
                 
                 
             }
             ViewStudentPersonalDetailsFrame.data1=data;
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
}
