package org.example.apjdfinalproject.Model;

import org.example.apjdfinalproject.TM.LoadIssueVehicleTM;
import org.example.apjdfinalproject.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class IssueModel {
    public static boolean IssueVehicle(String NIC, String CustomerName, String VehicleNumber, String VehicleBrandName) throws SQLException {

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String IssueDate = dateFormat.format(date);

        Connection connection = DBConnection.getDbConnection().getConnection();
        connection.setAutoCommit(false);

        try {
            PreparedStatement stm = connection.prepareStatement("insert into issue_vehicle(Customer_NIC,Customer_Name,Vehicle_Number,vehicle_Brand_Name,Issue_Date) values(?,?,?,?,?)");
            stm.setObject(1,NIC);
            stm.setObject(2,CustomerName);
            stm.setObject(3,VehicleNumber);
            stm.setObject(4,VehicleBrandName);
            stm.setObject(5,IssueDate);

            int results = stm.executeUpdate();

            if (results>0) {
                //execute all cached queries
                connection.commit();

                //set default setting of auto commit
                connection.setAutoCommit(true);
                return true;
            }else {
                //execute all cached queries
                connection.rollback();

                //set default setting of auto commit
                connection.setAutoCommit(true);
                return false;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static ArrayList<LoadIssueVehicleTM> LoadIssueVehicle() {
        Connection connection = DBConnection.getDbConnection().getConnection();

        try {
            PreparedStatement stm = connection.prepareStatement("select * from issue_vehicle");

            ResultSet resultSet = stm.executeQuery();

            ArrayList<LoadIssueVehicleTM> list = new ArrayList<>();

            while (resultSet.next()) {
                LoadIssueVehicleTM tm = new LoadIssueVehicleTM();

                tm.setIssueID(resultSet.getInt(1));
                tm.setCustomerNIC(resultSet.getString(2));
                tm.setCustomerName(resultSet.getString(3));
                tm.setVehicleNumber(resultSet.getString(4));
                tm.setVehicleBrandName(resultSet.getString(5));
                tm.setDate(resultSet.getString(6));

                list.add(tm);
            }
            return list;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
