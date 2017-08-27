-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tempo de Geração: 
-- Versão do Servidor: 5.5.27
-- Versão do PHP: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Banco de Dados: `jdjavaback2017`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `td_teste_dados`
--

CREATE TABLE IF NOT EXISTS `td_teste_dados` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(255) NOT NULL,
  `valor` int(11) NOT NULL,
  `hora` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;

--
-- Extraindo dados da tabela `td_teste_dados`
--

INSERT INTO `td_teste_dados` (`id`, `tipo`, `valor`, `hora`) VALUES
(1, 'Umidade do solo', 1749940627, 25),
(2, 'Umidade ar', 155629810, 25),
(3, 'Umidade ar', -1465154080, 25),
(4, 'Umidade do solo', -1242363796, 25),
(5, 'Umidade do solo', 655996951, 25),
(6, 'Umidade do solo', 685382532, 25),
(7, 'Temperatura', -1915244821, 25),
(8, 'Umidade ar', -382464764, 25),
(9, 'Temperatura', 2092024388, 25),
(10, 'Umidade ar', -369526622, 25),
(11, 'Umidade do solo', 684358209, 25),
(12, 'Umidade ar', 1584853930, 25),
(13, 'Temperatura', 431529176, 25);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
