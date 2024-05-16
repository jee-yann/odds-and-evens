package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  
  private String name;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    this.name = options[0];
  }

  public void play() {
    MessageCli.START_ROUND.printMessage("1");
    MessageCli.ASK_INPUT.printMessage();
    String input = Utils.scanner.nextLine();
    MessageCli.PRINT_INFO_HAND.printMessage(this.name, input);
  }

  public void endGame() {}

  public void showStats() {}
}
