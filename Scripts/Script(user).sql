show tables;
select * from courses;

select stud_id as studid, name, email, dob, phone 
from students
where stud_id = 1;
delete
from students
where stud_id = 3;