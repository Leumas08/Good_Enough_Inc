/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package good_enough_inc;

import javax.swing.JFrame;

/**
 *
 * @author swp99
 */
public class Good_Enough_Inc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
   //test1
        HSO_Landing_Page HSO = new HSO_Landing_Page();
        Comish_Landing_Page Com=new Comish_Landing_Page();
        Student_Landing_Page Student= new Student_Landing_Page();
        Student.setVisible(true);
        Com.setVisible(true);
        HSO.setVisible(true);
    }
}