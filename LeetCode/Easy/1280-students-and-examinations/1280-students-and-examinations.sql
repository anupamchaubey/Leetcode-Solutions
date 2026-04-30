# Write your MySQL query statement below

select st.student_id, st.student_name, sub.subject_name, count(e.subject_name) as attended_exams
From Students st Cross Join Subjects sub
Left Join Examinations e
On st.student_id=e.student_id
And sub.subject_name=e.subject_name
Group By st.student_id, sub.subject_name
Order By st.student_id, sub.subject_name
