package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;
import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  
  private String name;
  private int round;
  private Choice choice;
  private Ai opponent;
  private String winner;
  private int playerWins;
  private int aiWins;
  private List<Choice> history = new ArrayList<>();

  /**
   * Method newGame creates a new game against a certain instance of AI while making sure all
   * running statistics from the previous game is wiped.
   */
  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    this.name = options[0];
    this.round = 1;
    this.choice = choice;
    Ai ai = AiFactory.createAi(difficulty, choice);
    this.opponent = ai;
    this.playerWins = 0;
    this.aiWins = 0;
    history.clear();
  }

  /**
   * Method play simulates a round of the odd or even game against the AI.
   */
  public void play() {
    // Check if a name has been inputted which signals a runing game.
    if (this.name == null) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    MessageCli.START_ROUND.printMessage(Integer.toString(this.round));
    MessageCli.ASK_INPUT.printMessage();
    String input = Utils.scanner.nextLine();
    while (!(Utils.isInteger(input)) || (Integer.parseInt(input) < 0 || Integer.parseInt(input) > 5)) {
      MessageCli.INVALID_INPUT.printMessage();
      MessageCli.ASK_INPUT.printMessage();
      input = Utils.scanner.nextLine();
    }
    int humanMove = Integer.parseInt(input);
    
    int aiMove = opponent.getMove(history, winner);
    String aiName = "HAL-9000";

    MessageCli.PRINT_INFO_HAND.printMessage(this.name, input);
    MessageCli.PRINT_INFO_HAND.printMessage(aiName, Integer.toString(aiMove));


    int sum = humanMove + aiMove;
    if ((Utils.isEven(sum) && choice == Choice.EVEN) || 
        (Utils.isOdd(sum) && choice == Choice.ODD)) {
      this.winner = this.name;
      playerWins++;
    } else {
      this.winner = aiName;
      aiWins++;
    }

    String evenOrOdd;
    if (Utils.isOdd(sum)) {
      evenOrOdd = "ODD";
    } else {
      evenOrOdd = "EVEN";
    }


    // Adding to history.
    if (Utils.isEven(humanMove)) {
      history.add(Choice.EVEN);
    } else {
      history.add (Choice.ODD);
    }


    MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(sum), evenOrOdd, winner);
    round++;
  }

  /**
   * Method endGame ends the current game that the user is on and resets and running statistic.
   */
  public void endGame() {
    this.showStats();

    // Print the appropriate message depending on who won.
    if (playerWins > aiWins) {
      MessageCli.PRINT_END_GAME.printMessage(this.name);
    } else if (playerWins < aiWins) {
      MessageCli.PRINT_END_GAME.printMessage("HAL-9000");
    } else {
      MessageCli.PRINT_END_GAME_TIE.printMessage();
    }

    // Reset name to null to signal end of game.
    this.name = null;
  }

  /**
   * method showStats outputs the current stats of the round to the user.
   */
  public void showStats() {
    if (this.name == null) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }
    MessageCli.PRINT_PLAYER_WINS.printMessage(this.name, Integer.toString(this.playerWins), Integer.toString(this.aiWins));
    MessageCli.PRINT_PLAYER_WINS.printMessage("HAL-9000", Integer.toString(this.aiWins), Integer.toString(this.playerWins));
  }
}
