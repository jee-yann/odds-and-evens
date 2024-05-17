
package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;


public interface Strategy {
  public int getNumber(List<Choice> history, Choice choice);
}