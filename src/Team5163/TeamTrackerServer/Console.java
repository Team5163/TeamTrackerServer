/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Team5163.TeamTrackerServer;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yiwen Dong
 */
public class Console implements Runnable{
    
    Scanner scanner;
    Thread thread;
    
    public Console(){
        scanner = new Scanner(System.in);
    }
    
    public void start(){
        this.printMessage("Welcome to team tracker. This is version " + Server.version + " .");
        this.printMessage("This program is made by the programming team of 5163");
        thread = new Thread(this, "Console");
        thread.start();
    }
    
    public void printMessage(String message){
        System.out.println(System.nanoTime() + " " + message);
    }
    
    public void listenForCommand(){
        String message = scanner.nextLine();
        this.printMessage(message);
    }

    @Override
    public void run() {
        while(true){
            this.listenForCommand();
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                this.printMessage("Error: Sleep interupted");
            }
        }
    }
}

