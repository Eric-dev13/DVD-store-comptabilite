-- CREATE DATABASE dvdstore
CREATE TABLE client (
  id INT AUTO_INCREMENT PRIMARY KEY,
  address VARCHAR(255) NULL,
  firstname VARCHAR(255) NULL,
  lastname VARCHAR(255) NULL
);

-- dvd sont définis par leur nom genre quantité stocké
CREATE TABLE dvd (
  id INT AUTO_INCREMENT PRIMARY KEY,
  genre varchar(255) NULL,
  name varchar(255) NULL,
  quantity INT NULL
);

-- Une vente est liée à un client et un produit
CREATE TABLE vente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    date_achat DATE,
    prix DECIMAL(10, 2),
    client_id INT,
    dvd_id INT,
    FOREIGN KEY (client_id) REFERENCES client(id),
    FOREIGN KEY (dvd_id) REFERENCES dvd(id)
);



