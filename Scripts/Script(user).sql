show tables;
select * from courses;

select stud_id as studid, name, email, dob, phone 
from students
where stud_id = 1;
delete
from students
where stud_id = 3;

select stud_id, name, email, phone, a.addr_id, street, city, zip, country
		from students s left outer join addresses a on s.addr_id=a.addr_id;