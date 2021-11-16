-- MySQL Workbench Forward Engineering


-- -----------------------------------------------------
-- Schema Catastro
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `Catastro` ;

-- -----------------------------------------------------
-- Schema Catastro
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Catastro` DEFAULT CHARACTER SET utf8 ;
SHOW WARNINGS;
USE `Catastro` ;

-- -----------------------------------------------------
-- Table `MARCA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `MARCA` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `MARCA` (
  `idMARCA` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NULL,
  PRIMARY KEY (`idMARCA`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Ciclos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Ciclos` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `Ciclos` (
  `IdCiclos` INT NOT NULL AUTO_INCREMENT,
  `Descripcion` VARCHAR(45) NULL,
  `EnlaceWEB` VARCHAR(45) NULL,
  PRIMARY KEY (`IdCiclos`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Rutas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Rutas` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `Rutas` (
  `idRutas` INT NOT NULL AUTO_INCREMENT,
  `Descripcion` VARCHAR(45) NULL,
  `Lon` VARCHAR(45) NULL,
  `Lant` VARCHAR(45) NULL,
  `Ciclos_IdCiclos` INT NOT NULL,
  PRIMARY KEY (`idRutas`),
  INDEX `fk_Rutas_Ciclos1_idx` (`Ciclos_IdCiclos` ASC)  ,
  CONSTRAINT `fk_Rutas_Ciclos1`
    FOREIGN KEY (`Ciclos_IdCiclos`)
    REFERENCES `Ciclos` (`IdCiclos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `UsuariosBD`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `UsuariosBD` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `UsuariosBD` (
  `IdUsuario` INT NOT NULL AUTO_INCREMENT,
  `CodigoInterno` VARCHAR(45) NULL,
  `Nombre` VARCHAR(45) NULL,
  `Telefono` VARCHAR(45) NULL,
  `Lon` VARCHAR(45) NULL,
  `Lan` VARCHAR(45) NULL,
  `EnlaceWEB` VARCHAR(45) NULL,
  `Diametro` VARCHAR(45) NULL,
  `TipoMedidor` VARCHAR(45) NULL,
  `MARCA_idMARCA` INT NOT NULL,
  `Rutas_idRutas` INT NOT NULL,
  `Ciclos_IdCiclos` INT NOT NULL,
  PRIMARY KEY (`IdUsuario`),
  INDEX `fk_UsuariosBD_MARCA_idx` (`MARCA_idMARCA` ASC)  ,
  INDEX `fk_UsuariosBD_Rutas1_idx` (`Rutas_idRutas` ASC)  ,
  INDEX `fk_UsuariosBD_Ciclos1_idx` (`Ciclos_IdCiclos` ASC)  ,
  CONSTRAINT `fk_UsuariosBD_MARCA`
    FOREIGN KEY (`MARCA_idMARCA`)
    REFERENCES `MARCA` (`idMARCA`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_UsuariosBD_Rutas1`
    FOREIGN KEY (`Rutas_idRutas`)
    REFERENCES `Rutas` (`idRutas`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_UsuariosBD_Ciclos1`
    FOREIGN KEY (`Ciclos_IdCiclos`)
    REFERENCES `Ciclos` (`IdCiclos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Operario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Operario` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `Operario` (
  `idOperario` INT NOT NULL AUTO_INCREMENT,
  `NumeroID` VARCHAR(45) NULL,
  `Nombre` VARCHAR(45) NULL,
  `Telefono` VARCHAR(45) NULL,
  PRIMARY KEY (`idOperario`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `GeoOperario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GeoOperario` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `GeoOperario` (
  `Long` INT NULL,
  `Lant` VARCHAR(45) NULL,
  `Operario_idOperario` INT NOT NULL,
  PRIMARY KEY (`Operario_idOperario`),
  CONSTRAINT `fk_GeoOperario_Operario1`
    FOREIGN KEY (`Operario_idOperario`)
    REFERENCES `Operario` (`idOperario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;


