import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int[][] board;
	static int N;
	static int M;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int answer = 0;
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // N개의 점
		M = Integer.parseInt(st.nextToken()); // M개의 선
		board = new int[M+1][2]; // 연결 상태를 담은 2차원 배열
		
		for(int i=1;i<=M;i++) {
			st = new StringTokenizer(br.readLine());
			board[i][0] = Integer.parseInt(st.nextToken());
			board[i][1] = Integer.parseInt(st.nextToken());
		} // 연결 상태를 담은 2차원 배열 초기화
		
		visited = new boolean[N+1]; // visited

		for(int i=1;i<=N;i++) {
			if(visited[i] == false) {
				makeConnection(i, visited);
				answer++;
			//새로운 미방문 점 => 새로운 연결
			//새로운 연결이 있을 때마다 해당 지점을 시작으로 maekConnection 후 answer++
			}
		}
		System.out.println(answer);
	}
	
	static void makeConnection(int n, boolean[] visited) {
		Queue<Integer> q = new LinkedList<>(); // 이동해야할 지점 큐
		q.add(n); // 시작점을 큐에 넣음
		while(!q.isEmpty()) { //더 갈수있는 곳이 없을 때까지
			int start = q.poll(); // start에서 시작
			if(visited[start] == false) {
				visited[start] = true;
				for(int i=1;i<=M;i++) {
					if(board[i][0] == start && visited[board[i][1]] != true) {
						q.add(board[i][1]);
					}else if(board[i][1] == start && visited[board[i][0]] != true) {
						q.add(board[i][0]);
					}
				}
			}
		}
	}
}