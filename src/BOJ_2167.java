import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2167 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N, M;
        String[] line1 = br.readLine().split(" ");
        N = Integer.parseInt(line1[0]);
        M = Integer.parseInt(line1[1]);
        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] arrValues = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(arrValues[j]);
            }
        }

        int K = Integer.parseInt(br.readLine());
        Range[] ranges = new Range[K];
        int[] result = new int[K];

        for (int i = 0; i < K; i++) {
            ranges[i] = new Range(br.readLine().split(" "));

            for (int j = ranges[i].i - 1; j <= ranges[i].x - 1; j++) {
                for (int k = ranges[i].j - 1; k <= ranges[i].y - 1; k++) {
                    result[i] += arr[j][k];
                }
            }
        }

        for (int a : result) {
            System.out.println(a);
        }
    }
}

class Range {
    int i;
    int j;
    int x;
    int y;

    public Range(String[] arr) {
        i = Integer.parseInt(arr[0]);
        j = Integer.parseInt(arr[1]);
        x = Integer.parseInt(arr[2]);
        y = Integer.parseInt(arr[3]);
    }

    @Override
    public String toString() {
        return String.format("(%d, %d), (%d, %d)", i, j, x, y);
    }
}
