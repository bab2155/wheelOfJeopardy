package wheelOfJeopardy;

public class OpponentsChoiceSector extends WheelSector
{
	// Instance Variables
	private Player Opponent;

	public OpponentsChoiceSector( )
	{
		super("Opponents Choice" );
	}

	public String getName( )
	{
		return "Opponents Choice";
	}
	
    @Override
	public void performAction( Controller theController )
	{
            this.setOpponent( theController.getOpponent( ) );
	}

	public Player getOpponent( )
	{
		return this.Opponent;
	}

    public void setOpponent( Player theOpponent )
	{
            this.Opponent = theOpponent;
	}
}
