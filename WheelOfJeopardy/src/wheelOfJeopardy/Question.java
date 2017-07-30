package wheelOfJeopardy;

public class Question {
	
	private final String Question;
	
	private final String Answer;
	
	public Question(String theQuestionText, String theAnswerText){
		this.Question = theQuestionText;
		this.Answer = theAnswerText;
	}
	public boolean verifyAnswer(String theUserAnswer){
		return true;
	}
	public String getQuestion(){
		return this.Question;
	}

}
