package wheelOfJeopardy;

public class DatabaseManager {
	
	public static boolean validateDatabaseName(String theDatabaseName){
		return false;
	}
	public static QuestionBoard createQuestionBoardForRound(String theDatabaseName, int theRoundNumber){
		
		Question[] fakeQuestion = {new Question("bar","baz"), new Question("tango","paris")};
		String[] fakeCategory = {"foo","foxtrot"};
		QuestionBoard theQuestionBoard = new QuestionBoard(fakeCategory,fakeQuestion);
		return theQuestionBoard;
	}
	public static String[] getDatabaseNames(){
		String[] fakeDatabaseNames = {"FakeDatabase1","FakeDatabase2"};
		return fakeDatabaseNames;
	}

}
