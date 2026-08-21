import java.util.InputMismatchException;
import java.util.Scanner;

class DivideByZeroException extends Exception {
    DivideByZeroException(String msg) {
        super(msg);
    }
}

class InvalidNumberException extends Exception {
    InvalidNumberException(String msg) {
        super(msg);
    } 
}

public class GuardedCalculator {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            boolean done = false;

            while (!done) {
                try {
                    System.out.print("Enter Operand and Operator: ");

                    int a = sc.nextInt();
                    char op = sc.next().charAt(0);
                    int b = sc.nextInt();

                    if (a < 0 || b < 0) {
                        throw new InvalidNumberException(
                            "Negative number is not allowed!"
                        );
                    }

                    if (op == '*' && (a == 0 || b == 0)) {
                        throw new InvalidNumberException(
                            "0 is not allowed in multiplication!"
                        );
                    }

                    if (op == '/' && b == 0) {
                        throw new DivideByZeroException(
                            "Cannot divide by zero!"
                        );
                    }

                    if (op == '+') {
                        System.out.println("Result = " + (a + b));
                        done = true;
                    }
                    else if (op == '-') {
                        System.out.println("Result = " + (a - b));
                        done = true;
                    }
                    else if (op == '*') {
                        System.out.println("Result = " + (a * b));
                        done = true;
                    }
                    else if (op == '/') {
                        System.out.println("Result = " + (a / b));
                        done = true;
                    }
                    else {
                        System.out.println("Invalid operator!");
                    }
                }

                catch (InvalidNumberException |
                       DivideByZeroException e) {

                    System.out.println(e.getMessage());
                    sc.nextLine();
                }

                catch (InputMismatchException e) {
                    System.out.println(
                        "Please enter valid numbers!"
                    );
                    sc.nextLine();
                }

                finally {
                    System.out.println("Attempt logged.\n");
                }
            }
        }
    }
}