# Write your MySQL query statement below

select max(s.nu) as num
From (
    Select num as nu
From MyNumbers
Group By num
Having count(num)=1
) as s
