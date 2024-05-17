
package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;
import nz.ac.auckland.se281.Main.Choice;

/**
 * Factory OOP design where AI's of different difficulties can be created.
 */
public class AiFactory {

  /**
   * Creates the AI with the specific difficulty setting the user specified.
   * 
   * @param difficulty difficulty in which the AI must be made with.
   * @param choice whether the AI needs odd or even to win.
   * 
   */
  public static Ai createAi(Difficulty difficulty, Choice choice) {

    switch(difficulty) {
      case EASY:
        return new EasyAi(choice);
      case MEDIUM:
        return new MediumAi(choice);
      case HARD:
        return new HardAi(choice);
      default:
        return null;
    }
  }
}