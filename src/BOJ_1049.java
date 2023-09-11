import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1049 {
    static int[] priceArr;
    static int[] copyPriceArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int cutOffStrings = Integer.parseInt(tokenizer.nextToken());
        int brandCount = Integer.parseInt(tokenizer.nextToken());

        priceArr = new int[brandCount * 2];
        copyPriceArr = new int[priceArr.length];

        for (int i = 0; i < brandCount; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            priceArr[2 * i] = Integer.parseInt(tokenizer.nextToken());
            priceArr[2 * i + 1] = Integer.parseInt(tokenizer.nextToken());
        }

        int minPrice = 0;
        while (cutOffStrings != 0) {
            if (cutOffStrings >= 6) {
                minPrice += getMinPrice(6);
                cutOffStrings -= 6;
            } else {
                minPrice += getMinPrice(cutOffStrings);
                cutOffStrings -= cutOffStrings;
            }
        }

        System.out.println(minPrice);
    }

    // 남은 기타줄을 인자로 받는다.
    public static int getMinPrice(int curOffStrings) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < copyPriceArr.length; i++) {
            if (i % 2 == 1) {
                copyPriceArr[i] = priceArr[i] * curOffStrings; // 낱개 가격에 패키지 개수만 큼 저장
            } else {
                copyPriceArr[i] = priceArr[i];
            }
            min = Math.min(min, copyPriceArr[i]);
        }
        return min;
    }
}
