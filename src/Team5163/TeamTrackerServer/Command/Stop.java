/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Team5163.TeamTrackerServer.Command;

import Team5163.TeamTrackerServer.Server;

/**
 *
 * @author Yiwen Dong
 */
public class Stop extends Command{
    
    public Stop(){
        super("Stop");
    }

    @Override
    void trigger() {
        Server.console.printMessage("Stoping Server");
        Server.stop();
    }
    
}
