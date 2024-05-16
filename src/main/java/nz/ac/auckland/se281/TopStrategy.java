
package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import java.util.List;
import java.util.ArrayList;

public class TopStrategy implements Strategy {


  @Override
  public int getNumber(List<Choice> history, Choice choice) {


    Choice oppositeChoice;


    int count = 0;
    for (Choice round : history) {
      if (round == choice) {
        count++;
      }
    }

    if (count > (int) history.size() / 2) {
      return Utils.getRandomEvenNumber();
    } else if (count < (int) history.size() / 2) {
      return Utils.getRandomOddNumber();
    } else {
      return Utils.getRandomNumberRange(0, 5);
    }
    
  }
}