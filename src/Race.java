/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author swp99
 */
public class Race {
   private String name;
   private String Election_Type;
   private String [] items;
   
   public Race(String name, String Election_Type, String[] items)
   {
       this.name=name;
       this.Election_Type=Election_Type;
       this.items=new String[items.length];
       for(int i=0; i<items.length; i++)
       {
           this.items[i]=items[i];
       }
   }
}
