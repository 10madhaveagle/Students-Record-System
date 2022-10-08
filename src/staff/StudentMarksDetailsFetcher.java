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
public class StudentMarksDetailsFetcher 
{
     public ArrayList getData(String sid)
    {
        ArrayList a1=new ArrayList();
        try
        {
          Class.forName("com.mysql.jdbc.Driver").newInstance(); // Driver
          Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/college_db", "root", "root"); //connection
            Statement st1= conn.createStatement();// Statement
            // Statement st2= conn.createStatement();// Statement
             
            String query="Select * from marksdetails where studid='"+sid+"'";
            
          //  ResultSet rs1=st1.executeQuery(query);
             ResultSet rs2=st1.executeQuery(query);
             
           
            
             while(rs2.next())
             {
                 String studid=rs2.getString(1);
                
                 String studname=rs2.getString(2);
               
                
               String sem=rs2.getString(3);
                
                  String sub=rs2.getString(4);
                
                  String examdate=rs2.getString(5);
                
                  String marks=rs2.getString(6);
                  String examtype=rs2.getString(7);
            
                 
                a1.add(studid);
               a1.add(studname);
             
               a1.add(sem);
               a1.add(sub);
               a1.add(examdate);
               a1.add(marks);
               a1.add(examtype);
               
                 
             }
             
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        return a1;
    }
}
