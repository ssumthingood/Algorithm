//https://www.acmicpc.net/contest/problem/939/2
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lab {
	static BufferedReader br;
	static StringTokenizer st;
	static int N;
	static int M;
	static boolean[] printed;
	static int[] cost;
	static int lastBlank = 0;
	static int answer = 0;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		printed = new boolean[N+1];
		cost = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=M;i++) {
			printed[Integer.parseInt(st.nextToken())] = true;
		}
		
		for(int i=1;i<=N;i++) {
			if(!printed[i]) {
				if(lastBlank==0) {
					cost[i] = 7;
					lastBlank = i;
					answer = Math.max(answer, cost[i]);
				}else {
					if(lastBlank == i-1) {
						cost[i] = cost[i-1]+2;
						lastBlank = i;
						answer = Math.max(answer, cost[i]);
					}else {
						cost[i] = Math.min(cost[lastBlank]+2*(i-(lastBlank)), cost[lastBlank]+7);
						lastBlank = i;
						answer = Math.max(answer, cost[i]);
					}
				}
			}
		}
		System.out.println(answer);
	}
}