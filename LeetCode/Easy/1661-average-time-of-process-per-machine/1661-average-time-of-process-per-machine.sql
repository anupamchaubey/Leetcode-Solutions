# Write your MySQL query statement below

select a.machine_id, round(avg(
    (select p.timestamp as end
    from Activity p
    where p.machine_id=a.machine_id and a.process_id=p.process_id and activity_type='end')
    - (
        select p.timestamp as start
    from Activity p
    where p.machine_id=a.machine_id and a.process_id=p.process_id and activity_type='start'
    )
), 3) as processing_time
 From Activity a
 Group BY machine_id