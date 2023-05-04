import java.util.Scanner;

public class Assignment1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your surname: ");
        String surname = scanner.nextLine();
        displayFullName(name, surname);
    }

    public static void displayFullName(String name, String surname) {
        System.out.println("Your full name is: " + name + " " + surname);
    }
}
