/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package comapp;

import app.Com;
import app.Parameters;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author flyhigh
 */
public class GSMMessenger {

    private static GSMMessenger gsmMessenger = null;
    Com com1;
    PrintStream debugOut;
    static String response = "SMS was not sent. Please check modem";
    private GSMMessenger() {
          debugOut = System.out;
    }

    public static GSMMessenger getInstance() {
        response = "SMS was not sent. Please check modem";
        return gsmMessenger == null ? new GSMMessenger() : gsmMessenger;
    }

    public synchronized int sendMessage(String number, String message) {
        try {
            Parameters param = new Parameters();
            param.setPort("COM1");
            param.setBaudRate("9600");
            debugOut.println("Connecting ..");
            com1 = new Com(param);
            debugOut.println("Connected");
            char[] data = ("at+cmgs=\""+number+"\"").toCharArray();
            debugOut.println("Sending command..");
            for (int i = 0; i < data.length; i++) {

                com1.sendSingleData(data[i]);
                //Thread.sleep(40);
            }
            com1.sendSingleData(0x0D);
            debugOut.println("Recieving response..");
            boolean readytogo = false;
            long endTimestamp = System.currentTimeMillis()+5000;
            while (true) {
                if(System.currentTimeMillis()>endTimestamp){
                    throw new Exception("Sending Failed");
                }
                Thread.sleep(40);
                int read = com1.receiveSingleDataInt();
                System.out.println(read);
                if (readytogo) {
                    if (read == 32) {
                        break;
                    }
                }
                if (read == 62) {
                    readytogo = true;
                }

            }
            debugOut.println("Sending message ..");
            com1.sendArrayChar(message.toCharArray(),2);
            com1.sendSingleData(0x1A);
            debugOut.println("waiting for ok ..");
            readytogo = false;
            endTimestamp = System.currentTimeMillis()+5000;
            while (true) {
                if(System.currentTimeMillis()>endTimestamp){
                    throw new Exception("Sending Failed");
                }
                Thread.sleep(40);
                int read = com1.receiveSingleDataInt();
                System.out.println(read);
                if (readytogo) {
                    if (read == 'K') {
                        break;
                    }
                }
                if (read == 'O') {
                    readytogo = true;
                }

            }
            debugOut.println("ok recvd");
            response = "SMS Sent";
            
        } catch (Exception e) {
            Logger.getLogger(GSMMessenger.class.getName()).log(Level.SEVERE, null, e);
            response+="  :"+e.getMessage();
            return 0;
        }
        finally{
            try {
                com1.close();
            } catch (Exception ex) {
                Logger.getLogger(GSMMessenger.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 1;
    }
    synchronized boolean ready(){
        boolean response=true;
        try{
            Parameters param = new Parameters();
            param.setPort("COM1");
            param.setBaudRate("9600");
            debugOut.println("Connecting ..");
            com1 = new Com(param);
            debugOut.println("Connected");
            char[] data = ("at").toCharArray();
            for (int i = 0; i < data.length; i++) {
                com1.sendSingleData(data[i]);
                //Thread.sleep(400);
            }
            com1.sendSingleData(0x0D);
            
            int referenceData[] = {97,116,13,13,10,79,75,13,10};
            int c=0;
            while (true) {
                Thread.sleep(50);
                int read = com1.receiveSingleDataInt();
                if(c==referenceData.length){
                    break;
                }
                System.out.println(read);
                if(referenceData[c]!=read){
                    break;
                }
                c++;
                
            }
            if(c!=referenceData.length){
                debugOut.println(c+"      "+referenceData.length);
                return false;
            }
            else{
                return true;
            }
        }
        catch(Exception e){
            response =false;
            Logger.getLogger(GSMMessenger.class.getName()).log(Level.SEVERE, null, e);
        }
        finally{
        try {
            com1.close();
        } catch (Exception ex) {
            Logger.getLogger(GSMMessenger.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        return response;
    }
    void closeConnection(){
        try {
            com1.close();
        } catch (Exception ex) {
            Logger.getLogger(GSMMessenger.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
