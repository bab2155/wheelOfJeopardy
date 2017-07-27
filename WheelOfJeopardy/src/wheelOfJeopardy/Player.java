package wheelOfJeopardy;

public class Player {

	private final String Name;
	private int Score;
	private int NumberOfTokens;
	
	public Player(String thePlayerName){
		this.Name = thePlayerName;
	}
	public String getName(){
		return this.Name;
	}
	public int getScore(){
		return this.Score;
	}
	
	public void setScore(int theScore){
		this.Score = theScore;
	}
	
	public int getNumberOfTokens(){
	 return this.NumberOfTokens;
	}
	
	public void setNumberOfTokens(int theNumberOfTokens){
		this.NumberOfTokens = theNumberOfTokens;
	}
	
	public void useAToken(){
		this.NumberOfTokens = this.NumberOfTokens--;
	}
}
