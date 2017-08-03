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
    
    //Define all fields
    @FXML
    private Label label;
    @FXML
    private Label title;
    @FXML
    private Label spin_counter;
    @FXML
    private Label game_timer;
    @FXML
    private Label spin_label;
    @FXML
    private Label round_label;
    @FXML
    private Label round_value;
    @FXML
    private Label game_timer_label;
    @FXML
    private Label player1_label;
    @FXML
    private Label player2_label;
    @FXML
    private Label player3_label;
    @FXML
    private Label token_label;
    @FXML
    private Label scores_label;
    @FXML
    private Label player_identifier;
    @FXML
    private Label opponent_identifier;
    @FXML
    private Label question;
    @FXML
    private Label category;
    @FXML
    private Label player_answer_label;
    @FXML
    private Label question_value_label;
    @FXML
    private Label correct_answer_label;
    @FXML
    private Label category_title;
    @FXML
    private Label question_content;
    @FXML
    private Label question_value;
    
    @FXML
    private Button player_submit_button;
    @FXML
    private Button correct_override_submit_button;
    @FXML
    private Button incorrect_override_submit_button;
    @FXML
    private Button spin_wheel_button;
    
    @FXML
    private TextField player1_score;
    @FXML
    private TextField player2_score;
    @FXML
    private TextField player3_score;
    @FXML
    private TextField player1_tokens;
    @FXML
    private TextField player2_tokens;
    @FXML
    private TextField player3_tokens;
    @FXML
    private TextField player_answer;
    @FXML
    private TextField correct_answer;
    
    @FXML
    private TableView category_table;
    @FXML
    private TableColumn category1;
    @FXML
    private TableColumn category2;
    @FXML
    private TableColumn category3;
    @FXML
    private TableColumn category4;
    @FXML
    private TableColumn category5;
    @FXML
    private TableColumn category6;
    
    @FXML
    private AnchorPane game_play;
    @FXML
    private AnchorPane game_stats;
    @FXML
    private AnchorPane player_stats;
    @FXML
    private AnchorPane answer_results;
    @FXML 
    private AnchorPane sector_question;
    @FXML 
    private AnchorPane sector_bankruptcy;
    @FXML 
    private AnchorPane sector_lose_turn;
    @FXML 
    private AnchorPane sector_free_token;
    @FXML 
    private AnchorPane sector_player_choice;
    @FXML 
    private AnchorPane sector_opponent_choice;
    @FXML 
    private AnchorPane sector_spin_again;
    @FXML 
    private AnchorPane player_use_token;
    
    @FXML
    private Pane footer;
    
    //Anchor visibility
    @FXML
    private void setGamePlayVisible(Boolean visible){
        if(visible == true){
            game_play.setVisible(true);
        } else {
            game_play.setVisible(false);
        }
    }
    
    @FXML
    private void setSectorBankruptcyVisible(Boolean visible){
        if(visible == true){
            sector_bankruptcy.setVisible(true);
        } else {
            sector_bankruptcy.setVisible(false);
        }
    }
    
    @FXML
    private void setSectorLoseTurnVisible(Boolean visible){
        if(visible == true){
            sector_lose_turn.setVisible(true);
        } else {
            sector_lose_turn.setVisible(false);
        }
    }
    
    @FXML
    private void setSectorSpinAgainVisible(Boolean visible){
        if(visible == true){
            sector_spin_again.setVisible(true);
        } else {
            sector_spin_again.setVisible(false);
        }
    }
    
    @FXML
    private void setSectorFreeTokenVisible(Boolean visible){
        if(visible == true){
            sector_free_token.setVisible(true);
        } else {
            sector_free_token.setVisible(false);
        }
    }
    
    @FXML
    private void setUseTokenVisible(Boolean visible){
        if(visible == true){
            player_use_token.setVisible(true);
        } else {
            player_use_token.setVisible(false);
        }
    }
    
    @FXML
    private void setSectorPlayerChoiceVisible(Boolean visible){
        if(visible == true){
            sector_player_choice.setVisible(true);
        } else {
            sector_player_choice.setVisible(false);
        }
    }
    
    @FXML
    private void setSectorOpponentChoiceVisible(Boolean visible){
        if(visible == true){
            sector_opponent_choice.setVisible(true);
        } else {
            sector_opponent_choice.setVisible(false);
        }
    }
    
    @FXML
    private void setSectorQuestionVisible(Boolean visible){
        if(visible == true){
            sector_question.setVisible(true);
        } else {
            sector_question.setVisible(false);
        }
    }
    
    @FXML
    private void setAnswerResultsVisible(Boolean visible){
        if(visible == true){
            answer_results.setVisible(true);
        } else {
            answer_results.setVisible(false);
        }
    }
    
    @FXML
    private void setSectorsInvisible(){
        setAnswerResultsVisible(false);
        setSectorQuestionVisible(false);
        setSectorOpponentChoiceVisible(false);
        setSectorPlayerChoiceVisible(false);
        setUseTokenVisible(false);
        setSectorBankruptcyVisible(false);
        setSectorLoseTurnVisible(false);
        setSectorSpinAgainVisible(false);
        setSectorFreeTokenVisible(false);
    }
    
    
    //Label updates
    @FXML
    private void setRound(String round){
        round_value.setText(round);
    }
    
    @FXML
    private void setSpinCounter(String counter){
        spin_counter.setText(counter);
    }
    
    @FXML
    private void setTimer(String timer){
        game_timer.setText(timer);
    }
    
    @FXML
    private void setPlayer1Score(String score){
        player1_score.setText(score);
    }
    
    @FXML
    private void setPlayer2Score(String score){
        player2_score.setText(score);
    }
    
    @FXML
    private void setPlayer3Score(String score){
        player3_score.setText(score);
    }

    @FXML
    private void setPlayer1Tokens(String tokens){
        player1_tokens.setText(tokens);
    }
    
    @FXML
    private void setPlayer2Tokens(String tokens){
        player1_tokens.setText(tokens);
    }
    
    @FXML
    private void setPlayer3Tokens(String tokens){
        player1_tokens.setText(tokens);
    }
    
    //Handle Spin Wheel action
    @FXML
    private void handleSpinWheelAction(ActionEvent event) {
        spin_wheel_button.setText("Hello!");
    }
    
    //Handle Player Submit button action
    @FXML
    private void handlePlayerSubmitAction(ActionEvent event) {
        player_submit_button.setText("Hello!");
        setAnswerResultsVisible(true);
    }
    
    //Handle Correct Answer Override button action    
    @FXML
    private void handleCorrectOverrideSubmitAction(ActionEvent event) {
        correct_override_submit_button.setText("Hello!");
    }
    
    //Handle Incorrect Answer Override button action
    @FXML
    private void handleIncorrectOverrideSubmitAction(ActionEvent event) {
        incorrect_override_submit_button.setText("Hello!");
    }
    
    //Sector data population
    @FXML
    public void populateQuestion(String player, String categoryTitle, String questionContent, String answerContent, String pointValue){
        setSectorsInvisible();
        question_value.setText(pointValue);
        player_identifier.setText(player);
        category_title.setText(categoryTitle);
        question_content.setText(questionContent);
        correct_answer.setText(answerContent);
        setSectorQuestionVisible(true);
    }
    
    public void populateBankruptcy(String player){
        setSectorsInvisible();
        player_identifier.setText(player);
        setSectorBankruptcyVisible(true);
    }
    
    public void populateFreeToken(String player){
        setSectorsInvisible();
        player_identifier.setText(player);
        setSectorFreeTokenVisible(true);
    }
    
    public void populateLoseTurn(String player){
        setSectorsInvisible();
        player_identifier.setText(player);
        setSectorLoseTurnVisible(true);
    }
    
    public void populatePlayerChoice(String player){
        setSectorsInvisible();
        player_identifier.setText(player);
        //Add in categories to menu
        setSectorPlayerChoiceVisible(true);
    }
    
    public void populateOpponentChoice(String player, String opponent){
        setSectorsInvisible();
        player_identifier.setText(player);
        opponent_identifier.setText(opponent);
        //Add in categories to menu
        setSectorOpponentChoiceVisible(true);
    }
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
}
