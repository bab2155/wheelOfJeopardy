package wheelOfJeopardy;

public class QuestionBoard {
	
	private final String[] Categories;
	private Question[] Questions;
	
	public QuestionBoard(String[] theCategories, Question[] theQuestions){
		this.Categories = theCategories;
		this.Questions = theQuestions;
	}
	public void removeQuestion(Question theQuestion){
		
	}
	public void displayQuestion(Question theQuestion){
		
	}
	public Question getQuestionForCategory(String theCategory){
		return this.Questions[0];
	}
	public String[] getAllCategories(){
		return this.Categories;
	}
	public int[][] getDisplayMatrix(){
		
		int[][] displayMatrix = new int [6][5];
		return displayMatrix;
		
	}
}
