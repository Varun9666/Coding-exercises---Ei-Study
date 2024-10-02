package ChatApplication;

public interface CommunicationAdapter {
    void send(String message);
    String receive();
}