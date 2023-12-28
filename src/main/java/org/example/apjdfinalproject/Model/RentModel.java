package org.example.apjdfinalproject.Model;

import org.example.apjdfinalproject.TO.RentClose;
import org.example.apjdfinalproject.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RentModel {
    public static RentClose RentSearch(int ID) {
        Connection connection = DBConnection.getDbConnection().getConnection();

        try {
            PreparedStatement stm = connection.prepareStatement("select Customer_NIC, Customer_Name, Vehicle_Number, vehicle_Brand_Name from issue_vehicle where Issue_ID=?");
            stm.setObject(1,ID);

            ResultSet resultSet = stm.executeQuery();

            RentClose rentClose = new RentClose();

            if (resultSet.next()) {
                rentClose.setNIC(resultSet.getString(1));
                rentClose.setName(resultSet.getString(2));
                rentClose.setVehicleNumber(resultSet.getString(3));
                rentClose.setVehicleBrandName(resultSet.getString(4));


            }

            return rentClose;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean RentClose(String IssueID) {
        Connection connection = DBConnection.getDbConnection().getConnection();

        try {
            PreparedStatement stm = connection.prepareStatement("DELETE FROM issue_vehicle WHERE Issue_ID=?");
            stm.setObject(1,IssueID);

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
}
