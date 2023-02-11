
//https://www.acmicpc.net/contest/problem/939/1
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gorani {
	static BufferedReader br;
	static StringTokenizer st;
	static int N;
	static int M;
	static int minR = Integer.MAX_VALUE;
	static int minC = Integer.MAX_VALUE;
	static int answerR = 0;
	static int answerC = 1;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int target = Integer.parseInt(st.nextToken());
			
			if (target < minR) {
				minR = target;
				answerR = i;
			}
			if (i == N) {
				minC = target;
			}
		}
		
		for (int i = 2; i <= M; i++) {
			int target = Integer.parseInt(st.nextToken());
			if (target < minC) {
				minC = target;
				answerC = i;
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(answerR).append(" ").append(answerC);
		System.out.println(sb);
	}
}
