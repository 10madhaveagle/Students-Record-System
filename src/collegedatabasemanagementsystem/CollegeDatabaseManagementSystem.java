/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collegedatabasemanagementsystem;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author 2459
 */
public class CollegeDatabaseManagementSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
         LogInFrame lf=new LogInFrame();
        Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
        lf.setVisible(true);
        lf.setSize(d);
    }
    
}
