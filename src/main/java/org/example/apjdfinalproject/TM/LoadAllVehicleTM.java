package org.example.apjdfinalproject.TM;

public class LoadAllVehicleTM {
    private String VehicleNumber;
    private String BrandName;
    private String Color;
    private String FuleType;
    private String TransmissonType;
    private double Price;


    public LoadAllVehicleTM() {
    }

    public LoadAllVehicleTM(String vehicleNumber, String brandName, String color, String fuleType, String transmissonType, double price) {
        VehicleNumber = vehicleNumber;
        BrandName = brandName;
        Color = color;
        FuleType = fuleType;
        TransmissonType = transmissonType;
        Price = price;
    }


    public String getVehicleNumber() {
        return VehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        VehicleNumber = vehicleNumber;
    }

    public String getBrandName() {
        return BrandName;
    }

    public void setBrandName(String brandName) {
        BrandName = brandName;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getFuleType() {
        return FuleType;
    }

    public void setFuleType(String fuleType) {
        FuleType = fuleType;
    }

    public String getTransmissonType() {
        return TransmissonType;
    }

    public void setTransmissonType(String transmissonType) {
        TransmissonType = transmissonType;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }
}
