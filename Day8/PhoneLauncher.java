public class PhoneLauncher {
    public static void main(String[] args) {
        PhoneLauncher launcher = new PhoneLauncher();
        launcher.launch();
    }
    
    public void launch() {
        SmartPhone phone = new SmartPhone("Motorola");
        
        // Phone methods
        phone.call("01677 423336");
        phone.call("07969 412849");
        phone.call("001510 590 7277");
        
        // Old phone methods
        System.out.println("Brand: " + phone.getBrand());

        // MobilePhone methods
        phone.printLastNumbers();
        phone.ringAlarm("Wake up!");
        phone.playGame("Snake");
        
        // SmartPhone methods
        phone.browseWeb("http://moodle.bbk.ac.uk");
        Position pos = phone.findPosition();
        System.out.println("Position: <" + pos.latitude + ", " + pos.longitude + ">");
    }
}