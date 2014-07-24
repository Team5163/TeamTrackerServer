/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Team5163.TeamTrackerServer.Command;

import java.util.LinkedHashMap;
import java.util.Map;


/**
 *
 * @author Yiwen Dong
 */
public class CommandManager {
    
    private Map<String, Command> commands = new LinkedHashMap<>();
    
    public CommandManager(){
        
    }
    
    public void init(){
        this.regesterCommand(new Stop());
    }
    
    private void regesterCommand(Command command){
        commands.put(command.getCommandName().toLowerCase(), command);
    }
    
    public boolean haveCommand(String commandName){
        if(commands.containsKey(commandName.toLowerCase())){
            return true;
        }
        return false;
    }
    
    public void runCommand(String commandName){
        commands.get(commandName.toLowerCase()).trigger();
    }
}
