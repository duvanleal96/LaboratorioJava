-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 26, 2021 at 05:45 AM
-- Server version: 10.1.35-MariaDB
-- PHP Version: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `concurso`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbcategoria`
--

CREATE TABLE `tbcategoria` (
  `id` int(10) NOT NULL,
  `nombre` varchar(30) COLLATE utf8_bin NOT NULL,
  `puntaje` int(50) NOT NULL,
  `nivel` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `tbcategoria`
--

INSERT INTO `tbcategoria` (`id`, `nombre`, `puntaje`, `nivel`) VALUES
(1, 'Historia', 100, 1),
(2, 'Entretenimiento', 300, 2),
(3, 'Ciencias', 500, 3),
(4, 'Arte', 700, 4),
(5, 'Geografia', 1000, 5);

-- --------------------------------------------------------

--
-- Table structure for table `tbhistorial`
--

CREATE TABLE `tbhistorial` (
  `idjugador` int(10) NOT NULL,
  `puntaje` int(100) NOT NULL,
  `estado` varchar(30) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `tbhistorial`
--

INSERT INTO `tbhistorial` (`idjugador`, `puntaje`, `estado`) VALUES
(90, 100, 'Retiro'),
(91, 0, 'Eliminado');

-- --------------------------------------------------------

--
-- Table structure for table `tbjugador`
--

CREATE TABLE `tbjugador` (
  `id` int(10) NOT NULL,
  `nombre` varchar(30) COLLATE utf8_bin NOT NULL,
  `puntajeTotal` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `tbjugador`
--

INSERT INTO `tbjugador` (`id`, `nombre`, `puntajeTotal`) VALUES
(63, 'duvan', 0),
(64, 'duvan', 100),
(65, 'duvan emilio', 0),
(66, 'cocosete', 0),
(67, 'njkin', 0),
(68, ' m', 0),
(69, ' m', 0),
(70, ' m', 0),
(71, ' maria', 0),
(72, ' maria', 0),
(73, 'jijiijiji', 0),
(74, 'fewf', 0),
(75, 'fewf', 400),
(76, 'DUVAN', 0),
(77, '', 0),
(78, '', 0),
(79, '', 0),
(80, '', 0),
(81, '', 0),
(82, 'jenni', 0),
(83, 'jenni', 100),
(84, 'duvan', 0),
(85, 'g', 100),
(86, 'd', 0),
(87, 'duvan', 0),
(88, 'duvan', 0),
(89, 'carlos', 0),
(90, 'carlos', 100),
(91, 'pedro', 0);

-- --------------------------------------------------------

--
-- Table structure for table `tbpregunta`
--

CREATE TABLE `tbpregunta` (
  `id` int(10) NOT NULL,
  `descripcion` varchar(100) COLLATE utf8_bin NOT NULL,
  `idcategoria` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `tbpregunta`
--

INSERT INTO `tbpregunta` (`id`, `descripcion`, `idcategoria`) VALUES
(1, '¿En que año tuvo lugar el ataque a Pearl Harbor?', 1),
(3, '¿Con que emperador estuvo casada Cleopatra?', 1),
(4, '¿El renacimiento marcó el inicio de que edad...?', 1),
(9, '¿que se celebra el 8 de Marzo?', 1),
(10, '¿Como se llama la sustancia que se utiliza en la iglesia para hacer mucho humo?', 1),
(11, '¿Quién es Bella en la saga \"Crepusculo\"?', 2),
(12, '¿A que pelicula de Disney pertenece la cancion \"Un mundo ideal\"?', 2),
(13, '¿A quién se le considera el Rey del Pop?', 2),
(14, '¿Cómo se llama la actriz que protagoniza ¡Carly?', 2),
(15, '¿Cómo se llama el pájaro símbolico de los Juegos del Hambre?', 2),
(16, '¿Qué órgano del cuerpo humano produce la bilis?', 3),
(17, '¿Qué es un equino?', 3),
(18, '¿Cuántas cavidades estomacales tiene una vaca?', 3),
(19, '¿Qué función cumplen los bigotes del gato?', 3),
(20, '¿Con que parte del cuerpo hacen el zumbido las abejas?', 3),
(21, '¿Quién pintó el cuadro \"El jardín de las delicias\"?', 4),
(22, '¿Quién escribió \"El viejo y el mar?', 4),
(23, '¿Qué describe una prosopografía?', 4),
(24, '¿Qué obra de mármol de Miguel Ángel se encuentra en la Basílica de San Pedro?', 4),
(25, '¿Quién pintó La Capilla Sixtina?', 4),
(26, '¿Cuál es el código internacional para Cuba?', 5),
(27, '¿En qué país situarías la ciudad de Cali?', 5),
(28, '¿Con cuántos países limita Argentina?', 5),
(29, '¿Cuál es la capital de Suiza?', 5),
(30, '¿En qué país está la Laguna Verde?', 5);

-- --------------------------------------------------------

--
-- Table structure for table `tbrespuesta`
--

CREATE TABLE `tbrespuesta` (
  `id` int(10) NOT NULL,
  `descripcion` varchar(100) COLLATE utf8_bin NOT NULL,
  `validacion` tinyint(1) NOT NULL,
  `idpregunta` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `tbrespuesta`
--

INSERT INTO `tbrespuesta` (`id`, `descripcion`, `validacion`, `idpregunta`) VALUES
(1, '1939', 0, 1),
(2, '1940', 0, 1),
(3, '1941', 1, 1),
(4, '1942', 0, 1),
(9, 'Ptolomeo XIV', 0, 3),
(10, 'Julio César', 0, 3),
(11, 'Marco Antonio', 0, 3),
(12, 'Todas son correctas', 1, 3),
(13, 'Moderna', 1, 4),
(14, 'Antiguedad clasica ', 0, 4),
(15, 'Contemporánea', 0, 4),
(16, 'Media', 0, 4),
(17, 'El dia del trabajo', 0, 9),
(18, 'El dia del medio ambiente', 0, 9),
(19, 'El dia de la mujer', 1, 9),
(20, 'El dia del niño', 0, 9),
(21, 'Vino', 0, 10),
(22, 'Carbón', 0, 10),
(23, 'Aceite', 0, 10),
(24, 'Incienso', 1, 10),
(25, 'Kristen Stewart', 1, 11),
(26, 'Cristina Ricci', 0, 11),
(27, 'Emma Watson', 0, 11),
(28, 'Dakota Fanning', 0, 11),
(29, 'Aladdín', 1, 12),
(30, 'Pocahontas', 0, 12),
(31, 'Mulán', 0, 12),
(32, 'Hércules', 0, 12),
(33, 'Justin Bieber', 0, 13),
(34, 'Michael Jackson', 1, 13),
(35, 'Zayn Malik', 0, 13),
(36, 'Zac Efron', 0, 13),
(37, 'Victoria Justice', 0, 14),
(38, 'Miranda Cosgrove', 1, 14),
(39, 'Jennette McCurdy', 0, 14),
(40, 'Keke Palmer', 0, 14),
(41, 'Lechuza', 0, 15),
(42, 'Sinsajo', 1, 15),
(43, 'Gale', 0, 15),
(44, 'Llamas', 0, 15),
(45, 'Hígado', 1, 16),
(46, 'Páncreas', 0, 16),
(47, 'Intestino delgado', 0, 16),
(48, 'Riñon', 0, 16),
(49, 'Una vaca', 0, 17),
(50, 'Un antílope', 0, 17),
(51, 'Una oveja', 0, 17),
(52, 'Un caballo', 1, 17),
(53, 'Una', 0, 18),
(54, 'Dos', 0, 18),
(55, 'Tres', 0, 18),
(56, 'Cuatro', 1, 18),
(57, 'Son un órgano táctil', 1, 19),
(58, 'Son un órgano auditivo', 0, 19),
(59, 'Son un órgano olfativo', 0, 19),
(60, 'Son de adorno', 0, 19),
(61, 'Con las patas', 0, 20),
(62, 'Con las alas', 1, 20),
(63, 'Con la boca', 0, 20),
(64, 'Con las antenas', 0, 20),
(65, 'El Bosco', 1, 21),
(66, 'Carvaggio', 0, 21),
(67, 'Velázquez', 0, 21),
(68, 'Arcimboldo', 0, 21),
(69, 'Ernest Hemingway', 1, 22),
(70, 'Norman Mailer', 0, 22),
(71, 'Gabriel García Márquez', 0, 22),
(72, 'Truman Capote', 0, 22),
(73, 'El físico de una persona', 1, 23),
(74, 'El carácter de una persona', 0, 23),
(75, 'El fisico y el carácter de una persona', 0, 23),
(76, 'Caricaturiza a una persona', 0, 23),
(77, 'Moisés', 0, 24),
(78, 'La Piedad', 1, 24),
(79, 'Capilla Sixtina', 0, 24),
(80, 'David', 0, 24),
(81, 'Giorgio Vasari', 0, 25),
(82, 'Leonardo Da Vinci', 0, 25),
(83, 'Miguel Ángel', 1, 25),
(84, 'Tiziano', 0, 25),
(85, 'CA', 0, 26),
(86, 'CU', 1, 26),
(87, 'CB', 0, 26),
(88, 'Ninguna es correcta', 0, 26),
(89, 'Colombia', 1, 27),
(90, 'Venezuela', 0, 27),
(91, 'Costa Rica', 0, 27),
(92, 'Chile', 0, 27),
(93, 'Tres', 0, 28),
(94, 'Cuatro', 0, 28),
(95, 'Cinco', 1, 28),
(96, 'Seis', 0, 28),
(97, 'Berna', 1, 29),
(98, 'Zurich', 0, 29),
(99, 'Ginebra', 0, 29),
(100, 'Basilea', 0, 29),
(101, 'Chile', 0, 30),
(102, 'Argentina', 0, 30),
(103, 'Bolivia', 1, 30),
(104, 'Todas son correctas', 0, 30);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbcategoria`
--
ALTER TABLE `tbcategoria`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbhistorial`
--
ALTER TABLE `tbhistorial`
  ADD PRIMARY KEY (`idjugador`);

--
-- Indexes for table `tbjugador`
--
ALTER TABLE `tbjugador`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbpregunta`
--
ALTER TABLE `tbpregunta`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idcategoria` (`idcategoria`);

--
-- Indexes for table `tbrespuesta`
--
ALTER TABLE `tbrespuesta`
  ADD PRIMARY KEY (`id`),
  ADD KEY `tbpregunta` (`idpregunta`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbcategoria`
--
ALTER TABLE `tbcategoria`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `tbhistorial`
--
ALTER TABLE `tbhistorial`
  MODIFY `idjugador` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=92;

--
-- AUTO_INCREMENT for table `tbjugador`
--
ALTER TABLE `tbjugador`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=92;

--
-- AUTO_INCREMENT for table `tbpregunta`
--
ALTER TABLE `tbpregunta`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT for table `tbrespuesta`
--
ALTER TABLE `tbrespuesta`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=105;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
