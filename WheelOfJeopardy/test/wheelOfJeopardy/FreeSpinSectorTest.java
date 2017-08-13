package wheelOfJeopardy;

import static org.junit.Assert.*;

import org.junit.Test;
import wheelOfJeopardy.FreeSpinSector;

public class FreeSpinSectorTest {

	@Test
	public void testFreeSpinName() {
		FreeSpinSector testFreeSpin = new FreeSpinSector();
		assertEquals(testFreeSpin.Name,"Free Spin");
	}

}
