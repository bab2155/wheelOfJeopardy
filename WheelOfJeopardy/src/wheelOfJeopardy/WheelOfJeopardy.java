/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheelOfJeopardy;

import java.util.HashSet;
import java.util.Set;
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
        
        wheelofJeopardyDC.launchGame();
        
        
        
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }
    
}
