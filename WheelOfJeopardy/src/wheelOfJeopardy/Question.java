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
	public Question(String theQuestionText, String theAnswerText,int value){
		this.question = theQuestionText;
		this.answer = theAnswerText;
                this.value = value;
	}
	public boolean verifyAnswer(String theUserAnswer){
		return true;
	}

	public String getCategory(){
		return this.category;
	}
        public String getAnswer(){
            return this.answer;
        }
        public int getPointValue(){
            return this.value;
        }

	public String getQuestion(){
		return this.question;
	}

	public boolean getUsed(){
		return this.used;
	}

	public void setUsed(boolean status){
		this.used = status;
	}


}
