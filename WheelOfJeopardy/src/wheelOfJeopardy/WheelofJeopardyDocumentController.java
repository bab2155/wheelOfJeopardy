/*
 * Wheel of Jeopardy Game
 * 
 * 
 */
package wheelOfJeopardy;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author Heather
 */
public class WheelofJeopardyDocumentController implements Initializable {
    
    @FXML
    private Label label;
    private Label title;
    private Label spin_counter;
    private Label game_timer;
    private Label spin_label;
    private Label round_label;
    private Label round_value;
    private Label game_timer_label;
    private Label player1_label;
    private Label player2_label;
    private Label player3_label;
    private Label token_label;
    private Label scores_label;
    private Label player_identifier;
    private Label question;
    private Label category;
    private Label player_answer_label;
    private Label question_value_label;
    private Label correct_answer_label;
    private Label category_title;
    private Label question_content;
    private Label question_value;
    
    @FXML
    private Button player_submit_button;
    private Button correct_override_submit_button;
    private Button incorrect_override_button;
    private Button spin_wheel_button;
    
    @FXML
    private TextField player1_score;
    private TextField player2_score;
    private TextField player3_score;
    private TextField player1_tokens;
    private TextField player2_tokens;
    private TextField player3_tokens;
    private TextField player_answer;
    private TextField correct_answer;
    
    @FXML
    private TableView category_table;
    private TableColumn category1;
    private TableColumn category2;
    private TableColumn category3;
    private TableColumn category4;
    private TableColumn category5;
    private TableColumn category6;
    
    @FXML
    private AnchorPane game_play;
    private AnchorPane game_stats;
    private AnchorPane player_stats;
    
    @FXML
    private Pane footer;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
