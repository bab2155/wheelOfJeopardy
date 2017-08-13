package wheelOfJeopardy;

public abstract class WheelSector {

	public String Name;
	
	public WheelSector(){
		this.Name = "";
	}
	
	public WheelSector(String theName){
		this.Name = theName;
	}
	
	abstract void performAction(Controller theController);
}

