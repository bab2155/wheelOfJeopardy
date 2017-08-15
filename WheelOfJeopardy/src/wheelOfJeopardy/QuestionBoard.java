package wheelOfJeopardy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class QuestionBoard {
	
	private final String[] Categories;
	private Question[][] Questions;
	private HashMap<String, ArrayList<Question>> categoryQuestions;

	public QuestionBoard(HashMap<String, ArrayList<Question>> theCategoryQuestions){
		categoryQuestions = theCategoryQuestions;
		Categories = categoryQuestions.keySet().toArray(new String[categoryQuestions.keySet().toArray().length]);
		Questions = parseQuestions(categoryQuestions, Categories);

	}

	private Question[][] parseQuestions(HashMap<String, ArrayList<Question>> theCategoryQuestions,
																			String[] theCategories){

		Question[][] questions = new Question[6][5];

		for(int i=0;i<=5; i++){
			questions[i] = theCategoryQuestions.get(theCategories[i]).toArray(new Question[5]);
		}

		return questions;
	}


	/**
	 * Sets question used value to true
	 * @param theQuestion
	 */
	public void removeQuestion(Question theQuestion){
		theQuestion.setUsed(true);
	}


	/**
	 * Gets question from a given category and given point value
	 * @param theCategory: category
	 * @param thePointValue: point value
	 * @return corresponding question (Question)
	 */
	public Question getQuestionForCategory(String theCategory, int thePointValue){


		ArrayList<Question> allQuestions = this.categoryQuestions.get(theCategory);

		for(Question question : allQuestions){
			if(question.value == thePointValue && !question.getUsed()){
				return(question);
			}
		}

		/* If no more questions are left in the category, return null */
		return(null);
	}

	/**
	 * Gets all categories
	 * @return all categories
	 */
	public String[] getAllCategories(){
		return this.Categories;
	}
	public int[][] getDisplayMatrix(){
		
		int[][] displayMatrix = new int [6][5];
		return displayMatrix;
		
	}

	public void displayQuestion(Question theQuestion){

	}
}
