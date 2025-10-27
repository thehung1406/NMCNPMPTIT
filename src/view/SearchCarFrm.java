package  view;

import DAO.CarDAO;
import model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class SearchCarFrm extends JFrame {
    ArrayList<Car> cars;
    private final Receiving receiving;
    public SearchCarFrm(Receiving receiving) {
        this.receiving = receiving;
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jLabel1.setText("Search Car");
        carTable();
        jScrollPane1.setViewportView(jTable1);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jButton1.setText("Add new car");
        jButton2.setText("Next");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton2.setText("Next");
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
                                .addGap(66, 66, 66)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButton1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton2))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(70, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(357, 357, 357))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel1)
                                .addGap(31, 31, 31)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2))
                                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // Xử lý khi ấn vào Add New Car
        new AddNewCarFrm(receiving).setVisible(true);
        this.dispose();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // Xử lý khi ấn nút next
        (new SearchServiceFrm(receiving)).setVisible(true);
        this.dispose();
    }
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {
        // Xử lý sự kiện khi click chuột trong bảng
            int selectedRow = jTable1.getSelectedRow();
            ArrayList<UsedService> usedServices = new ArrayList<UsedService>();
            ArrayList<ServicedTechnician> servicedTechnicians = new ArrayList<ServicedTechnician>();
            CarReceived carReceived = new CarReceived();
            carReceived.setCar(cars.get(selectedRow));
            carReceived.setNote("");
            carReceived.setUsedServices(usedServices);
            carReceived.setServiceTechnicians(servicedTechnicians);
            if(checkCarReceived(carReceived)) JOptionPane.showMessageDialog(null, "You have added this car before");//Dùng để ngắn không cho 1 xe được thêm 2 lần
            else {
                receiving.getCarReceiveds().add(carReceived);
                JOptionPane.showMessageDialog(null, "Car is added to Receiving");
            }
            /*
            for(CarReceived car : carReceiveds){
                System.out.println(car.getCar().getNumberPlate());
            }
             */
    }
    public void carTable(){
        CarDAO dao = new CarDAO();
        cars = dao.searchCar(receiving.getCustomer().getId()+"");
        String[] columnNames = {"Id", "NumberPlate", "Model", "Make", "Description"};
        String[][] value = new String[cars.size()][5];
        for (int i = 0; i < cars.size(); i++) {
            value[i][0] = cars.get(i).getId() + "";
            value[i][1] = cars.get(i).getNumberPlate();
            value[i][2] = cars.get(i).getModel();
            value[i][3] = cars.get(i).getMake();
            value[i][4] = cars.get(i).getDescription();
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
    public boolean checkCarReceived(CarReceived carReceived){
        for(CarReceived x : receiving.getCarReceiveds()){
            if(x.getCar().getNumberPlate().equals(carReceived.getCar().getNumberPlate())){
                return true;
            }
        }
        return false;
    }
    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration
}
