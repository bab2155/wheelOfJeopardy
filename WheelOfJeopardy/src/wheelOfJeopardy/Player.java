package wheelOfJeopardy;
import javax.swing.JOptionPane;

public class Player {

	private final String Name;
	private int Score = 0;
	private int NumberOfTokens = 0;

	public Player(String thePlayerName) {
		this.Name = thePlayerName;
	}

	public String getName() {
		return this.Name;
	}

	public int getScore() {
		return this.Score;
	}

	public void setScore(int theScore) {
		//when ScoreBoard adds or subtracts points, it should store the final result here
		this.Score = theScore;
	}

	public int getNumberOfTokens() {
		return this.NumberOfTokens;
	}

	public void setNumberOfTokens(int theNumberOfTokens) {
		//when ScoreBoard adds or subtracts tokens, it should store the final result here
		this.NumberOfTokens = theNumberOfTokens;
	}

	public void useAToken() {
		if (this.NumberOfTokens > 0) {
			this.NumberOfTokens = this.NumberOfTokens--;
			//Controller allows for another turn
			
		} else {//no tokens to use
			//display error to user
			Player.infoBox("You do not have enough tokens", "TOKEN ERROR");
			//goto next player
			
		}
	}

	public static void infoBox(String infoMessage, String titleBar) {
		JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
	}
}