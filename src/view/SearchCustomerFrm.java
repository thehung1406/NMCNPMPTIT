package view;

import DAO.CustomerDAO;
import model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class SearchCustomerFrm extends javax.swing.JFrame {
    private ArrayList<Customer> customers;
    private final User user;
    public SearchCustomerFrm(User user) {
        this.user = user;
        initComponents();
    }
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();//Name
        jTextField2 = new javax.swing.JTextField();//Address
        jTextField3 = new javax.swing.JTextField();//Tel
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();//Note
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jLabel1.setText("Search Customer");
        jLabel2.setText("Name");
        jLabel3.setText("Address");
        jLabel4.setText("Tel");
        jLabel5.setText("Note");
        jButton1.setText("Search by name");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        defaultTable();
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jButton2.setText("Add new Customer");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(432, 432, 432)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(453, 453, 453))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(27, 27, 27)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jButton2)
                                                        .addComponent(jButton1)
                                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 773, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(30, 30, 30)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jTextField4)
                                                                        .addComponent(jTextField3)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(0, 0, Short.MAX_VALUE)))))))
                                .addGap(174, 174, 174))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)
                                .addGap(27, 27, 27)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)
                                .addComponent(jButton2)
                                .addGap(141, 141, 141))
        );
        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // Hành động khi click vào nút Search
        if(jTextField1.getText() == null ||jTextField1.getText().equals("")){//Nếu trường tên rỗng
            defaultTable();
            JOptionPane.showMessageDialog(null, "Please enter a name for the customer");
        }
        else {
            CustomerDAO cdao = new CustomerDAO();
            customers = cdao.searchCustomer(jTextField1.getText().trim());//Lấy ra những khách có tên gần giống với tên điền ở JTextField1
            if(customers.isEmpty()){
                JOptionPane.showMessageDialog(null, "There are no customer with similar name.");
                defaultTable();
            }
            else {
                upDateTable(customers);
            }
        }
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // Hành động khi click vào nút Add new Customer
        if (jTextField3.getText().length() > 11) {
            JOptionPane.showMessageDialog(null, "Please enter a Tel has 10 numbers");
        } else {
            CustomerDAO cdao = new CustomerDAO();
            Customer customer = new Customer();
            customer.setName(jTextField1.getText());
            customer.setAddress(jTextField2.getText());
            customer.setTel(jTextField3.getText());
            customer.setNote(jTextField4.getText());
            if (customer.getName().equals("") || customer.getAddress().equals("") || customer.getTel().equals("")) {//Kiểm tra xem đã điền đủ các trường chưa
                JOptionPane.showMessageDialog(null, "Please fill in all fields");
            } else {
                cdao.addCustomer(customer);
                customers = cdao.searchCustomer(jTextField1.getText().trim());
                JOptionPane.showMessageDialog(null, "The customer has been added");
                upDateTable(customers);
            }

        }
    }
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {
        // Xử lý sự kiện khi click chuột trong bảng
            int selectedRow = jTable1.getSelectedRow();
            Receiving receiving = new Receiving();
            ArrayList<CarReceived> carReceiveds = new ArrayList<>();
            receiving.setUser(user);
            receiving.setCustomer(customers.get(selectedRow));// Láy ra khách hàng ở hàng đã click chuột
            receiving.setCarReceiveds(carReceiveds);
            // System.out.println(receiving.getCustomer().getName());
            (new SearchCarFrm(receiving)).setVisible(true);
            this.dispose();
    }
    public void defaultTable(){
        String[] columnNames = {"Id", "Name", "Address", "Tel", "Note"};
        String[][] value = new String[0][5];
        DefaultTableModel tableModel = new DefaultTableModel(value, columnNames);
        jTable1.setModel(tableModel);
    }
    public void upDateTable(ArrayList<Customer> customers){
        String[] columnNames = {"Id", "Name", "Address", "Tel", "Note"};
        String[][] value = new String[customers.size()][5];
        for (int i = 0; i < customers.size(); i++) {
            value[i][0] = customers.get(i).getId() + "";
            value[i][1] = customers.get(i).getName();
            value[i][2] = customers.get(i).getAddress();
            value[i][3] = customers.get(i).getTel() + "";
            value[i][4] = customers.get(i).getNote();
        }
        DefaultTableModel tableModel = new DefaultTableModel(value, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //không thể thay đổi bảng
                return false;
            }
        };
        jTable1.setModel(tableModel);
    }
    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration
}
