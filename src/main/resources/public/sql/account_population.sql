-- This is a script to populate the account database
-- Account entries are in the following format:
-- account(username, password, session_token, first_name, last_name, address_number, address_number, address_city, address_zipcode)
-- account(varchar(20), varchar(64), varchar(25), varchar(20), varchar(20), integer, varchar(40), varchar(20), zipcode(minval 00000, maxval 99999))

insert into account VALUES
('cGrimes', 'eVERyoneOPPOSITEPREPAREDdAmaSCUsIndicateBARbadosELEMENTS', 'a9dv3ujdew87h4g8lj2ghib4z', 'Carl', 'Grimes', 1, '1', 'Atlanta', 30301),
('kGrimes', 'Password', null, 'Rick', 'Grimes' 1, '1', 'Atlanta', 30301),
('SaraJones', 'atTheWorld', 'b2dv3uvdew87g4g8lj2ghob4z', 'Sara', 'Jones', 1682, '1682' 'Keeseville', 12944),
('Rocky98', 'ThisisAsecret9', null, 'Richie', 'Lamere', 129, '129', 'Plattsburgh', 12901),
('scrapSpy', 'Password', 'c2dv3uvdew87g4g8lj2ghob4z', 'Scrappy', 'Doo', 8673, '8673' , 'Rochester'  14602),
('RedRapter', 'Colidiscope5Book', null, 'Rooter', 'Derns', 9021, '9021', 'Ticonderoga', 12883),
('Boscul83', 'HillyGreenzone', null, 'Gracie', 'Patenaude', 43, '43', 'Palo Alto', 94020),
('vasCope', 'Uppittydown', 'd3dv3uvdew87g4g8lj2ghob4z', 'Clint', 'Loons', 24, '24', 'Round Rock', 78664),
('Groot', 'rooLjdscne', null, 'Grim', 'Rooj', 782, '782', 'Syracuse', 78664 ),
('Spiderman', 'homeComingSpider', null, 'Peter', 'Parker', 98, '98', 'Jersey', 07030),
('MJ', 'Watsabulb7', 'e4dv3uvdew87g4g8lj2ghob4z', 'Mary', 'Jane', 99, '99', 'Jersey', 07030),
('KingMoney', 'GoldPufferfish', null, 'Michael', 'Mills', 24, '24', 'Albany', 12084),
('DJBoony', 'Collegeis4Lames', null, 'Clara', 'Meyer', 6780, '6780', 'Albany', 12208),
('EmsMaster','Huckle9Fin', null, 'Michael', 'Weller', 982, '982', 'Seattle', 98101),
('Arrrtz', 'enememy', null, 'Deryn', 'Makowski', 7762, '7762', 'Plattsburgh', 12901)
('Wilmist', 'goggleIT', null, 'Will', 'Mosk', 7, '7', 'Plattsburgh', 12903),
('BipsTheFool', 'CisforCobalt', null, 'Chris', 'Cauthorn', 342, '342', 'Los Angeles', 90001),
('ThunderBolt84', 'CoinmiNting', null, 'Chris', 'Kelly', 976, '976', 'Peru', 12972),\
('AtTheFaceAtTheFace', 'NumberUnoDos3','f5dv3uvdew87g4g8lj2ghob4z', 'Nick', 'Abagis', 208, '208', 'Jersey', 07087)
('PinaBanana', 'FruitsveggiesCars', null, 'Trudy', 'Berns', 8643, '8643', 'Austin', 73301),
('IntoTheToaster', 'IfIWEREAPOPTART', null, 'Poppy', 'Popes', 75, '75', 'Denver', 80224);
