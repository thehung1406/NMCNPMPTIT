package DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.Customer;


public class CustomerDAO  extends DAO{
    public CustomerDAO(){super();}
    public ArrayList<Customer> searchCustomer(String key){
        ArrayList<Customer> result = new ArrayList<Customer>();
        String sql = "SELECT * FROM tblcustomer WHERE Name LIKE ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + key + "%");
            ResultSet rs = ps.executeQuery();//Dùng cho các câu lệnh SELECT trả về đối tượng select trong SQL

            while(rs.next()){
                Customer customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setName(rs.getString("name"));
                customer.setAddress(rs.getString("address"));
                customer.setTel(rs.getString("tel"));
                customer.setNote(rs.getString("note"));
                result.add(customer);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
    public void addCustomer(Customer customer) {
        String sql = "INSERT INTO tblcustomer(Name,Address,Tel,Note) VALUES(?,?,?,?)";
        try{
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);//trả về ID khi thêm dữ liệu mới vào bảng
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getAddress());
            ps.setString(3, customer.getTel());
            ps.setString(4, customer.getNote());

            ps.executeUpdate();//Dùng cho các câu lệnh làm thay đổi bảng trả về số hàng b ảnh hưởng
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {//kiểm tra xem ResultSet có chứa hàng nào hay không
                customer.setId(generatedKeys.getInt(1));
            }
        }

        catch(Exception e){
            e.printStackTrace();
        }
    }
}
