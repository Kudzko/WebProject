package by.epam.javawebtraining.utils;

public class DBInitQuery {
    public static final String dbInitQuery ="CREATE DATABASE  IF NOT EXISTS `testingproject2` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;\n" +
            "USE `testingproject2`;\n" +
            "-- MySQL dump 10.13  Distrib 5.7.12, for Win32 (AMD64)\n" +
            "--\n" +
            "-- Host: 127.0.0.1    Database: testingproject\n" +
            "-- ------------------------------------------------------\n" +
            "-- Server version\t5.6.43-log\n" +
            "\n" +
            "/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;\n" +
            "/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;\n" +
            "/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;\n" +
            "/*!40101 SET NAMES utf8 */;\n" +
            "/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;\n" +
            "/*!40103 SET TIME_ZONE='+00:00' */;\n" +
            "/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;\n" +
            "/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;\n" +
            "/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;\n" +
            "/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;\n" +
            "\n" +
            "--\n" +
            "-- Table structure for table `answer`\n" +
            "--\n" +
            "\n" +
            "/*!40101 SET @saved_cs_client     = @@character_set_client */;\n" +
            "/*!40101 SET character_set_client = utf8 */;\n" +
            "CREATE TABLE IF NOT EXISTS `answer` (\n" +
            "  `id` int(11) NOT NULL AUTO_INCREMENT,\n" +
            "  `answertext` varchar(45) DEFAULT NULL,\n" +
            "  `right` tinyint(1) DEFAULT NULL,\n" +
            "  `question_id` int(11) NOT NULL,\n" +
            "  PRIMARY KEY (`id`)\n" +
            ") ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;\n" +
            "/*!40101 SET character_set_client = @saved_cs_client */;\n" +
            "\n" +
            "--\n" +
            "-- Table structure for table `question`\n" +
            "--\n" +
            "\n" +
            "/*!40101 SET @saved_cs_client     = @@character_set_client */;\n" +
            "/*!40101 SET character_set_client = utf8 */;\n" +
            "CREATE TABLE IF NOT EXISTS `question` (\n" +
            "  `id` int(11) NOT NULL AUTO_INCREMENT,\n" +
            "  `question` varchar(45) DEFAULT NULL,\n" +
            "  `test_id` int(11) NOT NULL,\n" +
            "  PRIMARY KEY (`id`)\n" +
            ") ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;\n" +
            "/*!40101 SET character_set_client = @saved_cs_client */;\n" +
            "\n" +
            "--\n" +
            "-- Table structure for table `result`\n" +
            "--\n" +
            "\n" +
            "\n" +
            "/*!40101 SET @saved_cs_client     = @@character_set_client */;\n" +
            "/*!40101 SET character_set_client = utf8 */;\n" +
            "CREATE TABLE IF NOT EXISTS `result` (\n" +
            "  `id` int(11) NOT NULL AUTO_INCREMENT,\n" +
            "  `user_id` int(11) NOT NULL,\n" +
            "  `test_id` int(11) NOT NULL,\n" +
            "  `mark` int(11) DEFAULT NULL,\n" +
            "  PRIMARY KEY (`id`)\n" +
            ") ENGINE=InnoDB DEFAULT CHARSET=utf8;\n" +
            "/*!40101 SET character_set_client = @saved_cs_client */;\n" +
            "\n" +
            "--\n" +
            "-- Table structure for table `role`\n" +
            "--\n" +
            "\n" +
            "\n" +
            "/*!40101 SET @saved_cs_client     = @@character_set_client */;\n" +
            "/*!40101 SET character_set_client = utf8 */;\n" +
            "CREATE TABLE IF NOT EXISTS `role` (\n" +
            "  `id` int(11) NOT NULL AUTO_INCREMENT,\n" +
            "  `role` varchar(45) DEFAULT NULL,\n" +
            "  PRIMARY KEY (`id`)\n" +
            ") ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;\n" +
            "/*!40101 SET character_set_client = @saved_cs_client */;\n" +
            "\n" +
            "--\n" +
            "-- Table structure for table `test`\n" +
            "--\n" +
            "\n" +
            "\n" +
            "/*!40101 SET @saved_cs_client     = @@character_set_client */;\n" +
            "/*!40101 SET character_set_client = utf8 */;\n" +
            "CREATE TABLE IF NOT EXISTS `test` (\n" +
            "  `id` int(11) NOT NULL AUTO_INCREMENT,\n" +
            "  `author` int(11) NOT NULL,\n" +
            "  `test_theme` int(11) NOT NULL,\n" +
            "  `test_name` varchar(45) DEFAULT NULL,\n" +
            "  PRIMARY KEY (`id`)\n" +
            ") ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;\n" +
            "/*!40101 SET character_set_client = @saved_cs_client */;\n" +
            "\n" +
            "--\n" +
            "-- Table structure for table `test_theme`\n" +
            "--\n" +
            "\n" +
            "\n" +
            "/*!40101 SET @saved_cs_client     = @@character_set_client */;\n" +
            "/*!40101 SET character_set_client = utf8 */;\n" +
            "CREATE TABLE IF NOT EXISTS `test_theme` (\n" +
            "  `id` int(11) NOT NULL AUTO_INCREMENT,\n" +
            "  `test_theme` varchar(45) DEFAULT NULL,\n" +
            "  PRIMARY KEY (`id`)\n" +
            ") ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;\n" +
            "/*!40101 SET character_set_client = @saved_cs_client */;\n" +
            "\n" +
            "--\n" +
            "-- Table structure for table `user`\n" +
            "--\n" +
            "\n" +
            "/*!40101 SET @saved_cs_client     = @@character_set_client */;\n" +
            "/*!40101 SET character_set_client = utf8 */;\n" +
            "CREATE TABLE IF NOT EXISTS `user` (\n" +
            "  `id` int(11) NOT NULL AUTO_INCREMENT,\n" +
            "  `login` varchar(45) CHARACTER SET utf8 DEFAULT NULL,\n" +
            "  `password` varchar(45) CHARACTER SET utf8 DEFAULT NULL,\n" +
            "  `role_id` int(11) NOT NULL,\n" +
            "  `name` varchar(45) CHARACTER SET utf8 DEFAULT NULL,\n" +
            "  `surname` varchar(45) CHARACTER SET utf8 DEFAULT NULL,\n" +
            "  PRIMARY KEY (`id`)\n" +
            ") ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;\n" +
            "/*!40101 SET character_set_client = @saved_cs_client */;\n" +
            "/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;\n" +
            "\n" +
            "/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;\n" +
            "/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;\n" +
            "/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;\n" +
            "/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;\n" +
            "/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;\n" +
            "/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;\n" +
            "/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;\n" +
            "\n" +
            "-- Dump completed on 2019-05-26  2:52:05\n";
}
