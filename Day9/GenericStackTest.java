public class GenericStackTest {
    public static void main(String[] args) {
        GenericStack<Integer> intStack = new GenericStack<Integer>();
        intStack.push(10);
        intStack.push(20);
        intStack.push(30);
        while (!intStack.isEmpty()) {
            Integer i = intStack.pop();
            System.out.println(i);
        }

        GenericStack<Double> doubleStack = new GenericStack<Double>();
        doubleStack.push(10.0);
        doubleStack.push(20.0);
        doubleStack.push(30.0);
        while (!doubleStack.isEmpty()) {
            Double d = doubleStack.pop();
            System.out.println(d);
        }

        // Following line will not compile because String does not extend Number
        // GenericStack<String> stringStack = new GenericStack<String>();
    }
}