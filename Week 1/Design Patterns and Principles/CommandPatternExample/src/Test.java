public class Test {
    public static void main(String[] args) {

        Light livingRoomLight = new Light();

        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);

        // invoker
        RemoteControl remote = new RemoteControl();

        // light ON
        remote.setCommand(lightOn);
        remote.pressButton();

        // light OFF
        remote.setCommand(lightOff);
        remote.pressButton();
    }
}
