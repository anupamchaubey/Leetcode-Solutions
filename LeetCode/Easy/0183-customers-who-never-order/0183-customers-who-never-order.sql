# Write your MySQL query statement below
select c.name as Customers 
From Customers c
Left Join Orders o
On c.id=o.customerId
where o.customerId is null