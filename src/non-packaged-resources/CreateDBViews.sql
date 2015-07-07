create or replace view
average_weight  as 
 select 
  `weight`.`person_id` AS `person_id`,
  date_format(`weight`.`weight_in_date`,'%Y-%m') AS `month_year`,
  avg(`weight`.`value` + 0 ) AS `avg_weight`,
  min(`weight`.`value` + 0) AS `min_weight`,
  max(`weight`.`value` + 0) AS `max_weight` 
 from `weight` 
 group by 
  `weight`.`person_id`,
  date_format(`weight`.`weight_in_date`,'%Y-%m') 
;

create or replace view 
total_activity as 
select `activity`.`person_id` AS `person_id`,date_format(`activity`.`activity_date`,'%Y-%m') AS `month_year`,
	sum(`activity`.`value` + 0) AS `total_activity`,
	min(`activity`.`value` + 0 ) AS `min_activity`,
	max(`activity`.`value` +0) AS `max_activity`,
	avg(`activity`.`value`+ 0) AS `avg_activity` 
from `activity` 
group by `activity`.`person_id`,date_format(`activity`.`activity_date`,'%Y-%m')


create or replace view
summary_table  as 
select 
 	FLOOR(RAND() * 500) as id,
 	average_weight.person_id, 
 	average_weight.month_year, 
 	total_activity, avg_weight 
from 
   average_weight 
     left outer join  total_activity 
       on (total_activity.month_year = average_weight.month_year 
         and total_activity.person_id = average_weight.person_id )
order by person_id,
	average_weight.month_year;
	
	
	
create or replace view summary_vitals  as  

 select   floor((rand() * 500)) AS `id`,    `vitals`.`person_id` AS `person_id`, 
   date_format(`vitals`.`vitals_date`,'%Y-%m') AS `month_year`, 
     avg(`vitals`.`systolic` + 0 ) AS `avg_systolic`,  
     min(`vitals`.`systolic` + 0) AS `min_systolic`, 
     max(`vitals`.`systolic` + 0) AS `max_systolic`,

     avg(`vitals`.`diatolic` + 0 ) AS `avg_diatolic`,  
     min(`vitals`.`diatolic` + 0) AS `min_diatolic`, 
     max(`vitals`.`diatolic` + 0) AS `max_diatolic`,

     avg(`vitals`.`pulse` + 0 ) AS `avg_pulse`,  
     min(`vitals`.`pulse` + 0) AS `min_pulse`, 
     max(`vitals`.`pulse` + 0) AS `max_pulse`


  from `vitals`   
  group by    `vitals`.`person_id`,   date_format(`vitals`.`vitals_date`,'%Y-%m');