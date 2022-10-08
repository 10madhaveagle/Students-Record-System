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
public class EditStudentDetails 
{
     public boolean getUpdateData(String studid,String subject,String dob,String gender,String parentname,String relation,String padd,String cadd,String pmob)
    {
        //stud_id, stud_name, semester, department, subject, dob, gender, email_id, mobile_number, parent_name, relation, per_address, curt_address, parent_mobile
        boolean flag=false;
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance(); // Driver
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/college_db", "root", "root"); //connection
            Statement st= conn.createStatement();// Statement
            
            String query="update studentdetails set subject='"+subject+"',dob='"+dob+"',gender='"+gender+"',parent_name='"+parentname+"', relation='"+relation+"', per_address='"+padd+"', curt_address='"+cadd+"', parent_mobile='"+pmob+"' where stud_id='"+studid+"'";
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
