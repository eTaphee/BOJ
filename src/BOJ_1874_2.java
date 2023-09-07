import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1874_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        // 수열의 현재 인덱스
        int idx = 0;
        // 스택에 마지막에 들어간 수
        int lastPushed = 0;
        while (true) {
            if (!stack.empty()) {
                int top = stack.peek();
                int num = arr[idx];

                // top과 현재 수열의 값이 같으면
                if (top == num) {
                    idx++; // 수열의 다음 수를 가르킨다.
                    stack.pop(); // 스택에서 꺼내기
                    sb.append("-\n");
                } else if (top > num) {
                    sb.delete(0, sb.length());
                    break;
                }
            }

            if (idx < arr.length && lastPushed < arr[idx]) {
                lastPushed++;
                stack.push(lastPushed);
                sb.append("+\n");
            }

            if (stack.empty()) {
                break;
            }
        }

        if (sb.length() > 0) {
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }
    }
}
