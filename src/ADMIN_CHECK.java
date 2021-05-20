
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author hp
 */
public class ADMIN_CHECK extends javax.swing.JFrame {

    /**
     * Creates new form ADMIN_CHECK
     */
    
    public ADMIN_CHECK() {
        initComponents();
    }
    public void submitvideo(){
        String value=(String) combobox.getSelectedItem();
          try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/upepeo"
        ,"root", "12345678");
              System.out.println("Connected");
           if(value.equals("General")){
            String sql = "INSERT INTO general VALUES (?,?)";
            PreparedStatement stm=con.prepareStatement(sql);
            
stm.setString(1, movienametxt.getText());
stm.setString(2,movieidtxt.getText());
System.out.println("connected");
stm.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "general Video added sucessfully");
            
           }    
           else if(value.equalsIgnoreCase("horror")){
                String sql = "INSERT INTO horror VALUES (?,?)";
            PreparedStatement stm=con.prepareStatement(sql);
            
            
stm.setString(1, movienametxt.getText());
stm.setString(2,movieidtxt.getText());
System.out.println("connected");
stm.executeUpdate();
            JOptionPane.showMessageDialog(null, "horror Video added sucessfully");
                 movieidtxt.setText("");
            movienametxt.setText(""); 
           }
           else if(value.equalsIgnoreCase("comedy")){
                String sql = "INSERT INTO comedy VALUES (?,?)";
            PreparedStatement stm=con.prepareStatement(sql);
            
            
stm.setString(1, movienametxt.getText());
stm.setString(2,movieidtxt.getText());
System.out.println("connected");
stm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Comedy Video added sucessfully");
                  movieidtxt.setText("");
            movienametxt.setText("");
           }
           else if(value.equalsIgnoreCase("cartoon")){
                String sql = "INSERT INTO cartoon VALUES (?,?)";
            PreparedStatement stm=con.prepareStatement(sql);
            
            
stm.setString(1, movienametxt.getText());
stm.setString(2,movieidtxt.getText());
System.out.println("connected");
stm.executeUpdate();
            JOptionPane.showMessageDialog(null, "cartoon Video added sucessfully");
            movieidtxt.setText("");
            movienametxt.setText("");
               
           }
           else if(value.equalsIgnoreCase("thriller")){
                String sql = "INSERT INTO thriller VALUES (?,?)";
            PreparedStatement stm=con.prepareStatement(sql);
            
            
stm.setString(1, movienametxt.getText());
stm.setString(2,movieidtxt.getText());
System.out.println("connected");
stm.executeUpdate();
            JOptionPane.showMessageDialog(null, "horror Video added sucessfully");
                  movieidtxt.setText("");
            movienametxt.setText("");
           }
        }catch(HeadlessException | ClassNotFoundException | SQLException ex){
            System.out.println("Crushes at a certain point");
        }
    }
    
  public ArrayList<members> People(){
      
ArrayList<members> membersList=new ArrayList<>();    

try{
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/upepeo"
        ,"root", "12345678");

String sql="SELECT * FROM membershipidentity";
Statement pstm=con.createStatement();
 
ResultSet rs=pstm.executeQuery(sql);
   System.out.println("Executing querry successfully");
members member;
while(rs.next()){
    member =new members        (rs.getString("Firstname"),      rs.getString("Lastname"),        rs.getString("Password"),   rs.getString("Email"),       rs.getInt("Phone_Number"),                
            rs.getString("Occupation"),            rs.getString("membership_ID"),            rs.getString("Registered_date"),           rs.getString("Username"),                   rs.getString("Street.No"),  
            rs.getString("House.No"));
   membersList.add(member);
   
}

rs.close();
con.close();
    
}catch(ClassNotFoundException | SQLException ex){
    System.out.println("Wrong idVideo");
}// TODO add your handling code here:
return membersList;    
    }
       
       public void show_members(){
        
        
        
     ArrayList <members>list=People();
     DefaultTableModel model=(DefaultTableModel)movietable.getModel();
       
     Object[] row=new Object[11];
 
     for(int i=0;i<list.size();i++){
        row[0] = list.get(i).getFirstname();
        row[1] = list.get(i).getLastname();
        row[2] = list.get(i).getPassword();
        row[3] = list.get(i).getEmail();
        row[4] = list.get(i).getPhone();
        row[5] = list.get(i).getOccupation();
        row[6] = list.get(i).getMembershipID();
        row[7] = list.get(i).getRegisteredDate();
        row[8] = list.get(i).getUsername();
        row[9] = list.get(i).getStreetNo();
        row[10] = list.get(i).getHouseNum();
        model.addRow(row);
     }
       }
        // System.out.println(Arra

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        movietable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        combobox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        movieidtxt = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        movienametxt = new javax.swing.JTextPane();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));

        jTabbedPane1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jTabbedPane1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jTabbedPane1ComponentShown(evt);
            }
        });

        movietable.setBackground(new java.awt.Color(51, 51, 51));
        movietable.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        movietable.setForeground(new java.awt.Color(255, 255, 255));
        movietable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "FirstName", "LastName", "Password", "Email", "PhoneNumber", "Occupation", "MembershipID", "Registered_Date", "Username", "Street_Numberr", "House_num"
            }
        ));
        jScrollPane1.setViewportView(movietable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1304, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Registered_Members", jPanel1);

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        combobox.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        combobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "General", "Horror", "Thriller", "cartoon", "Comedy", " " }));
        combobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Category");

        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("movie_ID");

        jLabel3.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Movie_Name");

        jScrollPane2.setViewportView(movieidtxt);

        jScrollPane3.setViewportView(movienametxt);

        jButton1.setBackground(new java.awt.Color(0, 0, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("SUBMIT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 51, 51));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton2.setText("DELETE");

        jButton3.setBackground(new java.awt.Color(255, 0, 0));
        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton3.setText("CANCEL");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(86, 86, 86)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(114, 114, 114)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(combobox, javax.swing.GroupLayout.Alignment.LEADING, 0, 253, Short.MAX_VALUE)))
                .addContainerGap(750, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(combobox, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addGap(38, 38, 38)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(298, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Add_Video", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPane1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTabbedPane1ComponentShown
show_members();        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane1ComponentShown

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
submitvideo();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void comboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboboxActionPerformed

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
            java.util.logging.Logger.getLogger(ADMIN_CHECK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ADMIN_CHECK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ADMIN_CHECK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ADMIN_CHECK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ADMIN_CHECK().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combobox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextPane movieidtxt;
    private javax.swing.JTextPane movienametxt;
    private javax.swing.JTable movietable;
    // End of variables declaration//GEN-END:variables
}
