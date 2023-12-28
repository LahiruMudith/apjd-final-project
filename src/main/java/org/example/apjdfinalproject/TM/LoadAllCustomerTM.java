package org.example.apjdfinalproject.TM;

public class LoadAllCustomerTM {
    private String NIC;
    private String Name;
    private String Address;
    private int Age;
    private int PhoneNumber;
    private int PhoneNumber2;

    public LoadAllCustomerTM() {
    }

    public LoadAllCustomerTM(String NIC, String name, String address, int age, int phoneNumber, int phoneNumber2) {
        this.NIC = NIC;
        Name = name;
        Address = address;
        Age = age;
        PhoneNumber = phoneNumber;
        PhoneNumber2 = phoneNumber2;
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

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public int getPhoneNumber2() {
        return PhoneNumber2;
    }

    public void setPhoneNumber2(int phoneNumber2) {
        PhoneNumber2 = phoneNumber2;
    }
}
