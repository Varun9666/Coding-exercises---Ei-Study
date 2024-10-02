# Exercise-1 Design Patterns in Java

This project demonstrates the implementation of six different design patterns, categorized into behavioral, creational, and structural patterns. Each design pattern is implemented in a structured and modular manner, following best practices like input validation, logging, and exception handling.

## Project Structure
/DesignPatternsProject
   ├── behavioral/
   │      ├── ObserverPattern.java
   │      ├── StrategyPattern.java
   ├── creational/
   │      ├── SingletonPattern.java
   │      ├── FactoryPattern.java
   ├── structural/
   │      ├── AdapterPattern.java
   │      ├── DecoratorPattern.java
   ├── Main.java
   ├── logger/
   │      ├── Logger.java
   ├── utils/
   │      ├── InputValidator.java


## Design Patterns Implemented

### Behavioral Patterns:
- **Observer Pattern**: Implements the observer-subject relationship, where changes in the subject are communicated to observers.
- **Strategy Pattern**: Defines a family of algorithms, encapsulates each one, and makes them interchangeable at runtime.

### Creational Patterns:
- **Singleton Pattern**: Ensures a class has only one instance and provides a global point of access to it.
- **Factory Pattern**: Provides an interface for creating objects, allowing subclasses to alter the type of objects that will be created.

### Structural Patterns:
- **Adapter Pattern**: Converts the interface of a class into another interface that clients expect.
- **Decorator Pattern**: Attaches additional responsibilities to an object dynamically, offering an alternative to subclassing.

## Logging

A simple logging mechanism is implemented to log all events during the execution of the program. The logs are written to `app.log` file in the project directory.

## Exception Handling

The code includes exception handling where necessary, ensuring the application continues to function even in case of errors. All exceptions are logged into `app.log`.

## Features

- **Separation of Concerns**: Each design pattern is implemented in its own class, making the code modular and maintainable.
- **Input Validation**: Ensures that all user inputs are validated before being processed.
- **Extensible**: Easy to add more patterns or extend existing ones due to the clean and modular structure.

## How Each Pattern is Demonstrated

### Observer Pattern
- **Location**: `behavioral/ObserverPattern.java`
- **Explanation**: In this example, Subject maintains a list of Observers. When the subject changes, all registered observers are notified.

### Strategy Pattern
- **Location**: `behavioral/StrategyPattern.java`
- **Explanation**: Two payment methods (Credit Card and PayPal) are defined as strategies. The ShoppingCart class allows switching between payment methods dynamically at runtime.

### Singleton Pattern
- **Location**: `creational/SingletonPattern.java`
- **Explanation**: The Singleton class ensures that only one instance is created and is globally accessible.

### Factory Pattern
- **Location**: `creational/FactoryPattern.java`
- **Explanation**: The ShapeFactory class provides an interface to create different shapes like Circle and Square.

### Adapter Pattern
- **Location**: `structural/AdapterPattern.java`
- **Explanation**: This pattern allows MediaPlayer to play different file formats, using an adapter to bridge the gap between incompatible interfaces.

### Decorator Pattern
- **Location**: `structural/DecoratorPattern.java`
- **Explanation**: Car is decorated with additional features dynamically by wrapping it in decorator classes like SportsCar.



# Exercise-2 Real-time Chat Application Programming 

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
