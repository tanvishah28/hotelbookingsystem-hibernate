INSERT INTO hotel(hotel_name,hotel_location,hotel_phone,hotel_email,hotel_rating,pet_friendly) VALUES 
('Taj','Mumbai','9876543210','taj@taj.com',5,1);
INSERT INTO hotel(hotel_name,hotel_location,hotel_phone,hotel_email,hotel_rating,pet_friendly) VALUES 
('Hyatt','Bangalore','9876543212','hyatt@hyatt.com',4,0);
INSERT INTO hotel(hotel_name,hotel_location,hotel_phone,hotel_email,hotel_rating,pet_friendly) VALUES 
('Leela','Mumbai','9876543202','leela@leela.com',5,1);
INSERT INTO hotel(hotel_name, hotel_location, hotel_phone, hotel_email, hotel_rating, pet_friendly) VALUES 
('Oberio', 'Mumbai', '9874562130','oberio@oberio.com',5,0);
INSERT INTO hotel(hotel_name,hotel_location,hotel_phone,hotel_email,hotel_rating,pet_friendly) VALUES 
('Taj Mahal','Agra','9876543210','tajmahal@taj.com',5,1);
INSERT INTO hotel(hotel_name,hotel_location,hotel_phone,hotel_email,hotel_rating,pet_friendly) VALUES 
(' Grand Hyatt','Bangalore','9876543212','grandhyatt@hyatt.com',4,0);
INSERT INTO hotel(hotel_name,hotel_location,hotel_phone,hotel_email,hotel_rating,pet_friendly) VALUES 
('ITC','Mumbai','9876543202','itc@leela.com',5,1);
INSERT INTO hotel(hotel_name, hotel_location, hotel_phone, hotel_email, hotel_rating, pet_friendly) VALUES 
('Raddison', 'Mumbai', '9874562130','raddison@oberio.com',5,0);

INSERT INTO room(room_no, room_type, room_price, floor_no, area_of_room, occupancy_details, hotel_id) VALUES
 (1, 'Garden View', 10000,11,'1500 sq.ft.','2 adults',101);
 INSERT INTO room(room_no, room_type, room_price, floor_no, area_of_room, occupancy_details, hotel_id) VALUES
 (2, 'Sea View', 15000, 12,'1800 sq.ft.','2 adults, 2 child',101);
 INSERT INTO room(room_no, room_type, room_price, floor_no, area_of_room, occupancy_details, hotel_id) VALUES
 (3, 'Suite Room', 18000,14,'2000 sq.ft.','2 adults, 2 child',101);
 INSERT INTO room(room_no, room_type, room_price, floor_no, area_of_room, occupancy_details, hotel_id) VALUES
 (4, 'Garden View', 10000,11,'1500 sq.ft.','2 adults',102), (5, 'Sea View', 15000, 12,'1800 sq.ft.','2 adults, 2 child',102), 
 (6, 'Suite Room', 18000,14,'2000 sq.ft.','2 adults, 2 child',103), (7, 'Suite Room', 18000,14,'2000 sq.ft.','2 adults, 2 child',103);
 
INSERT INTO customer(customer_name, customer_address, customer_phone, customer_email, preferences, special_needs) 
VALUES ('John', 'Delhi', '9876543810', 'john@gmail.com', 'King Size Bed', null);
INSERT INTO customer(customer_name, customer_address, customer_phone, customer_email, preferences, special_needs) 
VALUES ('Mary', 'Bangalore', '9876543212', 'mary@gmail.com', null , 'wheelchair');
INSERT INTO customer(customer_name, customer_address, customer_phone, customer_email, preferences, special_needs) 
VALUES ('Emily', 'Nainital', '9876543540', 'emily@gmail.com', 'King Size Bed', null);
INSERT INTO customer(customer_name, customer_address, customer_phone, customer_email, preferences, special_needs) 
VALUES ('Jack', 'Pune', '9876543217', 'jack@gmail.com', 'Single Bed', null),('Lily', 'Dehradun', '9876543222', 'lily@gmail.com', null, null);

INSERT INTO employee (emp_name, emp_salary, emp_phone, emp_address, emp_email, joining_date, hotel_id) VALUES
('Peter', 25000, '9876543310', 'Chennai', 'peter@gmail.com', '2022-2-21', 101);
INSERT INTO employee (emp_name, emp_salary, emp_phone, emp_address, emp_email, joining_date, hotel_id) VALUES
('Lisa', 35000, '9876543211', 'Delhi', 'lisa@gmail.com', '2022-2-22', 102);
INSERT INTO employee (emp_name, emp_salary, emp_phone, emp_address, emp_email, joining_date, hotel_id) VALUES
('Emma', 50000, '9876543213', 'Pune', 'emma@gmail.com', '2022-2-21', 103), 
('Chad', 40000, '9876521380', 'Mumbai', 'chad@gmail.com', '2022-2-21', 104);

INSERT INTO bill (bill_number,bill_amt, bill_DateTime, bill_status, payment_method, discount,bill_reward_points, customer_id) VALUES 
(1001,12000, '2022-2-26 11:15:00', 'PAID', 'DEBIT', '10%',20, 301);
INSERT INTO bill (bill_number,bill_amt, bill_DateTime, bill_status, payment_method, discount, bill_reward_points, customer_id) VALUES 
(1002,17000, '2022-2-26 11:15:00', 'PARTIALLY_PAID', 'CREDIT', 0, 0, 302);
INSERT INTO bill (bill_number,bill_amt, bill_DateTime, bill_status, payment_method, discount, bill_reward_points, customer_id) VALUES 
(1003,20000, '2022-2-27 11:15:00', 'PAID', 'DEBIT', '10%', 200, 303);
INSERT INTO bill (bill_number,bill_amt, bill_DateTime, bill_status, payment_method, discount, bill_reward_points, customer_id) VALUES 
(1004,12000, '2022-3-12 11:15:00', 'PAID', 'CREDIT', '5%', 80, 304),(1005,20000, '2022-3-13 11:15:00', 'PAID', 'CASH', '20%', 200, 303);

INSERT INTO service (service_name) VALUES ('Laundry');
INSERT INTO service (service_name) VALUES ('Cab service');
INSERT INTO service (service_name) VALUES ('Personal chef');
INSERT INTO service (service_name) VALUES ('Room Service');

INSERT INTO booking (booking_dateTime, booking_amt, check_in_DateTime, check_out_DateTime, no_of_adults, no_of_child, booking_status, hotel_id, 
customer_id, bill_id, room_id, emp_id) VALUES ('2022-2-22 08:05:22', 5000, '2022-2-25 12:05:22', '2022-2-26 11:05:22', 2, null, 
'COMPLETED',101,301,701,201,401);
INSERT INTO booking (booking_dateTime, booking_amt, check_in_DateTime, check_out_DateTime, no_of_adults, no_of_child, booking_status, hotel_id, 
customer_id, bill_id, room_id, emp_id) VALUES ('2022-2-20 12:05:22', 5500, '2022-2-25 12:05:22', '2022-2-26 11:05:22', 1, 1, 
'POSTPONED',101,302,702,202,401);
INSERT INTO booking (booking_dateTime, booking_amt, check_in_DateTime, check_out_DateTime, no_of_adults, no_of_child, booking_status, hotel_id, 
customer_id, bill_id, room_id, emp_id) VALUES ('2022-2-25 06:05:22', 8000, null, null, 2, 1, 'NO_SHOW',102,303,703,204,402);
INSERT INTO booking (booking_dateTime, booking_amt, check_in_DateTime, check_out_DateTime, no_of_adults, no_of_child, booking_status, hotel_id, 
customer_id, bill_id, room_id, emp_id) VALUES ('2022-2-28 06:05:22', 5000, '2022-3-11 12:05:22', '2022-3-12 11:05:22', 2, null, 
'COMPLETED',102,304,704,205,402),
('2022-3-01 06:05:22', 8100, '2022-3-12 12:05:22', '2022-3-13 11:05:22', 2, 1, 'COMPLETED',103,303,705,206,403);


INSERT INTO hotel_customer (hotel_id,customer_id, customer_type, customer_reward_points) VALUES (101,301,'Platinum',200);
INSERT INTO hotel_customer (hotel_id,customer_id, customer_type, customer_reward_points) VALUES (101,302,'Gold',100);
INSERT INTO hotel_customer (hotel_id,customer_id, customer_type, customer_reward_points) VALUES (101,303,'Silver',50);
INSERT INTO hotel_customer (hotel_id,customer_id, customer_type, customer_reward_points) VALUES (102,303,'Gold',100);
INSERT INTO hotel_customer (hotel_id,customer_id, customer_type, customer_reward_points) VALUES (103,303,'Platinum',200);
INSERT INTO hotel_customer (hotel_id,customer_id, customer_type, customer_reward_points) VALUES (102,304,'Silver',50);

INSERT INTO hotel_service (hotel_id,service_id, service_price) VALUES (101,601,1000);
INSERT INTO hotel_service (hotel_id,service_id, service_price) VALUES (101,602,1500);
INSERT INTO hotel_service (hotel_id,service_id, service_price) VALUES (101,603,5000);
INSERT INTO hotel_service (hotel_id,service_id, service_price) VALUES (102,601,1200),(102,602,1500),(102,603,6000),(101,604,2000),
(103,601,1000),(103,602,1500),(104,601,1000),(104,602,1500);

INSERT INTO booking_service (booking_id,hotel_service_id, rating) VALUES (501, 1, 5);
INSERT INTO booking_service (booking_id,hotel_service_id, rating) VALUES (501, 2, 3);
INSERT INTO booking_service (booking_id,hotel_service_id, rating) VALUES (501, 3, 4);
INSERT INTO booking_service (booking_id,hotel_service_id, rating) VALUES (504, 4, 4),(504, 6, 5),(505, 2, 3);
