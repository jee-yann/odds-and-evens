

package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import java.util.List;
import java.util.ArrayList;

public class HardAi extends Ai {
  public HardAi(Choice choice) {
    super(new RandomStrategy(), choice);
  }

  @Override
  public int getMove(List<Choice> history, String winner) {

    // Check if round 3 or above, if so, start cycling strategies.
    if (this.getRounds() >= 3) {
      if (winner != "HAL-9000" && winner != "") {
        if (this.getStrategy() instanceof RandomStrategy) {
          this.setStrategy(new TopStrategy());
        } else {
          this.setStrategy(new RandomStrategy());
        }
      }
    }
    incrementRounds();
    return this.getStrategy().getNumber(history, this.getChoice());
  }
}