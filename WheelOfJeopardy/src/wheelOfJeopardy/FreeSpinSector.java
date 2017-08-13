package wheelOfJeopardy;

public class FreeSpinSector extends WheelSector{

	public FreeSpinSector(){
		super("Free Spin");
	}
        @Override
	public void performAction(Controller theController){
		int currentNumberOfTokens = theController.getCurrentPlayer().getNumberOfTokens();
		theController.getCurrentPlayer().setNumberOfTokens(++currentNumberOfTokens);
	}

}
