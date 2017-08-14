package wheelOfJeopardy;

public class BankruptSector extends WheelSector
{

	/**
     * constructor
	 */
    public BankruptSector( )
	{
		super("Bankrupt");
	}

    /**
     * returns the name of the sector
     * @return a String
     */
	public String getName( )
    {
        return "Bankrupt";
    }

    /**
     * sets the score of current player to zero
     *
     * @param theController current game state
     */
    @Override
	public void performAction(Controller theController)
    {
        theController.getCurrentPlayer( ).setScore( 0 );
	}

}
