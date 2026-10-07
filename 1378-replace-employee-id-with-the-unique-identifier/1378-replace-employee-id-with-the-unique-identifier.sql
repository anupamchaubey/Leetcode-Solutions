# Write your MySQL query statement below
SELECT b.unique_id as unique_id, a.name as name
FROM Employees a
LEFT JOIN EmployeeUNI b
ON a.id=b.id
