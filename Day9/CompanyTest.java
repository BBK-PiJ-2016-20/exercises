public class CompanyTest {
    public static void main(String[] args) {
        Company c = new Company();
        c.addEmployee("Alice", "AA-05-04-02");
        c.addEmployee("Bob", "BB-09-09-09");
        c.printEmployees();
    }
}