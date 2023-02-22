SELECT name,COUNT(name) FROM cd.facilities 
INNER JOIN cd.bookings ON cd.facilities.facid = bookings.facid
GROUP BY name
ORDER BY COUNT(name) DESC
LIMIT 1;