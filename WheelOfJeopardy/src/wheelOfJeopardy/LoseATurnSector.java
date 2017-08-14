package wheelOfJeopardy;

public class LoseATurnSector extends WheelSector
{

	/**
	 * constructor
	 */
	public LoseATurnSector( )
	{
		super("Lose A Turn" );
	}

    /**
     * returns name of constructor
     *
     * @return String
     */
	public String getName( )
	{
		return "Lose A Turn";
	}

    /**
     * sets the current player to next player
     *
     * @param theController current game state
     */
	@Override
	public void performAction( Controller theController )
	{
		theController.loseATurn( );
	}
}
