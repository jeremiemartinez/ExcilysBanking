INSERT INTO authorities (authority_id, authority) VALUES (0, 'ROLE_ADMIN');
INSERT INTO authorities (authority_id, authority) VALUES (1, 'ROLE_USER');
INSERT INTO users (username, password, firstname, lastname) VALUES('lponnau', '1f2e49338c8458683783d92506dd092e0c8c25ef', 'Luc', 'Ponnau'); 
INSERT INTO users (username, password, firstname, lastname) VALUES('jmartinez', '31e0b4662006fc502125ae3394a32d71395d683a', 'Jérémie', 'Martinez');
INSERT INTO users_authorities (username, authority_id) VALUES ('lponnau', 0);
INSERT INTO users_authorities (username, authority_id) VALUES ('jmartinez', 1);