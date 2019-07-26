package com.robot.toy;

import java.util.Arrays;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.robot.toy.components.Coordinate;
import com.robot.toy.components.Table;
import com.robot.toy.components.ToyRobot;
import com.robot.toy.util.PropertiesLoader;

/**
 * Main Application Class
 * Reads input from the standard input and passes it on to Command processor
 * @author sumit
 *
 */
public class RobotApplication {
	
	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(RobotApplication.class);
		
		logger.trace("Starting ToyRobot application");
		
		/* Read northeast corner values from properties files */
		PropertiesLoader prop = PropertiesLoader.getInstance();
		int northMost = prop.getPositiveIntProperty("table.northmost", 5);
		int eastMost = prop.getPositiveIntProperty("table.eastmost", 5);
		Coordinate northEast = new Coordinate(northMost, eastMost);
		
		/* Initialize the table with northEast coordinates */
		Table table = new Table(northEast);
		logger.info("Initialized table " + table);
		
		/* Instantiate the Robot object
		 * By default, robot is not in active state.
		 * It can not turn or move, unless or until
		 * it has been places on the table 
		*/
		ToyRobot robot = new ToyRobot(table);
		
		Scanner scanner = new Scanner(System.in);
		logger.info("Waiting for input");
		/* Waiting for the input in infinte loop */
		/* The program will exit when user enters EXIT command */
		while (true) {
			/* Read the command from standard input and convert into upper case */
			String command = scanner.nextLine().trim().toUpperCase();
			logger.info("Command received : " + command);
			try {
				Command commandEnum = Command.valueOf(command.split(" ")[0]);
				commandEnum.executeCommand(command, robot);
				logger.info("Command executed");
			} catch (IllegalArgumentException exception) {
				logger.error("Invalid command entered by the user");
				System.out.println("Invalid command. Valid values are : " + Arrays.asList(Command.values()));
			}
		}
	}
}