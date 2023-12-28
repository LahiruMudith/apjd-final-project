package org.example.apjdfinalproject.Model;

import org.example.apjdfinalproject.TM.LoadAllCustomerTM;
import org.example.apjdfinalproject.TM.LoadIssueVehicleTM;
import org.example.apjdfinalproject.TO.Customer;
import org.example.apjdfinalproject.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerModel {
    
    public static boolean AddCustomer(Customer customer) {
        Connection connection = DBConnection.getDbConnection().getConnection();

        try {
            PreparedStatement stm = connection.prepareStatement("insert into customer values(?,?,?,?,?,?)");
            stm.setObject(1,customer.getNicNumber());
            stm.setObject(2,customer.getName());
            stm.setObject(3,customer.getAddress());
            stm.setObject(4,customer.getAge());
            stm.setObject(5,customer.getPhoneNumber());
            stm.setObject(6,customer.getPhoneNumber2());

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
    public static boolean UpdateCustomer(Customer customer) {
        Connection connection = DBConnection.getDbConnection().getConnection();

        try {
            PreparedStatement stm = connection.prepareStatement("update customer set Customer_Name=?, Customer_Address=?, Customer_Age=?, Customer_PhoneNumber=?, Customer_PhoneNumber2=? where Customer_NIC_Number=?");
            stm.setObject(1,customer.getName());
            stm.setObject(2,customer.getAddress());
            stm.setObject(3,customer.getAge());
            stm.setObject(4,customer.getPhoneNumber());
            stm.setObject(5,customer.getPhoneNumber2());
            stm.setObject(6,customer.getNicNumber());


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
    public static boolean DeleteCustomer(String NIC) {
        Connection connection = DBConnection.getDbConnection().getConnection();

        try {
            PreparedStatement stm = connection.prepareStatement("delete from customer where Customer_NIC_Number=?");
            stm.setObject(1,NIC);

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
    public static Customer SearchCustomer(String NIC) {
        Connection connection = DBConnection.getDbConnection().getConnection();

        try {
            PreparedStatement stm = connection.prepareStatement("select * from customer where Customer_NIC_Number=?");
            stm.setObject(1,NIC);

            ResultSet resultSet = stm.executeQuery();

            Customer customer = new Customer();

            if (resultSet.next()) {
                customer.setNicNumber(resultSet.getString(1));
                customer.setName(resultSet.getString(2));
                customer.setAddress(resultSet.getString(3));
                customer.setAge(resultSet.getString(4));
                customer.setPhoneNumber(Integer.parseInt(resultSet.getString(5)));
                customer.setPhoneNumber2(Integer.parseInt(resultSet.getString(6)));
            }

            return customer;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static ArrayList<LoadAllCustomerTM> ViewAllCustomer() {
        Connection connection = DBConnection.getDbConnection().getConnection();

        try {
            PreparedStatement stm = connection.prepareStatement("select * from customer");

            ResultSet resultSet = stm.executeQuery();

            ArrayList<LoadAllCustomerTM> list = new ArrayList<>();

            while (resultSet.next()) {
                LoadAllCustomerTM tm = new LoadAllCustomerTM();

                tm.setNIC(resultSet.getString(1));
                tm.setName(resultSet.getString(2));
                tm.setAddress(resultSet.getString(3));
                tm.setAge(resultSet.getInt(4));
                tm.setPhoneNumber(resultSet.getInt(5));
                tm.setPhoneNumber2(resultSet.getInt(6));

                list.add(tm);
            }
            return list;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    
}
