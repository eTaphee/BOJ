import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_1541 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String expression = br.readLine();
//        ArrayList<Integer> list = new ArrayList<>();
//
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < expression.length(); i++) {
//            char ch = expression.charAt(i);
//            if (ch == '+' || ch == '-') {
//                if (sb.length() > 0) {
//                    list.add(Integer.parseInt(sb.toString()));
//                    sb.delete(0, sb.length());
//                }
//                sb.append(ch);
//            } else {
//                sb.append(ch);
//            }
//        }
//        if (sb.length() > 0) {
//            list.add(Integer.parseInt(sb.toString()));
//        }
//
//        int result = 0;
//        int tmp = 0;
//        for (int num : list) {
//            if (num < 0) {
//                if (tmp != 0) {
//                    result += tmp * -1;
//                    tmp = 0;
//                }
//                tmp += Math.abs(num);
//            } else {
//                if (tmp != 0) {
//                    tmp += num;
//                } else {
//                    result += num;
//                }
//            }
//        }
//
//        if (tmp != 0) {
//            result += tmp * -1;
//        }
//
//        System.out.println(result);
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expression = br.readLine();

        int result = 0;
        for (String subexpression: expression.split("-")) {
            int subSum = 0;
            for (String str : subexpression.split("[+]")) {
                subSum += Integer.parseInt(str);
            }

            if (result == 0) {
                result += subSum;
            } else {
                result = result - subSum;
            }
        }

        System.out.println(result);
    }
}
