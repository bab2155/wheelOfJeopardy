package wheelOfJeopardy;

public class WheelSector
{
	// Instance variables
	public String Name;

	/**
	 * default constructor
	 */
	public WheelSector( )
	{
		this.Name = "";
	}

	/**
	 * overloaded constructor
	 *
	 * @param theName name of the category
	 */
	public WheelSector( String theName )
	{
		this.Name = theName;
	}

	/**
	 * returns the name of the sector
	 *
	 * @return name - the name of the sector
	 */
	public String getName( ){
            return this.Name;
        };

	
}

