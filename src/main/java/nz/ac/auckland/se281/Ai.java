
package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

/**
 * A CPU player that makes moves and can have adjusted difficulties.
 */
public abstract class Ai {
  private Strategy strategy;
  private Choice choice;
  private int rounds;

  /**
   * Constructs a new AI with specified strategy and winning choice
   * 
   * @param strategy strategy to be used by the AI
   * @param choice choice in whether the AI needs EVEN or ODD to win.
   */
  public Ai(Strategy strategy, Choice choice) {
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

  public int getRounds() {
    return this.rounds;
  }

  public void incrementRounds() {
    rounds++;
  }

  public Choice getChoice() {
    return this.choice;
  }

  public Strategy getStrategy() {
    return this.strategy;
  }
}