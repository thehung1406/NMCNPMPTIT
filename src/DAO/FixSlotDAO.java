package DAO;

import model.FixSlot;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class FixSlotDAO extends DAO{
    public FixSlotDAO() {super();}
    public ArrayList<FixSlot> searchFreeFixSlot(){
        ArrayList<FixSlot> result = new ArrayList<FixSlot>();
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatted = current.format(formatter);
        String sql = "SELECT * FROM FixSlot\n" +
                "WHERE ID NOT IN (\n" +
                "  SELECT cr.FixSlotID\n" +
                "  FROM tblCarReceived cr\n" +
                "  JOIN tblReceiving r ON cr.tblReceivingID = r.ID\n" +
                "  JOIN UsedService us ON us.tblCarReceivedID = cr.ID\n" +
                "  JOIN Service s ON us.ServiceID = s.ID\n" +
                "  GROUP BY cr.ID, r.ReceivingDate\n" +
                "  HAVING\n" +
                "    ? >= r.ReceivingDate\n" +
                "     AND ? < r.ReceivingDate + INTERVAL SUM(us.Quantity * TIME_TO_SEC(s.ServiceTime)) SECOND" +
                ");";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, formatted);
            ps.setString(2, formatted);
            ResultSet rs = ps.executeQuery();//Dùng cho các câu lệnh SELECT trả về đối tượng select trong SQL
            while(rs.next()){
                FixSlot fixSlot = new FixSlot();
                fixSlot.setId(rs.getInt("ID"));
                fixSlot.setNote(rs.getString("Note"));
                result.add(fixSlot);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

}
