import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ_4375 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        while (true) {
//            BigInteger num = BigInteger.valueOf(Integer.parseInt(br.readLine()));
//            BigInteger bigInt = BigInteger.valueOf(0);
//            int exponent = 0;
//            while (true) {
//                bigInt = BigInteger.valueOf(10).pow(exponent++).add(bigInt);
//                if (bigInt.mod(num) == BigInteger.valueOf(0)) {
//                    System.out.println(exponent);
//                    break;
//                }
//            }
//        }
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                long num = Long.parseLong(br.readLine());
                long digit = 1;
                long modsum = 1;
                while (modsum % num != 0) {
                    modsum = ((modsum * 10L) + 1L) % num;
                    digit++;
                }
                System.out.println(digit);
            } catch (NumberFormatException e) {
                // 빈칸 입력 시 예외 발생
                return;
            }
        }
    }
}
