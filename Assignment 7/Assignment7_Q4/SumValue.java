package Assignment7_Q4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class SumValue {
    public static void main(String[] args){
        int[] arr = new int[4000000];
        generateRandomArray(arr);
        long sum = sum(arr);
        System.out.println("Sum: " + sum);
    }

    /*generate array of random numbers*/
    static void generateRandomArray(int[] arr){
        Random random = new Random();
        for(int i = 0; i < arr.length; i++){
            arr[i] = random.nextInt(10);
        }
    }

    /*get sum of an array using 4 threads*/
    public static long sum(int[] arr) {
        List<Long> alist = new ArrayList<>();
        long actualTotal = 0;
        for(int i = 0; i < arr.length; i++){
            alist.add((long)arr[i]);
        }
        try {
            ForkJoinPool customThreadPool = new ForkJoinPool(4);
            actualTotal = customThreadPool.submit(
                    () -> alist.parallelStream().reduce(0L, Long::sum)).get();

        } catch (Exception e){
            throw new RuntimeException(e);
        }
        return actualTotal;
    }
}
