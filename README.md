# automation
===============================================

## Background
Automation tool for Web Services collections like Zapier/IFTTT


This application provides a user interface to a database to record my health measures.  Because what you don't measure you can't manage.  This database currently tracks three main areas.

- Weight: recorded daily in pounds, but a Withings Scale
- Activity: recorded by a Misfit Shine
- Blood Pressure and Pulse, recorded with iHealth BP Cuff 

The project requires:
 - [Jetty](http://eclispe.org/jetty)
 - JAVA >= 1.7 

This project is a maven project and should be built using:

    mvn clean install
    
To configure the Database run:

    mvn -p BuildDatabase    

To access the application run:

    mvn jetty:run

   Start Browser, [and click here](http://localhost:8080/): http://localhost:8080/



This application uses log4j, application logs are stored in <exe_root>/logs/.  There are three logs files of interest.

 - automation.log -- Main application log - Debug information is stored here
 - automation.audit.log -- Any audit information would be written here, should be empty for now
 - automation.sql.log -- Sql trace information is can be written here
 
The update [log4j.properties](src/main/resources/log4j.properties) to change location or log levels

## REST Commands
Post Activity
    curl -i -F name=test -F data=@localfile.csv http://localhost:8080/activity/record/

# Project Details
List the customer for whom this application was developed, at a minimum include names and email addresses.

-James Schappet <jschappet@gmail.com>




[![Build Status](https://travis-ci.org/jschappet/automation.svg?branch=master)](https://travis-ci.org/jschappet/automation/)
