import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        int a = arr[0];
        int b = arr[1];
        while (true) {
            if (b % a == 0) {
                break;
            }
            int tmp = b;
            b = a;
            a = tmp % a;
        }
        System.out.println(a);
        System.out.println((arr[0] * arr[1]) / a);
    }
}
