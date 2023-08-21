import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5613 {
    public static boolean isOperator(String str) {
        return "+".equals(str) || "-".equals(str) || "*".equals(str) || "/".equals(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int result = 0;
        String op = "+";
        while (true) {
            String str = br.readLine();

            if (str.equals("=")) {
                break;
            }

            if (isOperator(str)) {
                op = str;
            } else {
                int num = Integer.parseInt(str);
                switch (op) {
                    case "+":
                        result += num;
                        break;
                    case "-":
                        result -= num;
                        break;
                    case "*":
                        result *= num;
                        break;
                    case "/":
                        result /= num;
                        break;
                }
            }
        }

        System.out.println(result);
    }
}
