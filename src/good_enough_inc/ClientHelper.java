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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author baronzaaz
 */
public class ClientHelper extends Thread{
    Client client;
    BufferedReader socketReader;
    PrintWriter socketWriter;
    
    public ClientHelper(Client c) {
        client = c;
    }
    public void add(String item){
        item = item.trim();
        socketWriter.println("/add " + item);
        socketWriter.flush();
    }
    public void remove(String item){//remove item
        item=item.trim();
        socketWriter.println("/remove"+item);
        socketWriter.flush();
    }
    public void clear()//clear list
    {
        socketWriter.println("/clear");//send clear command
        socketWriter.flush();
    }
    
    @Override
    public void run(){
        try{
            Socket socket = new Socket("127.0.0.1",8888);
            String serverTalk;
            socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            socketWriter = new PrintWriter(socket.getOutputStream());
            
            socketWriter.println("/list");
            socketWriter.flush();
            
            while((serverTalk = socketReader.readLine()) != null){
                System.err.println("ClientHelper received:" + serverTalk);
                if(serverTalk.startsWith("/list")){
                    client.updateList(serverTalk.substring(6));
                }
            }
        }catch (UnknownHostException u){
            System.err.println("Server not found");
        }catch (IOException ioe){
            System.err.println(ioe);
        }
    }
}
