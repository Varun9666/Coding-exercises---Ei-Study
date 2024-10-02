package ChatApplication;

import java.util.Scanner;

public class ConsoleCommunicationAdapter implements CommunicationAdapter {
    private Scanner scanner;

    public ConsoleCommunicationAdapter() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void send(String message) {
        System.out.println(message);
    }

    @Override
    public String receive() {
        return scanner.nextLine();
    }
}