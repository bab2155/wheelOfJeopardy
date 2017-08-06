package wheelOfJeopardy;

import java.util.Random;

public class Wheel {
	private final WheelSector[] WheelSectors;
	
	public Wheel(String[] theCategories){
		
		WheelSector theWheelSectors[] = new WheelSector[12];
		theWheelSectors[0] = new CategorySector(theCategories[0]);
		theWheelSectors[1] = new CategorySector(theCategories[1]);
		theWheelSectors[2] = new CategorySector(theCategories[2]);
		theWheelSectors[3] = new CategorySector(theCategories[3]);
		theWheelSectors[4] = new CategorySector(theCategories[4]);
		theWheelSectors[5] = new CategorySector(theCategories[5]);
		theWheelSectors[6] = new BankruptSector();
		theWheelSectors[7] = new FreeSpinSector();
		theWheelSectors[8] = new LoseATurnSector();
		theWheelSectors[9] = new OpponentsChoiceSector();
		theWheelSectors[10] = new PlayersChoiceSector();
		theWheelSectors[11] = new SpinAgainSector();
		this.WheelSectors = theWheelSectors;
	}
	public WheelSector spin(){
		Random randomGenerator = new Random();
		int landedWheelSector = randomGenerator.nextInt(12);
		return this.WheelSectors[landedWheelSector];
	}
}
