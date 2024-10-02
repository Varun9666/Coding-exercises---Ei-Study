# Real-time Chat Application Programming Exercise

## Introduction

This is a simple console-based real-time chat application written in Java. Users can create or join chat rooms, send and receive messages in real-time, view active users in a chat room, and view the message history. The application demonstrates the use of design patterns and follows object-oriented programming principles.

## Features

- **User Management**: Create users with unique usernames.
- **Chat Room Management**:
  - Create chat rooms with unique room IDs.
  - Join existing chat rooms.
- **Real-Time Messaging**:
  - Send and receive messages within a chat room.
  - Messages are broadcast to all users in the chat room.
- **Active Users List**: View the list of active users in a chat room.
- **Message History**: View the entire message history of a chat room.
- **Design Patterns Implemented**:
  - **Observer Pattern**: For real-time message updates.
  - **Singleton Pattern**: For managing chat rooms.
  - **Adapter Pattern**: For flexible communication methods.


## How to Use the Application

When you run the application, you'll see a menu with several options. Follow the prompts to interact with the chat application.

### Menu Options

1. **Create User**:
   - Enter a unique username to create a new user.

2. **Create Chat Room**:
   - Enter your username.
   - Enter a new chat room ID (must be unique).
   - If the room ID already exists, you'll be prompted to join the existing room or choose another ID.

3. **Join Chat Room**:
   - Enter your username.
   - Enter the chat room ID you wish to join.
   - You must have an existing user to join a chat room.

4. **Send Message**:
   - Enter your username.
   - Type your message when prompted.
   - Your message will be broadcast to all users in the chat room.

5. **View Active Users**:
   - Enter your username.
   - The application will display the list of active users in your current chat room.

6. **View Message History**:
   - Enter your username.
   - The application will display the entire message history of your current chat room.

7. **Leave Chat Room**:
   - Enter your username.
   - You will leave the current chat room.

8. **Exit**:
   - Closes the application.

## Code Structure

The application consists of the following classes:

1. **ChatApplication.java**: The main class containing the application logic and user interface.

2. **User.java**: Represents a user in the chat application.
   - Implements the `Observer` interface.
   - Methods: `joinRoom()`, `leaveRoom()`, `sendMessage()`, `viewMessageHistory()`.

3. **ChatRoom.java**: Represents a chat room.
   - Implements the `Subject` interface.
   - Manages users and message history.
   - Methods: `addUser()`, `removeUser()`, `sendMessage()`, `getMessageHistory()`.

4. **ChatRoomManager.java**: Manages all chat rooms.
   - Implements the Singleton pattern.
   - Methods: `createChatRoom()`, `getChatRoom()`, `chatRoomExists()`.

5. **Observer.java** and **Subject.java**: Interfaces for the Observer pattern.

6. **CommunicationAdapter.java**: An interface for communication methods.

7. **ConsoleCommunicationAdapter.java**: Implements `CommunicationAdapter` for console I/O.

## Design Patterns Used

- **Observer Pattern**:
  - Allows `ChatRoom` to notify all registered `User` observers of new messages and user activities.
  - Promotes loose coupling between chat rooms and users.

- **Singleton Pattern**:
  - Ensures only one instance of `ChatRoomManager` exists.
  - Provides a global access point to manage chat rooms.

- **Adapter Pattern**:
  - `CommunicationAdapter` interface allows for different communication methods.
  - `ConsoleCommunicationAdapter` implements this interface for console-based communication.
  - Makes it easy to extend the application to support other communication protocols like network sockets.

## Object-Oriented Programming Principles

- **Encapsulation**: Classes encapsulate data and provide methods to interact with that data.
- **Inheritance and Polymorphism**: Interfaces and classes are used to achieve polymorphism.
- **SOLID Principles**:
  - **Single Responsibility**: Each class has a single responsibility.
  - **Open/Closed**: Classes are open for extension but closed for modification.
  - **Liskov Substitution**: Subtypes can replace their base types without affecting the correctness.
  - **Interface Segregation**: Interfaces are client-specific and not general-purpose.
  - **Dependency Inversion**: High-level modules depend on abstractions, not concrete implementations.


## Conclusion

This chat application serves as a foundational project demonstrating key programming concepts and design patterns. It provides a starting point for further development into a full-fledged chat system.
