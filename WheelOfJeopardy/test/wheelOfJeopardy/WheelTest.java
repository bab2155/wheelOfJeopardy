package wheelOfJeopardy;

import static org.junit.Assert.*;

import org.junit.Test;
import wheelOfJeopardy.Wheel;
import wheelOfJeopardy.WheelSector;

public class WheelTest {

	@Test
	public void testWheelReturnsSector() {
		String categories[] = new String[6];
		categories[0] = "Category0";
		categories[1] = "Category1";
		categories[2] = "Category2";
		categories[3] = "Category3";
		categories[4] = "Category4";
		categories[5] = "Category5";
		Wheel wheelTest = new Wheel(categories);
		assertTrue(wheelTest.spin() instanceof WheelSector);
	}

}
