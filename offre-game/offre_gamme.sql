-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mar. 27 juin 2023 à 21:47
-- Version du serveur : 10.4.27-MariaDB
-- Version de PHP : 8.0.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données : `offre_gamme`
--

-- --------------------------------------------------------

--
-- Structure de la table `categorie_decolettage`
--

CREATE TABLE `categorie_decolettage` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `category_parametre_decolletage`
--

CREATE TABLE `category_parametre_decolletage` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `complex_task_id` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Déchargement des données de la table `category_parametre_decolletage`
--

INSERT INTO `category_parametre_decolletage` (`id`, `name`, `complex_task_id`) VALUES
(1, 'Tournage + Coupe', '6a1dd975-b63a-473d-8f22-1151bb1c9be0'),
(2, 'Trou Central', '6a1dd975-b63a-473d-8f22-1151bb1c9be0'),
(3, 'Fraisage de Forme + Trou Excentré', '6a1dd975-b63a-473d-8f22-1151bb1c9be0'),
(4, 'Taillage + Autres', '6a1dd975-b63a-473d-8f22-1151bb1c9be0');

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `id` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `default_parameter`
--

CREATE TABLE `default_parameter` (
  `rang` bigint(20) NOT NULL,
  `outil_decolletage` varchar(255) DEFAULT NULL,
  `atelier` varchar(255) DEFAULT NULL,
  `box1` bit(1) NOT NULL,
  `box2` bit(1) NOT NULL,
  `box3` bit(1) NOT NULL,
  `box4` bit(1) NOT NULL,
  `box5` bit(1) NOT NULL,
  `cout_moyen_outil` double NOT NULL,
  `indirect_pur` double NOT NULL,
  `marge` double NOT NULL,
  `operation` varchar(255) DEFAULT NULL,
  `taux_horaire_production` double NOT NULL,
  `taux_horaire_reglage` double NOT NULL,
  `temps_de_cycle` double NOT NULL,
  `temps_de_montage` double NOT NULL,
  `valeur1` double NOT NULL,
  `valeur2` double NOT NULL,
  `valeur3` double NOT NULL,
  `valeur4` double NOT NULL,
  `valeur5` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `default_parameter2`
--

CREATE TABLE `default_parameter2` (
  `rang` bigint(20) NOT NULL,
  `categorie_piece` double NOT NULL,
  `statut_concept` varchar(255) DEFAULT NULL,
  `avance_coupe` varchar(255) DEFAULT NULL,
  `burin_ebavurage` double NOT NULL,
  `engrenage` varchar(255) DEFAULT NULL,
  `machine` varchar(255) DEFAULT NULL,
  `matiere` varchar(255) DEFAULT NULL,
  `type_usinage` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `parametre_decolletage`
--

CREATE TABLE `parametre_decolletage` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `category_parametre_decolletage_id` bigint(20) DEFAULT NULL,
  `cout_moyen_outils` double NOT NULL,
  `temps_de_montage` double NOT NULL,
  `status` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Déchargement des données de la table `parametre_decolletage`
--

INSERT INTO `parametre_decolletage` (`id`, `name`, `category_parametre_decolletage_id`, `cout_moyen_outils`, `temps_de_montage`, `status`) VALUES
(1, 'TourneurAvant', 1, 0, 0.3333, b'1'),
(2, 'TourneurArriere', 1, 0, 0.3333, b'1'),
(3, 'EbaucheAvant', 1, 0, 0.3333, b'1'),
(4, 'EbaucheArriere', 1, 0, 0.3333, b'1'),
(5, 'EbauchePelle', 1, 0, 0.3333, b'0'),
(6, 'Coupe', 1, 0, 0.3333, b'1'),
(7, 'CoupeEnRetrait', 1, 48, 0.6667, b'0'),
(8, 'BurinDeForme', 1, 48, 0.6667, b'0'),
(9, 'BurinPCD', 1, 300, 0.6667, b'0'),
(10, 'BurinPiqureAvant', 1, 48, 0.3333, b'0'),
(11, 'BurinPiqureArriere', 1, 48, 0.3333, b'0'),
(12, 'BurinDiamant', 1, 1500, 1, b'0'),
(13, 'BurinAPiquerInverse', 1, 48, 0.3333, b'0'),
(14, 'BurinAPiquer', 1, 48, 0.3333, b'0'),
(15, 'BurinAPiquerSpecial', 1, 48, 0.3333, b'0'),
(16, 'FaceAvantQueueAigle', 1, 48, 0.6667, b'0'),
(17, 'SimultaneeAvant', 1, 96, 0.6666, b'1'),
(18, 'SimultaneeArriere', 1, 96, 0.6666, b'1'),
(19, 'MecheACanon', 2, 48, 0.3333, b'0'),
(20, 'MechePlate', 2, 48, 0.3333, b'0'),
(21, 'CentreurEWAG', 2, 1500, 1, b'0'),
(22, 'CenteurStandard', 2, 48, 0.3333, b'0'),
(23, 'BrunissoirSpecial', 2, 48, 0.3333, b'0'),
(24, 'Brunissoir', 2, 48, 0.3333, b'0'),
(25, 'Aleseur', 2, 48, 0.6667, b'0'),
(26, 'AleseurSpecial', 2, 96, 0.6666, b'1'),
(27, 'Decreurseur', 2, 96, 0.6666, b'1'),
(28, 'Taraud', 2, 96, 0.6666, b'1'),
(29, 'MecheACanonDegagee', 2, 48, 0.3333, b'0'),
(30, 'MecheACanonEtagee', 2, 48, 0.3333, b'0'),
(31, 'DecreuseurSpecial', 2, 48, 0.3333, b'1'),
(32, 'MecheAEbauche', 2, 28, 0.3333, b'0'),
(33, 'FraiseTroisQuartSdt', 2, 50, 0.3333, b'0'),
(34, 'BrocheDeForme', 2, 400, 1, b'0'),
(35, 'Fraise1Dent', 2, 48, 0.3333, b'0'),
(36, 'Fraise2Dent', 2, 48, 0.3333, b'0'),
(37, 'Broche', 2, 48, 0.3333, b'1'),
(38, 'TaraudSpecial', 3, 50, 0.3333, b'0'),
(39, 'FraiseScie', 3, 28, 0.3333, b'0'),
(40, 'Fraise3Dents', 3, 48, 0.3333, b'0'),
(41, 'FraiseMultiDents', 3, 48, 0.3333, b'0'),
(42, 'Fraise3DentsSdt', 3, 28, 0.3333, b'0'),
(43, 'FraiseGLOOR', 3, 300, 0.3333, b'0'),
(44, 'MechePlate', 3, 48, 0.3333, b'0'),
(45, 'MecheExcentree', 3, 48, 0.3333, b'1'),
(46, 'FraiseDiamant', 3, 0, 1, b'0'),
(47, 'Fraise1DentEtagee', 3, 48, 0.3333, b'0'),
(48, 'FraiseARoulerAvant', 3, 48, 0.5, b'0'),
(49, 'FraiseScieSpeciale', 3, 48, 0.3333, b'1'),
(50, 'FraiseTube1Dent', 3, 48, 0.3333, b'0'),
(51, 'FraiseAbredeBarilletAchat', 3, 0, 1, b'0'),
(52, 'FraiseSpecial', 3, 48, 0.3333, b'1'),
(53, 'FraiseAbredeBarillet', 3, 0, 1, b'1'),
(54, 'MecheACanontroisQuart', 3, 48, 0.3333, b'0'),
(55, 'MecheExcentreedeForme', 3, 48, 0.3333, b'0'),
(56, 'FraiseARoulerArriere', 3, 48, 0.5, b'0'),
(57, 'FraiseParGeneration', 4, 530, 2, b'0'),
(58, 'FraiseDentParDent', 4, 48, 1, b'0'),
(59, 'FraiseACentre', 4, 48, 0.3333, b'1'),
(60, 'FraiseGloorDenture', 4, 300, 2, b'0');

-- --------------------------------------------------------

--
-- Structure de la table `piece`
--

CREATE TABLE `piece` (
  `id` varchar(255) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `piece_name` varchar(255) DEFAULT NULL,
  `plan_name` varchar(255) DEFAULT NULL,
  `client_id` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `sub_other_task`
--

CREATE TABLE `sub_other_task` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `numero_sequence` double NOT NULL,
  `temps_de_production` double NOT NULL,
  `task_id` varchar(255) DEFAULT NULL,
  `temps_de_reglage` double NOT NULL,
  `status` bit(1) NOT NULL,
  `temps_inter_operatoire_en_heure` double NOT NULL,
  `calculpvenchf` double NOT NULL,
  `calcul_pr_enchf` double NOT NULL,
  `indirect` double NOT NULL,
  `marge` double NOT NULL,
  `taux_horaire_production` double NOT NULL,
  `taux_horaire_reglage` double NOT NULL,
  `temps_de_passage_en_jour` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Déchargement des données de la table `sub_other_task`
--

INSERT INTO `sub_other_task` (`id`, `name`, `numero_sequence`, `temps_de_production`, `task_id`, `temps_de_reglage`, `status`, `temps_inter_operatoire_en_heure`, `calculpvenchf`, `calcul_pr_enchf`, `indirect`, `marge`, `taux_horaire_production`, `taux_horaire_reglage`, `temps_de_passage_en_jour`) VALUES
(1, 'Nettoyage Piece', 1, 0, '08cc366a-0ec1-481a-b764-ac5ab7b3644a', 0.5, b'1', 8, 0, 0, 0.23, 0.12, 0, 61.71, 0),
(2, 'Evaluation Qualite', 2, 0, '08cc366a-0ec1-481a-b764-ac5ab7b3644a', 0.42, b'1', 8, 0, 0, 0.23, 0.12, 0, 0, 0),
(3, 'Nettoyage Piece', 20, 0, '6a1dd975-b63a-473d-8f22-1151bb1c9be0', 0.42, b'1', 8, 0, 0, 0.23, 0.12, 0, 0, 0),
(4, 'Evaluation Qualite', 21, 0, '6a1dd975-b63a-473d-8f22-1151bb1c9be0', 1, b'1', 8, 0, 0, 0.23, 0.12, 0, 0, 0);

-- --------------------------------------------------------

--
-- Structure de la table `synthesis`
--

CREATE TABLE `synthesis` (
  `id` bigint(20) NOT NULL,
  `categorie_piece` int(11) NOT NULL,
  `lot_de_fabrication` double NOT NULL,
  `lot_finance` double NOT NULL,
  `prix_de_revient` double NOT NULL,
  `quantite_piece_client` double NOT NULL,
  `temps_de_passage` double NOT NULL,
  `piece_id` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `task`
--

CREATE TABLE `task` (
  `type` varchar(10) NOT NULL,
  `id` varchar(255) NOT NULL,
  `task_name` varchar(255) DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `numero` double DEFAULT NULL,
  `temps_cycle_de_base_second` double DEFAULT NULL,
  `temps_de_cycle_calculer_second` double DEFAULT NULL,
  `temps_de_reglage_heur` double DEFAULT NULL,
  `piece_id` varchar(255) DEFAULT NULL,
  `task_category_id` bigint(20) DEFAULT NULL,
  `categorie_decolettage_id` bigint(20) DEFAULT NULL,
  `moyenne_programmation_en_heure` double DEFAULT NULL,
  `temps_de_cycle_de_base` double DEFAULT NULL,
  `cout_totaux_outils` double DEFAULT NULL,
  `nbre_pieces_par_jour` double DEFAULT NULL,
  `tps_embarreur_canon` double DEFAULT NULL,
  `tps_mise_au_point` double DEFAULT NULL,
  `tps_posage_outils` double DEFAULT NULL,
  `tps_preparation_outils` double DEFAULT NULL,
  `tps_total_reglage` double DEFAULT NULL,
  `proportion_total_temps` double DEFAULT NULL,
  `calculpvenchf` double NOT NULL,
  `calcul_pr_enchf` double NOT NULL,
  `indirect` double NOT NULL,
  `marge` double NOT NULL,
  `taux_horaire_production` double NOT NULL,
  `taux_horaire_reglage` double NOT NULL,
  `temps_de_passage_en_jour` double NOT NULL,
  `temps_inter_operatoire_en_heure` double NOT NULL,
  `temps_pour_pcs_en_heure_par_piece` double NOT NULL,
  `pool_machine` varchar(255) DEFAULT NULL,
  `temps_de_reglage_en_heure` double NOT NULL,
  `edit` bit(1) NOT NULL,
  `temps_de_production` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Déchargement des données de la table `task`
--

INSERT INTO `task` (`type`, `id`, `task_name`, `status`, `numero`, `temps_cycle_de_base_second`, `temps_de_cycle_calculer_second`, `temps_de_reglage_heur`, `piece_id`, `task_category_id`, `categorie_decolettage_id`, `moyenne_programmation_en_heure`, `temps_de_cycle_de_base`, `cout_totaux_outils`, `nbre_pieces_par_jour`, `tps_embarreur_canon`, `tps_mise_au_point`, `tps_posage_outils`, `tps_preparation_outils`, `tps_total_reglage`, `proportion_total_temps`, `calculpvenchf`, `calcul_pr_enchf`, `indirect`, `marge`, `taux_horaire_production`, `taux_horaire_reglage`, `temps_de_passage_en_jour`, `temps_inter_operatoire_en_heure`, `temps_pour_pcs_en_heure_par_piece`, `pool_machine`, `temps_de_reglage_en_heure`, `edit`, `temps_de_production`) VALUES
('OTHER', '08cc366a-0ec1-481a-b764-ac5ab7b3644a', 'Decoupage', b'0', 0, 0.5, 0.23, 2, NULL, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0.433, 0, 0, 0.23, 0.12, 0, 0, 0, 30, 0, 'POOL B', 2, b'0', 0),
('OTHER', '0cdd9dcd-37f5-4943-82e5-657798baf709', 'RecoupManuelleTrou', b'0', 0, 25, 32, 0.5, NULL, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0.254, 0, 0, 0.23, 0.12, 0, 0, 0, 0, 0, 'POOL B', 0, b'0', 0),
('OTHER', '1506c27c-7bc9-42f1-88f6-f9d917cb2284', 'Double Colima_Meule', b'0', 0, 25, 32, 0.5, NULL, 5, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0.254, 0, 0, 0.23, 0.12, 0, 0, 0, 0, 0, 'POOL B', 0, b'0', 0),
('OTHER', '15be8e4e-fcfa-4101-88f1-1a4be160210d', 'DecolletageTest', b'0', 0, 25, 32, 0.5, NULL, 7, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0.254, 0, 0, 0.23, 0.12, 0, 0, 0, 0, 0, 'POOL B', 0, b'0', 0),
('OTHER', '29f1a09d-c024-4231-bb19-848add9f6afb', 'PaPManuelSansAffutage', b'0', 0, 25, 32, 0.5, NULL, 7, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0.254, 0, 0, 0.23, 0.12, 0, 0, 0, 0, 0, 'POOL B', 0, b'0', 0),
('OTHER', '32638150-e30b-4329-a4fe-7862e0e4bea0', 'kAssemblage', b'0', 0, 25, 32, 0.5, NULL, 15, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0.254, 0, 0, 0.23, 0.12, 0, 0, 0, 0, 0, 'POOL B', 0, b'0', 0),
('OTHER', '3c7a189b-72ca-4811-a30b-0d502b1bf39b', 'Chassage Roue', b'0', 0, 25, 32, 0.5, NULL, 7, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0.254, 0, 0, 0.23, 0.12, 0, 0, 0, 0, 0, 'POOL B', 0, b'0', 0),
('OTHER', '3ebe73c6-46a3-4077-890f-8885bda06eaf', 'RouePlaineGrande', b'0', 0, 25, 32, 0.5, NULL, 4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0.254, 0, 0, 0.23, 0.12, 0, 0, 0, 0, 0, 'POOL B', 0, b'0', 0),
('OTHER', '40e3af85-f0b9-47bb-96c3-e7fa28a0cdd6', 'Task4', b'0', 0, 25, 32, 0.5, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0.254, 0, 0, 0.23, 0.12, 0, 0, 0, 0, 0, 'POOL B', 0, b'0', 0),
('OTHER', '4412f1fe-a63c-42ae-aed1-3777b1df1d8a', 'TripleMoulureTV', b'0', 0, 25, 32, 0.5, NULL, 6, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0.254, 0, 0, 0.23, 0.12, 0, 0, 0, 0, 0, 'POOL B', 0, b'0', 0),
('OTHER', '4a4a7ae8-655b-45dc-a6d5-57d4a3653ece', 'Colima_Burin', b'0', 0, 25, 32, 0.5, NULL, 5, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0.254, 0, 0, 0.23, 0.12, 0, 0, 0, 0, 0, 'POOL B', 0, b'0', 0),
('OTHER', '4bf460f9-b74f-47c6-bc1d-e5e11c4c930e', 'Cerclage 2 ', b'0', 0, 25, 32, 0.5, NULL, 12, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0.254, 0, 0, 0.23, 0.12, 0, 0, 0, 0, 0, 'POOL B', 0, b'0', 0),
('OTHER', '50b369cb-fca7-4be2-bc6f-a634ce7dc204', 'Colima_Meule', b'0', 0, 25, 32, 0.5, NULL, 4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0.254, 0, 0, 0.23, 0.12, 0, 0, 0, 0, 0, 'POOL B', 0, b'0', 0),
('DECOL', '6a1dd975-b63a-473d-8f22-1151bb1c9be0', 'Decolletage', b'0', 0, 0, NULL, 23, NULL, 1, NULL, 0.75, 225, 242, 384, 2, 2, 8, 2, 14.75, 0.254, 0, 0, 0.23, 0.12, 0, 0, 0, 30, 0, 'POOL B', 20, b'0', 0),
('OTHER', '6abeb1ed-068b-4bfa-82e6-0f0655703175', 'Roulage', b'0', 0, 25, 32, 0.5, NULL, 8, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0.254, 0, 0, 0.23, 0.12, 0, 0, 0, 0, 0, 'POOL B', 0, b'0', 0),
('OTHER', '6bd3170a-f657-47a7-9a27-8202c1461f7d', 'RouePlainePetite', b'0', 0, 25, 32, 0.5, NULL, 4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0.254, 0, 0, 0.23, 0.12, 0, 0, 0, 0, 0, 'POOL B', 0, b'0', 0),
('OTHER', '6e8fc98a-2abc-4db4-acbc-fb2c6373356b', 'OP-Manuelle1', b'0', 0, 25, 32, 0.5, NULL, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0.254, 0, 0, 0.23, 0.12, 0, 0, 0, 0, 0, 'POOL B', 0, b'0', 0),
('OTHER', '70108dcb-7cb6-4a66-b22b-629fcb09ff18', 'MoulurTV_Sdt', b'0', 0, 25, 32, 0.5, NULL, 6, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0.254, 0, 0, 0.23, 0.12, 0, 0, 0, 0, 0, 'POOL B', 0, b'0', 0),
('OTHER', '73328b36-40ba-4130-ad80-31eebe937687', 'Brochage', b'0', 0, 25, 32, 0.5, NULL, 14, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0.254, 0, 0, 0.23, 0.12, 0, 0, 0, 0, 0, 'POOL B', 0, b'0', 0),
('OTHER', '80be1a3d-8936-446c-b851-a94f403d1db1', 'PaPManuelSansAffutage', b'0', 0, 25, 32, 0.5, NULL, 7, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0.254, 0, 0, 0.23, 0.12, 0, 0, 0, 0, 0, 'POOL B', 0, b'0', 0),
('OTHER', '82c70455-4eb8-4b9d-8cb3-d679dec20287', 'Traitement de surface ', b'0', 0, 25, 32, 0.5, NULL, 16, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0.254, 0, 0, 0.23, 0.12, 0, 0, 0, 0, 0, 'POOL B', 0, b'0', 0),
('OTHER', '85111ee9-ae1c-446b-9706-11c6a477872c', 'Colima_Meule', b'0', 0, 25, 32, 0.5, NULL, 5, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0.254, 0, 0, 0.23, 0.12, 0, 0, 0, 0, 0, 'POOL B', 0, b'0', 0),
('OTHER', '893498cb-505c-445c-8174-eff5485107d8', 'Moulur-TV', b'0', 0, 25, 32, 0.5, NULL, 6, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0.254, 0, 0, 0.23, 0.12, 0, 0, 0, 0, 0, 'POOL B', 0, b'0', 0),
('OTHER', '95f5cbb4-e5ad-4882-864c-782dd7712f79', 'Task1', b'0', 0, 25, 32, 0.5, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0.254, 0, 0, 0.23, 0.12, 0, 0, 0, 0, 0, 'POOL B', 0, b'0', 0),
('OTHER', 'a2ae4d96-1a71-43ec-9bbb-c6de862d2a78', 'Terminaison Mauelle', b'0', 0, 25, 32, 0.5, NULL, 18, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0.254, 0, 0, 0.23, 0.12, 0, 0, 0, 0, 0, 'POOL B', 0, b'0', 0),
('OTHER', 'b7095b70-bde2-46fa-b29b-a80f6bd68bfb', 'Polissage', b'0', 0, 25, 32, 0.5, NULL, 17, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0.254, 0, 0, 0.23, 0.12, 0, 0, 0, 0, 0, 'POOL B', 0, b'0', 0),
('OTHER', 'b7be9643-09d1-45c0-be00-87d69b3d2463', 'Roue_A_Bras', b'0', 0, 25, 32, 0.5, NULL, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0.254, 0, 0, 0.23, 0.12, 0, 0, 0, 0, 0, 'POOL B', 0, b'0', 0),
('OTHER', 'bcea3c6f-0678-4ff8-8ec1-b52cd3014fa6', 'RectifQuill(TrouFini)', b'0', 0, 25, 32, 0.5, NULL, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0.254, 0, 0, 0.23, 0.12, 0, 0, 0, 0, 0, 'POOL B', 0, b'0', 0),
('OTHER', 'c200e519-66c3-48a5-910a-7594830f082f', 'DoubleMoulureTV-1', b'0', 0, 25, 32, 0.5, NULL, 6, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0.254, 0, 0, 0.23, 0.12, 0, 0, 0, 0, 0, 'POOL B', 0, b'0', 0),
('OTHER', 'c7a72b70-a233-4537-a93b-33f5955f5ab4', 'Terminaison Horlogère', b'0', 0, 25, 32, 0.5, NULL, 9, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0.254, 0, 0, 0.23, 0.12, 0, 0, 0, 0, 0, 'POOL B', 0, b'0', 0),
('OTHER', 'ca38aced-e57a-4f7f-a281-9da63dbc6996', 'Bouclard', b'0', 0, 25, 32, 0.5, NULL, 10, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0.254, 0, 0, 0.23, 0.12, 0, 0, 0, 0, 0, 'POOL B', 0, b'0', 0),
('OTHER', 'cb6b5fd5-8b55-490e-b5bf-cf1d82e637d9', 'Task2', b'0', 0, 25, 32, 0.5, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0.254, 0, 0, 0.23, 0.12, 0, 0, 0, 0, 0, 'POOL B', 0, b'0', 0),
('OTHER', 'd048bedb-d593-46e9-b8c4-0c04a65cd17a', 'RectifQuill + RdF', b'0', 0, 25, 32, 0.5, NULL, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0.254, 0, 0, 0.23, 0.12, 0, 0, 0, 0, 0, 'POOL B', 0, b'0', 0),
('OTHER', 'd1273074-0981-4c65-8f2f-7e75fc3eeef5', 'Moulure', b'0', 0, 25, 32, 0.5, NULL, 13, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0.254, 0, 0, 0.23, 0.12, 0, 0, 0, 0, 0, 'POOL B', 0, b'0', 0),
('OTHER', 'd3433dcd-083c-4849-b575-aa34905a0a86', 'Contre-Perç_Sdt', b'0', 0, 25, 32, 0.5, NULL, 5, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0.254, 0, 0, 0.23, 0.12, 0, 0, 0, 0, 0, 'POOL B', 0, b'0', 0),
('OTHER', 'd3ffe812-43b9-43be-a3fd-cbafb67a1e88', 'Contre-Perç_Sdt', b'0', 0, 25, 32, 0.5, NULL, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0.254, 0, 0, 0.23, 0.12, 0, 0, 0, 0, 0, 'POOL B', 0, b'0', 0),
('OTHER', 'd62d4e12-17e6-4972-95bf-e950dc11b6a3', 'OP-Manuelle', b'0', 0, 25, 32, 0.5, NULL, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0.254, 0, 0, 0.23, 0.12, 0, 0, 0, 0, 0, 'POOL B', 0, b'0', 0),
('OTHER', 'd795e967-466f-4a8d-beda-8f2541b20cdd', 'RecoupDeForme', b'0', 0, 25, 32, 0.5, NULL, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0.254, 0, 0, 0.23, 0.12, 0, 0, 0, 0, 0, 'POOL B', 0, b'0', 0),
('OTHER', 'f1784d27-d692-4815-8101-ce502bf09a10', 'RoueAJantesLambo', b'0', 0, 25, 32, 0.5, NULL, 4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0.254, 0, 0, 0.23, 0.12, 0, 0, 0, 0, 0, 'POOL B', 0, b'0', 0);

-- --------------------------------------------------------

--
-- Structure de la table `task_category`
--

CREATE TABLE `task_category` (
  `id` bigint(20) NOT NULL,
  `category_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Déchargement des données de la table `task_category`
--

INSERT INTO `task_category` (`id`, `category_name`) VALUES
(1, 'Decolletage/Reprise'),
(2, 'Decoupage'),
(3, 'Cerclage'),
(4, 'Colimaçonnage'),
(5, 'Contre-Perçage'),
(6, 'Moulur-TV'),
(7, 'Taillage/Enchainage'),
(8, 'Roulage'),
(9, 'Terminaison Horlogère'),
(10, 'Bouclard'),
(11, 'OP-Manuelle'),
(12, 'Cerclage 2'),
(13, 'Moulure'),
(14, 'Brochage'),
(15, 'Assemblage'),
(16, 'Traitement de surface'),
(17, 'Polissage'),
(18, 'Terminaison Mauelle');

-- --------------------------------------------------------

--
-- Structure de la table `task_precision_parameter`
--

CREATE TABLE `task_precision_parameter` (
  `id` bigint(20) NOT NULL,
  `pieces_par_jour` double NOT NULL,
  `taux_de_rendment` double NOT NULL,
  `calcul_inverse_pieces_par_jour` double NOT NULL,
  `efficience_poste` double NOT NULL,
  `nombre_piece_par_heure` double NOT NULL,
  `nombre_piece_par_heure_apres_deduction` double NOT NULL,
  `pour_mil_par_pcs_en_heure` double NOT NULL,
  `status` bit(1) NOT NULL,
  `temps_de_cycle_gamme_en_seconde` double NOT NULL,
  `temps_ouverture_min` double NOT NULL,
  `other_task_id` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Déchargement des données de la table `task_precision_parameter`
--

INSERT INTO `task_precision_parameter` (`id`, `pieces_par_jour`, `taux_de_rendment`, `calcul_inverse_pieces_par_jour`, `efficience_poste`, `nombre_piece_par_heure`, `nombre_piece_par_heure_apres_deduction`, `pour_mil_par_pcs_en_heure`, `status`, `temps_de_cycle_gamme_en_seconde`, `temps_ouverture_min`, `other_task_id`) VALUES
(1, 23305, 0.84, 50000, 0.85, 7200, 4080, 0.29, b'1', 0.9, 480, '08cc366a-0ec1-481a-b764-ac5ab7b3644a');

-- --------------------------------------------------------

--
-- Structure de la table `task_time_parameter`
--

CREATE TABLE `task_time_parameter` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `nombre_heure` double NOT NULL,
  `proportion_temps` double NOT NULL,
  `status` bit(1) NOT NULL,
  `temps_min_par_heure` double NOT NULL,
  `total_time_en_min` double NOT NULL,
  `other_task_id` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Déchargement des données de la table `task_time_parameter`
--

INSERT INTO `task_time_parameter` (`id`, `name`, `nombre_heure`, `proportion_temps`, `status`, `temps_min_par_heure`, `total_time_en_min`, `other_task_id`) VALUES
(1, 'Auto Controle', 8, 0.167, b'1', 10, 80, '08cc366a-0ec1-481a-b764-ac5ab7b3644a'),
(2, 'Manipulation', 8, 0.083, b'1', 5, 40, '08cc366a-0ec1-481a-b764-ac5ab7b3644a'),
(3, 'Nettoyage Bande & Surveillance', 8, 0.083, b'1', 5, 40, '08cc366a-0ec1-481a-b764-ac5ab7b3644a'),
(4, 'Affutage Lege', 8, 0.1, b'1', 6, 48, '08cc366a-0ec1-481a-b764-ac5ab7b3644a');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `categorie_decolettage`
--
ALTER TABLE `categorie_decolettage`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `category_parametre_decolletage`
--
ALTER TABLE `category_parametre_decolletage`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKb8hv8v220uw57jbqokjdx0du1` (`complex_task_id`);

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `default_parameter`
--
ALTER TABLE `default_parameter`
  ADD PRIMARY KEY (`rang`);

--
-- Index pour la table `default_parameter2`
--
ALTER TABLE `default_parameter2`
  ADD PRIMARY KEY (`rang`);

--
-- Index pour la table `parametre_decolletage`
--
ALTER TABLE `parametre_decolletage`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK33ffg881r6m98ik8dg94edm99` (`category_parametre_decolletage_id`);

--
-- Index pour la table `piece`
--
ALTER TABLE `piece`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK7nqxu4njf0exvh0gn2irtmbfv` (`client_id`);

--
-- Index pour la table `sub_other_task`
--
ALTER TABLE `sub_other_task`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKjrb3h6n3g2cjopytlvxeaa3t8` (`task_id`);

--
-- Index pour la table `synthesis`
--
ALTER TABLE `synthesis`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKbaaleoc0o2tblwqbvnkapxn3y` (`piece_id`);

--
-- Index pour la table `task`
--
ALTER TABLE `task`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKndhkbekn7uxvbd70dnw2fcjk8` (`piece_id`),
  ADD KEY `FK8nbmbrk24s1dkt7h3fsfl6mg8` (`task_category_id`),
  ADD KEY `FKfwi3ey964j8p83natt0g7o65i` (`categorie_decolettage_id`);

--
-- Index pour la table `task_category`
--
ALTER TABLE `task_category`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `task_precision_parameter`
--
ALTER TABLE `task_precision_parameter`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKn56url4subcswtdq4boqqhuc3` (`other_task_id`);

--
-- Index pour la table `task_time_parameter`
--
ALTER TABLE `task_time_parameter`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK3bpmlpmm79bqbvehdmixnnku0` (`other_task_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `categorie_decolettage`
--
ALTER TABLE `categorie_decolettage`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `category_parametre_decolletage`
--
ALTER TABLE `category_parametre_decolletage`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `default_parameter`
--
ALTER TABLE `default_parameter`
  MODIFY `rang` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `default_parameter2`
--
ALTER TABLE `default_parameter2`
  MODIFY `rang` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `parametre_decolletage`
--
ALTER TABLE `parametre_decolletage`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=61;

--
-- AUTO_INCREMENT pour la table `sub_other_task`
--
ALTER TABLE `sub_other_task`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `synthesis`
--
ALTER TABLE `synthesis`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `task_category`
--
ALTER TABLE `task_category`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT pour la table `task_precision_parameter`
--
ALTER TABLE `task_precision_parameter`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `task_time_parameter`
--
ALTER TABLE `task_time_parameter`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `category_parametre_decolletage`
--
ALTER TABLE `category_parametre_decolletage`
  ADD CONSTRAINT `FKb8hv8v220uw57jbqokjdx0du1` FOREIGN KEY (`complex_task_id`) REFERENCES `task` (`id`);

--
-- Contraintes pour la table `parametre_decolletage`
--
ALTER TABLE `parametre_decolletage`
  ADD CONSTRAINT `FK33ffg881r6m98ik8dg94edm99` FOREIGN KEY (`category_parametre_decolletage_id`) REFERENCES `category_parametre_decolletage` (`id`);

--
-- Contraintes pour la table `piece`
--
ALTER TABLE `piece`
  ADD CONSTRAINT `FK7nqxu4njf0exvh0gn2irtmbfv` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`);

--
-- Contraintes pour la table `sub_other_task`
--
ALTER TABLE `sub_other_task`
  ADD CONSTRAINT `FKjrb3h6n3g2cjopytlvxeaa3t8` FOREIGN KEY (`task_id`) REFERENCES `task` (`id`);

--
-- Contraintes pour la table `synthesis`
--
ALTER TABLE `synthesis`
  ADD CONSTRAINT `FKbaaleoc0o2tblwqbvnkapxn3y` FOREIGN KEY (`piece_id`) REFERENCES `piece` (`id`);

--
-- Contraintes pour la table `task`
--
ALTER TABLE `task`
  ADD CONSTRAINT `FK8nbmbrk24s1dkt7h3fsfl6mg8` FOREIGN KEY (`task_category_id`) REFERENCES `task_category` (`id`),
  ADD CONSTRAINT `FKfwi3ey964j8p83natt0g7o65i` FOREIGN KEY (`categorie_decolettage_id`) REFERENCES `categorie_decolettage` (`id`),
  ADD CONSTRAINT `FKndhkbekn7uxvbd70dnw2fcjk8` FOREIGN KEY (`piece_id`) REFERENCES `piece` (`id`);

--
-- Contraintes pour la table `task_precision_parameter`
--
ALTER TABLE `task_precision_parameter`
  ADD CONSTRAINT `FKn56url4subcswtdq4boqqhuc3` FOREIGN KEY (`other_task_id`) REFERENCES `task` (`id`);

--
-- Contraintes pour la table `task_time_parameter`
--
ALTER TABLE `task_time_parameter`
  ADD CONSTRAINT `FK3bpmlpmm79bqbvehdmixnnku0` FOREIGN KEY (`other_task_id`) REFERENCES `task` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
