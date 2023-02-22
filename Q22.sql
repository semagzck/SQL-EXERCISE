SELECT TO_CHAR(joindate,'Month') AS  month,  COUNT(*)  AS member_amount
FROM cd.members
GROUP BY month
ORDER BY member_amount DESC
LIMIT 1;