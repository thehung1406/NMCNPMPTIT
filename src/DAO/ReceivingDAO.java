package DAO;

import model.CarReceived;
import model.Receiving;
import model.ServicedTechnician;
import model.UsedService;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceivingDAO extends DAO{
    public ReceivingDAO(){super();}
    public void addReceiving(Receiving receiving) {
        String sqlAddReceiving = "INSERT INTO tblreceiving (tblCustomerID, tblUserID, ReceivingDate) VALUES(?, ?, ?)";
        String sqlAddCarReceived= "INSERT INTO tblcarreceived(tblReceivingID, tblCarID, FixSlotID)VALUES(?, ?, ?)";
        String sqlAddUsedService = "INSERT INTO usedservice (ServiceID ,tblCarReceivedID, Quantity, Price)VALUES(? ,?, ?,?)";
        String sqlAddServicedTechnician ="INSERT INTO servicedtechnician (TechnicianID,tblCarReceivedID)VALUES(?, ?)";
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = current.format(formatter);//Lấy ra ngày hôm nay đã được format theo định dạng
        try {
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement(sqlAddReceiving, Statement.RETURN_GENERATED_KEYS);//trả về ID khi thêm dữ liệu mới vào bảng
            ps.setInt(1, receiving.getCustomer().getId());
            ps.setInt(2, receiving.getUser().getId());
            ps.setString(3, formattedDate);
            ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {// Kiểm tra xem có ReceivingID nào không
                receiving.setId(generatedKeys.getInt(1));
                //insert received cars
                for (CarReceived carrReceived : receiving.getCarReceiveds()) {
                    ps = con.prepareStatement(sqlAddCarReceived, Statement.RETURN_GENERATED_KEYS);
                    ps.setInt(1, receiving.getId());
                    ps.setInt(2, carrReceived.getCar().getId());
                    ps.setInt(3, carrReceived.getFixSlot().getId());
                    ps.executeUpdate();
                    generatedKeys = ps.getGeneratedKeys();
                    if (generatedKeys.next()) {// Kiểm tra xem có ID của xe  mới được tiếp nhận nào không
                        carrReceived.setId(generatedKeys.getInt(1));
                        for (UsedService usedService : carrReceived.getUsedServices()) {
                            ps = con.prepareStatement(sqlAddUsedService, Statement.RETURN_GENERATED_KEYS);
                            ps.setInt(1, usedService.getService().getId());
                            ps.setInt(2, carrReceived.getId());
                            ps.setInt(3, usedService.getQuantity());
                            ps.setInt(4, usedService.getPrice());
                            ps.executeUpdate();
                        }
                        for(ServicedTechnician servicedTechnician : carrReceived.getServiceTechnicians()){
                            ps = con.prepareStatement(sqlAddServicedTechnician, Statement.RETURN_GENERATED_KEYS);
                            ps.setInt(1, servicedTechnician.getTechnician().getId());
                            ps.setInt(2, carrReceived.getId());
                            ps.executeUpdate();
                        }
                    }
                }
            }
            con.commit();
        }catch(Exception e) {
            try {
                con.rollback();//nếu lỗi thì roll back lại
            }catch(Exception ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            try {
                con.setAutoCommit(true);
            }catch(Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
