package toy;

import java.util.Random;


public class Toy {
    private static final int MAX = 6000;
    private static final int MIN = 1000;
    private static final int ITTER = 5;
    private volatile boolean tumbler = false;

    private Random random = new Random();

    public void turnOff() {
        while (!Thread.currentThread().isInterrupted()) {
            if (tumbler) {
                tumbler = false;
                System.out.println("Игрушка выключила тумблер");
            }
        }
    }

    public void turnOn() {
        for (int i = 0; i < ITTER; i++) {
            if (!tumbler) {
                tumbler = true;
                System.out.printf("%s включил тумблер\n", Thread.currentThread().getName());
                sleep();
            }
        }
    }

    private void sleep() {
        try {
            Thread.sleep(random.nextInt(MAX - MIN) + MIN);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
