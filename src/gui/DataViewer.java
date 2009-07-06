/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DataViewer.java
 *
 * Created on 11 Ιουν 2009, 9:29:00 μμ
 */
package gui;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 *
 * @author Jimmys Daskalakis - jimdaskalakis01@yahoo.gr
 */
public class DataViewer extends javax.swing.JFrame {

    private String strXml;
    private String strTxt;
    private String strCsv;

    /** Creates new form DataViewer */
    public DataViewer() {
        initComponents();
    }

    public void setXml(String strXml) {
        this.strXml = strXml;
        TextArea.setLineWrap(true);
        TextArea.setText(strXml);
    }

    public void setTxt(String strTxt) {
        this.strTxt = strTxt;
        TextArea.setLineWrap(true);
        TextArea.setText(strTxt);

    }

    public void setCvs(String strCsv) {
        this.strCsv = strCsv;
        TextArea.setLineWrap(false);
        TextArea.setText(strCsv);
    }

    private void ShowMenuPopup(MouseEvent e) {
        jPopupMenu1.show(e.getComponent(),
                e.getX(), e.getY());
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
        CopyJmenu = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextArea = new javax.swing.JTextArea();

        CopyJmenu.setText("Copy     Ctrl+C");
        CopyJmenu.setActionCommand("Copy");
        CopyJmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CopyJmenuActionPerformed(evt);
            }
        });
        jPopupMenu1.add(CopyJmenu);

        setTitle("Viewer");

        TextArea.setColumns(20);
        TextArea.setEditable(false);
        TextArea.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        TextArea.setLineWrap(true);
        TextArea.setRows(5);
        TextArea.setAutoscrolls(false);
        TextArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TextAreaMouseClicked(evt);
            }
        });
        TextArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TextAreaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(TextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-585)/2, (screenSize.height-410)/2, 585, 410);
    }// </editor-fold>//GEN-END:initComponents

    private void TextAreaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TextAreaMouseClicked
        ShowMenuPopup(evt);
    }//GEN-LAST:event_TextAreaMouseClicked

    private void CopyJmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CopyJmenuActionPerformed
        setClipboardContents(TextArea.getSelectedText());
    }//GEN-LAST:event_CopyJmenuActionPerformed

    private void TextAreaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextAreaKeyPressed
        if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_C) {
            setClipboardContents(TextArea.getSelectedText());
        }
    }//GEN-LAST:event_TextAreaKeyPressed
    public static void setClipboardContents(String aString) {
        StringSelection stringSelection = new StringSelection(aString);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, (ClipboardOwner) null);
    }
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new DataViewer().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem CopyJmenu;
    public javax.swing.JTextArea TextArea;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
