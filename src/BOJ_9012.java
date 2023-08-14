import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9012 {

    static boolean isVPS(String str) {
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else {
                if (stack.empty()) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.empty();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

         int T = Integer.parseInt(br.readLine());

         for (int i = 0; i < T; i++) {
             if (isVPS(br.readLine())) {
                 System.out.println("YES");
             } else {
                 System.out.println("NO");
             }
         }
    }
}
