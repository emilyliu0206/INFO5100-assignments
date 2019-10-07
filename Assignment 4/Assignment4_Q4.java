package Assignment4;

public class Assignment4_Q4 {

    public int[][] multiplyMetrics(int[][] A, int[][] B){

        int rowA = A.length;
        int columnA = A[0].length;
        int columnB = B[0].length;
        int[][] product = new int[rowA][columnB];

        for(int i = 0; i < rowA; i++) {
            for (int j = 0; j < columnB; j++) {
                for (int k = 0; k < columnA; k++) {
                    product[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return product;
    }
}
