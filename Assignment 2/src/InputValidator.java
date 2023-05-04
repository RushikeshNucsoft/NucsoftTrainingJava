import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String emailRegex = "^[\\w-_.+]*[\\w-_.]@([\\w]+[.])+[\\w]+[\\w]$";
        String phoneRegex = "^\\d{10}$";
        
        System.out.print("Enter your email address: ");
        String email = scanner.nextLine();
        while (!isValidInput(email, emailRegex)) {
            System.out.print("Invalid email address. Please re-enter: ");
            email = scanner.nextLine();
        }
        System.out.println("Email address is valid.");
        
        System.out.print("Enter your phone number (10 digits only): ");
        String phone = scanner.nextLine();
        while (!isValidInput(phone, phoneRegex)) {
            System.out.print("Invalid phone number. Please re-enter: ");
            phone = scanner.nextLine();
        }
        System.out.println("Phone number is valid.");
        
        scanner.close();
    }
    
    private static boolean isValidInput(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
