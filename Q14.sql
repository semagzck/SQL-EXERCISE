SELECT first_name,last_name,amount
FROM customer
JOIN payment ON customer.customer_id = payment.customer_id
WHERE payment.amount = (SELECT MAX(amount) FROM payment)
