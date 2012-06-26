CREATE TABLE IF NOT EXISTS operations (
	operation_id integer PRIMARY KEY, 
	compte_id integer NOT NULL references comptes(compte_id),
	type VARCHAR(50) NOT NULL,
	montant double precision,
	date timestamp
);