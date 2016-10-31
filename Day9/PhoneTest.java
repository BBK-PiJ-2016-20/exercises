public class PhoneTest {

    public static void testPhone(Phone p) {
        SmartPhone s = (SmartPhone) p;

        s.call("5105907277");
        s.playGame("Snake");
        s.ringAlarm("An alarm");
        s.printLastNumbers();
        s.browseWeb("http://moodle.bbk.ac.uk");
        s.findPosition();
    }

    public static void main(String[] args) {
        MobilePhone myPhone = new MobilePhone("Samsung");

        testPhone(myPhone);
    }
}