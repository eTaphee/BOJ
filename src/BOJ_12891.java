import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_12891 {
    static String dna;

    // 윈도우에 있는 문자의 개수 배열
    static int[] windowCharCountArr = new int[4];

    // 부분 문자열에 포함되어야할 최소 개수 배열
    static int[] checkArr;

    // 검사 통과한 문자 개수
    static int checkedCount = 0;

    // 최대 윈도우 크기 (비밀번호로 사용할 부분 문자열 길이)
    static int maxWindowSize = 0;

    // 현재 윈도우 크기 (누적 부분문자열 길이)
    static int currentWindowSize = 0;

    // 윈도우 시작 인덱스
    static int windowStartIndex = 0;

    // 윈도우 끝 인덱스
    static int windowEndIndex = 0;

    // 만들 수 있는 비밀번호의 개수
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int sLength = Integer.parseInt(tokenizer.nextToken());

        maxWindowSize = Integer.parseInt(tokenizer.nextToken());
        dna = br.readLine();
        checkArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        calcCheckedCount(checkArr);

        // 윈도우 마지막 인덱스가 dna 문자열 길이에 도달하면 종료
        while (windowEndIndex < dna.length()) {
            // 현재 윈도우 사이즈가 최대 윈도우 사이즈가 될 때 까지 문자를 추가해야한다
            while (currentWindowSize != maxWindowSize) {
                addToWindow();
            }

            // 윈도우(부분문자열)이 완성되면 검사
            if (checkedCount == 4) {
                count++;
            }

            removeFromWindow();
        }

        System.out.println(count);
    }

    static int getIndex(char ch) {
        switch (ch) {
            case 'A':
                return 0;
            case 'C':
                return 1;
            case 'G':
                return 2;
            case 'T':
                return 3;
        }
        return -1;
    }

    // 윈도우에 문자를 추가한다.
    static void addToWindow() {
        char ch = dna.charAt(windowEndIndex);
        int index = getIndex(ch);

        // 윈도우에 추가된 문자의 개수를 증가
        windowCharCountArr[index]++;
        if (windowCharCountArr[index] == checkArr[index]) {
            // 윈도우에 추가된 문자의 개수와 최소 개수가 일치하면 검사 통과 문자 개수 1증가
            // 초과되면 증가되지 않음(이미 충족되었으니)
            checkedCount++;
        }

        windowEndIndex++;
        currentWindowSize++;
    }

    // 윈도우에서 문자를 제거한다.
    static void removeFromWindow() {
        char ch = dna.charAt(windowStartIndex);
        int index = getIndex(ch);

        // 최소 개수가 0인 경우 검사 통과 문자의 개수에 이미 포함된 것이니 진행하지 않는다.
        // 즉, 1이상인 경우에만 분기문 진행
        int checkCount = checkArr[index];
        if (checkCount > 0) {
            if(windowCharCountArr[index] == checkCount) {
                // 개수가 같아야만 통과 문자의 개수를 감소시킨다.
                // 분기문이 빠져나가고 윈도우의 문자 개수를 1를 감소시키는데,
                // 윈도우에 포함된 문자의 개수가 최소 개수보다 낮으므로 다시 통과 해야하는 문자의 개수에서 감소
                checkedCount--;
            }
        }

        // 윈도우에서 제거할 문자의 개수를 감소
        windowCharCountArr[index]--;


        windowStartIndex++;
        currentWindowSize--;
    }

    // 검사 통과한 문자 개수 구하기
    static void calcCheckedCount(int[] arr) {
        for (int num : arr) {
            if (num == 0) {
                // 포함해야하는 문자의 최소개수가 0인 경우 검사할 필요가 없으니 검사 통과한 문자를 증가
                checkedCount++;
            }
        }
        System.out.println("A=" + arr[0] + ", C=" + arr[1] + ", G=" + arr[2] + ", T=" + arr[3]);
        System.out.println("검사해야할 문자의 개수=" + (4 - checkedCount));
    }
}
