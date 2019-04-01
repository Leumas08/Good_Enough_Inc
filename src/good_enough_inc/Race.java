package good_enough_inc;

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
   private Item[] items;
   
   public Race()
   {
       this.name=null;
       this.Election_Type=null;
       this.items[0]=new Item();
   }
   public Race(String name, String Election_Type, Item[] items)
   {
       this.name=name;
       this.Election_Type=Election_Type;
       this.items=new Item[items.length];
       for(int i=0; i<items.length; i++)
       {
           this.items[i]=items[i];
       }
   }
}
