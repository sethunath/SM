/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author flyhigh
 */
class ConnectionHandler {

    public void changeMessage(JLabel label, Socket s) {
        BufferedReader br;
        String message = null;
        try {
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            message = br.readLine();
            //System.out.println("Data read .." + message);
            s.close();
        } catch (IOException ex) {
            Logger.getLogger(ConnectionHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (message != null) {
            label.setText(message);
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            label.setLocation(dim.width, label.getLocation().y);
        }

    }
}

class ConnectionListener extends Thread {

    public void run() {

        try {
            ServerSocket s = new ServerSocket(7384);
            while (true) {
                //System.out.println("Listening ..");
                Socket c = s.accept();
                //System.out.println("Connected ..");
                ScrollFrame.getFrames()[0].setVisible(true);
                (new ConnectionHandler()).changeMessage(ScrollFrame.messageLabel, c);
            }
        } catch (IOException ex) {
            Logger.getLogger(ScrollFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
