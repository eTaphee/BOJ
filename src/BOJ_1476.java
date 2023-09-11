import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(tokenizer.nextToken());
        int S = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());

        int year = 1;
        int[] yearArr = new int[]{1, 1, 1};
        while (true) {
            if (E == yearArr[0] && S == yearArr[1] && M == yearArr[2]) {
                break;
            }

            year++;
            yearArr[0]++;
            yearArr[1]++;
            yearArr[2]++;
            if (yearArr[0] > 15) {
                yearArr[0] = 1;
            }
            if (yearArr[1] > 28) {
                yearArr[1] = 1;
            }
            if (yearArr[2] > 19) {
                yearArr[2] = 1;
            }
        }

        System.out.println(year);
    }
}
