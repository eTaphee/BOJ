import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_1920 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        Set<Integer> set = new HashSet<>();
//        int N = Integer.parseInt(br.readLine());
//        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
//        while (tokenizer.hasMoreTokens()) {
//            set.add(Integer.parseInt(tokenizer.nextToken()));
//        }
//        int M = Integer.parseInt(br.readLine());
//        tokenizer = new StringTokenizer(br.readLine());
//        StringBuilder sb = new StringBuilder();
//        while (tokenizer.hasMoreTokens()) {
//            if (set.contains(Integer.parseInt(tokenizer.nextToken()))) {
//                sb.append("1\n");
//            } else {
//                sb.append("0\n");
//            }
//        }
//        System.out.println(sb);
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }
        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        tokenizer = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(tokenizer.nextToken());
            if (binarySearch(arr, num)) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }
        System.out.println(sb);
    }

    public static boolean binarySearch(int[] arr, int num) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == num) {
                return true;
            } else if (num < arr[mid]) {
                right = mid - 1;
            } else if (arr[mid] < num) {
                left = mid + 1;
            }
        }

        return false;
    }
}
