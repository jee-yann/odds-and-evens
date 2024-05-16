package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;
import java.util.List;
import java.util.ArrayList;

/** This class represents the Game is the main entry point. */
public class Game {
  
  private String name;
  private int round;
  private Choice choice;
  private AI opponent;
  List<Choice> history = new ArrayList<>();

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    this.name = options[0];
    this.round = 1;
    this.choice = choice;
    AI ai = AIFactory.createAI(difficulty, choice);
    this.opponent = ai;
    history.clear();
  }

  public void play() {
    

    MessageCli.START_ROUND.printMessage(Integer.toString(this.round));
    MessageCli.ASK_INPUT.printMessage();
    String input = Utils.scanner.nextLine();
    while (!(Utils.isInteger(input)) || (Integer.parseInt(input) < 0 || Integer.parseInt(input) > 5)) {
      MessageCli.INVALID_INPUT.printMessage();
      MessageCli.ASK_INPUT.printMessage();
      input = Utils.scanner.nextLine();
    }
    int humanMove = Integer.parseInt(input);
    
    int aiMove = opponent.getMove(history); // CHECK THIS OPPO
    String aiName = "HAL-9000";

    MessageCli.PRINT_INFO_HAND.printMessage(this.name, input);
    MessageCli.PRINT_INFO_HAND.printMessage(aiName, Integer.toString(aiMove));


    int sum = humanMove + aiMove;
    String winner;
    if ((Utils.isEven(sum) && choice == Choice.EVEN) || 
        (Utils.isOdd(sum) && choice == Choice.ODD)) {
      winner = this.name;
    } else {
      winner = aiName;
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

  public void endGame() {}

  public void showStats() {}
}
