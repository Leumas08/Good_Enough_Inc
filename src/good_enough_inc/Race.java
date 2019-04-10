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
   public String name;
   public String Election_Type;
   public Item[] items;
   

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
   public String getName()
   {
        return this.name;
   }
   public String getType()
   {
        return this.Election_Type;
   }
   public String[] getItemNames(int item)
   {
        return this.items[item].getNames();
   }
   public String getItemParty(int item)
   {
        return this.items[item].getParty();
   }
}
