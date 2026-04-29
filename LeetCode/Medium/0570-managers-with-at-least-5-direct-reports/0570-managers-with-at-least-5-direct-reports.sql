# Write your MySQL query statement below

Select name
From Employee
where id IN (
    Select managerId
    From Employee
    Group By managerId
    Having count(*)>=5
);