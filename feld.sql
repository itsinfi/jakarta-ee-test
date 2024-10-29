-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 29. Okt 2024 um 20:53
-- Server-Version: 10.4.27-MariaDB
-- PHP-Version: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `jarkarta-ee-test`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `feld`
--

CREATE TABLE `feld` (
  `feldnummer` int(11) NOT NULL,
  `groesse_ha` int(11) NOT NULL,
  `bodenart` varchar(50) NOT NULL,
  `standort` varchar(50) NOT NULL,
  `besitzer` varchar(50) NOT NULL,
  `anmerkungen` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Daten für Tabelle `feld`
--

INSERT INTO `feld` (`feldnummer`, `groesse_ha`, `bodenart`, `standort`, `besitzer`, `anmerkungen`) VALUES
(1, 55, 'Lehm', 'Musterstadt Nord', 'Landwirt A', 'Sehr fruchtbar'),
(2, 100, 'Sand', 'Musterstadt Süd', 'Landwirt B', 'Trockenheit erwartet'),
(3, 73, 'Ton', 'Musterstadt West', 'Landwirt C', 'Hanglage');

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `feld`
--
ALTER TABLE `feld`
  ADD PRIMARY KEY (`feldnummer`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `feld`
--
ALTER TABLE `feld`
  MODIFY `feldnummer` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
