package com.github.kingavatar.scientificcalculator;

import java.util.Scanner;

public class EntryPoint {
    public static void main(String[] args) {
        Calculator scientificCalculator = new Calculator();
        System.out.println("");
        System.out.print(ConsoleColors.CYAN_BOLD);
        System.out.print(ConsoleColors.WHITE_BACKGROUND);
        System.out.print(scientificCalculator);
        System.out.println(ConsoleColors.RESET);
        Scanner scanner  = new Scanner(System.in);
        boolean exitFlag = true;
        while (exitFlag) {
            exitFlag = runApp(scientificCalculator,scanner);
        }
        scanner.close();
    }
    static boolean runApp(Calculator scientificCalculator, Scanner scanner){
        System.out.println("");
        System.out.print(ConsoleColors.CYAN_BOLD);
        System.out.print(":: ");
        System.out.print(ConsoleColors.RESET+ConsoleColors.BOLD);
        System.out.print("Please Choose one of the Options Listed Below");
        System.out.println("");
        System.out.print(ConsoleColors.GREEN_BOLD);
        System.out.print("==> ");
        System.out.print(ConsoleColors.RESET+ConsoleColors.BOLD);
        System.out.println("["+ConsoleColors.CYAN_BOLD+"1"+ConsoleColors.RESET+ConsoleColors.BOLD+"] Square Root of a Number (\u221ax)");
        System.out.print(ConsoleColors.GREEN_BOLD);
        System.out.print("==> ");
        System.out.print(ConsoleColors.RESET+ConsoleColors.BOLD);
        System.out.println("["+ConsoleColors.CYAN_BOLD+"2"+ConsoleColors.RESET+ConsoleColors.BOLD+"] Factorial of a Number (x!)");
        System.out.print(ConsoleColors.GREEN_BOLD);
        System.out.print("==> ");
        System.out.print(ConsoleColors.RESET+ConsoleColors.BOLD);
        System.out.println("["+ConsoleColors.CYAN_BOLD+"3"+ConsoleColors.RESET+ConsoleColors.BOLD+"] Natural Logarithm of a Number (ln(x))");
        System.out.print(ConsoleColors.GREEN_BOLD);
        System.out.print("==> ");
        System.out.print(ConsoleColors.RESET+ConsoleColors.BOLD);
        System.out.println("["+ConsoleColors.CYAN_BOLD+"4"+ConsoleColors.RESET+ConsoleColors.BOLD+"] Power of a Number (x^b)");
        System.out.print(ConsoleColors.GREEN_BOLD);
        System.out.print("==> ");
        System.out.print(ConsoleColors.RESET+ConsoleColors.BOLD);
        System.out.print("["+ConsoleColors.CYAN_BOLD+"0"+ConsoleColors.RESET+ConsoleColors.BOLD+"] Exit");
        System.out.println(ConsoleColors.RESET);
        System.out.println("");
        System.out.print("Enter a number : ");
        int response = scanner.nextInt();
        switch (response) {
            case 0 -> {
                System.out.println("Thank you for using the Application, Bye Bye.");
                return false;
            }
            case 1 -> {
                System.out.print("Enter a Number : ");
                double inputNoSqrt = scanner.nextDouble();
                System.out.println(scientificCalculator.SquareRoot(inputNoSqrt));
            }
            case 2 -> {
                System.out.print("Enter a Number : ");
                int inputNoFact = scanner.nextInt();
                System.out.println(scientificCalculator.Factorial(inputNoFact));
            }
            case 3 -> {
                System.out.print("Enter a Number : ");
                double inputNolog = scanner.nextDouble();
                System.out.println(scientificCalculator.Log(inputNolog));
            }
            case 4 -> {
                System.out.print("Enter a Number : ");
                double inputNoPow = scanner.nextDouble();
                int inputNoExponent = scanner.nextInt();
                System.out.println(scientificCalculator.Pow(inputNoPow, inputNoExponent));
            }
            default -> System.out.println("Please Choose Number Between [1-4] for the Given Options.");
        }
        return true;
    }
}
