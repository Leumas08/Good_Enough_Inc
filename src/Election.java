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
    public Election(String name, String Com_name, String email)
    {
      this.name=name;
      this.Commissioner=new Commissioner(Com_name, email);
      this.Ballot=new Ballot();
    }
}
