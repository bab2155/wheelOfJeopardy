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
public class DatabaseManagerTest {
    
    public DatabaseManagerTest() {
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
     * Test of validateDatabaseName method, of class DatabaseManager.
     */
    @Test
    public void testValidateDatabaseName() {
        System.out.println("validateDatabaseName");
        DatabaseManager instance = null;
        boolean expResult = false;
        boolean result = instance.validateDatabaseName();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of createQuestionBoards method, of class DatabaseManager.
     */
    @Test
    public void testCreateQuestionBoards() {
        System.out.println("createQuestionBoards");
        String theDatabaseName = "questions.json";
        QuestionBoard[] expResult = null;
        QuestionBoard[] result = DatabaseManager.createQuestionBoards(theDatabaseName);
        //assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDatabaseNames method, of class DatabaseManager.
     */
    @Test
    public void testGetDatabaseNames() {
        System.out.println("getDatabaseNames");
        String[] expResult = null;
        String[] result = DatabaseManager.getDatabaseNames();
        //assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
