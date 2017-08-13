package wheelOfJeopardy;

public class Question {
	
	public String category;
	public String question;
	public String answer;
	public int value;
	public boolean used;

	/* private final String Question;
	
	private final String Answer;
	*/
	public Question(String theQuestionText, String theAnswerText){
		this.question = theQuestionText;
		this.answer = theAnswerText;
	}
	public boolean verifyAnswer(String theUserAnswer){
		return true;
	}

	public String getCategory(){
		return this.category;
	}

	public String getQuestion(){
		return this.question;
	}

	public String getAnswer(){
		return this.answer;
	}

	public int getValue(){
		return this.value;
	}

	public boolean getUsed(){
		return this.used;
	}

	public void setUsed(boolean status){
		this.used = status;
	}


}
