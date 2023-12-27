package org.example.apjdfinalproject.TO;

public class Vehicle {
    private String VehicleNumber;
    private String VehicleBrandName;
    private String VehicleColor;
    private String FuleType;
    private String TransmissionType;
    private double Price;

    public Vehicle(String vehicleNumber, String vehicleBrandName, String vehicleColor, String fuleType, String transmissionType, double price) {
        VehicleNumber = vehicleNumber;
        VehicleBrandName = vehicleBrandName;
        VehicleColor = vehicleColor;
        FuleType = fuleType;
        TransmissionType = transmissionType;
        Price = price;
    }

    public Vehicle() {

    }

    public String getVehicleNumber() {
        return VehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        VehicleNumber = vehicleNumber;
    }

    public String getVehicleBrandName() {
        return VehicleBrandName;
    }

    public void setVehicleBrandName(String vehicleBrandName) {
        VehicleBrandName = vehicleBrandName;
    }

    public String getVehicleColor() {
        return VehicleColor;
    }

    public void setVehicleColor(String vehicleColor) {
        VehicleColor = vehicleColor;
    }

    public String getFuleType() {
        return FuleType;
    }

    public void setFuleType(String fuleType) {
        FuleType = fuleType;
    }

    public String getTransmissionType() {
        return TransmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        TransmissionType = transmissionType;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }
}
