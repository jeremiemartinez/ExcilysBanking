INSERT INTO authorities (authority_id, authority) VALUES (0, 'ROLE_ADMIN');
INSERT INTO authorities (authority_id, authority) VALUES (1, 'ROLE_USER');
INSERT INTO users (username, password, firstname, lastname) VALUES('lponnau', 'excilys', 'Luc', 'Ponnau'); 
INSERT INTO users (username, password, firstname, lastname) VALUES('jmartinez', 'excilys', 'Jérémie', 'Martinez');
INSERT INTO users_authorities (username, authority_id) VALUES ('lponnau', 0);
INSERT INTO users_authorities (username, authority_id) VALUES ('jmartinez', 1);