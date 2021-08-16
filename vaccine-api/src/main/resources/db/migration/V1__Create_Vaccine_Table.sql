CREATE TABLE vaccine (
  id INT(10) AUTO_INCREMENT,
  vaccine varchar(255),
  user_id int(14) NOT NULL,
  vac_date datetime(6) NOT NULL,
  constraint PK_USER PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;