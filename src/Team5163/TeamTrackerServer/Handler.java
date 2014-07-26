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
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        //get message and check with protical for match and run.
    }
    
    public void stop(){
        thread = null;
    }
    
}
