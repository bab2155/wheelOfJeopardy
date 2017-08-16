/*
 * Wheel of Jeopardy Game
 * 
 * 
 */
package wheelOfJeopardy;

import com.sun.deploy.util.ArrayUtil;
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
    
    private Integer free_spin_type = 0;
    private Integer spin_count = 50;
    private Integer round_count = 1;
    private String[] questionsHC = new String[30];
    private String[] answersHC = new String[30];
    private String[] usedQuestion = new String[30];
    String[] firstRoundScore = new String[3];
    
    private Controller controller = new Controller();
    private ScoreBoard scoreboard;
    
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
    private void setPlayerScore(String player, String score){
        
        if(player.equalsIgnoreCase("player1")) {
             Integer total_score = Integer.parseInt(player1_score.getText());
             total_score += Integer.parseInt(score);
             player1_score.setText(Integer.toString(total_score));
        } else if(player.equalsIgnoreCase("player2")){
            Integer total_score = Integer.parseInt(player2_score.getText());
            total_score += Integer.parseInt(score);
            player2_score.setText(Integer.toString(total_score));
        } else {
            Integer total_score = Integer.parseInt(player3_score.getText());
            total_score += Integer.parseInt(score);
            player3_score.setText(Integer.toString(total_score));
        }
    }
    
    @FXML
    private void setFirstRoundScore(){
        firstRoundScore[0] = player1_score.getText();
        firstRoundScore[1] = player2_score.getText();
        firstRoundScore[2] = player3_score.getText();
    }
    
    @FXML String[] getFinalScore(){
        String[] finalScore = new String[3];
        finalScore[0] = String.valueOf(firstRoundScore[0]) + String.valueOf(player1_score.getText());
        finalScore[1] = String.valueOf(firstRoundScore[0]) + String.valueOf(player1_score.getText());
        finalScore[3] = String.valueOf(firstRoundScore[0]) + String.valueOf(player1_score.getText());
        
        return finalScore;
    }

    
    @FXML 
    private void setPlayerTokens(String player, String token){
        if(player.equalsIgnoreCase("player1")) {
             Integer total_tokens = Integer.parseInt(player1_tokens.getText());
             total_tokens += Integer.parseInt(token);
             player1_tokens.setText(Integer.toString(total_tokens));
        } else if(player.equalsIgnoreCase("player2")){
            Integer total_tokens = Integer.parseInt(player2_tokens.getText());
            total_tokens += Integer.parseInt(token);
            player2_tokens.setText(Integer.toString(total_tokens));
        } else {
            Integer total_tokens = Integer.parseInt(player3_tokens.getText());
            total_tokens += Integer.parseInt(token);
            player3_tokens.setText(Integer.toString(total_tokens));
        }
    }
    
    
    @FXML 
    private String getPlayerScore(String player){
        
        
        if(player.equalsIgnoreCase("player1")) {
             return player1_score.getText();
        } else if(player.equalsIgnoreCase("player2")){
            return player2_score.getText();
        } else {
            return player3_score.getText();
        }
    }
    
    @FXML 
    private String getPlayerTokens(String player){
        if(player.equalsIgnoreCase("player1")) {
             return player1_tokens.getText();
        } else if(player.equalsIgnoreCase("player2")){
            return player2_tokens.getText();
        } else {
            return player3_tokens.getText();
        }
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
    
    @FXML 
    private void usedQuestionsHC(){
        for (int i = 0; i < usedQuestion.length; i++) {
            usedQuestion[i] = "false";
        }
    }
    
    @FXML 
    private void hardCodedQuestions(){
       
       //category 1, 0-4
       questionsHC[0] = "The only Constitutional amendment to be repealed, the 18th Amendment originally put this into effect";
       questionsHC[1] = "In 1964 the Warren Commission concluded that this man acted alone in killing President Kennedy";
       questionsHC[2] = "Under the Jones Act of 1917, residents of this Caribbean island gained U.S. citizenship";
       questionsHC[3] = "Introduced by Europeans, this disease that wiped out entire tribes had its last known U.S. case in 1949";
       questionsHC[4] = "Missing question cat1";
       
       //catetgory 2, 5-9
       questionsHC[5] = "Royals' singer made Time magazine's list of the most influential teens of 2013";
       questionsHC[6] = "In a collaboration with Eminem, she sings of a monster that's under her bed & voices inside her head";
       questionsHC[7] = "6 months after his death, this rock icon's Minnesota home & studio complex was open to the public for tours";
       questionsHC[8] = "He collaborated with Pitbull on 'DJ Got Us Fallin' In Love";
       questionsHC[9] = "Bey's younger sister, in 2016 she had her first No. 1 album with 'A Seat at the Table'";
       
       //category 3, 10-14
       questionsHC[10] = "By definition, it's the branch of chemistry that deals with non-carbon compounds";
       questionsHC[11] = "Hydrogen has three isotopes: protium with its nucleus made up of one proton, deuterium with one proton and one neutron, and a third radioactive isotope with an additional neutron giving it a mass number of 3; hence, this name";
       questionsHC[12] = "The Celsius temperature scale is also known as this scale because it's divided into 100 parts”, \"answer\":\"centigrade";
       questionsHC[13] = "It seems to defy gravity when a liquid goes up tubes by means of this action";
       questionsHC[14] = "The original \"handy man\" was this early human whose name means just that";
       
       //category 4, 15-19 
       questionsHC[15] = "Mary Mapes Dodge penned this guy, \"Or, The Silver skates\"; within her lifetime, the book appeared in more than 100 edition";
       questionsHC[16] = "After leaving Rochester-- the man, not the city--this Bronte title woman finds herself destitute and friendless";
       questionsHC[17] = "The daydreams of this James Thurber character include being a surgeon & the world's greatest pistol shot";
       questionsHC[18] = "'T.S. Garp cried in the airplane that was bringing him home to be famous in his violent country', penned this novelist";
       questionsHC[19] = "Though the play did not hit Broadway until 1946, ‘The Iceman Cometh’ by him first cameth in 1939";
       
       //category 5, 20-24 
       questionsHC[20] = "Brixton Metals has the stocky symbol BBB; this home essentials store got BBBY";
       questionsHC[21] = "This delivery co. says it covers ‘more than 220 countries & territories’ and links ‘more than 99% of the world's GDP’";
       questionsHC[22] = "In 2012 the founder of this office superstore told the GOP convention how Mitt Romney helped launch the company";
       questionsHC[23] = "In 1999, this shark & a pal sold their broadcast.com to Yahoo for $5.7 billion";
       questionsHC[24] = "This casual clothing company debuted its \"initial\" catalog in 1983";
       
       //category 5, 25-29
       questionsHC[25] = "The \"Star Trek\" universe: Mr. Spock's emotionless race";
       questionsHC[26] = "Bridge of Spies’: the city where the bridge is located";
       questionsHC[27] = "Michael Fassbender plays an ‘Apple’ grower: the title";
       questionsHC[28] = "'The Blind Side': the Best Actress winner";
       questionsHC[29] = "'The Martian: the director";
    }
    
    @FXML 
    private void hardCodedAnswers(){
       //category 1, 0-4
       answersHC[0] = "Prohibition";
       answersHC[1] = "Oswald";
       answersHC[2] = "Puerto Rico";
       answersHC[3] = "smallpox";
       answersHC[4] = "no answer";
       
       //catetgory 2, 5-9
       answersHC[5] = "Lorde";
       answersHC[6] = "Rihanna";
       answersHC[7] = "Prince";
       answersHC[8] = "Usher";
       answersHC[9] = "Solange";
       
       //category 3, 10-14
       answersHC[10] = "inorganic";
       answersHC[11] = "tritium";
       answersHC[12] ="centigrade";
       answersHC[13] = "capillary";
       answersHC[14] = "homo habilis";
       
       //category 4, 15-19 
       answersHC[15] = "Hans Brinker";
       answersHC[16] = "Jane Eyre";
       answersHC[17] = "Walter Mitty";
       answersHC[18] = "John Irving";
       answersHC[19] = "Eugene O’Neill";
       
       //category 5, 20-24 
       answersHC[20] = "Bed Bath and Beyond";
       answersHC[21] = "FedEx";
       answersHC[22] = "Staples";
       answersHC[23] = "Mark Cuban";
       answersHC[24] = "J. Crew";
       
       //category 6, 25-29
       answersHC[25] = "Vulcan";
       answersHC[26] = "Berlin";
       answersHC[27] = "Steve Jobs";
       answersHC[28] = "Sandra Bullock";
       answersHC[29] = "Ridley Scott";
    }
    
    private String[] getQuestionValue(String category_name) {
        String[] categories = getCategories();
        String[] returnQuestion = new String[4];
        int column_selected = 0;
        if (category_name.length() > 0){
            column_selected = Arrays.asList(categories).indexOf(category_name);
        } else {
            column_selected = 0;
        }
        
        int offset = 5;
        
        if(column_selected > 0){
            for (int k = column_selected; k < 6; k++){
                for (int i = 0; i < 5; i++) {
                    if(usedQuestion[i + k*offset].equalsIgnoreCase("false")){
                    returnQuestion[0] = categories[k];
                    returnQuestion[1] = questionsHC[i + k*offset];
                    returnQuestion[2] = answersHC[i + k*offset];
                    returnQuestion[3] = String.valueOf((i+1)*100);
                    usedQuestion[i + k*offset] = "true";
                    return returnQuestion;
                    }
                }
            }
        } else {
            for (int j = 0; j < 6; j++){
                for (int i = 0; i < 5; i++) {
                    if(usedQuestion[i + j*offset].equalsIgnoreCase("false")){
                    returnQuestion[0] = categories[j];
                    returnQuestion[1] = questionsHC[i + j*offset];
                    returnQuestion[2] = answersHC[i + j*offset];
                    returnQuestion[3] = String.valueOf((i+1)*100);
                    usedQuestion[i + j*offset] = "true";
                    return returnQuestion;
                    }
                } 
            }       
        }    

        return returnQuestion;   
    }
    
    
    //Get next player after current player finishes turn
    @FXML
    private String getNextPlayer(String currentPlayer){
        String[] players = new String[3];
        players[0] = "player1";
        players[1] = "player2";
        players[2] = "player3";
        if(currentPlayer.equalsIgnoreCase(players[0])){
            return players[1];
        } else if(currentPlayer.equalsIgnoreCase(players[1])){
            return players[2];
        } else {
            return players[0];
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
        this.controller.setupScoreBoard();
        this.scoreboard = this.controller.getScoreBoard();
        
        /*Player player1 = this.scoreboard.getPlayerNumber(1);
        Player player2 = this.scoreboard.getPlayerNumber(2);
        Player player3 = this.scoreboard.getPlayerNumber(3);
        player1_tokens.setText("" + player1.getNumberOfTokens());
        player2_tokens.setText("" + player2.getNumberOfTokens());
        player3_tokens.setText("" +player3.getNumberOfTokens());
        player1_score.setText("" +player1.getScore());
        player2_score.setText("" + player1.getScore());
        player3_score.setText("" + player1.getScore());
        */
        this.updatePlayerStats();
        
        setGameStatsVisible(true);
        setPlayerStatsVisible(true);
        
        populateGameStats("1", getCategories());
        setGamePlayVisible(true);
        spin_wheel_image.setVisible(true);
        spin_wheel_button.setVisible(true);
        spin_wheel_button.setDisable(false);
        game_play.toFront();
        this.controller.startGame();

       // gamePlay(2, "player1", "0", false);
    }
    
    
    //Handle Spin Wheel action
    @FXML
    private void handleSpinWheelAction(ActionEvent event) {
        WheelSector theWheelSector = this.controller.spin();
        /**
        Random randomGen = new Random();
        int randomNum = randomGen.nextInt((7 - 1) + 1) + 1;
        gamePlay(randomNum, player_identifier.getText(), "0", false);
        **/
        gamePlay(theWheelSector);
    }
    
    //Handle Player Submit button action
    @FXML
    private void handlePlayerSubmitAction(ActionEvent event) {
        player_submit_button.setVisible(false);
        player_answer.setDisable(true);
        
        if (!player_answer.getText().equalsIgnoreCase(correct_answer.getText())){
            free_spin_type = 1;
            if(checkForToken()){
                populateUseToken();
            } else {
                setAnswerResultsIncorrectVisible(true);
            }
        } else {
            populateAnswerCorrect();
        }
    }
        
    @FXML
    private void handleCorrectAnswerContinueAction(ActionEvent event){
        highlightCategoryTable(category_title.getText(), false);
        updateCategoryTable(round_value.getText(), category_title.getText(), question_value.getText());
        player_answer.setText("");
        correct_answer.setText("");
        player_answer.setDisable(false);
        this.scoreboard.addPointsForPlayer(this.controller.getCurrentPlayer(), Integer.parseInt(question_value.getText()));
        this.updatePlayerStats();
        /**
        free_spin_type = 2;
        if(checkForToken()){
            populateUseToken();
        } else {
            Random randomGen = new Random();
            int randomNum = randomGen.nextInt((7 - 1) + 1) + 1;
            gamePlay(randomNum, player_identifier.getText(), "0", false);
        }
        * **/
    }
    
    //Handle Correct Answer Override button action    
    @FXML
    private void handleCorrectOverrideSubmitAction(ActionEvent event) {
        highlightCategoryTable(category_title.getText(), false);
        updateCategoryTable(round_value.getText(), category_title.getText(), question_value.getText());
        player_answer.setText("");
        correct_answer.setText("");
        player_answer.setDisable(false);
        this.controller.addPointsForCurrentPlayer(Integer.parseInt(question_value.getText()));
        this.updatePlayerStats();
        //setPlayerScore(player_identifier.getText(), question_value.getText());
        /**free_spin_type = 2;
        if(checkForToken()){
            populateUseToken();
        } else {
            Random randomGen = new Random();
            int randomNum = randomGen.nextInt((7 - 1) + 1) + 1;
            gamePlay(randomNum, player_identifier.getText(), "0", false);
        }
        * **/
    }
    
    //Handle Incorrect Answer Override button action
    @FXML
    private void handleIncorrectOverrideSubmitAction(ActionEvent event) {
        highlightCategoryTable(category_title.getText(), false);
        updateCategoryTable(round_value.getText(), category_title.getText(), question_value.getText());
        player_answer.setText("");
        correct_answer.setText("");
        player_answer.setDisable(false);
        free_spin_type = 2;
        this.controller.subtractPointsForCurrentPlayer(Integer.parseInt(question_value.getText()));
        this.updatePlayerStats();
        //String negativeScore = "-" + question_value.getText();
        //setPlayerScore(player_identifier.getText(), negativeScore);
        if(checkForToken()){
            populateUseToken();
        } 
        /**
         * else {
            Random randomGen = new Random();
            int randomNum = randomGen.nextInt((7 - 1) + 1) + 1;
            gamePlay(randomNum, player_identifier.getText(), "0", false);
        }
        * **/
    }
    
    //Handle using a token yes action
    @FXML
    private void handleUseTokenSubmitAction(ActionEvent event) {
        this.controller.useTokenForCurrentPlayer();
        /*
        String player = player_identifier.getText();
        Random randomGen = new Random();
        int randomNum = randomGen.nextInt((7 - 1) + 1) + 1;
        
        if(free_spin_type == 1){
            String questionContent = question_content.getText();
            String categoryTitle = category_title.getText();
            String answerContent = correct_answer.getText();
            String pointValue = question_value.getText();
            setPlayerTokens(player, "-1");
            populateQuestion(player, categoryTitle, questionContent, answerContent, pointValue);
            player_answer.setDisable(false);
        } else if(free_spin_type == 2){
            setPlayerTokens(player, "-1");
            gamePlay(randomNum, player_identifier.getText(), "0", true);
        } else if(free_spin_type == 3){
            setPlayerTokens(player, "-1");
            gamePlay(randomNum, player_identifier.getText(), "0", true);
        }
        */
       
    }
    
    //Handle using a token no action
    @FXML
    private void handleNoUseTokenSubmitAction(ActionEvent event) {
        this.controller.loseATurn();
        /**
        String player = player_identifier.getText();
        if(free_spin_type == 1){
            String questionContent = question_content.getText();
            String categoryTitle = category_title.getText();
            String answerContent = correct_answer.getText();
            String pointValue = question_value.getText();
            populateQuestion(player, categoryTitle, questionContent, answerContent, pointValue);
            player_answer.setDisable(true);
            player_submit_button.setVisible(false);
            setAnswerResultsIncorrectVisible(true);
        } else {
            Random randomGen = new Random();
            int randomNum = randomGen.nextInt((7 - 1) + 1) + 1;
            gamePlay(randomNum, player_identifier.getText(), "0", false);
        }
        * **/
    }
    
    //Handle player's choice
    @FXML
    private void handlePlayerChoiceSubmitAction(ActionEvent event) {
        String category_selected = "";
        if(!category_box_player.getSelectionModel().isEmpty()){
            category_box_player.getSelectionModel().getSelectedItem().toString();
        }
        
        String[] categories = getCategories();
        for (String s: categories) { 
            category_box_player.getItems().remove(s);
        }
        category_box_player.setValue("");
        
        CategorySector theCategorySector = new CategorySector(categories[0]);
        
        gamePlay(theCategorySector);
    }
    
    //Handle opponent's choice
    @FXML
    private void handleOpponentChoiceSubmitAction(ActionEvent event) {
        String category_selected = "";
        if(!category_box_opponent.getSelectionModel().isEmpty()){
            category_box_opponent.getSelectionModel().getSelectedItem().toString();
        }

        String[] categories = getCategories();
        for (String s: categories) { 
            category_box_opponent.getItems().remove(s);
        }
        category_box_opponent.setValue("");
        CategorySector theCategorySector = new CategorySector(categories[0]);
        
        gamePlay(theCategorySector);
        //gamePlay(7, player_identifier.getText(), category_selected, false);
    }
    
    //Handle bankruptcy submit action
    @FXML
    private void handleBankruptyContinueAction(ActionEvent event) {
        this.controller.bankruptCurrentPlayer();
        /*Integer total_score = Integer.parseInt(getPlayerScore(player_identifier.getText()));
        total_score = -total_score;
        
        Integer total_tokens = Integer.parseInt(getPlayerTokens(player_identifier.getText()));
        total_tokens = -total_tokens;
        
        setPlayerScore(player_identifier.getText(), String.valueOf(total_score));
        setPlayerTokens(player_identifier.getText(), String.valueOf(total_tokens));
        Random randomGen = new Random();
        int randomNum = randomGen.nextInt(9);
                */
        //setPlayerScore(this.controller.getCurrentPlayer(), String.valueOf(total_score));
        //setPlayerTokens(player_identifier.getText(), String.valueOf(total_tokens));
        this.updatePlayerStats();
        this.controller.loseATurn();
        //gamePlay(randomNum, player_identifier.getText(), "0", false);
    }
    
    //Handle lose turn submit action
    @FXML
    private void handleLoseTurnContinueAction(ActionEvent event) {
        if (checkForToken()){
            populateUseToken();
        }
        else{
            this.controller.loseATurn();
            //theCurrentPlayer = this.controller.getCurrentPlayer();
        }
        
        /*
        if(checkForToken(player_identifier.getText())){
            free_spin_type = 3;
            populateUseToken(player_identifier.getText());
        } else {
            Random randomGen = new Random();
            int randomNum = randomGen.nextInt(9);
            gamePlay(randomNum, player_identifier.getText(), "0", false);
        }
        */
    }
    
   //Handle spin again continue action
    @FXML
    private void handleSpinAgainContinueAction(ActionEvent event) {
        WheelSector theWheelSector = this.controller.spin();
        //Random randomGen = new Random();
        //int randomNum = randomGen.nextInt(9);
        //gamePlay(randomNum, player_identifier.getText(), "", false);
    }
    
    @FXML
    public boolean checkForToken(){
        return (this.controller.getCurrentPlayer().getNumberOfTokens() >= 1);
    }
    //Sector data population
    @FXML
    public void populateQuestion(String categoryTitle, String questionContent, String answerContent, String pointValue){
        setSectorsInvisible();
        sector_question.toFront();
        question_value.setText(pointValue);
        player_identifier.setText(this.controller.getCurrentPlayer().getName());
        category_title.setText(categoryTitle);
        question_content.setText(questionContent);
        correct_answer.setText(answerContent);
        highlightCategoryTable(categoryTitle, true);
        player_submit_button.setVisible(true);
        correct_answer.setEditable(false);
        setSectorQuestionVisible(true);
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
        this.updateGameStats();
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
        String[] categories = getCategories();
        setSectorsInvisible();
        sector_player_choice.toFront();
        player_identifier.setText(theCurrentPlayer.getName());
        for (String s: categories) { 
            category_box_player.getItems().add(s);
        }
        setSectorPlayerChoiceVisible(true);
    }
    
    public void populateOpponentChoice(){
        Player theOpponent = this.controller.getOpponent();
        String[] categories = getCategories();
        setSectorsInvisible();
        sector_opponent_choice.toFront();
        opponent_identifier.setText(theOpponent.getName());
        for (String s: categories) { 
            category_box_opponent.getItems().add(s);
        }
        setSectorOpponentChoiceVisible(true);
    }

    public void populateUseToken(){
        setSectorsInvisible();
        player_use_token.toFront();
        player_identifier.setText(this.controller.getCurrentPlayer().getName());
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
    
    public void updateCategoryTable(String round, String category, String points){
        //Remove category point value cell value
        int column_position = 0;
        int row_position = 0;
        if(category.equalsIgnoreCase(category1_label.getText())){
            column_position = 0;
        } else if(category.equalsIgnoreCase(category2_label.getText())){
            column_position = 1;
        } else if(category.equalsIgnoreCase(category3_label.getText())){
            column_position = 2;
        } else if(category.equalsIgnoreCase(category4_label.getText())){
            column_position = 3;
        } else if(category.equalsIgnoreCase(category5_label.getText())){
            column_position = 4;   
        } else if(category.equalsIgnoreCase(category6_label.getText())){
            column_position = 5;   
        } 

        //Round 1
        if (round.equalsIgnoreCase("1")){
            if (points.equalsIgnoreCase("100")){
                row_position = 0;
            } else if (points.equalsIgnoreCase("200")){
                row_position = 1;
            } else if (points.equalsIgnoreCase("300")){
                row_position = 2;
            } else if (points.equalsIgnoreCase("400")){
                row_position = 3;
            } else if (points.equalsIgnoreCase("500")){
                row_position = 4;
            }
        } else {
            if (points.equalsIgnoreCase("200")){
                row_position = 0;
            } else if (points.equalsIgnoreCase("400")){
                row_position = 1;
            } else if (points.equalsIgnoreCase("600")){
                row_position = 2;
            } else if (points.equalsIgnoreCase("800")){
                row_position = 3;
            } else if (points.equalsIgnoreCase("1000")){
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
       //lookup Java string comparisons
       /* if(player.equalsIgnoreCase(player1_label.getText())){
            player1_score.setText(points);
            player1_tokens.setText(tokens);
        } else if (player.equalsIgnoreCase(player2_label.getText())){
            player2_score.setText(points);
            player2_tokens.setText(tokens);
        } else {
            player3_score.setText(points);
            player3_tokens.setText(tokens);    
        }
               */
    }
        
    private ObservableList getInitialTableData(String round) {
        if(round.equalsIgnoreCase("1")){
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
        hardCodedAnswers();
        hardCodedQuestions();
        usedQuestionsHC();
    } 
    
    //Main controller
    public void gamePlay(WheelSector theWheelSector){
        spin_count--;
        setSpinCounter(Integer.toString(spin_count));
        if(spin_count == 0){
            if(round_value.getText().equalsIgnoreCase("1")){
                setRound("2");
                spin_count = 10;
                setSpinCounter(Integer.toString(spin_count));
            } else if (round_value.getText().equalsIgnoreCase("2")){
                //trigger game end
            }
        } else {
            //if(!useFreeToken){
                //player = getNextPlayer(player);
            //}

       
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
                    String[] questionValue = getQuestionValue(theWheelSector.getName());
                    populateQuestion(questionValue[0], questionValue[1], questionValue[2], questionValue[3]);
                }
            }
        }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
} 
     
    

