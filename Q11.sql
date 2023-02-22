SELECT COUNT(inventory.film_id)
FROM film 
JOIN inventory  ON film.film_id =inventory.film_id
JOIN film_category ON film.film_id = film_category.film_id
JOIN category ON film_category.category_id = category.category_id
WHERE film.rating ='PG-13' AND category.name = 'Comedy'



SELECT COUNT(DISTINCT inventory.film_id)
FROM film 
JOIN inventory  ON film.film_id =inventory.film_id
JOIN film_category ON film.film_id = film_category.film_id
JOIN category ON film_category.category_id = category.category_id
WHERE film.rating ='PG-13' AND category.name = 'Comedy'
