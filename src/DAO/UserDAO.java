package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.User;

public class UserDAO extends DAO{

    public UserDAO() {
        super();
    }
    public boolean checkLogin(User user) {
        boolean result = false;
        String sql = "SELECT ID,Fullname, Role FROM tblUser WHERE Username = ? AND Password = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ResultSet rs = ps.executeQuery();//Dùng cho các câu lệnh SELECT trả về đối tượng select trong SQL
            if(rs.next()) {
                user.setId(rs.getInt("ID"));
                user.setFullname(rs.getString("Fullname"));
                user.setRole(rs.getString("Role"));
                result = true;
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }


}
