-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema tim6
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema tim6
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tim6` DEFAULT CHARACTER SET utf8 ;
USE `tim6` ;

-- -----------------------------------------------------
-- Table `tim6`.`kategorija`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tim6`.`kategorija` (
  `id` INT NOT NULL AUTO INCEREMENT,
  `naziv` VARCHAR(45) NOT NULL,
  `opis` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tim6`.`uposlenik`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tim6`.`uposlenik` (
  `id` INT NOT NULL AUTO INCEREMENT,
  `ime_prezime` VARCHAR(45) NOT NULL,
  `datum_rođenja` DATE NULL,
  `jmbg` VARCHAR(45) NOT NULL,
  `broj_telefona` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `jmbg_UNIQUE` (`jmbg` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tim6`.`artikal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tim6`.`artikal` (
  `id` INT NOT NULL AUTO INCEREMENT,
  `naziv` VARCHAR(205) NOT NULL,
  `barkod` VARCHAR(13) NOT NULL,
  `jedinica_mjere` VARCHAR(45) NOT NULL,
  `cijena` DECIMAL NOT NULL,
  `zalihe_stanje` INT NOT NULL,
  `opis` VARCHAR(245) NULL,
  `kategorija_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_artikal_kategorija_idx` (`kategorija_id` ASC),
  CONSTRAINT `fk_artikal_kategorija`
    FOREIGN KEY (`kategorija_id`)
    REFERENCES `tim6`.`kategorija` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tim6`.`sef`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tim6`.`sef` (
  `uposlenik_id` INT NOT NULL,
  INDEX `fk_sef_uposlenik1_idx` (`uposlenik_id` ASC),
  CONSTRAINT `fk_sef_uposlenik1`
    FOREIGN KEY (`uposlenik_id`)
    REFERENCES `tim6`.`uposlenik` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tim6`.`kasir`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tim6`.`kasir` (
  `datum_zaposlenja` DATE NULL,
  `uposlenik_id` INT NOT NULL,
  INDEX `fk_kasir_uposlenik1_idx` (`uposlenik_id` ASC),
  CONSTRAINT `fk_kasir_uposlenik1`
    FOREIGN KEY (`uposlenik_id`)
    REFERENCES `tim6`.`uposlenik` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tim6`.`smjena`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tim6`.`smjena` (
  `id` INT NOT NULL AUTO INCEREMENT,
  `pocetak_smjene` TIMESTAMP NOT NULL,
  `kraj_smjene` TIMESTAMP NOT NULL,
  `kasir_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_racun_smjena1_idx` (`kasir_id` ASC),
  CONSTRAINT `fk_racun_smjena1`
    FOREIGN KEY (`kasir_id`)
    REFERENCES `tim6`.`kasir` (`uposlenik_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tim6`.`akcijapopust`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tim6`.`akcijapopust` (
  `id` INT NOT NULL AUTO INCEREMENT,
  `datum_pocetka` DATETIME NOT NULL,
  `datum_kraja` DATETIME NOT NULL,
  `opis` VARCHAR(245) NOT NULL,
  `iznos_popusta` INT(11) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tim6`.`racun`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tim6`.`racun` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `datum_i_vrijeme` DATETIME NULL,
  `broj_racuna` INT(11) NULL,
  `akcijapopust_id` INT NOT NULL,
  `smjena_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_racun_akcijapopust1_idx` (`akcijapopust_id` ASC),
  INDEX `fk_racun_smjena1_idx` (`smjena_id` ASC),
  CONSTRAINT `fk_racun_akcijapopust1`
    FOREIGN KEY (`akcijapopust_id`)
    REFERENCES `tim6`.`akcijapopust` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_racun_smjena11`
    FOREIGN KEY (`smjena_id`)
    REFERENCES `tim6`.`smjena` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tim6`.`stavkaracuna`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tim6`.`stavkaracuna` (
  `id` INT NOT NULL AUTO INCEREMENT,
  `kolicina` INT(11) NOT NULL,
  `ukupna_cijena` DECIMAL NOT NULL,
  `artikal_id` INT NOT NULL,
  `racun_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_stavkaracuna_artikal1_idx` (`artikal_id` ASC),
  INDEX `fk_stavkaracuna_racun1_idx` (`racun_id` ASC),
  CONSTRAINT `fk_stavkaracuna_artikal1`
    FOREIGN KEY (`artikal_id`)
    REFERENCES `tim6`.`artikal` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_stavkaracuna_racun1`
    FOREIGN KEY (`racun_id`)
    REFERENCES `tim6`.`racun` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tim6`.`vrstaplacanja`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tim6`.`vrstaplacanja` (
  `id` INT NOT NULL AUTO INCEREMENT,
  `naziv` VARCHAR(45) NOT NULL,
  `opis` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tim6`.`nacinplacanja`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tim6`.`nacinplacanja` (
  `id` INT NOT NULL AUTO INCEREMENT,
  `iznos` DECIMAL NOT NULL,
  `vrstaplacanja_id` INT NOT NULL,
  `racun_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_nacinplacanja_vrstaplacanja1_idx` (`vrstaplacanja_id` ASC),
  INDEX `fk_nacinplacanja_racun1_idx` (`racun_id` ASC),
  CONSTRAINT `fk_nacinplacanja_vrstaplacanja1`
    FOREIGN KEY (`vrstaplacanja_id`)
    REFERENCES `tim6`.`vrstaplacanja` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_nacinplacanja_racun1`
    FOREIGN KEY (`racun_id`)
    REFERENCES `tim6`.`racun` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
