package FlyBehavior;

public class CannotFly implements FlyBehavior {
    @Override
    public void doFlyActivity() {
        System.out.println("I cannot fly..");
    }
}
