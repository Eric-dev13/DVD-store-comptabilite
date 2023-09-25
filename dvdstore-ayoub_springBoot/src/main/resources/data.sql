
INSERT INTO client (id, address, firstname, lastname) VALUES
(1, '10 avenue des prés 13010 Marseille', 'Bill', 'Gate'),
(2, '123 Rue de la Célébrité, Los Angeles, CA, 90001, États-Unis', 'Jennifer', 'Smith'),
(3, '456 Avenue de la Renommée, New York, NY, 10001, États-Unis', 'Johnson', 'Michael');

INSERT INTO dvd (price, quantity, id, genre, name, filename) VALUES
(10, 100, 1, 'Drame', 'Titanic','https://m.media-amazon.com/images/I/51JUw3Ntd-L._AC_.jpg'),
(15.5, 50, 2, 'Policier', '36 Quai des Orfèvres','https://fr.web.img6.acsta.net/c_310_420/medias/nmedia/18/35/42/86/18395118.jpg'),
(20, 20, 3, 'Science-fiction', 'Interstellar','https://fr.web.img5.acsta.net/c_310_420/pictures/14/09/24/12/08/158828.jpg');

INSERT INTO vente (prix, client_id, date_achat, id, quantity, dvd_id) VALUES
(31, 2, '2023-09-20 19:21:32.289618', 11, 2, 2),
(31, 2, '2023-09-20 19:21:40.007726', 12, 2, 2);