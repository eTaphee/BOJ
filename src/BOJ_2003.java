import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line1 = br.readLine().split(" ");
        int N = Integer.parseInt(line1[0]);
        int M = Integer.parseInt(line1[1]);
        int[] arr = new int[N];

        int idx = 0;
        for (String s : br.readLine().split(" ")) {
            arr[idx++] = Integer.parseInt(s);
        }

        int count = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == M) {
                count++;
                sum = 0;
                continue;
            } else if (sum > M) {
                sum = 0;
                continue;
            }
            for (int j = i + 1; j < arr.length; j++) {
                sum += arr[j];
                if (sum == M) {
                    count++;
                    sum = 0;
                    break;
                } else if (sum > M) {
                    sum = 0;
                    break;
                }
            }
            sum = 0;
        }

        System.out.println(count);
    }
}
