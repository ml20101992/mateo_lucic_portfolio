-- MySQL dump 10.16  Distrib 10.1.28-MariaDB, for Win32 (AMD64)
--
-- Host: localhost    Database: mxl3773
-- ------------------------------------------------------
-- Server version	10.1.28-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `poster_name` varchar(50) DEFAULT NULL,
  `post` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;



--
-- Table structure for table `page_content`
--

DROP TABLE IF EXISTS `page_content`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `page_content` (
  `content_id` int(11) NOT NULL AUTO_INCREMENT,
  `origin_page` int(11) DEFAULT NULL,
  `content_header` varchar(255) DEFAULT NULL,
  `content` longtext,
  `position` int(11) DEFAULT NULL,
  `type` varchar(50) NOT NULL DEFAULT 'standard',
  PRIMARY KEY (`content_id`),
  KEY `page_content_pages_page_id_fk` (`origin_page`),
  CONSTRAINT `page_content_pages_page_id_fk` FOREIGN KEY (`origin_page`) REFERENCES `pages` (`page_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `page_content`
--

LOCK TABLES `page_content` WRITE;
/*!40000 ALTER TABLE `page_content` DISABLE KEYS */;
INSERT INTO `page_content` VALUES (9,3,'About Hotel Argentina','This historical hotel built in the early 20ties of the last century is situated in a gorgeous location near the entrance to the Old Town. \r\nIt is surrounded by pine trees and Mediterranean vegetation in the multitudes of gardens that are a part of the hotel.<br><br>\r\nNowadays, the historic hotel has been expanded with the addition of a somewhat more modern complex which together makes Grand Villa Argentina what it is. Grand Villa Argentina has also been a destination of many celebrities and well known personages from both Croatia and abroad. It is also a well-known conference destination owing to the combination of great location and quality service.<br><br>\r\nThe first thing that is seen when entering the hotel is it absolutely gorgeous view to the island of Lokrum and to the old town, in addition to the view to the hotel gardens.<br><br>\r\nLast, but not the least, Grand Villa Argentina possesses a beach with an outdoor pool which is also one of the favorite locations for the guests.\r\n<br>',1,'standard'),(10,4,'About Hotel Bellevue','The first thing one notice when entering hotel Bellevue is the absolute breathtaking view out to the sea. It has been said that one can get lost looking at the deep blue of the sea stretching out in frot of the viewer.\r\n<br><br>\r\nEngraved high into the cliff near the small bay of Miramara, just looking out of the window is breathtaking. The hotel beach can be seen right underneath you and is accessible by open elevator going down.\r\n<br><br>\r\nIt is luxuriously furnished, and provides a certain luxury oasis in sometimes hectic Dubrovnik in summertime.\r\n<br><br>\r\nWhy oasis?\r\n<br> <br>\r\nBecause it is located very near the Old Town (some 10 minutes of walk, most of them in the shade) and is not on the main driveway of Dubrovnik meaning you will not get stuck in traffic!\r\n',1,'standard'),(11,5,'About Hotel Excelsior','One of the first things noticed about hotel Excelsior is its location. It is situated at around five minutes of walk from the Old Town.\r\n<br><br>\r\nThe second thing noticed is how classy it is. There is a reason for that. \r\n<br><br>\r\nHotel Excelsior is one of the oldest hotels in the Dubrovnik area, only beaten by hotel Imperial. It was build on the former Royal Villa built there in 1913 and provides breathtaking view to the Old Town harbor and city walls, as well as providing beautiful view of Lokrum island and accompanying bay.\r\n<br><br>\r\nDue to its long history of excellence, hotel Excelesior hosted many celebrities and dignitaries from Croatia and abroad such as Queen Elizabeth the Second, Elizabeth Taylor, Orson Wells, Margaret Thatcher, Sophia Loren, Sir Roger Moore and many more!\r\n<br><br>\r\nThe hotel includes wellness and spa center and in combination of calm gardens , private beach, and three restaurants with gorgeous view make this hotel one of the top places to stay while in Dubrovnik!\r\n',1,'standard'),(12,6,'About Hotel Imperial','Located on the doorstep of Dubrovnik’s Old Town, Hilton Imperial Dubrovnik is a UNESCO World Heritage Site that offers stunning views over the medieval Old Town and Adriatic Sea. <br><br>\r\nSet in a historic building built in 1895 and private villa built in 1913, the hotel is only meters from Pile Gate so you can explore the fortified walls or even arrange a guided tour with ease. It is also the oldest hotel in Dubrovnik. <br><br>\r\n\r\nThe Hilton Imperial Dubrovnik hotel is just a minute away from Dubrovnik\'s Old Town. Banje Beach is also close by, so you can relax peacefully next to the sea.\r\n<br><br>\r\nExcellent quality of service and the best location in Dubrovnik practically guarantee that this hotel is and will remain a top pick to stay while in Dubrovnik.\r\n',1,'standard'),(13,7,'About Valamar Lacroma','Valamar Lacroma is one of the best hotels in the Dubrovnik area, as is evidenced by winning the World Travel Award in 2013,  2015 and 2016 as the best hotel in Croatia in addition to winning the same award for business hotel in Croatia in 2014, 2015 and 2016.<br><br>\r\nIt is located on Babin Kuk peninsula in one of the rare areas of Dubrovnik proper that is more or less untouched by man. It used to be several smaller hotels under the umbrella of Hoteli Babin Kuk, but several of them were damaged during the war and fell into disrepair.<br><br>\r\nNowadays, it is completely refurbished and modern, with luxury spacious rooms and great congress areas while boasting great and quality service.\r\nNo matter if you are here on business or pleasure, you will sure be able to find something that suits you!\r\n',1,'standard'),(14,8,'About Libertas Rixos','Libertas Rixos is one of the most iconic hotel of Dubrovnik. It is engraved into a cliff and one gets a feeling of slowly slooping terraces once one sets his/hers eyes on it.<br><br>\r\nIt offers an unforgettable holiday experience in a region rich in historical, cultural and natural beauties. Surrounded by the exciting and spectacular landscape of the Adriatic Sea and the mesmerising history of Dubrovnik, it will sure have something to interest anyone.<br><br>\r\nIt is very close to the Old Town, just ten minutes of walk, and it has its own beautiful beach with both indoor and outdoor pools. In addition to that it possesses two restaurants, a very good congress service, a spa and the only casino in Dubrovnik\r\n',1,'standard'),(15,9,'About Importanne Resort','Importanne Resort is comprised of hotels Neptun, Ariston, Royal Palm, Royal Princess, and Royal Blue and also includes Villa Elita, which is by itself the most luxurious place in Dubrovnik. It is situated on Babin Kuk peninsula and was recently completely refurbished. It is now even more modern and comfortable.<br><br>\r\nIt offers excellent view on the sea and is surrounded by mostly untouched nature. There is also a beautiful promenade leading towards Lapad Bay.\r\n<br><br>\r\nImportanne Resort offers three top tier restaurants with quality entertainment, several lounge bars and its own beach in addition to wellness center. One particularity that Importanne Resorts offer is a golf simulator and panoramic rooftop pool displaying Elafiti islands.\r\n<br><br>\r\nThe staff is attentive and speak multiple languages, thereby increasing the offer even more!\r\n<br><br>\r\nCombination of all the above definitely makes Importanne Resorts one of the top picks of places where to stay while in Dubrovnik if you want to enjoy the luxury!\r\n',1,'standard'),(16,10,'About Hotel Palace','Hotel Palace has been a staple of Dubrovnik tourist offering for more than thirty years. It is situated on the bottom of Petka hill and offers unparalleled view of the Elafiti islands along with a gorgeous sea view.\r\n<br><br>\r\nIt is surrounded by pine forests and offers plenty of opportunities to enjoy nature by walking along the seafront on either side of the hotel.\r\n<br><br>\r\nHotel Palace offers direct access to private beach containing two outdoor pools and third indoor pool, as well a diving center, tennis court and jogging paths.\r\n<br><br>\r\nBeautiful interior design and excellent service in addition to peace and quiet in a great location firmly place hotel Palace right there in the top of places to stay while in Dubrovnik!\r\n',1,'standard'),(17,3,'Where is Hotel Argentina','<p id=\"lat\">42.6404616</p>\r\n            <p id=\"lng\">18.1212761</p>\r\n            <p id=\"zoom\">16</p>',2,'map'),(18,4,'Where is Hotel Bellevue','<p id=\"lat\">42.6464147</p>\r\n            <p id=\"lng\">18.091964</p>\r\n            <p id=\"zoom\">16</p>',2,'map'),(19,5,'Where is Hotel Excelsior','<p id=\"lat\">42.6410226</p>\r\n            <p id=\"lng\">18.1187244</p>\r\n            <p id=\"zoom\">16</p>',2,'map'),(20,6,'Where is Hotel Imperial','<p id=\"lat\">42.642715</p>\r\n            <p id=\"lng\">18.1047162</p>\r\n            <p id=\"zoom\">16</p>',2,'map'),(21,7,'Where is Valamar Lacroma','<p id=\"lat\">42.6600045</p>\r\n                <p id=\"lng\">18.0622403</p>\r\n                <p id=\"zoom\">16</p>',2,'map'),(22,8,'Where is Hotel Libertas?','<p id=\"lat\">42.6452109</p>\r\n                <p id=\"lng\">18.0897518</p>\r\n                <p id=\"zoom\">15</p>',2,'map'),(23,10,'Where is Hotel Palace','<p id=\"lat\">42.6508168</p>\r\n                <p id=\"lng\">18.060692</p>\r\n                <p id=\"zoom\">15</p>',2,'map'),(24,9,'Where is Importanne Resort?','<p id=\"lat\">42.65884</p>\r\n<p id=\"lng\">18.0588623</p>\r\n<p id=\"zoom\">15</p>',2,'map'),(25,2,'Rector\'s Palace','Rector\'s Palace is one of the first things that can be seen when entering the Old Town. <br><br>\r\nIt used to be the seat of the Rector of the Republic of Ragusa, and nowadays it is a museum.<br><br>\r\nIt housed the Rector, the Small council, Greater council and the Senate of Republic of Ragusa.<br><br>\r\nThe Rector had an obligation to keep the keys to the city overnight and would return themin the morning to the Guard.<br><br>\r\nRector\'s Palace also served as both the court and in parts as a prison.',1,'standard'),(26,2,'Sponza Palace','Sponza Palace was used as mint, central bank, school and state treasury during the time of the Republic of Ragusa. In addition to aforementioned functions, it also served as a customs office to which the traders would come to pay their taxes.<br><br>\r\n \r\nIt was the focal point of life in the Republic since, as they say, all roads crossed there.<br><br>\r\n \r\nNowadays it is the State Archive for the Republic of Croatia in Dubrovnik. Dubrovnik Summer Festival is officially opened and closed there.<br><br>',2,'standard'),(27,2,'City Walls','Dubrovnik City Walls were built through the centuries with considerable care taken in order to ensure they are capable of withstanding any concievable attack.<br><br>\r\n \r\nWhen the gunpowder was introduced, instead of tearing down the old walls, the people of Ragusa instead just built another set of walls around the old ones.<br><br>\r\n \r\nSome of the most famous points on the walls are Minceta and Revelin towers.\r\n <br><br>\r\nThey were placed on the TripAdvisor portal as one of the must see places before you die.<br><br>\r\n ',3,'standard'),(28,2,'Franciscan Monastery','Franciscan Monastery is the biggest monastery in the City of Dubrovnik.\r\n<br><br>\r\nIn its long history, it has accumulated one of the greatest and oldest libraries in the Croatia.\r\n<br><br>\r\nIt also boasts the oldest pharmacy in Europe, with almost 700 years of uninterrupted service!',4,'standard'),(29,1,'Which hotel to choose?','With the multitude of hotels to choose from here in Dubrovnik, it might be a bit more difficult to choose from. You have everything here... From peace and quiet, to luxurious hotels, great view...\r\n<br><br>\r\nIn order to not get lost, we prepared a small list for you!\r\n<br><br>\r\nJust click on a hotel underneath and choose the lodgings that are the most to your liking!',1,'standard');
/*!40000 ALTER TABLE `page_content` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pages`
--

DROP TABLE IF EXISTS `pages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pages` (
  `page_id` int(11) NOT NULL,
  `page_title` varchar(50) DEFAULT NULL,
  `img_folder` varchar(50) DEFAULT NULL,
  `hero_message` tinytext NOT NULL,
  PRIMARY KEY (`page_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pages`
--

LOCK TABLES `pages` WRITE;
/*!40000 ALTER TABLE `pages` DISABLE KEYS */;
INSERT INTO `pages` VALUES (1,'Hotels',NULL,'<h1>Where to stay</h1><h2>Every man a king!</h2>'),(2,'What to visit','visiting','<h1>Beauties of Dubrovnik<h1><h2>Must see places</h2>'),(3,'Hotel Argentina','argentina','<h1>Hotel Argentina</h1><h2>The Princess of Dubrovnik</h2>'),(4,'Hotel Bellevue','bellevue','<h1>Hotel Bellevue</h1><h2>Taking your breath away</h2>'),(5,'Hotel Excelsior','excelsior','<h1>Hotel Excelsior</h1><h2>Where Queens dine</h2>'),(6,'Hotel Imperial','imperial','<h1>Hotel Imperial</h1><h2>The Grand Old Lady</h2>'),(7,'Valamar Lacroma','lacroma','<h1>Valamar Lacroma</h1><h2>Something for everyone</h2>'),(8,'Hotel Libertas','libertas','<h1>Hotel Libertas</h1><h2>A taste of Orient</h2>'),(9,'Importanne Resort','importanne','<h1>Importanne Resort</h1><h2>The Royal Family</h2>'),(10,'Hotel Palace','palace','<h1>Hotel Palace</h1><h2>Lay down your burdens and relax</h2>');
/*!40000 ALTER TABLE `pages` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-23 21:22:34
