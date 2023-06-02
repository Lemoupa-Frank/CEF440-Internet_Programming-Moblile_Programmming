-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 02, 2023 at 10:24 PM
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
-- Database: `mobile_programming_database`
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
  `plate_no` int(30) NOT NULL,
  `Admin_id` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
  `plate_no` int(30) NOT NULL,
  `employer` varchar(30) NOT NULL,
  `Admin_id` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `passenger`
--

CREATE TABLE `passenger` (
  `passenger_id` int(30) NOT NULL,
  `location` varchar(30) NOT NULL,
  `destination` varchar(30) NOT NULL,
  `names` varchar(30) NOT NULL,
  `ppassword` varchar(30) NOT NULL,
  `tel` bigint(30) NOT NULL,
  `freelance_id` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`Admin_id`);

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
  MODIFY `Admin_id` int(25) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `freelancetaxi`
--
ALTER TABLE `freelancetaxi`
  MODIFY `freelance_id` int(30) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `hiredtaxi`
--
ALTER TABLE `hiredtaxi`
  MODIFY `hiredtaxi_id` int(30) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `passenger`
--
ALTER TABLE `passenger`
  MODIFY `passenger_id` int(30) NOT NULL AUTO_INCREMENT;

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
