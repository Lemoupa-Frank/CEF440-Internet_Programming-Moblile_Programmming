-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 18, 2023 at 04:50 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `jetme_pd`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `Admin_id` int(25) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Admin_password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`Admin_id`, `Name`, `Admin_password`) VALUES
(1, 'ADMIN', 'ADMIN'),
(2, '', '');

-- --------------------------------------------------------

--
-- Table structure for table `booktaxi`
--

CREATE TABLE `booktaxi` (
  `book_key` int(30) NOT NULL,
  `time` timestamp(6) NULL DEFAULT NULL,
  `passenger_name` varchar(30) DEFAULT NULL,
  `Driver_Fname` varchar(30) DEFAULT NULL,
  `Driver_Lname` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `booktaxi`
--

INSERT INTO `booktaxi` (`book_key`, `time`, `passenger_name`, `Driver_Fname`, `Driver_Lname`) VALUES
(1, '2023-06-08 12:51:16.000000', 'ME', 'NA', 'ASD');

-- --------------------------------------------------------

--
-- Table structure for table `freelancetaxi`
--

CREATE TABLE `freelancetaxi` (
  `freelance_id` int(30) NOT NULL,
  `FF_name` varchar(30) NOT NULL,
  `FL_name` varchar(30) NOT NULL,
  `seats` int(25) NOT NULL,
  `FFpassword` varchar(30) NOT NULL,
  `driver_license` varchar(30) NOT NULL,
  `plate_no` varchar(30) NOT NULL,
  `Admin_id` int(30) NOT NULL,
  `FLongitudelocation` double(30,20) DEFAULT NULL,
  `Flatitudelocation` double(30,20) DEFAULT NULL,
  `TEL` bigint(20) NOT NULL,
  `time` timestamp(6) NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `freelancetaxi`
--

INSERT INTO `freelancetaxi` (`freelance_id`, `FF_name`, `FL_name`, `seats`, `FFpassword`, `driver_license`, `plate_no`, `Admin_id`, `FLongitudelocation`, `Flatitudelocation`, `TEL`, `time`) VALUES
(1, 'freelance1', 'name', 3, 'password', 'SW10', '1000', 1, 4.15032645479301100000, 9.28618813467422000000, 655665454, NULL),
(2, 'Freelance2', 'name2', 1, 'Password', 'SW11', '1001', 1, 4.15931499203504800000, 9.28481484372383300000, 0, NULL),
(3, 'freelance3', 'name3', 1, 'Password3', 'SW12', '1002', 1, 4.14989842665599200000, 9.24353028452781800000, 0, NULL),
(4, 'Freelance4', 'name4', 4, 'mypassword', 'SW13', '1003', 1, NULL, NULL, 0, NULL),
(5, 'freelance5', 'name5', 2, 'Passwords', 'SW14', '1004', 1, 4.16145510484375200000, 9.29726029296171700000, 0, NULL),
(6, 'Dustan', 'Njin', 2, 'word', 'SW10', '1011', 1, 4.16158351142733600000, 9.23468972346244700000, 0, NULL),
(7, 'seven', 'man', 2, 'seven', 'SW111', '1007', 1, 4.14720184405881700000, 9.24395943748733600000, 0, NULL),
(8, 'firstname', 'lastname', 2, 'passw', 'SW50', '1000', 1, 4.15546277433212100000, 9.28721028870100000000, 0, NULL),
(9, 'nine', 'man', 1, 'nine', 'SW19', '1009', 1, 4.14720184405881700000, 9.24395943748733600000, 0, NULL),
(10, 'Drada', 'Mua', 4, 'passwordd', 'SW1010', '101010', 1, 4.13898363083899800000, 9.24481774434149100000, 0, NULL),
(11, 'Njie', 'Clinton', 1, 'cPassword', 'SW1111', '101111', 1, 4.12494398600986500000, 9.24438859091441500000, 0, NULL),
(12, 'Enow', 'Baye', 3, 'ENpassword', 'SW112', '10012', 1, 4.14600335995032600000, 9.23357392455204500000, 0, NULL),
(13, 'Tambe', 'Mbappe', 2, 'TRpassword', 'SW141', '101221', 1, 4.15952900357756850000, 9.27846337302442000000, 0, NULL),
(14, '', '', 0, '', 'Not Found', '', 1, NULL, NULL, 0, NULL),
(15, '', '', 0, '', 'Not Found', '', 1, NULL, NULL, 0, NULL),
(16, '', '', 0, '', 'Not Found', '', 1, NULL, NULL, 0, NULL),
(24, 'AA', 'BB', 4, 'qwqw', '1231', 'SW2', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(25, 'AA', 'BB', 4, '1212', '123', 'SW2', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(26, 'AA', 'BB', 4, '1212', '123', 'SW2', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(27, '', '', 0, '', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(28, 'AAA', 'BBA', 4, '1231', '1231', 'SW1212', 1, 0.00000000000000000000, 0.00000000000000000000, 653676325, NULL),
(34, 'freyah', 'gayua', 0, 'yau', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(35, 'esti', 'esla', 0, 'love', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(36, 'eehe', 'esla', 0, 'love', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(37, 'Fra', 'gwjh', 0, 'ueuw', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(38, 'Fra', 'gwjh', 0, 'ueuw', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(39, 'jdhr', 'dhdhfb', 0, 'dbdjdh', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(40, 'jdhr', 'dhdhfb', 0, 'dbdjdh', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(41, 'jdhr', 'dhdhfb', 0, 'dbdjdh', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(42, 'jdhr', 'dhdhfb', 0, 'dbdjdh', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(43, 'vbgf', 'bjff', 0, 'vdghn', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(44, 'fggb', 'bhcv', 0, 'vjkk', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(45, 'fggb', 'bhcv', 0, 'vjkk', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(46, 'fggb', 'bhcv', 0, 'vjkk', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(47, 'Frank', 'last', 0, 'u7a', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(48, 'Frank', 'last', 0, 'u7a', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(49, 'Frank', 'last', 0, 'u7a', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(50, 'Frank', 'last', 0, 'u7a', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(51, 'Frank', 'last', 0, 'u7a', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(52, 'Frank', 'last', 0, 'u7a', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(53, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(54, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(55, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(56, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(57, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(58, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(59, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(60, 'rbhe', 'd', 0, 'd', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(61, 'rbhe', 'd', 0, 'd', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(62, 'rbhe', 'd', 0, 'd', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(63, 'rbhe', 'd', 0, 'd', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(64, 'rbhe', 'd', 0, 'd', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(65, 'rbhe', 'd', 0, 'd', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(66, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(67, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(68, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(69, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(70, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(71, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(72, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(73, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(74, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(75, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(76, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(77, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(78, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(79, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(80, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(81, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(82, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(83, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(84, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(85, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(86, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(87, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(88, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(89, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(90, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(91, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(92, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(93, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(94, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(95, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(96, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(97, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(98, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(99, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(100, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(101, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(102, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(103, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(104, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(105, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(106, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(107, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(108, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(109, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(110, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(111, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(112, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(113, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(114, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(115, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(116, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(117, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(118, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(119, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(120, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(121, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(122, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(123, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(124, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(125, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(126, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(127, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(128, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(129, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(130, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(131, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(132, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(133, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(134, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(135, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(136, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(137, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(138, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(139, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(140, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(141, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(142, 'heh', '123', 0, '123', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(143, 'rbhe', 'd', 0, 'd', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(144, 'rbhe', 'd', 0, 'd', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(145, 'rbhe', 'd', 0, 'd', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(146, 'rbhe', 'd', 0, 'd', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(147, 'rbhe', 'd', 0, 'd', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(148, 'rbhe', 'd', 0, 'd', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL),
(149, 'rbhe', 'd', 0, 'd', '', '', 1, 0.00000000000000000000, 0.00000000000000000000, 0, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `hiredtaxi`
--

CREATE TABLE `hiredtaxi` (
  `hiredtaxi_id` int(30) NOT NULL,
  `HF_name` varchar(30) NOT NULL,
  `HL_name` varchar(30) NOT NULL,
  `driver_licence` varchar(30) NOT NULL,
  `Hpassword` varchar(30) NOT NULL,
  `plate_no` varchar(30) NOT NULL,
  `employer` varchar(30) NOT NULL,
  `Admin_id` int(30) NOT NULL,
  `HLatitudelocation` double(25,25) DEFAULT NULL,
  `Hlongitudelocation` double(25,25) DEFAULT NULL,
  `time` timestamp(6) NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `hiredtaxi`
--

INSERT INTO `hiredtaxi` (`hiredtaxi_id`, `HF_name`, `HL_name`, `driver_licence`, `Hpassword`, `plate_no`, `employer`, `Admin_id`, `HLatitudelocation`, `Hlongitudelocation`, `time`) VALUES
(1, 'hired1', 'name', 'SWH1', '123password', '500', 'Buea Council', 1, NULL, NULL, NULL),
(2, 'hired2', 'name2', 'SWH2', '1234password', '501', 'Taxi Union', 1, NULL, NULL, NULL),
(3, 'hired3', 'name3', 'SWH3', '12345password', '503', 'Buea Council', 1, NULL, NULL, NULL),
(4, 'hired4', 'name4', 'SWH4', '123456password', '504', 'Buea Council', 1, NULL, NULL, NULL),
(5, 'hired5', 'name5', 'SWH5', '1234567password', '505', 'Taxi Union', 1, NULL, NULL, NULL),
(6, '', '', 'GHF', '', '', '', 1, NULL, NULL, NULL),
(13, 'AAAS', 'BBAS', '1231', '1212', 'SW22', 'BUEA DRIVERS GROUP', 1, 0.0000000000000000000000000, 0.0000000000000000000000000, NULL),
(14, 'AAA', 'BBA', '1231', '1231', 'SW1212', 'Buea Council', 1, 0.0000000000000000000000000, 0.0000000000000000000000000, NULL),
(15, 'AAA', 'BBA', '1231', '1231', 'SW1212', 'Buea Council', 1, 0.0000000000000000000000000, 0.0000000000000000000000000, NULL),
(16, 'AAA', 'BBA', '1231', '1231', 'SW1212', 'Buea Council', 1, 0.0000000000000000000000000, 0.0000000000000000000000000, NULL),
(18, '', '', 'Not Found', '', '', '', 1, NULL, NULL, NULL),
(19, '', '', 'Not Found', '', '', '', 1, NULL, NULL, NULL),
(20, 'Emade', 'Nsah', 'Nsah', '12', 'sfg', 'Buea Council', 1, 0.0000000000000000000000000, 0.0000000000000000000000000, NULL),
(21, 'esti', 'esla', 'ghbn', 'love', 'bdbeje', 'Buea Council', 1, 0.0000000000000000000000000, 0.0000000000000000000000000, NULL),
(22, 'Emade', 'Nsah', 'Nsah', 'love', 'bnnn', 'Buea Council', 1, 0.0000000000000000000000000, 0.0000000000000000000000000, NULL),
(23, 'Emade', 'Rosine', 'hub', 'love', 'huj ', 'Buea Council', 1, 0.0000000000000000000000000, 0.0000000000000000000000000, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `passenger`
--

CREATE TABLE `passenger` (
  `passenger_id` int(30) NOT NULL,
  `location` varchar(30) DEFAULT NULL,
  `destination` varchar(30) DEFAULT NULL,
  `names` varchar(30) NOT NULL,
  `ppassword` varchar(30) DEFAULT NULL,
  `tel` bigint(30) DEFAULT NULL,
  `freelance_id` int(30) DEFAULT NULL,
  `plongitudeLocation` double(25,20) DEFAULT NULL,
  `platitudelocation` double(25,20) DEFAULT NULL,
  `time` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `passenger`
--

INSERT INTO `passenger` (`passenger_id`, `location`, `destination`, `names`, `ppassword`, `tel`, `freelance_id`, `plongitudeLocation`, `platitudelocation`, `time`) VALUES
(1, 'St_clair', 'mile 16', 'Frank Michel', 'qwerty', 655544433, 1, 4.16620613448661800000, 9.23760796676657800000, NULL),
(2, 'central police', 'mile 17', 'Justene T', 'asasd', 620142101, 2, 4.16029944464922300000, 9.23014069713541800000, NULL),
(3, 'mile 16', 'GRA', 'Etuge Gideon', 'Azerty', 653676131, 3, NULL, NULL, NULL),
(4, 'UB Junction', 'check point', 'Emade Rosine', 'azas', 652451200, 2, 4.15507755152659900000, 9.23520470757494200000, NULL),
(5, 'UB Junction', 'GRA', 'T Estrela', 'wereas', 693251147, 5, 4.15499194643315100000, 9.24507523639773900000, NULL),
(6, 'center admin', 'Buea town', 'Ameh Bah', 'qwertyqwerty', 652145144, 6, 4.15259500004488700000, 9.29005051555553200000, NULL),
(7, 'Dirty South', 'Stadium', 'Betran Suh', 'Betran', 620214120, 7, 4.15610481192319300000, 9.28867722458888200000, NULL),
(8, 'central police', 'Buea town', 'Mr Bernard', 'Njie', 692541214, 8, 4.15773130481390900000, 9.26773453734746700000, NULL),
(9, 'mile 18', 'Stadium', 'Etuge Samuel', '123Sam', 670141225, 9, 4.15781690960992400000, 9.26799202940371500000, NULL),
(10, NULL, NULL, 'Frank Mike', 'Mike12', NULL, NULL, NULL, NULL, NULL),
(11, NULL, NULL, 'M Estrela', 'Estrell', NULL, NULL, NULL, NULL, NULL),
(12, NULL, NULL, '', '', 0, NULL, NULL, NULL, NULL),
(13, NULL, NULL, 'Tamah Justene', '5858', 698189870, NULL, NULL, NULL, NULL),
(14, NULL, NULL, '', '', 0, NULL, NULL, NULL, NULL),
(15, NULL, NULL, '', '', 0, NULL, NULL, NULL, NULL),
(16, NULL, NULL, '', '', 0, NULL, NULL, NULL, NULL),
(17, NULL, NULL, 'Meuser', '2231', 655223311, NULL, NULL, NULL, NULL),
(20, NULL, NULL, '', '', 0, NULL, NULL, NULL, NULL),
(21, NULL, NULL, '', '', 0, NULL, NULL, NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`Admin_id`);

--
-- Indexes for table `booktaxi`
--
ALTER TABLE `booktaxi`
  ADD PRIMARY KEY (`book_key`);

--
-- Indexes for table `freelancetaxi`
--
ALTER TABLE `freelancetaxi`
  ADD PRIMARY KEY (`freelance_id`),
  ADD KEY `Admin_id` (`Admin_id`);

--
-- Indexes for table `hiredtaxi`
--
ALTER TABLE `hiredtaxi`
  ADD PRIMARY KEY (`hiredtaxi_id`),
  ADD KEY `Admin_id` (`Admin_id`);

--
-- Indexes for table `passenger`
--
ALTER TABLE `passenger`
  ADD PRIMARY KEY (`passenger_id`),
  ADD KEY `freelance_id` (`freelance_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `Admin_id` int(25) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `booktaxi`
--
ALTER TABLE `booktaxi`
  MODIFY `book_key` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `freelancetaxi`
--
ALTER TABLE `freelancetaxi`
  MODIFY `freelance_id` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=150;

--
-- AUTO_INCREMENT for table `hiredtaxi`
--
ALTER TABLE `hiredtaxi`
  MODIFY `hiredtaxi_id` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT for table `passenger`
--
ALTER TABLE `passenger`
  MODIFY `passenger_id` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `freelancetaxi`
--
ALTER TABLE `freelancetaxi`
  ADD CONSTRAINT `freelancetaxi_ibfk_1` FOREIGN KEY (`Admin_id`) REFERENCES `admin` (`Admin_id`);

--
-- Constraints for table `hiredtaxi`
--
ALTER TABLE `hiredtaxi`
  ADD CONSTRAINT `hiredtaxi_ibfk_1` FOREIGN KEY (`Admin_id`) REFERENCES `admin` (`Admin_id`);

--
-- Constraints for table `passenger`
--
ALTER TABLE `passenger`
  ADD CONSTRAINT `passenger_ibfk_1` FOREIGN KEY (`freelance_id`) REFERENCES `freelancetaxi` (`freelance_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
