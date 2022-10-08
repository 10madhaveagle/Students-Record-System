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
public class StudentDetailsFetcher 
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
             
            String query="Select * from studentdetails where stud_id='"+sid+"'";
            
          //  ResultSet rs1=st1.executeQuery(query);
             ResultSet rs2=st1.executeQuery(query);
             
           
            
             while(rs2.next())
             {
                 String studid=rs2.getString(1);
                
                 String studname=rs2.getString(2);
               
                 String dept=rs2.getString(3);
               
                  String sem=rs2.getString(4);
                
                  String sub=rs2.getString(5);
                
                  String dob=rs2.getString(6);
                
                  String gender=rs2.getString(7);
                 
                 String mobile=rs2.getString(8);
                  String email=rs2.getString(9);
                   String pname=rs2.getString(10);
                  String relation=rs2.getString(11);
                  String padd=rs2.getString(12);
                  String cadd=rs2.getString(13);
                  String pmobile=rs2.getString(14);
                 
                a1.add(studid);
               a1.add(studname);
               a1.add(dept);
               a1.add(sem);
               a1.add(sub);
               a1.add(dob);
               a1.add(gender);
               a1.add(mobile);
               a1.add(email);
               a1.add(pname);
               a1.add(relation);
               a1.add(padd);
               a1.add(cadd);
               a1.add(pmobile);
                 
             }
             
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        return a1;
    }
}
