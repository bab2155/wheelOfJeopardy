package wheelOfJeopardy;

public class Question {
	
	private final String Question;
	private final int  PointValue;
	private final String Answer;
	
	public Question(String theQuestionText, String theAnswerText, int thePointValue){
		this.Question = theQuestionText;
		this.Answer = theAnswerText;
                this.PointValue = thePointValue;
	}
	public boolean verifyAnswer(String theUserAnswer){
		return true;
	}
	public String getQuestion(){
		return this.Question;
	}
        public String getAnswer(){
            return this.Answer;
        }
        public int getPointValue(){
            return this.PointValue;
        }

}
