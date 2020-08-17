package Duck;

import FlyBehavior.CanFly;
import FlyBehavior.CannotFly;
import QuackBehavior.CanQuack;

public class ToyDuck extends Duck {
    public ToyDuck() {
        quackBehavior = new CanQuack();
    }

    @Override
    public void fly() {
        this.flyBehavior = new CanFly();
        flyBehavior.doFlyActivity();
    }

    public String myName() {
        return "I'm toy duck.";
    }

    public String color() {
        return "Whatever";
    }
}
