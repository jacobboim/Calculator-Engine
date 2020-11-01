package calcEngine;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //default program to run if no input in command line
        double[] leftVals = {100d, 25d, 225d, 11d};
        double[] rightVals = {50d, 92d, 17d, 3d};
        char[] opCodes = {'d', 'a', 's', 'm'};
        double[] results = new double[opCodes.length];
        if (args.length == 0) {
            for (int i = 0; i < opCodes.length; i++) {
                results[i] = execute(opCodes[i], leftVals[i], rightVals[i]);
            }
            for (double currentResult : results)
                System.out.println(currentResult);
        }
        else if (args.length == 1 && args[0].equals("interactive"))
            executeInteractivley();
        else if (args.length == 3)
            handleCommandLine(args);
        else
            System.out.println("please provide an opcode and 2 ints");

    }

    static void executeInteractivley(){
        System.out.println("Enter an operation and two numbers");
        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine();
        String[] parts =  userInput.split(" ");
        performOperation(parts);
    }

    private static void performOperation(String[] parts) {
        char opCOde = opCodeFromString(parts[0]);
        if(opCOde == 'w')
            handleWhen(parts);
        else {
            double leftVal = valueFromWord(parts[1]);
            double rightVal = valueFromWord(parts[2]);
            double result = execute(opCOde, leftVal, rightVal);
            displayResult(opCOde,leftVal,rightVal,result);
        }
    }
    private static void handleWhen(String[] parts) {
        //DateTimeFormatter usDateFormat = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        LocalDate startDate = LocalDate.parse(parts[1]);
        long daysToAdd = (long) valueFromWord(parts[2]);
        LocalDate newDate = startDate.plusDays(daysToAdd);

        String output = String.format("%s plus %d days is %s" , startDate,daysToAdd,newDate);
        System.out.println(output);
    }
    private static void displayResult(char opCOde, double leftVal, double rightVal, double result) {
        char symbol = symbolFromOpCode(opCOde);
        String output = String.format("%.3f %c %.3f = %.3f", leftVal,symbol, rightVal, result);
        System.out.println(output);

    }
    private static char symbolFromOpCode (char opCode){
        char[] opCodes = {'a','s','m','d','+','-','*','/'};
        char[] symbols = {'+','-','*','/','+','-','*','/'};
        char symbol = ' ';
        for (int i = 0; i < opCodes.length; i++) {
            if(opCode == opCodes[i]){
                symbol = symbols[i];
                break;
            }
        }
        return  symbol;
    }
    private static void handleCommandLine(String[] args) {
        char opCode = args[0].charAt(0);
        double leftVal = Double.parseDouble(args[1]);
        double rightVal = Double.parseDouble(args[2]);
        double result = execute(opCode, leftVal, rightVal);
        System.out.println(result);
    }

    static double execute(char opCode, double leftVal, double rightVal) {
        double result;
        switch (opCode) {
            case 'a', '+' -> result = leftVal + rightVal;
            case 's', '-' -> result = leftVal - rightVal;
            case 'm', '*' -> result = leftVal * rightVal;
            case 'd', '/' -> result = rightVal != 0 ? leftVal / rightVal : 0.0d;
            default -> {
                System.out.println("Invalid Opcode: " + opCode);
                result = 0.0d;
            }
        }
        return result;
    }

    static char opCodeFromString(String operationName) {
        char opCode = operationName.charAt(0);
        return opCode;
    }

    static double valueFromWord(String word) {
        String[] numberWords = {
                "zero", "one", "two", "three",
                "four", "five", "six", "seven",
                "eight", "nine" , "ten", "eleven",
                "twelve", "thirteen" , "fourteen",
                "fifteen" , "sixteen", "seventeen" ,
                "eighteen", "nineteen" , "twenty"
        };

        double value = -1d;
        for (int i = 0; i < numberWords.length; i++) {
            if (word.equals(numberWords[i])){
                value = i;
                break;
            }
        }
        if (value == -1) {
            value = Double.parseDouble(word);
        }
        return value;
    }
}





