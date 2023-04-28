DROP SCHEMA IF EXISTS hoteldb;
CREATE SCHEMA hoteldb;
USE hoteldb;

CREATE TABLE hotel (
	hotel_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	hotel_name VARCHAR(20),
	hotel_location VARCHAR(20),
	hotel_phone VARCHAR(10), 
	hotel_email VARCHAR(50),
	hotel_rating INT,
	pet_friendly BOOLEAN
);

CREATE TABLE room ( 
	room_id INT AUTO_INCREMENT PRIMARY KEY,
	room_no INT,
	room_type VARCHAR(50),
	room_price DECIMAL(10,2),
	floor_no INT,
	area_of_room VARCHAR(15),
	occupancy_details VARCHAR(30),
	hotel_id INT,
	FOREIGN KEY (hotel_id) REFERENCES hotel (hotel_id)
    ON DELETE CASCADE
);

CREATE TABLE customer (
	customer_id INT AUTO_INCREMENT PRIMARY KEY,
	customer_name VARCHAR(20),
	customer_address VARCHAR(100),
	customer_phone VARCHAR(10),
	customer_email VARCHAR(50),
	preferences VARCHAR(50),
	special_needs VARCHAR(50)
);

CREATE TABLE employee (
	emp_id INT AUTO_INCREMENT PRIMARY KEY,
	emp_name VARCHAR (20),
	emp_salary DECIMAL(10,2),
	emp_phone VARCHAR(10),
	emp_address VARCHAR(20),
	emp_email VARCHAR(50),
	joining_date DATE,
	hotel_id INT,
	FOREIGN KEY (hotel_id) REFERENCES hotel (hotel_id)
    ON DELETE CASCADE
);

CREATE TABLE bill (
	bill_id INT AUTO_INCREMENT PRIMARY KEY,
    bill_number INT,
	bill_amt DECIMAL(8,2),
	bill_DateTime DATETIME,
	bill_status VARCHAR(50),
	payment_method VARCHAR(10),
	discount VARCHAR (5),
	bill_reward_points DECIMAL(10,2),
	customer_id INT,
	FOREIGN KEY (customer_id) REFERENCES customer (customer_id)
    ON DELETE CASCADE
);


CREATE TABLE booking (
	booking_id INT AUTO_INCREMENT PRIMARY KEY,
	booking_dateTime DATETIME,
	booking_amt DECIMAL(10,2),
	check_in_DateTime DATETIME,
	check_out_DateTime DATETIME,
	no_of_adults INT,
	no_of_child INT,
	booking_status VARCHAR (20),
	hotel_id INT,
	FOREIGN KEY (hotel_id) REFERENCES hotel (hotel_id) ON DELETE CASCADE,
	customer_id INT,
	FOREIGN KEY (customer_id) REFERENCES customer (customer_id),
	bill_id INT,
	FOREIGN KEY (bill_id ) REFERENCES bill (bill_id) ON DELETE CASCADE,
	room_id INT,
	FOREIGN KEY (room_id  ) REFERENCES room (room_id) ON DELETE CASCADE,
	emp_id INT,
	FOREIGN KEY (emp_id  ) REFERENCES employee (emp_id)
    ON DELETE CASCADE
);

CREATE TABLE service (
	service_id INT AUTO_INCREMENT PRIMARY KEY,
	service_name VARCHAR(30)
);

CREATE TABLE hotel_customer (
	hotel_customer_id INT AUTO_INCREMENT PRIMARY KEY,
	hotel_id INT,
	FOREIGN KEY (hotel_id) REFERENCES hotel (hotel_id) ON DELETE CASCADE,
	customer_id INT,
	FOREIGN KEY (customer_id) REFERENCES customer (customer_id) ON DELETE CASCADE,
	customer_type VARCHAR(15),
	customer_reward_points DECIMAL(5,2)
);

CREATE TABLE hotel_service (
	hotel_service_id INT AUTO_INCREMENT PRIMARY KEY,
	hotel_id INT,
	FOREIGN KEY (hotel_id) REFERENCES hotel (hotel_id) ON DELETE CASCADE,
	service_id INT,
	FOREIGN KEY (service_id ) REFERENCES service (service_id ) ON DELETE CASCADE,
	service_price DECIMAL(10,2)
);

CREATE TABLE booking_service (
	booking_service_id INT AUTO_INCREMENT PRIMARY KEY,
	booking_id INT,
	FOREIGN KEY (booking_id ) REFERENCES booking (booking_id ) ON DELETE CASCADE,
	hotel_service_id INT,
	FOREIGN KEY (hotel_service_id ) REFERENCES hotel_service (hotel_service_id ) ON DELETE CASCADE,
	rating DECIMAL(3,1)
);

ALTER TABLE hotel AUTO_INCREMENT=101;
ALTER TABLE room AUTO_INCREMENT=201;
ALTER TABLE customer AUTO_INCREMENT=301;
ALTER TABLE employee AUTO_INCREMENT=401;
ALTER TABLE booking AUTO_INCREMENT=501;
ALTER TABLE service AUTO_INCREMENT=601;
ALTER TABLE bill AUTO_INCREMENT=701;