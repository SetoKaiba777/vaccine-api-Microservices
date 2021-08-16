CREATE TABLE user (
  id INT(10) AUTO_INCREMENT,
  name longtext,
  cpf_code varchar(14) NOT NULL,
  email varchar(255) NOT NULL,
  born_date datetime(6) NOT NULL,
  constraint PK_USER PRIMARY KEY (id),
  constraint UK_USER_MAIL UNIQUE (email),
  constraint UK_USER_CPF UNIQUE (cpf_code)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
