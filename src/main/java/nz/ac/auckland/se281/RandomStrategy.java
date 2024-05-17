
package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

/**
 * Simple strategy in which a random number is generated to be played.
 */
public class RandomStrategy implements Strategy {
  @Override
  public int getNumber(List<Choice> history, Choice choice) {
    return Utils.getRandomNumberRange(0, 5);
  }
}