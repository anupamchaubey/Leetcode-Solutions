# Write your MySQL query statement below

Select w.id
From Weather w
where w.temperature>(
    Select nw.temperature
    From Weather nw
    Where Datediff(w.recordDate, nw.recordDate)=1
)