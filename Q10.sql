SELECT name FROM language
WHERE language_id=
(SELECT DISTINCT(film.language_id) FROM film
INNER JOIN inventory
ON film.film_id=inventory.film_id
WHERE inventory.store_id=1);
