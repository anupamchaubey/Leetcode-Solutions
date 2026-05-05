# Write your MySQL query statement below

select email
From Person 
Group By email
Having count(email)>1