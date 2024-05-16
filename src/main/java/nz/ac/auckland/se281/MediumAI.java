

package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import java.util.List;
import java.util.ArrayList;

public class MediumAI extends AI {
  public MediumAI(Choice choice) {
    super(new RandomStrategy(), choice);
  }

  @Override
  public int getMove(List<Choice> history) {

    // Check if round 3, if so, switch from random strategy to top strategy.
    if (rounds == 3) {
      this.setStrategy(new TopStrategy());
    }
    rounds++;
    return this.strategy.getNumber(history, this.choice);
  }
}