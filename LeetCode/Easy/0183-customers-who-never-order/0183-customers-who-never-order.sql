# Write your MySQL query statement below


Select c.name as Customers
From Customers c
Where Not Exists(
    Select 1 
    From Orders o
    where o.customerId=c.id
) 