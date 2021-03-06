class SmartPhone extends MobilePhone {

    public SmartPhone(String brand) {
        super(brand);
    }

    /**
     * Visits a URL (by printing it out).
     *
     * @param url the url to "visit".
     */
    public void browseWeb(String url) {
        System.out.println("Browsing to: " + url);
    }

    /**
     * Returns the GPS coordinates of the phone
     *
     * @returns an object representing the latitude and longitude.
     */
    public Position findPosition() {
        return new Position(10.0, 11.3);
    }

    @Override
    public void call(String number) {
        if (number.startsWith("00")) {
            storeNumber(number);
            System.out.println("Calling " + number + " through the internet to save money");
        } else {
            super.call(number);
        }
    }
    
    // Because playGame in MobilePhone is private, I need to provide a new implementation of it here so
    // that there is a visible version of playGame to call from PhoneLauncher.
    public void playGame(String game) {
        System.out.println("A fancy smartphone version of: " + game);
    }
}