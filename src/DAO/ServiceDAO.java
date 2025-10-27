package DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Service;

public class ServiceDAO  extends DAO{
    public ServiceDAO(){super();}
    public ArrayList<Service> searchService(String key){
        ArrayList<Service> result = new ArrayList<Service>();
        String sql = "SELECT * FROM service WHERE Name LIKE ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + key + "%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Service service = new Service();
                service.setId(rs.getInt("id"));
                service.setName(rs.getString("name"));
                service.setUnitPrice(rs.getInt("unitPrice"));
                service.setServiceTime(rs.getTime("ServiceTime"));
                result.add(service);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
