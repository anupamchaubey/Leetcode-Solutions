# Write your MySQL query statement below

select q.query_name as query_name,  round(avg(q.rating/ q.position), 2) as quality, round((sum(q.rating<3)/ count(q.rating))*100, 2) as poor_query_percentage

from Queries q
Group By query_name