import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ_11047 {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NK = br.readLine().split(" ");
        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);
        PriorityQueue<Integer> coins = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < N; i++) {
            int coin = Integer.parseInt(br.readLine());
            if (coin <= K) {
                coins.offer(coin);
            }
        }

        int count = 0;
        while (K != 0) {
            int coin = coins.peek();
            if (K < coin) {
                coins.poll();
                continue;
            }
            K -= coin;
            count++;
            if (K < coin) {
                coins.poll();
            }
        }

        System.out.println(count);
    }
}
