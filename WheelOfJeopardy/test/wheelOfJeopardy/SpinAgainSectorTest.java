package wheelOfJeopardy;

import static org.junit.Assert.*;

import org.junit.Test;
import wheelOfJeopardy.SpinAgainSector;

public class SpinAgainSectorTest {

	@Test
	public void testSpinAgainSector() {
		SpinAgainSector testSpinAgainSector = new SpinAgainSector();
		assertEquals(testSpinAgainSector.Name,"Spin Again");
	}

}
