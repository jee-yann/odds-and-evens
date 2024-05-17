
package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

/**
 * Medium difficulty AI that samples the first few user moves then
 * switches to top strategy after 3 rounds.
 */
public class MediumAi extends Ai {
  public MediumAi(Choice choice) {
    super(new RandomStrategy(), choice);
  }

  @Override
  public int getMove(List<Choice> history, String winner) {

    // Check if it's round 4, if so, switch from random strategy to top strategy.
    if (this.getRounds() == 4) {
      this.setStrategy(new TopStrategy());
    }
    incrementRounds();
    return this.getStrategy().getNumber(history, this.getChoice());
  }
}