 import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br;
    public static int recur(int k, int cnt) {
        // 종료 조건
        int flag = 0;
        int sum = Integer.MAX_VALUE;
        for (int i = 2; i * i <= k; i++) {
            if (k % i == 0) {
                flag = 1;
                int max = Math.max(recur(i, cnt + 1), recur(k / i, cnt + 1));
                sum = Math.min(max, sum);
            }
        }

        if (flag == 0) {
            return cnt;
        }
        return sum;

    }

    public static void main(String[] args) throws IOException {
    	br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        System.out.println(recur(k, 0));
    }
}