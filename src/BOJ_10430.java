import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_10430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int A = arr[0];
        int B = arr[1];
        int C = arr[2];

        System.out.println((A + B) % C);
        System.out.println(((A % C) + (B % C)) % C);
        System.out.println((A * B) % C);
        System.out.println((A % C) * (B % C) % C);
    }
}
