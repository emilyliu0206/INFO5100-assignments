import java.util.Arrays;

public class MyIndexOutOfBoundException extends RuntimeException{
    private int lowerBound, upperBound, index;
    private MyIndexOutOfBoundException(int current, int lower_bound, int upper_bound) {
        this.index = current;
        this.lowerBound = lower_bound;
        this.upperBound = upper_bound;
    }

    public String toString() {
        return "Error Message: Index: " + index +
                ", but Lower bound: " + this.lowerBound +
                ", Upper Bound: " + this.upperBound;
    }

    public static void main(String[] args){
        final int LIST_SIZE = 10;
        int[] list_of_zeros = new int[LIST_SIZE];
        Arrays.fill(list_of_zeros, 0);
        for(int i = 0; i < 11; i++){
            try{
                if (i >= LIST_SIZE){
                    throw new MyIndexOutOfBoundException(i, 0, LIST_SIZE - 1);
                } else{
                    System.out.println(list_of_zeros[i]);
                }
            }catch (MyIndexOutOfBoundException e){
                System.out.println(e.toString());
            }
        }


    }


}
