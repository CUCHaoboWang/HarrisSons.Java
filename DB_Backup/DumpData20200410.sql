-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: harrissonsdb.cewsoho8wmni.us-east-1.rds.amazonaws.com    Database: HarrisSonsDB
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ '';

--
-- Dumping data for table `__EFMigrationsHistory`
--

LOCK TABLES `__EFMigrationsHistory` WRITE;
/*!40000 ALTER TABLE `__EFMigrationsHistory` DISABLE KEYS */;
INSERT INTO `__EFMigrationsHistory` VALUES ('20200315210747_InitialCreate','3.1.1'),('20200326093024_DevTest1','3.1.1'),('20200410193703_DevTest2','3.1.1');
/*!40000 ALTER TABLE `__EFMigrationsHistory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tblAddress`
--

LOCK TABLES `tblAddress` WRITE;
/*!40000 ALTER TABLE `tblAddress` DISABLE KEYS */;
INSERT INTO `tblAddress` VALUES (1,'Suite 112','905 Huels Pike','Torpbury','Idaho','Buckinghamshire','99429-8406'),(2,'Apt. 709','58008 Kuhlman Island','West Adelle','Indiana','Avon','79489'),(3,'Suite 641','113 McCullough Summit','Hammeston','Colorado','Cambridgeshire','59756-8684'),(4,'Suite 434','13363 Ambrose Meadow','East Obie','Delaware','Avon','99170'),(5,'Suite 829','5156 Daugherty Lake','Camillamouth','Indiana','Borders','65852-3875'),(6,'Suite 593','0457 Fannie Springs','East Orionborough','Oklahoma','Avon','84632'),(7,'Apt. 593','5857 Ruth Vista','Harveyberg','South Dakota','Avon','13846'),(8,'Suite 967','048 Schuyler Port','North Peggie','Minnesota','Bedfordshire','86315-7710'),(9,'Apt. 428','04522 Keira Circles','Wehnerchester','Missouri','Borders','72786-0835'),(10,'Apt. 801','171 Henriette Flats','Lake Hildegard','Texas','Bedfordshire','33282-2321'),(11,'Suite 322','33546 Raynor Estate','Janiyaborough','Oregon','Borders','43044'),(12,'Apt. 934','609 Huels Points','Larkinville','Mississippi','Avon','48987'),(13,'Suite 395','777 Kessler Groves','New Dallasfurt','New Mexico','Borders','89443'),(14,'Apt. 484','1515 Langosh Pine','North Janice','Washington','Bedfordshire','22708-7683'),(15,'Apt. 619','8478 Teagan Mount','Lake Isaiasberg','Arkansas','Buckinghamshire','65108-7970'),(16,'Suite 073','2371 Eulalia Canyon','East Solonton','Colorado','Avon','47876'),(17,'Suite 176','0664 Blick Extensions','Zboncakshire','Montana','Cambridgeshire','95658'),(18,'Suite 037','18130 Moore Ford','Emardview','New York','Bedfordshire','55517'),(19,'Apt. 289','7510 Parisian Trail','Beattyton','Arkansas','Berkshire','98640'),(20,'Suite 483','08906 Jerry Forge','New Traceport','Mississippi','Bedfordshire','13822'),(21,'Suite 122','666 Spinka Estate','Loganbury','Alabama','Cambridgeshire','91042-6031'),(22,'Apt. 670','20201 Reynolds Freeway','South Jeweltown','Kansas','Cambridgeshire','83249-1208'),(23,'Suite 256','56817 Kaleb Point','Rogahnside','Virginia','Buckinghamshire','76743'),(24,'Apt. 246','587 Okuneva Locks','New Aliza','Wisconsin','Cambridgeshire','73975'),(25,'Apt. 602','03280 Aniyah Mill','Lockmanchester','Alaska','Bedfordshire','29052-7082'),(26,'Suite 035','15443 Bogan Port','Wendellview','Delaware','Cambridgeshire','80271'),(27,'Apt. 464','500 Chelsie Summit','Charlestown','Washington','Berkshire','86276'),(28,'Apt. 686','633 Winston Squares','Emmetfurt','North Carolina','Berkshire','26869-7991'),(29,'Apt. 940','1194 Doyle Stream','South Collin','Louisiana','Bedfordshire','46744-0918'),(30,'Apt. 143','753 Melvina Freeway','East Zack','Wisconsin','Buckinghamshire','78000'),(31,'Suite 663','3941 Cole Groves','Sawaynland','Idaho','Avon','24561'),(32,'Apt. 556','45591 Callie Causeway','Dominicton','California','Borders','28691-7262'),(33,'Suite 402','8794 Blanche Ranch','South Eleazarside','Hawaii','Buckinghamshire','92776-7708'),(34,'Apt. 539','533 Cole Circles','East Kaylahburgh','New Mexico','Buckinghamshire','91613'),(35,'Suite 520','605 Bruen Mills','Ortizberg','Alabama','Avon','26325'),(36,'Apt. 702','3547 Jaskolski Loop','Lupeland','Georgia','Berkshire','34927'),(37,'Suite 212','769 Huel Rapid','Ritchieborough','Texas','Avon','14016'),(38,'Apt. 710','502 Brown Hollow','Cooperfurt','New Jersey','Cambridgeshire','26091'),(39,'Suite 758','836 Eliezer Prairie','South Eddfort','Nevada','Bedfordshire','79786-4805'),(40,'Apt. 814','89359 Daniel Passage','Labadieborough','Mississippi','Bedfordshire','21386-8182'),(41,'Apt. 416','44201 Antwon Stravenue','Tristonchester','Tennessee','Borders','03821'),(42,'Apt. 705','35288 Fritsch Village','Huelsburgh','Oklahoma','Bedfordshire','14565-9576'),(43,'Suite 953','56131 Bartholome Hill','South Wilhelmchester','Nebraska','Berkshire','55463'),(44,'Suite 203','20462 Lincoln Coves','Pourosport','New Jersey','Borders','56011'),(45,'Apt. 339','687 Hamill Pines','Verdaberg','South Dakota','Bedfordshire','78310'),(46,'Apt. 590','06781 Leola Roads','Port Maude','Delaware','Borders','60878-7025'),(47,'Apt. 660','90116 Ellis Place','South Andrewburgh','Wisconsin','Bedfordshire','82307'),(48,'Apt. 184','3523 Quinten Square','South Wilsonfort','Pennsylvania','Avon','90948'),(49,'Apt. 845','87802 Kenyatta Loaf','Laceyland','Louisiana','Cambridgeshire','52619'),(50,'Suite 264','319 Paucek Alley','Schneiderland','Illinois','Avon','19514'),(51,'Suite 504','9139 Schaden Garden','Littelton','Utah','Berkshire','07530-8958'),(52,'Apt. 152','531 Kassulke Lane','Lake Brenda','Utah','Avon','27442'),(53,'Suite 730','69043 Nona Course','Mayerburgh','New Jersey','Avon','81448'),(54,'Suite 938','23839 Hane Forge','Jennieshire','New York','Cambridgeshire','30484'),(55,'Suite 044','0683 Robbie Center','Reichelview','Maryland','Avon','17433'),(56,'Apt. 069','68249 Runolfsdottir Isle','Port Russelchester','North Carolina','Avon','14369'),(57,'Suite 824','7592 Issac Viaduct','Port Percivalberg','Arkansas','Cambridgeshire','73226-6192'),(58,'Apt. 271','527 Greenholt Mill','South Janet','Florida','Borders','94477-5584'),(59,'Suite 088','78134 Nikko Loop','Nolaview','South Carolina','Buckinghamshire','97009'),(60,'Apt. 474','92679 Green Drives','Dantechester','Alabama','Berkshire','56099-3775'),(61,'Suite 797','94281 Kirlin Haven','East Barry','Ohio','Buckinghamshire','01763'),(62,'Apt. 547','51389 Schimmel Ridge','Botsfordmouth','Massachusetts','Avon','57457-8697'),(63,'Suite 606','5487 Americo Junction','Lake Jaredborough','Ohio','Cambridgeshire','23641'),(64,'Suite 555','31147 Jast Vista','Koelpinport','South Dakota','Buckinghamshire','96499-0319');
/*!40000 ALTER TABLE `tblAddress` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tblBusinessContact`
--

LOCK TABLES `tblBusinessContact` WRITE;
/*!40000 ALTER TABLE `tblBusinessContact` DISABLE KEYS */;
INSERT INTO `tblBusinessContact` VALUES (1,'Trystan28@hotmail.com','1-465-536-7559 x9571','966.885.7214',32),(2,'Sibyl.Senger67@yahoo.com','(316) 793-2961 x71600','872.499.2754',3),(3,'Ryleigh_Powlowski@hotmail.com','664-885-8659 x87886','1-505-544-8244 x1534',4),(4,'Davon_McLaughlin84@gmail.com','624.607.0058','1-841-340-3194 x0443',5),(5,'Arielle.Pacocha@gmail.com','1-438-897-0378 x29547','285-254-8950',6),(6,'Broderick.Schuppe@hotmail.com','449-985-2699 x302','(950) 205-7638',7),(7,'Hans_Hamill94@hotmail.com','275.659.8448 x156','841-785-7576',8),(8,'Leon.Nikolaus25@hotmail.com','(832) 244-4307','(760) 778-1687 x0385',9),(9,'Breanne.Stracke83@hotmail.com','335-727-3298','890.206.8887 x3476',10),(10,'Micah62@yahoo.com','1-864-902-5407','926-966-7020 x492',11),(11,'Caterina_Nikolaus3@hotmail.com','959-474-4080 x3703','(698) 509-2423 x936',12),(12,'Kobe.Quitzon15@hotmail.com','628-522-6217 x699','(787) 396-7926',13),(13,'Ayla24@hotmail.com','698.790.2168','(956) 403-4248',14),(14,'Amely_Kuphal19@gmail.com','245-307-1901 x3697','1-376-470-7739',15),(15,'Jovanny.Kub17@hotmail.com','1-815-637-9436','454-219-9199',16),(16,'Lina.Gleichner@yahoo.com','362-469-0736 x5868','574.423.3457',17),(17,'Derrick_Herman@gmail.com','217-326-4330 x81430','1-203-850-8288 x143',18),(18,'Marcos_Hodkiewicz@hotmail.com','1-619-578-3025 x191','(853) 363-0388 x3590',19),(19,'Garrick_Kertzmann85@hotmail.com','1-283-941-9677 x997','507.244.2525 x183',20),(20,'Rossie.Boyer@yahoo.com','1-327-791-1161','1-524-622-4924',21),(21,'Janiya18@gmail.com','876.627.6582 x305','1-441-615-6815',22),(22,'Jamie_Welch22@hotmail.com','662-859-5869 x6599','516.904.0590',23),(23,'Craig_Wehner75@yahoo.com','782-690-7682 x4603','709.472.1142',24),(24,'Eleanora_Christiansen9@hotmail.com','(383) 901-4940 x12598','(357) 680-3443 x0276',25),(25,'Elmira.Deckow@hotmail.com','562-860-3209','(468) 819-3016 x39601',26),(26,'Randi.Boyer94@gmail.com','849-431-7614 x557','(273) 785-3408 x914',27),(27,'Johan92@hotmail.com','1-834-926-2344 x94137','1-251-441-4259',28),(28,'Maureen7@gmail.com','(684) 672-5652','(948) 387-7486 x75751',29),(29,'Deja.King@hotmail.com','(485) 642-3878','340-311-3917 x2680',30),(30,'Vaughn.Mosciski@gmail.com','256-856-2443','213-851-0600 x5250',31),(31,'Christ9@hotmail.com','241.935.8735 x2402','1-802-389-8959 x6938',2),(32,'Ian.Anderson@yahoo.com','(253) 554-4876 x3890','1-885-628-0658 x6844',1);
/*!40000 ALTER TABLE `tblBusinessContact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tblClient`
--

LOCK TABLES `tblClient` WRITE;
/*!40000 ALTER TABLE `tblClient` DISABLE KEYS */;
INSERT INTO `tblClient` VALUES (1,'Manuel','Gutmann','1975-08-29','2011-08-03',NULL,32),(2,'Agustin','Casper','1987-06-28','2019-04-04',NULL,3),(3,'Lupe','Renner','1972-07-16','2012-06-18',NULL,4),(4,'William','Schneider','1950-02-07','2018-10-12',NULL,5),(5,'Keara','Hirthe','1955-03-01','2016-06-16',NULL,6),(6,'Teresa','Kuhn','1989-02-26','2017-04-07',NULL,7),(7,'Sherman','Johnston','1990-10-22','2012-08-15',NULL,8),(8,'Nicholaus','Lebsack','1958-03-11','2012-04-19',NULL,9),(9,'Derick','Goodwin','1941-07-30','2019-03-03',NULL,10),(10,'Lizeth','Tremblay','1954-09-10','2015-05-28',NULL,11),(11,'Weldon','Upton','1980-09-26','2015-01-02',NULL,12),(12,'Jocelyn','Leannon','1964-04-01','2012-09-18',NULL,13),(13,'Tre','Schimmel','1955-07-05','2017-06-29',NULL,14),(14,'Krystal','Mante','1949-08-28','2014-01-24',NULL,15),(15,'Kamron','Krajcik','1974-11-25','2015-12-25',NULL,16),(16,'Douglas','Lehner','1950-05-09','2011-03-30',NULL,17),(17,'Herta','Hahn','1999-06-19','2017-01-27',NULL,18),(18,'Orlando','Fritsch','1955-01-10','2016-08-21',NULL,19),(19,'Breanne','Rath','1980-04-11','2010-02-05',NULL,20),(20,'Raleigh','Hamill','1953-03-28','2013-09-05',NULL,21),(21,'Adriel','Mayer','1959-08-01','2019-08-07',NULL,22),(22,'Diana','Lueilwitz','1978-10-06','2016-11-19',NULL,23),(23,'Beryl','Mraz','1962-07-30','2011-07-12',NULL,24),(24,'Elyse','Oberbrunner','1955-11-04','2014-06-14',NULL,25),(25,'Murphy','Luettgen','1944-06-04','2011-12-08',NULL,26),(26,'Julio','Predovic','1969-08-02','2016-11-03',NULL,27),(27,'Kari','Mertz','1977-02-18','2018-09-18',NULL,28),(28,'Sonia','Corwin','1975-10-24','2012-03-21',NULL,29),(29,'Deonte','Emard','1974-12-31','2017-01-04',NULL,30),(30,'Columbus','Effertz','1991-08-20','2018-09-23',NULL,31),(31,'Solon','Hessel','1952-02-03','2014-09-09',NULL,2),(32,'Bradly','Smith','1952-10-01','2010-10-13',NULL,1);
/*!40000 ALTER TABLE `tblClient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tblDepartment`
--

LOCK TABLES `tblDepartment` WRITE;
/*!40000 ALTER TABLE `tblDepartment` DISABLE KEYS */;
INSERT INTO `tblDepartment` VALUES (1,'Document Control','Quality Assurance'),(2,'Information Services','Executive General and Administration'),(3,'Finance','Executive General and Administration'),(4,'Human Resources','Executive General and Administration'),(5,'Marketing','Sales and Marketing'),(6,'Sales','Sales and Marketing'),(7,'Web Design','Research and Development'),(8,'Software Engineering','Research and Development'),(9,'Quality Assurance','Quality Assurance'),(10,'Executive','Executive General and Administration');
/*!40000 ALTER TABLE `tblDepartment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tblEmployee`
--

LOCK TABLES `tblEmployee` WRITE;
/*!40000 ALTER TABLE `tblEmployee` DISABLE KEYS */;
INSERT INTO `tblEmployee` VALUES (1,'Rita','Hane','1969-03-21','0c:c4:62:13:1a:ab','2018-03-02',14,32),(2,'Burnice','Franecki','1974-11-07','4d:fb:5f:3d:b6:e1','2019-03-18',5,3),(3,'Khalil','O\'Kon','1990-09-30','0b:a0:3e:2f:d3:ff','2019-12-06',11,4),(4,'Mariam','Bosco','1968-08-21','06:fb:18:95:ea:cc','2014-03-30',18,5),(5,'Mervin','Bayer','1968-04-05','bc:5c:75:ad:ca:37','2016-03-05',15,6),(6,'Eleazar','Monahan','1960-11-01','bd:2f:02:78:4a:a1','2010-07-14',21,7),(7,'Lola','Marks','1971-03-18','16:f4:64:25:20:f6','2011-03-16',2,8),(8,'Carlotta','Welch','1988-12-14','d7:e3:e2:b9:26:34','2017-10-01',10,9),(9,'Drew','Schinner','1984-03-21','01:3e:e8:92:72:82','2017-12-07',22,10),(10,'Lilla','Johns','1985-06-23','75:45:81:49:a5:17','2016-07-14',13,11),(11,'Evelyn','Kling','1963-02-03','04:58:1f:96:91:7b','2018-06-26',4,12),(12,'Mortimer','Greenholt','1979-05-17','7b:f3:26:3c:8e:84','2016-02-12',16,13),(13,'Peyton','Hand','1972-05-07','33:6e:9c:38:dd:8e','2016-11-05',24,14),(14,'Zora','Kling','1966-02-07','ed:39:8f:73:dc:f1','2013-02-12',1,15),(15,'Elliot','Paucek','1973-10-17','f9:ca:8e:23:69:88','2011-05-17',7,16),(16,'Christelle','O\'Kon','1990-03-07','b5:24:b1:fa:58:9e','2012-11-27',10,17),(17,'Jeanie','Greenholt','1961-04-01','54:05:ec:ac:1a:a7','2016-09-10',17,18),(18,'Eda','Auer','1984-12-28','db:74:d1:aa:b9:25','2011-07-03',22,19),(19,'Estefania','Glover','1979-11-07','2c:84:6b:c2:e2:98','2016-12-10',9,20),(20,'Margaret','Donnelly','1962-01-31','f1:76:88:36:bd:6d','2014-10-25',3,21),(21,'Ethelyn','Hintz','1989-06-03','15:49:3c:28:ae:e4','2011-06-13',24,22),(22,'Gene','Willms','1990-06-20','d5:d9:68:41:58:c5','2010-09-25',6,23),(23,'Angelita','Heidenreich','1977-02-02','ce:83:5b:21:83:68','2017-03-16',23,24),(24,'Ethan','Watsica','1964-12-15','70:6e:21:86:b9:ea','2018-01-11',17,25),(25,'Clara','Schuppe','1963-09-07','2e:a1:af:ce:7c:15','2017-02-05',8,26),(26,'Christa','Hagenes','1975-07-13','a8:7a:b8:cd:8c:60','2017-05-20',24,27),(27,'Nicholas','Muller','1993-02-18','b5:68:f9:1f:d2:0b','2011-07-31',17,28),(28,'Winifred','Crona','1984-05-04','b6:55:b9:71:b5:eb','2016-05-15',20,29),(29,'Hannah','Rohan','1992-07-19','0c:c6:a7:ce:ec:5d','2014-03-31',10,30),(30,'Hettie','Bergstrom','1978-09-16','5a:eb:46:d4:5c:43','2016-08-20',19,31),(31,'Margarett','Deckow','1987-02-04','82:3b:a3:b6:7a:75','2010-06-30',12,2),(32,'Pierce','Dicki','1978-01-30','1c:a9:70:0d:08:ed','2014-12-27',22,1);
/*!40000 ALTER TABLE `tblEmployee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tblPayRate`
--

LOCK TABLES `tblPayRate` WRITE;
/*!40000 ALTER TABLE `tblPayRate` DISABLE KEYS */;
INSERT INTO `tblPayRate` VALUES (1,1),(2,2),(3,3),(4,4),(5,5),(6,6),(7,7),(8,8);
/*!40000 ALTER TABLE `tblPayRate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tblPersonalContact`
--

LOCK TABLES `tblPersonalContact` WRITE;
/*!40000 ALTER TABLE `tblPersonalContact` DISABLE KEYS */;
INSERT INTO `tblPersonalContact` VALUES (1,'Kian.Waters@hotmail.com','(294) 579-6809','937-843-2628',64),(2,'Manuel.Macejkovic@yahoo.com','343.392.6344','(999) 309-0566',35),(3,'Judah39@hotmail.com','(629) 718-5536 x226','822.356.4836 x5074',36),(4,'Leo_Wolf83@gmail.com','(740) 306-3547','896.922.7797 x2530',37),(5,'Alaina_Gorczany28@gmail.com','1-810-781-5012 x9972','(637) 627-8346 x09060',38),(6,'Sadie98@hotmail.com','840-727-7535','846-348-0993 x7372',39),(7,'Forest.Brakus@yahoo.com','767.499.6000 x700','223-839-4198 x026',40),(8,'Marion.Heller30@hotmail.com','946-674-1989','720.461.7001 x428',41),(9,'Madie.Ferry73@hotmail.com','704.753.5697','(423) 203-7919 x028',42),(10,'Everardo.Ondricka22@yahoo.com','1-658-291-8536','361-415-3680',43),(11,'Karina_Howell20@yahoo.com','366.764.9254 x48516','991.931.1543 x215',44),(12,'Carson_Jast40@gmail.com','(948) 578-6187 x2979','806-605-0231 x874',45),(13,'Antonette_Stehr92@gmail.com','614-545-9761 x3357','824.918.1169',46),(14,'Creola_Stroman59@gmail.com','1-883-445-1453','341.869.2843 x773',47),(15,'Jeffrey33@gmail.com','1-952-742-8944','1-956-697-4059',48),(16,'Ana.Crona57@yahoo.com','(208) 914-4876 x988','1-834-522-7470 x28136',49),(17,'Jamaal.Jacobson96@yahoo.com','1-581-407-2152 x708','883-466-2963 x3123',50),(18,'Keara_Cummings@gmail.com','261-210-2550','(205) 615-3733',51),(19,'Lucienne_Langosh56@yahoo.com','(903) 916-5777 x16364','361.380.0865 x964',52),(20,'Elouise.Emmerich@gmail.com','670.285.7471 x096','253.440.9926 x56926',53),(21,'Verna7@yahoo.com','1-617-560-5265 x52638','1-836-267-0415 x4822',54),(22,'Victor49@hotmail.com','579-636-5194 x29870','727-537-5057',55),(23,'Jacinto_Rohan@hotmail.com','922-923-2929 x5735','662-317-7470',56),(24,'Helga.Mitchell35@hotmail.com','(708) 748-9313','1-577-397-4313 x581',57),(25,'Laura_Crooks@yahoo.com','(462) 306-5202 x6904','239.648.2729',58),(26,'Richard85@gmail.com','(540) 437-8704 x5304','694.408.5580',59),(27,'Glenna_Hansen66@yahoo.com','1-326-654-8265 x99397','1-648-688-8886 x0935',60),(28,'Ceasar.Schimmel@hotmail.com','399-712-3255 x406','837-304-7379 x3881',61),(29,'Patsy_Denesik31@hotmail.com','1-857-754-5231 x927','705.866.8905 x2325',62),(30,'Felicita36@hotmail.com','1-980-659-2147','630.201.2176',63),(31,'Jolie_Brakus20@gmail.com','883-319-4726','661.294.1665 x5847',34),(32,'Amya_Marquardt@yahoo.com','1-262-361-5983 x4111','580-418-6415',33);
/*!40000 ALTER TABLE `tblPersonalContact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tblPosition`
--

LOCK TABLES `tblPosition` WRITE;
/*!40000 ALTER TABLE `tblPosition` DISABLE KEYS */;
INSERT INTO `tblPosition` VALUES (1,'Marketing Manager',5,5),(2,'Chief Financial Officer',3,6),(3,'Human Resource Administrator',4,4),(4,'Human Resource Manager',4,5),(5,'Information Services Manager',2,5),(6,'Quality Assurance Technician',9,3),(7,'Quality Assurance Manager',9,4),(8,'Document Control Assistant',1,3),(9,'Document Control Manager',1,4),(10,'Sales Representative',6,3),(11,'Sales Manager',6,4),(12,'Marketing Assistant',5,3),(13,'Marketing Specialist',5,4),(14,'Chief Executive Officer',10,8),(15,'Vice President of Engineering',8,7),(16,'Engineering Manager',8,7),(17,'Software Engineer',8,6),(18,'Infrastructure Technician',8,6),(19,'Network Administrator',8,6),(20,'Database Administrator',8,6),(21,'Senior Web Designer',7,5),(22,'Associate Web Designer',7,4),(23,'Finance Manager',3,5),(24,'Accountant',3,4);
/*!40000 ALTER TABLE `tblPosition` ENABLE KEYS */;
UNLOCK TABLES;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-10 22:09:39
