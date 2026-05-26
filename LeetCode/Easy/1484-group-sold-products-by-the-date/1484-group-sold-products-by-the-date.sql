# Write your MySQL query statement below

select sell_date, count(Distinct product) as num_sold,
Group_Concat(Distinct product Order By product ASC separator ',') as products
From Activities
Group By sell_date
Order By sell_date