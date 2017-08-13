package wheelOfJeopardy;

import static org.junit.Assert.*;

import org.junit.Test;
import wheelOfJeopardy.PlayersChoiceSector;

public class PlayersChoiceSectorTest {

	@Test
	public void testPlayersChoiceName() {
		PlayersChoiceSector testPlayersChoice = new PlayersChoiceSector();
		assertEquals(testPlayersChoice.Name,"Players Choice");
	}

}
