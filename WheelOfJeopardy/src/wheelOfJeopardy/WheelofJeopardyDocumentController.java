/*
 * Wheel of Jeopardy Game
 * 
 * 
 */
package wheelOfJeopardy;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
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
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.application.Platform;


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
    @FXML private Label spin_timer;
    @FXML private Label player1_label;
    @FXML private Label player2_label;
    @FXML private Label player3_label;
    @FXML private Label token_label;
    @FXML private Label scores_label;
    @FXML private Label player_identifier;
    @FXML private Label opponent_identifier;
    @FXML private Label player_display_name;
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
    @FXML private Label player1_final_name;
    @FXML private Label player2_final_name;
    @FXML private Label player3_final_name;
    @FXML private Label player1_final_score;
    @FXML private Label player2_final_score;
    @FXML private Label player3_final_score;
    @FXML private Label winner_name;
    
    @FXML private MenuItem help;
    @FXML private AnchorPane help_anchor_pane;
    @FXML private Button close_help_button;
    
    @FXML private Button player_submit_button;
    @FXML private Button correct_override_submit_button;
    @FXML private Button incorrect_override_submit_button;
    @FXML private Button spin_wheel_button;
    @FXML private Button new_game_button;
    @FXML private Button start_game_button;
    @FXML private Button player_choice_submit_button;
    @FXML private Button opponent_choice_submit_button;
    @FXML private Button bankruptcy_continue_button;
    @FXML private Button lose_turn_continue_button;
    @FXML private Button player_use_token_submit;
    @FXML private Button player_no_use_token_submit;
    @FXML private Button spin_again_continue_button;
    
    
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
    
    @FXML private AnchorPane game_screen;
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
    @FXML private AnchorPane game_end;
    
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
    
    //private Integer free_spin_type = 0;
    //private Integer spin_count = 2;
    //private Integer round_count = 1;
    private String[] questionsHC = new String[30];
    private String[] answersHC = new String[30];
    private String[] usedQuestion = new String[30];
    //String[] firstRoundScore = new String[3];
    //Integer[] finalScore = new Integer[3];
    
    private Controller controller = new Controller();
    private ScoreBoard scoreboard;
    private Question lastQueston;
    
    private TimeKeeper timeKeeper = new TimeKeeper();
    private boolean isTimerForQuestion = false;
    private TimeKeeper gameTimer = new TimeKeeper();
    
    //Add styling
    @FXML void addCSS(){
        //anchors
        game_screen.getStyleClass().add("back-style");
        footer.getStyleClass().add("back-style");

        //buttons
        player_submit_button.getStyleClass().add("button-style");
        correct_override_submit_button.getStyleClass().add("button-style");
        incorrect_override_submit_button.getStyleClass().add("button-style");
        spin_wheel_button.getStyleClass().add("button-style");
        new_game_button.getStyleClass().add("button-style");
        start_game_button.getStyleClass().add("button-style");
        player_choice_submit_button.getStyleClass().add("button-style");
        opponent_choice_submit_button.getStyleClass().add("button-style");
        bankruptcy_continue_button.getStyleClass().add("button-style");
        player_use_token_submit.getStyleClass().add("button-style");
        player_no_use_token_submit.getStyleClass().add("button-style");
        lose_turn_continue_button.getStyleClass().add("button-style");
        spin_again_continue_button.getStyleClass().add("button-style");
        
    }
    
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
            correct_override_submit_button.setDisable(false);
            incorrect_override_submit_button.setDisable(false);
        } else {
            answer_results_incorrect.setVisible(false);
            answer_results_incorrect.setDisable(true);
            correct_override_submit_button.setDisable(true);
            incorrect_override_submit_button.setDisable(true);
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
    
    @FXML
    private void setGameEndVisible(Boolean visible){
        game_end.setVisible(visible);
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
    private void setActionTimer(){
        Platform.runLater(() -> {
            int numberOfSeconds = timeKeeper.getNumberOfSeconds();
            spin_timer.setText(String.format("00:%02d",numberOfSeconds));
            if (numberOfSeconds == 0){
               if (isTimerForQuestion){
                gamePlay(new LoseATurnSector());
                isTimerForQuestion = false;
               }
               else{
                String[] wheelCategories = getCategories();
                gamePlay(new CategorySector(wheelCategories[0]));
               }
            }
        });
        
    }
    
    @FXML
    private void setGameTimer(){
        Platform.runLater(() -> {
            int totalSeconds = gameTimer.getNumberOfSeconds();
            int minutes = (totalSeconds % 3600) /60;
            int seconds = totalSeconds % 60;
            game_timer.setText(String.format("%02d:%02d",minutes,seconds));
            
        });
        
    }
    
    
    @FXML void setPlayerWinner(Player theWinner){
       
        winner_name.setText(theWinner.getName());
    }

    

    @FXML
    private String[] getCategories(){
        String[] categories = new String[6];
        QuestionBoard[] questionBoards = this.controller.QuestionBoards;
        categories = questionBoards[this.controller.getRoundNumber()-1].getAllCategories();
        return categories;
    }
    
    @FXML
    private List<String> getValidCategories(){
        String[] categories = getCategories();
        List<String> validCategories = new ArrayList<>();
        for (int idx = 0; idx < categories.length; idx++)
        {
            if (this.controller.getQuestionForCategory(categories[idx]) != null){
                validCategories.add(categories[idx]);
            }
        }
        return validCategories;
    }
    
    @FXML 
    private void usedQuestionsHC(){
        for (int i = 0; i < usedQuestion.length; i++) {
            usedQuestion[i] = "false";
        }
    }
    
    
    //Handle Game start action
    @FXML
    private void handleGameLaunch(ActionEvent event) {
        new_game_button.setVisible(false);
        large_wheel_image.setVisible(false);
        player_identifiers.setVisible(true);
    }
    
    //Handle Player Identifier submit action and start game
    @FXML
    public void handleGameStart(ActionEvent event) {
        player_identifiers.setVisible(false);
        player1_label.setText(player1_name.getText());
        this.controller.setPlayer1(player1_name.getText());
        player2_label.setText(player2_name.getText());
        this.controller.setPlayer2(player2_name.getText());
        player3_label.setText(player3_name.getText());
        this.controller.setPlayer3(player3_name.getText());
        this.controller.startGame();
        this.controller.setupScoreBoards();
        this.scoreboard = this.controller.getScoreBoard();
        
        this.updatePlayerStats();
        
        setGameStatsVisible(true);
        setPlayerStatsVisible(true);
        round_value.setText(Integer.toString(this.controller.getRoundNumber()));
        
        populateGameStats();
        setGamePlayVisible(true);
        spin_wheel_image.setVisible(true);
        spin_wheel_button.setVisible(true);
        spin_wheel_button.setDisable(false);
        game_play.toFront();
        
        this.gameTimer.addListener(() -> {
            setGameTimer();
        });
        
        this.gameTimer.startStopWatch();

    }
    
    
    //Handle Spin Wheel action
    @FXML
    private void handleSpinWheelAction(ActionEvent event) {

        WheelSector theWheelSector = this.controller.spin();
        
        gamePlay(theWheelSector);
    }
    
    //Handle Player Submit button action
    @FXML
    private void handlePlayerSubmitAction(ActionEvent event) {
        timeKeeper.stopTimer();
        isTimerForQuestion = false;
        player_submit_button.setVisible(false);
        player_answer.setDisable(true);
        
        if (!player_answer.getText().equalsIgnoreCase(correct_answer.getText())){
            setAnswerResultsIncorrectVisible(true);    
        } else {
            populateAnswerCorrect();
        }
        spin_timer.setVisible(false);
    }
    
        
    @FXML
    private void handleCorrectAnswerContinueAction(ActionEvent event){
        highlightCategoryTable(category_title.getText(), false);
        updateCategoryTable();
        player_answer.setText("");
        correct_answer.setText("");
        player_answer.setDisable(false);

        this.scoreboard.addPointsForPlayer(this.controller.getCurrentPlayer(), Integer.parseInt(question_value.getText()));
        this.updatePlayerStats();
        
    }
    
    //Handle Correct Answer Override button action    
    @FXML
    private void handleCorrectOverrideSubmitAction(ActionEvent event) {
        highlightCategoryTable(category_title.getText(), false);
        updateCategoryTable();
        player_answer.setText("");
        correct_answer.setText("");
        player_answer.setDisable(false);

        this.controller.addPointsForCurrentPlayer(Integer.parseInt(question_value.getText()));
        this.updatePlayerStats();
        
    }
    
    //Handle Incorrect Answer Override button action
    @FXML
    private void handleIncorrectOverrideSubmitAction(ActionEvent event) {
        highlightCategoryTable(category_title.getText(), false);
        updateCategoryTable();
        player_answer.setText("");
        correct_answer.setText("");
        player_answer.setDisable(false);
        this.controller.subtractPointsForCurrentPlayer(Integer.parseInt(question_value.getText()));
        this.updatePlayerStats();
        
        if(checkForToken()){
            populateUseToken();
        } 
        else{
            this.controller.loseATurn();
        }
        
    }
    
    //Handle using a token yes action
    @FXML
    private void handleUseTokenSubmitAction(ActionEvent event) {
        this.controller.useTokenForCurrentPlayer();
        this.updatePlayerStats();
        
    }
    
    //Handle using a token no action
    @FXML
    private void handleNoUseTokenSubmitAction(ActionEvent event) {
        this.controller.loseATurn();
       
    }
    
    //Handle player's choice
    @FXML
    private void handlePlayerChoiceSubmitAction(ActionEvent event) {
        this.timeKeeper.stopTimer();
        String category_selected = "no";
        if(!category_box_player.getSelectionModel().isEmpty()){
            category_selected = category_box_player.getSelectionModel().getSelectedItem().toString();
        }
        
        String[] categories = getCategories();
        for (String s: categories) { 
            category_box_player.getItems().remove(s);
        }
        category_box_player.setValue("");
        //spin_count ++; //Have to update to not count as a spin
        

        CategorySector theCategorySector = new CategorySector(category_selected);
        spin_timer.setVisible(false);
        gamePlay(theCategorySector);
    }
    
    //Handle opponent's choice
    @FXML
    private void handleOpponentChoiceSubmitAction(ActionEvent event) {
        this.timeKeeper.stopTimer();
        String category_selected = "no";
        if(!category_box_opponent.getSelectionModel().isEmpty()){
            category_selected = category_box_opponent.getSelectionModel().getSelectedItem().toString();
        }

        String[] categories = getCategories();
        for (String s: categories) { 
            category_box_opponent.getItems().remove(s);
        }
        category_box_opponent.setValue("");

        CategorySector theCategorySector = new CategorySector(category_selected);
        spin_timer.setVisible(false);
        gamePlay(theCategorySector);
    }
    
    //Handle bankruptcy submit action
    @FXML
    private void handleBankruptyContinueAction(ActionEvent event) {
        this.controller.bankruptCurrentPlayer();
        this.updatePlayerStats();
        this.controller.loseATurn();
    }
    
    //Handle lose turn submit action
    @FXML
    private void handleLoseTurnContinueAction(ActionEvent event) {
        if (checkForToken()){
            populateUseToken();
        }
        else{
            this.controller.loseATurn();
        }
        
    }
    
   //Handle spin again continue action
    @FXML
    private void handleSpinAgainContinueAction(ActionEvent event) {

        WheelSector theWheelSector = this.controller.spin();
        
    }
    @FXML 
    private void handleHelp(ActionEvent event){
        help_anchor_pane.toFront();
        help_anchor_pane.setVisible(true); 
        close_help_button.toFront();
        close_help_button.setDisable(false);
    }    
    @FXML 
    private void handleHelpClose(ActionEvent event){
        help_anchor_pane.setVisible(false); 
        close_help_button.setDisable(true);
    }
    
    @FXML
    public boolean checkForToken(){
        return (this.controller.getCurrentPlayer().getNumberOfTokens() >= 1);
    }
    
    @FXML void setPlayerDisplayName(String player){
        if(player.equalsIgnoreCase("player1")) {
             player_display_name.setText(this.scoreboard.getPlayerNumber(1).getName());
        } else if(player.equalsIgnoreCase("player2")){
            player_display_name.setText(this.scoreboard.getPlayerNumber(2).getName());
        } else {
            player_display_name.setText(this.scoreboard.getPlayerNumber(3).getName());
        }
    }
    
    @FXML void setOpponentDisplayName(String player){
        if(player.equalsIgnoreCase("player1")) {
            opponent_identifier.setText(player1_name.getText());
        } else if(player.equalsIgnoreCase("player2")){
            opponent_identifier.setText(player2_name.getText());
        } else {
            opponent_identifier.setText(player3_name.getText());
        }
    }
        
    //Sector data population
    @FXML
    public void populateQuestion(String categoryTitle, Question theQuestion){
        setSectorsInvisible();
        sector_question.toFront();
        question_value.setText(Integer.toString(theQuestion.getPointValue()));
        player_identifier.setText(this.controller.getCurrentPlayer().getName());
        category_title.setText(categoryTitle);
        question_content.setText(theQuestion.getQuestion());
        correct_answer.setText(theQuestion.getAnswer());
        highlightCategoryTable(categoryTitle, true);
        player_submit_button.setVisible(true);
        correct_answer.setEditable(false);
        setSectorQuestionVisible(true);
        
        this.timeKeeper = new TimeKeeper();
        this.isTimerForQuestion = true;
        this.timeKeeper.addListener(() -> {
            setActionTimer();
        });
        
        spin_timer.setVisible(true);
        this.timeKeeper.startTimer(60);
        
        
    }
    
    //Populate answer correct
    @FXML
    public void populateAnswerCorrect(){
        answer_results_correct.toFront();
        setAnswerResultsCorrectVisible(true);
    }
    
    //Populate answer incorrect
    @FXML
    public void populateAnswerIncorrect(String answerContent){
        answer_results_incorrect.toFront();
        setAnswerResultsIncorrectVisible(true);
        
    }
    
    public void populateBankruptcy(){
        setSectorsInvisible();
        sector_bankruptcy.toFront();
        player_identifier.setText(this.controller.getCurrentPlayer().getName());
        setSectorBankruptcyVisible(true);
    }
    
    public void populateFreeToken(){
        setSectorsInvisible();
        sector_free_token.toFront();
        player_identifier.setText(this.controller.getCurrentPlayer().getName());
        this.controller.addTokenForCurrentPlayer();
        this.updatePlayerStats();
        //setPlayerTokens(player, "1");
        setSectorFreeTokenVisible(true);
    }
    
    public void populateSpinAgain(){
        setSectorsInvisible();
        sector_spin_again.toFront();
        player_identifier.setText(this.controller.getCurrentPlayer().getName());
        setSectorSpinAgainVisible(true);
    }
    
    public void populateLoseTurn(){
        setSectorsInvisible();
        sector_lose_turn.toFront();
        player_identifier.setText(this.controller.getCurrentPlayer().getName());
        setSectorLoseTurnVisible(true);
    }
    
    public void populatePlayerChoice(){
        Player theCurrentPlayer = this.controller.getCurrentPlayer();
        List<String> validCategories = getValidCategories();
        setSectorsInvisible();
        sector_player_choice.toFront();
        player_identifier.setText(theCurrentPlayer.getName());
        for (int idx2 = 0; idx2 < validCategories.size(); idx2++) { 
            category_box_player.getItems().add(validCategories.get(idx2));
        }
        setSectorPlayerChoiceVisible(true);
        
        this.timeKeeper = new TimeKeeper();
        this.timeKeeper.addListener(() -> {
            setActionTimer();
        });
        
        spin_timer.setVisible(true);
        this.timeKeeper.startTimer(15);
    }
    
    public void populateOpponentChoice(){
        Player theOpponent = this.controller.getOpponent();
        List<String> validCategories = getValidCategories();
        
        setSectorsInvisible();
        sector_opponent_choice.toFront();
        opponent_identifier.setText(theOpponent.getName());
        for (int idx2 = 0; idx2 < validCategories.size(); idx2++) { 
            category_box_opponent.getItems().add(validCategories.get(idx2));
        }
        setSectorOpponentChoiceVisible(true);
        
        this.timeKeeper = new TimeKeeper();
        this.timeKeeper.addListener(() -> {
            setActionTimer();
        });
        spin_timer.setVisible(true);
        this.timeKeeper.startTimer(15);
    }

    public void populateUseToken(){
        setSectorsInvisible();
        player_use_token.toFront();
        player_identifier.setText(this.controller.getCurrentPlayer().getName());
        setUseTokenVisible(true);
    }
        
    public void populateGameStats(){
        round_value.setText(Integer.toString(this.controller.getRoundNumber()));
        data = getInitialTableData(Integer.toString(this.controller.getRoundNumber()));
        String[] categories = getCategories();
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
        int spinCount = this.scoreboard.getRoundCount();
        setSpinCounter(Integer.toString(spinCount));
    }
    
    
    public void highlightCategoryTable(String category, boolean highlight){
        if(highlight){
            if(category.equalsIgnoreCase(category1_label.getText())){
                category1.getStyleClass().add("category-style");
            } else if(category.equalsIgnoreCase(category2_label.getText())){
                category2.getStyleClass().add("category-style");
            } else if(category.equalsIgnoreCase(category3_label.getText())){
                category3.getStyleClass().add("category-style");
            } else if(category.equalsIgnoreCase(category4_label.getText())){
                category4.getStyleClass().add("category-style");
            } else if(category.equalsIgnoreCase(category5_label.getText())){
                category5.getStyleClass().add("category-style");
            } else if(category.equalsIgnoreCase(category6_label.getText())){
                category6.getStyleClass().add("category-style");   
            }
        } else {
            if(category.equalsIgnoreCase(category1_label.getText())){
                category1.getStyleClass().clear();
            } else if(category.equalsIgnoreCase(category2_label.getText())){
                category2.getStyleClass().clear();
            } else if(category.equalsIgnoreCase(category3_label.getText())){
                category3.getStyleClass().clear();
            } else if(category.equalsIgnoreCase(category4_label.getText())){
                category4.getStyleClass().clear();
            } else if(category.equalsIgnoreCase(category5_label.getText())){
                category5.getStyleClass().clear();
            } else if(category.equalsIgnoreCase(category6_label.getText())){
                category6.getStyleClass().clear();   
            }
        }
    }
    
    public void updateCategoryTable(){
        //Remove category point value cell value
        int row_position = 0;
        String category = this.lastQueston.getCategory();
        int points = this.lastQueston.getPointValue();
        row_position = (points/(100 * this.controller.getRoundNumber()) -1);
        
        
        RowPointValues updatedRow = new RowPointValues();
        updatedRow = (RowPointValues) list.get(row_position);
        
        
        if(category.equalsIgnoreCase(category1_label.getText())){
            updatedRow.setCell_1("");
        } else if(category.equalsIgnoreCase(category2_label.getText())){
            updatedRow.setCell_2("");
        } else if(category.equalsIgnoreCase(category3_label.getText())){
            updatedRow.setCell_3("");
        } else if(category.equalsIgnoreCase(category4_label.getText())){
            updatedRow.setCell_4("");
        } else if(category.equalsIgnoreCase(category5_label.getText())){
            updatedRow.setCell_5("");
        } else if(category.equalsIgnoreCase(category6_label.getText())){
            updatedRow.setCell_6("");
        } 

        list.set(row_position, updatedRow);       
    }
    
    
    
    
    public void updatePlayerStats(){
        Player player1 = this.scoreboard.getPlayerNumber(1);
        Player player2 = this.scoreboard.getPlayerNumber(2);
        Player player3 = this.scoreboard.getPlayerNumber(3);
        player1_tokens.setText("" + player1.getNumberOfTokens());
        player2_tokens.setText("" + player2.getNumberOfTokens());
        player3_tokens.setText("" +player3.getNumberOfTokens());
        player1_score.setText("" +player1.getScore());
        player2_score.setText("" + player2.getScore());
        player3_score.setText("" + player3.getScore());
       
    }
        
    private ObservableList getInitialTableData(String round) {
        if(round_value.getText().equalsIgnoreCase("1")){
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
    
    @FXML 
    //Game opener
    public void launchGame(){
        game_open_panel.setVisible(true);
        addCSS();
        
    } 
    

    //Main controller

    public void gamePlay(WheelSector theWheelSector){
        player_display_name.setText(this.controller.getCurrentPlayer().getName());
        String[] categories = getCategories();
        for (String category:categories){
            highlightCategoryTable(category, false);
        }
        
        int spinCount = this.scoreboard.getRoundCount();
        setSpinCounter(Integer.toString(spinCount));
        String[] theCategories = getCategories();
        boolean areThereUnusedQuestions = false;
        for (String theCategory:theCategories){
            if(this.controller.getQuestionForCategory(theCategory) != null){
                areThereUnusedQuestions = true;
                break;
            }
        }
        if(spinCount == 0 || !areThereUnusedQuestions){
            if(this.controller.getRoundNumber() == 1){
                this.controller.startRound2();
                this.updatePlayerStats();
                populateGameStats();
                
                setSpinCounter(Integer.toString(this.scoreboard.getRoundCount()));
                
            } else if (round_value.getText().equalsIgnoreCase("2")){
                endGame();
            }
        } else {

            game_play.toFront();
   
                if (theWheelSector instanceof BankruptSector){
                    populateBankruptcy();
                }
                if (theWheelSector instanceof LoseATurnSector){
                    populateLoseTurn();
                }
                if (theWheelSector instanceof PlayersChoiceSector){
                    populatePlayerChoice();
                }
                if (theWheelSector instanceof OpponentsChoiceSector){
                    populateOpponentChoice();
                }
                if (theWheelSector instanceof SpinAgainSector){
                    populateSpinAgain();
                }
                if (theWheelSector instanceof FreeSpinSector){
                    populateFreeToken();
                }
                if (theWheelSector instanceof CategorySector){
                    String theCategory = theWheelSector.getName();
                    
                    Question theQuestion = this.controller.getQuestionForCategory(theCategory);
                    if (theQuestion == null){
                        WheelSector newWheelSector = this.controller.spin();
                        gamePlay(newWheelSector); 
                    }
                    else{
                        this.lastQueston = theQuestion;
                        theQuestion.setUsed(true);
                        populateQuestion(theCategory, theQuestion);
                    }
                }

            }
        }
    @FXML private void endGame(){
        Player theWinner = this.controller.stopGame();
        setSectorsInvisible();
        setGamePlayVisible(false);
        setPlayerStatsVisible(false);
        setGameStatsVisible(false);
        //setFinalScore();
        Player player1 = this.controller.getPlayerNumber(1);
        Player player2 = this.controller.getPlayerNumber(2);
        Player player3 = this.controller.getPlayerNumber(3);
        
        player1_final_score.setText(String.valueOf(player1.getScore()));
        player2_final_score.setText(String.valueOf(player2.getScore()));
        player3_final_score.setText(String.valueOf(player3.getScore()));
        player1_final_name.setText(player1.getName());
        player2_final_name.setText(player2.getName());
        player3_final_name.setText(player3.getName());
        
        setPlayerWinner(theWinner);
        spin_wheel_image.setVisible(false);
        spin_wheel_button.setVisible(false);
        spin_wheel_button.setDisable(true);
        game_end.toFront();
        setGameEndVisible(true);
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
} 
     
    

