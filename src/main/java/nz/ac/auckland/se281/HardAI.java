

package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import java.util.List;
import java.util.ArrayList;

public class HardAI extends AI {
  public HardAI(Choice choice) {
    super(new RandomStrategy(), choice);
  }

  @Override
  public int getMove(List<Choice> history, String winner) {

    // Check if round 3 or above, if so, start cycling strategies.
    if (rounds >= 3) {
      if (winner != "HAL-9000" && winner != "") {
        if (this.strategy instanceof RandomStrategy) {
          this.setStrategy(new TopStrategy());
        } else {
          this.setStrategy(new RandomStrategy());
        }
      }
    }
    rounds++;
    return this.strategy.getNumber(history, this.choice);
  }
}