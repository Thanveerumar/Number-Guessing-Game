import java.util.Scanner;
import java.util.Random;

class startGame {
    int InputFromSystem;
    int InputFromUser;
    int NoOfGuesses;

    startGame() {
        Random r = new Random();
        this.InputFromSystem = r.nextInt(100) + 1;
    }

    public boolean takeUserInput() {
        if (NoOfGuesses < 9) {
            System.out.print("Enter your guessed number : ");
            this.InputFromUser = NumberGuessingGame.takeIntegerInput(100);
            NoOfGuesses++;
            return false;
        } else {
            System.out.println("your attempts are over.... Better Luck Next Time ! \n");

            return true;
        }
    }

    public boolean isCorrectGuess() {
        if (InputFromSystem == InputFromUser) {
            System.out.println("Congrats! You guess the system generated number " + InputFromSystem + " in "
                    + NoOfGuesses + " guesses");
            switch (NoOfGuesses) {
                case 1:
                    System.out.println("your score is 100 out of 100 ");
                    System.out.println("you got 10 points out 10 points");
                    break;
                case 2:
                    System.out.println("your score is 90 out of 100 ");
                    System.out.println("you got  9 points out 10 points");
                    break;
                case 3:
                    System.out.println("your score is 80  out of 100 ");

                    System.out.println("you got  8 points out 10 points");
                    break;
                case 4:
                    System.out.println("your score is 70 out of 100 ");
                    System.out.println("you got 7 points out 10 points");
                    break;
                case 5:
                    System.out.println("your score is 60 out of 100 ");
                    System.out.println("you got 6 points out 10 points");
                    break;
                case 6:
                    System.out.println("your score is 50 out of 100 ");
                    System.out.println("you got 5 points out 10 points");
                    break;
                case 7:
                    System.out.println("your score is 40 out of 100 ");
                    System.out.println("you got 4 points out 10 points");
                    break;
                case 8:
                    System.out.println("your score and points are too low. Better Luck Next Time ! ");
                    break;
            }
            System.out.println();
            return true;
        } else if (NoOfGuesses < 9 && InputFromSystem > InputFromUser) {
            System.out.println("System generated number is greater than " + InputFromUser);

        } else
            System.out.println("System generated number is less than " + InputFromUser);
        return false;
    }
}

public class NumberGuessingGame {
    public static int takeIntegerInput(int limit) {
        int input = 0;
        boolean flag = false;
        Scanner s = new Scanner(System.in);
        while (!flag) {
            try {
                input = s.nextInt();
                flag = true;
                if (flag && input > limit || input < 1) {
                    System.out.println("choose the number between 1 and " + limit);
                    flag = false;
                }
            } catch (Exception e) {
                System.out.println("Enter only integer value ");
                flag = false;
            }
        }

        return input;

    }

    public static void main(String[] args) {
        int nextRound = 1, noOfRounds = 0;
        System.out.println("1. Start the game \n2.Exit");
        System.out.println("Enter your choice : ");
        int choice = takeIntegerInput(2);
        if (choice == 1) {
            while (nextRound == 1) {
                startGame stargame = new startGame();
                boolean isMatched = false;
                boolean isLimitCross = false;
                System.out.println("\nRound " + noOfRounds + " starts......");
                while (!isMatched && !isLimitCross) {
                    isLimitCross = stargame.takeUserInput();
                    isMatched = stargame.isCorrectGuess();

                }
                System.out.println("1.Next Round \n2.Exit");
                System.out.println("Enter your choice : ");
                nextRound = takeIntegerInput(2);
                if (nextRound != 1) {
                    System.exit(0);

                }
            }
        } else
            System.exit(0);
    }

}
