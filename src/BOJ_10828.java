import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        Stack stack = new Stack(10000);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            String command = br.readLine();

            if (command.startsWith("push")) {
                stack.push(Integer.parseInt(command.split(" ")[1]));
            } else {
                if (command.startsWith("pop")) {
                    sb.append(stack.pop());
                } else if (command.startsWith("top")) {
                    sb.append(stack.top());
                } else if (command.startsWith("size")) {
                    sb.append(stack.size());
                } else if (command.startsWith("empty")) {
                    sb.append(stack.empty());
                }

                if (i < size - 1) {
                    sb.append("\n");
                }
            }
        }

        br.close();

        System.out.println(sb);
    }
}

class Stack {
    int size = 0;
    int[] arr;
    int idx = 0;

    Stack(int size) {
        this.size = size;
        this.arr = new int[size];
        this.idx = 0;
    }

    boolean isFull() {
        return (idx) == size;
    }

    public void push(int num) {
        if (isFull()) {
            return;
        }
        arr[idx++] = num;
    }

    public int pop() {
        if (idx == 0) {
            return -1;
        }

        return arr[--idx];
    }

    public int top() {
        if (idx == 0) {
            return -1;
        }

        return arr[idx - 1];
    }

    public int size() {
        if (idx == 0) {
            return 0;
        }

        return this.idx;
    }

    public int empty() {
        if (idx == 0) {
            return 1;
        }
        return 0;
    }
}