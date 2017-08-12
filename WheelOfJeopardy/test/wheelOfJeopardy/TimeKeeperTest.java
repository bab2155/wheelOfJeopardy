/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheelOfJeopardy;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MikeWilkinson
 */
public class TimeKeeperTest {
    
    public TimeKeeperTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of startTimer method, of class TimeKeeper.
     */
    @Test
    public void testStartTimer() {
        int theDuration = 60;
        TimeKeeper instance = new TimeKeeper();
        instance.startTimer(theDuration);
        assertEquals(0,instance.getNumberOfSeconds());
    }

    /**
     * Test of stopTimer method, of class TimeKeeper.
     */
    @Test
    public void testStopTimer() {
        TimeKeeper instance = new TimeKeeper();
        instance.stopTimer();
        assertEquals(instance.getNumberOfSeconds(),0);
    }

    /**
     * Test of pauseTimer method, of class TimeKeeper.
     */
    @Test
    public void testPauseTimer() {
        TimeKeeper instance = new TimeKeeper();
        instance.pauseTimer();
        assertEquals(instance.getNumberOfSeconds(),0);
    }

    /**
     * Test of continueTimer method, of class TimeKeeper.
     */
    @Test
    public void testContinueTimer() {
        TimeKeeper instance = new TimeKeeper();
        instance.continueTimer();
        assertEquals(instance.getNumberOfSeconds(),0);
    }

    /**
     * Test of getNumberOfSeconds method, of class TimeKeeper.
     */
    @Test
    public void testGetNumberOfSeconds() {
        TimeKeeper instance = new TimeKeeper();
        int expResult = 0;
        int result = instance.getNumberOfSeconds();
        assertEquals(expResult, result);
        
    }
    
    public void addListener(TimeKeeperListener theListener){
        
    }
    
}
