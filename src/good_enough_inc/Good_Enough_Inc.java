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
        JFrame head=new Head();
        head.setSize(1000, 600);
        head.setVisible(true);
        JFrame Com=new Commission_Frame();
        Com.setSize(1000, 600);
        Com.setVisible(true);
        JFrame Stu=new Student();
        Stu.setSize(1000, 600);
        Stu.setVisible(true);
    }
    
}
