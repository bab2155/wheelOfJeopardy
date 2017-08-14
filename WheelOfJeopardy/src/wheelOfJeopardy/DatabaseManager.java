package wheelOfJeopardy;

public class DatabaseManager {
	
	public static boolean validateDatabaseName(String theDatabaseName){
		return false;
	}
	public static QuestionBoard createQuestionBoardForRound(String theDatabaseName, int theRoundNumber){
		
		Question[] fakeQuestion = {new Question("bar","baz",100), new Question("tango","paris",200)};
		String[] fakeCategory = {"foo","foxtrot"};
		QuestionBoard theQuestionBoard = new QuestionBoard(fakeCategory,fakeQuestion);
		return theQuestionBoard;
	}
	public static String[] getDatabaseNames(){
		String[] fakeDatabaseNames = {"FakeDatabase1","FakeDatabase2"};
		return fakeDatabaseNames;
	}

}
