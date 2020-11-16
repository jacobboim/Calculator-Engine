package calcEngine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        dynamicInteractivity();

    }


    private static void dynamicInteractivity(){
        DynamicHelper helper = new DynamicHelper(new MathProcessing[]{
            new Adder(),
                new PowerOf(),
                new Divider(),
                new Subtractor(),
                new Multiplier()

        });

        System.out.println("Enter an operation and two numbers");
        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine();

        helper.process(userInput);
    }

    static void executeInteractivley(){
        System.out.println("Enter an operation and two numbers");
        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine();
        String[] parts =  userInput.split(" ");
        performOperation(parts);
    }

    private static void performOperation(String[] parts) {
        MathOperation operation = MathOperation.valueOf(parts[0].toUpperCase());
        double leftVal = Double.parseDouble(parts[1]);
        double rightVal = Double.parseDouble(parts[2]);
         CalculateBase calculation = createCalculation(operation, leftVal ,rightVal);
        calculation.calculate();
        String output = String.format("%.3f %s %.3f = ", leftVal, operation, rightVal);
        System.out.println(output);
        System.out.println(calculation.getResult());
        }


    private  static  CalculateBase createCalculation(MathOperation operation, double leftVal, double rightVal ){
        CalculateBase  calculation = null;

        switch (operation){
            case ADD:
                calculation = new Adder(leftVal,rightVal);
                break;
            case SUBTRACT:
                calculation = new Subtractor(leftVal,rightVal);
                break;
            case MULTIPLY:
                calculation = new Multiplier(leftVal,rightVal);
                break;
            case DIVIDE:
                calculation = new Divider(leftVal,rightVal);
                break;
        }

        return calculation;
    }

    static void doCalculation(CalculateBase calculation, double leftVal, double rightVal){
        calculation.setLeftVal(leftVal);
        calculation.setResult(rightVal);
        calculation.calculate();
        System.out.println("Calculation result = " + calculation.getResult());


    }

    static void performCalculations() {
        MathEquation[] equations = new MathEquation[4];
        equations[0] = new MathEquation('d',100.0d, 50.0d);
        equations[1] = new MathEquation('a',25.0d, 92.0d);
        equations[2] = new MathEquation('s',225.0d, 17.0d);
        equations[3] = new MathEquation('m',11.0d, 3.0d);

        for (MathEquation equation : equations) {
            equation.execute();
            System.out.println("result =  " + equation.getResult());
        }

        System.out.println("Average result = " + MathEquation.getAverage());


        System.out.println();
        System.out.println("Using execute overloads");
        System.out.println();

        MathEquation equationOverload = new MathEquation('d');
            double leftDouble = 9;
            double rightDouble = 4;
            equationOverload.execute(leftDouble,rightDouble);
        System.out.println("Overload result with Doubles: " + equationOverload.getResult());


        int leftInt = 9;
        int rightInt = 4;
        equationOverload.execute(leftDouble,rightDouble);
        System.out.println("Overload result with ints: " + equationOverload.getResult());



    }

}

    /*

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

    private static void handleCommandLine(String[] args) {
        char opCode = args[0].charAt(0);
        double leftVal = Double.parseDouble(args[1]);
        double rightVal = Double.parseDouble(args[2]);
        double result = execute(opCode, leftVal, rightVal);
        System.out.println(result);
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

     */





