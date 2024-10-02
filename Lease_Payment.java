import java.util.Scanner;
public class Lease_Payment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // totalLeased input and validations
        double totalLeasedAmount = Employee_Record.getNumberInput(sc, "Enter Total Leased Amount: ");
        while(totalLeasedAmount <= 0){
            totalLeasedAmount = Employee_Record.getNumberInput(sc, "Invalid Amount, please try again !");
        }

        // total pay amount input and validations
        double totalPayAmount = Employee_Record.getNumberInput(sc, "Enter Total Pay Amount: ");
        while(totalPayAmount < 0){
            totalPayAmount = Employee_Record.getNumberInput(sc, "Invalid Amount, please try again !");
        }

        // lease term input and validations
        int leaseTerm = Employee_Record.getNumberInput(sc, "Enter Lease Term (months): ");
        while (leaseTerm <= 0){
            leaseTerm = Employee_Record.getNumberInput(sc, "Invalid Term, please try again !");
        }

        // interest rate input and validations
        double interestRateLease = Employee_Record.getNumberInput(sc, "Enter Interest Rate : ");
        while (invalidLeaseRate(interestRateLease)){
            interestRateLease = Employee_Record.getNumberInput(sc, "Invalid Interest Rate , please try again !: ");
        }

        // monthly payment calculation and final output result
        double result = monthlyPayment(totalLeasedAmount, totalPayAmount, leaseTerm, interestRateLease);
        Employee_Record.show_message("The monthly payment amount is: " + result);
    }
    /**
     * Calculates the monthly payment of a lease.
     * @param totalLeasedMoney The total amount of the lease.
     * @param downPayment The total amount already paid.
     * @param leaseTerm The number of months of the lease.
     * @param interestRate The interest of the lease.
     * @return The amount that's going to be paid monthly
     */
    private static double monthlyPayment(double totalLeasedMoney,double downPayment, int leaseTerm, double interestRate) {
        double balance = totalLeasedMoney - downPayment;
        return (balance + balance*(interestRate/100))/leaseTerm;
    }

    /**
     *  Checks if an interest Rate is invalid
     * @param interestRate The interest Rate to validate
     * @return true if the interest Rate is less or equal than zero or more than 100, otherwise false
     */
    private static boolean invalidLeaseRate(double interestRate) {
        return interestRate <= 0 || interestRate > 100;
    }
}
