import java.util.Arrays;
import java.util.Scanner;

public class BOJ_24174 {
    static int swapCount = 0;
    static int K = 0;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        K = scanner.nextInt();
        scanner.nextLine();
        int[] arr = new int[A + 1];

        System.arraycopy(Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray(), 0, arr, 1, A);

        try {
            sortHeap(arr);
        } catch (Exception e) {
        }

        if (swapCount < K) {
            System.out.println(-1);
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < arr.length; i++) {
                sb.append(arr[i]);
                sb.append(" ");
            }
            System.out.println(sb);
        }
    }

    static void swap(int[] A, int a, int b) throws Exception {
        int aValue = A[a];
        A[a] = A[b];
        A[b] = aValue;
        swapCount++;
        if (swapCount == K) {
            throw new Exception();
        }
    }

    static void sortHeap(int[] A) throws Exception {
        buildMinHeap(A, A.length - 1);
        for (int i = A.length - 1; i >= 2; i--) {
            swap(A, 1, i);
            heapify(A, 1, i - 1);
        }
    }

    static void buildMinHeap(int[] A, int n) throws Exception {
        for (int i = (n / 2); i >= 1; i--) {
            heapify(A, i, n);
        }
    }

    static void heapify(int[] A, int k, int n) throws Exception {
        int left = 2 * k;
        int right = 2 * k + 1;
        int smaller = -1;

        if (right <= n) {
            smaller = A[left] < A[right] ? left : right;
        } else if (left <= n) {
            smaller = left;
        } else {
            return;
        }

        if (A[smaller] < A[k]) {
            swap(A, k, smaller);
            heapify(A, smaller, n);
        }
    }
}
