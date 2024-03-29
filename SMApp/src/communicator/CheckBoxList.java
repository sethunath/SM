/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package communicator;

/**
 *
 * @author flyhigh
 */
import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

import javax.swing.border.*;


public class CheckBoxList extends JFrame

{

  protected JList  m_list;

  protected JLabel m_total;

  public CheckBoxList() {

    super("Swing List [Check boxes]");

    setSize(280, 250);

    getContentPane().setLayout(new FlowLayout());

    InstallData[] options = {

      new InstallData("Program executable", 118),

      new InstallData("Help files", 52),

      new InstallData("Tools and converters", 83),

      new InstallData("Source code", 133)

    };

    m_list = new JList(options);

    CheckListCellRenderer renderer = new CheckListCellRenderer();

    m_list.setCellRenderer(renderer);

    m_list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    CheckListener lst = new CheckListener(this);

    m_list.addMouseListener(lst);

    m_list.addKeyListener(lst);

    JScrollPane ps = new JScrollPane();

    ps.getViewport().add(m_list);

    m_total = new JLabel("Space required: 0K");

    JPanel p = new JPanel();

    p.setLayout(new BorderLayout());

    p.add(ps, BorderLayout.CENTER);

    p.add(m_total, BorderLayout.SOUTH);

    p.setBorder(new TitledBorder(new EtchedBorder(),

      "Please select options:") );

    getContentPane().add(p);

    WindowListener wndCloser = new WindowAdapter() {

      public void windowClosing(WindowEvent e) {

        System.exit(0);

      }

    };

    addWindowListener(wndCloser);

    setVisible(true);

    recalcTotal();

  }

  public void recalcTotal() {

    ListModel model = m_list.getModel();

    int total = 0;

    for (int k=0; k<model.getSize(); k++) {

      InstallData data = (InstallData)model.getElementAt(k);

      if (data.isSelected())

        total += data.getSize();

    }

    m_total.setText("Space required: "+total+"K");

  }

  public static void main(String argv[]) {

    new CheckBoxList();

  }

}

class CheckListCellRenderer extends JCheckBox

 implements ListCellRenderer

{

  protected static Border m_noFocusBorder =

    new EmptyBorder(1, 1, 1, 1);

  public CheckListCellRenderer() {

    super();

    setOpaque(true);

    setBorder(m_noFocusBorder);

  }

  public Component getListCellRendererComponent(JList list,

   Object value, int index, boolean isSelected, boolean cellHasFocus)

  {

    setText(value.toString());

    setBackground(isSelected ? list.getSelectionBackground() :

      list.getBackground());

    setForeground(isSelected ? list.getSelectionForeground() :

      list.getForeground());

    InstallData data = (InstallData)value;

      setSelected(data.isSelected());

    setFont(list.getFont());

    setBorder((cellHasFocus) ?

    UIManager.getBorder("List.focusCellHighlightBorder")

      : m_noFocusBorder);

    return this;

  }

}

class CheckListener implements MouseListener, KeyListener

{

  protected CheckBoxList m_parent;

  protected JList m_list;

  public CheckListener(CheckBoxList parent) {

    m_parent = parent;

    m_list = parent.m_list;

  }

  public void mouseClicked(MouseEvent e) {

    if (e.getX() < 20)

    doCheck();

  }

  public void mousePressed(MouseEvent e) {}

  public void mouseReleased(MouseEvent e) {}

  public void mouseEntered(MouseEvent e) {}

  public void mouseExited(MouseEvent e) {}

  public void keyPressed(KeyEvent e) {

    if (e.getKeyChar() == ' ')

      doCheck();

  }

  public void keyTyped(KeyEvent e) {}

  public void keyReleased(KeyEvent e) {}

  protected void doCheck() {

    int index = m_list.getSelectedIndex();

    if (index < 0)

      return;

    InstallData data = (InstallData)m_list.getModel().

      getElementAt(index);

    data.invertSelected();

    m_list.repaint();

    m_parent.recalcTotal();

  }

}

class InstallData

{

  protected String m_name;

  protected int m_size;

  protected boolean m_selected;

  public InstallData(String name, int size) {

    m_name = name;

    m_size = size;

    m_selected = false;

  }

  public String getName() { return m_name; }

  public int getSize() { return m_size; }

  public void setSelected(boolean selected) {

    m_selected = selected;

  }

  public void invertSelected() { m_selected = !m_selected; }

  public boolean isSelected() { return m_selected; }

  public String toString() { return m_name+" ("+m_size+" K)"; }

}