ALTER TABLE operations ADD COLUMN compte_destination integer references comptes(compte_id);