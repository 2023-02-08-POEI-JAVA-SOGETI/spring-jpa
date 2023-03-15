ALTER TABLE article
ADD COLUMN fournisseur_id INT,
ADD CONSTRAINT fk_fournisseur
  FOREIGN KEY (fournisseur_id)
  REFERENCES fournisseur(id);
