package wheelOfJeopardy;

public class  SpinAgainSector extends WheelSector{

	public SpinAgainSector(){
		super("Spin Again");
	}
	public void performAction(Controller theController){
		theController.spin();
	}

}
