/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abscorp;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author muzammil
 */
public class loign extends javax.swing.JFrame {
    
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    /**
     * Creates new form loign
     */
    public loign() {
        initComponents();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
      
        
        conn = db.java_db();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_combo = new javax.swing.JComboBox<>();
        login_btn = new javax.swing.JButton();
        txt_username = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Andika", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(218, 204, 204));
        jLabel1.setText("Welcome to ABS Corp");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(30, 230, 436, 71);

        jLabel4.setFont(new java.awt.Font("Ubuntu Light", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 250, 250));
        jLabel4.setText("Position        :");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(50, 440, 113, 34);

        jLabel2.setFont(new java.awt.Font("Ubuntu Light", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(252, 252, 252));
        jLabel2.setText("Username    :");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(50, 310, 113, 48);

        jLabel3.setFont(new java.awt.Font("Ubuntu Light", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(248, 241, 241));
        jLabel3.setText("Password    :");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(50, 380, 113, 37);

        txt_combo.setFont(new java.awt.Font("Ubuntu Light", 1, 18)); // NOI18N
        txt_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Supervisor", "Associate" }));
        jPanel1.add(txt_combo);
        txt_combo.setBounds(200, 440, 240, 42);

        login_btn.setFont(new java.awt.Font("Andika", 1, 18)); // NOI18N
        login_btn.setForeground(new java.awt.Color(23, 0, 255));
        login_btn.setText("LogIn");
        login_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_btnActionPerformed(evt);
            }
        });
        jPanel1.add(login_btn);
        login_btn.setBounds(340, 510, 129, 58);

        txt_username.setFont(new java.awt.Font("Ubuntu Light", 1, 18)); // NOI18N
        txt_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usernameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_username);
        txt_username.setBounds(200, 320, 240, 40);
        jPanel1.add(txt_password);
        txt_password.setBounds(200, 380, 240, 40);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/abscorp/images/back1.jpg"))); // NOI18N
        jPanel1.add(jLabel5);
        jLabel5.setBounds(0, -30, 925, 652);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 910, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameActionPerformed

    private void login_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_btnActionPerformed



         String sql= "select empID,username,Password,Salary,pos from employee where (username = ? and Password = ? and pos = ?)";
        try{
            
            
            int count = 0;
            
            pst = conn.prepareStatement(sql);
            
            pst.setString(1, txt_username.getText());
            pst.setString(2, txt_password.getText());
            pst.setString(3, txt_combo.getSelectedItem().toString());
            
//            JOptionPane.showMessageDialog(null,"before updating count : "+ count);
            
            rs = pst.executeQuery();
            
            while(rs.next()){
                String position = rs.getString(5);
                String password = rs.getString(3);
                String username = rs.getString(2);
                Employee.Satus = position;
                Employee.username = username;
                Employee.pass = password;
                count= count + 1;
            }
//            JOptionPane.showMessageDialog(null, "After updating count : "+count);
            
            
            
            
            String access = (txt_combo.getSelectedItem().toString());
            
            
            if (count ==  1){
                if(access == "Supervisor"){
                    Supervisor supervisor = new Supervisor();
                    supervisor.setVisible(true);
                    this.dispose();
                }else{
                    Associate associate = new Associate();
                    associate.setVisible(true);
                    this.dispose();
                
                }
                
                
                
            }else{
                 JOptionPane.showMessageDialog(null, "Username,Password,or position entered are wrong");
            
            }
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
            try{
                
                rs.close();
                pst.close();
                
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        
        
        }
        









        // TODO add your handling code here:
    }//GEN-LAST:event_login_btnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(loign.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loign.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loign.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loign.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loign().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton login_btn;
    private javax.swing.JComboBox<String> txt_combo;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
