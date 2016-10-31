public class PhoneTest {

    public static void testPhone(Phone p) {
        // Can only use the "call" method here, as it is the only one defined in the Phone interface
        p.call("5105907277");
    }

    public static void main(String[] args) {
        SmartPhone myPhone = new SmartPhone("Samsung");

        testPhone(myPhone);

        // Won't work, as this method is not defined on MobilePhone
        myPhone.browseWeb("http://moodle.bbk.ac.uk");

        // Won't work, as this method is not defined on MobilePhone
        myPhone.findPosition();
    }
}