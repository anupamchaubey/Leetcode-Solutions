# Write your MySQL query statement below
 
select a.machine_id,
Round(AVG(b.timestamp-a.timestamp), 3) as processing_time
From Activity a
JOIN Activity b
ON a.machine_id = b.machine_id
and a.process_id=b.process_id
where a.activity_type='start' and b.activity_type='end'
Group By machine_id