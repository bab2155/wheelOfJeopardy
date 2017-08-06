package wheelOfJeopardy;

public class OpponentsChoiceSector extends WheelSector{

	private Player Opponent;
	public OpponentsChoiceSector(){
		super("Opponents Choice");
	}
	
	public void performAction(Controller theController){
		
	}
	private void getOpponent(){
		this.Opponent = new Player("");
	}
}
