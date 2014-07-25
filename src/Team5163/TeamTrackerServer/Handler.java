/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Team5163.TeamTrackerServer;

import java.net.Socket;

/**
 * This is the class that handles all the clients. 
 * This is to be initated by listener and closed by either the server or client.
 * @author Yiwen Dong
 */
public class Handler implements Runnable{
    
    private Socket socket;
    Thread thread;
    
    public Handler(Socket socket){
        this.socket = socket;
    }
    
    public void start(){
        //add itself to listener and get client id
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void stop(){}
    
}
