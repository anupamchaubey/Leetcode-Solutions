# Write your MySQL query statement below
SELECT w.id
FROM Weather w
INNER JOIN Weather t
ON DATEDIFF(w.recordDate, t.recordDate)=1
WHERE w.temperature>t.temperature