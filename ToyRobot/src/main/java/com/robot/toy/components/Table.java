package com.robot.toy.components;

/**
 * Table class defines the boundaries for robot
 * @author sumit
 *
 */
public class Table {

	/* Defiens the botttomLeft corner */
	private Coordinate southWestCorner;
	/* Defiens the topRight corner */
	private Coordinate northEastCorner;
	
	/**
	 * Constructor
	 * @param southWeCorner - bottomLeft corner of the table
	 * @param northEastCorner - topRight corner of the table
	 */
	public Table(Coordinate southWeCorner, Coordinate northEastCorner) {
		this.southWestCorner = southWeCorner;
		this.northEastCorner = northEastCorner;
	}
	
	/**
	 * Constructor
	 * @param northEasCorner - topRight corner of the table
	 */
	public Table(Coordinate northEasCorner) {
		/* Assumes bottomLeft corner to be 0,0 */
		this.southWestCorner = new Coordinate(0, 0);
		this.northEastCorner = northEasCorner;
	}
	
	/**
	 * Checks whether a step taken from the given position will still lie on the table or not
	 * @param position - Position from where the step will be taken
	 * @param step - Step to be taken
	 * @return true if lies on table, otherwise false
	 */
	public boolean liesWithIn(Coordinate position, Coordinate step) {
		/* Creates a new coordinate by summing uop x and y of both */
		Coordinate newCoordinate = new Coordinate(position.getX() + step.getX(), position.getY() + step.getY());
		/* checks whether the new coordinate lies on the table or not */
		return liesWithIn(newCoordinate);
		
	}
	
	/**
	 * Checks whether the given position lies on the table or not
	 * @param position - Position that needs to be checked
	 * @return true if lies on table, otherwise false
	 */
	public boolean liesWithIn(Coordinate position) {
		/* Checks the position to be within the bounds of the table */
		if ( southWestCorner.getX() <= position.getX() && southWestCorner.getY() <= position.getY()
				&& northEastCorner.getX() >= position.getX() && northEastCorner.getY() >= position.getY()) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Returns String representation for the table object
	 */
	@Override
	public String toString() {
		return "NorthEast Corner : " + northEastCorner + " SouthWest Corner :" + southWestCorner;
	}
	
}
