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
                this.RoundCount = 50;
	}
	public void addPointsForPlayer(Player thePlayer, int numberOfPoints){
		thePlayer.setScore(thePlayer.getScore() + numberOfPoints);
		
	}
	public Player getPlayerNumber(int playerNumber){

		switch (playerNumber){
			case 1: return this.Player1;
			case 2: return this.Player2;
			case 3: return this.Player3;
		}
		return null;
	}

	public void decrementRoundCount(){
		--this.RoundCount;
	}
	public int getRoundCount(){
		return this.RoundCount;
	}
	public void bankruptPlayer(Player thePlayer){
		thePlayer.setScore(0);
	}

	public void useTokenForPlayer(Player thePlayer){
		thePlayer.useAToken();
	}

	public void subtractPointsForPlayer(Player thePlayer, int points){
		thePlayer.setScore(thePlayer.getScore() - points);
	}
	public void incrementTokensForPlayer(Player thePlayer){
		thePlayer.setNumberOfTokens(thePlayer.getNumberOfTokens() + 1);
	}
}
