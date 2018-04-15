-- This is a script to populate the tracking database
-- payment entries are in the following format:
-- tracking(tracking_id, destination_number, destination_street, destination_city, destination_zipcode, shipping_days, status, vehicle_id)
-- tracking(id, integer, varchar(40), varchar(20), zipcode(minval 00000, maxval 99999), shipping_type, status, vehicle_id)

insert into tracking VALUES
(387598743253000000, 24, 'St John Street', 'Grosse Pointe', 48236, 1, 'delivered', 098645755765765813),
(934843607693547639, 5632, 'Rugar Street', 'Klamath Falls', 97603, 4, 'transit', 987654324355234352),
(437598632748729487, 3452, 'Elm Street', 'Lemont', 60439, 1, 'transit', 783568756576567546),
(837395083248978650, 23, 'Lopple Street', 'Miami', 33056, 5, 'transit', 783568756576567546),
(327589438508834092, 5432, 'Nowehere Street', 'Royersford', 19468, 7, 'transit', 432645768707645324),
(893532034985297492, 4535, 'Looker Street', 'Riverdale', 30274, 6, 'destroyed', 325546456775986743),
(498759843275976030, 4326, 'Hoop Street', 'Atlantic City', 08401, 2, 'transit', 398437832984329845),
(387509347598743209, 2, 'Five Street', 'Delaware', 43015, 9, 'transit',  324576896546757656),
(894730549875638304, 2134, 'Ninity Street', 'Adrian', 49221, 4, 'transit',  324576896546757656),
(485032548093505460, 577, 'Trinity Street', 'Wethersfield', 06109, -1, 'late', 231543565857685453),
(019274883724362587, 333, 'Womp Street', 'West Deptford', 08096, 3, 'transit', 231543565857685453),
(897324784625987823, 222, 'Oof Street', 'Omaha', 68107, 4, 'transit', 214325453464577696),
(309812743091859068, 435, 'Birch Street', 'Wheaton', 60187, 7, 'transit', 987654324355234352),
(673809124398743259, 435, 'Birch Street', 'Wheaton',60187, 2, 'delivered', 231543565857685453),
(837590549609895789, 43, 'Lego Street', 'Florence', 29501, 1, 'transit', 214325453464577696),
(888848484775875859, 324, 'Tom Street', 'Manassas', 20109, 5, 'transit', 456577876565674564),
(536474783747483938, 234, 'Steet Street', 'Astoria', 11102, 3, 'delivered', 214325453464577696),
(489039393929288724, 675, 'Goggle Street', 'Astoria', 11102, 1, 'transit', 432645768707645324),
(324879837474747174, 1234, 'Upper Street', 'Astoria', 11102, -6, 'lost', 456577876565674564),
(910243898173498127, 123, 'Hello Street', 'Astoria', 11102, 7, 'transit', 231543565857685453),
(237489827364876217, 4444, 'Jacob Street', 'Astoria', 11102, 7, 'transit', 213414344343443556),
(392966942048006859,43,'Street Road','Glendale Heights',60139,3,'delivered',305721538986038873),
(932485129289762441,855,'Front Street North','Colorado Springs',80911,3,'delivered',098645755765765813),
(734788349146001435,6322,'Bridle Lane','Stillwater',55082,3,'delivered',098645755765765813),
(254944226015721685,9432,'Fulton Street','Virginia Beach',23451,3,'delivered',325546456775986743),
(898612139982806177,533,'Cottage Street','Clarksburg',26301,3,'delivered',325546456775986743),
(621045941800353453,90,'8th Street','Powell',37849,3,'delivered',325546456775986743),
(844966222394930890,332,'Catherine Street','Maplewood',07040,3,'delivered',214325453464577696),
(708270172629718019,342,'4th Street West','Cary',27511,3,'delivered',214325453464577696),
(115016514620638218,7255,'Pin Oak Drive','Middle Village',11379,3,'delivered',214325453464577696),
(856524590127043286,13,'Route 9','Zionsville',46077,7,'delivered',456577876565674564),
(039020977714416568,31,'Amherst Street','Cheshire',06410,7,'delivered',456577876565674564),
(491967678813134361,73,'Woodland Drive','Sterling Heights',48310 ,7,'delivered',456577876565674564),
(454725594535555082,36,'Valley Road','Mason',45040,7,'delivered',213414344343443556),
(683401145260840867,634,'Walnut Avenue','Basking Ridge',07920,7,'delivered',213414344343443556),
(901223883694246472,6222,'Orchard Street','Watertown',02472,7,'delivered',213414344343443556),
(770491499634181276,43,'State Street East','Springboro',45066,7,'delivered',214325453464577696),
(008403452673877153,9835,'Marshall Street','Lockport',14094,7,'delivered',214325453464577696),
(888538436610676215,546,'Tanglewood Drive','Centereach',11720,7,'delivered',214325453464577696),
(532868628508231148,84,'Vine Street','Shepherdsville',40165,2,'delivered',214325453464577696),
(031743877434235324,44,'3rd Street North','Tuckerton',08087,2,'delivered',783568756576567546),
(330372631792790415,4,'Division Street','Circle Pines',55014,2,'delivered',783568756576567546),
(816138358521206393,1,'Walnut Avenue','South Ozone Park',11420,2,'delivered',783568756576567546),
(708290464287071072,3,'Church Street South','Manassas',20109,2,'delivered',783568756576567546),
(777323682887336586,5,'Canterbury Road','West Roxbury',02132,-6,'lost',783568756576567546),
(645650189168403089,6,'Country Club Drive','Jamaica',11432,-6,'lost',783568756576567546),
(329459314882524455,435,'Maple Avenue','Central Islip',11722,-10,'lost',783568756576567546),
(236804263821589582,522,'Mulberry Street','Southington',06489,-6,'lost',783568756576567546),
(327694117298703157,743,'Hickory Street','Salisbury',21801,-6,'lost',783568756576567546),
(888603117834718445,3211,'Main Street East','Fenton',48430,-6,'lost',783568756576567546),
(949504741672373964,8642,'Lincoln Street','Portsmouth',23703,-6,'lost',783568756576567546),
(080141608232704186,4543,'Woodland Road','Murrells Inlet',29576,-6,'lost',783568756576567546),
(753221016979089406,444,'Route 44','Madison',35758,-2,'late',325546456775986743),
(038723618333534580,3352,'Route 27','Bellmore',35758,-5,'lost',325546456775986743),
(499349667957687567,756,'Grove Avenue','Parsippany',11710,-6,'lost',325546456775986743),
(729006341962346032,70,'Bank Street','Winchester',07054,2,'transit',325546456775986743),
(557060049591798353,7,'Crescent Street','Capitol Heights',22601,2,'transit',325546456775986743),
(167744961300907658,6,'Hilltop Road','Redondo Beach',20743,1,'transit',398437832984329845),
(858796001159389109,345,'Parker Street','Anaheim',90278,1,'transit',398437832984329845),
(713253696431859999,85,'Cross Street','Bedford',92806,1,'transit',398437832984329845),
(142211155025329289,3247,'Lexington Court','Dubuque',44146,1,'transit',398437832984329845),
(576853297679307806,854,'Creek Road','Cherry Hill',52001,1,'transit',398437832984329845),
(090797129934138871,284,'Ridge Avenue','Grand Blanc',08003,1,'transit',398437832984329845),
(000122592693545028,574,'Walnut Street','Orlando',48439,1,'transit',398437832984329845),
(802749863835617167,395,'Fawn Lane','Minneapolis',32806,5,'transit',987654324355234352),
(674728976052737627,5643,'3rd Street East','Oak Forest',55406,5,'transit',987654324355234352),
(248932780168238242,5634,'Route 6','Port Saint Lucie',60452,5,'transit',987654324355234352),
(510723123875600969,45,'Holly Drive','Cantonment',34952,5,'transit',987654324355234352),
(435278330721278104,4264,'Highland Avenue','Hillsborough',32533,5,'transit',987654324355234352),
(255103296691511362,5623,'Woodland Avenue','Rosemount',08844,5,'transit',987654324355234352),
(748229447200924626,6234,'B Street','Berwyn',60402,5,'transit',987654324355234352),
(466466701770292991,4559,'Church Road','Colonial Heights',23834,5,'transit',987654324355234352),
(173151312379699415,3242,'Heritage Drive','Westmont',60559,5,'transit',214325453464577696),
(114506458013430374,5222,'Heritage Drive','Eastpointe',48021,3,'transit',214325453464577696),
(259295861313108653,4326,'Prospect Street','Glasgow',42141,3,'transit',214325453464577696),
(037874814092703089,764,'Brookside Drive','Huntington',11743,3,'transit',214325453464577696),
(056781292338027517,1854,'Magnolia Drive','Beltsville',20705,3,'transit',214325453464577696),
(166730092344289266,8785,'Pin Oak Drive','Pawtucket',02860,3,'transit',214325453464577696),
(662971797309553478,1844,'Route 9','Wethersfield',06109,3,'transit',214325453464577696),
(528013833788869296,1745,'Willow Avenue','Helena',59601,3,'transit',214325453464577696),
(022101287950279792,5746,'Beechwood Drive','Park Ridge',60068,3,'transit',214325453464577696),
(392402684566742100,444,'Meadow Lane','Lockport',14094,3,'transit',214325453464577696),
(691241980248514262,77,'8th Street','Land O Lakes',34639,3,'destroyed',214325453464577696),
(853430869129714084,33,'Fulton Street','Riverside',08075,5,'destroyed',214325453464577696),
(760513857670330118,7576,'Country Club Drive','Decatur',30030,5,'destroyed',432645768707645324),
(078832298740303693,324,'Hamilton Street','Decatur',07036,6,'destroyed',432645768707645324),
(131922460985666675,4324,'Ann Street','Linden',60110,6,'destroyed',432645768707645324),
(084562702061993384,5620,'Orchard Street','Carpentersville',33160,6,'destroyed',432645768707645324),
(222425212632984335,8900,'State Street East','North Miami Beach',78501,2,'destroyed',432645768707645324),
(915211966414217552,7677,'Marshall Street','Mcallen',43612,2,'destroyed',432645768707645324);