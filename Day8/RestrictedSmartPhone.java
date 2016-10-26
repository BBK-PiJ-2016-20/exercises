class RestrictedSmartPhone extends SmartPhone {
    // This gives an error message, because you cannot override a method with more restrictive permission.
    // It would not make sense to do so; the point of extending a class is that the subclass is-a object of
    // the superclass type, i.e., a RestrictedSmartPhone ought to be able to do anything a SmartPhone can.
    // If we make a method type more restrictive, we are going against that contract.
    private void playGame(String game) {
        System.out.println("How are you calling this? It's not allowed.");
    }
}