
package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import java.util.List;
import java.util.ArrayList;

public abstract class AI {
  private Strategy strategy;
  private Choice choice;
  private int rounds;

  public AI(Strategy strategy, Choice choice) {
    this.strategy = strategy;
    this.choice = choice;
    this.rounds = 0;
  }

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }
  
  public int getMove(List<Choice> history, String winner) {
    return this.strategy.getNumber(history, choice);
  }
}