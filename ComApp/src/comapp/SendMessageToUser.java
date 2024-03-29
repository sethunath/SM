/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SendMessageToUser.java
 *
 * Created on Apr 12, 2010, 5:22:56 PM
 */
package comapp;

import communicator.DB.DBModel;
import communicator.DB.User;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jdesktop.application.Action;

/**
 *
 * @author flyhigh
 */
public class SendMessageToUser extends javax.swing.JInternalFrame {

    /** Creates new form SendMessageToUser */
    String ip = null;
    String message = null;
    String phone;

    public SendMessageToUser() {
        initComponents();
        groupSetVisible(false);
//        jLabel2.setSize(40,40);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        searchText = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        smsCheckBox = new javax.swing.JCheckBox();
        imCheckBox = new javax.swing.JCheckBox();
        okButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        messageText = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();
        statusLabel = new javax.swing.JLabel();

        setClosable(true);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(comapp.ComApp.class).getContext().getResourceMap(SendMessageToUser.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        searchText.setText(resourceMap.getString("searchText.text")); // NOI18N
        searchText.setName("searchText"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(comapp.ComApp.class).getContext().getActionMap(SendMessageToUser.class, this);
        jButton1.setAction(actionMap.get("showDetails")); // NOI18N
        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton1MouseReleased(evt);
            }
        });

        smsCheckBox.setText(resourceMap.getString("smsCheckBox.text")); // NOI18N
        smsCheckBox.setName("smsCheckBox"); // NOI18N

        imCheckBox.setText(resourceMap.getString("imCheckBox.text")); // NOI18N
        imCheckBox.setName("imCheckBox"); // NOI18N

        okButton.setText(resourceMap.getString("okButton.text")); // NOI18N
        okButton.setName("okButton"); // NOI18N
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        messageText.setName("messageText"); // NOI18N
        jScrollPane1.setViewportView(messageText);

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        statusLabel.setText(resourceMap.getString("statusLabel.text")); // NOI18N
        statusLabel.setName("statusLabel"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(okButton)
                        .addGap(73, 73, 73)
                        .addComponent(statusLabel))
                    .addComponent(imCheckBox)
                    .addComponent(smsCheckBox)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchText, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(searchText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(smsCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(imCheckBox)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(okButton)
                            .addComponent(statusLabel))
                        .addGap(118, 118, 118))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel2)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    void groupSetVisible(boolean visibility) {
        smsCheckBox.setVisible(visibility);
        imCheckBox.setVisible(visibility);
        okButton.setVisible(visibility);
    }
    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        // TODO add your handling code here:
        //new SendMessage(ComApp.getApplication(),"192.168.1.40","hello man");
        //okButton.setIcon(new ImageIcon("loading.gif"));
        if(messageText.getText().trim().length()==0){
            JOptionPane.showMessageDialog(this, "Please provide a message");
            return;
        }
        if (imCheckBox.isSelected()) {
            //okButton.setText("sending IM ..");
            statusLabel.setText("Sending IM ..");
            okButton.setEnabled(false);
            Thread t = new SendMessage(ip, messageText.getText());
            t.start();
            try {
                t.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(SendMessageToUser.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(this, ((SendMessage) t).response);
            okButton.setEnabled(true);
            statusLabel.setText("");
            //okButton.setIcon(new ImageIcon());
            okButton.setText("OK");
        }
        if (smsCheckBox.isSelected()) {
            statusLabel.setText("Sending SMS ..");
            Runnable t = new Runnable() {

                public void run() {
                    GSMMessenger.getInstance().sendMessage(phone, messageText.getText());;
                }
            };
            Thread myT = new Thread(t);
            myT.start();
            try {
                myT.join(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(SendMessageToUser.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(this, GSMMessenger.response);
            statusLabel.setText("");
        }
    }

    @Action
    public void showDetails() {
        if (!new DBModel().empIdExists(searchText.getText().trim())) {
            groupSetVisible(false);
            JOptionPane.showMessageDialog(this, "Employee Id Not Found", "Attention", JOptionPane.ERROR_MESSAGE);

            return;
        }

        User u = new DBModel().getUserByEmpId(searchText.getText().trim());
        if (u.getIp() != null && u.getIp().trim().length() != 0) {
            this.ip = u.getIp();
            imCheckBox.setVisible(true);
            imCheckBox.setText("Send IM to " + ip + "(" + u.getUsername() + ")");
        }
        if (u.getPhone() != null && u.getPhone().trim().length() != 0) {
            this.phone = u.getPhone();
            smsCheckBox.setVisible(true);
            smsCheckBox.setText("Send SMS to " + phone + "(" + u.getUsername() + ")");
        }
        okButton.setVisible(true);
    }//GEN-LAST:event_okButtonActionPerformed

    private void jButton1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseReleased
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox imCheckBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane messageText;
    private javax.swing.JButton okButton;
    private javax.swing.JTextField searchText;
    private javax.swing.JCheckBox smsCheckBox;
    private javax.swing.JLabel statusLabel;
    // End of variables declaration//GEN-END:variables
}
