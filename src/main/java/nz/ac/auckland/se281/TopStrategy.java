
package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import java.util.List;


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
    if (count > (int) history.size() / 2) {
      return Utils.getRandomOddNumber();
    } else if (count < (int) history.size() / 2) {
      return Utils.getRandomEvenNumber();
    } else {
      return Utils.getRandomNumberRange(0, 5);
    }
    
  }
}