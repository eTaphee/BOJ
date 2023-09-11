import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int T = Integer.parseInt(br.readLine());
//
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < T; i++) {
//            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
//            int M = Integer.parseInt(tokenizer.nextToken());
//            int N = Integer.parseInt(tokenizer.nextToken());
//            int x = Integer.parseInt(tokenizer.nextToken());
//            int y = Integer.parseInt(tokenizer.nextToken());
//            sb.append(getYear(M, N, x, y)).append("\n");
//        }
//        System.out.println(sb);
//
//        System.out.println(getYear(40000, 39999, 39999, 39998)); // 83
//        System.out.println(getYear(40000, 39999, 40000, 39999)); // 83
//        System.out.println(getYear(39999, 2, 39998, 2)); // 83
//        System.out.println(getYear(13,11,5,6)); // 83
//        System.out.println(getYear(13,11,5,7)); // 18
        System.out.println(getYear(13,8,8,4)); // 18
//        System.out.println(getYear(13,11,5,9)); // 31
//        System.out.println(getYear(13,11,11,11));


//                System.out.println(getYear(3, 1, 1, 1));//ok
//                System.out.println(getYear(3, 2, 1, 1));//ok
//                System.out.println(getYear(3, 2, 1, 2));//ok
//                System.out.println(getYear(3, 2, 2, 1));//ok
//                System.out.println(getYear(3, 2, 2, 2));//ok
//                System.out.println(getYear(3, 2, 3, 1));//ok
//                System.out.println(getYear(3, 2, 3, 2));//ok

//        System.out.println(getYear(10, 12, 5, 1));//ok
//        System.out.println(getYear(10, 12, 1, 1));//ok
//        System.out.println(getYear(10, 12, 1, 2));//no
//        System.out.println(getYear(10, 12, 1, 3));//ok
//        System.out.println(getYear(10, 12, 1, 4)); // no
//        System.out.println(getYear(10, 12, 1, 5)); // ok
//        System.out.println(getYear(10, 12, 1, 6)); // no
//        System.out.println(getYear(10, 12, 1, 7)); // ok
//        System.out.println(getYear(10, 12, 1, 8)); // no
//        System.out.println(getYear(10, 12, 1, 9)); // ok
//        System.out.println(getYear(10, 12, 1, 10)); // no
//        System.out.println(getYear(10, 12, 1, 11)); // ok
//        System.out.println(getYear(10, 12, 1, 12)); // no
//        System.out.println(getYear(10, 12, 10, 11)); // no
//        System.out.println(getYear(10, 12, 10, 12)); // no

//        System.out.println(getYear(13, 11, 1, 1)); // ok
//        System.out.println(getYear(13, 11, 1, 2)); // ok
//        System.out.println(getYear(13, 11, 1, 3)); // ok
//        System.out.println(getYear(13, 11, 1, 4)); // ok
//        System.out.println(getYear(13, 11, 1, 5)); // ok
//        System.out.println(getYear(13, 11, 1, 6)); // ok
//        System.out.println(getYear(13, 11, 1, 7)); // ok
//        System.out.println(getYear(13, 11, 1, 8)); // ok
//        System.out.println(getYear(13, 11, 1, 9)); // ok
//        System.out.println(getYear(13, 11, 1, 10)); // ok // 13, 11 중 작은수 이하의 공약수가 아닌 경우에?
//        System.out.println(getYear(13, 11, 1, 11)); // ok
//        System.out.println(getYear(13, 11, 13, 11)); // ok // 13 11은 소수여서 뭘 넣어도 ok
//        System.out.println(getYear(13, 11, 10, 11)); // ok // 13 11은 소수여서 뭘 넣어도 ok

//        System.out.println(getYear(12, 14, 1, 6)); // no
//        System.out.println(getYear(12, 14, 1, 3)); // ok
//        System.out.println(getYear(12, 14, 6, 8)); // ok
    }

    public static int getYear(int M, int N, int x, int y) {
        int year = x;
        int[] arr = new int[]{x, x};

        if (x > 1 && x < M && y > 1 && y < M) {
            int modMx = modmod(M, x);
            int modMy = modmod(M, y);
            int modNx = modmod(N, x);
            int modNy = modmod(N, y);

            if ((modMx + modMy + modNx + modNy) == 0) {
                return -1;
            }
        }

        while (true) {
            if (arr[0] == x && arr[1] == y) {
                break;

            }

            year += M;
            arr[1] = year % N;
        }

        return year;
    }

    public static int modmod(int M, int m) {
        while (true) {
            int mod = M % m;
            if (mod == 0) {
                return 0;
            } else if (mod == 1) {
                return 1;
            }
            M = m;
            m = mod;
        }
    }
}
