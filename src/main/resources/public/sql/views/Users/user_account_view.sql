create view u_account_v as
select username, first_name, last_name, password
address_number, adress_street, address_city, address_zipcode
from account;