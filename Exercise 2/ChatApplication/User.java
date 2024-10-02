package ChatApplication;

public class User implements Observer {
 private String username;
 protected ChatRoom chatRoom;
 private CommunicationAdapter adapter;

 public User(String username, CommunicationAdapter adapter) {
     this.username = username;
     this.adapter = adapter;
 }

 public void joinRoom(ChatRoom chatRoom) {
     if (this.chatRoom != null) {
         leaveRoom();
     }
     this.chatRoom = chatRoom;
     chatRoom.addUser(this);
 }

 public void leaveRoom() {
     if (chatRoom != null) {
         chatRoom.removeUser(this);
         chatRoom = null;
     }
 }

 public void sendMessage() {
     if (chatRoom != null) {
         adapter.send("Enter message: ");
         String message = adapter.receive();
         chatRoom.sendMessage(message, this);
     } else {
         adapter.send("You are not in a chat room.");
     }
 }

 public void viewMessageHistory() {
     if (chatRoom != null) {
         adapter.send("Message History for room " + chatRoom.getRoomId() + ":");
         for (String msg : chatRoom.getMessageHistory()) {
             adapter.send(msg);
         }
     } else {
         adapter.send("You are not in a chat room.");
     }
 }

 public String getUsername() {
     return username;
 }

 @Override
 public void update(String message) {
     adapter.send(message);
 }
}