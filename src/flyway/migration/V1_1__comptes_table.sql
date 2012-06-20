CREATE TYPE compteType AS ENUM ('CARTE', 'ESPECE');
CREATE TABLE IF NOT EXISTS comptes (
	compte_id integer PRIMARY KEY ,
	solde double precision NOT NULL,
	type compteType,
	username VARCHAR(50) references users(username)
);