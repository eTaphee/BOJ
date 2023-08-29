import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1254 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        StringBuilder sb = new StringBuilder(S);

        int idx = 0;
        int length = sb.length();
        while (true) {
            int left = 0;
            int right = sb.length() - 1;
            boolean flag = false;

            while (left < right) {
                if (sb.charAt(left) != sb.charAt(right)) {
                    flag = true;
                    break;
                }
                left++;
                right--;
            }
            if (!flag) {
                break;
            }
            sb.insert(length, sb.charAt(idx++));
        }

        System.out.println(sb);
        System.out.println(sb.length());
    }
}
