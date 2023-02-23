import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static BufferedReader br;
	static StringTokenizer st;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		br =new BufferedReader(new InputStreamReader(System.in));
		st=  new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[100001];
		bfs(N,0);
	}
	static void bfs(int n, int i) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {n,i});
		visited[n] = true;
		while(true) {
			int[] next = q.poll();
			if(next[0]==M) {
				System.out.println(next[1]);
				return;
			}
			
			if(next[0]<M) {
				if( next[0] <=50000 && !visited[next[0]*2]) {
					visited[next[0]*2] = true;
					q.add(new int[] {next[0]*2, next[1]+1});					
				}
				
				if(!visited[next[0]+1]) {
					visited[next[0]+1] = true;
					q.add(new int[] {next[0]+1, next[1]+1});					
				}
			}
			
			if(next[0]>=1) {
				if(!visited[next[0]-1]) {
					visited[next[0]-1] = true;
					q.add(new int[] {next[0]-1, next[1]+1});					
				}
			}
		}
	}
}