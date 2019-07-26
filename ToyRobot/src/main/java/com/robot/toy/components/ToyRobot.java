package com.robot.toy.components;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ToRobot
 * Holds the current position, placement state and the current direction
 * @author sumit
 *
 */
public class ToyRobot {
	
	Logger logger = LoggerFactory.getLogger(ToyRobot.class);

	/* Current position of the robot */
	private Coordinate currentPosition;
	
	/* Current direction of the robot */
	
	private Direction currentDirection;
	
	/* Table on which the robot needs to move */
	private Table table;
	
	/* Whether it has been placed successfully or not */
	private boolean isPlaced = false;
	
	/**
	 * Constructor 
	 * @param table - Table on which Robot will be placed. Helps to define the bounds
	 */
	public ToyRobot(Table table) {
		this.table = table;
	}
	
	/**
	 * Initializes the robot on the table with position and direction
	 * @param position - Position of the robot
	 * @param direction - Direction of the robot
	 */
	public void place(Coordinate position, Direction direction) {
		/* Checks whether the given position lies on the table or not */
		if (table.liesWithIn(position)) {
			currentPosition = position;
			currentDirection = direction;
			isPlaced = true;
			logger.info("Placed robot on the table " + currentPosition + " " + currentDirection);
		} else {
			String logMessage = "Unable to place robot on the table as position %s does not lie on the table %s";
			logMessage = String.format(logMessage, position.toString(), table.toString());
			logger.error(logMessage);
			currentPosition = null;
			currentDirection = null;
			isPlaced = false;
		}
	}
	
	/**
	 * Turns left if is places on the table and changes its current direction
	 */
	public void turnLeft() {
		if ( isPlaced ) {
			currentDirection = currentDirection.getLeftDirection();
			logger.info("Robot turned left. Current direction " + currentDirection);
		} else {
			logger.error("Robot not placed, can not turn left");
		}
	}
	
	/**
	 * Turns Right if is places on the table and changes its current direction
	 */
	public void turnRight() {
		if ( isPlaced ) {
			currentDirection = currentDirection.getRightDirection();
			logger.info("Robot turned right. Current direction " + currentDirection);
		} else {
			logger.error("Robot not placed, can not turn right");
		}
	}
	
	/**
	 * Moves one step in the current direction if it is placed and if new position is still on table
	 */
	public void move() {
		if ( isPlaced ) {
			/* Gets the step corresponding to the current dierection */
			Coordinate step = currentDirection.getStep();
			/* Check whether taking one step from the current position will still land robot on the table */
			if (table.liesWithIn(currentPosition, step)) {
				/* adds step to the current position */
				currentPosition.addStep(step);
				logger.info("Robot moved one step. New position " + currentPosition.toString());
			} else {
				logger.error("Robot new position not on table, can not move");
			}
		} else {
			logger.error("Robot not placed, can not move");
		}
	}
	
	/**
	 * Reports the current position and direction
	 * @return String with current positin and direction
	 */
	public String report() {
		return toString();
	}
	
	/**
	 * String representation of the robot
	 */
	@Override
	public String toString() {
		if ( isPlaced ) {
			return currentPosition + "," + currentDirection;
		} else {
			return "Not Placed";
		}
	}
}	