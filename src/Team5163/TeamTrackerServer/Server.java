/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Team5163.TeamTrackerServer;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yiwen Dong
 */
public class Server {
    
    public static String version = "0.1";
    public static Console console;
    public static Listener listener;
    
    public static void stop(){
        console.stop();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        console = new Console();
        console.start();
        for(int a = 0; a < 10; a++){
            console.printMessage(String.valueOf(a));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                console.printMessage("Error: Sleep interupted in class: " + Server.class.getName());
            }
        }
    }
}
