-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Dec 05, 2018 at 05:49 AM
-- Server version: 10.2.17-MariaDB
-- PHP Version: 7.1.22

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `u764646568_ft`
--

-- --------------------------------------------------------

--
-- Table structure for table `categories`
--

CREATE TABLE `categories` (
  `id` int(11) NOT NULL,
  `category_tag` varchar(20) NOT NULL,
  `category_name` varchar(40) NOT NULL,
  `category_img_video` text NOT NULL,
  `category_img_photo` text NOT NULL,
  `video_redirect` varchar(200) NOT NULL,
  `photo_redirect` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `categories`
--

INSERT INTO `categories` (`id`, `category_tag`, `category_name`, `category_img_video`, `category_img_photo`, `video_redirect`, `photo_redirect`) VALUES
(1, 'techfest', 'TechFest', '/uploads/category/vid_techfest.png', '', '', ''),
(2, 'cufest', 'CU Fest', '/uploads/category/vid_cufest.png', '', '', ''),
(3, 'freshers', 'Freshers', '/uploads/category/vid_freshers.png', '', '', ''),
(4, 'students', 'By Students', '/uploads/category/vid_students.png', '', '', ''),
(5, 'sports', 'Sports', '/uploads/category/vid_sports.png', '', '', ''),
(6, 'visitors', 'Visitors', '/uploads/category/vid_visitors.png', '', '', ''),
(7, 'official', 'Official', '/uploads/category/vid_official.png', '', '', ''),
(8, 'clubactivity', 'Club and Activities', '/uploads/category/vid_clubactivity.png', '', '', ''),
(9, 'achimil', 'Achievements and Milestones', '/uploads/category/vid_achimil.png', '', '', ''),
(10, 'life', 'Life at CU', '/uploads/category/vid_life.png', '', '', ''),
(11, 'all', 'ALL', '/uploads/category/vid_all.png', '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `video_gallery`
--

CREATE TABLE `video_gallery` (
  `id` int(6) NOT NULL,
  `title` varchar(180) NOT NULL,
  `thumbnail_image` varchar(40) NOT NULL,
  `video_category` varchar(20) NOT NULL,
  `video_url` varchar(255) NOT NULL,
  `date` date NOT NULL,
  `video_description` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `video_gallery`
--

INSERT INTO `video_gallery` (`id`, `title`, `thumbnail_image`, `video_category`, `video_url`, `date`, `video_description`) VALUES
(10, 'Chandigarh University campus life 2017', '10.png', 'cufest', 'https://www.youtube.com/watch?v=gBJxjfdXKaA', '2018-07-27', 'Top  University in Punjab..'),
(11, 'Chandigarh university campus life', '11.png', 'life', 'https://www.youtube.com/watch?v=gBJxjfdXKaA', '2018-07-16', 'Chandigarh University campus life 2017'),
(12, 'A Day in Chandigarh university', '12.png', 'students', 'https://www.youtube.com/watch?v=IjKv8MZk1hU', '2018-07-05', 'Daily routine at Chandigarh University'),
(13, 'Hostel life @ CU', '13.png', 'life', 'https://www.youtube.com/watch?v=-gdrCzCqGbk', '2018-07-02', 'rom dwelling in a congenial atmosphere to growing in a healthy environment, hostel life at ChandigarhUniversity is a remarkable episode that helps you collect a sack full of memories. Being a hosteller in CU, you will be met with amazing new experiences every day. Can\\\'t believe! Look no further and explore video showing - how life at CUhostel is a bundle of different activities...'),
(14, 'Chandigarh university Admissions', '14.png', 'official', 'https://www.youtube.com/watch?v=R53yMzwDY2w', '2018-07-14', 'Have Admission Enquiry??  At Chandigarh University Admissions support team is here to help you both On-Campus and Off-Campus. Feel free to come and get your admission queries solved at our admission office at CU Campus.'),
(15, 'Last day of degree', '15.png', 'students', 'https://www.youtube.com/watch?v=vG8GFIzGIZU', '2018-07-11', 'OUR LAST DAY AT CHANDIGARH UNIVERSITY.'),
(16, 'Movie promotions', '16.png', 'visitors', 'https://www.youtube.com/watch?v=dI7Zla3SYzM', '2018-07-13', 'A Video for those who missed Katrina Kaif and Sidharth Malhotra visit to Chandigarh University'),
(17, 'Placements', '17.png', 'achimil', 'https://www.youtube.com/watch?v=UO4qiUhYNr0', '2018-07-15', 'placed in amazon with the dream package.'),
(18, 'diverse in culture', '18.png', 'achimil', 'https://www.youtube.com/watch?v=uveY2A2yMJg', '2018-07-06', 'Chandigarh University - Student centric approach which includes Transparent Examination, Flexible Choice Based Academic Model, Open Elective System, Rich Industry Academia Interface and Best Campus Placements are earned Chandigarh University yet another honor by being awarded as most Student Friendly University in India during 9th Innovative Education Awards 2017 held at Mumbai.'),
(19, 'Tech fest', '19.png', 'techfest', 'https://www.youtube.com/watch?v=fEoaw7Vjhh4', '2018-07-09', 'handigarh University organized a technical fest named TECH INVENT 2017 to encourage its students to adopt technology and to showcase their technical and innovative expertise. Winners awarded with Cash prizes of worth 1 Million. Watch the Video.');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `video_gallery`
--
ALTER TABLE `video_gallery`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `categories`
--
ALTER TABLE `categories`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `video_gallery`
--
ALTER TABLE `video_gallery`
  MODIFY `id` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
