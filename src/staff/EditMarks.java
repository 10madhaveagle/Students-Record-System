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
public class EditMarks 
{
    public boolean getUpdateMarkrs(String sid,String sname,String semester, String subject , String examdate,String marks,String examtype )
    {
        boolean flag=false;
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance(); // Driver
          Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/college_db", "root", "root"); //connection
            Statement st= conn.createStatement();// Statement
            
            String query="update marksdetails set subject='"+subject+"' , examdate='"+examdate+"', marks='"+marks+"' , exam_type='"+examtype+"'where  stud_id='"+sid+"'";
            int x=st.executeUpdate(query);
            if(x>0)
                flag=true;
            else 
                flag=false;
            st.close();
            conn.close();
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        return flag;
    }
}
