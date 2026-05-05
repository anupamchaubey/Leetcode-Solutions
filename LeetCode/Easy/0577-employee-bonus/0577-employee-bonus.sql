# Write your MySQL query statement below

select e.name as name, b.bonus as bonus
From Employee e
Left Join Bonus b
On e.empId=b.empId
where b.bonus is Null Or b.bonus<1000