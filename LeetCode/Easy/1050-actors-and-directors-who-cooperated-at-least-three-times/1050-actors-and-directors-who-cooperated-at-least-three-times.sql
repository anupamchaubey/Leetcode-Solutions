# Write your MySQL query statement below

select actor_id, director_id
From ActorDirector
Group By actor_id, director_id
Having count(*)>=3