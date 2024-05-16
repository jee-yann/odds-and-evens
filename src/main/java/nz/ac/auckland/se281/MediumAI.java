

package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import java.util.List;
import java.util.ArrayList;

public class MediumAI extends AI {
  public MediumAI(Choice choice) {
    super(new TopStrategy(), choice);
  }

  @Override
  public int getMove(List<Choice> history) {
    return this.strategy.getNumber(history, this.choice);
  }
}