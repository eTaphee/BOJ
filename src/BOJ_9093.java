import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        String[] arr = new String[T];

        for (int i = 0; i < T; i++) {
            arr[i] = br.readLine();
        }

        StringBuilder sb = new StringBuilder();
        for (String str : arr) {
            for (String s : str.split(" ")) {
                for (int i = s.length() - 1; i >= 0; i--) {
                    sb.append(s.charAt(i));
                }
                sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
