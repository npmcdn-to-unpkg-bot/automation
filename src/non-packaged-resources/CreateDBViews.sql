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
	
	
	
create or replace view summary_vitals_tmp  as  

 select   floor((rand() * 500)) AS `id`, `vitals`.`person_id` AS `person_id`,
 date_format(`vitals`.`vitals_date`,'%Y-%m') AS `month_year`,
 avg(`vitals`.`systolic` + 0 ) AS `avg_systolic`,
 min(`vitals`.`systolic` + 0) AS `min_systolic`,
 max(`vitals`.`systolic` + 0) AS `max_systolic`,
 avg(`vitals`.`diatolic` + 0 ) AS `avg_diatolic`,
 min(`vitals`.`diatolic` + 0) AS `min_diatolic`,
 max(`vitals`.`diatolic` + 0) AS `max_diatolic`,
 avg(`heart_rate`.`value` + 0 ) AS `avg_pulse`,
 min(`heart_rate`.`value` + 0) AS `min_pulse`,
 max(`heart_rate`.`value` + 0) AS `max_pulse`     
 from `vitals` left outer join `heart_rate` on `vitals`.`vitals_date` = `heart_rate`.`measure_date`       
 group by    `vitals`.`person_id`,   date_format(`vitals`.`vitals_date`,'%Y-%m') 
 order by  date_format(`vitals`.`vitals_date`,'%Y-%m');

 select * from summary_vitals left outer join sumamry_heart_rate 
 where summary_vitals.month_year = sumamry_heart_rate.month_year 
 
create or replace view summary_vitals  as  
select summary_vitals_tmp.month_year, floor((rand() * 500)) AS `id`,
`summary_vitals_tmp`.`person_id`, 
 avg_systolic, min_systolic, max_systolic, 
 min_diatolic, avg_diatolic, max_diatolic, 
 summary_heart_rate.avg_pulse, 
 summary_heart_rate.max_pulse, 
 summary_heart_rate.min_pulse 
 from summary_vitals_tmp 
 	left outer join summary_heart_rate   on summary_vitals_tmp.month_year = summary_heart_rate.month_year 
order by summary_vitals_tmp.month_year ;
 
 
 
create or replace view summary_heart_rate  as   
 select   floor((rand() * 500)) AS `id`, `heart_rate`.`person_id` AS `person_id`,
  date_format(`heart_rate`.`measure_date`,'%Y-%m') AS `month_year`,
 avg(`heart_rate`.`value` + 0 ) AS `avg_pulse`,
 min(`heart_rate`.`value` + 0) AS `min_pulse`,
 max(`heart_rate`.`value` + 0) AS `max_pulse`     
 from  `heart_rate`        
 group by    `heart_rate`.`person_id`,   date_format(`heart_rate`.`measure_date`,'%Y-%m') 
 order by  date_format(`heart_rate`.`measure_date`,'%Y-%m');
 