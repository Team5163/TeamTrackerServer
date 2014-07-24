/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Team5163.TeamTrackerServer.Command;

/**
 *
 * @author Yiwen Dong
 */
public abstract class Command {
    
    private String commandName;
    
    public Command(String name){
        this.commandName = name;
    }
    
    public String getCommandName(){
        return commandName;
    }
    //this is ran every time the command is triggered.
    abstract void trigger();
    
}
