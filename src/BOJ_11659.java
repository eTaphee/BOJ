import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] line1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = line1[0];
        int M = line1[1];
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        long[] sumArr = new long[N + 1];

        for (int i = 1; i < sumArr.length; i++) {
            sumArr[i] = arr[i - 1] + sumArr[i - 1];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int from = line[0];
            int to = line[1];
            long subSum = sumArr[to] - sumArr[from - 1];
            sb.append(subSum + "\n");
        }

        System.out.println(sb);
    }
}
