
package nz.ac.auckland.se281;

public abstract class AI {
  public Strategy strategy;

  public AI(Strategy strategy) {
    this.strategy = strategy;
  }

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }
  
  public int getMove() {
    return this.strategy.getNumber();
  }
}