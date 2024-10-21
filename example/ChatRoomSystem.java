// ChatMediator Interface
interface ChatMediator {
    void sendMessage(String message, User user);
    void addUser(User user);
}

// Concrete Mediator
class ChatRoom implements ChatMediator {
    private List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public void sendMessage(String message, User user) {
        for (User u : users) {
            if (u != user) {
                u.receiveMessage(message);
            }
        }
    }
}

// User Abstract Class
abstract class User {
    protected ChatMediator mediator;
    protected String name;

    public User(ChatMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public abstract void sendMessage(String message);
    public abstract void receiveMessage(String message);
}

// Concrete User
class RegularUser extends User {
    public RegularUser(ChatMediator mediator, String name) {
        super(mediator, name);
    }

    public void sendMessage(String message) {
        System.out.println(this.name + " sends: " + message);
        mediator.sendMessage(message, this);
    }

    public void receiveMessage(String message) {
        System.out.println(this.name + " receives: " + message);
    }
}

// Main Class
public class ChatRoomSystem {
    public static void main(String[] args) {
        ChatRoom chatRoom = new ChatRoom();

        User user1 = new RegularUser(chatRoom, "Alice");
        User user2 = new RegularUser(chatRoom, "Bob");

        chatRoom.addUser(user1);
        chatRoom.addUser(user2);

        user1.sendMessage("Hi Bob!");
    }
}
