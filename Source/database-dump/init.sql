-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`kategorija`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`kategorija` (
  `id` INT NOT NULL,
  `naziv` VARCHAR(45) NOT NULL,
  `opis` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`uposlenik`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`uposlenik` (
  `id` INT NOT NULL,
  `ime_prezime` VARCHAR(45) NOT NULL,
  `datum_rođenja` DATE NULL,
  `jmbg` VARCHAR(45) NOT NULL,
  `broj_telefona` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `jmbg_UNIQUE` (`jmbg` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`artikal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`artikal` (
  `id` INT NOT NULL,
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
    REFERENCES `mydb`.`kategorija` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`sef`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`sef` (
  `uposlenik_id` INT NOT NULL,
  INDEX `fk_sef_uposlenik1_idx` (`uposlenik_id` ASC),
  CONSTRAINT `fk_sef_uposlenik1`
    FOREIGN KEY (`uposlenik_id`)
    REFERENCES `mydb`.`uposlenik` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`kasir`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`kasir` (
  `datum_zaposlenja` DATE NULL,
  `uposlenik_id` INT NOT NULL,
  INDEX `fk_kasir_uposlenik1_idx` (`uposlenik_id` ASC),
  CONSTRAINT `fk_kasir_uposlenik1`
    FOREIGN KEY (`uposlenik_id`)
    REFERENCES `mydb`.`uposlenik` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`smjena`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`smjena` (
  `id` INT NOT NULL,
  `pocetak_smjene` TIMESTAMP NOT NULL,
  `kraj_smjene` TIMESTAMP NOT NULL,
  `kasir_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_smjena_kasir1_idx` (),
  INDEX `fk_racun_smjena1_idx` (`kasir_id` ASC),
  CONSTRAINT `fk_racun_smjena1`
    FOREIGN KEY (`kasir_id`)
    REFERENCES `mydb`.`kasir` (`uposlenik_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`akcijapopust`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`akcijapopust` (
  `id` INT NOT NULL,
  `datum_pocetka` DATETIME NOT NULL,
  `datum_kraja` DATETIME NOT NULL,
  `opis` VARCHAR(245) NOT NULL,
  `iznos_popusta` INT(11) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`racun`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`racun` (
  `id` INT NOT NULL,
  `datum_i_vrijeme` DATETIME NULL,
  `broj_racuna` INT(11) NULL,
  `akcijapopust_id` INT NOT NULL,
  `smjena_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_racun_akcijapopust1_idx` (`akcijapopust_id` ASC),
  INDEX `fk_racun_smjena1_idx` (`smjena_id` ASC),
  CONSTRAINT `fk_racun_akcijapopust1`
    FOREIGN KEY (`akcijapopust_id`)
    REFERENCES `mydb`.`akcijapopust` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_racun_smjena1`
    FOREIGN KEY (`smjena_id`)
    REFERENCES `mydb`.`smjena` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`stavkaracuna`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`stavkaracuna` (
  `id` INT NOT NULL,
  `kolicina` INT(11) NOT NULL,
  `ukupna_cijena` DECIMAL NOT NULL,
  `artikal_id` INT NOT NULL,
  `racun_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_stavkaracuna_artikal1_idx` (`artikal_id` ASC),
  INDEX `fk_stavkaracuna_racun1_idx` (`racun_id` ASC),
  CONSTRAINT `fk_stavkaracuna_artikal1`
    FOREIGN KEY (`artikal_id`)
    REFERENCES `mydb`.`artikal` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_stavkaracuna_racun1`
    FOREIGN KEY (`racun_id`)
    REFERENCES `mydb`.`racun` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`vrstaplacanja`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`vrstaplacanja` (
  `id` INT NOT NULL,
  `naziv` VARCHAR(45) NOT NULL,
  `opis` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`nacinplacanja`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`nacinplacanja` (
  `id` INT NOT NULL,
  `iznos` DECIMAL NOT NULL,
  `vrstaplacanja_id` INT NOT NULL,
  `racun_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_nacinplacanja_vrstaplacanja1_idx` (`vrstaplacanja_id` ASC),
  INDEX `fk_nacinplacanja_racun1_idx` (`racun_id` ASC),
  CONSTRAINT `fk_nacinplacanja_vrstaplacanja1`
    FOREIGN KEY (`vrstaplacanja_id`)
    REFERENCES `mydb`.`vrstaplacanja` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_nacinplacanja_racun1`
    FOREIGN KEY (`racun_id`)
    REFERENCES `mydb`.`racun` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
