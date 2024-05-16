

package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class EasyAI extends AI {
  public EasyAI(Choice choice) {
    super(new RandomStrategy(), choice);
  }
}