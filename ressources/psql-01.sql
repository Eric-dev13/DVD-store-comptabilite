CREATE OR REPLACE FUNCTION calculPrice(item_id BIGINT)RETURNS NUMERIC AS $$
DECLARE
    item_quantity INT;
    item_price NUMERIC;
    total_price NUMERIC;
BEGIN
-- Récupérer la quantité et le prix de l'article à partir de la table panier_dvd
    SELECT dvd_quantity, dvd_price INTO item_quantity, item_price
    FROM panier_dvd
    WHERE id = item_id;
	
	-- Calculer le prix total
    total_price := item_quantity * item_price;

    RETURN total_price;

END;
$$ LANGUAGE plpgsql;

SELECT calculPrice(1);