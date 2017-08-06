package wheelOfJeopardy;

import java.util.Arrays;

public class Controller {
	private QuestionBoard QuestionBoard;
	private Player[] Players;
	private Player CurrentPlayer;
	private ScoreBoard ScoreBoard;
	private TimeKeeper TimeKeeper;
	private Wheel Wheel;
	private int RoundNumber;
	//need to add View as an attribute
	
	public void startGame(){
		this.RoundNumber = 1;
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
	public void createQuestionBoardFromDatabase(String theUserDatabaseName){
		String theActualDatabaseNames[] = DatabaseManager.getDatabaseNames();
		if (Arrays.asList(theActualDatabaseNames).contains(theUserDatabaseName)){
			this.QuestionBoard = DatabaseManager.createQuestionBoardForRound(theUserDatabaseName,this.RoundNumber);
		}
	}

}
