/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * IPDdumpAboutBox.java
 *
 * Created on 8 Ιουλ 2009, 7:47:35 μμ
 */
package gui;

import java.awt.Font;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author Jimmys Daskalakis
 */
public class IPDdumpAboutBox extends javax.swing.JDialog {

    String baseName = "gui.resources.IPDdumpAboutBox";
    ResourceBundle rb = ResourceBundle.getBundle(baseName, new Locale("en"));

    /** Creates new form IPDdumpAboutBox */
    public IPDdumpAboutBox(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

//        Enumeration bundleKeys = rb.getKeys();
//
//while (bundleKeys.hasMoreElements()) {
//    String key = (String)bundleKeys.nextElement();
//    String value = rb.getString(key);
//    System.out.println("key = " + key + ", " +
//		       "value = " + value);
//}

        setTitle(rb.getString("title"));
        appTitleLabel.setText(rb.getString("title"));
        versionLabel.setText(rb.getString("versionLabel"));
        appVersionLabel.setText(rb.getString("version"));
        vendorLabel.setText(rb.getString("vendorLabel"));
        appVendorLabel.setText(rb.getString("vendor"));
        homepageLabel.setText(rb.getString("homepageLabel"));
        appHomepageLabel.setText(rb.getString("homepage"));
        appDescLabel.setText(rb.getString("description"));

        appDescLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
        appVersionLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
        appVendorLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
        appHomepageLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
        appTitleLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        homepageLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
        vendorLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
        versionLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
    //iconLabel.setIcon(new ImageIcon(rb.getString("iconLabelIcon")));
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        iconLabel = new javax.swing.JLabel();
        appTitleLabel = new javax.swing.JLabel();
        versionLabel = new javax.swing.JLabel();
        appVersionLabel = new javax.swing.JLabel();
        vendorLabel = new javax.swing.JLabel();
        appVendorLabel = new javax.swing.JLabel();
        homepageLabel = new javax.swing.JLabel();
        appHomepageLabel = new javax.swing.JLabel();
        appDescLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        iconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/resources/about.png"))); // NOI18N

        appTitleLabel.setFont(appTitleLabel.getFont().deriveFont(appTitleLabel.getFont().getStyle() | java.awt.Font.BOLD, appTitleLabel.getFont().getSize()+4));
        appTitleLabel.setText("IPD dump");

        versionLabel.setFont(versionLabel.getFont().deriveFont(versionLabel.getFont().getStyle() | java.awt.Font.BOLD));
        versionLabel.setText("Product Version\\:");

        appVersionLabel.setText("1.0");

        vendorLabel.setFont(vendorLabel.getFont().deriveFont(vendorLabel.getFont().getStyle() | java.awt.Font.BOLD));
        vendorLabel.setText("Vendor\\:");

        appVendorLabel.setText("Jimmys");

        homepageLabel.setFont(homepageLabel.getFont().deriveFont(homepageLabel.getFont().getStyle() | java.awt.Font.BOLD));
        homepageLabel.setText("Homepage\\:");

        appHomepageLabel.setText("N/A");

        appDescLabel.setText("<html>The ipddump utility was created initially to extract SMS records from a Blackberry backup, which is an IPD (Inter@ctive Pager Backup) file. Its goal is to be able to extract and export all types of records into customized open text formats. It now supports Sms, Contacts and Memos in XML, CSV and plain text formats! The app is 100% free! please leave feedback in http://code.google.com/p/ipddump/issues/list for any issues you might have!");

        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(appTitleLabel)
                            .addComponent(appDescLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(versionLabel)
                            .addComponent(vendorLabel)
                            .addComponent(homepageLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(appHomepageLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 243, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addGap(32, 32, 32))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(appVersionLabel)
                                    .addComponent(appVendorLabel))
                                .addContainerGap(318, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(appTitleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(appDescLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(versionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(appVersionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vendorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(appVendorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(homepageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(appHomepageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1))
                .addGap(63, 63, 63))
            .addComponent(iconLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-610)/2, (screenSize.height-270)/2, 610, 270);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JLabel appDescLabel;
    private javax.swing.JLabel appHomepageLabel;
    private javax.swing.JLabel appTitleLabel;
    private javax.swing.JLabel appVendorLabel;
    private javax.swing.JLabel appVersionLabel;
    private javax.swing.JLabel homepageLabel;
    private javax.swing.JLabel iconLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel vendorLabel;
    private javax.swing.JLabel versionLabel;
    // End of variables declaration//GEN-END:variables
}
