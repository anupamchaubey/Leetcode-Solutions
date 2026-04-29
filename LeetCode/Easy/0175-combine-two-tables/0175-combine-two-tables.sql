# Write your MySQL query statement below

select firstName, lastName, city, state
From Person p Left Join Address a
ON p.personId=a.personId