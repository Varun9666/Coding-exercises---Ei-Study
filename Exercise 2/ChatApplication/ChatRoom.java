package ChatApplication;
import java.util.ArrayList;
import java.util.List;

public class ChatRoom implements Subject {
    private String roomId;
    private List<Observer> observers;
    private List<String> messageHistory;
    private List<String> activeUsers;

    public ChatRoom(String roomId) {
        this.roomId = roomId;
        observers = new ArrayList<>();
        messageHistory = new ArrayList<>();
        activeUsers = new ArrayList<>();
    }

    public String getRoomId() {
        return roomId;
    }

    public List<String> getMessageHistory() {
        return messageHistory;
    }

    public List<String> getActiveUsers() {
        return activeUsers;
    }

    public void addUser(User user) {
        registerObserver(user);
        activeUsers.add(user.getUsername());
        String joinMessage = user.getUsername() + " has joined the chat.";
        messageHistory.add(joinMessage);
        notifyObservers(joinMessage);
    }

    public void removeUser(User user) {
        removeObserver(user);
        activeUsers.remove(user.getUsername());
        String leaveMessage = user.getUsername() + " has left the chat.";
        messageHistory.add(leaveMessage);
        notifyObservers(leaveMessage);
    }

    public void sendMessage(String message, User user) {
        String formattedMessage = user.getUsername() + ": " + message;
        messageHistory.add(formattedMessage);
        notifyObservers(formattedMessage);
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer o : observers) {
            o.update(message);
        }
    }
}