package wheelOfJeopardy;

public abstract class WheelSector {

	protected String Name;
	
	public WheelSector(String theName){
		this.Name = theName;
	}
	
	abstract void performAction(Controller theController);
}

