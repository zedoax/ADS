CREATE USER member PASSWORD 'password';
GRANT SELECT ON account, contract_member, non_contract_member,
  payment, package_weight, package_class, package, tracking
    TO member;
GRANT INSERT ON package, tracking TO member;
GRANT UPDATE  ON account, payment, package, tracking TO member;

CREATE USER memberadd PASSWORD 'password';
GRANT INSERT ON account, non_contract_member TO memberadd;

CREATE USER tracker PASSWORD 'password';
GRANT SELECT ON package, location_log, tracking,
  vehicle, station, package_class, package_weight TO tracker;

CREATE USER employee PASSWORD 'password';
GRANT ALL ON account, contract_member, non_contract_member,
payment, package_weight, package_class, package, tracking, location_log,
   vehicle, station TO employee;