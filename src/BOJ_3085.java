import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class BOJ_3085 {
    static int N;
    static char[][] board;
    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static Set<Swap> swapSet = new HashSet<>();
    static int maxCandy = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new char[N][N];

        for (int i = 0; i < N; i++) {
            char[] arr = br.readLine().toCharArray();
            board[i] = arr;
        }


        for (int i = 0; i < N; i++) {
            int candyRow = 1;
            int candyCol = 1;
            for (int j = 0; j < N; j++) {
                if (j < N -1 && board[i][j] == board[i][j + 1]) {
                    candyCol++;
                    maxCandy = Math.max(candyCol, maxCandy);
                } else {
                    candyCol = 1;
                }

                if (j < N -1 && board[j][i] == board[j + 1][i]) {
                    candyRow++;
                    maxCandy = Math.max(candyRow, maxCandy);
                } else {
                    candyRow = 1;
                }

                for (int[] dir : dirs) {
                    int swapX = i + dir[0];
                    int swapY = j + dir[1];

                    if (enableSwap(i, j, swapX, swapY)) {
                        swap(i, j, swapX, swapY);
                        maxCandy(i, j, swapX, swapY);
                        swap(i, j, swapX, swapY);
                    }
                }
            }
        }
        System.out.println(maxCandy);
    }

    public static void maxCandy(int x, int y, int swapX, int swapY) {
        int candyCol = 1;
        int candyRow = 1;

        for (int i = 1; i < N; i++) {
            if (board[x][i - 1] == board[x][i]) {
                candyCol++;
                maxCandy = Math.max(candyCol, maxCandy);
            } else {
                candyCol = 1;
            }

            if (board[i - 1][y] == board[i][y]) {
                candyRow++;
                maxCandy = Math.max(candyRow, maxCandy);
            } else {
                candyRow = 1;
            }
        }

        if (x == swapX) {
            int candy = 0;
            for (int i = 1; i < N; i++) {
                if (board[i - 1][swapY] == board[i][swapY]) {
                    candy++;
                    maxCandy = Math.max(candy, maxCandy);
                } else {
                    candy = 1;
                }
            }
        } else if (y == swapY) {
            int candy = 0;
            for (int i = 1; i < N; i++) {
                if (board[swapX][i - 1] == board[swapX][i]) {
                    candy++;
                    maxCandy = Math.max(candy, maxCandy);
                } else {
                    candy = 1;
                }
            }
        }
    }

    public static boolean enableSwap(int x, int y, int swapX, int swapY) {
        if (swapX < 0 || swapX >= N || swapY < 0 || swapY >= N) {
            return false;
        }

        Swap swap = new Swap(x, y, swapX, swapY);
        if (swapSet.contains(swap)) {
            return false;
        }

        return board[x][y] != board[swapX][swapY];
    }

    public static void swap(int x, int y, int swapX, int swapY) {
        char tmp = board[x][y];
        board[x][y] = board[swapX][swapY];
        board[swapX][swapY] = tmp;

        Swap swap = new Swap(x, y, swapX, swapY);
        swapSet.add(swap);
    }

    static class Swap {
        int fromX;
        int fromY;
        int toX;
        int toY;

        Swap(int fromX, int fromY, int toX, int toY) {
            if (fromX < toX) {
                if (fromY < toY) {
                    this.fromX = fromX;
                    this.fromY = fromY;
                    this.toX = toX;
                    this.toY = toY;
                } else {
                    this.fromX = fromX;
                    this.fromY = toY;
                    this.toX = toX;
                    this.toY = fromY;
                }
            } else {
                if (fromY < toY) {
                    this.fromX = toX;
                    this.fromY = fromY;
                    this.toX = fromX;
                    this.toY = toY;
                } else {
                    this.fromX = toX;
                    this.fromY = toY;
                    this.toX = fromX;
                    this.toY = fromY;
                }
            }
        }

        @Override
        public int hashCode() {
            return Objects.hash(fromX, fromY, toX, toY);
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) return true;
            if (!(o instanceof Swap)) return false;
            Swap comp = (Swap) o;
            return this.fromX == comp.fromX && this.fromY == comp.fromY && this.toX == comp.toX && this.toY == comp.toY;
        }
    }
}
