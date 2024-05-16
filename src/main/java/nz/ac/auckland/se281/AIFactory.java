
package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;
import nz.ac.auckland.se281.Main.Choice;

public class AIFactory {
  public static AI createAI(Difficulty difficulty, Choice choice) {

    switch(difficulty) {
      case EASY:
        return new EasyAI(choice);
      default:
        return null;
    }
  }
}