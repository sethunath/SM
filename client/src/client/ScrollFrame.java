/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ScrollFrame.java
 *
 * Created on Apr 11, 2010, 2:52:11 PM
 */
package client;

import java.awt.AWTException;
import java.awt.CheckboxMenuItem;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author flyhigh
 */
public class ScrollFrame extends javax.swing.JFrame {

    static final int LOCATION_TOP = 1;
    static final int LOCATION_BOTTOM = 2;
    static final int LOCATION_MIDDLE = 3;
    
    /** Creates new form ScrollFrame */
    //static String message = "hello all test . this complete text should be displayed completely without break ups ";
    public ScrollFrame() {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        jButton1.setLocation((int) dim.getWidth() - 200, 0);
        //this.setUndecorated(true);
        //this.setLocation(100,100);


    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jButton1 = new javax.swing.JButton();
        messageLabel = new javax.swing.JLabel();

        jMenu1.setText("Location");

        jMenuItem1.setText("bottom");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("moddle");
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("top");
        jMenu1.add(jMenuItem3);

        jPopupMenu1.add(jMenu1);

        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(0, 0, 0));
        setForeground(new java.awt.Color(0, 0, 0));
        setUndecorated(true);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jButton1.setForeground(new java.awt.Color(0, 0, 255));
        jButton1.setText("X");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.setBorderPainted(false);
        jButton1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        messageLabel.setFont(new java.awt.Font("Times New Roman", 1, 24));
        messageLabel.setForeground(new java.awt.Color(204, 0, 0));
        messageLabel.setText("import java.awt.Rectangle;Adding background image to JDesktopPaneAdding background image to JDesktopPane");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(358, 358, 358)
                .addComponent(messageLabel)
                .addContainerGap(472, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(messageLabel)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
        if (evt.getButton() == 3) {
            jPopupMenu1.show(this, evt.getX(), evt.getY());

        }
    }//GEN-LAST:event_formMouseClicked

    /**
     * @param args the command line arguments
     */
    protected static Image createImage(String path, String description) {
        
        return (new ImageIcon(path, description)).getImage();
        
    }

    public static void main(String args[]) {
        final boolean decorated = false;
        final int location = ScrollFrame.LOCATION_TOP;

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                final ScrollFrame jf1 = new ScrollFrame();
                final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

                final PopupMenu popup = new PopupMenu();
                final TrayIcon trayIcon = new TrayIcon(createImage("icon.gif", "tray icon"));
                final SystemTray tray = SystemTray.getSystemTray();

                // Create a popup menu components
                //MenuItem aboutItem = new MenuItem("About");
                final CheckboxMenuItem cb1 = new CheckboxMenuItem("Top");
                final CheckboxMenuItem cb2 = new CheckboxMenuItem("Middle");
                final CheckboxMenuItem cb3 = new CheckboxMenuItem("Bottom");
                cb1.addItemListener(new ItemListener() {

                    public void itemStateChanged(ItemEvent e) {
                        int cb1Id = e.getStateChange();
                        if (cb1Id == ItemEvent.SELECTED) {
                            // action goest here
                            jf1.setBounds(2, 3, dim.width, 50);
                            cb2.setState(false);
                            cb3.setState(false);
                        } 
                    }
                });
                cb2.addItemListener(new ItemListener() {

                    public void itemStateChanged(ItemEvent e) {
                        int cb1Id = e.getStateChange();
                        if (cb1Id == ItemEvent.SELECTED) {
                            // action goest here
                            jf1.setBounds(2, dim.height / 2, dim.width, 50);
                            cb1.setState(false);
                            cb3.setState(false);
                        }
                    }
                });

                cb3.addItemListener(new ItemListener() {

                    public void itemStateChanged(ItemEvent e) {
                        int cb1Id = e.getStateChange();
                        if (cb1Id == ItemEvent.SELECTED) {
                            // action goest here
                            jf1.setBounds(2, dim.height - 80, dim.width, 50);
                            cb2.setState(false);
                            cb1.setState(false);
                        }
                    }
                });
                
                Menu displayMenu = new Menu("Location");
                MenuItem exitItem = new MenuItem("Exit");

                //Add components to popup menu
                //popup.add(aboutItem);


                popup.add(displayMenu);
                displayMenu.add(cb1);
                displayMenu.add(cb2);
                displayMenu.add(cb3);
                popup.add(exitItem);

                trayIcon.setPopupMenu(popup);
                try {
                    tray.add(trayIcon);
                } catch (AWTException ex) {
                    Logger.getLogger(ScrollFrame.class.getName()).log(Level.SEVERE, null, ex);
                }

                //jf1.setUndecorated(decorated);
                jf1.setVisible(false);
                
                if (location == ScrollFrame.LOCATION_BOTTOM) {
                    jf1.setBounds(2, dim.height - 80, dim.width, 50);
                }
                if (location == ScrollFrame.LOCATION_MIDDLE) {
                    jf1.setBounds(2, dim.height / 2, dim.width, 50);
                }
                if (location == ScrollFrame.LOCATION_TOP) {
                    jf1.setBounds(2, 3, dim.width, 50);
                }

                //ScrollFrame.jLabel1.setSize(1024, 100);

                // System.out.println("Abt to accept ..");
                new ConnectionListener().start();
                new Scroller(ScrollFrame.messageLabel, Toolkit.getDefaultToolkit().getScreenSize().width).start();
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    public javax.swing.JPopupMenu jPopupMenu1;
    static javax.swing.JLabel messageLabel;
    // End of variables declaration//GEN-END:variables
}

class Scroller extends Thread {

    JLabel jl;
    int maxx;

    public Scroller(JLabel jl, int maxx) {
        this.jl = jl;
        this.maxx = maxx;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(25);
                jl.setLocation((jl.getBounds().x + jl.getBounds().width) == 0 ? maxx : jl.getLocation().x - 1, jl.getLocation().y);
                //jl.setText(ScrollFrame.message);
            } catch (InterruptedException ex) {
                Logger.getLogger(Scroller.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}