import java.util.Scanner;
import java.util.Random;

public class numbergame {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random r = new Random();

        int lB = 1;
        int uB = 100;
        int tN = r.nextInt(uB - lB + 1) + lB;
        int no;
        int attempts = 0;

        System.out.println("Welcome ");
        System.out.println(" TO NUMBER GAME");
        System.out.println("I have chosen a number between " + lB + " and " + uB + ". GUESS IT?? ");

        do {
            System.out.print("Enter your GUESS NUMBER: ");
            no = s.nextInt();
            attempts++;

            if (no < tN) {
                System.out.println("Too low! Try again.");
            } else if (no > tN) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("YEHHH IT'S A CORRECT NUMBER !   YOUR ATTEMPT's : " + attempts + " ");
            }

        } while (no != tN);

    }
}
