use the_fish_shop_db;

-- all passwords have 123 added to the username(john - john123, admin - admin123)
call insertEmployeeWithDetails('John', 'Doe', 'Main st. 111, New York', 'john', '$2a$04$T83fgYSZH/Yf3KbpuiPixe.lAjUXqBreo.c6nyQ7TXkHXExIOt982', 'jonh123@foo.mail');
call insertEmployeeWithDetails('Jane', 'Doe', 'Elk st. 222, Anchorage', 'jane', '$2a$04$qUamQqiPmXYrQE5GfYC9cOs7/C3Umc3/QvjdY9R1pDuhe3Q7LT4MW', 'jane123@foo.mail');
call insertEmployeeWithDetails('Jack', 'Brown', 'Long st.333, Denver', 'jack', '$2a$04$ormy3tcvLZLh37ALquIDluLHjWfW4U851WFLwR8YjIJFAg9ZcKf6K', 'jack123@foo.mail');
call insertEmployeeWithDetails('Jill', 'Black', 'Short st. 444 89, Los Angeles', 'jill', '$2a$04$atk5Xn1Pw7sW6OMar1k5muzW7lYDsNF/O8UTiB7feD2FzkQeiCFse', 'jill123@foo.mail');

insert into users 
	values (null, 'pera', '$2a$04$PYt7kuG.KanclxLB/hjhtuelF7ksWWSuAZbKfP9PXG89f7yReBUw6', 'pera@foo.mail', null, 'ROLE_CUSTOMER'),
		(null, 'admin', '$2a$04$Qzs/CoH3Y36Tqmg/sHv4redqHtuKtDZgedv9Aq38FoNAG6S6fR7sy', 'admin@foo.mail', null, 'ROLE_ADMIN');

insert into products values
				-- fresh water fish --
		(null, 'Bolivian ram', 'Geophagus ramirezi', 'FW_FISH'),
		(null, 'Neon tetra', 'Paracheirodon innesi', 'FW_FISH'),
		(null, 'Kuhli loach', 'Pangio kuhlii', 'FW_FISH'),
		(null, 'Panda cory', 'Coridoras panda', 'FW_FISH'),
        		-- salt water fish --
        (null, 'Firefish', 'Nemateleotris magnifica', 'SW_FISH'),
        (null, 'Bicolor bleny', 'Ecsenius bicolor', 'SW_FISH'),
        (null, 'Coral beauty', 'Centropyge bispinosa', 'SW_FISH'),
        (null, 'Ocellaris clownfish', 'Amphiprion ocellaris', 'SW_FISH'),
				-- crabs --
        (null, 'Red claw crab', 'Perisesarma bidens', 'CRAB_FISH'),
        (null, 'Fiddler crab', 'Uca sp.', 'CRAB_FISH'),
        (null, 'Vampire crab', 'Geosesarma sp.', 'CRAB_FISH'),
        (null, 'Panther crab', 'Parathelphusa pantherina', 'CRAB_FISH'),
       				-- pond fish --
        (null, 'Koi', 'Cyprinus carpio haematopterus', 'P_FISH'),
        (null, 'Goldfish', 'Carassius auratus', 'P_FISH'),
		
				-- fresh water plant --
        (null, 'Java moss', 'Vesicularia dubyana', 'FW_PLANT'),
        (null, 'Rotala', 'Rotala rotundifolia', 'FW_PLANT'),
        (null, 'Jungle Val', 'Vallisneria americana', 'FW_PLANT'),
		(null, 'Amazon Sword', 'Echinodorus sp.', 'FW_PLANT'),
				-- pond plant --
		(null, 'Creeping Jenny', 'Lysimachia nummularia', 'P_PLANT'),
        (null, 'Pickerel', 'Pontederia cordata', 'P_PLANT'),
        (null, 'Water letuce', 'Pistia sp.', 'P_PLANT'),
        (null, 'Sweet flag', 'Acorus calamus', 'P_PLANT'),
				-- food --
		(null, 'Taio-aini', 'Universal fish food', 'FOOD'),
        (null, 'King British', 'Goldfish flake', 'FOOD'),
        (null, 'Csaka green-1', 'Koi food', 'FOOD'),
        (null, 'JBL Nova Tab', 'Tropical fish food', 'FOOD'),
       	(null, 'Vitalis aqua nutrition', 'Cichlid pelets', 'FOOD'),      
				-- tanks --
        (null, 'Fluval GH', '120l', 'TANK'),
        (null, 'Marineland Z90', '90l', 'TANK'),
        (null, 'NanoTank', '30l', 'TANK'),
        (null, 'AquaT', '10l', 'TANK'),
				-- filter --
		(null, 'Sun-Sun-China', 'HW304B', 'FILTER'),
        (null, 'Fluval FX6', 'FX6', 'FILTER'),
        (null, 'Pond Kingstar', 'over9000', 'FILTER'),
        (null, 'Fluval 406', '106-406', 'FILTER'),
       	(null, 'ChinaStar', 'FF89', 'FILTER'),      
				-- co2 --
		(null, 'Aquatic-co2', 'No description', 'CO2'),
        (null, 'China-chong', 'Ch0ng2', 'CO2'),
        (null, 'Generic Tablets', '40p', 'CO2'),
        (null, 'Zdixmatic 4', 'Carbonizer', 'CO2'),
       	(null, 'HangoN', 'Co2 monitor', 'CO2');   

set @id1 = (select products.id from products where products.title = 'Bolivian ram');
set @id2 = (select products.id from products where products.title = 'Neon tetra');
set @id3 = (select products.id from products where products.title = 'Kuhli loach');
set @id4 = (select products.id from products where products.title = 'Panda cory');
set @id5 = (select products.id from products where products.title = 'Firefish');
set @id6 = (select products.id from products where products.title = 'Bicolor bleny');
set @id7 = (select products.id from products where products.title = 'Coral beauty');
set @id8 = (select products.id from products where products.title = 'Ocellaris clownfish');
set @id9 = (select products.id from products where products.title = 'Red claw crab');
set @id10 = (select products.id from products where products.title = 'Fiddler crab');
set @id11 = (select products.id from products where products.title = 'Vampire crab');
set @id12 = (select products.id from products where products.title = 'Panther crab');
set @id13 = (select products.id from products where products.title = 'Koi');
set @id14 = (select products.id from products where products.title = 'Goldfish');
set @id15 = (select products.id from products where products.title = 'Java moss');
set @id16 = (select products.id from products where products.title = 'Rotala');
set @id17 = (select products.id from products where products.title = 'Jungle Val');
set @id18 = (select products.id from products where products.title = 'Amazon Sword');
set @id19 = (select products.id from products where products.title = 'Creeping Jenny');
set @id20 = (select products.id from products where products.title = 'Pickerel');
set @id21 = (select products.id from products where products.title = 'Water letuce');
set @id22 = (select products.id from products where products.title = 'Sweet flag');
set @id23 = (select products.id from products where products.title = 'Taio-aini');
set @id24 = (select products.id from products where products.title = 'King British');
set @id25 = (select products.id from products where products.title = 'Csaka green-1');
set @id26 = (select products.id from products where products.title = 'JBL Nova Tab');
set @id27 = (select products.id from products where products.title = 'Vitalis aqua nutrition');
set @id28 = (select products.id from products where products.title = 'Fluval GH');
set @id29 = (select products.id from products where products.title = 'Marineland Z90');
set @id30 = (select products.id from products where products.title = 'NanoTank');
set @id31 = (select products.id from products where products.title = 'AquaT');
set @id32 = (select products.id from products where products.title = 'Sun-Sun-China');
set @id33 = (select products.id from products where products.title = 'Fluval FX6');
set @id34 = (select products.id from products where products.title = 'Pond Kingstar');
set @id35 = (select products.id from products where products.description = '106-406');
set @id36 = (select products.id from products where products.title = 'ChinaStar');
set @id37 = (select products.id from products where products.title = 'Aquatic-co2');
set @id38 = (select products.id from products where products.title = 'China-chong');
set @id39 = (select products.id from products where products.title = 'Generic Tablets');
set @id40 = (select products.id from products where products.title = 'Zdixmatic 4');
set @id41 = (select products.id from products where products.title = 'HangoN');

insert into stock
	values(null, 3.4, 50,  now(), @id1),
		  (null, 1.25, 400, now(), @id2),
		  (null, 1.99, 50,  now(), @id3),
		  (null, 1.75, 50,  now(), @id4),
          (null, 3.25, 50,  now(), @id5),
          (null, 4.2, 50,  now(), @id6),
          (null, 3.9, 50,  now(), @id7),
	      (null, 3.9, 50,  now(), @id8),
          (null, 3.3, 50,  now(), @id9),
          (null, 3.9, 50,  now(), @id10),
          (null, 7.5, 50,  now(), @id11),
          (null, 24.9, 50,  now(), @id12),
          (null, 14.9, 50,  now(), @id13),
          (null, 5.0, 50,  now(), @id14),
          (null, 0.9, 50,  now(), @id15),
          (null, 2.1, 50,  now(), @id16),
          (null, 1.7, 50,  now(), @id17),
          (null, 1.9, 50,  now(), @id18),
          (null, 11.0, 50,  now(), @id19),
          (null, 8.0, 50,  now(), @id20),
          (null, 9.0, 50,  now(), @id21),
          (null, 7.5, 50,  now(), @id22),
          (null, 2.5, 50,  now(), @id23),
          (null, 4.0, 50,  now(), @id24),
          (null, 5.5, 50,  now(), @id25),
          (null, 2.75, 50,  now(), @id26),
          (null, 6.0, 50,  now(), @id27),
          (null, 180.0, 50,  now(), @id28),
          (null, 145.0, 50,  now(), @id29),
          (null, 35.5, 50,  now(), @id30),
          (null, 45.5, 50,  now(), @id31),
          (null, 89.9, 50,  now(), @id32),
          (null, 150.0, 50,  now(), @id33),
		  (null, 1500.0, 50,  now(), @id34),
          (null, 120.0, 50,  now(), @id35),
          (null, 95.00, 50,  now(), @id36),
          (null, 17.0, 50,  now(), @id37),
          (null, 21.9, 50,  now(), @id38),
          (null, 4.5, 50,  now(), @id39),
          (null, 15.5, 50,  now(), @id40),
          (null, 12.0, 50,  now(), @id41);
         