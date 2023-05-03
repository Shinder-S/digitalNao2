USE `person_db`;
DROP TABLE IF EXISTS `person_db`.`person_list`;
CREATE TABLE `person_db`.`person_list` (
`id` varchar(16) NOT NULL,
`name` varchar(32) NOT NULL,
`birthdate` date NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;