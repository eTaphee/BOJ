import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int start = input[0];
        start = (start == 1) ? 2 : start;
        int end = input[1];
        boolean[] arr = new boolean[end + 1];
        for (int i = 2; i <= end; i++) {
            arr[i] = true;
        }

        for (int i = 2; i * i <= arr.length; i++) {
            if (arr[i]) {
                for (int j = i * i; j < arr.length; j += i) {
                    arr[j] = false;
                }
            }
        }

        for (int i = start; i <= end; i++) {
            if (arr[i]) {
                System.out.println(i);
            }
        }
    }
}
