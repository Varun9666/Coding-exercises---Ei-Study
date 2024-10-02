package creational;

class Singleton {
    private static Singleton instance;

    private Singleton() { }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Singleton Instance Accessed!");
    }
}

public class SingletonPattern {
    public static void execute() {
        Singleton singleton = Singleton.getInstance();
        singleton.showMessage();
    }
}
