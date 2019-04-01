/*Group Members:
    Francesco Cassarino
    Grant Jones
    Jakob Krasny
    Emerald Lee
    Samuel Price
*/
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package good_enough_inc;

import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author baronzaaz
 */
public class ServerCook extends Thread{
    boolean alive = true;
    ArrayList<String> itemList;//list of strings
    ArrayList<ServerWaiter> Waiters;//list of waiters
    
    public ServerCook() {   
        itemList = new ArrayList();
        itemList.add("");
        Waiters=new ArrayList();//creates new array list
    }
    public void addItem(String itemIn){
        itemList.add(itemIn);
        System.err.println("Server added:" + itemIn);
    }
    public String getList(){
        String strList = new String();
        for(String x : itemList){
            strList = strList + "/NEWWORD" + x;
        }
        return strList.trim();
    }
    public void refresher()//used to update all lists
    {
        for(int i=0; i<Waiters.size(); i++)
        {
            Waiters.get(i).refresh();
        }
    }
    public void removeItem(String item){//remove item entered
        for(int i=0; i<itemList.size(); i++){
            if(itemList.get(i).equals(item))//if equal
            {
                itemList.remove(i);//remove it
            }
        }
    }
    public void clearList() //removes items in list
    {
        itemList.clear();//.clear removes items from list
    }
    @Override
    public void run(){
        System.err.println("Server Starting");
        try{
            ServerSocket serverSocket = new ServerSocket(8888);
            while(alive){
                
                Socket clientSocket = serverSocket.accept();
                Waiters.add(new ServerWaiter(this, clientSocket));//store in array list
                Waiters.get(Waiters.size()-1).start();//start waiter
                
            }
        }catch(BindException be){
            System.err.println("Stop Previous Server Instance.");
        }catch(IOException e){
            System.err.println(e);
        }catch(Exception x){
            System.err.println(x + "client likely disconnected");
        }
        System.err.println("Server Shutting Down");
    }   
}