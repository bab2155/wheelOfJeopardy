package wheelOfJeopardy;

public class PlayersChoiceSector extends WheelSector
{
	/**
	 * constructor
	 */
	public PlayersChoiceSector( )
	{
		super("Players Choice" );
	}

	/**
	 * returns name of the sector
	 *
	 * @return String
	 */
	public String getName( )
	{
		return "Players Choice";
	}

	/**
	 * player chooses a category
	 *
	 * @param theController current game state
	 */
	@Override
	public void performAction( Controller theController )
	{
		// player chooses a category from the dropdown list
	}
}
