package Duck;

import FlyBehavior.CanFly;
import QuackBehavior.CanQuack;

public class WhiteDuck extends Duck {
    public WhiteDuck() {
        this.flyBehavior = new CanFly();
        this.quackBehavior = new CanQuack();
    }

    public String myName() {
        return "White Duck";
    }

    public String color() {
        return "I'm white";
    }
}
