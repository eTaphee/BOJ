import java.util.Arrays;
import java.util.Scanner;

public class BOJ_26008 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] NMA = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int H = scanner.nextInt();
        int N = NMA[0];
        int M = NMA[1];
        int A = NMA[2];

        long nn = (long)Math.pow(10, 9) + 7;
        long result = 1;
        for (int i = 1; i <= N -1; i++) {
            result *= M;
            result %= nn;
        }
        System.out.println(result);

//        int[] P = new int[N];
//        for (int i = 0; i < Math.pow(M, N); i++) {
//            int n = i;
//            int idx = N - 1;
//            while (n != 0) {
//                int mod = n % M;
//                P[idx] = mod;
//                n /= M;
//                idx--;
//            }
//
//            int hash = getHash(P, M, A);
//            if (hash == H && !map.containsKey(hash)) {
//                map.put(hash, 0);
//            }
//            map.computeIfPresent(hash, (k, v) -> { return v + 1; });
//
//            if (hash == H) {
//                System.out.println(String.format("%s => num: %d, hash: %d", Arrays.toString(P), i, hash));
//
//            }
////            System.out.println(Arrays.toString(P) + " => " + hash);4
//
//        }
//
//        System.out.println((int)(map.get(H) % (Math.pow(10, 7) + 7)));
    }

    public static int getHash(int[] P, int M, int A) {
        int sum = 0;
        for (int i = 0; i < P.length; i++) {
            sum += (P[i] * Math.pow(A, i));
        }
        return sum % M;
    }
}
