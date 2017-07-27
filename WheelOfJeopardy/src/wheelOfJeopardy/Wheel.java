package wheelOfJeopardy;

public class Wheel {
	private final WheelSector[] WheelSectors;
	
	public Wheel(String[] theCategories){
		this.WheelSectors = new WheelSector[12];
	}
	public WheelSector spin(){
		return this.WheelSectors[0];
	}
}
