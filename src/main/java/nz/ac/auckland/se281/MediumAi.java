
package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import java.util.List;

public class MediumAi extends Ai {
  public MediumAi(Choice choice) {
    super(new RandomStrategy(), choice);
  }

  @Override
  public int getMove(List<Choice> history, String winner) {

    // Check if round 3, if so, switch from random strategy to top strategy.
    if (this.getRounds() == 3) {
      this.setStrategy(new TopStrategy());
    }
    incrementRounds();
    return this.getStrategy().getNumber(history, this.getChoice());
  }
}