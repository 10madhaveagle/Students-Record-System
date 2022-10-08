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
public class StudentIdFetcher 
{
    public ArrayList getID()
    {
        ArrayList a1=new ArrayList();
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance(); // Driver
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/college_db", "root", "root"); //connection
            Statement st= conn.createStatement();// Statement
            
            String query="select * from studentregisterinfo ";
            System.out.println("Query is"+query);
            ResultSet rs=st.executeQuery(query);
            
            while(rs.next())
            {
                String studid=rs.getString(1);
              
                a1.add(studid);
           
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
