package wheelOfJeopardy;

import static org.junit.Assert.*;

import org.junit.Test;
import wheelOfJeopardy.OpponentsChoiceSector;

public class OpponentsChoiceSectorTest {

	@Test
	public void testOpponentsChoiceName() {
		OpponentsChoiceSector testOpponentsChoice = new OpponentsChoiceSector();
		assertEquals(testOpponentsChoice.Name,"Opponents Choice");
	}

}
