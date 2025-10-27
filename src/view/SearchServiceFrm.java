package view;

import DAO.ServiceDAO;
import model.CarReceived;
import model.Receiving;
import model.Service;
import model.UsedService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class SearchServiceFrm extends javax.swing.JFrame {
   private Receiving receiving;
   private ArrayList<Service> services;
   public SearchServiceFrm(Receiving receiving) {
        this.receiving = receiving;
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();//trường điền tên service
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();//Trường điền số lượng
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        ArrayList<CarReceived> carReceiveds = receiving.getCarReceiveds();
        String[] numberPlates = new String[carReceiveds.size()];
        int cnt =0;
        for(CarReceived carReceived : carReceiveds){
            numberPlates[cnt]=carReceived.getCar().getNumberPlate();
            cnt++;
        }
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(numberPlates));
        jLabel1.setText("Search Service");
        jLabel2.setText("Choose car");
        jLabel3.setText("Service");
        defaultTable();
        jScrollPane1.setViewportView(jTable1);
        jButton1.setText("Next");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jLabel4.setText("Quantity");
        jButton3.setText("Search");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jButton2.setText("Add to Receiving");
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
                                .addGap(73, 73, 73)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(46, 46, 46)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(89, 89, 89)
                                                                                .addComponent(jButton3))
                                                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addContainerGap(472, Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jButton2)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jButton1))
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 798, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(410, 410, 410)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel1)
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton3))
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2))
                                .addGap(63, 63, 63))
        );
        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        // Hành động khi click vào nút Search
        if(jTextField1.getText() == null ||jTextField1.getText().equals("")){//Nếu trường tên service rỗng
            defaultTable();
            JOptionPane.showMessageDialog(null, "Please enter a name for the service");
        }
        else {
            ServiceDAO sdao = new ServiceDAO();
            services= sdao.searchService(jTextField1.getText().trim());//Lấy ra những service có tên gần giống với tên điền ở trường name
            if(services.size()==0){
                JOptionPane.showMessageDialog(null, "There are no service with similar name.");
                defaultTable();
            }
            else {
                String[] columnNames = {"ID", "Name", "Unit price","Service Time"};
                String[][] value = new String[services.size()][5];
                for (int i = 0; i < services.size(); i++) {
                    value[i][0] = services.get(i).getId() + "";
                    value[i][1] = services.get(i).getName();
                    value[i][2] = services.get(i).getUnitPrice()+"";
                    value[i][3]=services.get(i).getServiceTime()+"";
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
        }
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // Xử lý hành động khi click "Next"
        (new ChooseFixSlotFrm(receiving)).setVisible(true);
        this.dispose();
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // Xử lý hành động khi click "Add to receiving"
        int selectedRow = jTable1.getSelectedRow();//Lấy ra chỉ số của dòng được chọn
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null, "Please choose the service");
        }
        else {
            Service service = services.get(selectedRow);// Service được chọn
            String numberPlate = jComboBox1.getSelectedItem().toString(); // Lấy ra  Number Plate của xe được chọn trong combo box
            //System.out.println(numberPlate);
            CarReceived carReceived = receiving.getCarReceived(numberPlate);
            //System.out.println(services.get(selectedRow).getName());
                if(jTextField2.getText().trim().equals("")){
                    JOptionPane.showMessageDialog(null, "Please fill the quantity for the service");
                }
                else {
                    try {
                        int quantity = Integer.parseInt(jTextField2.getText());
                        if (checkService(service, carReceived.getUsedServices())) {//Kiểm tra xem service này đã được thêm hay chưa
                            int quantityBefore = carReceived.getUsedService(service).getQuantity();
                            carReceived.getUsedService(service).setQuantity(quantity + quantityBefore);
                            int quantityAfter = carReceived.getUsedService(service).getQuantity();
                            String mess = "You have add " + quantityAfter + " " + service.getName() + " + to " + numberPlate;
                            JOptionPane.showMessageDialog(null, mess);
                            //System.out.println(numberPlate+" "+service.getName()+" "+quantityAfter+" "+ quantityBefore);
                        } else {//TH service này chưa được thêm
                            UsedService usedService1 = new UsedService();
                            usedService1.setQuantity(quantity);
                            usedService1.setService(service);
                            usedService1.setPrice(service.getUnitPrice());
                            carReceived.getUsedServices().add(usedService1);
                            String mess = "You have add " + quantity + " " + service.getName() + " + to " + numberPlate;
                            JOptionPane.showMessageDialog(null, mess);
                            //System.out.println(numberPlate+" "+service.getName()+" "+quantity);
                        }
                    }
                    catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Please fill the quantity for the service is a number");
                    }
            }
        }
    }
    public boolean checkService(Service service,ArrayList<UsedService> usedServices){
       for(UsedService usedService:usedServices){
           if(service.getName().equals(usedService.getService().getName())){
               return true;
           }
        }
        return false;
    }
    public void defaultTable(){
        String[] columnNames = {"ID", "Name", "Unit price","Service Time"};
        String[][] value = new String[0][4];
        DefaultTableModel tableModel = new DefaultTableModel(value, columnNames);
        jTable1.setModel(tableModel);
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration
}
