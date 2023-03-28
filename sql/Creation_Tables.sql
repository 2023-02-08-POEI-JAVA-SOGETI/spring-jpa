-- MySQL
CREATE TABLE restaurant
(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nom VARCHAR(255) NOT NULL,    
    prix VARCHAR(255),
    adresse VARCHAR(255),
    type_restaurant_id INT
);

CREATE TABLE reservation
(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nom_reservant VARCHAR(255) NOT NULL,
    prenom_reservant VARCHAR(255),
    telephone_reservant VARCHAR(10),
    date_heure DATETIME NOT NULL,
    restaurant_id INT
);

CREATE TABLE type_restaurant
(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nom VARCHAR(255) NOT NULL
);



ALTER TABLE restaurant ADD FOREIGN KEY (type_restaurant_id) REFERENCES type_restaurant(id);
ALTER TABLE reservation ADD FOREIGN KEY (restaurant_id) REFERENCES restaurant(id);

INSERT INTO restaurant (nom, prix, adresse) VALUES ('Chez Pierre', 'TRES_BON_MARCHE', '12 rue de la Paix');
INSERT INTO restaurant (nom, prix, adresse) VALUES ('Le Bistrot', 'BON_MARCHE', '8 avenue des Champs-Élysées');
INSERT INTO restaurant (nom, prix, adresse) VALUES ('Le Ritz', 'CHER', '15 place Vendôme');
INSERT INTO restaurant (nom, prix, adresse) VALUES ('La Tour d\'Argent', 'TRES_CHER', '17 Quai de la Tournelle');
