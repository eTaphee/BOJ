import java.io.*;

public class BOJ_17425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        long[] dp = new long[1_000_000 + 1];
        boolean[] primeArr = new boolean[1_000_000 + 1];
        for (int i = 2; i < primeArr.length; i++) {
            primeArr[i] = true;
        }

        for (int i = 2; i * i < primeArr.length; i++) {
            if (primeArr[i]) {
                for (int j = i * i; j < primeArr.length; j += i) {
                    primeArr[j] = false;
                }
            }
        }

        for (int i = 1; i < dp.length; i++) {
            if (primeArr[i]) {
                dp[i] = i + 1;
            } else {
                
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            long sum = 1 + N;
            if (!primeArr[N]) {
                for (int j = 1; j <= N / 2; j++) {
                    sum += (N / j) * j;
                }
            }
            bw.append(sum + "\n");
        }

        bw.flush();
    }
}
