class SmartPhone extends MobilePhone {
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
}