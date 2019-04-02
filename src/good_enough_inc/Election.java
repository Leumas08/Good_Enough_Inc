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
public class Election {
    private String name;
    private Commissioner Commissioner;
    private boolean Status;
    private Ballot Ballot;
    public Election()
    {
        //this.name=null;
        //this.Commissioner=new Commissioner();
        //this.Ballot=new Ballot();
    }
    public Election(String name, String Com_name, String email)
    {
      this.name=name;
      this.Commissioner=new Commissioner(Com_name, email);
      this.Status=false;
    }
    public String getName()
    {
        return this.name;
    }
    public String getComName()
    {
        return this.Commissioner.getName();
    }
    public String getEmail()
    {
        return this.Commissioner.getEmail();
    }
}
