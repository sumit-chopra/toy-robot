package com.robot.toy.components;

/**
 * Enum for Direction
 * @author sumit
 *
 */
public enum Direction {

	/**
	 * List all 4 possible directions
	 */
	NORTH,
	SOUTH,
	WEST,
	EAST;

	/* Direction when Robot turns left from the current direction */
	private Direction leftDirection;
	
	/* Direction when Robot turns right from the current direction */
	private Direction rightDirection;
	
	/* Step in terms of incremental x and y with respect to the current direction */
	private Coordinate step;
	
	static {
		/**
		 * Initializing leftDirection, rightDirection and step for each of the direction
		 */
		
		NORTH.leftDirection = WEST;
		NORTH.rightDirection = EAST;
		NORTH.step = new Coordinate(0, 1);
		
		SOUTH.leftDirection = EAST;
		SOUTH.rightDirection = WEST;
		SOUTH.step = new Coordinate(0, -1);
		
		WEST.leftDirection = SOUTH;
		WEST.rightDirection = NORTH;
		WEST.step = new Coordinate(-1, 0);
		
		EAST.leftDirection = NORTH;
		EAST.rightDirection = SOUTH;
		EAST.step = new Coordinate(1, 0);
		
	
	}
	
	/**
	 * Gets the direction if robot turns left from the current direction
	 * @return Direction
	 */
	public Direction getLeftDirection() {
		return leftDirection;
	}
	
	/**
	 * Gets the direction if robot turns right from the current direction 
	 * @return Direction
	 */
	public Direction getRightDirection() {
		return rightDirection;
	}
	
	/**
	 * Gets the step value in terms of x and y coordinates if robot makes a move
	 * @return
	 */
	public Coordinate getStep() {
		return step;
	}	
}
