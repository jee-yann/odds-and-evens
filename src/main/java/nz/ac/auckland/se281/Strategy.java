
package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import java.util.List;
import java.util.ArrayList;

public interface Strategy {
  public int getNumber(List<Choice> history, Choice choice);
}