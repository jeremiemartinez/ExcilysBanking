CREATE TABLE IF NOT EXISTS operations (
	operation_id serial PRIMARY KEY, 
	compte_id integer NOT NULL references comptes(compte_id),
	type VARCHAR(50) NOT NULL,
	montant double precision,
	date timestamp,
	libelle VARCHAR(150)
);