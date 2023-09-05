import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9012_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            int cnt = 0;
            for (char ch : str.toCharArray()) {
                if (ch == '(') {
                    cnt++;
                } else {
                    cnt--;
                }
                if (cnt < 0) {
                    break;
                }
            }
            if (cnt == 0) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }

        System.out.println(sb);
    }
}
