/*
 * Wheel of Jeopardy Game
 * 
 * 
 */
package wheelOfJeopardy;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author Heather
 */
public class WheelofJeopardyDocumentController implements Initializable {
    
    //Define all fields
    @FXML private Label label;
    @FXML private Label title;
    @FXML private Label spin_counter;
    @FXML private Label game_timer;
    @FXML private Label spin_label;
    @FXML private Label round_label;
    @FXML private Label round_value;
    @FXML private Label game_timer_label;
    @FXML private Label player1_label;
    @FXML private Label player2_label;
    @FXML private Label player3_label;
    @FXML private Label token_label;
    @FXML private Label scores_label;
    @FXML private Label player_identifier;
    @FXML private Label opponent_identifier;
    @FXML private Label question;
    @FXML private Label category;
    @FXML private Label player_answer_label;
    @FXML private Label question_value_label;
    @FXML private Label correct_answer_label;
    @FXML private Label category_title;
    @FXML private Label question_content;
    @FXML private Label question_value;
    @FXML private Label category1_label;
    @FXML private Label category2_label;
    @FXML private Label category3_label;
    @FXML private Label category4_label;
    @FXML private Label category5_label;
    @FXML private Label category6_label;
    
    @FXML private Button player_submit_button;
    @FXML private Button correct_override_submit_button;
    @FXML private Button incorrect_override_submit_button;
    @FXML private Button spin_wheel_button;
    
    @FXML private TextField player1_score;
    @FXML private TextField player2_score;
    @FXML private TextField player3_score;
    @FXML private TextField player1_tokens;
    @FXML private TextField player2_tokens;
    @FXML private TextField player3_tokens;
    @FXML private TextField player_answer;
    @FXML private TextField correct_answer;
    
    @FXML private TableView category_table;
    @FXML private TableColumn category1;
    @FXML private TableColumn category2;
    @FXML private TableColumn category3;
    @FXML private TableColumn category4;
    @FXML private TableColumn category5;
    @FXML private TableColumn category6;
    @FXML private ChoiceBox category_box_player;
    @FXML private ChoiceBox category_box_opponent;
    
    @FXML private AnchorPane game_play;
    @FXML private AnchorPane game_stats;
    @FXML private AnchorPane player_stats;
    @FXML private AnchorPane answer_results;
    @FXML private AnchorPane sector_question;
    @FXML private AnchorPane sector_bankruptcy;
    @FXML private AnchorPane sector_lose_turn;
    @FXML private AnchorPane sector_free_token;
    @FXML private AnchorPane sector_player_choice;
    @FXML private AnchorPane sector_opponent_choice;
    @FXML private AnchorPane sector_spin_again;
    @FXML private AnchorPane player_use_token;
    
    @FXML  private Pane footer;
    
    private ObservableList data;
    public List list = new ArrayList();
    public RowPointValues row1 = new RowPointValues("100", "100", "100", "100", "100", "100");
    public RowPointValues row2 = new RowPointValues("200", "200", "200", "200", "200", "200");
    public RowPointValues row3 = new RowPointValues("300", "300", "300", "300", "300", "300");
    public RowPointValues row4 = new RowPointValues("400", "400", "400", "400", "400", "400");
    public RowPointValues row5 = new RowPointValues("500", "500", "500", "500", "500", "500");
    public RowPointValues row6 = new RowPointValues("200", "200", "200", "200", "200", "200");
    public RowPointValues row7 = new RowPointValues("400", "400", "400", "400", "400", "400");
    public RowPointValues row8 = new RowPointValues("600", "600", "600", "600", "600", "600");
    public RowPointValues row9 = new RowPointValues("800", "800", "800", "800", "800", "800");
    public RowPointValues row10 = new RowPointValues("1000", "1000", "1000", "1000", "1000", "1000");
    
    
        
    //Anchor visibility
    @FXML
    public void setGamePlayVisible(Boolean visible){
        if(visible == true){
            setSectorsInvisible();
            game_play.setVisible(true);
        } else {
            setSectorsInvisible();
            game_play.setVisible(false);
        }
    }
    
    @FXML
    public void setPlayerStatsVisible(Boolean visible){
        if(visible == true){
            player_stats.setVisible(true);
        } else {
            setSectorsInvisible();
            player_stats.setVisible(false);
        }
    }
    
    @FXML
    public void setGameStatsVisible(Boolean visible){
        if(visible == true){
            game_stats.setVisible(true);
        } else {
            setSectorsInvisible();
            game_stats.setVisible(false);
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
    
    public void populateSpinAgain(String player){
        setSectorsInvisible();
        player_identifier.setText(player);
        setSectorSpinAgainVisible(true);
    }
    
    public void populateLoseTurn(String player){
        setSectorsInvisible();
        player_identifier.setText(player);
        setSectorLoseTurnVisible(true);
    }
    
    public void populatePlayerChoice(String player, String[] categories){
        setSectorsInvisible();
        player_identifier.setText(player);
        for (String s: categories) { 
            category_box_player.getItems().add(s);
        }
        setSectorPlayerChoiceVisible(true);
    }
    
    public void populateOpponentChoice(String player, String opponent, String[] categories){
        setSectorsInvisible();
        player_identifier.setText(player);
        opponent_identifier.setText(opponent);
        for (String s: categories) { 
            category_box_opponent.getItems().add(s);
        }
        setSectorOpponentChoiceVisible(true);
    }

    public void populateUseToken(String player){
        setSectorsInvisible();
        player_identifier.setText(player);
        setUseTokenVisible(true);
    }
        
    public void populateGameStats(String round, String[] categories){
        round_value.setText(round);
        data = getInitialTableData(round);
        category1_label.setText(categories[0]);
        category2_label.setText(categories[1]);
        category3_label.setText(categories[2]);
        category4_label.setText(categories[3]);
        category5_label.setText(categories[4]);
        category6_label.setText(categories[5]);
        category_table.setItems(data);
        
        category1.setCellValueFactory(new PropertyValueFactory("cell_1"));
        category2.setCellValueFactory(new PropertyValueFactory("cell_2"));
        category3.setCellValueFactory(new PropertyValueFactory("cell_3"));
        category4.setCellValueFactory(new PropertyValueFactory("cell_4"));
        category5.setCellValueFactory(new PropertyValueFactory("cell_5"));
        category6.setCellValueFactory(new PropertyValueFactory("cell_6"));       
    }
    
    public void updateGameStats(){
        //update round and game timer?
    }
    
    public void highlightCategoryTable(String category, String points){
        //Find category point value to highlight
    }
    
    public void updateCategoryTable(String category, String points){
        //Remove category point value cell value
        /*if(category == category1_label.getText()){
            String chosenColumn = "1";
        }
        if(points == "100"){
            String chosenRow = "1"; 
        } */
            row1.setCell_1("");
        
    }
    
    
    public void populatePlayerStats(){
        //player names
    }
    
    public void updatePlayerStats(String player, String points, String tokens){
       //lookup Java string comparisons
        if(player == player1_label.getText()){
            player1_score.setText(points);
            player1_tokens.setText(tokens);
        } else if (player == player2_label.getText()){
            player2_score.setText(points);
            player2_tokens.setText(tokens);
        } else {
            player3_score.setText(points);
            player3_tokens.setText(tokens);    
        }
    }
        
    private ObservableList getInitialTableData(String round) {
        if(round == "1"){
            list.add(row1);
            list.add(row2);
            list.add(row3);
            list.add(row4);
            list.add(row5);
        } else {
            list.clear();
            list.add(row6);
            list.add(row7);
            list.add(row8);
            list.add(row9);
            list.add(row10);
        }
        
        ObservableList data = FXCollections.observableList(list);

        return data;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
}
