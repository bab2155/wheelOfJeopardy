package wheelOfJeopardy;

public class BankruptSector  extends WheelSector{

	public BankruptSector(){
		super("Bankrupt");
	}
        @Override
	public void performAction(Controller theController){
		theController.getScoreBoard().bankruptPlayer(theController.getCurrentPlayer());
	}

}
