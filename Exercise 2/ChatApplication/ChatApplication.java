package ChatApplication;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ChatApplication {
 public static void main(String[] args) {
     CommunicationAdapter adapter = new ConsoleCommunicationAdapter();
     Scanner scanner = new Scanner(System.in);
     ChatRoomManager manager = ChatRoomManager.getInstance();
     Map<String, User> users = new HashMap<>();
     while (true) {
         adapter.send("\nMenu:");
         adapter.send("1. Create User");
         adapter.send("2. Create Chat Room");
         adapter.send("3. Join Chat Room");
         adapter.send("4. Send Message");
         adapter.send("5. View Active Users");
         adapter.send("6. View Message History");
         adapter.send("7. Leave Chat Room");
         adapter.send("8. Exit");

         adapter.send("Select an option: ");
         String choice = scanner.nextLine();

         switch (choice) {
             case "1":
                 adapter.send("Enter your username: ");
                 String username = scanner.nextLine();
                 if (users.containsKey(username)) {
                     adapter.send("Username already exists. Please choose another one.");
                 } else {
                     User user = new User(username, new ConsoleCommunicationAdapter());
                     users.put(username, user);
                     adapter.send("User " + username + " created.");
                 }
                 break;
             case "2":
                 adapter.send("Enter your username: ");
                 username = scanner.nextLine();
                 User user = users.get(username);
                 if (user == null) {
                     adapter.send("User does not exist. Please create a user first.");
                     break;
                 }
                 adapter.send("Enter new chat room ID: ");
                 String newRoomId = scanner.nextLine();
                 if (manager.chatRoomExists(newRoomId)) {
                     adapter.send("Chat room already exists. Do you want to join it? (yes/no)");
                     String response = scanner.nextLine();
                     if (response.equalsIgnoreCase("yes")) {
                         ChatRoom existingChatRoom = manager.getChatRoom(newRoomId);
                         user.joinRoom(existingChatRoom);
                     } else {
                         adapter.send("Please choose another room ID.");
                     }
                 } else {
                     ChatRoom newChatRoom = manager.createChatRoom(newRoomId);
                     user.joinRoom(newChatRoom);
                 }
                 break;
             case "3":
                 adapter.send("Enter your username: ");
                 username = scanner.nextLine();
                 user = users.get(username);
                 if (user == null) {
                     adapter.send("User does not exist. Please create a user first.");
                     break;
                 }
                 adapter.send("Enter chat room ID to join: ");
                 String roomId = scanner.nextLine();
                 ChatRoom chatRoom = manager.getChatRoom(roomId);
                 if (chatRoom != null) {
                     user.joinRoom(chatRoom);
                 } else {
                     adapter.send("Chat room does not exist.");
                 }
                 break;
             case "4":
                 adapter.send("Enter your username: ");
                 username = scanner.nextLine();
                 user = users.get(username);
                 if (user != null) {
                     user.sendMessage();
                 } else {
                     adapter.send("User does not exist. Please create a user first.");
                 }
                 break;
             case "5":
                 adapter.send("Enter your username: ");
                 username = scanner.nextLine();
                 user = users.get(username);
                 if (user != null && user.chatRoom != null) {
                     adapter.send("Active users in " + user.chatRoom.getRoomId() + ": " + user.chatRoom.getActiveUsers());
                 } else {
                     adapter.send("You are not in a chat room.");
                 }
                 break;
             case "6": 
                 adapter.send("Enter your username: ");
                 username = scanner.nextLine();
                 user = users.get(username);
                 if (user != null) {
                     user.viewMessageHistory();
                 } else {
                     adapter.send("User does not exist. Please create a user first.");
                 }
                 break;
             case "7":
                 adapter.send("Enter your username: ");
                 username = scanner.nextLine();
                 user = users.get(username);
                 if (user != null) {
                     user.leaveRoom();
                 } else {
                     adapter.send("User does not exist.");
                 }
                 break;
             case "8":
                 adapter.send("Exiting application...");
                 scanner.close();
                 System.exit(0);
             default:
                 adapter.send("Invalid option.");
         }
     }
 }
}