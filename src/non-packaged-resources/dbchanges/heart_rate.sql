CREATE TABLE weight.heart_rate (
       heart_rate_id INT NOT NULL
     , person_id INT NOT NULL
     , value VARCHAR(20) NOT NULL
     , measure_date TIMESTAMP(19)
     , PRIMARY KEY (heart_rate_id)
     , CONSTRAINT FK_weight_1_1 FOREIGN KEY (person_id)
                  REFERENCES weight.person (person_id)
);

