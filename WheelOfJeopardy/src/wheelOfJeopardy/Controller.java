package wheelOfJeopardy;

import java.util.Arrays;
import java.util.Random;

public class Controller
{
	// Instance variables
        private QuestionBoard QuestionBoard;
	private Player[] Players;
	private int CurrentPlayerNumber;
	private final ScoreBoard ScoreBoard;
	private TimeKeeper TimeKeeper;
	private Wheel Wheel;
	private int RoundNumber;
	private final String DatabaseName;
        private Question LastQuestion;
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

    /**
     * start the game
     */
    public void startGame()
    {
		this.RoundNumber = 1;
		
		this.createQuestionBoard();
		
		this.Wheel = new Wheel(this.QuestionBoard.getAllCategories());
		
		//Pick current player randomly
		Random randomGenerator = new Random();
		this.CurrentPlayerNumber = randomGenerator.nextInt(3);
	}

    /**
     * stop the game
     */
    public void stopGame()
    {
		//
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
        this.ScoreBoard.decrementRoundCount();
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
        boolean canContinue = false;
        int currentRoundCount = this.ScoreBoard.getRoundCount( );
		if ( currentRoundCount < 50 )
		{
			canContinue = true;
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
     * @return Question
     */
    public Question getQuestionForCategory( String theCategory )
    {   Question theQuestion = this.QuestionBoard.getQuestionForCategory(theCategory);
        this.LastQuestion = theQuestion;
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
		this.ScoreBoard.useTokenForPlayer( this.getCurrentPlayer( ) );
	}

    /**
     * creates the QuestionBoard
     */
    public void createQuestionBoard( )
    {
		String theActualDatabaseNames[ ] = DatabaseManager.getDatabaseNames( );
		if ( Arrays.asList( theActualDatabaseNames ).contains( this.DatabaseName ) )
		{
			this.QuestionBoard = DatabaseManager.createQuestionBoardForRound( this.DatabaseName,this.RoundNumber );
		}
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
        int theOpponentNumber = -1;
        while( theOpponentNumber == this.CurrentPlayerNumber )
        {
            theOpponentNumber = randomGenerator.nextInt(3 );
        }
        return this.Players[ theOpponentNumber ];
    }
    
    /**
     * adds a token for the current player
     */
      public void addTokenForCurrentPlayer(){
         this.ScoreBoard.incrementTokensForPlayer(this.getCurrentPlayer());
      }
      
      /**
       * adds the points for the last question for the current player
       */
      public void addLastQuestionPointsForCurrentPlayer(){
        this.ScoreBoard.addPointsForPlayer(this.getCurrentPlayer(), this.LastQuestion.getPointValue());
      }
      
      /**
       * subtracts the points for the last question for the current player
       */
      public void subtractLastQuestionPointsForCurrentPlayer(){
        this.ScoreBoard.subtractPointsForPlayer(this.getCurrentPlayer(),this.LastQuestion.getPointValue());
      }
       
      /**
       * overrides the answer validation for the current player
       * @param theOverride 
       */
      public void overrideAnswerValidationForCurrentPlayer(boolean theOverride){
        if (theOverride){
            this.addLastQuestionPointsForCurrentPlayer();
        }
        else{
            this.subtractLastQuestionPointsForCurrentPlayer();
        }
      }

}
