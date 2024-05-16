package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  
  private String name;
  private int round = 1;
  private Difficulty difficulty;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    this.name = options[0];
    this.difficulty = difficulty;
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
    
    AI ai = AIFactory.createAI(difficulty);
    
    MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", Integer.toString(ai.getMove()));


    MessageCli.PRINT_INFO_HAND.printMessage(this.name, input);

    round++;

  }

  public void endGame() {}

  public void showStats() {}
}
