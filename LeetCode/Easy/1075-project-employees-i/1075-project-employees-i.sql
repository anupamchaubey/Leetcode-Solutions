# Write your MySQL query statement below

select project_id, round(avg(experience_years), 2) as average_years
from Project p JOIN Employee e
ON e.employee_id=p.employee_id
Group By p.project_id
