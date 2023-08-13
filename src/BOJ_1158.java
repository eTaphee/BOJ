import java.util.*;
import java.util.stream.Collectors;

public class BOJ_1158 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int K = scanner.nextInt();

//        solution1(N, K);
        solution2(N, K);
    }

    public static void solution1(int N, int K) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> permutation = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(i + 1);
        }

        int idx = -1;
        int cnt = 0;
        while (list.size() > 0) {
            cnt++;
            idx++;
            if (cnt % K == 0) {
                idx = idx % list.size();
                permutation.add(list.remove(idx));
                idx--;
            }
        }

        printData(permutation);
    }

    public static void solution2(int N, int K) {
        Node head = null;
        Node tail = null;
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if (head == null) {
                Node newNode = new Node(i + 1, null, null);
                head = newNode;
                tail = newNode;
                head.next = tail;
                tail.prev = head;
                continue;
            }

            Node newNode = new Node(i + 1, tail, head);
            tail.next = newNode;
            tail = newNode;
            head.prev = newNode;
        }

//        Node cur = head;
//        do {
//            System.out.print(cur.data + " ");
//            cur = cur.next;
//        } while (cur != head);
//        System.out.println();

        Node cur = head;
        int cnt = 1;
        do {
            if (cnt % K == 0) {
                cur.prev.next = cur.next;
                cur.next.prev = cur.prev;
                list.add(cur.data);
            }
            cur = cur.next;
            cnt++;
        } while (cur.next != cur);
        list.add(cur.data);

        printData(list);
    }

    public static void printData(ArrayList<Integer> list) {
        System.out.printf("<%s>", String.join(", ", list.stream().map(String::valueOf).collect(Collectors.toList())));
        System.out.println();
    }
}

class Node {
    int data;
    Node prev;
    Node next;

    Node(int data, Node prev, Node next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }
}