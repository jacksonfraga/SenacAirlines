-- phpMyAdmin SQL Dump
-- version 4.0.4.2
-- http://www.phpmyadmin.net
--
-- Máquina: localhost
-- Data de Criação: 26-Nov-2015 às 02:34
-- Versão do servidor: 5.6.13
-- versão do PHP: 5.4.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de Dados: `senacairlines`
--
CREATE DATABASE IF NOT EXISTS `senacairlines` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `senacairlines`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `aviao`
--

CREATE TABLE IF NOT EXISTS `aviao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(20) NOT NULL,
  `nome` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE IF NOT EXISTS `cliente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `rg` varchar(15) NOT NULL,
  `telefone` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `passagem`
--

CREATE TABLE IF NOT EXISTS `passagem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `vooId` int(11) NOT NULL,
  `clienteId` int(11) NOT NULL,
  `dataCompra` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `vooId` (`vooId`),
  KEY `clienteId` (`clienteId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `voo`
--

CREATE TABLE IF NOT EXISTS `voo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `origem` varchar(50) NOT NULL,
  `destino` varchar(50) NOT NULL,
  `hora` datetime NOT NULL,
  `aviaoId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `aviaoId` (`aviaoId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `passagem`
--
ALTER TABLE `passagem`
  ADD CONSTRAINT `passagem_ibfk_2` FOREIGN KEY (`clienteId`) REFERENCES `cliente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `passagem_ibfk_1` FOREIGN KEY (`vooId`) REFERENCES `voo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `voo`
--
ALTER TABLE `voo`
  ADD CONSTRAINT `voo_ibfk_1` FOREIGN KEY (`aviaoId`) REFERENCES `aviao` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
