# Write your MySQL query statement below

select w.id
From Weather w
Join Weather c

where DateDiff(w.recordDate, c.recordDate)=1 and c.temperature<w.temperature