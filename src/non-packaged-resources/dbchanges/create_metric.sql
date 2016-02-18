CREATE TABLE weight.metric (
       metric_id INT NOT NULL AUTO_INCREMENT
     , name VARCHAR(200) NOT NULL
     , text_value TEXT
     , numeric_value DECIMAL
     , date_added TIMESTAMP
     , source TEXT
     , PRIMARY KEY (metric_id)
);

