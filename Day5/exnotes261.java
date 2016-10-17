public class exnotes261 {
    public static void main(String[] args) {
        int EMPLOYEES = 10;
        int[] employeeIds = new int[EMPLOYEES];
        String[] employeeNames = new String[EMPLOYEES];
        
        for (int i = 0; i < EMPLOYEES; i++) {
            System.out.println("(" + (EMPLOYEES - i) + " employees left to enter)");
            System.out.print("Employee id: ");
            employeeIds[i] = Integer.parseInt(System.console().readLine());
            System.out.print("Employee name: ");
            employeeNames[i] = System.console().readLine();
            System.out.println("");
        }

        System.out.println("All employees entered\n");

        System.out.println("Employees with an id less than 1000:");

        for (int i = 0; i < EMPLOYEES; i++) {
            if (employeeIds[i] < 1000) {
                System.out.println("Employee name: " + employeeNames[i]);
                System.out.println("Employee id: " + employeeIds[i]);
            }
        }

        System.out.println("")        

        System.out.println("Employees with names beginning with 'J' or 'S'");

        for (int i = 0; i < EMPLOYEES; i++) {
            char first = employeeNames[i].charAt(0);

            if (first == 'J' || first == 'S') {
                System.out.println("Employee name: " + employeeNames[i]);
                System.out.println("Employee id: " + employeeIds[i]);
            }
        }
    } 
}