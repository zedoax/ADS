-- This is a script to populate the package database
-- package entries are in the following format:
-- package(package_id, weight_class, package_type, hazardous, tracking_id, username)
-- package(id, varchar(20), varchar(20), boolean, id, varchar(20))

insert into package_db VALUES
(8594557493867543547475836, '0- 5', 'flat', 0, 3875987432530000000055344, 'cGrimes'),
(9999557493867543547475836, '0- 5', 'flat', 0, 9348436076935476393474123, 'cGrimes'),
(8888557493867543547475836, '0- 5', 'flat', 0, 4375986327487294875873544, 'SaraJones'),
(0101557493867543547475836, '35+', 'flat', 0, 8373950832489786503832283, 'SaraJones'),
(4866057749386754725747583, '35+', 'flat', 0, 3275894385088340925849855, 'Rocky98'),
(4866059384729384425747583, '35+', 'flat', 0, 8935320349852974920289472, 'Rocky98'),
(0938402284729384425747583, '35+', 'flat', 0, 4987598432759760303984944, 'scrapSpy'),
(4866753287482734987324897, '5 - 10', 'flat', 0, 3875093475987432098598545, 'Boscul83'),
(4866938484129384425058345, '5 - 10', 'large box', 0, 8947305498756383049898275, 'Boscul83'),
(5367892030934898723092834, '5 - 10', 'large box', 0, 4850325480935054609842322, 'vasCope'),
(0987678902159212432623123, '10 - 20', 'large box', 0, 0192748837243625873621746, 'vasCope'),
(9927378364787498734826748, '10 - 20', 'large box', 1, 8973247846259878231734808, 'Spiderman'),
(8372148972348789743298317, '10 - 20', 'envelope', 1, 3098127430918590684597443, 'KingMoney'),
(3817498372198743103458764, '20 - 35', 'envelope', 1, 6738091243987432590105483, 'BipsTheFool'),
(8372478261237632784922284, '20 - 35', 'envelope', 1, 8375905496098957898567736, 'AtTheFaceAtTheFace'),
(6387618732647826310327499, '20 - 35', 'envelope', 1, 8888484847758758595037378, 'PinaBanana'),
(9843270932480984324398329, '20 - 35', 'envelope', 1, 5364747837474839383748902, 'IntoTheToaster'),
(4372023948209143809325022, '20 - 35', 'small box', 1, 4890393939292887240320393, 'MJ'),
(4756349937219847202458769, '20 - 35', 'small box', 1, 3248798374747471747281010, 'MJ'),
(8970329374217643783228243, '35+', 'small box', 1, 9102438981734981273489234, 'Wilmist'),
(2102938471029474923920275, '35+', 'large box', 1, 2374898273648762173874312, 'DJBoony'),
(2303207804886755278087927, '10 - 20','flat',0,3929669420480068599262554,'glados'),
(5850112913802181032856218, '10 - 20','flat',0,9324851292897624414461545,'scholarshipmoney'),
(8974190496805996643034462, '10 - 20','flat',0,7347883491460014356476542,'nfsaw'),
(5502699421154201966413753, '10 - 20','flat',0,2549442260157216857815030,'nHesner'),
(1419797538584566135030026, '0- 5','flat',0,8986121399828061778841961,'Redherring'),
(2775207081421121730679233, '0- 5','flat',0,6210459418003534531928409,'wendys'),
(9122023406288949796527089, '0- 5','flat',0,8449662223949308901672217,'JustinS'),
(7386344257099356257315083, '0- 5','flat',0,7082701726297180191446179,'rEnser'),
(0911810441176807309088170, '20 - 35','flat',0,1150165146206382183670113,'Neunsa'),
(7450428460667374153422392, '35+','flat',0,8565245901270432862911195,'pawsSer'),
(3022482841703457508972030, '35+','flat',0,0390209777144165681445750,'Bunbunny'),
(7950118889724234106314526, '35+','flat',0,4919676788131343618075682,'Brasshopper'),
(3252920182071420090184943, '0- 5','flat',0,4547255945355550824451512,'dessertTime'),
(2366343999376555556360187, '0- 5','flat',0,6834011452608408671496600,'TimeShark'),
(5308422473286549548825254, '0- 5','flat',0,9012238836942464720258268,'GuineaPiglet'),
(9574180209851258875019190, '0- 5','flat',0,7704914996341812765307981,'WorthyGhost'),
(5184325720069717361192120, '5 - 10','flat',0,0084034526738771539068128,'demonster'),
(0525423946003974272833232, '5 - 10','flat',0,8885384366106762154216241,'demonster'),
(3635158692849443914962208, '0- 5','flat',1,5328686285082311486927200,'demonster'),
(0737756803256561231574553, '0- 5','flat',1,0317438774342353240345161,'Dwarvoe'),
(4997997161013842106904553, '0- 5','flat',1,3303726317927904159632159,'nHeofer'),
(8065639135632663836944474, '10 - 20','large box',1,8161383585212063935769410,'nHeofer'),
(7541460394471365338208875, '10 - 20','large box',1,7082904642870710725528513,'conjursa'),
(3425452341828858180287298, '10 - 20','large box',1,7773236828873365860698671,'Neoid'),
(1644089937465511769306546, '35+','large box',1,6456501891684030893369409,'Pelicandy'),
(6885109848053488421799433, '35+','large box',1,3294593148825244557007415,'MerryImmortal'),
(2737860847690896376623339, '35+','large box',1,2368042638215895822081398,'SpringThief'),
(4376419783752448561509602, '0- 5','large box',1,3276941172987031570298539,'Neams'),
(3721352155761075034786930, '0- 5','large box',1,8886031178347184450778023,'Salamantix'),
(7554897267659185002672289, '35+','large box',0,9495047416723739641659809,'Salamantix'),
(9023687877191696317748825, '35+','large box',0,0801416082327041865613300,'Salamantix'),
(2238047606458385594045480, '20 - 35','large box',0,7532210169790894069198241,'JustinS'),
(0696614525044229068813667, '20 - 35','large box',0,0387236183335345808227849,'Sealixir'),
(6297770923148101703033634, '20 - 35','large box',0,4993496679576875675164638,'cowhale'),
(7293120982827129140322669, '0- 5','large box',0,7290063419623460320573897,'IKnewIt'),
(2478268259343234316419621, '0- 5','large box',0,5570600495917983530117961,'WorthyGhost'),
(2770251019434715086930702, '20 - 35','large box',0,1677449613009076584336144,'Smorh'),
(3646756986474023112172730, '20 - 35','large box',0,8587960011593891094672161,'Toad'),
(6012392036002846010185379, '35+','large box',0,7132536964318599996497543,'nHeofer'),
(0350661311739673422362457, '35+','large box',0,1422111550253292895013129,'GuineaPiglet'),
(3483152854199103968879563, '20 - 35','large box',0,5768532976793078064410484,'MerryImmortal'),
(9910387602134758407091811, '0- 5','envelope',0,0907971299341388718175761,'SpringThief'),
(5448252127860579775240872, '0- 5','envelope',0,0001225926935450288102749,'GamerMan'),
(5525646301888368193493001, '35+','envelope',0,8027498638356171674703877,'GamerMan'),
(1935991474050713990193422, '35+','envelope',0,6747289760527376276607137,'dessertTime'),
(9119305211520177112894115, '35+','envelope',0,2489327801682382427146735,'NightMelon'),
(6722826375172571098384116, '35+','envelope',1,5107231238756009690332338,'goblinman'),
(1801361261814613658901281, '35+','envelope',1,4352783307212781045047727,'alligators'),
(3909902666553875312733193, '0- 5','envelope',1,2551032966915113622852872,'ohno'),
(6642135816952230973554851, '20 - 35','envelope',1,7482294472009246267368311,'Salamantix'),
(9467395254743483133429367, '20 - 35','envelope',1,4664667017702929911907713,'Lkjfs'),
(3282782283864311641866942, '20 - 35','envelope',1,1731513123796994153209937,'warkawk'),
(9333470305537296353426923, '20 - 35','envelope',1,1145064580134303744636824,'Lkjfs'),
(1671102151264163605009361, '20 - 35','envelope',1,2592958613131086534486922,'alligators'),
(8102988513364962503480897, '20 - 35','envelope',1,0378748140927030895963733,'MicaK'),
(8372871219562786767658623, '20 - 35','envelope',0,0567812923380275171520758,'sCassidy'),
(9903825770683433003139543, '20 - 35','envelope',0,1667300923442892668386916,'Dwarvoe'),
(2506081839058907467822253, '10 - 20','envelope',0,6629717973095534785757772,'nHesner'),
(1407986443057551572644147, '10 - 20','envelope',0,5280138337888692967324784,'ripToysrUs'),
(6343259789614103847679592, '10 - 20','small box',0,0221012879502797929763627,'ripToysrUs'),
(7061574611482881528339690, '10 - 20','small box',0,3924026845667421005473972,'ripToysrUs'),
(1040777333328492390288541, '10 - 20','small box',0,6912419802485142621155275,'ripToysrUs'),
(5675517774737331054139214, '10 - 20','small box',1,8534308691297140844558541,'ripToysrUs'),
(5640004533952660470277823, '10 - 20','small box',1,7605138576703301186981757,),
(5631613092797431442589202, '35+','small box',1,0788322987403036934694716,'MicaK'),
(2784611701550638381556902, '35+','small box',1,1319224609856666750673662,'bigapple'),
(6688539113152264448106679, '0- 5','small box',1,0845627020619933847107145,'pawsSer'),
(8949779583648125676292750, '0- 5','small box',1,2224252126329843350250619,'Emufassa'),
(4289049488705804109152063, '0- 5','small box',1,9152119664142175524837769,'Emufassa');