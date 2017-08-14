package wheelOfJeopardy;

public class ScoreBoard {

	private final Player Player1;
	private final Player Player2;
	private final Player Player3;
	private int RoundCount;
	
	public ScoreBoard(Player firstPlayer, Player secondPlayer, Player thirdPlayer){
		this.Player1 = firstPlayer;
		this.Player2 = secondPlayer;
		this.Player3 = thirdPlayer;
	}
	public void addPointsForPlayer(Player thePlayer, int numberOfPoints){
		
	}
	public Player getPlayerNumber(int playerNumber){
		return this.Player1;
	}
	public void decrementRoundCount(){
		--this.RoundCount;
	}
	public int getRoundCount(){
		return this.RoundCount;
	}
	public void bankruptPlayer(Player thePlayer){
		
	}
	public void useTokenForPlayer(Player thePlayer){
		
	}
	public void subtractPointsForPlayer(Player thePlayer, int theNumberOfPoints){
		
	}
	public void incrementTokensForPlayer(Player thePlayer){
		
	}
}
