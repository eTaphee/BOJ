import java.util.Scanner;

public class BOJ_11720 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String sNum = scanner.next();

        int sum = 0;
        for (char cNum : sNum.toCharArray()) {
            sum += (cNum - '0');
        }
        System.out.println(sum);
    }
}
