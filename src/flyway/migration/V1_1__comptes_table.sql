CREATE TABLE IF NOT EXISTS comptes (
	compte_id integer PRIMARY KEY ,
	solde double precision NOT NULL,
	type VARCHAR(20),
	username VARCHAR(50) references users(username)
);