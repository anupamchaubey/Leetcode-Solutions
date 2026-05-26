# Write your MySQL query statement below

select a.sell_date, count(Distinct a.product) as num_sold, 
Group_Concat(Distinct a.product separator ',') as products
From Activities a
Group By a.sell_date
Order By sell_date
