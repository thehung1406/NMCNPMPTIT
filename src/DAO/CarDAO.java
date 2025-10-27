package DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.Car;

public class CarDAO  extends DAO{
    public CarDAO(){super();}
    public ArrayList<Car> searchCar(String key){
        ArrayList<Car> results = new ArrayList<Car>();
        String sql = "select * from tblcar where tblCustomerID = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,key);
            ResultSet rs = ps.executeQuery();//Dùng cho các câu lệnh SELECT trả về đối tượng select trong SQL
            while(rs.next()){
                Car car = new Car();
                car.setId(rs.getInt("id"));
                car.setNumberPlate(rs.getString("numberPlate"));
                car.setModel(rs.getString("model"));
                car.setMake(rs.getString("make"));
                car.setDescription(rs.getString("description"));
                results.add(car);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return results;
    }
    public ArrayList<Car> getAllCar(){
        ArrayList<Car> results = new ArrayList<Car>();
        String sql = "select * from tblcar ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Car car = new Car();
                car.setId(rs.getInt("id"));
                car.setNumberPlate(rs.getString("numberPlate"));
                car.setModel(rs.getString("model"));
                car.setMake(rs.getString("make"));
                car.setDescription(rs.getString("description"));
                results.add(car);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return results;
    }
    public void addCar(Car car,String key) {
        String sql = "INSERT INTO tblcar(NumberPlate,Model,Make,Description,tblCustomerID) VALUES(?,?,?,?,?)";
        boolean result = true;
        try{
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);//trả về ID khi thêm dữ liệu mới vào bảng
            ps.setString(1, car.getNumberPlate());
            ps.setString(2, car.getModel());
            ps.setString(3, car.getMake());
            ps.setString(4, car.getDescription());
            ps.setString(5,key);

            ps.executeUpdate();//Dùng cho các câu lệnh làm thay đổi bảng trả về số hàng b ảnh hưởng
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {//kiểm tra xem ResultSet có chứa hàng nào hay không
                car.setId(generatedKeys.getInt(1));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
