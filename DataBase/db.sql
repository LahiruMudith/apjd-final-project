create database Lahiru_Motors;

use Lahiru_Motors;

create table user(
Email varchar(300),
Password varchar(20),
Primary Key (Email)
);

create table Vehicle (
Vehicle_Number varchar(20),
vehicle_Brand_Name varchar(40) Not Null,
Vehicle_Color varchar(10) Not Null,
Fule_Type varchar(20) Not Null,
Transmission_Type varchar(20) Not Null,
1Day_Price double Not Null,
Primary Key(Vehicle_Number)
);

create table Customer (
Customer_NIC_Number varchar(12),
Customer_Name varchar(40) Not Null,
Customer_Address varchar(100) Not Null,
Customer_Age int Not Null,
Customer_PhoneNumber int Not Null,
Customer_PhoneNumber2 int,
Primary Key(Customer_NIC_Number)
);

create table Issue_Vehicle (
Issue_ID int AUTO_INCREMENT NOT NULL,
Customer_NIC varchar(12),
Customer_Name varchar(40) Not Null,
Vehicle_Number varchar(20),
vehicle_Brand_Name varchar(40) Not Null,
Issue_Date date,
	Primary Key (Issue_ID),
    FOREIGN KEY (Customer_NIC) REFERENCES Customer(Customer_NIC_Number),
    FOREIGN KEY (Vehicle_Number) REFERENCES Vehicle(Vehicle_Number)
);


