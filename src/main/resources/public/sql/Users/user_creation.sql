CREATE USER 'member' PASSWORD 'password';
GRANT SELECT ON 'account', 'contract_member', 'non_contract_member',
  'payment', 'package_weight', 'package_class', 'package_db', 'tracking_db'
    TO 'member';
GRANT INSERT ON 'package_db', 'tracking_db' TO 'member';
GRANT UPDATE  ON 'account', 'payment', 'package_db', 'tracking_db' TO 'member';

CREATE USER 'memberadd' PASSWORD 'password';
GRANT INSERT ON 'account', 'non_contract_member';

CREATE USER 'tracking' PASSWORD 'password';
GRANT SELECT ON 'package_db', 'location_log', 'tracking_db',
  'vehicle', 'station' TO 'tracking';

CREATE USER 'employee' PASSWORD 'password';
GRANT ALL ON * TO 'employee';