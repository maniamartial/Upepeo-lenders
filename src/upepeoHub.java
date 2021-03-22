
import java.awt.Color;
import java.awt.HeadlessException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */

public class upepeoHub extends javax.swing.JFrame {
    

    /**
     * Creates new form upepeoHub
     */
    public upepeoHub() {
        initComponents();
        
         ButtonGroup gb=new ButtonGroup();
    gb.add(radiocartoon);
    gb.add(radiogeneral);
gb.add(radiothriller);
gb.add(radiohorror);
gb.add(radiocomedy);

movienumbertxt.setEditable(false);
ButtonGroup bg=new ButtonGroup();
bg.add(radiogood);
bg.add(radiobad);


ButtonGroup confirm=new ButtonGroup();
confirm.add(goodradio);
confirm.add(badradio);
confirm.add(spoiltradio);

firstnamecardtxt.setEditable(false);
lastnamecardtxt.setEditable(false);
passwordcardtxt.setEditable(false);
emailcardtxt.setEditable(false);
phonecardtxt.setEditable(false);
occupationcardtxt.setEditable(false);
usernamecardtxt.setEditable(false);
    }
    
    /*private void Print(){
        
        try{
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/upepeo"
        ,"root", "Jose19#*");

String sql="SELECT * FROM membershipidentity WHERE username=? and password=?";
Statement st=con.createStatement();
ResultSet rs=st.executeQuery(sql);
while(rs.next()){
    member=new members(rs.getString("Firstname"),      rs.getString("Lastname"),        rs.getString("Password"),   rs.getString("Email"),       rs.getInt("Phone_Number"),                
            rs.getString("Occupation"),            rs.getString("membership_ID"),            rs.getString("Registered_date"),           rs.getString("Username"),                   rs.getString("Street.No"),  
            rs.getString("House.No"));
    printReceipt.add(member);
    
    
    String fname=rs.getString("Firstname");
    String lname=rs.getString("Lastname");
    String password=rs.getString("Password");
    String email=rs.getString("Email");
    int phonenum=rs.getInt("Phone_Number");
    String occupation=rs.getString("Occupation");
    String userName=rs.getString("Username");
    String membershipId=rs.getString("membership_ID");
    
}
rs.close();
con.close();

        }catch(Exception ex){
            System.out.println("An error occured");
        }  
       // return printReceipt;
    }*/
    
    public void demandPayment(){
        JOptionPane.showMessageDialog(null, "Payment of Ksh.700");
        
    }
    public String incrementdate(){
        SimpleDateFormat form=new SimpleDateFormat("yyyy,MM,dd");
        Calendar cal=Calendar.getInstance();
        String det=form.format(cal.getTime());
        int daysnum=Integer.parseInt(daystxt.getText());
        cal.add(Calendar.DAY_OF_MONTH, daysnum);
        String finaldays = form.format(cal.getTime());
        return finaldays;
    }
public void calculatePayment(){
    int count=0;
    int amount=0;
    if(movieidtxt.getText().startsWith("1")){
        count++;
        amount+=50*count;
        String totalamount=Integer.toString(amount);
        amountborrowtxt.setText(totalamount);
        Register rg=new Register();
        String dat=rg.automaticDate();
        datetxt.setText(incrementdate());
    }
    
    else if(movieidtxt.getText().startsWith("2")){
        count++;
         amount+=70*count;
          String totalamount=Integer.toString(amount);
        amountborrowtxt.setText(totalamount);
        Register rg=new Register();
        String dat=rg.automaticDate();
        datetxt.setText(incrementdate());
    }
     else if(movieidtxt.getText().startsWith("3")){
        count++;
         amount+=60*count;
    }
     else if(movieidtxt.getText().startsWith("4")){
        count++;
         amount+=40*count;
    }
     else if(movieidtxt.getText().startsWith("5")){
        count++;
         amount+=80*count;
    }
}
    public void hideRows(){
        DefaultTableModel dm=(DefaultTableModel)videotabble.getModel();
int rowCount=dm.getRowCount();
for(int i=rowCount-1;i>=0;i--)
    dm.removeRow(i);
  }
          
       public ArrayList<User> thrillerList(){
      
ArrayList<User> thrillersList=new ArrayList<>();    

try{
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/upepeo"
        ,"root", "Jose19#*");

String sql="SELECT * FROM thriller";
Statement pstm=con.createStatement();

ResultSet rs=pstm.executeQuery(sql);

User user;
while(rs.next()){
    user=new User(rs.getInt("thriller_ID"), rs.getString("name"));
    thrillersList.add(user);
    
}

rs.close();
con.close();
    
}catch(ClassNotFoundException | SQLException ex){
    System.out.println("Wrong idVideo");
}// TODO add your handling code here:
return thrillersList;    
    }
       
       public void show_thriller(){
        
        System.out.println("Show data");
        
     ArrayList <User>list=thrillerList();
     DefaultTableModel model=(DefaultTableModel)videotabble.getModel();
     Object[] row=new Object[2];
     for(int i=0;i<list.size();i++){
         row[0]=list.get(i).getId();
         row[1]=list.get(i).getName();
         model.addRow(row);
        // System.out.println(Arrays.toString(row));
     }
       }
    
       public ArrayList<User> cartoonList(){
      
ArrayList<User> cartoonsList=new ArrayList<>();    

try{
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/upepeo"
        ,"root", "Jose19#*");

String sql="SELECT * FROM cartoon";
Statement pstm=con.createStatement();

ResultSet rs=pstm.executeQuery(sql);

User user;
while(rs.next()){
    user=new User(rs.getInt("cartoon_ID"), rs.getString("name"));
    cartoonsList.add(user);
    
}

rs.close();
con.close();
    
}catch(ClassNotFoundException | SQLException ex){
    System.out.println("Wrong idVideo");
}// TODO add your handling code here:
return cartoonsList;    
    }
       public void show_cartoon(){
        
        System.out.println("Show data");
        
     ArrayList <User>list=cartoonList();
     DefaultTableModel model=(DefaultTableModel)videotabble.getModel();
     Object[] row=new Object[2];
     for(int i=0;i<list.size();i++){
         row[0]=list.get(i).getId();
         row[1]=list.get(i).getName();
         model.addRow(row);
         //System.out.println(Arrays.toString(row));
     }
       }
      
       public ArrayList<User> horrorList(){
      ArrayList<User> usersList=new ArrayList<>();    

try{
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/upepeo"
        ,"root", "Jose19#*");

String sql="SELECT * FROM horror";
Statement pstm=con.createStatement();

ResultSet rs=pstm.executeQuery(sql);

User user;
while(rs.next()){
    user=new User(rs.getInt("horror_ID"), rs.getString("name"));
    usersList.add(user);
    
}

rs.close();
con.close();
    
}catch(ClassNotFoundException | SQLException ex){
    System.out.println("Wrong idVideo");
}// TODO add your handling code here:
return usersList;    
    }
       public void show_horror(){
        
        System.out.println("Show data");
        
     ArrayList <User>list=horrorList();
     DefaultTableModel model=(DefaultTableModel)videotabble.getModel();
     Object[] row=new Object[2];
     for(int i=0;i<list.size();i++){
         row[0]=list.get(i).getId();
         row[1]=list.get(i).getName();
         model.addRow(row);
        // System.out.println(Arrays.toString(row));
     }
     
       }
  
    
       public ArrayList<User> comedyList(){
      
ArrayList<User> comedysList=new ArrayList<>();    

try{
    
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/upepeo"
        ,"root", "Jose19#*");

String sql="SELECT * FROM comedy";
Statement pstm=con.createStatement();

ResultSet rs=pstm.executeQuery(sql);

User user;
while(rs.next()){
    user=new User(rs.getInt("Comedy_ID"), rs.getString("name"));
    comedysList.add(user);
    
}

rs.close();
con.close();
    
}catch(ClassNotFoundException | SQLException ex){
    System.out.println("Wrong idVideo");
}// TODO add your handling code here:
return comedysList;    
    }
       
       public void show_comedy(){
        
        System.out.println("Show data");
        
     ArrayList <User>list=comedyList();
     DefaultTableModel model=(DefaultTableModel)videotabble.getModel();
     Object[] row=new Object[2];
     for(int i=0;i<list.size();i++){
         row[0]=list.get(i).getId();
         row[1]=list.get(i).getName();
         model.addRow(row);
         System.out.println(Arrays.toString(row));
     }
       }
    
    public ArrayList<User> userList(){
      
ArrayList<User> usersList=new ArrayList<>();    

try{
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/upepeo"
        ,"root", "Jose19#*");

String sql="SELECT * FROM general";
Statement pstm=con.createStatement();

ResultSet rs=pstm.executeQuery(sql);

User user;
while(rs.next()){
    user=new User(rs.getInt("general_ID"), rs.getString("name"));
    usersList.add(user);
}

rs.close();
con.close();
    
}catch(ClassNotFoundException | SQLException ex){
    System.out.println("Wrong idVideo");
}// TODO add your handling code here:
return usersList;    

    }
    
    public void show_user(){
        
        System.out.println("Show data");
        
     ArrayList <User>list=userList();
     DefaultTableModel model=(DefaultTableModel)videotabble.getModel();
     Object[] row=new Object[2];
     for(int i=0;i<list.size();i++){
         row[0]=list.get(i).getId();
         row[1]=list.get(i).getName();
         model.addRow(row);
        // System.out.println(Arrays.toString(row));
     }
        
        
    }

    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu5 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        goodradio = new javax.swing.JRadioButton();
        badradio = new javax.swing.JRadioButton();
        spoiltradio = new javax.swing.JRadioButton();
        returningbutton = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        occupationcardtxt = new javax.swing.JTextPane();
        jScrollPane9 = new javax.swing.JScrollPane();
        firstnamecardtxt = new javax.swing.JTextPane();
        passwordcardtxt = new javax.swing.JPasswordField();
        jButton6 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        phonecardtxt = new javax.swing.JTextPane();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        lastnamecardtxt = new javax.swing.JTextPane();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        usernamecardtxt = new javax.swing.JTextPane();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        emailcardtxt = new javax.swing.JTextPane();
        jLabel20 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jPanel9 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        videotabble = new javax.swing.JTable();
        radiogeneral = new javax.swing.JRadioButton();
        radiohorror = new javax.swing.JRadioButton();
        radiothriller = new javax.swing.JRadioButton();
        radiocartoon = new javax.swing.JRadioButton();
        radiocomedy = new javax.swing.JRadioButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        movieidtxt = new javax.swing.JTextPane();
        borrowbutton = new javax.swing.JButton();
        addmoviebutton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        daystxt = new javax.swing.JTextPane();
        searchmoviebutton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        radiogood = new javax.swing.JRadioButton();
        radiobad = new javax.swing.JRadioButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        movienumbertxt = new javax.swing.JTextPane();
        jScrollPane7 = new javax.swing.JScrollPane();
        datetxt = new javax.swing.JTextPane();
        printreceiptbuttton = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        amountborrowtxt = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();

        jMenu5.setText("jMenu5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jTabbedPane1.setForeground(new java.awt.Color(0, 0, 255));
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tempus Sans ITC", 3, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 51, 51));
        jLabel10.setText("Thank you for returning our videos");

        jPanel11.setBackground(new java.awt.Color(204, 255, 204));

        jLabel9.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jLabel9.setText("Movie_Status");

        goodradio.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        goodradio.setText("Good");
        goodradio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goodradioActionPerformed(evt);
            }
        });

        badradio.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        badradio.setText("Demaged");
        badradio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                badradioActionPerformed(evt);
            }
        });

        spoiltradio.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        spoiltradio.setText("Lost");
        spoiltradio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spoiltradioActionPerformed(evt);
            }
        });

        returningbutton.setBackground(new java.awt.Color(0, 0, 255));
        returningbutton.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        returningbutton.setForeground(new java.awt.Color(255, 255, 255));
        returningbutton.setText("SUBMIT");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(returningbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(goodradio)
                                .addGap(68, 68, 68)
                                .addComponent(badradio)
                                .addGap(69, 69, 69)
                                .addComponent(spoiltradio)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel9)
                .addGap(39, 39, 39)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(goodradio)
                    .addComponent(badradio)
                    .addComponent(spoiltradio))
                .addGap(26, 26, 26)
                .addComponent(returningbutton)
                .addGap(33, 33, 33)
                .addComponent(jLabel11)
                .addContainerGap(292, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE))
                .addContainerGap(1180, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Return_Video", jPanel5);

        jPanel12.setBackground(new java.awt.Color(153, 255, 153));

        jLabel12.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLabel12.setText("Occupation");

        jScrollPane8.setViewportView(occupationcardtxt);

        jScrollPane9.setViewportView(firstnamecardtxt);

        jButton6.setBackground(new java.awt.Color(0, 0, 255));
        jButton6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton6.setText("PRINT");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLabel13.setText("FirstName");

        phonecardtxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                phonecardtxtMouseEntered(evt);
            }
        });
        jScrollPane10.setViewportView(phonecardtxt);

        jLabel14.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLabel14.setText("LastName");

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 255));
        jLabel15.setText("Upepeo Membership Card");

        jLabel16.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLabel16.setText("Password");

        jScrollPane11.setViewportView(lastnamecardtxt);

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel17.setText("UserName");

        jScrollPane12.setViewportView(usernamecardtxt);

        jLabel19.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLabel19.setText("Email");

        jScrollPane13.setViewportView(emailcardtxt);

        jLabel20.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLabel20.setText("Phone No");

        jLabel25.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel25.setText("Membership_ID");

        jScrollPane1.setViewportView(jTextPane1);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel13)
                                        .addComponent(jLabel17))
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20))
                                .addGap(31, 31, 31)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(passwordcardtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(57, 57, 57)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(457, Short.MAX_VALUE))
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel12Layout.createSequentialGroup()
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel12Layout.createSequentialGroup()
                            .addGap(76, 76, 76)
                            .addComponent(jLabel14))
                        .addGroup(jPanel12Layout.createSequentialGroup()
                            .addGap(140, 140, 140)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(580, Short.MAX_VALUE)))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel17)))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordcardtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(46, 46, 46)
                        .addComponent(jLabel20)))
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel12)))
                .addGap(30, 30, 30)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(79, 79, 79))
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel12Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(92, 92, 92)
                    .addComponent(jLabel14)
                    .addContainerGap(460, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(533, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("MembershipCard", jPanel6);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1722, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("", jPanel9);

        jPanel7.setBackground(new java.awt.Color(204, 255, 204));

        jLabel2.setFont(new java.awt.Font("Tempus Sans ITC", 0, 18)); // NOI18N
        jLabel2.setText("Choose your video category");

        videotabble.setBackground(new java.awt.Color(204, 255, 204));
        videotabble.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        videotabble.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Movie-Id", "Name"
            }
        ));
        videotabble.setMinimumSize(new java.awt.Dimension(30, 25));
        jScrollPane2.setViewportView(videotabble);

        radiogeneral.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        radiogeneral.setText("General");
        radiogeneral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiogeneralActionPerformed(evt);
            }
        });

        radiohorror.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        radiohorror.setText("Horror");
        radiohorror.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiohorrorActionPerformed(evt);
            }
        });

        radiothriller.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        radiothriller.setText("Thriller");
        radiothriller.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiothrillerActionPerformed(evt);
            }
        });

        radiocartoon.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        radiocartoon.setText("Cartoon");
        radiocartoon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiocartoonActionPerformed(evt);
            }
        });

        radiocomedy.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        radiocomedy.setText("Comedy");
        radiocomedy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiocomedyActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 51, 102));
        jLabel18.setText("Ksh.50");

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 51, 102));
        jLabel21.setText("Ksh.40");

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 51, 102));
        jLabel22.setText("Ksh.60");

        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 51, 102));
        jLabel23.setText("Ksh.80");

        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 102, 102));
        jLabel24.setText("Ksh.70");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(radiogeneral)
                                    .addComponent(jLabel18))
                                .addGap(49, 49, 49)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(radiohorror)
                                    .addComponent(jLabel21))
                                .addGap(61, 61, 61)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(radiothriller)
                                    .addComponent(jLabel22))
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGap(64, 64, 64)
                                        .addComponent(radiocartoon)
                                        .addGap(49, 49, 49))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel23)
                                        .addGap(58, 58, 58)))
                                .addComponent(radiocomedy))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(532, 532, 532)
                        .addComponent(jLabel24)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(23, 23, 23)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radiogeneral)
                    .addComponent(radiohorror)
                    .addComponent(radiothriller)
                    .addComponent(radiocartoon)
                    .addComponent(radiocomedy))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel23)
                        .addComponent(jLabel24))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18)
                        .addComponent(jLabel21)
                        .addComponent(jLabel22)))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(282, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(255, 204, 204));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel3.setText("Movie_ID");

        movieidtxt.setBackground(new java.awt.Color(204, 255, 255));
        jScrollPane3.setViewportView(movieidtxt);

        borrowbutton.setBackground(new java.awt.Color(0, 0, 255));
        borrowbutton.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        borrowbutton.setForeground(new java.awt.Color(255, 255, 255));
        borrowbutton.setText("SUBMIT");
        borrowbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrowbuttonActionPerformed(evt);
            }
        });

        addmoviebutton.setBackground(new java.awt.Color(0, 0, 255));
        addmoviebutton.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        addmoviebutton.setForeground(new java.awt.Color(255, 255, 255));
        addmoviebutton.setText("ADD");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Number of days you will stay wiith the movie");

        jScrollPane4.setViewportView(daystxt);

        searchmoviebutton.setBackground(new java.awt.Color(0, 0, 255));
        searchmoviebutton.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        searchmoviebutton.setForeground(new java.awt.Color(255, 255, 255));
        searchmoviebutton.setText("SEARCH ");
        searchmoviebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchmoviebuttonActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("Movie_Status");

        radiogood.setText("Good");

        radiobad.setText("Demaged");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(radiogood)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(borrowbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchmoviebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radiobad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(addmoviebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel3))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(addmoviebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(searchmoviebutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(radiogood)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addComponent(radiobad)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(13, 13, 13)))))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(borrowbutton)
                .addGap(22, 22, 22))
        );

        jPanel10.setBackground(new java.awt.Color(204, 255, 204));

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel5.setText("Number of Movies");

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel6.setText("Amount to pay");

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel8.setText("Date To be returned");

        jScrollPane5.setViewportView(movienumbertxt);

        jScrollPane7.setViewportView(datetxt);

        printreceiptbuttton.setBackground(new java.awt.Color(0, 0, 255));
        printreceiptbuttton.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        printreceiptbuttton.setForeground(new java.awt.Color(255, 255, 255));
        printreceiptbuttton.setText("PRINT_RECEIPT");
        printreceiptbuttton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printreceiptbutttonActionPerformed(evt);
            }
        });

        jScrollPane6.setViewportView(amountborrowtxt);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(46, 46, 46)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                    .addComponent(jScrollPane7)
                    .addComponent(printreceiptbuttton)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
                .addContainerGap(216, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel5))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel6))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(31, 31, 31)
                .addComponent(printreceiptbuttton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(244, 244, 244))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(462, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Borrow_Video", jPanel4);

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Light", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Upepeo video Hub");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(446, 446, 446)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(282, 282, 282))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(444, 444, 444)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void printreceiptbutttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printreceiptbutttonActionPerformed
        datetxt.setText(automaticdate());

        }
        public String automaticdate(){
            Date date=new Date();
            SimpleDateFormat form=new SimpleDateFormat("yyyy:MM:dd");
            String day=form.format(date);

            return day;// TODO add your handling code here:
    }//GEN-LAST:event_printreceiptbutttonActionPerformed

    private void searchmoviebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchmoviebuttonActionPerformed
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/upepeo"
                ,"root", "Jose19#*");

           // String sql="SELECT * FROM general,cartoon,comedy";
            String query="SELECT * FROM general,cartoon,thriller,comedy,horror WHERE cartoon_ID=?";
            PreparedStatement st=con.prepareStatement(query);
            st.setString(1,movieidtxt.getText());

            ResultSet rs=st.executeQuery();
            if(rs.next()){
                String name=rs.getString("name");
                // JOptionPane.CANCEL_OPTION(null,"Confirm that you want to cancel");
                JOptionPane.showMessageDialog(null, "movie_ID: "+movieidtxt.getText()+"\nname: "+name+"\nStatus: Available");

            }
            else{
                JOptionPane.showMessageDialog(null, "movie_ID: "+movieidtxt.getText()+"\nStatus: Not Available");

            }
        }catch(HeadlessException | ClassNotFoundException | SQLException ex){
            System.out.println("Error occured");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_searchmoviebuttonActionPerformed

    private void borrowbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrowbuttonActionPerformed
movienumbertxt.setText("1");
        calculatePayment();        // TODO add your handling code here:
    }//GEN-LAST:event_borrowbuttonActionPerformed

    private void radiocomedyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiocomedyActionPerformed

        hideRows();
        show_comedy();        // TODO add your handling code here:
    }//GEN-LAST:event_radiocomedyActionPerformed

    private void radiocartoonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiocartoonActionPerformed
        hideRows();
        show_cartoon();        // TODO add your handling code here:
    }//GEN-LAST:event_radiocartoonActionPerformed

    private void radiothrillerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiothrillerActionPerformed
        hideRows();
        show_thriller();        // TODO add your handling code here:
    }//GEN-LAST:event_radiothrillerActionPerformed

    private void radiohorrorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiohorrorActionPerformed
        hideRows();
        show_horror();        // TODO add your handling code here:
    }//GEN-LAST:event_radiohorrorActionPerformed

    private void radiogeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiogeneralActionPerformed
        //createConnection();
        hideRows();
        show_user();// TODO add your handling code here:
    }//GEN-LAST:event_radiogeneralActionPerformed

    private void phonecardtxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phonecardtxtMouseEntered
        phonecardtxt.setBackground(Color.yellow);        // TODO add your handling code here:
    }//GEN-LAST:event_phonecardtxtMouseEntered

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void goodradioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goodradioActionPerformed
JOptionPane.showMessageDialog(null," Thank you Come back again..."); 
// TODO add your handling code here:
    }//GEN-LAST:event_goodradioActionPerformed

    private void badradioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_badradioActionPerformed
      demandPayment();        // TODO add your handling code here:
    }//GEN-LAST:event_badradioActionPerformed

    private void spoiltradioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spoiltradioActionPerformed
demandPayment();        // TODO add your handling code here:
    }//GEN-LAST:event_spoiltradioActionPerformed

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
            java.util.logging.Logger.getLogger(upepeoHub.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(upepeoHub.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(upepeoHub.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(upepeoHub.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new upepeoHub().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addmoviebutton;
    private javax.swing.JTextPane amountborrowtxt;
    private javax.swing.JRadioButton badradio;
    private javax.swing.JButton borrowbutton;
    private javax.swing.JTextPane datetxt;
    private javax.swing.JTextPane daystxt;
    private javax.swing.JTextPane emailcardtxt;
    private javax.swing.JTextPane firstnamecardtxt;
    private javax.swing.JRadioButton goodradio;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane lastnamecardtxt;
    private javax.swing.JTextPane movieidtxt;
    private javax.swing.JTextPane movienumbertxt;
    private javax.swing.JTextPane occupationcardtxt;
    private javax.swing.JPasswordField passwordcardtxt;
    private javax.swing.JTextPane phonecardtxt;
    private javax.swing.JButton printreceiptbuttton;
    private javax.swing.JRadioButton radiobad;
    private javax.swing.JRadioButton radiocartoon;
    private javax.swing.JRadioButton radiocomedy;
    private javax.swing.JRadioButton radiogeneral;
    private javax.swing.JRadioButton radiogood;
    private javax.swing.JRadioButton radiohorror;
    private javax.swing.JRadioButton radiothriller;
    private javax.swing.JButton returningbutton;
    private javax.swing.JButton searchmoviebutton;
    private javax.swing.JRadioButton spoiltradio;
    private javax.swing.JTextPane usernamecardtxt;
    private javax.swing.JTable videotabble;
    // End of variables declaration//GEN-END:variables
}
