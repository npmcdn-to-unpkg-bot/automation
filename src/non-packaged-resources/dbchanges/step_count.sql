CREATE TABLE weight.step_count (
       id INT NOT NULL
     , person_id INT NOT NULL
     , value VARCHAR(20) NOT NULL
     , measure_start_date TIMESTAMP(19)
     , measure_end_date TIMESTAMP(19)
     , PRIMARY KEY (id)
     , CONSTRAINT FK_activity_1_1 FOREIGN KEY (person_id)
                  REFERENCES weight.person (person_id)
);

