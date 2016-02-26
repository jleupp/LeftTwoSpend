-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema left2spenddb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `left2spenddb` ;

-- -----------------------------------------------------
-- Schema left2spenddb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `left2spenddb` DEFAULT CHARACTER SET utf8 ;
SHOW WARNINGS;
USE `left2spenddb` ;

-- -----------------------------------------------------
-- Table `account`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `account` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `account` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `monthly_allowance` DECIMAL(7,2) NOT NULL DEFAULT 0.0,
  `spent_this_month` DECIMAL(7,2) NOT NULL DEFAULT 0.0,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `user` (
  `email` VARCHAR(45) NOT NULL,
  `amount_spent` DECIMAL(7,2) NOT NULL DEFAULT 0.0,
  `password` VARCHAR(45) NOT NULL,
  `account_id` INT NULL,
  PRIMARY KEY (`email`),
  CONSTRAINT `FK_users_account_id`
    FOREIGN KEY (`account_id`)
    REFERENCES `account` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE UNIQUE INDEX `email_UNIQUE` ON `user` (`email` ASC);

SHOW WARNINGS;
CREATE INDEX `FK_users_account_id_idx` ON `user` (`account_id` ASC);

SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `account`
-- -----------------------------------------------------
START TRANSACTION;
USE `left2spenddb`;
INSERT INTO `account` (`id`, `monthly_allowance`, `spent_this_month`) VALUES (1, 3000, 0);
INSERT INTO `account` (`id`, `monthly_allowance`, `spent_this_month`) VALUES (2, 100, 0);

COMMIT;


-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `left2spenddb`;
INSERT INTO `user` (`email`, `amount_spent`, `password`, `account_id`) VALUES ('jeffrey.leupp@gmail.com', 0, 'rowcol', 1);
INSERT INTO `user` (`email`, `amount_spent`, `password`, `account_id`) VALUES ('elenapignatelli@gmail.com', 0, 'pipe', 1);
INSERT INTO `user` (`email`, `amount_spent`, `password`, `account_id`) VALUES ('docmeow@mail.com', 0, 'meow', 2);

COMMIT;

