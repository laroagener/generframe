/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import config.Session;
import config.conf;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author PC 11
 */
public class transaction extends javax.swing.JFrame {

    /**
     * Creates new form transaction
     */
    public transaction() {
     if (Session.getInstance().getU_id() == 0) {
            JOptionPane.showMessageDialog(null, "Please login first!");
            laroa.login log = new laroa.login();
            log.setVisible(true);
            this.dispose();
            return;    
        
    }
    initComponents();
    loadTransactionsTable();
    } 
    private void loadTransactionsTable() {
        DefaultTableModel model = (DefaultTableModel) transactiontbl.getModel();
        model.setRowCount(0);
        model.setColumnIdentifiers(new String[]{"Trans ID", "Customer", "Total Amount", "Date", "Payment Method", "Cashier"});

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conf dbConfig = new conf();
            conn = dbConfig.connectDB();
            String sql = "SELECT t.transaction_id, t.customer_name, t.total_amount, t.transaction_date, " +
                        "t.payment_method, u.username as cashier " +
                        "FROM tbl_transactions t JOIN tbl_users u ON t.u_id = u.u_id " +
                        "ORDER BY t.transaction_date DESC";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Object[] row = {
                    rs.getInt("transaction_id"),
                    rs.getString("customer_name"),
                    String.format("%.2f", rs.getDouble("total_amount")),
                    rs.getString("transaction_date"),
                    rs.getString("payment_method"),
                    rs.getString("cashier")
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading transactions: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        searchbtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        editbtd = new javax.swing.JButton();
        addbtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        transactiontbl = new javax.swing.JTable();
        deletebtn = new javax.swing.JButton();
        search = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jDesktopPane1.setBackground(new java.awt.Color(153, 153, 153));
        jDesktopPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jDesktopPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchbtn.setText("Search");
        searchbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbtnActionPerformed(evt);
            }
        });
        jDesktopPane1.add(searchbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 70, 90, 30));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("TRANSACTION");
        jDesktopPane1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, -1, -1));

        jButton8.setText("Home");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jDesktopPane1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 90, 30));

        editbtd.setText("Edit");
        editbtd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editbtdActionPerformed(evt);
            }
        });
        jDesktopPane1.add(editbtd, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 90, 30));

        addbtn.setText("Add");
        addbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbtnActionPerformed(evt);
            }
        });
        jDesktopPane1.add(addbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 90, 30));

        transactiontbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(transactiontbl);

        jDesktopPane1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 790, -1));

        deletebtn.setText("Delete");
        deletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebtnActionPerformed(evt);
            }
        });
        jDesktopPane1.add(deletebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, 90, 30));

        search.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        search.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        search.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        search.setOpaque(false);
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        jDesktopPane1.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 70, 140, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1050, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1050, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbtnActionPerformed
String keyword = search.getText().trim();
        if (keyword.isEmpty()) {
          loadTransactionsTable();
            return;
        }

        DefaultTableModel model = (DefaultTableModel) transactiontbl.getModel();
        model.setRowCount(0);

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conf dbConfig = new conf();
            conn = dbConfig.connectDB();
            String sql = "SELECT t.transaction_id, t.customer_name, t.total_amount, t.transaction_date, " +
                        "t.payment_method, u.username as cashier " +
                        "FROM tbl_transactions t JOIN tbl_users u ON t.u_id = u.u_id " +
                        "WHERE t.customer_name LIKE ? OR t.transaction_id LIKE ? " +
                        "ORDER BY t.transaction_date DESC";
            pstmt = conn.prepareStatement(sql);
            String pattern = "%" + keyword + "%";
            pstmt.setString(1, pattern);
            pstmt.setString(2, pattern);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Object[] row = {
                    rs.getInt("transaction_id"),
                    rs.getString("customer_name"),
                    String.format("%.2f", rs.getDouble("total_amount")),
                    rs.getString("transaction_date"),
                    rs.getString("payment_method"),
                    rs.getString("cashier")
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Search error: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_searchbtnActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
                user.usertbl table = new user.usertbl();
                table.setVisible(true);
                this.dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void editbtdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editbtdActionPerformed
        int selectedRow = transactiontbl.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a transaction to view");
            return;
        }

        int transId = (int) transactiontbl.getValueAt(selectedRow, 0);
        viewTransactionDetails(transId);
    }                                       

    // ✅ FIXED: Added missing viewTransactionDetails method
    private void viewTransactionDetails(int transId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conf dbConfig = new conf();
            conn = dbConfig.connectDB();
            
            String sql = "SELECT t.*, ti.book_title, ti.quantity, ti.price, ti.subtotal, u.username " +
                        "FROM tbl_transactions t " +
                        "JOIN tbl_transaction_items ti ON t.transaction_id = ti.transaction_id " +
                        "JOIN tbl_users u ON t.u_id = u.u_id " +
                        "WHERE t.transaction_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, transId);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                StringBuilder details = new StringBuilder();
                details.append("Transaction ID: ").append(transId).append("\n");
                details.append("Customer: ").append(rs.getString("customer_name")).append("\n");
                details.append("Date: ").append(rs.getString("transaction_date")).append("\n");
                details.append("Cashier: ").append(rs.getString("username")).append("\n");
                details.append("Payment: ").append(rs.getString("payment_method")).append("\n\n");
                details.append("Items:\n");
                details.append("----------------------------------------\n");
                
                do {
                    details.append(rs.getString("book_title")).append(" x ")
                           .append(rs.getInt("quantity")).append(" = ")
                           .append(String.format("%.2f", rs.getDouble("subtotal"))).append("\n");
                } while (rs.next());
                
                details.append("----------------------------------------\n");
                details.append("Total: ").append(String.format("%.2f", rs.getDouble("total_amount")));

                JOptionPane.showMessageDialog(this, details.toString(), "Transaction Details", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }//GEN-LAST:event_editbtdActionPerformed

    private void addbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbtnActionPerformed
        createNewTransaction();
    }

    private void createNewTransaction() {
        String customerName = JOptionPane.showInputDialog(this, 
            "Enter Customer Name:", "New Transaction - Step 1/5", JOptionPane.QUESTION_MESSAGE);
        
        if (customerName == null || customerName.trim().isEmpty()) return;

        String bookTitle = JOptionPane.showInputDialog(this, 
            "Enter Book Title:", "New Transaction - Step 2/5", JOptionPane.QUESTION_MESSAGE);
        
        if (bookTitle == null || bookTitle.trim().isEmpty()) return;

        String qtyStr = JOptionPane.showInputDialog(this, 
            "Enter Quantity:", "New Transaction - Step 3/5", JOptionPane.QUESTION_MESSAGE);
        
        if (qtyStr == null) return;
        
        int quantity;
        try {
            quantity = Integer.parseInt(qtyStr.trim());
            if (quantity <= 0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid quantity!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String priceStr = JOptionPane.showInputDialog(this, 
            "Enter Price per Book:", "New Transaction - Step 4/5", JOptionPane.QUESTION_MESSAGE);
        
        if (priceStr == null) return;
        
        double price;
        try {
            price = Double.parseDouble(priceStr.trim());
            if (price <= 0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid price!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String[] paymentOptions = {"Cash", "Credit Card", "Debit Card", "Online Payment"};
        String paymentMethod = (String) JOptionPane.showInputDialog(this, 
            "Select Payment Method:", "New Transaction - Step 5/5", 
            JOptionPane.QUESTION_MESSAGE, null, paymentOptions, paymentOptions[0]);
        
        if (paymentMethod == null) return;

        double totalAmount = quantity * price;

        int confirm = JOptionPane.showConfirmDialog(this,
            "Transaction Summary:\n\n" +
            "Customer: " + customerName + "\n" +
            "Book: " + bookTitle + "\n" +
            "Quantity: " + quantity + "\n" +
            "Price: " + String.format("%.2f", price) + "\n" +
            "Total: " + String.format("%.2f", totalAmount) + "\n" +
            "Payment: " + paymentMethod + "\n\n" +
            "Confirm transaction?",
            "Confirm Transaction", JOptionPane.YES_NO_OPTION);

        if (confirm != JOptionPane.YES_OPTION) return;

        if (saveTransaction(customerName, bookTitle, quantity, price, totalAmount, paymentMethod)) {
            JOptionPane.showMessageDialog(this, "Transaction completed successfully!", 
                "Success", JOptionPane.INFORMATION_MESSAGE);
            loadTransactionsTable();
            showReceipt(customerName, bookTitle, quantity, price, totalAmount, paymentMethod);
        } else {
            JOptionPane.showMessageDialog(this, "Transaction failed!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean saveTransaction(String customerName, String bookTitle, int quantity, 
            double price, double totalAmount, String paymentMethod) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conf dbConfig = new conf();
            conn = dbConfig.connectDB();
            conn.setAutoCommit(false);

            String sqlTrans = "INSERT INTO tbl_transactions (u_id, customer_name, total_amount, payment_method) VALUES (?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sqlTrans, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, Session.getInstance().getU_id());
            pstmt.setString(2, customerName);
            pstmt.setDouble(3, totalAmount);
            pstmt.setString(4, paymentMethod);
            pstmt.executeUpdate();

            rs = pstmt.getGeneratedKeys();
            int transId = 0;
            if (rs.next()) {
                transId = rs.getInt(1);
            }

            String sqlItem = "INSERT INTO tbl_transaction_items (transaction_id, book_title, quantity, price, subtotal) VALUES (?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sqlItem);
            pstmt.setInt(1, transId);
            pstmt.setString(2, bookTitle);
            pstmt.setInt(3, quantity);
            pstmt.setDouble(4, price);
            pstmt.setDouble(5, totalAmount);
            pstmt.executeUpdate();

            conn.commit();
            return true;

        } catch (Exception e) {
            try {
                if (conn != null) conn.rollback();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) {
                    conn.setAutoCommit(true);
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void showReceipt(String customerName, String bookTitle, int quantity, 
            double price, double totalAmount, String paymentMethod) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(new Date());
        
        StringBuilder receipt = new StringBuilder();
        receipt.append("========================================\n");
        receipt.append("        NOVEL'S BOOK SHOP\n");
        receipt.append("           SALES RECEIPT\n");
        receipt.append("========================================\n");
        receipt.append("Date: ").append(date).append("\n");
        receipt.append("Customer: ").append(customerName).append("\n");
        receipt.append("Cashier: ").append(Session.getInstance().getUsername()).append("\n");
        receipt.append("----------------------------------------\n");
        receipt.append(String.format("%-20s %3s %10s\n", "Item", "Qty", "Amount"));
        receipt.append("----------------------------------------\n");
        
        String shortTitle = bookTitle.length() > 20 ? bookTitle.substring(0, 17) + "..." : bookTitle;
        receipt.append(String.format("%-20s %3d %10.2f\n", shortTitle, quantity, totalAmount));
        
        receipt.append("----------------------------------------\n");
        receipt.append(String.format("%-24s %10.2f\n", "TOTAL:", totalAmount));
        receipt.append(String.format("%-24s %10s\n", "Payment:", paymentMethod));
        receipt.append("========================================\n");
        receipt.append("     Thank you for your purchase!\n");
        receipt.append("========================================\n");

        javax.swing.JTextArea textArea = new javax.swing.JTextArea(receipt.toString());
        textArea.setFont(new java.awt.Font("Monospaced", java.awt.Font.PLAIN, 12));
        textArea.setEditable(false);
        javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane(textArea);
        scrollPane.setPreferredSize(new java.awt.Dimension(400, 400));
        
        JOptionPane.showMessageDialog(this, scrollPane, "Receipt", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_addbtnActionPerformed

    private void deletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtnActionPerformed
         int selectedRow = transactiontbl.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a transaction to delete");
            return;
        }

        int transId = (int) transactiontbl.getValueAt(selectedRow, 0);
        String customer = (String) transactiontbl.getValueAt(selectedRow, 1);

        int confirm = JOptionPane.showConfirmDialog(this,
            "Delete transaction for " + customer + "?\n(Transaction ID: " + transId + ")",
            "Confirm Delete", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            deleteTransaction(transId);
        
            loadTransactionsTable();
        }
    }

    private void deleteTransaction(int transId) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conf dbConfig = new conf();
            conn = dbConfig.connectDB();
            
            // Delete items first (foreign key constraint)
            String sqlItems = "DELETE FROM tbl_transaction_items WHERE transaction_id = ?";
            pstmt = conn.prepareStatement(sqlItems);
            pstmt.setInt(1, transId);
            pstmt.executeUpdate();
            
            // Delete transaction
            String sqlTrans = "DELETE FROM tbl_transactions WHERE transaction_id = ?";
            pstmt = conn.prepareStatement(sqlTrans);
            pstmt.setInt(1, transId);
            
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "Transaction deleted successfully");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error deleting transaction: " + e.getMessage());
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }//GEN-LAST:event_deletebtnActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        searchbtnActionPerformed(evt);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new transaction().setVisible(true);
            }
        });
    }//GEN-LAST:event_searchActionPerformed

    /**
     * @param args the command line arguments
     */
    {
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addbtn;
    private javax.swing.JButton deletebtn;
    private javax.swing.JButton editbtd;
    private javax.swing.JButton jButton8;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField search;
    private javax.swing.JButton searchbtn;
    private javax.swing.JTable transactiontbl;
    // End of variables declaration//GEN-END:variables
}
