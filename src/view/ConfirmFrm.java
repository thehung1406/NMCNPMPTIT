package view;

import DAO.ReceivingDAO;
import model.CarReceived;
import model.Receiving;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class ConfirmFrm extends javax.swing.JFrame {

    private Receiving receiving;
    public ConfirmFrm(Receiving receiving) {
        this.receiving = receiving;
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        CusName = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel3.setText("jLabel3");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jLabel1.setText("Comfirm");
        jLabel2.setText("Customer");
        CusName.setText(receiving.getCustomer().getName());
        jLabel5.setText("Car");
        ArrayList<CarReceived> carReceiveds = receiving.getCarReceiveds();
        String[] numberPlates = new String[carReceiveds.size()];
        int cnt =0;
        for(CarReceived carReceived : carReceiveds){
            numberPlates[cnt]=carReceived.getCar().getNumberPlate();
            cnt++;
        }
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(numberPlates));
        setTable1(numberPlates[0]);
        setTable2(numberPlates[0]);
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Cancel");

        jButton2.setText("Confirm");

        jLabel6.setText("Service");

        jLabel7.setText("Technician");

        jLabel8.setText("Fix Slot");

        jLabel9.setText(receiving.getCarReceived(numberPlates[0]).getFixSlot().getNote());
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxActionPerformed(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(409, 409, 409)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(59, 59, 59)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
                                                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(41, 41, 41)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(CusName, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jScrollPane2)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jButton1)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jButton2)))))
                                .addContainerGap(142, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(CusName)
                                        .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel9))
                                .addGap(26, 26, 26)
                                .addComponent(jLabel7)
                                .addGap(21, 21, 21)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(jLabel6)
                                .addGap(28, 28, 28)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(42, 42, 42)
                                                .addComponent(jButton1))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(53, 53, 53)
                                                .addComponent(jButton2)))
                                .addContainerGap(88, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>
    public void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        //Xử lý khi click Cancel
        (new TechnicianManganerHomeFrm(receiving.getUser())).setVisible(true);
        this.dispose();
    }
    public void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // Xử lý khi click Confirm
        ReceivingDAO receivingDAO = new ReceivingDAO();
        receivingDAO.addReceiving(receiving);
        JOptionPane.showMessageDialog(null, "Success receiving .");
        (new TechnicianManganerHomeFrm(receiving.getUser())).setVisible(true);
        this.dispose();
    }
    public void comboBoxActionPerformed(java.awt.event.ActionEvent evt) {
        //Xử lú khi thay đổi item trong combo box
        String numberPlate = jComboBox1.getSelectedItem().toString();
        jLabel9.setText(receiving.getCarReceived(numberPlate).getFixSlot().getNote());
        setTable1(numberPlate);
        setTable2(numberPlate);
    }
    public void setTable1(String numberPlate) {
        String[] columnNames = {"ID", "Name", "Unit price", "Quantity"};
        int size = receiving.getCarReceived(numberPlate).getUsedServices().size();
        String[][] value = new String[size][5];
        for (int i = 0; i < size; i++) {
            value[i][0] = receiving.getCarReceived(numberPlate).getUsedServices().get(i).getId() + "";
            value[i][1] = receiving.getCarReceived(numberPlate).getUsedServices().get(i).getService().getName();
            value[i][2] = receiving.getCarReceived(numberPlate).getUsedServices().get(i).getService().getUnitPrice() + "";
            value[i][3] = receiving.getCarReceived(numberPlate).getUsedServices().get(i).getQuantity()+"";
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
    public void setTable2(String numberPlate) {
        String[] columnNames = {"ID","Name", "Note"};
        int size = receiving.getCarReceived(numberPlate).getServiceTechnicians().size();
        String[][] value = new String[size][4];
        for (int i = 0; i < size; i++) {
            value[i][0] = receiving.getCarReceived(numberPlate).getServiceTechnicians().get(i).getTechnician().getId() + "";
            value[i][1] = receiving.getCarReceived(numberPlate).getServiceTechnicians().get(i).getTechnician().getName();
            value[i][2] = receiving.getCarReceived(numberPlate).getServiceTechnicians().get(i).getTechnician().getNote();
        }
        DefaultTableModel tableModel = new DefaultTableModel(value, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //không thể thay đổi bảng
                return false;
            }
        };
        jTable2.setModel(tableModel);
    }
    // Variables declaration - do not modify
    private javax.swing.JLabel CusName;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration
}
