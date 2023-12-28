package org.example.apjdfinalproject.TO;

public class RentClose {
    private int IssueID;
    private String NIC;
    private String Name;
    private String VehicleNumber;

    public RentClose(String NIC, String name, String vehicleNumber, String vehicleBrandName) {
        this.NIC = NIC;
        Name = name;
        VehicleNumber = vehicleNumber;
        VehicleBrandName = vehicleBrandName;
    }

    private String VehicleBrandName;

    public RentClose() {

    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
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

    public int getIssueID() {
        return IssueID;
    }

    public void setIssueID(int issueID) {
        IssueID = issueID;
    }
}
