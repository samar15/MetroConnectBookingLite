# MetroConnectBookingLite

Metro connect is a service that provides goods transportation service between four metros:
Delhi, Mumbai, Chennai and Kolkata. Booking lite is a vehicle management system in which client can add request for transport of packages
with certain weight to/from different metros.  

Create a rest services for client that allocates available vehicle for the booking. 
Client 

Add a request with the following properties: 
Source City 
Destination City 
Date of pickup 
packageWeight 

                                 

Returns: 
Vehicle Number (“Vehicle not available”) if vehicle is not available. 
Cost 

 

Optional: Writing TestCases  

Assume that travel time and cost between any two metro is fixed: 

Eg: 
Delhi-Mumbai:    3 days, Rs. 50k 
Delhi-Chennai:    4 days, Rs. 70k 

Assume there are 10,000 vehicles available in every metro when the service starts. 
Assume any entity or parameter you consider is needed for this System. Do use a proper project Structure. 

Tech Stack preferred: Java8, Springboot , hibernate, mysql , redis 


MYSQL TABLES

create table location (
id INT ,
code VARCHAR(10) NOT NULL ,
latitude DOUBLE NOT NULL ,
longitude DOUBLE NOT NULL ,
PRIMARY KEY (id)
);


create table vehicle (
id INT ,
vehicle_number VARCHAR(10) NOT NULL ,
is_available BOOLEAN NOT NULL ,
PRIMARY KEY (id)
);


create table request (
id INT AUTO_INCREMENT ,
source_code VARCHAR(10) NOT NULL ,
destination_code VARCHAR(10) NOT NULL ,
date_of_package BIGINT(16) NOT NULL ,
user_id INT NOT NULL ,
weight FLOAT NOT NULL ,
PRIMARY KEY (id)
);