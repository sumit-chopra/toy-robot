package com.robot.toy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.robot.toy.components.Coordinate;
import com.robot.toy.components.Direction;
import com.robot.toy.components.ToyRobot;

public enum Command {
	
	/**
	 * Functional interface BiConsumer written as lamba
	 */
	PLACE((String command, ToyRobot robot) -> {
		List<Object> positionDirection = parsePlaceCommand(command);
		if ( !positionDirection.isEmpty() && positionDirection.size() == 2)
			robot.place((Coordinate) positionDirection.get(0), (Direction) positionDirection.get(1));
	}),
	MOVE((String command, ToyRobot robot) -> robot.move()),
	LEFT((String command, ToyRobot robot) -> robot.turnLeft()),
	RIGHT((String command, ToyRobot robot) -> robot.turnRight()),
	REPORT((String command, ToyRobot robot) -> System.out.println(robot.report())),
	EXIT((String command, ToyRobot robot) -> System.exit(0));
		
	/**
	 * Functional Interface. BiConsumer is from java.util.function
	 * Takes 2 arguments as input and does the processing.
	 * 
	 * Functional Interface can be written as lamba 
	 */
	private final BiConsumer<String, ToyRobot> processor;
	
	/**
	 * Enum constructor. Takes BiConsumer as the input
	 * @param commandProcessor command to be executed
	 */
	private Command(BiConsumer<String, ToyRobot> commandProcessor) {
		processor = commandProcessor;
	}
	
	/**
	 * Executes the lambda
	 * @param command - Command that the user has inputted
	 * @param robot - Instance of the toy robot on which this command needs to be executed
	 */
	public void executeCommand(String command, ToyRobot robot) {
		processor.accept(command, robot);
	}
	
	
	/**
	 * To parse the PLACE command. format should be PLACE <Integer,Integer,Direction>
	 *  All validations are done.
	 *  
	 * @param command - Input string that needs to be parsed. 
	 * @return List of objects containing Coordinate object and Direction enum
	 */
	public static List<Object> parsePlaceCommand(String command) {
		Logger logger = LoggerFactory.getLogger(Command.class);

		logger.info("Parsing place command " + command);
		List<Object> returnList = new ArrayList<Object>();
		if ( command != null && !command.isBlank()) {
			/* Split the command string with a space */
			String[] commandStr = command.trim().split(" ");
			/* There should be exactly two components */
			if ( commandStr.length == 2 ) {
				/* Split the second component by , */
				String[] positionDirectionArr = commandStr[1].split(",");
				/* There should be exactly 3 components - x,y, direction */
				if ( positionDirectionArr.length == 3 ) {
					try {
						/* parse first component into integer and pick up the value as x */
						int x = Integer.valueOf(positionDirectionArr[0].trim()).intValue();
						logger.info("Retrieved x value from the command " + x);
						/* parse second component into integer and pick up the value as y */
						int y = Integer.valueOf(positionDirectionArr[1].trim()).intValue();
						logger.info("Retrieved y value from the command " + y);
						/* Construct the coordinate object out of it */
						Coordinate initalPos = new Coordinate(x, y);
						/* parse the third component into Direction enum */
						Direction d = Direction.valueOf(positionDirectionArr[2].trim());
						logger.info("Retrieved direction value from the command " + d);
						return Arrays.asList(initalPos, d);
					} catch (NumberFormatException exception) {
						/* x or y could not be converted into integer */
						logger.error(exception.getMessage(),exception);
					}
					catch (IllegalArgumentException e) {
						/* Direction could not be converted into enum */
						logger.error(e.getMessage(),e);
					}	
				}
			}
		}
		if ( returnList.isEmpty()) {
			logger.error("Invalid place command ");
			System.out.println("Not a valid PLACE command. eg. PLACE 1,1,NORTH");
		}
		return returnList;
	}
}
