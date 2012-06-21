CREATE TABLE IF NOT EXISTS authorities (
	authority_id integer PRIMARY KEY,
	authority VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS users (
	username VARCHAR(50) PRIMARY KEY, 
	password VARCHAR(150) NOT NULL, 
	firstname VARCHAR(50) NOT NULL,
	lastname VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS users_authorities (
	username VARCHAR(50) references users(username),
	authority_id integer references authorities(authority_id),
	PRIMARY KEY (username, authority_id)
);