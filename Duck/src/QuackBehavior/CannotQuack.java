package QuackBehavior;

public class CannotQuack implements QuackBehavior {
    @Override
    public void doQuackActivity() {
        System.out.println("...");
    }
}
