import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int M = Arrays.stream(arr).max().getAsInt();
        int sum = Arrays.stream(arr).sum();
        double avg = sum / (double)M * 100 / (double)N;
        System.out.println(avg);
    }
}
