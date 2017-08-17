package wheelOfJeopardy;

public class OpponentsChoiceSector extends WheelSector
{
	// Instance Variables
	private Player Opponent;

	public OpponentsChoiceSector( )
	{
		super("Opponents Choice" );
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
