import java.util.Scanner;

class InvalidPinException extends Exception {
    public InvalidPinException(String message) {
        super(message);
    }
}

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

public class ATMSystem {
    private static final int CORRECT_PIN = 1234;
    private static double balance = 3000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Enter PIN: ");
            int enteredPin = scanner.nextInt();
            
            if (enteredPin != CORRECT_PIN) {
                throw new InvalidPinException("Error: Invalid PIN.");
            }
            
            System.out.print("Withdraw Amount: ");
            double withdrawAmount = scanner.nextDouble();
            
            if (withdrawAmount > balance) {
                throw new InsufficientBalanceException("Error: Insufficient balance.");
            }
            
            balance -= withdrawAmount;
            System.out.println("Withdrawal successful! Remaining Balance: " + balance);
        } catch (InvalidPinException | InsufficientBalanceException e) {
            System.out.println(e.getMessage() + " Current Balance: " + balance);
        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please enter a numeric value.");
        } finally {
            scanner.close();
        }
    }
}
