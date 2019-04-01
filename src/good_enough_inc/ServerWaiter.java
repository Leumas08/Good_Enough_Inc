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

/**
 *
 * @author baronzaaz
 */
public class ServerWaiter extends Thread{

    BufferedReader socketReader;
    PrintWriter socketWriter;
    ServerCook serverCook;
    
    public ServerWaiter(ServerCook sc, Socket socket) {
        try{
            serverCook = sc;
            socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            socketWriter = new PrintWriter(socket.getOutputStream());
        }catch(IOException x){
            System.err.println(x);
        }
    }
    public void refresh()//used to keep all lists updating
    {
        socketWriter.println("/list "+serverCook.getList());
        socketWriter.flush();
    }
    @Override
    public void run(){
        try{
            String clientInput;
            
            //this loop continuously reads input from the client and calls the server to react to it
            while((clientInput = socketReader.readLine()) != null){
                
                System.err.println("waiter received:" + clientInput);
                if(clientInput.startsWith("/add")){
                    String item = clientInput.substring(5);
                    if(!item.isEmpty()){
                        serverCook.addItem(item);
                        socketWriter.println("/list " + serverCook.getList());
                        socketWriter.flush();
                        
            
                    }
                    
                }else if(clientInput.startsWith("/list")){
                    socketWriter.println("/list " + serverCook.getList());
                    socketWriter.flush();
                }else if(clientInput.startsWith("/remove")){
                    String item=clientInput.substring(7);
                    serverCook.removeItem(item);
                  
                }else if(clientInput.startsWith("/clear")){//clear items
                    serverCook.clearList();
                   
                }
                serverCook.refresher();//calls function to update everyone's list
                //This refreshes everyone's list continuously
            }
        }catch (IOException ioe){
            System.err.println(ioe);
        }       
    }
}