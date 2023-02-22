SELECT address.district, SUM(payment.amount) AS amount
FROM payment
JOIN customer ON payment.customer_id = customer.customer_id
JOIN address ON customer.address_id = address.address_id
GROUP BY address.district
ORDER BY amount DESC
LIMIT 1;
