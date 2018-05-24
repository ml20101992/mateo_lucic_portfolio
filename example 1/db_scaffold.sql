-- MySQL dump 10.14  Distrib 5.5.56-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: group1700
-- ------------------------------------------------------
-- Server version	5.5.56-MariaDB

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
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categories` (
  `cat_id` int(8) NOT NULL AUTO_INCREMENT,
  `cat_name` varchar(255) NOT NULL,
  `cat_description` varchar(255) NOT NULL,
  PRIMARY KEY (`cat_id`),
  UNIQUE KEY `cat_name_unique` (`cat_name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'About KofiTuGo website','Everything you want to know about our page! </br>Meet the developers, read up on our goals and see important page announcements!'),(2,'Coffee Talk','Wanted to learn something new about coffee? This is the right place for you!<br><br>Hop in and start contributing!'),(5,'General talk','Want to just talk about random things? Well, here you can!');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `page_content`
--

DROP TABLE IF EXISTS `page_content`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `page_content` (
  `content_id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_page` int(11) NOT NULL,
  `position` int(11) NOT NULL,
  `content` longtext CHARACTER SET latin1 COLLATE latin1_general_ci NOT NULL,
  `header` varchar(200) NOT NULL,
  `image` varchar(100) DEFAULT 'no',
  PRIMARY KEY (`content_id`),
  KEY `parent_page` (`parent_page`),
  CONSTRAINT `page_content_ibfk_1` FOREIGN KEY (`parent_page`) REFERENCES `pages` (`page_id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `page_content`
--

LOCK TABLES `page_content` WRITE;
/*!40000 ALTER TABLE `page_content` DISABLE KEYS */;
INSERT INTO `page_content` VALUES (1,1,1,'Coffee comes from a tree plant called genus Coffea where the beans are extracted from the cherries, dried, roasted then grounded and finally brewed into a warm beverage people generally drink to boost their energy level. <br>\r\nThe beginning of coffee started in Africa on the Arabian Peninsula with the plant originating from Ethiopia however the drinking culture started in the 15th century in Yemen in the city of Mocha. <br>\r\nThere is a popular legend that states how a goat herder named Kaldi from Ethiopia noticed his goats acting unusually hyper prancing around the hills. Kaldi decided to observe their routines and noticed how their behavior changed after eating some strange red berries. After trying the red berries, he felt an energy boost and joined the prancing goats, becoming the happiest goat herder in Arabia. <br>\r\nOne day a monk was passing by and noticed Kaldi ´s behavior. Kaldi explained what he had discovered with the berries and the monk got an idea to make a hot beverage to prevent the other monks from falling asleep during prayers. The seeds were dried, then boiled and finally a new hot beverage was made. The monks loved it and finally stopped falling asleep during prayers.<br>\r\n','The legend of Coffee','no'),(2,1,2,'The new hot beverage became popular in area of the Arabian Peninsula within the Islamic culture for religious purposes then started spreading to Egypt, Syria, Turkey, India and Indonesia in the 16th century. Shortly after, coffee houses started appearing in the Middle East since Muslims were forbidden to enter taverns and restaurants were not common at the time. <br>The coffee drinking culture appeared late in Europe since Europeans were not used to the bitter taste of coffee. The beverage was also looked upon as a Muslim drink so Europeans took quite a while to become accustom to it. <br>Coffee consumption became more popular at the end of the 17th century where Europeans added honey and milk to make the taste nicer for their palettes.','History of coffee','history.jpg'),(3,1,3,'The hot beverage contains caffeine and antioxidants which are good for the body. Drinking coffee can reduce problems for the digestive system and the body´s circulation. <br>Today coffee trees are grown in over 50 countries in the tropical areas of Africa, Asia, the Caribbean South and Central America. Coffee is an important export product since people drink an average of 3 cups a day and worldwide 2.25 billion cups of coffee is drunk per day. <br>With the number of coffee shops spreading around the world, the beverage has become a custom to many people´s morning rituals to help them wake up and to keep their energy level boosted throughout in the day.<br>','Trivia','trivia.jpg'),(4,3,1,'Best temperature for the brewing the coffee is 92-96C.  In manual brewing it is the best to \r\nleave water to boil and then sit it for 3-5 minutes before adding ground coffee.\r\n','What is the best temperature when you are brewing coffee?','no'),(5,3,2,'Coffee consists of 98% of water so taste of your coffee depends on your water. Better the taste of water, better taste of coffee. Some people use tap water and some people use bottled water for their coffee. If you can, do not use distilled water. Some of the machines come with filter so you can get better quality coffee taste if your water does not taste good.  ','Is water important when brewing coffee?','no'),(6,3,3,'Best coffes to brew are: <br>\r\n1. Mocha Java Coffee<br>\r\n2. Hawaii Kona Coffee<br>\r\n3. Guatemalan Antigua Coffee<br>\r\n4. Tanzania Peaberry Coffee<br>\r\n5. Nicaraguan Coffee<br>\r\n','What are the best coffees to brew?','no'),(7,3,4,'The best way is to take the coffee beans from a single source, they have the best flavor. Coffees from the stores can sit on the shelf for months and that is not good because it loses its taste.','About coffee beans','no'),(8,3,5,'The Moka Pot is famous around Italy and it is a pot made of three layers, the first layer is for the water, second layer is for fresh grounded coffee and the last one is where coffee comes out. Water boils and pushes the grounded coffee at the top part and the rest of the water comes to the top evaporating.','The Moka Pot','no'),(9,3,6,'To make expresso you have to preheat the cup so the cup does not absorb heat from the coffee. When you are making expresso you have to grind the coffee beans but they need to be grinded properly to achieve the right taste (you can order already grinded coffee beans).','How to make expresso in a Expresso machine?','no'),(10,3,7,'French press is a glass container that has a press in it. You have to preheat the French press so it does not absorb heat of coffee. After bringing water to almost boiling you put grinded coffee beans in the press and hot water, leave it to sit for few minutes until it is easy to press so remains go down at the bottom.','French press','no'),(11,3,8,'For Turkish Coffee you have to first fill the ibrik with water, after that you put it on the heat for 2 minutes and then you add grinded coffee and if you want some sugar. When the coffee starts to rise you take it from heat and set it aside for 20 sec and then put it back on the heat, repeat this process 2 more times and then leave it for 2 min to settle','Turkish Coffee','no'),(12,3,9,'You can grow your own coffee trees in your house, the perfect place for them is window because plant needs a lot of brightness and moist ground to grow. The plant is usually grown in tropical areas so that plant need a special care. Temperature cannot go below freezing because coffee plant cannot survive that. If you take care of it properly after 3 years it will give flowers and little berries that contain coffee beans but there would not be enough for brewing coffee but you will have few beans just for fun','Growing coffee trees','no'),(13,3,10,'After the coffee beans are picked they are placed on sun for weeks so they dry up and their moist comes on 11%. When they finally dry up coffee is tasted multiple times to check the quality and after all of them are dry enough they will get green grayish color. The next step is roasting the coffee beans at 260°C until they get brown color like the ones that you buy at the store and after that you can grind them or leave them like that depending on the type of coffee you are making','Processing raw coffee beans','no'),(14,2,1,'Coffee specialists estimate that the Coffea tree has between 25-100 different kinds of coffee plants. Since the plants can be grown widely and differ in appearance, this makes it difficult to know the exact amount of existing coffee plants. <br>The two most commonly and commercially used are Arabica and Robusta. Arabica grows in the temperatures of 15-24 ºC and Robusta grows in the temperatures of 24-30 ºC. Arabica is commercially consumed by 70% of the coffee drinking population and the other 30% consume Robusta. <br>This is due to Arabica being more aromatic and sophisticated where Robusta is known to be hardier and bitterer.','What coffee beans are there?','no'),(15,2,2,'Arabica comes from Ethiopia where the original coffee plants were found growing between 610 to 1830 meters above sea level. The coffee bean is flatter then the Robusta bean creating a milder coffee with less caffeine. The Arabica beans are also more expensive than the Robusta because they are grown in steep areas which are not easy to access.','Arabica bean','arabica.jpg'),(16,2,3,'Robusta is grown in West Africa, part of Asia and in Brazil. The bean is smaller and rounder then the Arabica bean with a stronger taste and higher amount of caffeine. Robusta can resist harsher conditions better then Arabica making it cheaper on the market. The Robusta beans are generally used for making instant coffee or for mixtures with other coffees.','Robusta bean','robusta.jpg'),(17,2,4,'The taste of coffee varies depending on the soil the plants were grown on, how much sunshine there was throughout the year, the amount of rain, the altitude, the region they are in and the different cultures people have. Coffee plants are grown in over 50 countries throughout Africa, Asia, Europe, the Americas and the Oceania area. ','Conclusion','no'),(18,6,1,'When the coffee is picked and dried it goes to the oven to roast and after that it is shipped to the countries that need it. In those countries coffee is grinded and then packed to be ready for sale. The reason why coffee is grinded in sale destination countries is because if coffee was grinded in the beginning it would lose a lot of taste. So the coffee that you bay in your local stores is probably grinded in your own country.','Grinded coffee','grinded.jpg'),(19,6,2,'Instant or soluble coffee is made to speed up the process of making coffee by putting the coffee crystal or powder into a cup and finally adding hot water. To make instant coffee, coffee beans are first roasted and grinded then hot water is used to extract the grinded coffee to get the taste and aroma. The extract is then dehydrated in two ways using the freeze-drying or spray drying method.<br>\r\nFreeze drying is when the extract is frozen at the temperature of -40 degrees Celsius, cut into granules and dried under the vacuum by taking out the liquid usually creating the crystalized instant coffee. Dry spraying is when the extract is sprayed with hot air until it becomes a powder and this method is more commonly used. No filter is then needed to make instant coffee and it is quicker than making classical coffee.\r\n','Instant coffee','nescafe.jpg'),(20,6,3,'Some people might not be able to consume caffeine due to health issues or personal preference, so they drink decaffeinated coffee. To make decaffeinated coffee, the caffeine needs to be extracted from the beans while they are still green by first swelling them with water or steam and then extracting the caffeine using activated carbon. This process has to be done a few times until the beans are finally left with no caffeine or 0.1% which is allowed by European law. The beans are then dried and ready to be grinded to be made into instant decaffeinates coffee. ','Decaf coffee','decaf.jpg'),(21,7,1,'The beginning of coffee started in Africa with the plant originating from Ethiopia. Sidamo, Harrar, Kaffa are the main regions where the coffee beans are produced. The coffee beans in Ethiopia are generally processed using the wet method creating a sweet berry taste to the coffee. The Ethiopian coffee ceremony is done three times a day with the purpose of socializing with family and friends. By tradition, a woman dressed in white first washes green beans are and then roasts them on a traditional pan. After the roasting is done, she walks around the so others can smell the coffee beans while cooling them. The beans are then grinded and put into a jebana which is filled with boiling water.  A jebana is an Ethiopian coffee pot made out of clay with a long head so the coffee can brew. The idea of the ceremony is to cherish coffee as a commodity from their country while spending time with other and socializing.','Origins of coffee in Africa','arab_shop.jpg'),(22,7,2,'Yemen is the country where the culture of drinking coffee became popular in the 15th century. The beans are smaller with an irregular shape and are processed using the dry method. The coffee from Yemen is deep and rich. In the past, coffee was exported using the port in Mocha and the name became a synonym for coffee from this region. The first coffee blend was made when the Dutch combined the Yemen coffee with the coffee from the Java Island in Asia and today is well known as the Mocha Java.','Coffee in Yemen','yemen.jpg'),(23,7,3,'Kenyan coffee is known to be more sharp and flavorful with a strong aroma. It is popular amongst Europeans and in the United States of America. The Ivory Coast is popular for its export on Robusta coffee. Sudan has thick coffee which is infused with spices making it strong. Zanzibar´s custom is to drink coffee without milk and sugar where Egypt´s tradition on making coffee is similar to Turkish using a coffee pot with a narrow top.','Coffe in the rest of Africa','no'),(24,8,1,'Coffee was brought to Indonesia in the 17th century by Dutch colonists. Today, Asia is the third largest contributor on the market regarding producing and exporting coffee even with the continent having the lowest amount of coffee consumers in the world. The best known islands for producing good quality coffee are Java and Sumatra in Indonesia with their coffee known to be thick with a mild acidic taste. Indonesia is also known for their aged coffee where the beans are stored and by using the damp weather the taste of the beverage becomes less acidic. Aged coffee costs more than other coffees due to its long process and high quality. ','Coffee in Indonesia','indonesia.jpg'),(25,8,2,'Vietnam was introduced to coffee by French missionaries in 19th century where Arabica trees were planted. Today Vietnam is known for making Robusta which has less acidity and a milder taste then the usual hardy Robusta. <br>Vietnam is also well known for blending different typed of coffees. Ca phe sua da is the name of the coffee which is a custom for drinking in Vietnam. A phin is a Vietnamese coffee press which serves as a filter and brewer.\r\n<br> Grinded coffee is added to the phin and then placed over a cup. The coffee is pressed with another piece of the phin and then hot water is poured into the filter slowly. The coffee drips into the empty cup slowly because the grinded coffee is compressed. <br>While the coffee is dripping into the cup, they cook sweetened condensed milk and then pour a layer which is approximately 1 - 2 centimeters thick l into another cup. <br>Once the coffee stops dripping, sugar is added since it is traditional for the coffee to be drunken sweet. The coffee is poured into the cup with the condensed milk and finally served. Some might even shake the coffee to make foam and then it is poured into the cup with condensed milk making the beverage have three layers. ','Coffee in Vietnam','nam.jpg'),(26,8,3,'Another popular coffee tradition is making Vietnamese egg coffee better known to locals as Ca phe Trung. The Vietnamese coffee filter (phin) is placed over an empty cup, grinded coffee is added, pressed and then hot water is poured into the filter. While the coffee is dripping into the empty cup, a serving cup is placed into a bowl with hot water to warm the cup.<br> During this time, the egg mixture needs to be prepared by using egg yolks, sugar, vanilla, sweetened condensed milk and a teaspoon of coffee which are mixed about three minutes until the mixtures becomes white and fluffy. When the coffee is done dripping, it is poured into the serving cup in the bowl with hot water, followed by the egg mixtures which goes on top and has to sit at least 30 second for the egg yolk to cook. Finally, a bit of coffee is poured over the egg mixture and the Ca phe Trung is ready to be served.','Did you know?','no'),(27,9,1,'Since coffee trees prefer a warmer climate close to the equator, they are difficult to grow in Europe. The coffee drinking culture had also arrived in Europe fairly late due coffee being looked upon as a Muslim drink, where Europeans preferred tea.<br> The hot beverage became popular in the 17th century where Europeans added honey and milk to make the taste sweeter and coffee shops started spreading throughout the continent. Today, coffee has become a part of many Europeans everyday life and the culture of preparing them is different depends on the country. ','How coffee came to Europe','no'),(28,9,2,'Italians are known for their espresso which is when hot water poured through pressured grinded coffee using an espresso machine. It in is served in small double shot cups and is supposed to be drunk with small sips. Italians drink them throughout the whole day but mainly after dinner. In France the people use a French press to make their coffee. Hot water is poured into the press over the grinded coffee and after about 3-4 minutes, the grinded coffee in the water is pushed down so the beverage does not contain the grind. The Turks use a coffee pot made out of copper with a handle called an ibriq. First water is boiled in the Ibriq on a stove then grinded coffee is added to the water. The coffee pot is then put on the stove again until the mixture is brought up to a boil. The coffee pot is removed from the heat and then put back onto the stove to boil up again. It is a custom to do this 2 – 3 times to make the taste stronger. Finally, the coffee is poured into a cup and should let sit for about a minute so the grinds fall to the bottom. People can then add milk or sugar depending on personal preferences. ','Coffee in Italy','italy.jpg'),(29,9,3,'Croatians are passionate coffee drinkers whether it is their morning coffee, coffee at work or spending hours at a local café talking, it is their favourite way to pass time and it is a part of their culture. Most of the hot beverages consumed in Croatia are influenced by Italy with the espresso, latte, macchiato and cappuccino. Croatia also does not have a single Starbucks because Croatians do not have the tendency to buy coffee “to go” since drinking coffee is not the important part, socializing with people is. There was one that opened in Zagreb but it closed soon after because the Starbuck culture just did not work. The prices were fairly high, their blends such as a Mocha Cookie Crumble Frappuccino are too complex and the coffee in general is not as strong as the in local cafés. In general, Croatians just love to sit down with a cup of coffee and take it easy or how the locals would say “pomalo”.','Coffee in Croatia','split.jpg'),(30,10,1,'Mexico is one of the largest coffee producers in the world common for making small plantation farms so it is easier to watch over. Mexican coffee is strong, best made for dark roasts and blends. <br>Puerto Rico also has world famous coffee and even if the country has problems with hurricanes sometimes, today it is known for its rich Arabica. <br>Guatemala has volcanic soil making the beans have a distinctive and spicy taste. <br>Costa Rica is known for its wet processed quality Arabica which is medium acidic and strong making a balanced coffee. <br>Colombia is 2nd in the world regarding production with its excellent quality coffee Colombian Supremo. <br>Brazil is 1st in the world for production with plantations expanding for miles with great soil, weather and altitude for the coffee trees growing both Arabica and Robusta.','Coffee in wider America','plantation.jpg'),(31,10,2,'Regarding the United States of America, coffee trees are grown on Hawaii, where the continental area does not have the required weather for the plants. The most popular is Kona coffee which is grown by the volcano Mauna Loa where the soil is perfect for the tree plants. The coffee is rich and aromatic processed very carefully. <br>Kona coffee with made with finely grinded coffee which is put into a filter over a cup and then hot water is poured over the coffee. Once the hot beverage has stopped dripping, the coffee is ready to be served. Sugar and cream can be added depending on personal preference.','Coffee in the United States','no'),(32,4,1,'The trees can be found in a tropical environment between the latitudes of the Tropics Cancer and Capricorn where they can grow to be 9 meters and even a higher in length however people usually prune them so it is easier to harvest later. The leaves are usually green however specialists have found dark green, yellow and purple leaves on some trees. The coffee cherry of the genus Coffea tree takes about a year until it becomes ready to harvest. Since the trees mainly grow on mountainous area, the cherries are usually handpicked with the exception of trees grown in flat areas which are picked using machines. ','How does the tree look like','coffee_tree.jpg'),(33,4,2,'There are two types of cherry harvesting: strip picking where all the coffee cherries are harvested at the same time or selective picking where only the fully ripped ones are picked which is usually done by hand.<br> After the coffee cherries have been harvested, the seeds are removed usually using a coffee mill and then dried in using two methods: the dry method which uses the sun or machines and the wet method incorporating fermentation creating a milder coffee. This drying process can vary between 6-7 days solely by patio or 12-14 days for naturally processed beans.<br> The beans are ready when they turn green and the moisture content is between 11-15% and best at 12.5%.','Harvesting and drying coffee','processing.jpg'),(34,4,3,'The next step is to roast the green beans until they turn brown. During this process, the beans gradually get a darker brown color and the aroma of the coffee bean intensifies.<br> Different cultures have different ways of roasting their beans, depending on the flavor they want to achieve, however generally the beans are roasted between the temperatures of 180ºC to 240ºC for approximately 20 minutes. <br>The longer the beans are roasting, the stronger will the flavor be. After the roasting process, the beans are cooled down so the aroma can settle and finally the product is ready to be sold. Some companies might even grind their coffee before selling depending on who the buyer is such as grocery stores with packaged coffee where some buyers would rather receive the beans and grind them just before making the beverage such as coffee shops. <br>After the roasted beans have been grinded, the coffee is brewed using hot water and then served for drinking. ','Roasting coffee beans','no'),(35,5,1,'Coffee is a hot beverage which contains caffeine which helps improving people’s energy level also boosting their physical performance and burning fat. It gets into the blood stream quickly continuing to the brain making people more focused and sharper. The beverage also has antioxidants, vitamins and nutrients which are good for the body. Specialists state that coffee decreases the possibility for diseases including diabetes type II, Alzheimer\'s disease, dementia, Parkinson\'s, cancer and heart disease. Since coffee has caffeine and is commonly consumed with other people, it also helps people with depression. ','Health benefits of coffee','no'),(36,5,2,'Kopi Luwak is the most expensive coffee in the world and it comes from the Indonesian island of Java and Sumatra. <br>An animal called Paradoxurus or locally called luwak comes from this place and eats the red cherries from the coffee plants. The bean is fermented in the animal’s stomach then after the beans exit the animal naturally through their digestive system.<br> People then gather the intact beans from the floor of the forests, clean them, roast them, grind them and finally brew them into a cup of coffee. Since this is the only place with this type of coffee making process, this is the reason the price is so high.<br> People also say that the coffee cannot be compared to others regarding the taste which is said to be rich with a hint or caramel or chocolate.','The most expensive coffee','no'),(37,5,3,'Starbucks is a large worldwide coffee chain company which started in Seattle (USA) in 1971. In 2016, a Starbucks was located in 23,768 worldwide. The company uses espresso machines to make the product which can be blended with other coffees, spices, flavours, syrups, sprinkles, ice and different types of milk. People can sit in the café but the Starbucks culture is more focused on “coffee to go” where people order their beverages and leave. Starbucks also serves fresh fruit juices, Frappuccino’s, pastries and snacks to their customers. Some of the shops even sell pre-packaged meals and sandwiches. The company is most popular in the United States of America and Canada, where Europeans are known more to sit at a local café however more and more are popping up around the continent since it is quicker to get a coffee at a Starbucks then to make one at home before work.\r\n\r\n','Starbucks - the coffee giant','starbucks.jpg'),(38,5,4,'Liqueur coffee\r\nCoffee can also be drunk with alcohol where a shot of a liqueur is added to the beverage usually served in a glass cup. There are different types of liquored coffee around the world with the Irish coffee being one of the most popular ones where a shot of whiskey is added to the coffee including sugar and cream on the top. Spain also has the popular carajillo where rum, aguardiente or orujo is added to the blend. Different countries add different types of alcohol to their coffee depending on the culture such as: the French add Grand Marnier, Italians add Amaretto, Germans add Schnapps, Russians add vodka, Americans add bourbon and the English add gin. Other alcohols added to coffee can be Baileys, brandy, absinth, Bénédictine, grappa, Sambuca and many more.','Liqueur coffee','irish.jpg');
/*!40000 ALTER TABLE `page_content` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pages`
--

DROP TABLE IF EXISTS `pages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pages` (
  `page_id` int(11) NOT NULL AUTO_INCREMENT,
  `page_desc` varchar(30) NOT NULL,
  `full_title` varchar(200) NOT NULL,
  `parent_page` varchar(30) NOT NULL,
  PRIMARY KEY (`page_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pages`
--

LOCK TABLES `pages` WRITE;
/*!40000 ALTER TABLE `pages` DISABLE KEYS */;
INSERT INTO `pages` VALUES (1,'About','About Coffee','0'),(2,'Beans','Types of Beans','about.php'),(3,'FAQ','Frequently asked questions','0'),(4,'Tutorials','Harvesting of Coffee','0'),(5,'Trivia','Trivia','0'),(6,'Product','Types of Product','about.php'),(7,'Africa','Coffee in Africa','regions.php'),(8,'Asia','Coffee in Asia','regions.php'),(9,'Europe','Coffee in Europe','regions.php'),(10,'Americas','Coffee in Americas','regions.php');
/*!40000 ALTER TABLE `pages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `posts`
--

DROP TABLE IF EXISTS `posts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `posts` (
  `post_id` int(8) NOT NULL AUTO_INCREMENT,
  `post_content` text NOT NULL,
  `post_date` datetime NOT NULL,
  `post_topic` int(8) NOT NULL,
  `post_by` int(8) NOT NULL,
  PRIMARY KEY (`post_id`),
  KEY `post_topic` (`post_topic`),
  KEY `post_by` (`post_by`),
  CONSTRAINT `posts_ibfk_1` FOREIGN KEY (`post_topic`) REFERENCES `topics` (`topic_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `posts_ibfk_2` FOREIGN KEY (`post_by`) REFERENCES `users` (`user_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `posts`
--

LOCK TABLES `posts` WRITE;
/*!40000 ALTER TABLE `posts` DISABLE KEYS */;
INSERT INTO `posts` VALUES (47,'Hello!<br><br>\r\n\r\nThis way, I would like to introduce you all to our brave and selfless team that sweated blood and tears to spread the word of the goodness that is coffee to the world!\r\n<br><br>\r\n\r\nWithout further ado, let me present the TEAM!','2017-12-06 06:24:00',28,1),(48,'Have any questions to ask the KofiTuGo team?<br><br>\r\nThis is the place to ask!','2017-12-06 06:24:00',29,1),(49,'GENERAL DISCUSSION CATEGORY RULES!\r\n<br><br>\r\n\r\n1. DO NOT INSULT OTHER USERS<br>\r\n2. HATE SPEECH IS STRICTLY FORBRIDDEN<br>\r\n3. DO NOT SPAM!<br>\r\n<br>\r\n\r\nHope you will enjoy the KofiTuGo forum!','2017-12-06 06:24:00',30,1),(50,'Hello\r\nMy name is Teo and my job on this project was generating content for our web site \r\nI hope you like it :)','2017-12-06 07:17:09',28,12),(51,'Hello!\r\n\r\nI am the team leader behind this glorious website. We worked really hard to make this website happen and we are glad that it all worked out in the end. I was glad to work with my teammates and looking forward to our future assignments as well!\r\n\r\nNice to meet you everyone, and I hope you enjoy the website.','2017-12-06 07:24:47',28,13),(52,'Hola, I am the lead UX/UI designer for Kofi Tu Go.\r\nIf you have any complaints about the design or usability you know where to go ;)','2017-12-06 07:30:47',28,14),(53,'Yay guys, your page is awesome!','2017-12-06 08:59:20',28,15),(54,'Hey guys, why do you love coffee so much?','2017-12-06 08:59:55',31,15),(55,'alo','2018-01-11 14:31:05',32,1),(56,'test 2','2018-04-14 09:43:49',29,1);
/*!40000 ALTER TABLE `posts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `topics`
--

DROP TABLE IF EXISTS `topics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `topics` (
  `topic_id` int(8) NOT NULL AUTO_INCREMENT,
  `topic_subject` varchar(255) NOT NULL,
  `topic_date` datetime NOT NULL,
  `topic_cat` int(8) NOT NULL,
  `topic_by` int(8) NOT NULL,
  PRIMARY KEY (`topic_id`),
  KEY `topic_cat` (`topic_cat`),
  KEY `topic_by` (`topic_by`),
  CONSTRAINT `topics_ibfk_1` FOREIGN KEY (`topic_cat`) REFERENCES `categories` (`cat_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `topics_ibfk_2` FOREIGN KEY (`topic_by`) REFERENCES `users` (`user_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topics`
--

LOCK TABLES `topics` WRITE;
/*!40000 ALTER TABLE `topics` DISABLE KEYS */;
INSERT INTO `topics` VALUES (28,'Meet the KofiTuGo Team!','2017-12-06 06:24:00',1,1),(29,'Ask us anything about coffee!','2017-12-06 06:24:00',2,1),(30,'General Talk Rules','2017-12-06 06:24:00',5,1),(31,'A question for the devs','2017-12-06 08:59:55',1,15),(32,'test za toma','2018-01-11 14:31:05',1,1);
/*!40000 ALTER TABLE `topics` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `user_id` int(8) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(30) NOT NULL,
  `user_pass` varchar(255) NOT NULL,
  `user_email` varchar(255) NOT NULL,
  `user_date` datetime NOT NULL,
  `user_level` int(8) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_name_unique` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'mateo','mateo123','mateo.lucic@gmail.com','2017-11-09 00:00:00',1),(12,'teo','teo123','txs4072@g.rit.edu','2017-12-06 07:15:04',1),(13,'Marino','marino123','marinobjeloperakxb@gmail.com','2017-12-06 07:20:27',1),(14,'Klara','klara','klarabalerina@gmail.com','2017-12-06 07:27:06',1),(15,'test_acc','test123','mxl3773@g.rit.edu','2017-12-06 08:58:28',1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-23 15:31:53
