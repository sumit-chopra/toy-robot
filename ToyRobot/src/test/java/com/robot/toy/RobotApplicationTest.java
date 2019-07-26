package com.robot.toy;

import com.robot.toy.components.Coordinate;
import com.robot.toy.components.Direction;
import com.robot.toy.components.Table;
import com.robot.toy.components.ToyRobot;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class RobotApplicationTest 
    extends TestCase
{
	
	private static final String NOT_PLACED_STR = "Not Placed";
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public RobotApplicationTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( RobotApplicationTest.class );
    }

    /**
     * Try to place robot out of the table
     */
    public void testPlaceRobotOutOfTable()
    {
    	Coordinate northEastCorner = new Coordinate(5, 5);
        Table table = new Table(northEastCorner);
        ToyRobot robot = new ToyRobot(table);
        
        robot.place(new Coordinate(7, 7), Direction.NORTH);
        assertEquals(NOT_PLACED_STR, robot.report());
    }
    
    /**
     * Try to place robot out of the table and move
     */
    public void testPlaceRobotOutOfTableAndMove()
    {
    	Coordinate northEastCorner = new Coordinate(5, 5);
        Table table = new Table(northEastCorner);
        ToyRobot robot = new ToyRobot(table);
        
        robot.place(new Coordinate(7, 7), Direction.NORTH);
        robot.move();
        assertEquals(NOT_PLACED_STR, robot.report());
    }
    
    /**
     * Try to place robot out of the table and turn left
     */
    public void testPlaceRobotOutOfTableAndTurnLeft()
    {
    	Coordinate northEastCorner = new Coordinate(5, 5);
        Table table = new Table(northEastCorner);
        ToyRobot robot = new ToyRobot(table);
        
        robot.place(new Coordinate(7, 7), Direction.NORTH);
        robot.turnLeft();
        assertEquals(NOT_PLACED_STR, robot.report());
    }
    
    /**
     * Try to place robot out of the table and turn right
     */
    public void testPlaceRobotOutOfTableAndTurnRight()
    {
    	Coordinate northEastCorner = new Coordinate(5, 5);
        Table table = new Table(northEastCorner);
        ToyRobot robot = new ToyRobot(table);
        
        robot.place(new Coordinate(7, 7), Direction.NORTH);
        robot.turnRight();
        assertEquals(NOT_PLACED_STR, robot.report());
    }
    
    /**
     * Try to place robot out of the table and try moving on the table
     */
    public void testPlaceRobotOutOfTableAndMoveOnTable()
    {
    	Coordinate northEastCorner = new Coordinate(5, 5);
        Table table = new Table(northEastCorner);
        ToyRobot robot = new ToyRobot(table);
        
        robot.place(new Coordinate(6, 6), Direction.NORTH);
        robot.turnLeft();
        robot.move();
        robot.turnLeft();
        robot.move();
        assertEquals(NOT_PLACED_STR, robot.report());
    }
    
    /**
     * Place Robot on table
     */
    public void testPlaceRobot()
    {
    	Coordinate northEastCorner = new Coordinate(5, 5);
        Table table = new Table(northEastCorner);
        ToyRobot robot = new ToyRobot(table);
        
        robot.place(new Coordinate(1, 2), Direction.NORTH);
        assertEquals("1,2,NORTH", robot.report());
    }
    
    /**
     * Make robot turn left when direction north
     */
    public void testTurnLeftWhenNorth()
    {
    	Coordinate northEastCorner = new Coordinate(5, 5);
        Table table = new Table(northEastCorner);
        ToyRobot robot = new ToyRobot(table);
        
        robot.place(new Coordinate(3, 3), Direction.NORTH);
        robot.turnLeft();
        assertEquals("3,3,WEST", robot.report());
    }
    
    /**
     * Make robot turn left when direction south
     */
    public void testTurnLeftWhenSouth()
    {
    	Coordinate northEastCorner = new Coordinate(5, 5);
        Table table = new Table(northEastCorner);
        ToyRobot robot = new ToyRobot(table);
        
        robot.place(new Coordinate(3, 3), Direction.SOUTH);
        robot.turnLeft();
        assertEquals("3,3,EAST", robot.report());
    }
    
    /**
     * Make robot turn left when direction WEST
     */
    public void testTurnLeftWhenWest()
    {
    	Coordinate northEastCorner = new Coordinate(5, 5);
        Table table = new Table(northEastCorner);
        ToyRobot robot = new ToyRobot(table);
        
        robot.place(new Coordinate(3, 3), Direction.WEST);
        robot.turnLeft();
        assertEquals("3,3,SOUTH", robot.report());
    }
    
    /**
     * Make robot turn left when direction East
     */
    public void testTurnLeftWhenEast()
    {
    	Coordinate northEastCorner = new Coordinate(5, 5);
        Table table = new Table(northEastCorner);
        ToyRobot robot = new ToyRobot(table);
        
        robot.place(new Coordinate(3, 3), Direction.EAST);
        robot.turnLeft();
        assertEquals("3,3,NORTH", robot.report());
    }
    
    /**
     * Move when direction north
     */
    public void testRobotMoveWhenNorth()
    {
    	Coordinate northEastCorner = new Coordinate(5, 5);
        Table table = new Table(northEastCorner);
        ToyRobot robot = new ToyRobot(table);
        
        robot.place(new Coordinate(3, 3), Direction.NORTH);
        robot.move();
        assertEquals("3,4,NORTH", robot.report());
    }
    
    /**
     * Move when direction south
     */
    public void testRobotMoveWhenSouth()
    {
    	Coordinate northEastCorner = new Coordinate(5, 5);
        Table table = new Table(northEastCorner);
        ToyRobot robot = new ToyRobot(table);
        
        robot.place(new Coordinate(3, 3), Direction.SOUTH);
        robot.move();
        assertEquals("3,2,SOUTH", robot.report());
    }
    
    /**
     * Move when direction west
     */
    public void testRobotMoveWhenWest()
    {
    	Coordinate northEastCorner = new Coordinate(5, 5);
        Table table = new Table(northEastCorner);
        ToyRobot robot = new ToyRobot(table);
        
        robot.place(new Coordinate(3, 3), Direction.WEST);
        robot.move();
        assertEquals("2,3,WEST", robot.report());
    }
    
    /**
     * Move when direction East
     */
    public void testRobotMoveWhenEast()
    {
    	Coordinate northEastCorner = new Coordinate(5, 5);
        Table table = new Table(northEastCorner);
        ToyRobot robot = new ToyRobot(table);
        
        robot.place(new Coordinate(3, 3), Direction.EAST);
        robot.move();
        assertEquals("4,3,EAST", robot.report());
    }
    
    /**
     * Move out of the table
     */
    public void testRobotMoveOutOfTableNorth()
    {
    	Coordinate northEastCorner = new Coordinate(5, 5);
        Table table = new Table(northEastCorner);
        ToyRobot robot = new ToyRobot(table);
        
        robot.place(new Coordinate(5, 5), Direction.NORTH);
        robot.move();
        assertEquals("5,5,NORTH", robot.report());
    }
    
    /**
     * Move out of the table
     */
    public void testRobotMoveOutOfTableSouth()
    {
    	Coordinate northEastCorner = new Coordinate(5, 5);
        Table table = new Table(northEastCorner);
        ToyRobot robot = new ToyRobot(table);
        
        robot.place(new Coordinate(0,0), Direction.SOUTH);
        robot.move();
        assertEquals("0,0,SOUTH", robot.report());
    }
    
    
    /**
     * Move 
     */
    public void testRobotMove1()
    {
    	Coordinate northEastCorner = new Coordinate(5, 5);
        Table table = new Table(northEastCorner);
        ToyRobot robot = new ToyRobot(table);
        
        robot.place(new Coordinate(0, 0), Direction.NORTH);
        robot.move();
        assertEquals("0,1,NORTH", robot.report());
    }
    
    /**
     * Move 
     */
    public void testRobotMove2()
    {
    	Coordinate northEastCorner = new Coordinate(5, 5);
        Table table = new Table(northEastCorner);
        ToyRobot robot = new ToyRobot(table);
        
        robot.place(new Coordinate(1, 2), Direction.EAST);
        robot.move();
        robot.move();
        robot.turnLeft();
        robot.move();
        assertEquals("3,3,NORTH", robot.report());
    }
    
    /**
     * Move without placing
     */
    public void testRobotMoveWithoutPlacing()
    {
    	Coordinate northEastCorner = new Coordinate(5, 5);
        Table table = new Table(northEastCorner);
        ToyRobot robot = new ToyRobot(table);
       
        robot.move();
       
        assertEquals(NOT_PLACED_STR, robot.report());
    }
    
    /**
     * Turn Left without placing
     */
    public void testRobotTurnLeftWithoutPlacing()
    {
    	Coordinate northEastCorner = new Coordinate(5, 5);
        Table table = new Table(northEastCorner);
        ToyRobot robot = new ToyRobot(table);
       
        robot.turnLeft();
       
        assertEquals(NOT_PLACED_STR, robot.report());
    }
   
    /**
     * Turn right without placing
     */
    public void testRobotTurnRightWithoutPlacing()
    {
    	Coordinate northEastCorner = new Coordinate(5, 5);
        Table table = new Table(northEastCorner);
        ToyRobot robot = new ToyRobot(table);
       
        robot.turnRight();
       
        assertEquals(NOT_PLACED_STR, robot.report());
    }
    
   
}
