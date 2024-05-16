
package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;
import nz.ac.auckland.se281.Main.Choice;

public class AiFactory {
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