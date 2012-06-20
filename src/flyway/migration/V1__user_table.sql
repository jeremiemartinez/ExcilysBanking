CREATE TABLE IF NOT EXISTS authorities (
	authority_id integer PRIMARY KEY,
	role ENUM('ROLE_USER', 'ROLE_ADMIN')
);

CREATE TABLE IF NOT EXISTS users (
	username VARCHAR(50) PRIMARY KEY, 
	password VARCHAR(150) NOT NULL, 
	firstname VARCHAR(150) NOT NULL,
	lastname VARCHAR(150) NOT NULL,
	authority_id integer references authorities(authority_id)
);

CREATE TABLE IF NOT EXISTS comptes (
	compte_id integer PRIMARY KEY,
	solde double precision NOT NULL,
	username_id VARCHAR(50) references users(username_id)
);

INSERT INTO authorities (1, 'ROLE_USER')
INSERT INTO authorities (2, 'ROLE_ADMIN')
INSERT INTO users (login, password, name, phone, nationality, fk_authority) VALUES('lponnau', 'excilys', 'Ponnau Luc', 1); 
INSERT INTO users (login, password, name, phone, nationality, fk_authority) VALUES('jmartinez', 'excilys', 'Martinez Jeremie', 2);