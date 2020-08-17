package Duck;

import FlyBehavior.CannotFly;
import QuackBehavior.CannotQuack;

public class RubberDuck extends Duck {
    public RubberDuck() {
        this.flyBehavior = new CannotFly();
        this.quackBehavior = new CannotQuack();
    }

    public String myName() {
        return "My name is RubberDuck.";
    }

    public String color() {
        return "Yellow";
    }
}
