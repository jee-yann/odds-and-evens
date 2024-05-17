
package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

public class RandomStrategy implements Strategy {
  @Override
  public int getNumber(List<Choice> history, Choice choice) {
    return Utils.getRandomNumberRange(0, 5);
  }
}