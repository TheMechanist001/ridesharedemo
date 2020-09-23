DROP TABLE IF EXISTS DRIVER;

CREATE TABLE DRIVER (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  coordinate VARCHAR(250),
  date_coordinate_updated DATE,
  date_created DATE NOT NULL,
  deleted BOOLEAN NOT NULL,
  online_status VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL,
  username VARCHAR(250) NOT NULL
);