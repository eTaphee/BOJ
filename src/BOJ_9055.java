import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            int[] arr = new int[num + 1];

            if (num <= 2) {
                sb.append(num).append("\n");
            } else {
                arr[1] = 1;
                arr[2] = 2;
                arr[3] = 4;

                for (int j = 4; j < arr.length; j++) {
                    arr[j] = arr[j - 1] + arr[j - 2] + arr[j - 3];
                }

                sb.append(arr[num]).append("\n");
            }
        }
        System.out.println(sb);
    }
}
