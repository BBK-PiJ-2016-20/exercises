class Notes32 {
    private static class Results {
        private int distinctions;
        private int passes;
        private int fails;
        private int invalid;

        private Results() {
            distinctions = 0;
            passes = 0;
            fails = 0;
            invalid = 0;
        }        

        public void print() {
            System.out.println("Distinctions: " + distinctions);
            System.out.println("Passes: " + passes);
            System.out.println("Fails: " + fails);
            System.out.println("And " + invalid + "invalid entries.");
        }

        public static Results read() {
            Results results = new Results();
            boolean finished = false;
            do {
                System.out.print("Enter a mark (-1 to end): ");
                int mark = Integer.parseInt(System.console().readLine());
                if (mark == -1) {
                    finished = true;
                } else if (mark < 0 || mark > 100 ) {
                    results.invalid = 0;
                } else if (mark >= 70) {
                    results.distinctions++;
                } else if (mark >= 50) {
                    results.passes++;
                } else {
                    results.fails++;
                }
            } while (!finished);
        }
    }



    public static void main(String[] args) {
        Results results = Results.read();
        results.print();
    }
}