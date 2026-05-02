# Write your MySQL query statement below

select s.user_id, round(IFNULL(
    sum(cf.action="confirmed")/count(cf.user_id), 0), 2) as confirmation_rate

from Signups s Left Join Confirmations cf
ON s.user_id=cf.user_id
Group By s.user_id