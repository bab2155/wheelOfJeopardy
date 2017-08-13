package wheelOfJeopardy;

public class OpponentsChoiceSector extends WheelSector{

	private Player Opponent;
	public OpponentsChoiceSector(){
		super("Opponents Choice");
	}
	
        @Override
	public void performAction(Controller theController){
            this.setOpponent(theController.getOpponent());
	}
	public Player getOpponent(){
		return this.Opponent;
	}
        public void setOpponent(Player theOpponent){
            this.Opponent = theOpponent;
        }
}
