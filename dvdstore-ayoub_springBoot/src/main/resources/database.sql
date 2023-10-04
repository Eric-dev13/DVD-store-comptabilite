
INSERT INTO client (id, address, firstname, lastname) VALUES
(1, '10 avenue des prés 13010 Marseille', 'Bill', 'Gate'),
(2, '123 Rue de la Célébrité, Los Angeles, CA, 90001, États-Unis', 'Jennifer', 'Smith'),
(3, '456 Avenue de la Renommée, New York, NY, 10001, États-Unis', 'Johnson', 'Michael');

INSERT INTO dvd (price, quantity, id, genre, realisateur, acteur, name, filename, synopsis) VALUES
(10, 100, 1, 'drame', 'James Cameron', 'Leonardo DiCaprio, Kate Winslet, Billy Zane', 'Titanic', 'affiche-film-titanic.jpg','Southampton, 10 avril 1912. Le paquebot le plus grand et le plus moderne du monde, réputé pour son insubmersibilité, le \"Titanic\", appareille pour son premier voyage. Quatre jours plus tard, il heurte un iceberg. A son bord, un artiste pauvre et une grande bourgeoise tombent amoureux. '),
(15.5, 50, 2, 'policier', 'Benjamin Lehrer', 'Didier Bourdon, Caroline Anglade, Yann Papin', '36 Quai des Orfèvres','36.webp','L\'affrontement sur une période de 10 ans de deux grands flics hors pair affectés au 36, quai des Orfèvres, siège de la PJ. L\'un est patron de la brigade de recherche et d\'intervention, tandis que l\'autre dirige la brigade de répression du banditisme. '),
(20, 20, 3, 'science-fiction', 'Christopher Nolan', 'Matthew McConaughey, Anne Hathaway, Michael Caine', 'Interstellar','interstellar.jpg','Le film raconte les aventures d’un groupe d’explorateurs qui utilisent une faille récemment découverte dans l’espace-temps afin de repousser les limites humaines et partir à la conquête des distances astronomiques dans un voyage interstellaire.');

INSERT INTO vente (prix, client_id, date_achat, id, quantity, dvd_id) VALUES
(31, 2, '2023-09-20 19:21:32.289618', 11, 2, 2),
(31, 2, '2023-09-20 19:21:40.007726', 12, 2, 2);