/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Team5163.TeamTrackerServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yiwen Dong
 */
public class Listener implements Runnable {

    ServerSocket listener;
    Thread thread;
    boolean running = false;
    List<Handler> listOfHandler = new ArrayList<>();

    public Listener() {
        try {
            listener = new ServerSocket(5163);
        } catch (IOException ex) {
            Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void start() {
        running = true;
        thread = new Thread(this, "Listener");
        thread.start();
    }

    @Override
    public void run() {
        try {
            while (running && !listener.isClosed()) {
                new Handler(listener.accept()).start();
                Server.console.printMessage("New socket connection established");
            }
        } catch (IOException ex) {
            Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                listener.close();
            } catch (IOException ex) {
                Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void stop() {
        running = false;
        try {
            Socket socket = new Socket("localhost", 5163);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.stopHandler();
        thread = null;
    }
    
    private void stopHandler(){
        for(Handler handler: listOfHandler){
            handler.stop();
        }
    }
}
