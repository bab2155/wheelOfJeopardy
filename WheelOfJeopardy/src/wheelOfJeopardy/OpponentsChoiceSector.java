package wheelOfJeopardy;

public class OpponentsChoiceSector extends WheelSector{

	private Player Opponent;
	public OpponentsChoiceSector(String theName){
		super(theName);
	}
	
	public void performAction(Controller theController){
		
	}
	private void getOpponent(){
		this.Opponent = new Player("");
	}
}
