package wheelOfJeopardy;

public class LoseATurnSector extends WheelSector{

	public LoseATurnSector(){
		super("Lose A Turn");
	}
	public void performAction(Controller theController){
		theController.loseATurn();
	}
}
