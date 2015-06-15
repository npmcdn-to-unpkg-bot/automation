create or replace view
average_weight  as 
select 
	person_id,DATE_FORMAT(weight_in_date,'%Y-%m') as month_year,   
	format(avg(value),2) as avg_weight
from weight
group by person_id,DATE_FORMAT(weight_in_date,'%Y-%m')
;

create or replace view 
total_activity as 
select `activity`.`person_id` AS `person_id`,date_format(`activity`.`activity_date`,'%Y-%m') AS `month_year`,sum(`activity`.`value`) AS `total_activity` from `activity` group by `activity`.`person_id`,date_format(`activity`.`activity_date`,'%Y-%m')


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
	
	