/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package comapp;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author flyhigh
 */
public class SendMessage extends Thread {
    String host;
    String message;
    public String response="Message Sent";
    public SendMessage(String host, String message) {
        this.host = host;
        this.message = message;
    }
    boolean sendMessage(){
        try {
            Socket s = new Socket(host, 7384);
            s.getOutputStream().write(message.getBytes());
            s.close();
        } catch (UnknownHostException ex) {
            
            Logger.getLogger(SendMessage.class.getName()).log(Level.SEVERE, null, ex);
            response = ex.getMessage();
            return false;
        } catch (IOException ex) {
            
            Logger.getLogger(SendMessage.class.getName()).log(Level.SEVERE, null, ex);
            response = ex.getMessage();
            return false;
        }
        return true;
    }
    public void run(){
        sendMessage();
    }
}
