DROP DATABASE IF EXISTS the_fish_shop_db;

CREATE DATABASE IF NOT EXISTS `the_fish_shop_db`;
USE `the_fish_shop_db` ;
-- -----------------------------------------------------------------------------
-- CREATE TABLES
-- -----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `the_fish_shop_db`.`user_info` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(60) NULL DEFAULT NULL,
  `last_name` VARCHAR(60) NULL DEFAULT NULL,
  `address` VARCHAR(60) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `the_fish_shop_db`.`users` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(60) NOT NULL,
  `password` CHAR(68) NOT NULL,
  `email` VARCHAR(254) NOT NULL,
  `user_info_id` INT(11) NULL DEFAULT NULL,
  `roles` ENUM('ROLE_ADMIN', 'ROLE_CUSTOMER', 'ROLE_EMPLOYEE') NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_userInfoId_users_idx` (`user_info_id` ASC),
  CONSTRAINT `fk_userInfoId_users`
    FOREIGN KEY (`user_info_id`)
    REFERENCES `the_fish_shop_db`.`user_info` (`id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `the_fish_shop_db`.`orders` (
  `id` INT(11) NOT NULL,
  `user_id` INT(11) NOT NULL,
  `date_time` DATETIME NOT NULL,
  `total_price` DOUBLE(8,2) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_userid_order_idx` (`user_id` ASC),
  CONSTRAINT `fk_userid_orders`
    FOREIGN KEY (`user_id`)
    REFERENCES `the_fish_shop_db`.`users` (`id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `the_fish_shop_db`.`products` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `description` VARCHAR(200) NOT NULL,
  `the_type` ENUM('FW_FISH', 'SW_FISH', 'CRAB_FISH', 'P_FISH', 'FW_PLANT', 'P_PLANT', 'TANK', 'FILTER', 'CO2', 'FOOD') NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `the_fish_shop_db`.`products_order` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `product_id` INT(11) NOT NULL,
  `order_id` INT(11) NOT NULL,
  `quantity` INT(3) NOT NULL,
  `price` DOUBLE(8,2) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_orderproduct_po_idx` (`order_id` ASC),
  INDEX `fk_productID_po` (`product_id` ASC),
  CONSTRAINT `fk_orderID_po`
    FOREIGN KEY (`order_id`)
    REFERENCES `the_fish_shop_db`.`orders` (`id`),
  CONSTRAINT `fk_productID_po`
    FOREIGN KEY (`product_id`)
    REFERENCES `the_fish_shop_db`.`products` (`id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `the_fish_shop_db`.`stock` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `price` DOUBLE(8,2) NOT NULL,
  `quantity` INT(5) NOT NULL,
  `price_date` DATE NOT NULL,
  `product_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_productID_stock` (`product_id` ASC),
  CONSTRAINT `fk_productID_stock`
    FOREIGN KEY (`product_id`)
    REFERENCES `the_fish_shop_db`.`products` (`id`))
ENGINE = InnoDB;

-- -----------------------------------------------------------------------------
-- CREATE STORED PROCEDURES
-- -----------------------------------------------------------------------------

USE the_fish_shop_db;

-- getProductsForHomePage() 
DROP PROCEDURE IF EXISTS get_products_for_home_page;
DELIMITER $$
	CREATE PROCEDURE get_products_for_home_page()
	BEGIN
		select products.id, products.title, products.the_type, stock.price, stock.quantity
		from products left join stock
		on products.id=stock.product_id;
	END $$
DELIMITER ;

	-- insertEmployeeWithDetails(args) 
DROP PROCEDURE IF EXISTS insertEmployeeWithDetails;
DELIMITER $$
	CREATE PROCEDURE insertEmployeeWithDetails(
		firstName varchar(60), lastName varchar(60), address varchar(60),
		username varchar(60), password char(68), email varchar(254)
	)
	BEGIN
		insert into user_info values
			(null, firstName, lastName, address);
		set @id = (select user_info.id from user_info where first_name=firstName and lastName=lastName limit 1);
		insert into users values
			(null, username, password, email, @id, 'ROLE_EMPLOYEE');
	END $$
DELIMITER ;

-- updateEmployeeWithDetails(args)
DROP PROCEDURE IF EXISTS updateEmployeeWithDetails;
DELIMITER $$
	CREATE PROCEDURE updateEmployeeWithDetails(
		theId int(11), firstName varchar(60), lastName varchar(60),
		updatedAddress varchar(60), updatedUsername varchar(60), updatedEmail varchar(254)
		)
	BEGIN
		SET @udId = (SELECT user_info_id FROM users WHERE id = theId);
		UPDATE user_info
			SET first_name = firstName, last_name = lastName, address = updatedAddress
		WHERE id = @udId;
		UPDATE users
			SET username = updatedUsername, email = updatedEmail
		WHERE id=theId;
	END $$
DELIMITER ;

-- insertUserWithDetails(args)
DROP PROCEDURE IF EXISTS insertUserWithDetails;
DELIMITER $$
	CREATE PROCEDURE insertUserWithDetails(
		firstName varchar(60), lastName varchar(60), address varchar(60),
		username varchar(60), password char(68), email varchar(254), theRole enum('ROLE_ADMIN', 'ROLE_EMPLOYEE', 'ROLE_CUSTOMER')
		)
	BEGIN
		insert into user_info values
			(null, firstName, lastName, address);
		set @id = (select user_info.id from user_info where first_name=firstName and lastName=lastName limit 1);
		insert into users values
			(null, username, password, email, @id, theRole);
	END $$
DELIMITER ;
