/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Team5163.TeamTrackerServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
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
            while (running) {
                new Handler(listener.accept()).start();
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
        thread = null;
    }
}
