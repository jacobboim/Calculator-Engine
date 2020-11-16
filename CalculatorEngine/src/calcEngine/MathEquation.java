package calcEngine;

public class MathEquation {
    private double leftVal;
    private double rightVal;
    private char opCode;
    private double result;

    private static int numberOfCalculations;
    private static int sumOfResults;

    public MathEquation() {
    }

    public MathEquation(char opCode) {
        this.opCode = opCode;
    }

    public MathEquation(char opCode, double leftVal, double rightVal) {
        this(opCode);
        this.leftVal = leftVal;
        this.rightVal = rightVal;
    }

    public void execute(double leftVal, double rightVal){
        this.leftVal=leftVal;
        this.rightVal=rightVal;

        execute();
}

    public void execute(int leftVal, int rightVal){
        this.leftVal=leftVal;
        this.rightVal=rightVal;

        execute();
        result= (int) result;
    }

    public double getLeftVal() {
        return leftVal;
    }

    public double getRightVal() {
        return rightVal;
    }

    public char getOpCode() {
        return opCode;
    }
    public double getResult() {
        return result;
    }

    public void getResult(double result) {
        this.result = result;
    }

    public void setLeftVal(double leftVal) {
        this.leftVal = leftVal;
    }

    public void setRightVal(double rightVal) {
        this.rightVal = rightVal;
    }

    public void setOpCode(char opCode) {
        this.opCode = opCode;
    }

    public  static  double getAverage(){
        return sumOfResults / numberOfCalculations;
    }

    void execute(){
        switch (opCode) {
            case 'a':
            case '+':
                result = leftVal + rightVal;
                break;
            case 's':
            case '-':
                result = leftVal - rightVal;
                break;
            case 'm':
            case '*':
                result = leftVal * rightVal;
                break;
            case 'd':
            case '/':
                result = rightVal != 0 ? leftVal / rightVal : 0.0d;
                break;
            default:
                System.out.println("Invalid Opcode: " + opCode);
                result = 0.0d;
                break;
        }

        numberOfCalculations++;
        sumOfResults += result;

    }
}
