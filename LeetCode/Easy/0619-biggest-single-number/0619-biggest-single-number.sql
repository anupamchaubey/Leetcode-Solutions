# Write your MySQL query statement below

select(
    select num
From MyNumbers
Group By num
Having count(num)=1
Order By num Desc
limit 1
) as num