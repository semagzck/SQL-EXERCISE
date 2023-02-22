SELECT COUNT(*) FROM film
WHERE rating IN ('R','NC-17')
AND rental_rate BETWEEN 1.00 AND 2.00