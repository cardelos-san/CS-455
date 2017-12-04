
-- Creating tables
USE bodega;
CREATE TABLE Category(
  categoryId INT(5) NOT NULL PRIMARY KEY,
  categoryName VARCHAR(32) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8  COLLATE=utf8_unicode_ci;

CREATE TABLE Item(
  itemId INT(5) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  itemName VARCHAR(32) NOT NULL,
  price FLOAT NOT NULL,
  categoryId INT(5) NOT NULL,
  userId INT(5) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8  COLLATE=utf8_unicode_ci;

CREATE TABLE Users(
  userId INT(5) NOT NULL PRIMARY KEY,
  uName VARCHAR(32) NOT NULL,
  pWord VARCHAR(100) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8  COLLATE=utf8_unicode_ci;

CREATE TABLE Stock(
  stockId INT(5) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  date_updated timestamp NOT NULL default CURRENT_TIMESTAMP,
  noAvailable INT(5) DEFAULT 0,
  noPreferred INT(5) DEFAULT 0,
  noSold INT(5) DEFAULT 0,
  noMissing INT(5) DEFAULT 0,
  itemId INT(5) NOT NULL,
  userId INT(5) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8  COLLATE=utf8_unicode_ci;

CREATE TABLE StockLog(
  stockId INT(5) NOT NULL PRIMARY KEY,
  totalSold INT(5) NOT NULL,
  totalOrdered INT(5) NOT NULL
  
) ENGINE=InnoDB  DEFAULT CHARSET=utf8  COLLATE=utf8_unicode_ci;


-- Adding foreign keys

ALTER TABLE Item                ADD CONSTRAINT categoryId_fk                   FOREIGN KEY (categoryId)       REFERENCES Category (categoryId)     ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE Item                ADD CONSTRAINT modified_by_user_fk             FOREIGN KEY (userId)       	  REFERENCES Users 	  (userId)     	   ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE Stock               ADD CONSTRAINT itemId_fk            		   FOREIGN KEY (itemId)       	  REFERENCES Item 	  (itemId)     	   ON DELETE CASCADE ON UPDATE NO ACTION;
ALTER TABLE Stock               ADD CONSTRAINT userId_fk            		   FOREIGN KEY (userId)       	  REFERENCES Users 	  (userId)     	   ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE StockLog            ADD CONSTRAINT stockId_fk                      FOREIGN KEY (stockId)          REFERENCES Stock    (StockId)        ON DELETE NO ACTION ON UPDATE NO ACTION; 