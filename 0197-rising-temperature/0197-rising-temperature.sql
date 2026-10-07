# Write your MySQL query statement below
SELECT w.id
FROM Weather w
 JOIN Weather t
WHERE DATEDIFF(w.recordDate, t.recordDate)=1 AND w.temperature>t.temperature