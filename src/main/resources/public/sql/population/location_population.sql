-- This is a script to populate the location database
-- location_log entries are in the following format:
-- location_log(package_id, location_id, tracking_id)
-- location_log(id, id, time, date, id)

insert into location_log VALUES
(859455749386754354, 327486917324648247, parsedatetime('13:30','HH:mm'), parsedatetime('2018-01-01','yyyy-MM-dd') ,387598743253000000),
(999955749386754354, 873249817324981734, parsedatetime('2:50','HH:mm'), parsedatetime('2018-02-10','yyyy-MM-dd') ,934843607693547639),
(888855749386754354, 463938454494926374, parsedatetime('2:50','HH:mm'),  parsedatetime('2018-02-10','yyyy-MM-dd') ,437598632748729487),
(010155749386754354, 848537484648484747, parsedatetime('11:30','HH:mm'),  parsedatetime('2018-02-10','yyyy-MM-dd') ,837395083248978650),
(486605774938675472, 363639308726163535, parsedatetime('11:30','HH:mm'),  parsedatetime('2018-02-10','yyyy-MM-dd') ,327589438508834092),
(486605938472938442, 930393993937454563, parsedatetime('12:55','HH:mm'),  parsedatetime('2018-02-20','yyyy-MM-dd') ,893532034985297492),
(093840228472938442, 957575858324903030, parsedatetime('12:55', 'HH:mm'), parsedatetime('2018-03-11','yyyy-MM-dd') ,498759843275976030),
(486675328748273498, 985294204030003939, parsedatetime('11:00','HH:mm'),  parsedatetime('2018-01-20','yyyy-MM-dd') ,387509347598743209),
(486693848412938442, 020302103981203930, parsedatetime('11:00','HH:mm'),  parsedatetime('2018-01-20','yyyy-MM-dd') ,894730549875638304),
(536789203093489872, 219389739829101028, parsedatetime('11:00','HH:mm'),  parsedatetime('2018-01-20','yyyy-MM-dd') ,485032548093505460),
(098767890215921243, 129812493938474949, parsedatetime('12:30', 'HH:mm'), parsedatetime('2018-02-25','yyyy-MM-dd') ,019274883724362587),
(992737836478749873, 023948012748474774, parsedatetime('14:00','HH:mm'),  parsedatetime('2018-04-01','yyyy-MM-dd') ,897324784625987823),
(837214897234878974, 320417328479237198, parsedatetime('12:00', 'HH:mm'), parsedatetime('2017-12-20' ,'yyyy-MM-dd') ,309812743091859068),
(381749837219874310, 231786401473737374, parsedatetime('12:30','HH:mm'),  parsedatetime('2017-12-25','yyyy-MM-dd') ,673809124398743259),
(837247826123763278, 398309843201032842, parsedatetime('4:50', 'HH:mm'), parsedatetime('2018-01-23','yyyy-MM-dd') ,837590549609895789),
(638761873264782631, 120487498712379404, parsedatetime('5:20','HH:mm'),  parsedatetime('2018-03-04','yyyy-MM-dd') ,888848484775875859),
(984327093248098432, 234984098109248743, parsedatetime('3:34', 'HH:mm'), parsedatetime('2017-03-29','yyyy-MM-dd') ,536474783747483938),
(437202394820914380, 321409832409120484, parsedatetime('4:40', 'HH:mm'), parsedatetime('2018-03-10','yyyy-MM-dd') ,489039393929288724),
(475634993721984720, 234893201030484849, parsedatetime('11:25', 'HH:mm'), parsedatetime('2018-02-02','yyyy-MM-dd') ,324879837474747174),
(897032937421764378, 099987656787980887, parsedatetime('11:30', 'HH:mm'), parsedatetime('2018-02-03','yyyy-MM-dd') ,910243898173498127),
(210293847102947492, 987654345678909987, parsedatetime('11:45', 'HH:mm'), parsedatetime('2018-03-03','yyyy-MM-dd') ,237489827364876217);