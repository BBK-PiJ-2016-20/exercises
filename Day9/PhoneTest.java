public class PhoneTest {
    public static void main(String[] args) {
        SmartPhone myPhone = new SmartPhone("Samsung");

        myPhone.browseWeb("http://moodle.bbk.ac.uk");
        myPhone.findPosition();
        myPhone.call("5105907277");
        myPhone.playGame("Snake");
        myPhone.ringAlarm("An alarm");
        myPhone.printLastNumbers();
    }
}