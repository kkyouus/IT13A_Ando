
package Finals;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class GUILogin extends javax.swing.JFrame {

    
    public GUILogin() {
        initComponents();
        setBounds(600, 300, 400, 250);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelusername = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreausername = new javax.swing.JTextArea();
        jLabelpassword = new javax.swing.JLabel();
        jPasswordField = new javax.swing.JPasswordField();
        jButtonEnter = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(3, 2));

        jLabelusername.setText("Username:");
        getContentPane().add(jLabelusername);

        jTextAreausername.setColumns(20);
        jTextAreausername.setRows(5);
        jScrollPane1.setViewportView(jTextAreausername);

        getContentPane().add(jScrollPane1);

        jLabelpassword.setText("Password:");
        getContentPane().add(jLabelpassword);
        getContentPane().add(jPasswordField);

        jButtonEnter.setText("ENTER");
        jButtonEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnterActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEnter);

        jButtonCancel.setText("CANCEL");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCancel);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEnterActionPerformed
        String username = jTextAreausername.getText();
        String password = new String(jPasswordField.getPassword());
        
        SavedData(username, password);
        
        JOptionPane.showMessageDialog(this, "Account Saved Successfully", "Saved", JOptionPane.INFORMATION_MESSAGE);    
    }//GEN-LAST:event_jButtonEnterActionPerformed

    private void SavedData(String username,String password){
        try {
            File file = new File("C:\\Users\\User\\Documents\\Credentials.txt");
            
            BufferedWriter credits = new BufferedWriter(new FileWriter(file,true));
            credits.write("Username:" + username + ", password: "+ password);
            credits.newLine();
            credits.close();
            
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error Saving Account", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
            
    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        jTextAreausername.setText("");
        jPasswordField.setText("");
    }//GEN-LAST:event_jButtonCancelActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUILogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUILogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUILogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUILogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUILogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonEnter;
    private javax.swing.JLabel jLabelpassword;
    private javax.swing.JLabel jLabelusername;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreausername;
    // End of variables declaration//GEN-END:variables
}
