# Write your MySQL query statement below

select e.name as Employee
From Employee e
Join Employee m
On e.managerId=m.id
where e.salary > m.salary