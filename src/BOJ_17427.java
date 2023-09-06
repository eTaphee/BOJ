import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ_17427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += (N / i) * i;
        }

        System.out.println(sum);
    }


//    static int[] dp;
//    static boolean[] primeArr = new boolean[1_000_000 + 1];
//    static BigInteger bigInteger = BigInteger.valueOf(0);
//
//    public static void main(String[] args) throws IOException {
//        for (int i = 2; i < primeArr.length; i++) {
//            primeArr[i] = true;
//        }
//
//        for (int i = 2; i * i < primeArr.length; i++) {
//            if (primeArr[i]) {
//                for (int j = i * i; j < primeArr.length; j += i) {
//                    primeArr[j] = false;
//                }
//            }
//        }
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//
//        long sum = 0;
//        for(int i = 1; i <= N; i++ ) {
//            sum += (N / i) * i;
//        }
//        System.out.println(sum);
//
////        dp = new int[N + 1];
////        dp[1] = 1;
//////        System.out.println(g_N(N));
////        g_N(N);
////        System.out.println(bigInteger);
//    }
//
//    public static int f_A(int A) {
//        if (dp[A] != 0) {
//            return dp[A];
//        }
//
//        if (primeArr[A]) {
//            dp[A] = 1 + A;
//            return dp[A];
//        }
//
//        int sum = A + 1;
//        for (int i = 2; i <= A / 2; i++) {
//            if (A % i == 0) {
//                sum += i;
//            }
//        }
//
//        dp[A] = sum;
//        return dp[A];
//    }
//
//    public static int g_N(int N) {
//        int result = 0;
//        for (int i = 1; i <= N; i++) {
//            bigInteger= bigInteger.add(BigInteger.valueOf(f_A(i)));
////            result += f_A(i);
//        }
//        return result;
//    }
//
//    public static boolean isPrime(int num) {
//        for (int i = 2; i <= num / 2; i++) {
//            if (num % i == 0) {
//                return false;
//            }
//        }
//
//        return true;
//    }
}
