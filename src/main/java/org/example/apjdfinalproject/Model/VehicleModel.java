package org.example.apjdfinalproject.Model;

import org.example.apjdfinalproject.TM.LoadAllVehicleTM;
import org.example.apjdfinalproject.TO.Vehicle;
import org.example.apjdfinalproject.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VehicleModel {
    public static boolean AddVehicle(Vehicle vehicle) {
        try {
            Connection connection = DBConnection.getDbConnection().getConnection();

            PreparedStatement stm = connection.prepareStatement("insert into vehicle values(?,?,?,?,?,?) ");
            stm.setObject(1,vehicle.getVehicleNumber());
            stm.setObject(2,vehicle.getVehicleBrandName());
            stm.setObject(3,vehicle.getVehicleColor());
            stm.setObject(4,vehicle.getFuleType());
            stm.setObject(5,vehicle.getTransmissionType());
            stm.setObject(6,vehicle.getPrice());

            int results = stm.executeUpdate();

            System.out.println(results);

            if (results>0) {
                return  true;
            }else {
                return false;
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static boolean UpdateVehicle(Vehicle vehicle) {

        Connection connection = DBConnection.getDbConnection().getConnection();

        try {

            PreparedStatement stm = connection.prepareStatement("update vehicle set vehicle_Brand_Name=?, Vehicle_Color=?, Fule_Type=?, Transmission_Type=?, 1Day_Price=? where Vehicle_Number=?");
            stm.setObject(1,vehicle.getVehicleBrandName());
            stm.setObject(2,vehicle.getVehicleColor());
            stm.setObject(3,vehicle.getFuleType());
            stm.setObject(4,vehicle.getTransmissionType());
            stm.setObject(5,vehicle.getPrice());
            stm.setObject(6,vehicle.getVehicleNumber());

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
    public static boolean DeleteVehicle(String searchId) {

        Connection connection = DBConnection.getDbConnection().getConnection();

        try {
            PreparedStatement stm = connection.prepareStatement("delete from Vehicle where Vehicle_Number=?");
            stm.setObject(1,searchId);

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
    public static ArrayList<LoadAllVehicleTM> LoadAllVehicle() {
        Connection connection = DBConnection.getDbConnection().getConnection();

        try {
            PreparedStatement stm = connection.prepareStatement("select * from Vehicle");

            ResultSet resultSet = stm.executeQuery();

            ArrayList<LoadAllVehicleTM> list = new ArrayList<>();

            while (resultSet.next()) {
                LoadAllVehicleTM tm =new LoadAllVehicleTM();

                tm.setVehicleNumber(resultSet.getString(1));
                tm.setBrandName(resultSet.getString(2));
                tm.setColor(resultSet.getString(3));
                tm.setFuleType(resultSet.getString(4));
                tm.setTransmissonType(resultSet.getString(5));
                tm.setPrice(Double.parseDouble(resultSet.getString(6)));

                list.add(tm);
            }
            return list;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static Vehicle Search(String searchId) {

        Connection connection = DBConnection.getDbConnection().getConnection();

        try {

            PreparedStatement stm = connection.prepareStatement("select * from vehicle where Vehicle_Number=?");
            stm.setObject(1,searchId);

            ResultSet resultSet = stm.executeQuery();

            Vehicle vehicle = new Vehicle();

            while (resultSet.next()) {
                vehicle.setVehicleNumber(resultSet.getString(1));
                vehicle.setVehicleBrandName(resultSet.getString(2));
                vehicle.setVehicleColor(resultSet.getString(3));
                vehicle.setFuleType(resultSet.getString(4));
                vehicle.setTransmissionType(resultSet.getString(5));
                vehicle.setPrice(resultSet.getDouble(6));
            }

            return vehicle;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
