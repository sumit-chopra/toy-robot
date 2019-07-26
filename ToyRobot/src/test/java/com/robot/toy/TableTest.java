package com.robot.toy;

import com.robot.toy.components.Coordinate;
import com.robot.toy.components.Table;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class TableTest 
    extends TestCase
{
	
	private static final String NOT_PLACED_STR = "Not Placed";
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public TableTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( TableTest.class );
    }
   
    /**
     * Test bottom left coordinate lies on table 
     */
    public void testTableLiesWithInBottomLeftCorner()
    {
    	Coordinate northEastCorner = new Coordinate(5, 5);
        Table table = new Table(northEastCorner);
       
        assertEquals(true, table.liesWithIn(new Coordinate(0, 0)));
    }
    
    /**
     * Test top right coordinate lies on table 
     */
    public void testTableLiesWithInTopRightCorner()
    {
    	Coordinate northEastCorner = new Coordinate(5, 5);
        Table table = new Table(northEastCorner);
       
        assertEquals(true, table.liesWithIn(new Coordinate(5, 5)));
    }
    
    /**
     * Test top left coordinate lies on table 
     */
    public void testTableLiesWithInTopLeftCorner()
    {
    	Coordinate northEastCorner = new Coordinate(5, 5);
        Table table = new Table(northEastCorner);
       
        assertEquals(true, table.liesWithIn(new Coordinate(5, 0)));
    }
    
    /**
     * Test bottom right left coordinate lies on table 
     */
    public void testTableLiesWithInBottomRightCorner()
    {
    	Coordinate northEastCorner = new Coordinate(5, 5);
        Table table = new Table(northEastCorner);
       
        assertEquals(true, table.liesWithIn(new Coordinate(0, 5)));
    }
    
    /**
     * Test coordinate lies on table 
     */
    public void testTableLiesWithIn1()
    {
    	Coordinate northEastCorner = new Coordinate(5, 5);
        Table table = new Table(northEastCorner);
       
        assertEquals(true, table.liesWithIn(new Coordinate(1, 1)));
    }
    
    /**
     * Test coordinate lies on table 
     */
    public void testTableLiesWithIn2()
    {
    	Coordinate northEastCorner = new Coordinate(5, 5);
        Table table = new Table(northEastCorner);
       
        assertEquals(true, table.liesWithIn(new Coordinate(2, 2)));
    }
    
    /**
     * Test coordinate lies on table 
     */
    public void testTableLiesWithIn3()
    {
    	Coordinate northEastCorner = new Coordinate(5, 5);
        Table table = new Table(northEastCorner);
       
        assertEquals(true, table.liesWithIn(new Coordinate(3, 5)));
    }
    
    /**
     * Test coordinate lies outside of table 
     */
    public void testTableLiesOutside1()
    {
    	Coordinate northEastCorner = new Coordinate(5, 5);
        Table table = new Table(northEastCorner);
       
        assertEquals(false, table.liesWithIn(new Coordinate(0, 6)));
    }
    
    /**
     * Test coordinate lies outside of table 
     */
    public void testTableLiesOutside2()
    {
    	Coordinate northEastCorner = new Coordinate(5, 5);
        Table table = new Table(northEastCorner);
       
        assertEquals(false, table.liesWithIn(new Coordinate(5, 6)));
    }
    
    /**
     * Test coordinate lies outside of table 
     */
    public void testTableLiesOutside3()
    {
    	Coordinate northEastCorner = new Coordinate(5, 5);
        Table table = new Table(northEastCorner);
       
        assertEquals(false, table.liesWithIn(new Coordinate(6, 5)));
    }
    
    /**
     * Test coordinate lies outside of table 
     */
    public void testTableLiesOutside4()
    {
    	Coordinate northEastCorner = new Coordinate(5, 5);
        Table table = new Table(northEastCorner);
       
        assertEquals(false, table.liesWithIn(new Coordinate(6, 0)));
    }
    
    /**
     * Test coordinate lies outside of table 
     */
    public void testTableLiesOutside5()
    {
    	Coordinate northEastCorner = new Coordinate(5, 5);
        Table table = new Table(northEastCorner);
       
        assertEquals(false, table.liesWithIn(new Coordinate(8, 9)));
    }
    
    /**
     * Test step lies with in 
     */
    public void testTableLiesStepWithIn1()
    {
    	Coordinate northEastCorner = new Coordinate(5, 5);
        Table table = new Table(northEastCorner);
       
        assertEquals(true, table.liesWithIn(new Coordinate(0, 0), new Coordinate(0, 1)));
    }
    
    /**
     * Test step lies with in 
     */
    public void testTableLiesStepWithIn2()
    {
    	Coordinate northEastCorner = new Coordinate(5, 5);
        Table table = new Table(northEastCorner);
       
        assertEquals(true, table.liesWithIn(new Coordinate(0, 0), new Coordinate(1, 0)));
    }
    
    /**
     * Test step lies with in 
     */
    public void testTableLiesStepWithIn3()
    {
    	Coordinate northEastCorner = new Coordinate(5, 5);
        Table table = new Table(northEastCorner);
       
        assertEquals(false, table.liesWithIn(new Coordinate(0, 0), new Coordinate(0, -1)));
    }
    
    /**
     * Test step lies with in 
     */
    public void testTableLiesStepWithIn4()
    {
    	Coordinate northEastCorner = new Coordinate(5, 5);
        Table table = new Table(northEastCorner);
       
        assertEquals(false, table.liesWithIn(new Coordinate(0, 0), new Coordinate(-1, 0)));
    }
    
    /**
     * Test step lies with in 
     */
    public void testTableLiesStepWithIn5()
    {
    	Coordinate northEastCorner = new Coordinate(5, 5);
        Table table = new Table(northEastCorner);
       
        assertEquals(false, table.liesWithIn(new Coordinate(5, 5), new Coordinate(0, 1)));
    }
    
    /**
     * Test step lies with in 
     */
    public void testTableLiesStepWithIn6()
    {
    	Coordinate northEastCorner = new Coordinate(5, 5);
        Table table = new Table(northEastCorner);
       
        assertEquals(false, table.liesWithIn(new Coordinate(5, 5), new Coordinate(1, 0)));
    }
    
    /**
     * Test step lies with in 
     */
    public void testTableLiesStepWithIn7()
    {
    	Coordinate northEastCorner = new Coordinate(5, 5);
        Table table = new Table(northEastCorner);
       
        assertEquals(true, table.liesWithIn(new Coordinate(5, 5), new Coordinate(0, -1)));
    }
    
    /**
     * Test step lies with in 
     */
    public void testTableLiesStepWithIn8()
    {
    	Coordinate northEastCorner = new Coordinate(5, 5);
        Table table = new Table(northEastCorner);
       
        assertEquals(true, table.liesWithIn(new Coordinate(5, 5), new Coordinate(-1, 0)));
    }
    
    /**
     * Test step lies with in 
     */
    public void testTableLiesStepWithIn9()
    {
    	Coordinate northEastCorner = new Coordinate(5, 5);
        Table table = new Table(northEastCorner);
       
        assertEquals(true, table.liesWithIn(new Coordinate(5, 0), new Coordinate(0, 1)));
    }
    
    /**
     * Test step lies with in 
     */
    public void testTableLiesStepWithIn10()
    {
    	Coordinate northEastCorner = new Coordinate(5, 5);
        Table table = new Table(northEastCorner);
       
        assertEquals(false, table.liesWithIn(new Coordinate(5, 0), new Coordinate(1, 0)));
    }
    
    /**
     * Test step lies with in 
     */
    public void testTableLiesStepWithIn11()
    {
    	Coordinate northEastCorner = new Coordinate(5, 5);
        Table table = new Table(northEastCorner);
       
        assertEquals(false, table.liesWithIn(new Coordinate(5, 0), new Coordinate(0, -1)));
    }
    
    /**
     * Test step lies with in 
     */
    public void testTableLiesStepWithIn12()
    {
    	Coordinate northEastCorner = new Coordinate(5, 5);
        Table table = new Table(northEastCorner);
       
        assertEquals(true, table.liesWithIn(new Coordinate(5, 0), new Coordinate(-1, 0)));
    }
    
    /**
     * Test step lies with in 
     */
    public void testTableLiesStepWithIn13()
    {
    	Coordinate northEastCorner = new Coordinate(5, 5);
        Table table = new Table(northEastCorner);
       
        assertEquals(false, table.liesWithIn(new Coordinate(0, 5), new Coordinate(0, 1)));
    }
    
    /**
     * Test step lies with in 
     */
    public void testTableLiesStepWithIn14()
    {
    	Coordinate northEastCorner = new Coordinate(5, 5);
        Table table = new Table(northEastCorner);
       
        assertEquals(true, table.liesWithIn(new Coordinate(0, 5), new Coordinate(1, 0)));
    }
    
    /**
     * Test step lies with in 
     */
    public void testTableLiesStepWithIn15()
    {
    	Coordinate northEastCorner = new Coordinate(5, 5);
        Table table = new Table(northEastCorner);
       
        assertEquals(true, table.liesWithIn(new Coordinate(0, 5), new Coordinate(0, -1)));
    }
    
    /**
     * Test step lies with in 
     */
    public void testTableLiesStepWithIn16()
    {
    	Coordinate northEastCorner = new Coordinate(5, 5);
        Table table = new Table(northEastCorner);
       
        assertEquals(false, table.liesWithIn(new Coordinate(0, 5), new Coordinate(-1, 0)));
    }
    
    
    
   
}
