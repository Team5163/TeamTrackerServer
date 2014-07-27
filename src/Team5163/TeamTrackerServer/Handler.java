/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Team5163.TeamTrackerServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is the class that handles all the clients. 
 * This is to be initated by listener and closed by either the server or client.
 * @author Yiwen Dong
 */
public class Handler implements Runnable{
    
    private Socket socket;
    Thread thread;
    BufferedReader in;
    PrintWriter out;
    boolean running = false;
    
    public Handler(Socket socket){
        this.socket = socket;
    }
    
    public void start(){
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);    
        } catch (IOException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        //get message and check with protical for match and run.
        while(running){
            try {
                String message = in.readLine();
                if(message != null){
                    Server.console.printMessage(String.valueOf(this.getProtocolNum(message)));
                    Server.console.printMessage(this.getMessage(message));
                }
            } catch (IOException ex) {
                Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private int getProtocolNum(String message){
        return Integer.valueOf(new StringBuilder().append(message.charAt(0)).append(message.charAt(1)).toString());
    }
    
    private String getMessage(String message){
        return message.substring(2);
    }
    
    public void stop(){
        running = false;
        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        thread = null;
    }
    
}
