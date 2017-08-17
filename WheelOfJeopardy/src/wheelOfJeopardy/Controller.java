package wheelOfJeopardy;

import java.util.Arrays;
import java.util.Random;

public class Controller
{
	// Instance variables
        private QuestionBoard[] QuestionBoards = new QuestionBoard[2];
	private Player[] Players = new Player[3];
	private int CurrentPlayerNumber;
	private ScoreBoard[] ScoreBoards = new ScoreBoard[2];
	private TimeKeeper TimeKeeper;
	private Wheel Wheel;
	private int RoundNumber;
	private String DatabaseName;
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
	
		this.ScoreBoards[0] = new ScoreBoard(this.Players[0],this.Players[1],this.Players[2]);
		this.ScoreBoards[1] = new ScoreBoard(this.Players[0],this.Players[1],this.Players[2]);
                
		this.DatabaseName = theDatabaseName;
    }
    
    public Controller(){
        this.DatabaseName = "";
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
        this.ScoreBoards[0] = new ScoreBoard(this.Players[0],this.Players[1],this.Players[2]);
        this.ScoreBoards[1] = new ScoreBoard(new Player(this.Players[0].getName()),new Player(this.Players[1].getName()),new Player(this.Players[2].getName()));
    }
    
    public void setDatabaseName(String theDatabaseName){
        this.DatabaseName = theDatabaseName;
    }
    /**
     * start the game
     */
    public void startGame()
    {
		this.RoundNumber = 1;
                
                this.DatabaseName = "questions.json";
		
		//this.createQuestionBoards();
		
		//this.Wheel = new Wheel(this.QuestionBoards[this.RoundNumber-1].getAllCategories());
		
                String[] categories = new String[6];
                categories[0] = "American History";
                categories[1] = "Single-Named Singers";
                categories[2] = "Science";
                categories[3] = "Literature";
                categories[4] = "Business";
                categories[5] = "Movies";
                this.Wheel = new Wheel(categories);
		//Pick current player randomly
		Random randomGenerator = new Random();
		this.CurrentPlayerNumber = randomGenerator.nextInt(3);
    }

    /**
     * stop the game and declare the winner
     * @return 
     */
    public Player stopGame()
    {
        this.Players[0].setScore(this.getScoreBoard().getPlayerNumber(1).getScore() + this.Players[0].getScore());
        this.Players[1].setScore(this.getScoreBoard().getPlayerNumber(2).getScore() + this.Players[1].getScore());
        this.Players[2].setScore(this.getScoreBoard().getPlayerNumber(3).getScore() + this.Players[2].getScore());
        Player theWinner = this.Players[0];
	for (int playerIndex = 1; playerIndex < this.Players.length; playerIndex++){
            if (this.Players[playerIndex].getScore() > theWinner.getScore()){
                theWinner = this.Players[playerIndex];
            }
        }
        return theWinner;
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
	
        String[] categories = new String[6];
        categories[0] = "Criminal Behavior";
        categories[1] = "Board Games";
        categories[2] = "Pop Culture";
        categories[3] = "Palindromes";
        categories[4] = "Geography";
        categories[5] = "Botany";  
        this.Wheel = new Wheel(categories);
        
	//this.Wheel = new Wheel(this.QuestionBoards[this.RoundNumber-1].getAllCategories());
        
    }
    
    /**
     * returns the current state of scoreboard
     *
     * @return Scoreboard
     */
    public ScoreBoard getScoreBoard( )
    {
	return this.ScoreBoards[this.RoundNumber-1];
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
    public Question getQuestionForCategory( String theCategory, int thePointValue )
    {   Question theQuestion = this.getQuestionBoard().getQuestionForCategory(theCategory,thePointValue);
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
		String theActualDatabaseNames[] = DatabaseManager.getDatabaseNames();
		if (Arrays.asList(theActualDatabaseNames).contains(this.DatabaseName)){
                     this.QuestionBoards = DatabaseManager.createQuestionBoards(DatabaseName);
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
