package wheelOfJeopardy;

public class Controller {
	private QuestionBoard QuestionBoard;
	private Player[] Players;
	private Player CurrentPlayer;
	private ScoreBoard ScoreBoard;
	private TimeKeeper TimeKeeper;
	private Wheel Wheel;
	//need to add View as an attribute
	
	public void startGame(){
		
	}
	public void stopGame(){
		
	}
	public void spin(){
		
	}
	public void loseATurn(){
		
	}
	public Question getQuestionForCategory(String theCategory){
		return this.QuestionBoard.getQuestionForCategory(theCategory);
	}
	public void getPlayersChoice(){
		
	}
	public void getOpponentsChoiceFrom(Player theOpponent){
		
	}
	public Player getCurrentPlayer(){
		return this.CurrentPlayer;
	}
	public void useTokenForCurrentPlayer(){
		
	}

}
