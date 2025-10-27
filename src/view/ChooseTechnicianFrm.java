package view;


import DAO.TechnicianDAO;
import model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class ChooseTechnicianFrm extends javax.swing.JFrame {
    private Receiving receiving;
    TechnicianDAO dao = new TechnicianDAO();
    ArrayList<Technician> technicians=dao.searchFreeTechnician();
    public ChooseTechnicianFrm(Receiving  receiving ) {
        this.receiving = receiving;
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Choose Technician");

        jLabel2.setText("Choose car");
        ArrayList<CarReceived> carReceiveds = receiving.getCarReceiveds();
        String[] numberPlates = new String[carReceiveds.size()];
        int cnt =0;
        for(CarReceived carReceived : carReceiveds){
            numberPlates[cnt]=carReceived.getCar().getNumberPlate();
            cnt++;
        }
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(numberPlates));
        TechnicianTable();
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Next");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(46, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(200, 200, 200))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(44, 44, 44)
                                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(75, 75, 75)))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(jButton1)
                                .addContainerGap(66, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // Xử lý khi ấn nút Next
        if (!checkChooseTechnician()) JOptionPane.showMessageDialog(null, "Please select Technician for all car received");
        else {
            (new ConfirmFrm(receiving)).setVisible(true);
            this.dispose();
        }
    }
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {
        // Xử lý sự kiện khi click chuột trong bảng
        int selectedRow = jTable1.getSelectedRow();
        String numberPlate = jComboBox1.getSelectedItem().toString();
        Technician technician= technicians.get(selectedRow);
        CarReceived carReceived = receiving.getCarReceived(numberPlate);
        ServicedTechnician servicedTechnician = new ServicedTechnician();
        servicedTechnician.setTechnician(technician);
        carReceived.getServiceTechnicians().add(servicedTechnician);
        JOptionPane.showMessageDialog(null, "You have added  "+ technician.getName() + " for "+ numberPlate);
        technicians.remove(technician);
        TechnicianTable();
        }

    public void TechnicianTable(){
        String[] columnNames = {"ID","Name", "Note"};
        if(technicians.size()==0) JOptionPane.showMessageDialog(null, "There are no free technician");
        String[][] value = new String[technicians.size()][4];
        for (int i = 0; i < technicians.size(); i++) {
            value[i][0] = technicians.get(i).getId() + "";
            value[i][1] = technicians.get(i).getName();
            value[i][2] = technicians.get(i).getNote();
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
    public boolean checkChooseTechnician(){
        for(CarReceived carReceived : receiving.getCarReceiveds()){
            if(carReceived.getServiceTechnicians().size()==0)
                return false;
        }
        return true;
    }
    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration
}

