

package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

/**
 * Simple AI that picks a number at random to play.
 */
public class EasyAi extends Ai {
  public EasyAi(Choice choice) {
    super(new RandomStrategy(), choice);
  }
}