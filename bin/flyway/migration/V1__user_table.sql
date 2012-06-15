CREATE TABLE IF NOT EXISTS users (login VARCHAR(16) PRIMARY KEY, password VARCHAR(20) NOT NULL, name VARCHAR(80), phone VARCHAR(16), nationality VARCHAR(30));

INSERT INTO users (login, password, name, phone, nationality) VALUES('jmartinez', 'excilys', 'Martinez Jeremie', '0652776432', 'French');
INSERT INTO users (login, password, name, phone, nationality) VALUES('lponnau', 'bizu', 'Ponnau Luc', '0836656565', 'French'); 