package view;

import DAO.FixSlotDAO;
import model.CarReceived;
import model.FixSlot;
import model.Receiving;
import model.UsedService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class ChooseFixSlotFrm extends javax.swing.JFrame {
    private Receiving receiving;
    FixSlotDAO fixSlotDAO = new FixSlotDAO();
    ArrayList<FixSlot> fixSlots = fixSlotDAO.searchFreeFixSlot();
    public ChooseFixSlotFrm(Receiving receiving) {
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
        jLabel1.setText("Choose fix slot");
        jLabel2.setText("Choose car");
        ArrayList<CarReceived> carReceiveds = receiving.getCarReceiveds();
        String[] numberPlates = new String[carReceiveds.size()];
        int cnt =0;
        for(CarReceived carReceived : carReceiveds){
            numberPlates[cnt]=carReceived.getCar().getNumberPlate();
            cnt++;
        }
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(numberPlates));
        FixSlotTable();
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
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(233, 233, 233)
                                                .addComponent(jLabel1))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(54, 54, 54)
                                                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jButton1)
                                .addContainerGap(112, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // Xử lý khi ấn nút Next
        if (!checkChooseFixSlot()) JOptionPane.showMessageDialog(null, "Please select fix slot for all car received");
        else {
            (new ChooseTechnicianFrm(receiving)).setVisible(true);
            this.dispose();
        }
    }
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {
            // Xử lý sự kiện khi click chuột trong bảng
            int selectedRow = jTable1.getSelectedRow();
            String numberPlate = jComboBox1.getSelectedItem().toString();
            FixSlot fixSlot = fixSlots.get(selectedRow);
            CarReceived carReceived = receiving.getCarReceived(numberPlate);
            if(carReceived.getFixSlot() != null) JOptionPane.showMessageDialog(null, "You have added a fix slot for this car before");//Dùng để ngắn không cho 1 xe được thêm 2 lần
            else {
                carReceived.setFixSlot(fixSlot);
                fixSlots.remove(selectedRow);
                FixSlotTable();
                JOptionPane.showMessageDialog(null, fixSlot.getNote()+" is added to "+numberPlate);
            }
    }
    public void FixSlotTable(){
        String[] columnNames = {"ID", "Note"};
        if(fixSlots.size()==0) JOptionPane.showMessageDialog(null, "There are no free fix slot");
        String[][] value = new String[fixSlots.size()][3];
        for (int i = 0; i < fixSlots.size(); i++) {
            value[i][0] = fixSlots.get(i).getId() + "";
            value[i][1] = fixSlots.get(i).getNote();
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
    public boolean checkChooseFixSlot(){
        for(CarReceived carReceived : receiving.getCarReceiveds()){
            if(carReceived.getFixSlot() == null){
                return false;
            }
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
