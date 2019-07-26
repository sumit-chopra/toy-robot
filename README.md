# Toy Robot

This programming excercise has been solved using the following tools :

- Java 8
- Maven
- Junit
- SLF4J
- Log4J

## Code Flow
1. RobotApplication class receives the standard input
2. Forwards the input as and when it comes to Command class
3. Command class parses the input and find the matching command to be executed on Robot using lambda expressions
4. Robot class receives different inputs
- PLACE
- MOVE
- LEFT
- RIGHT
- REPORT
5. Robot class identifies whether the given command can be executed or not and executes if it can be

## Configuration File

config.properties is the configuration file which holds the following configuration

`table.northmost=5

table.eastmost=5`

log4j.properties holds the configuration file for logging

`log4j.rootLogger=TRACE, file

log4j.appender.file=org.apache.log4j.RollingFileAppender

log4j.appender.file.File=./logs/logging.log

log4j.appender.file.MaxFileSize=10MB

log4j.appender.file.MaxBackupIndex=10

log4j.appender.file.layout=org.apache.log4j.PatternLayout

log4j.appender.file.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n`

Both the properties files need to be present in the classpath

## Unit Tests

Unit tests has been written using Junit.

## Sample input

After running the program, each input command should be given on a separate line.
Valid commands are :
- PLACE 1,1,NORTH
- MOVE
- LEFT
- RIGHT
- REPORT
- EXIT

Only REPORT command will present output. The current location and direction of the robot.
No other command will present the output.
EXIT  will terminate the program.
