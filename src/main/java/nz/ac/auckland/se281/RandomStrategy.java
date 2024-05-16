
package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import java.util.List;
import java.util.ArrayList;

public class RandomStrategy implements Strategy {
  @Override
  public int getNumber(List<Choice> history, Choice choice) {
    return Utils.getRandomNumberRange(0, 5);
  }
}