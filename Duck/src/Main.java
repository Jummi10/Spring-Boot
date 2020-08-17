import Duck.Duck;
import Duck.RubberDuck;
import Duck.ToyDuck;
import Duck.WhiteDuck;

public class Main {
    public static void main(String[] args) {
        Duck rubberDuck = new RubberDuck();
        Duck toyDuck = new ToyDuck();
        Duck whiteDuck = new WhiteDuck();

        rubberDuck.fly();
        rubberDuck.quack();
        System.out.println(rubberDuck.myName());
        System.out.println();

        toyDuck.fly();
        System.out.println(whiteDuck.color());
    }
}
