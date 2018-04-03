-- This is a script to populate the contract_member database
-- contract_member entries are in the following format:
-- contract_member(member_id, cycle_start, cycle_bill, username)
-- contract_member(id, date, price, varchar(20)) -> id = integer with 25 sig figs

insert into contract_member VALUES
(8910743192238459123999222, 2018-03-22, 2.00 , 'cGrimes'),
(9001743809143277816342834, 1998-09-24, 2.50, 'kGrimes'),
(8174132487981732498173243, 2000-12-01, 1.00, 'SaraJones'),
(9120743887562724324275655, 2006-02-07, 0.50, 'Rocky98'),
(2143814798342147398443294, 2006-01-07, 4.00, 'scrapSpy'),
(9871432784913798430798432, 2005-10-16, 100.59, 'RedRapter'),
(8274910743290832842190344, 2010-06-25, 63.11, 'Boscul83'),
(0917438109741092748213560, 2002-04-13, 54.99, 'vasCope'),
(0981264810823498732163495, 2003-08-22, 101.42, 'Groot'),
(3864971826340918732424311, 2001-02-11, 23.40, 'Spiderman'),
(1201213412354425463212434, 1956-03-11, 10.98, 'MJ');
