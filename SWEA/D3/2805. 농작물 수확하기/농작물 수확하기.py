import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static BufferedReader br;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int map[][] = new int[n][n];
			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				for (int j = 0; j < str.length(); j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}
			int sum = 0;
			int idx = 0;
			int len = 1;
			int flag = 1;
			for (int i = 0; i < n; i++) {
				int start = n / 2 - idx;
				int templen = len;
				while (templen > 0) {
					sum += map[i][start];
					start++;
					templen--;
				}
				if (len == n || flag == 0) {
					len -= 2;
					idx--;
					flag = 0;
				} else {
					len += 2;
					idx++;
				}
			}
			System.out.println("#" + (tc + 1) + " " + sum);
		}
	}

}
