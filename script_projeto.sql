DROP DATABASE HOTEL;
CREATE DATABASE HOTEL;
USE HOTEL;
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Table `hospedes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hospedes` ;

CREATE TABLE IF NOT EXISTS `hospedes` (
  `hospede_id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `cpf` VARCHAR(15) NOT NULL COMMENT '',
  `nome` VARCHAR(45) NOT NULL COMMENT '',
  `endereco` VARCHAR(100) NOT NULL COMMENT '',
  `telefone` VARCHAR(20) NOT NULL COMMENT '',
  `email` VARCHAR(45) NOT NULL COMMENT '',
  `data_nascimento` DATE NOT NULL COMMENT '',
  PRIMARY KEY (`hospede_id`)  COMMENT '',
  UNIQUE INDEX `email_UNIQUE` (`email` ASC)  COMMENT '',
  UNIQUE INDEX `cpf_UNIQUE` (`cpf` ASC)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = cp850
COLLATE = cp850_general_ci;


-- -----------------------------------------------------
-- Table `categorias`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `categorias` ;

CREATE TABLE IF NOT EXISTS `categorias` (
  `categoria_id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `nome_categoria` VARCHAR(25) NOT NULL COMMENT '',
  PRIMARY KEY (`categoria_id`)  COMMENT '',
  UNIQUE INDEX `nome_categoria_UNIQUE` (`nome_categoria` ASC)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `itens_consumo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `itens_consumo` ;

CREATE TABLE IF NOT EXISTS `itens_consumo` (
  `item_id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `descricao` VARCHAR(45) NOT NULL COMMENT '',
  `valor` DOUBLE NOT NULL COMMENT '',
  `categoria_id` INT NULL COMMENT '',
  PRIMARY KEY (`item_id`)  COMMENT '',
  UNIQUE INDEX `descricao_UNIQUE` (`descricao` ASC)  COMMENT '',
  CONSTRAINT `categoria_id`
    FOREIGN KEY (`categoria_id`)
    REFERENCES `categorias` (`categoria_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tipo_acomodacao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tipo_acomodacao` ;

CREATE TABLE IF NOT EXISTS `tipo_acomodacao` (
  `tipo_acomodacao_id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `descricao` VARCHAR(45) NOT NULL COMMENT '',
  `qtde_acomodacoes` INT NOT NULL COMMENT '',
  `valor_diaria` DOUBLE NOT NULL COMMENT '',
  `num_adultos` INT NOT NULL COMMENT '',
  `num_criancas` INT NOT NULL COMMENT '',
  PRIMARY KEY (`tipo_acomodacao_id`)  COMMENT '',
  UNIQUE INDEX `descricao_UNIQUE` (`descricao` ASC)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `acomodacoes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `acomodacoes` ;

CREATE TABLE IF NOT EXISTS `acomodacoes` (
  `acomodacao_id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `num_acomodacao` INT NOT NULL COMMENT '',
  `andar` INT NOT NULL COMMENT '',
  `tipo_acomodacao_id` INT NOT NULL COMMENT '',
  `reservado` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '',
  PRIMARY KEY (`acomodacao_id`)  COMMENT '',
  UNIQUE INDEX `num_acomodacao_UNIQUE` (`num_acomodacao` ASC)  COMMENT '',
  CONSTRAINT `tipo_acomodacao_id`
    FOREIGN KEY (`tipo_acomodacao_id`)
    REFERENCES `tipo_acomodacao` (`tipo_acomodacao_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cartoes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cartoes` ;

CREATE TABLE IF NOT EXISTS `cartoes` (
  `cartao_id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `numero_cartao` VARCHAR(45) NOT NULL COMMENT '',
  `bandeira` VARCHAR(45) NOT NULL COMMENT '',
  `hospede_id` INT NOT NULL COMMENT '',
  PRIMARY KEY (`cartao_id`)  COMMENT '',
  UNIQUE INDEX `numero_cartao_UNIQUE` (`numero_cartao` ASC)  COMMENT '',
  CONSTRAINT `fk_cartoes_1`
    FOREIGN KEY (`hospede_id`)
    REFERENCES `hospedes` (`hospede_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `reservas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `reservas` ;

CREATE TABLE IF NOT EXISTS `reservas` (
  `reserva_id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `data_chegada` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '',
  `data_saida` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '',
  `hospede_id` INT NOT NULL COMMENT '',
  `acomodacao_id` INT NOT NULL COMMENT '',
  `valor_diaria` DOUBLE NOT NULL COMMENT '',
  `taxa_multa` DOUBLE NULL DEFAULT 0 COMMENT '',
  `cartao_id` INT NULL COMMENT '',
  `desconto` DOUBLE NULL DEFAULT 0 COMMENT '',
  PRIMARY KEY (`reserva_id`)  COMMENT '',
  CONSTRAINT `cartao_id_fk`
    FOREIGN KEY (`cartao_id`)
    REFERENCES `cartoes` (`cartao_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `hospede_id_fk`
    FOREIGN KEY (`hospede_id`)
    REFERENCES `hospedes` (`hospede_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `tipo_acomodacao_id_fk`
    FOREIGN KEY (`acomodacao_id`)
    REFERENCES `acomodacoes` (`acomodacao_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `acompanhantes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `acompanhantes` ;

CREATE TABLE IF NOT EXISTS `acompanhantes` (
  `acompanhante_id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `nome` VARCHAR(45) NOT NULL COMMENT '',
  `idade` INT NOT NULL COMMENT '',
  `reserva_id` INT NOT NULL COMMENT '',
  PRIMARY KEY (`acompanhante_id`)  COMMENT '',
  UNIQUE INDEX `acompanhante_id_UNIQUE` (`acompanhante_id` ASC)  COMMENT '',
  CONSTRAINT `fk_acompanhantes_1`
    FOREIGN KEY (`reserva_id`)
    REFERENCES `reservas` (`reserva_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `entradas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `entradas` ;

CREATE TABLE IF NOT EXISTS `entradas` (
  `entrada_id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `data_chegada` TIMESTAMP NULL COMMENT '',
  `data_saida` TIMESTAMP NULL COMMENT '',
  `reserva_id` INT NULL COMMENT '',
  PRIMARY KEY (`entrada_id`)  COMMENT '',
  CONSTRAINT `reserva_id_fk`
    FOREIGN KEY (`reserva_id`)
    REFERENCES `reservas` (`reserva_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `consumos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `consumos` ;

CREATE TABLE IF NOT EXISTS `consumos` (
  `consumo_id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `data_consumo` DATE NOT NULL COMMENT '',
  `num_acomodacao` INT NOT NULL COMMENT '',
  `item_id` INT NOT NULL COMMENT '',
  `qtde_consumida` INT NOT NULL DEFAULT 0 COMMENT '',
  PRIMARY KEY (`consumo_id`)  COMMENT '',
  CONSTRAINT `item_id`
    FOREIGN KEY (`item_id`)
    REFERENCES `itens_consumo` (`item_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `num_acomodacao`
    FOREIGN KEY (`num_acomodacao`)
    REFERENCES `acomodacoes` (`num_acomodacao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tipos_pagamento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tipos_pagamento` ;

CREATE TABLE IF NOT EXISTS `tipos_pagamento` (
  `tipo_pagamento_id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `tipo` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`tipo_pagamento_id`)  COMMENT '',
  UNIQUE INDEX `tipo_UNIQUE` (`tipo` ASC)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `saidas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `saidas` ;

CREATE TABLE IF NOT EXISTS `saidas` (
  `saida_id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `num_acomodacao` INT NOT NULL COMMENT '',
  `data_saida` TIMESTAMP NOT NULL COMMENT '',
  `num_diarias` INT NOT NULL COMMENT '',
  `valor_servicos` DOUBLE NOT NULL COMMENT '',
  `desconto` DOUBLE NULL DEFAULT 0 COMMENT '',
  `estadia_paga` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '',
  `tipo_pagamento_id` INT NOT NULL COMMENT '',
  `reserva_id` INT NULL COMMENT '',
  PRIMARY KEY (`saida_id`)  COMMENT '',
  CONSTRAINT `tipo_pagamento_id`
    FOREIGN KEY (`tipo_pagamento_id`)
    REFERENCES `tipos_pagamento` (`tipo_pagamento_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_saidas_1`
    FOREIGN KEY (`reserva_id`)
    REFERENCES `reservas` (`reserva_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `reservas_encerradas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `reservas_encerradas` ;

CREATE TABLE IF NOT EXISTS `reservas_encerradas` (
  `reserva_id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `data_chegada` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '',
  `data_saida` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '',
  `hospede_id` INT NOT NULL COMMENT '',
  `acomodacao_id` INT NOT NULL COMMENT '',
  `valor_diaria` DOUBLE NOT NULL COMMENT '',
  `taxa_multa` DOUBLE NULL DEFAULT 0 COMMENT '',
  `cartao_id` INT NULL COMMENT '',
  `desconto` DOUBLE NULL DEFAULT 0 COMMENT '',
  PRIMARY KEY (`reserva_id`)  COMMENT '',
  CONSTRAINT `cartao_id_fk2`
    FOREIGN KEY (`cartao_id`)
    REFERENCES `cartoes` (`cartao_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `hospede_id_fk2`
    FOREIGN KEY (`hospede_id`)
    REFERENCES `hospedes` (`hospede_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `tipo_acomodacao_id_fk2`
    FOREIGN KEY (`acomodacao_id`)
    REFERENCES `acomodacoes` (`acomodacao_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

DELIMITER //

CREATE TRIGGER `fechar_reservas`
BEFORE DELETE
   ON reservas FOR EACH ROW
   
BEGIN
   -- Insert record into audit table
   INSERT INTO reservas_encerradas
   ( data_chegada,
	 data_saida,
     hospede_id,
     acomodacao_id,
     valor_diaria,
     taxa_multa,
     cartao_id,
     desconto)
   VALUES
   (OLD.data_chegada,
    OLD.data_saida,
    OLD.hospede_id,
    OLD.acomodacao_id,
    OLD.valor_diaria,
    OLD.taxa_multa,
    OLD.cartao_id,
    OLD.desconto);
   
END; //

DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
