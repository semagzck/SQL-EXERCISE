SELECT first_name || '' || last_name AS full_name,COUNT(actor.actor_id)FROM actor
INNER JOIN film_actor
ON actor.actor_id=film_actor.actor_id
INNER JOIN inventory
ON inventory.film_id=film_actor.film_id
WHERE store_id=2
GROUP BY actor.first_name,actor.last_name,actor.actor_id
ORDER BY COUNT(actor.actor_id) DESC
LIMIT 5;
