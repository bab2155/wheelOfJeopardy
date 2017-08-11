/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheelOfJeopardy;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import wheelOfJeopardy.WheelofJeopardyDocumentController;


/**
 *
 * @author Heather
 */
public class WheelOfJeopardy extends Application {
    
    static WheelofJeopardyDocumentController wheelofJeopardyDC; 
    
    @Override
    public void start(Stage stage) throws Exception {        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("WheelofJeopardy.fxml"));
        Parent root = loader.load();
        
        wheelofJeopardyDC = (WheelofJeopardyDocumentController)loader.getController();

        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
        //Initial screen should go here, probably something which will just be turned to invisible when game is launched
        //Get player names?
        wheelofJeopardyDC.setGamePlayVisible(true);
        wheelofJeopardyDC.setGameStatsVisible(true);
        wheelofJeopardyDC.setPlayerStatsVisible(true);
        
        //Round 1
        String player = "Anakin";
        String[] categories = new String[6];
        categories[0] = "American History";
        categories[1] = "Single-Named Singers";
        categories[2] = "Science";
        categories[3] = "Literature";
        categories[4] = "Business";
        categories[5] = "Movies";
        
        wheelofJeopardyDC.populateGameStats("1", categories);  
        
        //Round 2
        //wheelofJeopardyDC.populateGameStats("2", categories);  
        
        //Start game timer
        //Something for handling the wheel click/spin result?
        //Loop through 50 rounds, etc and based on random spin, call one of the following:

            //If lose turn:
            //wheelofJeopardyDC.populateLoseTurn(player);
        
            //if bankruptcy:
            //wheelofJeopardyDC.populateBankruptcy(player);
        
            //if player's choice:
            wheelofJeopardyDC.populatePlayerChoice(player, categories);
        
            //if opponent's choice:
            //String opponent
            //wheelofJeopardyDC.populateOpponentChoice(player, opponent, categories);
        
            //if spin again:
            //wheelofJeopardyDC.populateSpinAgain(player);
        
            //if free token:
            //wheelofJeopardyDC.populateFreeToken(player);
        
            //if question:
            //String categoryTitle; String questionContent; String answerContent; String pointValue;
            //wheelofJeopardyDC.populateQuestion(player, categoryTitle, questionContent, answerContent, pointValue);
            //Handle question submit button? since we are passing in the answer, I can do a string insensitive comparison in the 
            //button submit
            String category = "ASd";
            String points = "100";
            wheelofJeopardyDC.updateCategoryTable(category, points);
            
            //Use free token
            //if free token:
            //wheelofJeopardyDC.populateUseToken(player);
            
            //at some point, count spins, launch next round and continue until game end 
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
