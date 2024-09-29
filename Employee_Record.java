import java.util.Scanner;

public class Employee_Record {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //firstname input and validation
        String firstName = getStringInput(input, "First Name");
        while(invalid_string(firstName)) {
            firstName = getStringInput(input, "Invalid First Name, try again please !");
        }

        //lastname input and validation
        String lastName = getStringInput(input, "Last Name");
        while(invalid_string(lastName)) {
            lastName = getStringInput(input, "Invalid Last Name, try again please !");
        }

        //age input and validation
        int age = getNumberInput(input, "Age");
        while(invalid_range_number(0, 100, age)){
            age = getNumberInput(input, "Invalid Age, try again please !");
        }

        //employee number input and validation
        int employee_number = getNumberInput(input, "Employee Number");
        while(invalid_range_number(27560000, 27569999, employee_number)){
            employee_number = getNumberInput(input,"Invalid Employee number, try again please !");
        }

        //final result
        show_message("Employee Data");
        show_message("Name: "+firstName+" "+lastName);
        show_message("Age: "+age);
        show_message("Number: "+employee_number);
        show_message("Email: "+firstName.toLowerCase()+"."+lastName.toLowerCase()+"@mentormakers.com");
    }

    /**
     *  Prints a message in console.
     * @param message The string to print.
     */
    private static void show_message(String message) {
        System.out.println(message);
    }

    /**
     * Checks if a number is available in a range of numbers and returns the result.
     * @param lower The lower bound of the interval.
     * @param upper The upper bound of the interval.
     * @param value The number evaluated between the given intervals.
     * @return true if the number is outside the upper and lower bound, otherwise false.
     * @throws IllegalArgumentException if the lower bound is higher than the upper one.
     */
    private static boolean invalid_range_number(Integer lower, Integer upper, Integer value) {
        if (lower > upper) {
            throw new IllegalArgumentException("Invalid range number");
        }
        return lower > value || value > upper;
    }

    /**
     * Checks if a text has a digit inside them and returns the result.
     * @param string The text evaluated.
     * @return  true if there is a digit inside the string, otherwise false.
     */
    private static boolean invalid_string(String string) {
        int length = string.length();
        for (int i = 0; i < length ; i++) {
            char c = string.charAt(i);
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    /**
     *  Gets an integer from the user
     * @param input_int The Scanner object to capture the integer from the user
     * @param message The prompt to guide the user
     * @return The required integer
     */
    private static int getNumberInput(Scanner input_int, String message) {
        show_message(message);
        return input_int.nextInt();
    }

    /**
     *  Gets a string from the user
     * @param input_str The Scanner object to capture the string from the user
     * @param message The prompt to guide the user
     * @return The required string
     */
    private static String getStringInput(Scanner input_str, String message) {
        show_message(message);
        return input_str.nextLine();
    }
}
