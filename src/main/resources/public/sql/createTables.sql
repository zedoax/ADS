CREATE TABLE account (
	username VARCHAR(20) NOT NULL PRIMARY KEY,
	password VARCHAR(64) NOT NULL,
	session_token VARCHAR(25) UNIQUE,
	first_name VARCHAR(20) NOT NULL,
	last_name VARCHAR(20) NOT NULL,
	address_number INT NOT NULL,
	address_street VARCHAR(40) NOT NULL,
	address_city VARCHAR(20) NOT NULL,
	address_zipcode MEDIUMINT(5) UNSIGNED NOT NULL
);

CREATE TABLE contract_member(
	member_id INT NOT NULL PRIMARY KEY,
	cycle_start DATE NOT NULL,
	cycle_bill DECIMAL(20,2) DEFAULT 00.00,
	username VARCHAR(20) REFERENCES account(username)
);

CREATE TABLE non_contract_member(
	member_id INT NOT NULL PRIMARY KEY,
	username VARCHAR(20) REFERENCES account(username)
);

CREATE TABLE payment(
	username VARCHAR(20) REFERENCES account(username),
	payment DECIMAL(20,2) NOT NULL,
	pay_date DATE NOT NULL
);


CREATE TABLE package_weight(
	weight_class VARCHAR(20) NOT NULL PRIMARY KEY,
	cost_modifier FLOAT DEFAULT 1
);

CREATE TABLE package_class(
	package_type VARCHAR(20) NOT NULL PRIMARY KEY,
	cost_modifier FLOAT DEFAULT 1
);

CREATE TABLE station(
	location_id INT NOT NULL PRIMARY KEY,
	location_number INT NOT NULL,
	location_street VARCHAR(40) NOT NULL,
	location_city VARCHAR(20) NOT NULL,
	location_zipcode MEDIUMINT(5) UNSIGNED NOT NULL
);

CREATE TABLE vehicle(
	vehicle_id INT NOT NULL PRIMARY KEY,
	vehicle_type VARCHAR(10) NOT NULL,
	origin_id INT REFERENCES station(location_id),
	destination_id INT REFERENCES station(location_id)
);

CREATE TABLE tracking(
	tracking_id INT NOT NULL PRIMARY KEY,
	destination_number INT NOT NULL,
	destination_street VARCHAR(40) NOT NULL,
	destination_city VARCHAR(20) NOT NULL,
	destiantion_zipcode MEDIUMINT(5) UNSIGNED NOT NULL,
	shipping_days INT NOT NULL,
	status VARCHAR(20),
	vehicle_id INT REFERENCES vehicle(vehicle_id)
);

CREATE TABLE package(
	package_id INT NOT NULL PRIMARY KEY,
	weight_class VARCHAR(20) REFERENCES package_weight(weight_class),
	package_type VARCHAR(20) REFERENCES package_class(package_type),
	hazardous BOOLEAN DEFAULT false,
	tracking_id INT REFERENCES tracking(tracking_id)
);

CREATE TABLE location_log(
	package_id INT REFERENCES package(package_id),
	location_id INT REFERENCES station(location_id)
);