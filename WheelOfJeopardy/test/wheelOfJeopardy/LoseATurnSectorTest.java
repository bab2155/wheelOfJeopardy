package wheelOfJeopardy;

import static org.junit.Assert.*;

import org.junit.Test;
import wheelOfJeopardy.LoseATurnSector;

public class LoseATurnSectorTest {

	@Test
	public void testLoseATurnSectorName() {
		LoseATurnSector testLoseATurn = new LoseATurnSector();
		assertEquals(testLoseATurn.Name,"Lose A Turn");
	}

}
