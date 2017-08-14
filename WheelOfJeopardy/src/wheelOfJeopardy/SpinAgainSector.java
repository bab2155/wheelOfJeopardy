package wheelOfJeopardy;

public class  SpinAgainSector extends WheelSector
{
	/**
	 * constructor
	 */
	public SpinAgainSector( )
	{
		super("Spin Again" );
	}

	/**
	 * returns the name of the sector
	 *
	 * @return String
	 */
	public String getName( )
	{
		return "Spin Again";
	}

	/**
	 * spins the wheel again and generates a new result
	 * @param theController current game state
	 */
	@Override
	public void performAction( Controller theController )
	{
		theController.spin( );
	}
}
