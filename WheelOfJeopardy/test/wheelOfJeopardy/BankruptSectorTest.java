package wheelOfJeopardy;

import static org.junit.Assert.*;

import org.junit.Test;
import wheelOfJeopardy.BankruptSector;

public class BankruptSectorTest {

	@Test
	public void testBankruptSectorName() {
		BankruptSector testBankrupt = new BankruptSector();
		assertEquals(testBankrupt.Name,"Bankrupt");
	}

}
