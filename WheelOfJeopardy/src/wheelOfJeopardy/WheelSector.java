package wheelOfJeopardy;

public abstract class WheelSector
{
	// Instance variables
	public String name;

	/**
	 * default constructor
	 */
	public WheelSector( )
	{
		this.name = "";
	}

	/**
	 * overloaded constructor
	 *
	 * @param theName name of the category
	 */
	public WheelSector( String theName )
	{
		this.name = theName;
	}

	/**
	 * returns the name of the sector
	 *
	 * @return name - the name of the sector
	 */
	abstract String getName( );

	/**
	 *
	 * @param theController current game state
	 */
	abstract void performAction( Controller theController );
}

