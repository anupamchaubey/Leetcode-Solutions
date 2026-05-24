# Write your MySQL query statement below

select class 
From Courses
Group By class
Having Count(*)>=5