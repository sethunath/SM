/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EditEmployee.java
 *
 * Created on Apr 12, 2010, 3:54:36 PM
 */

package comapp;

import communicator.DB.DBModel;
import communicator.DB.User;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import org.jdesktop.application.Action;

/**
 *
 * @author flyhigh
 */
public class EditEmployee extends javax.swing.JInternalFrame {
      DefaultComboBoxModel listModel;
    /** Creates new form EditEmployee */
    public EditEmployee() {
        populateListModel();
        initComponents();
        groupSetVisible(false);
    }
    void populateListModel(){
        listModel = new DefaultComboBoxModel();
        ArrayList al = new DBModel().getDepartments();
        Iterator i = al.iterator();
        while(i.hasNext()){
            listModel.addElement((String)i.next());
        }
    }
    void groupSetVisible(boolean visibility){
        jLabel2.setVisible(visibility);
        jLabel3.setVisible(visibility);
        jLabel4.setVisible(visibility);
        jLabel5.setVisible(visibility);
        nameText.setVisible(visibility);
        phoneText.setVisible(visibility);
        jComboBox1.setVisible(visibility);
        ipText.setVisible(visibility);
        saveButton.setVisible(visibility);
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
        nameText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        phoneText = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        ipText = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();

        setClosable(true);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(comapp.ComApp.class).getContext().getResourceMap(EditEmployee.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        searchText.setText(resourceMap.getString("searchText.text")); // NOI18N
        searchText.setName("searchText"); // NOI18N

        nameText.setName("nameText"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel5.setText(resourceMap.getString("jLabel5.text")); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N

        jComboBox1.setModel(listModel);
        jComboBox1.setName("jComboBox1"); // NOI18N

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        phoneText.setName("phoneText"); // NOI18N

        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        ipText.setName("ipText"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(comapp.ComApp.class).getContext().getActionMap(EditEmployee.class, this);
        jButton1.setAction(actionMap.get("showEditPane")); // NOI18N
        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N

        saveButton.setAction(actionMap.get("edit")); // NOI18N
        saveButton.setText(resourceMap.getString("saveButton.text")); // NOI18N
        saveButton.setName("saveButton"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addContainerGap())
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel5)
                                .addComponent(jLabel1))
                            .addGap(63, 63, 63)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(searchText, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                .addComponent(jComboBox1, 0, 149, Short.MAX_VALUE)
                                .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(phoneText, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                .addComponent(ipText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                .addComponent(saveButton))
                            .addGap(48, 48, 48)
                            .addComponent(jButton1)
                            .addGap(107, 107, 107)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1)
                    .addComponent(searchText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(phoneText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ipText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(saveButton)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Action
    public void showEditPane() {
        if(!new DBModel().empIdExists(searchText.getText().trim())){
            groupSetVisible(false);
            JOptionPane.showMessageDialog(this,"Employee Id Not Found","Attention",JOptionPane.ERROR_MESSAGE);
            
            return;
        }
        groupSetVisible(true);
        User u = new DBModel().getUserByEmpId(searchText.getText().trim());
        nameText.setText(u.getUsername());
        phoneText.setText(u.getPhone());
        ipText.setText(u.getIp());
        jComboBox1.setSelectedItem(new DBModel().getDepartmentById(u.getDepartment()));
    }

    @Action
    public void edit() {
         if(nameText.getText().trim().length()==0){
            JOptionPane.showMessageDialog(this,"Please provide a name","Attention",JOptionPane.ERROR_MESSAGE);
            return;
        }
        new DBModel().editUser(nameText.getText().trim(),(String)jComboBox1.getSelectedItem(),ipText.getText().trim(),phoneText.getText().trim(),searchText.getText().trim());
        JOptionPane.showMessageDialog(this,"Employee Details Saved","Done",JOptionPane.INFORMATION_MESSAGE);
        groupSetVisible(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ipText;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField nameText;
    private javax.swing.JTextField phoneText;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField searchText;
    // End of variables declaration//GEN-END:variables

}