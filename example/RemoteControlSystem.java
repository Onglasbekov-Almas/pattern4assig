// Command Interface
interface Command {
    void execute();
    void undo();
}

// TV Receiver
class TV {
    public void on() { System.out.println("TV is ON"); }
    public void off() { System.out.println("TV is OFF"); }
}

// TurnTVOn Command
class TurnTVOn implements Command {
    private TV tv;

    public TurnTVOn(TV tv) { this.tv = tv; }

    public void execute() { tv.on(); }
    public void undo() { tv.off(); }
}

// RemoteControl
class RemoteControl {
    private Command[] commands = new Command[2];

    public void setCommand(int slot, Command command) {
        commands[slot] = command;
    }

    public void pressButton(int slot) {
        commands[slot].execute();
    }
}

// Main class
public class RemoteControlSystem {
    public static void main(String[] args) {
        TV tv = new TV();
        Command tvOn = new TurnTVOn(tv);

        RemoteControl remote = new RemoteControl();
        remote.setCommand(0, tvOn);

        remote.pressButton(0);  // Turns TV ON
    }
}
