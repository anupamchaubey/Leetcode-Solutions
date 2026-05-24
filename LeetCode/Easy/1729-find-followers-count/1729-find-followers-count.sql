# Write your MySQL query statement below

select user_id, count(*) as followers_count
From Followers
Group By user_id
Order By user_id