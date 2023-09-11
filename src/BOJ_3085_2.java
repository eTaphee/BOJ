import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3085_2 {
    static int N;
    static char[][] board;
    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int maxCandy = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new char[N][N];

        for (int i = 0; i < N; i++) {
            char[] arr = br.readLine().toCharArray();
            board[i] = arr;
            for (int j = 0; j < N; j++) {
                maxCandy = Math.max(maxCandy, getMaxCandy(i, j));
                if (maxCandy == N) {
                    System.out.println(maxCandy);
                    return;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int[] dir : dirs) {
                    int newX = i + dir[0];
                    int newY = j + dir[1];
                    if (enableSwap(i, j, newX, newY)) {
                        swap(i, j, newX, newY);
                        maxCandy = Math.max(maxCandy, getMaxCandy(i, j));
                        if (maxCandy == N) {
                            System.out.println(maxCandy);
                            return;
                        }
                        swap(i, j, newX, newY);
                    }
                }
            }
        }
        System.out.println(maxCandy);
    }

    public static void swap(int x1, int y1, int x2, int y2) {
        char tmp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = tmp;
    }

    public static boolean enableSwap(int x1, int y1, int x2, int y2) {
        if (x2 < 0 || x2 >= N || y2 < 0 || y2 >= N) {
            return false;
        }

        return board[x1][y1] != board[x2][y2];
    }

    public static int getMaxCandy(int x, int y) {
        int rowCount = 1;
        int colCount = 1;
        int rowMax = 1;
        int colMax = 1;

        for (int i = 0; i < N - 1; i++) {
            if (board[i][y] == board[i + 1][y] && board[i][y] != Character.MIN_VALUE && board[i + 1][y] != Character.MIN_VALUE) {
                rowCount++;
                rowMax = Math.max(rowCount, rowMax);
            } else {
                rowCount = 1;
            }

            if (board[x][i] == board[x][i + 1] && board[x][i] != Character.MIN_VALUE && board[x][i + 1] != Character.MIN_VALUE) {
                colCount++;
                colMax = Math.max(colCount, colMax);
            } else {
                colCount = 1;
            }
        }

        return Math.max(rowMax, colMax);
    }
}
