import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int start = 1;
        int end = 1;
        int cnt = 0;
        int sum = 1;
        while (true) {
            if (sum < N) {
                end++;
                sum += end;
            } else if (sum > N) {
                sum -= start;
                start++;
            }

            if (sum == N) {
                cnt++;
                end++;
                sum += end;
            }

            if (end > N) {
                break;
            }
        }
        System.out.println(cnt);
    }
}
