import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2961 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] S = new int[N];
        int[] B = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            S[i] = Integer.parseInt(tokenizer.nextToken());
            B[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < (int)Math.pow(2, N); i++) {
            char[] arr = Integer.toBinaryString(i).toCharArray();
            int diff = 0;
            int ssum = 1;
            int bsum = 0;
            for (int j = 0; j < arr.length; j++) {
                if ((i & (1 << j)) > 0) {
                    ssum *= S[j];
                    bsum += B[j];
                }
            }
            diff = Math.abs(ssum - bsum);
            min = Math.min(min, diff);
        }

        System.out.println(min);
    }
}
