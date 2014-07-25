/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Team5163.TeamTrackerServer;

import Team5163.TeamTrackerServer.Command.CommandManager;
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
    boolean running = false;
    CommandManager commandManager = new CommandManager();
    
    public Console(){
        scanner = new Scanner(System.in);
        commandManager.init();
    }
    
    public void start(){
        this.printMessage("Welcome to team tracker. This is version " + Server.version + " .");
        this.printMessage("This program is made by the programming team of 5163");
        running = true;
        thread = new Thread(this, "Console");
        thread.start();
    }
    
    public void printMessage(String message){
        System.out.println("[" + System.currentTimeMillis() + "]: " + message);
    }
    
    public void listenForCommand(){
        String message = scanner.nextLine();
        this.printMessage("Command Run: " + message);
        if(commandManager.haveCommand(message)){
            commandManager.runCommand(message);
        }
    }

    @Override
    public void run() {
        while(running){
            this.listenForCommand();
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                this.printMessage("Error: Sleep interupted");
            }
        }
    }
    
    public void stop(){
        running = false;
        thread = null;
    }
}

