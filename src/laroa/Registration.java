package laroa; // Ensure this matches your package
import config.conf;
import javax.swing.JOptionPane;

public class Registration extends javax.swing.JFrame {

    public Registration() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        user = new javax.swing.JTextField();
        pass = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("User Registration");

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setLayout(null);

        jDesktopPane1.setBackground(new java.awt.Color(153, 153, 153));
        jDesktopPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jDesktopPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jDesktopPane1.add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 110, 190, 40));
        jDesktopPane1.add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 230, 190, 40));

        jButton1.setBackground(new java.awt.Color(0, 51, 255));
        jButton1.setFont(new java.awt.Font("Century Gothic", 1, 14)); 
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Sign Up");
        // LINKING THE ACTION LISTENER
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jDesktopPane1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 290, 190, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/laroa/images/Grey Minimalist Bookstore Business Logo.png"))); 
        jDesktopPane1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 500, 500));

        jDesktopPane1.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 170, 190, 40));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 18)); 
        jLabel2.setText("User Name");
        jDesktopPane1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 90, 100, 20));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 18)); 
        jLabel3.setText("Email");
        jDesktopPane1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 150, -1, 20));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 18)); 
        jLabel5.setText("Password");
        jDesktopPane1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 210, -1, -1));

        jPanel1.add(jDesktopPane1);
        jDesktopPane1.setBounds(0, 0, 1050, 600);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1047, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
     conf conf = new conf();

    String sql = "INSERT INTO tbl_users(username, email, password, type, status) VALUES (?, ?, ?, ?, ?)";
    String password = new String(pass.getPassword());

    if (user.getText().isEmpty() || email.getText().isEmpty() || password.isEmpty()) {
        JOptionPane.showMessageDialog(this, "All fields are required!");
        return;
    }

    conf.addRecord(sql, user.getText(),email.getText(),password,"admin", "Pending");
        

    JOptionPane.showMessageDialog(this, "Registration successful!");

    // NAVIGATION
    login login = new login();
    login.setVisible(true);
    this.dispose();
    }
    
    
                            

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Registration().setVisible(true);
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JTextField email;
    private javax.swing.JButton jButton1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField pass;
    private javax.swing.JTextField user;
    // End of variables declaration                   
}