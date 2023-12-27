package org.example.apjdfinalproject.TM;

public class LoadIssueVehicleTM {
    private int IssueID;
    private String CustomerNIC;
    private String CustomerName;
    private String VehicleNumber;
    private String VehicleBrandName;
    private String Date;

    public String getCustomerNIC() {
        return CustomerNIC;
    }

    public void setCustomerNIC(String customerNIc) {
        CustomerNIC = customerNIc;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
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

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public int getIssueID() {
        return IssueID;
    }

    public void setIssueID(int issueID) {
        IssueID = issueID;
    }
}
