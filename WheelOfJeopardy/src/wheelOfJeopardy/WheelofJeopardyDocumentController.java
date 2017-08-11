/*
 * Wheel of Jeopardy Game
 * 
 * 
 */
package wheelOfJeopardy;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
import javafx.scene.image.ImageView;
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
    @FXML private Button new_game_button;
    @FXML private Button start_game_button;
    @FXML private Button player_choice_submit_button;
    @FXML private Button opponent_choice_submit_button;
    @FXML private Button bankruptcy_continue_button;
    @FXML private Button player_use_token_submit;
    
    @FXML private TextField player1_name;
    @FXML private TextField player2_name;
    @FXML private TextField player3_name;
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
    
    @FXML private AnchorPane game_open_panel;
    @FXML private AnchorPane player_identifiers;
    @FXML private AnchorPane game_play;
    @FXML private AnchorPane game_stats;
    @FXML private AnchorPane player_stats;
    @FXML private AnchorPane answer_results_incorrect;
    @FXML private AnchorPane answer_results_correct;
    @FXML private AnchorPane sector_question;
    @FXML private AnchorPane sector_bankruptcy;
    @FXML private AnchorPane sector_lose_turn;
    @FXML private AnchorPane sector_free_token;
    @FXML private AnchorPane sector_player_choice;
    @FXML private AnchorPane sector_opponent_choice;
    @FXML private AnchorPane sector_spin_again;
    @FXML private AnchorPane player_use_token;
    
    @FXML  private Pane footer;
    
    @FXML private ImageView large_wheel_image;
    @FXML private ImageView spin_wheel_image;
    
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
            sector_bankruptcy.setDisable(false);
        } else {
            sector_bankruptcy.setVisible(false);
            sector_bankruptcy.setDisable(true);
        }
    }
    
    @FXML
    private void setSectorLoseTurnVisible(Boolean visible){
        if(visible == true){
            sector_lose_turn.setVisible(true);
            sector_lose_turn.setDisable(false);
        } else {
            sector_lose_turn.setVisible(false);
            sector_lose_turn.setDisable(true);
        }
    }
    
    @FXML
    private void setSectorSpinAgainVisible(Boolean visible){
        if(visible == true){
            sector_spin_again.setVisible(true);
            sector_spin_again.setDisable(false);
        } else {
            sector_spin_again.setVisible(false);
            sector_spin_again.setDisable(true);
        }
    }
    
    @FXML
    private void setSectorFreeTokenVisible(Boolean visible){
        if(visible == true){
            sector_free_token.setVisible(true);
            sector_free_token.setDisable(false);
        } else {
            sector_free_token.setVisible(false);
            sector_free_token.setDisable(true);
        }
    }
    
    @FXML
    private void setUseTokenVisible(Boolean visible){
        if(visible == true){
            player_use_token.setVisible(true);
            player_use_token.setDisable(false);
        } else {
            player_use_token.setVisible(false);
            player_use_token.setDisable(true);
        }
    }
    
    @FXML
    private void setSectorPlayerChoiceVisible(Boolean visible){
        if(visible == true){
            sector_player_choice.setVisible(true);
            sector_player_choice.setDisable(false);
        } else {
            sector_player_choice.setVisible(false);
            sector_player_choice.setDisable(true);
        }
    }
    
    @FXML
    private void setSectorOpponentChoiceVisible(Boolean visible){
        if(visible == true){
            sector_opponent_choice.setVisible(true);
            sector_opponent_choice.setDisable(false);
        } else {
            sector_opponent_choice.setVisible(false);
            sector_opponent_choice.setDisable(true);
        }
    }
    
    @FXML
    private void setSectorQuestionVisible(Boolean visible){
        if(visible == true){
            sector_question.setVisible(true);
            sector_question.setDisable(false);
        } else {
            sector_question.setVisible(false);
            sector_question.setDisable(true);
        }
    }
    
    @FXML
    private void setAnswerResultsCorrectVisible(Boolean visible){
        if(visible == true){
            answer_results_correct.setVisible(true);
            answer_results_correct.setDisable(false);
        } else {
            answer_results_correct.setVisible(false);
            answer_results_correct.setDisable(true);
        }
    }
    
    @FXML
    private void setAnswerResultsIncorrectVisible(Boolean visible){
        if(visible == true){
            answer_results_incorrect.setVisible(true);
            answer_results_incorrect.setDisable(false);
        } else {
            answer_results_incorrect.setVisible(false);
            answer_results_incorrect.setDisable(true);
        }
    }
    
    @FXML
    private void setSectorsInvisible(){
        setAnswerResultsIncorrectVisible(false);
        setAnswerResultsCorrectVisible(false);
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
    
    public void gamePlay(int counter){
        //Round 1
        String player = "player1";
        String opponent = "player2";
        
        String categoryTitle = "American History"; 
        String questionContent = "The only Constitutional amendment to be repealed, the 18th Amendment originally put this into effect"; 
        String answerContent = "Prohibition"; 
        String pointValue = "100";
        
        game_play.toFront();
        switch(counter) {
            case 1: 
                populateBankruptcy(player);
                break;
            case 2: 
                populateLoseTurn(player);
                break;
            case 3:
                populatePlayerChoice(player, getCategories());
                break;
            case 4:
                populateOpponentChoice(player, opponent, getCategories());
                break;
            case 5: 
                populateSpinAgain(player);
                break;
            case 6: 
                populateFreeToken(player);
                break;
            case 7:
                populateQuestion(player, categoryTitle, questionContent, answerContent, pointValue);
                break;
            case 8: 
                populateUseToken(player);
                break;
            default: 
                populateSpinAgain(player);
                break;
        }

    }
    

    @FXML 
    public void launchGame(){
        game_open_panel.setVisible(true);
    } 
    
    //Handle Game start action
    @FXML
    private void gameLaunch(ActionEvent event) {
        new_game_button.setVisible(false);
        large_wheel_image.setVisible(false);
        player_identifiers.setVisible(true);
    }
    
    @FXML
    private String[] getCategories(){
        String[] categories = new String[6];
        categories[0] = "American History";
        categories[1] = "Single-Named Singers";
        categories[2] = "Science";
        categories[3] = "Literature";
        categories[4] = "Business";
        categories[5] = "Movies";
        
        return categories;
    }
    
    //Handle Player Identifier submit action and start game
    @FXML
    public void gameStart(ActionEvent event) {
        player_identifiers.setVisible(false);
        player1_label.setText(player1_name.getText());
        player2_label.setText(player2_name.getText());
        player3_label.setText(player3_name.getText());
        setGameStatsVisible(true);
        setPlayerStatsVisible(true);
        
        populateGameStats("1", getCategories());
        setGamePlayVisible(true);
        spin_wheel_image.setVisible(true);
        spin_wheel_button.setVisible(true);
        spin_wheel_button.setDisable(false);
        game_play.toFront();
        
        gamePlay(7);
    }
    
    
    //Handle Spin Wheel action
    @FXML
    private void handleSpinWheelAction(ActionEvent event) {
        Random randomGen = new Random();
        int randomNum = randomGen.nextInt((7 - 1) + 1) + 1;
        gamePlay(randomNum);
    }
    
    //Handle Spin Wheel action
    @FXML
    private void handleBankruptcyAction(ActionEvent event) {
        //Random randomGen = new Random();
        //int randomNum = randomGen.nextInt((7 - 1) + 1) + 1;
        //gamePlay(randomNum);
        gamePlay(4);
    }
    
    //Handle Player Submit button action
    @FXML
    private void handlePlayerSubmitAction(ActionEvent event) {
        player_submit_button.setVisible(false);
        setAnswerResultsIncorrectVisible(true);
    }
    
    //Handle Correct Answer Override button action    
    @FXML
    private void handleCorrectOverrideSubmitAction(ActionEvent event) {
        player_answer.setText("");
        correct_answer.setText("");
        highlightCategoryTable(category_title.getText(), false);
        Random randomGen = new Random();
        int randomNum = randomGen.nextInt((7 - 1) + 1) + 1;
        gamePlay(randomNum);
    }
    
    //Handle Incorrect Answer Override button action
    @FXML
    private void handleIncorrectOverrideSubmitAction(ActionEvent event) {
        player_answer.setText("");
        correct_answer.setText("");
        highlightCategoryTable(category_title.getText(), false);
        Random randomGen = new Random();
        int randomNum = randomGen.nextInt((7 - 1) + 1) + 1;
        gamePlay(randomNum);
    }
    
    //Handle using a token yes action
    @FXML
    private void handleUseTokenSubmitAction(ActionEvent event) {
        incorrect_override_submit_button.setText("Hello!");
        Random randomGen = new Random();
        int randomNum = randomGen.nextInt((7 - 1) + 1) + 1;
        gamePlay(randomNum);
    }
    
    //Handle player's choice
    @FXML
    private void handlePlayerChoiceSubmitAction(ActionEvent event) {
        String[] categories = getCategories();
        for (String s: categories) { 
            category_box_player.getItems().remove(s);
        }
        category_box_player.setValue("");
        Random randomGen = new Random();
        int randomNum = randomGen.nextInt((7 - 1) + 1) + 1;
        gamePlay(randomNum);
    }
    
    //Handle player's choice
    @FXML
    private void handleOpponentChoiceSubmitAction(ActionEvent event) {
        String[] categories = getCategories();
        for (String s: categories) { 
            category_box_opponent.getItems().remove(s);
        }
        category_box_opponent.setValue("");
        Random randomGen = new Random();
        int randomNum = randomGen.nextInt(9);
        gamePlay(randomNum);
    }
    
    //Sector data population
    @FXML
    public void populateQuestion(String player, String categoryTitle, String questionContent, String answerContent, String pointValue){
        setSectorsInvisible();
        sector_question.toFront();
        question_value.setText(pointValue);
        player_identifier.setText(player);
        category_title.setText(categoryTitle);
        question_content.setText(questionContent);
        correct_answer.setText(answerContent);
        highlightCategoryTable(categoryTitle, true);
        player_submit_button.setVisible(true);
        setSectorQuestionVisible(true);
    }
    
    //Populate answer correct
    @FXML
    public void populateAnswerCorrect(String answerContent){
        answer_results_correct.toFront();
        setAnswerResultsCorrectVisible(true);
    }
    
    //Populate answer incorrect
    @FXML
    public void populateAnswerIncorrect(String answerContent){
        answer_results_incorrect.toFront();
        setAnswerResultsIncorrectVisible(true);
    }
    
    public void populateBankruptcy(String player){
        setSectorsInvisible();
        sector_bankruptcy.toFront();
        player_identifier.setText(player);
        setSectorBankruptcyVisible(true);
    }
    
    public void populateFreeToken(String player){
        setSectorsInvisible();
        sector_free_token.toFront();
        player_identifier.setText(player);
        setSectorFreeTokenVisible(true);
    }
    
    public void populateSpinAgain(String player){
        setSectorsInvisible();
        sector_spin_again.toFront();
        player_identifier.setText(player);
        setSectorSpinAgainVisible(true);
    }
    
    public void populateLoseTurn(String player){
        setSectorsInvisible();
        sector_lose_turn.toFront();
        player_identifier.setText(player);
        setSectorLoseTurnVisible(true);
    }
    
    public void populatePlayerChoice(String player, String[] categories){
        setSectorsInvisible();
        sector_player_choice.toFront();
        player_identifier.setText(player);
        for (String s: categories) { 
            category_box_player.getItems().add(s);
        }
        setSectorPlayerChoiceVisible(true);
    }
    
    public void populateOpponentChoice(String player, String opponent, String[] categories){
        setSectorsInvisible();
        sector_opponent_choice.toFront();
        opponent_identifier.setText(opponent);
        for (String s: categories) { 
            category_box_opponent.getItems().add(s);
        }
        setSectorOpponentChoiceVisible(true);
    }

    public void populateUseToken(String player){
        setSectorsInvisible();
        player_use_token.toFront();
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
        
        
        category1.getStyleClass().add("category1-style");
        category2.getStyleClass().add("category2-style");
        category3.getStyleClass().add("category3-style");
        category4.getStyleClass().add("category4-style");
        category5.getStyleClass().add("category5-style");
        category6.getStyleClass().add("category6-style");
    }
    
    public void updateGameStats(){
        //update round and game timer?
    }
    
    public void highlightCategoryTable(String category, boolean highlight){
        if(highlight == true){
            if(category == category1_label.getText()){
                category1.getStyleClass().add("category-style");
            } else if(category == category2_label.getText()){
                category2.getStyleClass().add("category-style");
            } else if(category == category3_label.getText()){
                category2.getStyleClass().add("category-style");
            } else if(category == category4_label.getText()){
                category2.getStyleClass().add("category-style");
            } else if(category == category5_label.getText()){
                category2.getStyleClass().add("category-style");
            } else if(category == category6_label.getText()){
                category2.getStyleClass().add("category-style");   
            }
        } else {
            if(category == category1_label.getText()){
                category1.getStyleClass().remove("category-style");
            } else if(category == category2_label.getText()){
                category2.getStyleClass().remove("category-style");
            } else if(category == category3_label.getText()){
                category2.getStyleClass().remove("category-style");
            } else if(category == category4_label.getText()){
                category2.getStyleClass().remove("category-style");
            } else if(category == category5_label.getText()){
                category2.getStyleClass().remove("category-style");
            } else if(category == category6_label.getText()){
                category2.getStyleClass().remove("category-style");   
            }
        }
    }
    
    public void updateCategoryTable(String round, String category, String points){
        //Remove category point value cell value
        int column_position = 0;
        int row_position = 0;
        if(category == category1_label.getText()){
            column_position = 0;
        } else if(category == category2_label.getText()){
            column_position = 1;
        } else if(category == category3_label.getText()){
            column_position = 2;
        } else if(category == category4_label.getText()){
            column_position = 3;
        } else if(category == category5_label.getText()){
            column_position = 4;   
        } else if(category == category6_label.getText()){
            column_position = 5;   
        } 

        //Round 1
        if (round == "1"){
            if (points == "100"){
                row_position = 0;
            } else if (points == "200"){
                row_position = 1;
            } else if (points == "300"){
                row_position = 2;
            } else if (points == "400"){
                row_position = 3;
            } else if (points == "500"){
                row_position = 4;
            }
        } else {
            if (points == "200"){
                row_position = 0;
            } else if (points == "400"){
                row_position = 1;
            } else if (points == "600"){
                row_position = 2;
            } else if (points == "800"){
                row_position = 3;
            } else if (points == "1000"){
                row_position = 4;
            }
        }
        
        RowPointValues updatedRow = new RowPointValues();
            updatedRow = (RowPointValues) list.get(row_position);
            if (column_position == 0){
                updatedRow.setCell_1("");
            } else if (column_position == 1){
                updatedRow.setCell_2("");
            } else if (column_position == 2){
                updatedRow.setCell_3("");
            } else if (column_position == 3){
                updatedRow.setCell_4("");
            } else if (column_position == 4){
                updatedRow.setCell_5("");
            } else if (column_position == 5){
                updatedRow.setCell_6("");
            }

            list.set(row_position, updatedRow);       
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
