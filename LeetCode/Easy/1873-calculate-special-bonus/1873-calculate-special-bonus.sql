# Write your MySQL query statement below

select employee_id, 
Case
When employee_id % 2 != 0 And name Not like 'M%' Then salary
Else 0
End as bonus
From Employees
order by employee_id