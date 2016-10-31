public class PhoneTest {
    public static void main(String[] args) {
        MobilePhone myPhone = new SmartPhone("Samsung");

        // Won't work, as this method is not defined on MobilePhone
        myPhone.browseWeb("http://moodle.bbk.ac.uk");

        // Won't work, as this method is not defined on MobilePhone
        myPhone.findPosition();
        myPhone.call("5105907277");
        myPhone.playGame("Snake");
        myPhone.ringAlarm("An alarm");
        myPhone.printLastNumbers();
    }
}