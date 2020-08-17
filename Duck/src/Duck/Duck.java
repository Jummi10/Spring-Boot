package Duck;

import FlyBehavior.FlyBehavior;
import QuackBehavior.QuackBehavior;

public abstract class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public void fly() {
        this.flyBehavior.doFlyActivity();
    }

    public void quack() {
        this.quackBehavior.doQuackActivity();
    }

    public abstract String myName();

    public abstract String color();
}
