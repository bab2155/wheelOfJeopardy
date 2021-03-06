package wheelOfJeopardy;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Controller
{
	// Instance variables
  public QuestionBoard[] QuestionBoards = new QuestionBoard[2];
	private Player[] Players = new Player[3];
	private int CurrentPlayerNumber;
	private ScoreBoard ScoreBoard;
	private TimeKeeper TimeKeeper;
	private Wheel Wheel;
	private int RoundNumber;
	private String DatabaseName;
        private int[] firstRoundScores = new int[3];
	public URL testme;
	//need to add View as an attribute

    /**
     * constructor
     *
     * @param theFirstPlayerName name of the first player
     * @param theSecondPlayerName name of the second player
     * @param theThirdPlayerName name of the third player
     * @param theDatabaseName name of the database
     */
    public Controller(String theFirstPlayerName, String theSecondPlayerName, String theThirdPlayerName,String theDatabaseName)
    {
		this.Players[0] = new Player(theFirstPlayerName);
		this.Players[1] = new Player(theSecondPlayerName);
		this.Players[2] = new Player(theThirdPlayerName);
	
		this.ScoreBoard = new ScoreBoard(this.Players[0],this.Players[1],this.Players[2]);
                
		this.DatabaseName = theDatabaseName;
    }
    
    public Controller(){
        

    }
    
    public void setPlayer1(String theFirstPlayerName){
        this.Players[0] = new Player(theFirstPlayerName);
    }

    
    public void setPlayer2(String theSecondPlayerName){
        this.Players[1] = new Player(theSecondPlayerName);
    }
    
    public void setPlayer3(String theThirdPlayerName){
        this.Players[2] = new Player(theThirdPlayerName);
    }
    
    public void setupScoreBoards(){
        this.ScoreBoard = new ScoreBoard(this.Players[0],this.Players[1],this.Players[2]);
    }
    
    
    public String[] getDatabaseNames(){
        return DatabaseManager.getDatabaseNames();
    }
    
    public void setDatabaseName(String theDatabaseName){
        this.DatabaseName = theDatabaseName;
    }
    /**
     * start the game
     */
    public void startGame() throws Exception
    {
                if (this.DatabaseName == null){
                    throw new Exception("No database is selected");
                }
		this.RoundNumber = 1;
                
                createQuestionBoards();
	
                this.Wheel = new Wheel(this.getQuestionBoard().getAllCategories());
		//Pick current player randomly
		Random randomGenerator = new Random();
		this.CurrentPlayerNumber = randomGenerator.nextInt(3);
    }

    /**
     * stop the game and declare the winner
     * @return 
     */
    public List<Player> stopGame()
    {
        this.Players[0].setScore(this.firstRoundScores[0] + this.Players[0].getScore());
        this.Players[1].setScore(this.firstRoundScores[1] + this.Players[1].getScore());
        this.Players[2].setScore(this.firstRoundScores[2] + this.Players[2].getScore());
        List<Player> theWinners = new ArrayList<Player>();
        theWinners.add(this.Players[0]);
        for (int playerIndex = 1; playerIndex < this.Players.length; playerIndex++){
            int previousScore = theWinners.get(0).getScore();
            if (this.Players[playerIndex].getScore() > previousScore){
                for (int idx2 = 0; idx2 < theWinners.size(); idx2++){
                    theWinners.remove(idx2);
                }
                theWinners.add(this.Players[playerIndex]);
            }
            else if (this.Players[playerIndex].getScore() == previousScore){
                theWinners.add(this.Players[playerIndex]);
            }
        }
        
        return theWinners;
    }

    
    public QuestionBoard getQuestionBoard(){
        return this.QuestionBoards[this.RoundNumber-1];
    }
    
    public int getRoundNumber(){
        return this.RoundNumber;
    }
    /**
     * continues the game to round 2
     */
    public void startRound2()
    {
        this.RoundNumber = 2;
	
        this.Wheel = new Wheel(this.getQuestionBoard().getAllCategories());
        
        this.firstRoundScores[0] = this.Players[0].getScore();
        this.firstRoundScores[1] = this.Players[1].getScore();
        this.firstRoundScores[2] = this.Players[2].getScore();
        
        this.Players[0].setScore(0);
        this.Players[1].setScore(0);
        this.Players[2].setScore(0);
        
        this.ScoreBoard.setRoundCount(50);
        
	//this.Wheel = new Wheel(this.QuestionBoards[this.RoundNumber-1].getAllCategories());
        
    }
    
    /**
     * returns the current state of scoreboard
     *
     * @return Scoreboard
     */
    public ScoreBoard getScoreBoard( )
    {
	return this.ScoreBoard;
    }

    /**
     * spins the wheel
     *
     * @return WheelSector
     */
    public WheelSector spin( )
    {
        this.getScoreBoard().decrementRoundCount();
        return this.Wheel.spin();
    }

    
    /**
     * checks the current round count
     * returns true if currentRoundCount is less than 50; otherwise false
     *
     * @return boolean
     */
    public boolean canRoundContinue( )
    {
        boolean canContinue = true;
        
        //check the current round count from the scoreboard
        int currentRoundCount = this.getScoreBoard().getRoundCount( );
        if ( currentRoundCount == 0 )
        {
            canContinue = false;
	}
        
        int maxPointValue = 0;
        if (this.RoundNumber == 1){
            maxPointValue = 1000;
        }
        else if(this.RoundNumber == 2){
            maxPointValue = 2000;
        }
        
        //Check if any questions remain for the round
        boolean areThereQuestionsLeft = false;
        String[] theCategories = this.getQuestionBoard().getAllCategories();
        for (String theCategory:theCategories){
            if (this.getQuestionBoard().getQuestionForCategory(theCategory, maxPointValue) != null){
                areThereQuestionsLeft = true;
                break;
            } 
        }
        
        if (!areThereQuestionsLeft){
            canContinue = false;
        }
        
        return canContinue;
        
        
    }

    /**
     * sets the current player to next player
     */
	public void loseATurn( )
	{
		this.setCurrentPlayer( );
	}

    /**
     * gets the next question for a given category
     *
     * @param theCategory the current category
     * @param thePointValue
     * @return Question
     */
    public Question getQuestionForCategory( String theCategory)
    {   
        int multiplier = 100;
        if (this.RoundNumber == 2){
            multiplier = 200;
        }
       
        Question theQuestion = null;
        for (int idx = 1 * multiplier; idx < 6 * multiplier; idx++){
            Question tmpQuestion = this.getQuestionBoard().getQuestionForCategory(theCategory,idx);
            if (tmpQuestion != null){
                theQuestion = tmpQuestion;
                break;
            }
        }
        
        return theQuestion;
    }

    /**
     * returns the current player
     *
     * @return Player
     */
    public Player getCurrentPlayer( )
    {
	return this.Players[ this.CurrentPlayerNumber ];
    }

    /**
     * sets the current player to next player
     */
	private void setCurrentPlayer()
	{
		if ( this.CurrentPlayerNumber < this.Players.length-1 )
		{
			this.CurrentPlayerNumber = this.CurrentPlayerNumber + 1;
		}
		else
		{
			this.CurrentPlayerNumber = 0;
		}
	}

    /**
     * allows a player to use a token
     */
	public void useTokenForCurrentPlayer( )
    {
		this.getScoreBoard().useTokenForPlayer( this.getCurrentPlayer( ) );
	}
	public void createQuestionBoards(){
	  this.QuestionBoards = DatabaseManager.createQuestionBoards(this.DatabaseName);
//		String theActualDatabaseNames[] = DatabaseManager.getDatabaseNames();
//		if (Arrays.asList(theActualDatabaseNames).contains(this.DatabaseName)){
//                     this.QuestionBoards = DatabaseManager.createQuestionBoards(DatabaseName);
//		}
	}

    /**
     * randomly chooses an opposing player
     *
     * @return Player
     */
    public Player getOpponent( )
    {
        //Pick current player randomly
        Random randomGenerator = new Random( );
        int theOpponentNumber = this.CurrentPlayerNumber;
        while( theOpponentNumber == this.CurrentPlayerNumber )
        {
            theOpponentNumber = randomGenerator.nextInt(3);
        }
        return this.Players[theOpponentNumber];
    }
    
    /**
     * adds a token for the current player
     */
      public void addTokenForCurrentPlayer(){
         this.getScoreBoard().incrementTokensForPlayer(this.getCurrentPlayer());
      }
      
      /**
       * adds the points for the last question for the current player
       */
      public void addPointsForCurrentPlayer(int theNumberOfPoints){
        this.getScoreBoard().addPointsForPlayer(this.getCurrentPlayer(), theNumberOfPoints);
      }
      
      /**
       * subtracts the points for the last question for the current player
       */
      public void subtractPointsForCurrentPlayer(int theNumberOfPoints){
        this.getScoreBoard().subtractPointsForPlayer(this.getCurrentPlayer(),theNumberOfPoints);
      }
       
      public void bankruptCurrentPlayer(){
          this.getScoreBoard().bankruptPlayer(this.getCurrentPlayer());
      }

      public Player getPlayerNumber(int thePlayerNumber){
          return this.Players[thePlayerNumber -1];
      }
}
