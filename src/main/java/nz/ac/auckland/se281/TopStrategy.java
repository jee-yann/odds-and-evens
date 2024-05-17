
package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

/**
 * Represents a strategy in which a decision is based on the history of the
 * opponent's moves and what they are most likely to do.
 */
public class TopStrategy implements Strategy {


  @Override
  public int getNumber(List<Choice> history, Choice choice) {
    int count = 0;

    // Count how many times the bot and human have the same choices.
    for (Choice round : history) {
      if (round == choice) {
        count++;
      }
    }

    // Return appropriate number.
    if (count > ((double) history.size() / 2.0)) {
      return Utils.getRandomOddNumber();
    } else if (count < ((double) history.size() / 2.0)) {
      return Utils.getRandomEvenNumber();
    } else {
      return Utils.getRandomNumberRange(0, 5);
    }
    
  }
}