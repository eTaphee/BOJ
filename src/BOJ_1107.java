import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] buttons = new boolean[10];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = true; // 버튼 초기화
        }
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        if (M > 0) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            while (tokenizer.hasMoreTokens()) {
                int button = Integer.parseInt(tokenizer.nextToken());
                buttons[button] = false; // 고장 버튼 false로 변경
            }
        }

        // 변경할 채널이 현재 채널인 경우 종료
        if (N == 100) {
            System.out.println(0);
            return;
        }

        int target = N;
        int digit = (N == 0) ? 1 : (int) Math.log10(N) + 1;
        int now = 0;
        StringBuilder operation = new StringBuilder(); // 리모콘 조작 연산
        while (true) {
            if (digit == 0 || (buttons.length - M == 0)) { // 남은 자리수가 0 또는 멀쩡한 버튼이 없는 경우
                int diff = Math.abs(now - N); // 채널의 차이 만큼 조작
                for (int i = 0; i < diff; i++) {
                    if (now > N) {
                        now--;
                        operation.append("-");
                    } else {
                        now++;
                        operation.append("+");
                    }
                }
            } else {
                int front = (int) (target / Math.pow(10, --digit));
                int button = findButton(buttons, front);
                if (button > -1) {
                    operation.append(button);
                    target -= (button * Math.pow(10, digit));
                    now = (now * 10) + button;
                }
            }

            if (now == N) {
                break;
            }
        }
        System.out.println(operation.length());
        System.out.println(operation);
    }

    public static int findButton(boolean[] buttons, int target) {
        int minIndex = -1;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < buttons.length; i++) {
            if (buttons[i]) {
                int diff = Math.abs(target - i);
                if (diff < min) {
                    min = diff;
                    minIndex = i;
                }
            }
        }

        return minIndex;
    }
}
