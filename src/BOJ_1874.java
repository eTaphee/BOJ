import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        n = 1;
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!stack.empty() && stack.peek() == arr[idx]) {
                stack.pop();
                idx++;
                sb.append("-\n");
            } else {
                stack.push(n++);
                sb.append("+\n");
            }

            if (n > arr.length + 1 || idx == arr.length - 1) {
                if (!stack.empty() && stack.peek() == arr[idx]) {
                    stack.pop();
                    sb.append("-");
                }
                break;
            }
        }

        if (stack.empty()) {
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }
    }
}
