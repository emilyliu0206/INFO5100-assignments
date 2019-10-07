package Assignment4;

public class Assignment4_Q5 {
        public static int[] diStringMatch(String S) {
            int N = S.length();
            int lo = 0, hi = N;
            int[] result = new int[N + 1];
            for (int i = 0; i < N; ++i) {
                if (S.charAt( i ) == 'I')
                    result[i] = lo++;
                else
                    result[i] = hi--;
            }

            result[N] = lo;
            return result;
        }
}
