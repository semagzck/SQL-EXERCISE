SELECT COUNT(DISTINCT film_id) FROM film
WHERE film_id NOT IN(
SELECT film_id FROM inventory)