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
-- Tabellenstruktur für Tabelle `mais`
--

CREATE TABLE `mais` (
  `id` int(11) NOT NULL,
  `sorte` varchar(50) NOT NULL,
  `pflanzdatum` varchar(50) NOT NULL,
  `erntezeit` varchar(50) NOT NULL,
  `menge_tonnen` int(11) NOT NULL,
  `feldnummer` int(11) NOT NULL,
  `duengemittel` varchar(50) NOT NULL,
  `anmerkungen` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Daten für Tabelle `mais`
--

INSERT INTO `mais` (`id`, `sorte`, `pflanzdatum`, `erntezeit`, `menge_tonnen`, `feldnummer`, `duengemittel`, `anmerkungen`) VALUES
(1, 'Zuckermais', '01.04.2024', '01.09.2024', 105, 1, 'NPK-DÃ¼nger', 'Gute Ernte erwartet'),
(2, 'Futtermais', '15.03.2024', '15.08.2024', 150, 2, 'Ammoniumnitrat', 'Erntezeit um 2 Wochen verschoben'),
(3, 'Pflanzenmais', '20.04.2024', '20.09.2024', 82, 3, 'Kali-DÃ¼nger', 'Regen erforderlich'),
(4, 'blub', '2asoihd', '239187', 192873, 1928063, 'brud', 's98uahd');

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `mais`
--
ALTER TABLE `mais`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `mais`
--
ALTER TABLE `mais`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
