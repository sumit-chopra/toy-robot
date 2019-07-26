package com.robot.toy.components;

/**
 * Coordinate Class - Depicting a position in terms of x and y coordinates
 * @author sumit
 *
 */
public class Coordinate {
	/* x coordinate of the position */
	private int x;
	
	/* y coordinate of the position */
	private int y;
	
	/**
	 * Cosntructor
	 * @param x - coordinate on the x axis
	 * @param y - coordinate on the y axis
	 */
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Method to add a step to the current coordinate object
	 * 
	 * @param step - Steps in terms of coordinate'x x and y 
	 */
	public void addStep(Coordinate step) {
		x += step.x;
		y += step.y;
	}
	
	/**
	 * Returns x coordinate
	 * @return x coordinate
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Sets x coordinate
	 * @param x - value of x coordinate
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * Returns y coordinate
	 * @return y coordinate
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Sets y coordinate
	 * @param y - value of y coordinate
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * String representation of the coordinate object
	 */
	@Override
	public String toString() {
		return x + "," + y;
	}
	
	
	
}
