import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_10807 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 선언

        int N = Integer.parseInt(br.readLine());
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> map = new HashMap<>();

        while (tokenizer.hasMoreTokens()) {
            int key = Integer.parseInt(tokenizer.nextToken());
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        System.out.println(map.getOrDefault(v, 0));
    }
}
