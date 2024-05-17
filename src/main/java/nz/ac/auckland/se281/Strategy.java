
package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

/**
 * A method for AI to make a move and get a number.
 */
public interface Strategy {
  public int getNumber(List<Choice> history, Choice choice);
}