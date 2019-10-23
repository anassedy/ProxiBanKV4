-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  mer. 23 oct. 2019 à 17:11
-- Version du serveur :  10.3.16-MariaDB
-- Version de PHP :  7.1.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `proxibanquev4`
--

-- --------------------------------------------------------

--
-- Structure de la table `agence`
--

CREATE TABLE `agence` (
  `id` bigint(20) NOT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `agence`
--

INSERT INTO `agence` (`id`, `adresse`, `nom`) VALUES
(1, 'xxxx', 'proxibanque');

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `id` bigint(20) NOT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `conseiller_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`id`, `adresse`, `email`, `nom`, `prenom`, `conseiller_id`) VALUES
(1, 'gaggaga', 'sjksks', 'anas', 'edy', 9),
(2, 'xxx', 'yyy', 'aa', 'bbb', 2),
(3, 'ddd', 'vvvv', 'bb', 'ccc', 2);

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

CREATE TABLE `compte` (
  `type_compte` varchar(31) NOT NULL,
  `num_compte` bigint(20) NOT NULL,
  `date_creation` datetime DEFAULT NULL,
  `solde` double NOT NULL,
  `decouvert` double DEFAULT NULL,
  `taux` double DEFAULT NULL,
  `client_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `compte`
--

INSERT INTO `compte` (`type_compte`, `num_compte`, `date_creation`, `solde`, `decouvert`, `taux`, `client_id`) VALUES
('CompteCourant', 1, '2019-10-23 11:27:11', 900, 1000, NULL, 2),
('CompteCourant', 2, '2019-10-23 11:27:33', 1065, 1000, NULL, 3);

-- --------------------------------------------------------

--
-- Structure de la table `compte_agence`
--

CREATE TABLE `compte_agence` (
  `num_compte` bigint(20) NOT NULL,
  `date_creation` datetime DEFAULT NULL,
  `solde` double NOT NULL,
  `agence_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `compte_agence`
--

INSERT INTO `compte_agence` (`num_compte`, `date_creation`, `solde`, `agence_id`) VALUES
(1, NULL, 105, 1);

-- --------------------------------------------------------

--
-- Structure de la table `conseiller_client`
--

CREATE TABLE `conseiller_client` (
  `id` bigint(20) NOT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `gerant_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `conseiller_client`
--

INSERT INTO `conseiller_client` (`id`, `adresse`, `email`, `nom`, `prenom`, `gerant_id`) VALUES
(2, NULL, NULL, 'anas', 'edchoury', NULL),
(7, NULL, NULL, 'hamza', 'hamza', 4),
(9, NULL, NULL, 'anas', 'edy', 4),
(11, 'ssss', 'xxvv', 'xxx', 'xxxx', 4);

-- --------------------------------------------------------

--
-- Structure de la table `gerant`
--

CREATE TABLE `gerant` (
  `id` bigint(20) NOT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `agence_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `gerant`
--

INSERT INTO `gerant` (`id`, `adresse`, `email`, `nom`, `prenom`, `agence_id`) VALUES
(4, NULL, NULL, 'hamza', 'omouh', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(12),
(12);

-- --------------------------------------------------------

--
-- Structure de la table `moderateur`
--

CREATE TABLE `moderateur` (
  `id` bigint(20) NOT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `moderateur`
--

INSERT INTO `moderateur` (`id`, `adresse`, `email`, `nom`, `prenom`) VALUES
(6, NULL, NULL, 'fz', 'nouaim');

-- --------------------------------------------------------

--
-- Structure de la table `operation`
--

CREATE TABLE `operation` (
  `numero` bigint(20) NOT NULL,
  `date_operation` datetime DEFAULT NULL,
  `montant` double NOT NULL,
  `id_compte_emetteur` bigint(20) DEFAULT NULL,
  `id_compte_recepteur` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `operation`
--

INSERT INTO `operation` (`numero`, `date_operation`, `montant`, `id_compte_emetteur`, `id_compte_recepteur`) VALUES
(1, '2019-10-23 11:30:59', 1000, 1, 2),
(2, '2019-10-23 12:22:35', 100, 1, 2);

-- --------------------------------------------------------

--
-- Structure de la table `parametrage`
--

CREATE TABLE `parametrage` (
  `id` bigint(20) NOT NULL,
  `commission` double NOT NULL,
  `graphe` bit(1) NOT NULL,
  `nombre_max_client` int(11) NOT NULL,
  `nombre_max_conseiller` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `parametrage`
--

INSERT INTO `parametrage` (`id`, `commission`, `graphe`, `nombre_max_client`, `nombre_max_conseiller`) VALUES
(1, 0.05, b'0', 5, 10);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `active` int(11) NOT NULL,
  `password` varchar(255) NOT NULL,
  `permissions` varchar(255) DEFAULT NULL,
  `roles` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  `employe_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `active`, `password`, `permissions`, `roles`, `username`, `employe_id`) VALUES
(1, 1, '$2a$10$JCcxbaoXiegzUmz5U2z0R.A9fZM8JbTrdTzZ/pg7tFagJx0iFpf9u', '', 'CONSEILLER', 'anas', 2),
(3, 1, '$2a$10$E3igjOCZiutxfnvK4eN95eLcUDQLgRG9mG7EfFaJnertCeVhzc8v6', '', 'GERANT', 'hamza', 4),
(5, 1, '$2a$10$ZhBIPSoOOCGkf7wkb5PsmuKiIFpuGUuniC/X0MlKAWwMMoIVtWXzi', '', 'MODERATEUR', 'fz', 6),
(10, 1, '$2a$10$sDhGcRGLjaRajpOzWwMwauk/10QH9H/M9Qa7IuzzuW5j7SoPO3ggS', '', 'CONSEILLER', 'xxx', 11);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `agence`
--
ALTER TABLE `agence`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKo7ywqo45o193qkm3uchetgpps` (`conseiller_id`);

--
-- Index pour la table `compte`
--
ALTER TABLE `compte`
  ADD PRIMARY KEY (`num_compte`),
  ADD KEY `FK5qv5tcfmwu2mli0brm27y13gl` (`client_id`);

--
-- Index pour la table `compte_agence`
--
ALTER TABLE `compte_agence`
  ADD PRIMARY KEY (`num_compte`),
  ADD KEY `FK2q3vqc09mne7k3vd41veycrvs` (`agence_id`);

--
-- Index pour la table `conseiller_client`
--
ALTER TABLE `conseiller_client`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK1gp5ryf856wvt5xy59h1vpj07` (`gerant_id`);

--
-- Index pour la table `gerant`
--
ALTER TABLE `gerant`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKmghgfrjlgv37ah0on1y292gy2` (`agence_id`);

--
-- Index pour la table `moderateur`
--
ALTER TABLE `moderateur`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `operation`
--
ALTER TABLE `operation`
  ADD PRIMARY KEY (`numero`),
  ADD KEY `FKm8mpsv58kr0o8ep810e59kjvv` (`id_compte_emetteur`),
  ADD KEY `FKj7p4cj7sp8c108o8g0hbxu8ma` (`id_compte_recepteur`);

--
-- Index pour la table `parametrage`
--
ALTER TABLE `parametrage`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `agence`
--
ALTER TABLE `agence`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `compte`
--
ALTER TABLE `compte`
  MODIFY `num_compte` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `compte_agence`
--
ALTER TABLE `compte_agence`
  MODIFY `num_compte` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `operation`
--
ALTER TABLE `operation`
  MODIFY `numero` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `parametrage`
--
ALTER TABLE `parametrage`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
