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
public class Ballot {
    private String name;
    private Race[] Races;
    
    public Ballot()
    {
        this.name=null;
        this.Races[0]=new Race();
    }
}
