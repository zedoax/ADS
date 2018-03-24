-- creates the role for user
CREATE ROLE user;

-- creates role for trackers
CREATE ROLE tracker;

-- creates role for employee
CREATE ROLE member;

-- gives all tracking privileges to user
GRANT tracker TO member

-- gives user read and update privileges
GRANT READ, UPDATE
ON u_account_v
TO member;

-- Gives customer read and insert privileges on u_package_v
GRANT READ, INSERT
ON u_package_v
TO member;

-- gives tracker read permissions on location_log_v
GRANT READ
ON location_log_v
TO tracker;

GRANT READ
ON package_tracking_v
TO tracker;

GRANT READ
ON e_account_v
TO employee;

GRANT READ, INSERT
ON station
TO employee;

GRANT READ, INSERT
ON vehicle
TO employee;

GRANT READ, INSERT
ON location_log_v
TO employee;

GRANT UPDATE
ON package_db(truck_id)
TO employee;

GRANT UPDATE
ON truck(origin_id, destination_id)
TO employee;





