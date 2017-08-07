package wheelOfJeopardy;

import static org.junit.Assert.*;

import org.junit.Test;

public class LoseATurnSectorTest {

	@Test
	public void testLoseATurnSectorName() {
		LoseATurnSector testLoseATurn = new LoseATurnSector();
		assertEquals(testLoseATurn.Name,"Lose A Turn");
	}

}
