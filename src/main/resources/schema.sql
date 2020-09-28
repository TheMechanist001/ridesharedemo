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

DROP TABLE IF EXISTS CAR;

CREATE TABLE CAR (
  id UUID NOT NULL PRIMARY KEY,
  date_created DATE NOT NULL,
  license_plate VARCHAR(250) NOT NULL,
  seat_count NUMERIC (9,0) NOT NULL,
  convertible BOOLEAN NOT NULL,
  rating NUMERIC(9,2),
  engine_type VARCHAR(250) NOT NULL,
  manufacturer VARCHAR(250) NOT NULL,
  selected_driver_id NUMERIC(9,0),
  date_selected DATE,
  is_car_selected BOOLEAN

);
