import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int digit = (int) Math.log10(N) + 1;
        int remain = N;
        long length = 0;
        for (int i = digit - 1; i >= 0; i--) {
            int between = remain - (int)Math.pow(10, i) + 1;
            length += (between * (digit--));
            remain -= between;
        }

        System.out.println(length);
    }
}
