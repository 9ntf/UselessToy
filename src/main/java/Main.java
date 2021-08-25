import toy.Toy;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Toy toy = new Toy();

        Thread userThread = new Thread(null,toy::turnOn, "User");
        Thread toyThread = new Thread(null,toy::turnOff, "Toy");

        userThread.start();
        toyThread.start();

        userThread.join();
        toyThread.interrupt();
    }
}
