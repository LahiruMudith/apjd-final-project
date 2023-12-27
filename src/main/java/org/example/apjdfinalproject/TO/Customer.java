package org.example.apjdfinalproject.TO;

public class Customer {
    private String NicNumber;
    private String Name;
    private String Address;
    private String Age;
    private int PhoneNumber;
    private int PhoneNumber2;

    public Customer() {
    }

    public Customer(String nicNumber, String name, String address, String age, int phoneNumber, int phoneNumber2) {
        NicNumber = nicNumber;
        Name = name;
        Address = address;
        Age = age;
        PhoneNumber = phoneNumber;
        PhoneNumber2 = phoneNumber2;
    }

    public String getNicNumber() {
        return NicNumber;
    }

    public void setNicNumber(String nicNumber) {
        NicNumber = nicNumber;
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

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
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
