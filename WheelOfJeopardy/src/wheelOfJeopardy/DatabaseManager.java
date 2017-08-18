package wheelOfJeopardy;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.util.*;

import com.google.gson.stream.JsonReader;

public class DatabaseManager {

	String dbName;
	String dbPath;
	String databaseDir = "./src/assets/database/";
	Question[] gameQuestions;
	String[] round1Categories;
	String[] round2Categories;
	private int[][] questionValues = {{100, 200, 300, 400, 500},{200,400,600,800,1000}};


	public DatabaseManager(String theDatabaseName){
		dbName = theDatabaseName;
		dbPath = databaseDir + dbName;
		gameQuestions = getAllDatabaseQuestions(dbPath);
	}

	/**
	 * Ensures name of database exists in database folder
	 * @return (boolean) if it exists
	 */
	public boolean validateDatabaseName(){

		File f = new File(dbPath);

		if(f.exists()){
			return true;
		}
		return false;
	}

	private static Question[] getAllDatabaseQuestions(String databaseName){
		/* Load all questions from given database and store */

		/** get 12 random categories
		 * Get 5 questions from each category
		 * Question should correspond to each point value
		 * Pick random categories for each round
		 */

		Question[] questions = null;

		try{
			JsonReader jr = new JsonReader(new FileReader("./src/assets/database/" +databaseName));
			questions = new Gson().fromJson(jr, Question[].class);

		} catch (Exception e){
			e.printStackTrace();
		}

		return questions;
	}

	/**
	 * Defines the categories for each round
	 */
	private static String[][] setRoundCategories(Question[] theQuestions){

		String[][] categories = new String[2][6];
		HashSet<String> categorySet = new HashSet<String>();

		for(Question question : theQuestions){
			categorySet.add(question.category);
		}

		List<String> allcat = new ArrayList<String>(categorySet);
		Collections.shuffle(allcat);


		//TODO: ensure there are at least 12 categories

		int i,j;
		for(int x=0; x<12; x++){

			if(x<=5){i=0; j=x;}
			else{i=1; j=x-6;}

			categories[i][j] = allcat.get(x);
		}

		return categories;

	}

	private static List<HashMap<String, ArrayList<Question>>> getCategoryQuestions(String[][] theRoundCategories,Question[] theQuestions){

		Integer round1values[] = {100, 200, 300, 400, 500};
		Integer round2values[] = {200, 400, 600, 800, 1000};

		List<List<Integer>> questionValues = new ArrayList<>();
		questionValues.add(0, Arrays.asList(round1values));
		questionValues.add(1, Arrays.asList(round2values));

		// Initialize list of HashMaps for category questions for each round
		List<HashMap<String, ArrayList<Question>>> categoryQuestions = new ArrayList<HashMap<String,
				ArrayList<Question>>>();

		// Initialize categories in HashMap
		for(int i=0; i<=1; i++){
			for(String category : theRoundCategories[i]){
				categoryQuestions.get(i).put(category, new ArrayList<Question>());
			}
		}

		for(int i=0; i<=1; i++) {
			HashMap<String, ArrayList<Question>> allQuestions = new HashMap<String, ArrayList<Question>>();


			for (Question question : theQuestions) {

				// See if current question category exists in round categories
				if (categoryQuestions.get(i).containsKey(question.category)) {
					allQuestions.get(question.category).add(question);
				}
			}

			// Shuffle all questions
			for (String category : theRoundCategories[i]) {
				Collections.shuffle(allQuestions.get(category));

				for (Integer roundvalue : questionValues.get(i)) {
					Question toAdd = allQuestions.get(category).stream().filter(question -> question.value == roundvalue)
							.findFirst()
							.get();
					categoryQuestions.get(i).get(category).add(toAdd);
				}

			}
		}


		return categoryQuestions;

	}

	/**
	 * Creates question board from database
	 * @param theRoundNumber
	 * @return
	 */
	public static QuestionBoard[] createQuestionBoards(String theDatabaseName){

		Question[] dbQuestions = getAllDatabaseQuestions(theDatabaseName);
		String[][] roundCategories = setRoundCategories(dbQuestions);
		List<HashMap<String, ArrayList<Question>>> categoryQuestions = getCategoryQuestions(roundCategories, dbQuestions);

		List<QuestionBoard> tmp = new ArrayList<>();

		for(HashMap<String, ArrayList<Question>> hm : categoryQuestions){
			QuestionBoard qb = new QuestionBoard(hm);
			tmp.add(qb);
		}

		QuestionBoard[] gameQuestionBoards = tmp.toArray(new QuestionBoard[2]);

		return gameQuestionBoards;

	}
	public static String[] getDatabaseNames(){

		/* Get all files from db directory */
//		File dbStore = new File(this.databaseDir);
		File dbStore = new File("./src/assets/database/");
                System.out.println(dbStore.getAbsolutePath());
		File[] files = dbStore.listFiles();
		List<String> filenames = new ArrayList<String>();

		for(File file: files){
				filenames.add(file.getName());
		}
		String[] databaseNames = new String[filenames.size()];
		filenames.toArray(databaseNames);

		return databaseNames;

	}

}
