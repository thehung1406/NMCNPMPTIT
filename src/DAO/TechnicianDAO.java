package DAO;

import model.Technician;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class TechnicianDAO extends DAO {
    public TechnicianDAO() {super();}
    public ArrayList<Technician> searchFreeTechnician() {
        ArrayList<Technician> result = new ArrayList<Technician>();
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatted = current.format(formatter);
        String sql = "SELECT *\n" +
                "FROM Technician t\n" +
                "WHERE t.ID NOT IN (\n" +
                "    SELECT st.TechnicianID\n" +
                "    FROM ServicedTechnician st\n" +
                "    JOIN tblCarReceived cr ON st.tblCarReceivedID = cr.ID\n" +
                "    JOIN tblReceiving r ON cr.tblReceivingID = r.ID\n" +
                "    JOIN UsedService us ON us.tblCarReceivedID = cr.ID\n" +
                "    JOIN Service s ON us.ServiceID = s.ID\n" +
                "    GROUP BY st.TechnicianID, cr.ID, r.ReceivingDate\n" +
                "    HAVING\n" +
                "        ? >= r.ReceivingDate\n" +
                "        AND ? <  r.ReceivingDate + INTERVAL SUM(us.Quantity * TIME_TO_SEC(s.ServiceTime)) SECOND\n" +
                ");\n";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, formatted);
            ps.setString(2, formatted);
            ResultSet rs = ps.executeQuery();//Dùng cho các câu lệnh SELECT trả về đối tượng select trong SQL
            while(rs.next()){
               Technician technician = new Technician();
               technician.setId(rs.getInt("ID"));
               technician.setName(rs.getString("Name"));
               technician.setNote(rs.getString("Note"));
               result.add(technician);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
