package ChatApplication;

import java.util.HashMap;
import java.util.Map;

public class ChatRoomManager {
    private static ChatRoomManager instance;
    private Map<String, ChatRoom> chatRooms;

    private ChatRoomManager() {
        chatRooms = new HashMap<>();
    }

    public static synchronized ChatRoomManager getInstance() {
        if (instance == null) {
            instance = new ChatRoomManager();
        }
        return instance;
    }

    public ChatRoom getChatRoom(String roomId) {
        return chatRooms.get(roomId);
    }

    public boolean chatRoomExists(String roomId) {
        return chatRooms.containsKey(roomId);
    }

    public ChatRoom createChatRoom(String roomId) {
        ChatRoom chatRoom = new ChatRoom(roomId);
        chatRooms.put(roomId, chatRoom);
        return chatRoom;
    }
}

