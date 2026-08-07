public class Driver 
{
     public static void main(String[] args) 
     {

        String[] passwords = 
        {
                "abc",
                "Hello12",
                "Abcd1234!",
                "password",
                "Niyati1252",
                "Java@45"
        };
        
        for (String pw : passwords) 
            {

            System.out.println("\nPassword : " + pw);

            System.out.println("Length : " +
                    PasswordChecker.hasLength(pw));

            System.out.println("Uppercase : " +
                    PasswordChecker.hasUpperCase(pw));

            System.out.println("Digit : " +
                    PasswordChecker.hasDigit(pw));

            System.out.println("Special : " +
                    PasswordChecker.hasSpecial(pw));

            System.out.println("Strength : " +
                    PasswordChecker.strength(pw));
        }

    }

}