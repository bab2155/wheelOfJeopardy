package wheelOfJeopardy;

public class FreeSpinSector extends WheelSector
{
	/**
	 * constructor
	 */
	public FreeSpinSector( )
	{
		super("Free Spin" );
	}

	/**
	 * returns the name of the sector
	 *
	 * @return String
	 */
	public String getName( )
	{
		return "Free Spin";
	}

	/**
	 * increases the number of tokens per player by one
	 *
	 * @param theController current game state
	 */
	@Override
	public void performAction( Controller theController )
	{
		int currentNumberOfTokens = theController.getCurrentPlayer( ).getNumberOfTokens( );
		theController.getCurrentPlayer( ).setNumberOfTokens(++currentNumberOfTokens);
	}
}
