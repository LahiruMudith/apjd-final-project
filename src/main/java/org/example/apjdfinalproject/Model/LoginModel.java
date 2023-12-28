package org.example.apjdfinalproject.Model;

import org.example.apjdfinalproject.TO.User;
import org.example.apjdfinalproject.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginModel {
    public static boolean CreateAccount(User user) {
        Connection connection = DBConnection.getDbConnection().getConnection();

        try {
            PreparedStatement stm = connection.prepareStatement("insert into user values(?,?)");
            stm.setObject(1,user.getEmail());
            stm.setObject(2,user.getPassword());

            int results = stm.executeUpdate();

            if (results>0) {
                return true;
            }else {
                return false;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static boolean ForgotPassword(User user) {
        Connection connection = DBConnection.getDbConnection().getConnection();

        try {
            PreparedStatement stm = connection.prepareStatement("update user set Password=?,Email=? where Email=?");
            stm.setObject(1,user.getPassword());
            stm.setObject(2,user.getEmail());
            stm.setObject(3,user.getEmail());

            int results = stm.executeUpdate();

            if (results>0) {
                return true;
            }else {
                return false;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static User SearchUser(String email) {
        Connection connection = DBConnection.getDbConnection().getConnection();

        try {
            PreparedStatement stm = connection.prepareStatement("select * from user where Email=?");
            stm.setObject(1,email);

            ResultSet resultSet = stm.executeQuery();

            User user = new User();

            while (resultSet.next()) {
                user.setEmail(resultSet.getString(1));
            }

            return user;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean Login(User user) {
        Connection connection = DBConnection.getDbConnection().getConnection();

        try {
            PreparedStatement stm = connection.prepareStatement("select Email, Password from user where Email=? && Password=?");
            stm.setObject(1,user.getEmail());
            stm.setObject(2,user.getPassword());

            ResultSet results = stm.executeQuery();

            if (results==null) {
                return false;
            }else {
                return true;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
