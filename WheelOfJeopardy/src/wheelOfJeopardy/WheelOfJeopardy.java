/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheelofjeopardy;

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
        //Parent root = FXMLLoader.load(getClass().getResource("WheelofJeopardy.fxml"));
        //Set up instance instead of using static load() method
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("WheelofJeopardy.fxml"));
        Parent root = loader.load();
        
        wheelofJeopardyDC = (WheelofJeopardyDocumentController)loader.getController();
        wheelofJeopardyDC.setGamePlayVisible(true);
        String player = "Anakin";
        wheelofJeopardyDC.populateLoseTurn(player);
        
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
