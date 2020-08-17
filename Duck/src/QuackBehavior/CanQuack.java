package QuackBehavior;

public class CanQuack implements QuackBehavior {
    @Override
    public void doQuackActivity() {
        System.out.println("Quack Quack");
    }
}
