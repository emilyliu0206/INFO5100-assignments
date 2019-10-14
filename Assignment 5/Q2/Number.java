public class Number {
    public static int count(int x, int y){
        try{
            return x/y;
        }
        catch (ArithmeticException arithmeticException){
            System.err.print("Error:" + arithmeticException.getMessage());
        }
        return 0;
    }
}
