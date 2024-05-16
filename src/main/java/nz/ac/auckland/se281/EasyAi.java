

package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class EasyAi extends Ai {
  public EasyAi(Choice choice) {
    super(new RandomStrategy(), choice);
  }
}