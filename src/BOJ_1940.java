import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);

        int sIdx = 0;
        int eIdx = arr.length - 1;
        int armour = 0;
        int count = 0;
        while (sIdx < eIdx) {
            armour = arr[sIdx] + arr[eIdx];
            if (armour == M) {
                count++;
                sIdx++;
                eIdx--;
            } else if (armour < M) {
                sIdx++;
            } else if (armour > M) {
                eIdx--;
            }
        }
        System.out.println(count);
    }
}
