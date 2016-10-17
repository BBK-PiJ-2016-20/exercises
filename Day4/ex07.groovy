class Mortgage {
    private double borrowed;
    private double rate;
    private double length;

    Mortgage(double borrowed, double rate, double length) {
        this.borrowed = borrowed;
        this.rate = rate;
        this.length = length;
    }

    double getTotal() {
        return borrowed * (1 + rate / 100)
    }

    double getAnnualPayment() {
        return getTotal() / length;
    }

    double getInterestOnlyPeriod() {
        return (getTotal() - borrowed) / getAnnualPayment(); 
    }
}


print("Amount to borrow: ");
double borrowed = Double.parseDouble(System.console().readLine());

print("Interest rate (per cent): ");
double rate = Double.parseDouble(System.console().readLine());

print("Mortgage length: ");
double length = Double.parseDouble(System.console().readLine());

Mortgage m = new Mortgage(borrowed, rate, length);
println("Total amount to pay: " + m.getTotal());
println("Annual payment: " + m.getAnnualPayment());
println("Time to pay interest: " + m.getInterestOnlyPeriod());