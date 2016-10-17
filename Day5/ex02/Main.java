public class Main {
    private static void printArray(int[] arr) {
        System.out.print("{");
        System.out.print(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            System.out.print(", " + arr[i]);
        }
        System.out.println("}");
    }

    private static void sameLength() {
        System.out.println("Same length");
        int[] first = {1, 2, 3, 4};
        int[] second = {8, 9, 10, 11};

        ArrayCopier.copy(first, second);

        printArray(first);
        printArray(second);
    }

    private static void firstLonger() {
        System.out.println("First longer");
        int [] first = {1, 2, 3, 4, 5, 6};
        int [] second = {8, 9, 10, 11};

        ArrayCopier.copy(first, second);

        printArray(first);
        printArray(second);
    }

    private static void secondLonger() {
        System.out.println("Second longer");
        int [] first = {1, 2, 3, 4};
        int [] second = {8, 9, 10, 11, 12, 13};

        ArrayCopier.copy(first, second);

        printArray(first);
        printArray(second);
    }

    public static void main(String[] args) {
        sameLength();
        firstLonger();
        secondLonger();
    }
}