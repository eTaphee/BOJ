import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_6588 {

    public static void main(String[] args) throws IOException {
        boolean[] prime = new boolean[1_000_000 + 1];

        for (int i = 2; i < prime.length; i++) {
            prime[i] = true;
        }

        for (int i = 2; i * i < prime.length; i++) {
            if (prime[i]) {
                for (int j = i * i; j < prime.length; j += i) {
                    prime[j] = false;
                }
            }
        }

        PrimeNode node = null;
        PrimeNode[] nodes = new PrimeNode[prime.length];
        PrimeNode first = null;
        for (int i = 2; i < prime.length; i++) {
            if (prime[i]) {
                if (node == null) {
                    node = new PrimeNode(i, null, null);
                    first = node;
                } else {
                    PrimeNode prev = node;
                    node = new PrimeNode(i, null, prev);
                    prev.next = node;
                }
                nodes[i] = node;
            }
        }


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = 0;
        do {
            num = Integer.parseInt(br.readLine());
            if (num == 0) break;

            int idx = num - 1;
            PrimeNode p1Node = first;
            PrimeNode p2Node = nodes[idx];

            while (p2Node == null) {
                p2Node = nodes[--idx];
            }

            int sum = 0;
            while (true) {
                // 6 = 3 + 3
//                if (p1Node == p2Node) {
//                    break;
//                }

                sum = p1Node.num + p2Node.num;
                if (sum > num) {
                    p2Node = p2Node.prev;
                } else if (sum < num) {
                    p1Node = nodes[num - p2Node.num];// p1Node.next;
                    int p1 = (num - p2Node.num) + 1;
                    while (p1Node == null) {
                        p1Node = nodes[p1++];
                    }
                } else {
                    break;
                }
            }

            if (sum == num) {
                sb.append(num + " = " + p1Node.num + " + " + p2Node.num + "\n");
//        sb.append(String.format("%d = %d + %d\n", num, p1Node.num, p2Node.num));
            } else {
                sb.append("Goldbach's conjecture is wrong.\n");
            }
        } while (num != 0);

        System.out.println(sb);
    }
}

class PrimeNode {
    int num;
    PrimeNode next;
    PrimeNode prev;

    public PrimeNode(int num, PrimeNode next, PrimeNode prev) {
        this.num = num;
        this.next = next;
        this.prev = prev;
    }
}
