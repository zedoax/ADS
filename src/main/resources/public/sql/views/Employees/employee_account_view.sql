create view e_account_v as
select username, first_name, last_name,
address_number, adress_street, address_city, address_zipcode
from account;

create view e_package_v as
select username, first_name, last_name,
address_number, adress_street, address_city, address_zipcode
from account;


