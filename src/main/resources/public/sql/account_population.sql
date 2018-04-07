-- This is a script to populate the account database
-- Account entries are in the following format:
-- account(username, password, session_token, first_name, last_name, address_number, address_number, address_city, address_zipcode, profile_url, credit_card_number, credit_card_exp)
-- account(varchar(20), varchar(64), varchar(25), varchar(20), varchar(20), integer, varchar(40), varchar(20), zipcode(minval 00000, maxval 99999))

insert into account VALUES
('cGrimes', 'eVERyoneOPPOSITEPREPAREDdAmaSCUsIndicateBARbadosELEMENTS', 'a9dv3ujdew87h4g8lj2ghib4z', 'Carl', 'Grimes', 1, '1', 'Atlanta', 30301, 'http://runt-of-the-web.com/wordpress/wp-content/uploads/2016/04/wtf-pictures-1.jpg' , null, null),
('kGrimes', 'Password', null, 'Rick', 'Grimes', 1, '1', 'Atlanta', 30301, null, null),
('SaraJones', 'atTheWorld', 'b2dv3uvdew87g4g8lj2ghob4z', 'Sara', 'Jones', 1682, '1682', 'Keeseville', 12944, null, 4849033379487133, '1999-08-30'),
('Rocky98', 'ThisisAsecret9', null, 'Richie', 'Lamere', 129, '129', 'Plattsburgh', 12901, null, 4249033449487133, '1998-08-30'),
('scrapSpy', 'Password', 'c2dv3uvdew87g4g8lj2ghob4z', 'Scrappy', 'Doo', 8673, '8673' , 'Rochester',  14602, null, 4836865184064143, '2020-08-30'),
('RedRapter', 'Colidiscope5Book', null, 'Rooter', 'Derns', 9021, '9021', 'Ticonderoga', 12883, null, 4040410761801138, '2024-12-30'),
('Boscul83', 'HillyGreenzone', null, 'Gracie', 'Patenaude', 43, '43', 'Palo Alto', 94020, null, 4040410761801138, '2025-03-15'),
('vasCope', 'Uppittydown', 'd3dv3uvdew87g4g8lj2ghob4z', 'Clint', 'Loons', 24, '24', 'Round Rock', 78664, null, 4711861702955607, '2008-01-30'),
('Groot', 'rooLjdscne', null, 'Grim', 'Rooj', 782, '782', 'Syracuse', 78664, null, null, null),
('Spiderman', 'homeComingSpider', null, 'Peter', 'Parker', 98, '98', 'Jersey', 07030, null, null),
('MJ', 'Watsabulb7', 'e4dv3uvdew87g4g8lj2ghob4z', 'Mary', 'Jane', 99, '99', 'Jersey', 07030, null, 4711861702955607, '2034-11-15'),
('KingMoney', 'GoldPufferfish', null, 'Michael', 'Mills', 24, '24', 'Albany', 12084, null, null, null),
('DJBoony', 'Collegeis4Lames', null, 'Clara', 'Meyer', 6780, '6780', 'Albany', 12208, null, null, null),
('EmsMaster','Huckle9Fin', null, 'Michael', 'Weller', 982, '982', 'Seattle', 98101, null, 4260829515790235, '2004-01-15'),
('Arrrtz', 'enememy', null, 'Deryn', 'Makowski', 7762, '7762', 'Plattsburgh', 12901, null, 4813133419461957, '2001-12-10'),
('Wilmist', 'goggleIT', null, 'Will', 'Mosk', 7, '7', 'Plattsburgh', 12903, null, 4813133419461957, '2034-8-05'),
('BipsTheFool', 'CisforCobalt', null, 'Chris', 'Cauthorn', 342, '342', 'Los Angeles', 90001, null, 4788295671002760, '2028-08-30'),
('ThunderBolt84', 'CoinmiNting', null, 'Chris', 'Kelly', 976, '976', 'Peru', 12972, null, 4016390182452275, '2035-12-30'),
('AtTheFaceAtTheFace', 'NumberUnoDos3','f5dv3uvdew87g4g8lj2ghob4z', 'Nick', 'Abagis', 208, '208', 'Jersey', 07087, null, 4824889190502353, '1998-08-30'),
('PinaBanana', 'FruitsveggiesCars', null, 'Trudy', 'Berns', 8643, '8643', 'Austin', 73301, null, 4583762809297551, '2035-08-30'),
('IntoTheToaster', 'IfIWEREAPOPTART', null, 'Poppy', 'Popes', 75, '75', 'Denver', 80224, null, null),
-- bBurns unhashed password = oliveoil
('bBurns', 'YkJ1cm5zOm9saXZlb2ls', null, 'Bob', 'Burns', 352, 'Rosewell', 'Rochester', 39284, null, null, null),
-- password = working
('Smorh', 'U21vcmg6d29ya2luZw==', null, 'Sam', 'Emlaas', 24, 'Canterbury Ln', 'Aurora', 42521, null, null, null),
-- password = sdfnl34
('Neams', 'TmVhbXM6c2RmbmwzNA==', null, 'Neville', 'Baxter', 465, 'Smith Rd', 'Clarence', 14031, null, 123123568421538, '2014-05-20'),
-- password = toytime
('Toad', 'VG9hZDp0b3l0aW1l', null, 'Todd', 'Smith', 4905, 'Johnson Rd', 'Albany', 12208, null, null, null),
-- pwd: datatypes
('lHenderson', 'bEhlbmRlcnNvbjpkYXRhdHlwZXM=', null, 'Laura', 'Henderson', 4953, 'Shimmerville Rd', 'Williamsville', 13042, null, null, null),
-- threegiftcards
('nHeofer', 'bkhlb2Zlcjp0aHJlZWdpZnRjYXJkcw==', null, 'Nellie', 'Heofer', 3943, 'Circle Dr', 'Williamsville', 13042, null, null, null),
-- thatsIt3
('JenTen', 'SmVuVGVuOnRoYXRzSXQz', null, 'Jennifer', 'Smith', 942, 'Johnson Rd', 'Austin', 10493, null, null, null),
-- password: grocerySt0re
('IKnewIt', 'SUtuZXdJdDpncm9jZXJ5U3QwcmU=',
-- freeTeeShirt
('Cubeast', 'Q3ViZWFzdDpmcmVlVGVlU2hpcnQ=', )
('GuineaPiglet')
('Pelicandy')
('SpringThief')
('MerryImmortal')
('JTerry')
('Ssmithh')
('sSmith')
('Dolphine')
('Mosquitar')
('WorthyGhost')
('TimeShark')
('GamerMan')
('conjursa')
('FastSpecter')
('chicken')
('dessertTime')
('MelanieJ')
('Noel')
('asdfghj')
('Neoid')
('Brasshopper')
('ninjavu')
('bingod')
('NightMelon')
('sdfdsf')
('cowhale')
('Dismag')
('Spillager')
('lostCow')
('goblinman')
('troutlaw')
('Sealixir')
('mCather')
('audino')
('glados')
('noSQL')
('Lkjfs')
('Nead')
('Salamantix')
('Bunbunny')
('llama')
('demonster')
('Emufassa')
('lJones')
('sCassidy')
('MicaK')
('warkawk')
('Dwarvoe')
('Muskunk')
('muppet')
('scholarshipmoney')
('nfsaw')
('nHesner')
('kElroy')
('Meoif')
('ripToysrUs')
('ponlyon')
('Globster')
('woodpecker')
('Redherring')
('ohno')
('wendys')
('alligators')
('scorpions')
('rEnser')
('skoRs')
('JustinS')
('bigapple')
('Neunsa')
('pawsSer')
('jeffery')